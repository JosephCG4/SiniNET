package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.CentroDeSaludDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

public class CentroDeSaludDAOImpl extends DAOImplBase implements CentroDeSaludDAO {

    private CentrosDeSaludDTO centroDeSalud;

    public CentroDeSaludDAOImpl() {
        super("GS_CENTRO_DE_SALUD");
        this.centroDeSalud = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CENTRO_DE_SALUD_ID", true, true));
        this.listaColumnas.add(new Columna("CODIGO_RENIPRESS", false, false));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
	this.listaColumnas.add(new Columna("UBICACION_ID", false, false));
	this.listaColumnas.add(new Columna("TELEFONO", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.centroDeSalud.getCodigoRenipress());
        this.statement.setString(2, this.centroDeSalud.getNombre());
	this.statement.setInt(3, this.centroDeSalud.getUbicacion().getUbicacionId());
        this.statement.setString(4, this.centroDeSalud.getTelefono());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.centroDeSalud.getCodigoRenipress());
        this.statement.setString(2, this.centroDeSalud.getNombre());
	this.statement.setInt(3, this.centroDeSalud.getUbicacion().getUbicacionId());
        this.statement.setString(4, this.centroDeSalud.getTelefono());
	this.statement.setInt(5, this.centroDeSalud.getCentroDeSaludId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.centroDeSalud.getCentroDeSaludId());
    }

    @Override
    public Integer insertar(CentrosDeSaludDTO centroDeSalud) {
        this.centroDeSalud = centroDeSalud;
        return super.insertar();
    }

    @Override
    public Integer modificar(CentrosDeSaludDTO centroDeSalud) {
        this.centroDeSalud = centroDeSalud;
        return super.modificar();
    }

    @Override
    public Integer eliminar(CentrosDeSaludDTO centroDeSalud) {
        this.centroDeSalud = centroDeSalud;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.centroDeSalud.getCentroDeSaludId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.centroDeSalud = new CentrosDeSaludDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        this.centroDeSalud.setCentroDeSaludId(this.resultSet.getInt("CENTRO_DE_SALUD_ID"));
        this.centroDeSalud.setCodigoRenipress(this.resultSet.getString("CODIGO_RENIPRESS"));
        this.centroDeSalud.setNombre(this.resultSet.getString("NOMBRE"));
        this.centroDeSalud.setTelefono(this.resultSet.getString("TELEFONO"));
        this.centroDeSalud.setUbicacion(ubicacion);
        this.centroDeSalud.getUbicacion().setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.centroDeSalud = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.centroDeSalud);
    }

    @Override
    public CentrosDeSaludDTO obtenerPorId(Integer centroDeSaludID) {
        CentrosDeSaludDTO centroDeSaludDTO = new CentrosDeSaludDTO();
        centroDeSaludDTO.setCentroDeSaludId(centroDeSaludID);
        this.centroDeSalud = centroDeSaludDTO;
        super.obtenerPorId();
        return this.centroDeSalud;
    }
    
    @Override
    public ArrayList<CentrosDeSaludDTO> listarTodos() {
        return (ArrayList<CentrosDeSaludDTO>) super.listarTodos();
    }
    
    @Override
    public ArrayList<CentrosDeSaludDTO> listarPorNombreCodigoRENIPRESS(String filtro){
        
        String sql = "SELECT cs.CENTRO_DE_SALUD_ID, cs.CODIGO_RENIPRESS, cs.NOMBRE, u.UBICACION_ID, u.DIRECCION, u.REFERENCIA, u.LATITUD, u.LONGITUD, cs.TELEFONO "
                + "FROM GS_CENTRO_DE_SALUD as cs JOIN GS_UBICACION as u ON cs.UBICACION_ID = u.UBICACION_ID "
                +"WHERE (cs.NOMBRE LIKE ? OR cs.CODIGO_RENIPRESS LIKE ?);";
        return (ArrayList<CentrosDeSaludDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombreCodigoRENIPRESS, filtro);   
    }
    
    private void incluirValorDeParametrosParaListarPorNombreCodigoRENIPRESS(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
            this.statement.setString(2, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
