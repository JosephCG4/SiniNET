package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.TallerDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

public class TallerDAOImpl extends DAOImplBase implements TallerDAO {

    private TalleresDTO taller;

    public TallerDAOImpl() {
        super("GS_TALLER");
        this.taller = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("TALLER_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("UBICACION_ID", false, false));
        this.listaColumnas.add(new Columna("TELEFONO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.taller.getNombre());
        this.statement.setInt(2, this.taller.getUbicacion().getUbicacionId());
        this.statement.setString(3, this.taller.getTelefono());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.taller.getNombre());
        this.statement.setInt(2, this.taller.getUbicacion().getUbicacionId());
        this.statement.setString(3, this.taller.getTelefono());
        this.statement.setInt(4, this.taller.getTallerId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.taller.getTallerId());
    }

    @Override
    public Integer insertar(TalleresDTO taller) {
        this.taller = taller;
        return super.insertar();
    }

    @Override
    public Integer modificar(TalleresDTO taller) {
        this.taller = taller;
        return super.modificar();
    }

    @Override
    public Integer eliminar(TalleresDTO taller) {
        this.taller = taller;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.taller.getTallerId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.taller = new TalleresDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        this.taller.setTallerId(this.resultSet.getInt("TALLER_ID"));
        this.taller.setNombre(this.resultSet.getString("NOMBRE"));
        this.taller.setTelefono(this.resultSet.getString("TELEFONO"));
        this.taller.setUbicacion(ubicacion);
        this.taller.getUbicacion().setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.taller = null;
    }    
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.taller);
    }

    @Override
    public TalleresDTO obtenerPorId(Integer tallerId) {
        TalleresDTO tallerDTO = new TalleresDTO();
        tallerDTO.setTallerId(tallerId);
        this.taller = tallerDTO;
        super.obtenerPorId();
        return this.taller;
    }
    
    @Override
    public ArrayList<TalleresDTO> listarTodos() {
        return (ArrayList<TalleresDTO>) super.listarTodos();
    }

    @Override
    public ArrayList<TalleresDTO> listarPorNombre(String nombre) {
        String sql = """
                     SELECT TALLER_ID, NOMBRE, UBICACION_ID, TELEFONO
                         FROM GS_TALLER  WHERE NOMBRE LIKE ?;""";
        return (ArrayList<TalleresDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombre, nombre);
    }
    
    private void incluirValorDeParametrosParaListarPorNombre(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
