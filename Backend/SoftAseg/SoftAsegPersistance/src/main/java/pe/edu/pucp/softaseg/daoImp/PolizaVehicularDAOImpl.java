package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.util.TipoPolizaVehicular;
import pe.edu.pucp.softaseg.dao.PolizaVehicularDAO;

public class PolizaVehicularDAOImpl extends DAOImplBase implements PolizaVehicularDAO{
    private PolizasVehicularesDTO polizasVehiculares;
    private Integer centinelaListar;

    public PolizaVehicularDAOImpl() {
        super("GS_POLIZA_VEHICULAR");
        this.polizasVehiculares = null;
        this.retornarLlavePrimaria = true;
        this.centinelaListar = 0;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("POLIZA_ID", true, true));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("ESTADO", false, false));
	this.listaColumnas.add(new Columna("TIPO", false, false));
	this.listaColumnas.add(new Columna("PORCENTAJE_COBERTURA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.polizasVehiculares.getAsegurado().getPersonalId());
        this.statement.setString(2, this.polizasVehiculares.getEstado().name());
        this.statement.setString(3, this.polizasVehiculares.getTipo().name());
        this.statement.setInt(4, this.polizasVehiculares.getPorcentajeCobertura());
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.polizasVehiculares.getAsegurado().getPersonalId());
        this.statement.setString(2, this.polizasVehiculares.getEstado().name());
        this.statement.setString(3, this.polizasVehiculares.getTipo().name());
        this.statement.setInt(4, this.polizasVehiculares.getPorcentajeCobertura());
	this.statement.setInt(5, this.polizasVehiculares.getPolizaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.polizasVehiculares.getPolizaId());
    }

    @Override
    public Integer insertar(PolizasVehicularesDTO polizasVehiculares) {
        this.polizasVehiculares=polizasVehiculares;
        return super.insertar();
    }

    @Override
    public Integer modificar(PolizasVehicularesDTO polizasVehiculares) {
        this.polizasVehiculares = polizasVehiculares;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PolizasVehicularesDTO polizasVehiculares) {
        this.polizasVehiculares = polizasVehiculares;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.polizasVehiculares.getPolizaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.polizasVehiculares = new PolizasVehicularesDTO();
        PersonasDTO persona = new PersonasDTO();
        this.polizasVehiculares.setPolizaId(this.resultSet.getInt("POLIZA_ID"));
        this.polizasVehiculares.setAsegurado(persona);
        this.polizasVehiculares.getAsegurado().setPersonalId(this.resultSet.getInt("PERSONA_ID"));
        this.polizasVehiculares.setEstado(EstadoPoliza.valueOf(this.resultSet.getString("ESTADO")));
        this.polizasVehiculares.setTipo(TipoPolizaVehicular.valueOf(this.resultSet.getString("TIPO")));
        this.polizasVehiculares.setPorcentajeCobertura(this.resultSet.getInt("PORCENTAJE_COBERTURA"));
        if(centinelaListar == 1){
            this.polizasVehiculares.getAsegurado().setDni(this.resultSet.getString("DNI"));
            this.polizasVehiculares.getAsegurado().setNombres(this.resultSet.getString("NOMBRES"));
            this.polizasVehiculares.getAsegurado().setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
            this.polizasVehiculares.getAsegurado().setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
            this.polizasVehiculares.getAsegurado().setTelefono(this.resultSet.getString("TELEFONO"));
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.polizasVehiculares = null;
    }    

    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.polizasVehiculares);
    }
    
    @Override
    public ArrayList<PolizasVehicularesDTO> listarTodos() {
        this.centinelaListar = 0;
        return (ArrayList<PolizasVehicularesDTO>) super.listarTodos();
    }
    
    @Override
    public PolizasVehicularesDTO obtenerPorId(Integer polizasVehicularesID) {
        PolizasVehicularesDTO polizasVehicularesDTO = new PolizasVehicularesDTO();
        polizasVehicularesDTO.setPolizaId(polizasVehicularesID);
        this.polizasVehiculares = polizasVehicularesDTO;
        super.obtenerPorId();
        return this.polizasVehiculares;
    }

    @Override
    public ArrayList<PolizasVehicularesDTO> listarPorNombreApellidoAsegurado(String filtro) {
        this.centinelaListar = 1;
        String sql = """
                     SELECT po.POLIZA_ID, po.PERSONA_ID, po.ESTADO, po.TIPO, po.PORCENTAJE_COBERTURA, 
                        pe.DNI, pe.NOMBRES, pe.APELLIDO_PATERNO, pe.APELLIDO_MATERNO, pe.TELEFONO
                         FROM GS_POLIZA_VEHICULAR as po JOIN GU_PERSONA as pe ON pe.PERSONA_ID = po.PERSONA_ID
                                      WHERE pe.NOMBRES LIKE ? OR pe.APELLIDO_PATERNO LIKE ? OR pe.APELLIDO_MATERNO LIKE ?;""";
        return (ArrayList<PolizasVehicularesDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombreApellidoAsegurado, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorNombreApellidoAsegurado(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
            this.statement.setString(2, cadena);
            this.statement.setString(3, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
