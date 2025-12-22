
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.SiniestroDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;

public class SiniestroDAOImpl extends DAOImplBase implements SiniestroDAO{
    
    private SiniestrosDTO siniestro;

    public SiniestroDAOImpl() {
        super("GS_SINIESTRO");
        this.siniestro = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("SINIESTRO_ID", true, true));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("FECHA_Y_HORA", false, false));
	this.listaColumnas.add(new Columna("ESTADO", false, false));
	this.listaColumnas.add(new Columna("CALIFICACION_SERVICIO", false, false));
        this.listaColumnas.add(new Columna("UBICACION_ID", false, false));
        this.listaColumnas.add(new Columna("PROCURADOR_ID", false, false));
        this.listaColumnas.add(new Columna("VALIDEZ", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.siniestro.getDescripcion());
        this.statement.setTimestamp(2, Timestamp.valueOf(this.siniestro.getFechaHora()));
	this.statement.setString(3, this.siniestro.getEstado().toString());
	this.statement.setInt(4, this.siniestro.getCalificacionServicio());
        this.statement.setInt(5, this.siniestro.getUbicacion().getUbicacionId());
        this.statement.setInt(6, this.siniestro.getProcurador().getPersonalId());
        this.statement.setBoolean(7, this.siniestro.getValidez());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.siniestro.getDescripcion());
        this.statement.setTimestamp(2, Timestamp.valueOf(this.siniestro.getFechaHora()));
	this.statement.setString(3, this.siniestro.getEstado().toString());
	this.statement.setInt(4, this.siniestro.getCalificacionServicio());
        this.statement.setInt(5, this.siniestro.getUbicacion().getUbicacionId());
        this.statement.setInt(6, this.siniestro.getProcurador().getPersonalId());
        this.statement.setBoolean(7, this.siniestro.getValidez());
        this.statement.setInt(8, this.siniestro.getSiniestroId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.siniestro.getSiniestroId());
    }

    @Override
    public Integer insertar(SiniestrosDTO siniestro) {
        this.siniestro = siniestro;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(SiniestrosDTO siniestro) {
        this.siniestro = siniestro;
        return super.modificar();
    }

    @Override
    public Integer eliminar(SiniestrosDTO siniestro) {
        this.siniestro = siniestro;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.siniestro.getSiniestroId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.siniestro = new SiniestrosDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        EmpleadosDTO procurador = new EmpleadosDTO();
        this.siniestro.setSiniestroId(this.resultSet.getInt("SINIESTRO_ID"));
        this.siniestro.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.siniestro.setFechaHora(this.resultSet.getTimestamp("FECHA_Y_HORA").toLocalDateTime());
        this.siniestro.setEstado(EstadoSiniestro.valueOf(this.resultSet.getString("ESTADO")));
        this.siniestro.setCalificacionServicio(this.resultSet.getInt("CALIFICACION_SERVICIO"));
        this.siniestro.setUbicacion(ubicacion);
        this.siniestro.getUbicacion().setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
        this.siniestro.setProcurador(procurador);
        this.siniestro.getProcurador().setPersonalId(this.resultSet.getInt("PROCURADOR_ID"));
        this.siniestro.setValidez(this.resultSet.getBoolean("VALIDEZ"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.siniestro = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.siniestro);
    }

    @Override
    public SiniestrosDTO obtenerPorId(Integer siniestroId) {
        SiniestrosDTO siniestroDTO = new SiniestrosDTO();
        siniestroDTO.setSiniestroId(siniestroId);
        this.siniestro = siniestroDTO;
        super.obtenerPorId();
        return this.siniestro;
    }
    
    @Override
    public ArrayList<SiniestrosDTO> listarTodos() {
        return (ArrayList<SiniestrosDTO>) super.listarTodos();
    }

    @Override
    public ArrayList<SiniestrosDTO> listarPorEmpleado(String filtro) {
        String sql = "SELECT s.SINIESTRO_ID, s.DESCRIPCION, s.FECHA_Y_HORA, s.ESTADO, s.CALIFICACION_SERVICIO, s.UBICACION_ID, s.PROCURADOR_ID, s.VALIDEZ"
                + " FROM GS_SINIESTRO as s JOIN GU_EMPLEADO as e ON e.EMPLEADO_ID = s.PROCURADOR_ID JOIN GU_PERSONA as p ON e.EMPLEADO_ID = p.PERSONA_ID"
                +" WHERE (p.NOMBRES LIKE ? OR p.APELLIDO_PATERNO LIKE ?) ORDER BY s.FECHA_Y_HORA DESC;";
         
        return (ArrayList<SiniestrosDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorEmpleado, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorEmpleado(Object objetoParametros) {
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
