package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.EmpleadoDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.util.DesempenhoEmpleado;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;
import pe.edu.pucp.softaseg.model.util.TipoEmpleado;

public class EmpleadoDAOImpl extends DAOImplBase implements EmpleadoDAO {

    private EmpleadosDTO empleado;

    public EmpleadoDAOImpl() {
        super("GU_EMPLEADO");
        this.empleado = null;
        this.retornarLlavePrimaria = false;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("EMPLEADO_ID", true, false));
	this.listaColumnas.add(new Columna("DESEMPENHO", false, false));
	this.listaColumnas.add(new Columna("TIPO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.empleado.getPersonalId());
	this.statement.setString(2, this.empleado.getDesempenio().name());
	this.statement.setString(3, this.empleado.getTipo().name());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
	this.statement.setString(1, this.empleado.getDesempenio().name());
	this.statement.setString(2, this.empleado.getTipo().name());
	this.statement.setInt(3, this.empleado.getPersonalId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.empleado.getPersonalId());
    }

    @Override
    public Integer insertar(EmpleadosDTO empleado) {
        this.empleado = empleado;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(EmpleadosDTO empleado) {
        this.empleado = empleado;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EmpleadosDTO empleado) {
        this.empleado = empleado;
        return super.eliminar();
    }


    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.empleado.getPersonalId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.empleado = new EmpleadosDTO();
        this.empleado.setPersonalId(this.resultSet.getInt("EMPLEADO_ID"));
        this.empleado.setDni(this.resultSet.getString("DNI"));
	this.empleado.setNombres(this.resultSet.getString("NOMBRES"));
	this.empleado.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
	this.empleado.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
	this.empleado.setTelefono(this.resultSet.getString("TELEFONO"));
        this.empleado.setNombreUsuario(this.resultSet.getString("NOMBRE_USUARIO"));
        this.empleado.setContrasenia(this.resultSet.getString("CONTRASENHA"));
        this.empleado.setCorreo(this.resultSet.getString("CORREO"));
        this.empleado.setEstado(EstadoUsuario.valueOf(this.resultSet.getString("ESTADO")));
        this.empleado.setDesempenio(DesempenhoEmpleado.valueOf(this.resultSet.getString("DESEMPENHO")));
        this.empleado.setTipo(TipoEmpleado.valueOf(this.resultSet.getString("TIPO")));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.empleado = null;
    }  
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.empleado);
    }
    
    @Override
    public EmpleadosDTO obtenerPorId(Integer empleadoId) {
        EmpleadosDTO empleadoDTO = new EmpleadosDTO();
        empleadoDTO.setPersonalId(empleadoId);
        this.empleado = empleadoDTO;
        String sql = "SELECT e.EMPLEADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, e.DESEMPENHO, e.TIPO"
                + "  FROM GU_EMPLEADO as e JOIN GU_USUARIO as u ON e.EMPLEADO_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON e.EMPLEADO_ID = p.PERSONA_ID WHERE e.EMPLEADO_ID = ?";
        super.obtenerPorId(sql);
        return this.empleado;
    }
    
    @Override
    public ArrayList<EmpleadosDTO> listarTodos() {        
        String sql = "SELECT e.EMPLEADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, e.DESEMPENHO, e.TIPO"
                + "  FROM GU_EMPLEADO as e JOIN GU_USUARIO as u ON e.EMPLEADO_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON e.EMPLEADO_ID = p.PERSONA_ID";
        return (ArrayList<EmpleadosDTO>) super.listarTodos(sql);
    }

    @Override
    public ArrayList<EmpleadosDTO> listarPorNombreApellidoPaternoTipoEmpleado(String filtro) {
        String sql = "SELECT e.EMPLEADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, e.DESEMPENHO, e.TIPO"
                + "  FROM GU_EMPLEADO as e JOIN GU_USUARIO as u ON e.EMPLEADO_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON e.EMPLEADO_ID = p.PERSONA_ID"
                +" WHERE (p.NOMBRES LIKE ? OR p.APELLIDO_PATERNO LIKE ? OR e.TIPO LIKE ?);";
        return (ArrayList<EmpleadosDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombreApellidoPaternoTipoEmpleado, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorNombreApellidoPaternoTipoEmpleado(Object objetoParametros) {
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
    private void incluirValorDeParametrosParaListarProcuradores(Object objetoParametros) {
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

    @Override
    public ArrayList<EmpleadosDTO> listarProcuradores(String filtro) {
        String sql = "SELECT e.EMPLEADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, e.DESEMPENHO, e.TIPO"
                + "  FROM GU_EMPLEADO as e JOIN GU_USUARIO as u ON e.EMPLEADO_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON e.EMPLEADO_ID = p.PERSONA_ID"
                +" WHERE (p.NOMBRES LIKE ? OR p.APELLIDO_PATERNO LIKE ?) AND e.TIPO = 'PROCURADOR';";
        return (ArrayList<EmpleadosDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarProcuradores, filtro);
    }
}
