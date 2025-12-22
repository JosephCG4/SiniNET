
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softaseg.dao.AdministradorDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

public class AdministradorDAOImpl extends DAOImplBase implements AdministradorDAO{
    
    private AdministradoresDTO administrador;

    public AdministradorDAOImpl() {
        super("GU_ADMINISTRADOR");
        this.administrador = null;
        this.retornarLlavePrimaria = false;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ADMINISTRADOR_ID", true, false));
	this.listaColumnas.add(new Columna("LLAVE_MAESTRA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.administrador.getPersonalId());
	this.statement.setString(2, this.administrador.getLlaveMaestra());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
	this.statement.setString(1, this.administrador.getLlaveMaestra());
	this.statement.setInt(2, this.administrador.getPersonalId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.administrador.getPersonalId());
    }

    @Override
    public Integer insertar(AdministradoresDTO administrador) {
        this.administrador = administrador;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(AdministradoresDTO administrador) {
        this.administrador = administrador;
        return super.modificar();
    }

    @Override
    public Integer eliminar(AdministradoresDTO administrador) {
        this.administrador = administrador;
        return super.eliminar();
    }


    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.administrador.getPersonalId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.administrador = new AdministradoresDTO();
        this.administrador.setPersonalId(this.resultSet.getInt("ADMINISTRADOR_ID"));
        this.administrador.setDni(this.resultSet.getString("DNI"));
	this.administrador.setNombres(this.resultSet.getString("NOMBRES"));
	this.administrador.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
	this.administrador.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
	this.administrador.setTelefono(this.resultSet.getString("TELEFONO"));
        this.administrador.setNombreUsuario(this.resultSet.getString("NOMBRE_USUARIO"));
        this.administrador.setContrasenia(this.resultSet.getString("CONTRASENHA"));
        this.administrador.setCorreo(this.resultSet.getString("CORREO"));
        this.administrador.setEstado(EstadoUsuario.valueOf(this.resultSet.getString("ESTADO")));
        this.administrador.setLlaveMaestra(this.resultSet.getString("LLAVE_MAESTRA"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.administrador = null;
    }  
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.administrador);
    }
    
    @Override
    public AdministradoresDTO obtenerPorId(Integer empleadoId) {
        AdministradoresDTO AdministradorDTO = new AdministradoresDTO();
        AdministradorDTO.setPersonalId(empleadoId);
        this.administrador = AdministradorDTO;
        String sql = "SELECT a.ADMINISTRADOR_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, a.LLAVE_MAESTRA"
                + "  FROM GU_ADMINISTRADOR as a JOIN GU_USUARIO as u ON a.ADMINISTRADOR_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON p.PERSONA_ID = a.ADMINISTRADOR_ID WHERE a.ADMINISTRADOR_ID = ?";
        super.obtenerPorId(sql);
        return this.administrador;
    }
    
    @Override
    public ArrayList<AdministradoresDTO> listarTodos() {        
        String sql = "SELECT a.ADMINISTRADOR_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, u.NOMBRE_USUARIO, u.CONTRASENHA, u.CORREO, u.ESTADO, a.LLAVE_MAESTRA"
                + "  FROM GU_ADMINISTRADOR as a JOIN GU_USUARIO as u ON a.ADMINISTRADOR_ID = u.USUARIO_ID JOIN GU_PERSONA as p ON p.PERSONA_ID = a.ADMINISTRADOR_ID";
        return (ArrayList<AdministradoresDTO>) super.listarTodos(sql);
    }
}
