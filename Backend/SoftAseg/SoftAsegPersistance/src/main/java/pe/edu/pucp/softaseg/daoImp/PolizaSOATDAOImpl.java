package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.PolizaSOATDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;

public class PolizaSOATDAOImpl extends DAOImplBase implements PolizaSOATDAO{
    private PolizasSOATDTO polizasSOAT;
    private Integer centinelaListar;

    public PolizaSOATDAOImpl() {
        super("GS_POLIZA_SOAT");
        this.polizasSOAT = null;
        this.retornarLlavePrimaria = true;
        this.centinelaListar = 0;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("POLIZA_SOAT_ID", true, true));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("ESTADO", false, false));
	this.listaColumnas.add(new Columna("MONTO_A_COBERTURA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.polizasSOAT.getAsegurado().getPersonalId());
        this.statement.setString(2, this.polizasSOAT.getEstado().name());
        this.statement.setInt(3, this.polizasSOAT.getMontoACobertura());

    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.polizasSOAT.getAsegurado().getPersonalId());
        this.statement.setString(2, this.polizasSOAT.getEstado().name());
        this.statement.setInt(3, this.polizasSOAT.getMontoACobertura());
	this.statement.setInt(4, this.polizasSOAT.getPolizaId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.polizasSOAT.getPolizaId());
    }

    @Override
    public Integer insertar(PolizasSOATDTO polizasSOAT) {
        this.polizasSOAT=polizasSOAT;
        return super.insertar();
    }

    @Override
    public Integer modificar(PolizasSOATDTO polizasSOAT) {
        this.polizasSOAT = polizasSOAT;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PolizasSOATDTO polizasSOAT) {
        this.polizasSOAT = polizasSOAT;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.polizasSOAT.getPolizaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.polizasSOAT = new PolizasSOATDTO();
        PersonasDTO persona = new PersonasDTO();
        this.polizasSOAT.setPolizaId(this.resultSet.getInt("POLIZA_SOAT_ID"));
        this.polizasSOAT.setAsegurado(persona);
        this.polizasSOAT.getAsegurado().setPersonalId(this.resultSet.getInt("PERSONA_ID"));
        this.polizasSOAT.setEstado(EstadoPoliza.valueOf(this.resultSet.getString("ESTADO")));
        this.polizasSOAT.setMontoACobertura(this.resultSet.getInt("MONTO_A_COBERTURA"));
        if(centinelaListar == 1){
            this.polizasSOAT.getAsegurado().setDni(this.resultSet.getString("DNI"));
            this.polizasSOAT.getAsegurado().setNombres(this.resultSet.getString("NOMBRES"));
            this.polizasSOAT.getAsegurado().setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
            this.polizasSOAT.getAsegurado().setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
            this.polizasSOAT.getAsegurado().setTelefono(this.resultSet.getString("TELEFONO"));
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.polizasSOAT = null;
    }    

    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.polizasSOAT);
    }
    
    @Override
    public ArrayList<PolizasSOATDTO> listarTodos() {
        this.centinelaListar=0;
        return (ArrayList<PolizasSOATDTO>) super.listarTodos();
    }
    
    @Override
    public PolizasSOATDTO obtenerPorId(Integer polizasSOATID) {
        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();
        polizasSOATDTO.setPolizaId(polizasSOATID);
        this.polizasSOAT = polizasSOATDTO;
        super.obtenerPorId();
        return this.polizasSOAT;
    }

    @Override
    public ArrayList<PolizasSOATDTO> listarPorNombreApellidoAsegurado(String filtro) {
        this.centinelaListar = 1;
        String sql = """
                     SELECT po.POLIZA_SOAT_ID, po.PERSONA_ID, po.ESTADO, po.MONTO_A_COBERTURA, 
                        pe.DNI, pe.NOMBRES, pe.APELLIDO_PATERNO, pe.APELLIDO_MATERNO, pe.TELEFONO
                         FROM GS_POLIZA_SOAT as po JOIN GU_PERSONA as pe ON pe.PERSONA_ID = po.PERSONA_ID
                                      WHERE pe.NOMBRES LIKE ? OR pe.APELLIDO_PATERNO LIKE ? OR pe.APELLIDO_MATERNO LIKE ?;""";
        return (ArrayList<PolizasSOATDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombreApellidoAsegurado, filtro);
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
