
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softaseg.dao.UsuarioDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;


public class UsuarioDAOImpl extends DAOImplBase implements UsuarioDAO{
    
    private UsuariosDTO usuario;

    public UsuarioDAOImpl() {
        super("GU_USUARIO");
        this.usuario = null;
        this.retornarLlavePrimaria = false;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("USUARIO_ID", true, false));
        this.listaColumnas.add(new Columna("NOMBRE_USUARIO", false, false));
        this.listaColumnas.add(new Columna("CONTRASENHA", false, false));
	this.listaColumnas.add(new Columna("CORREO", false, false));
	this.listaColumnas.add(new Columna("ESTADO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.usuario.getPersonalId());
        this.statement.setString(2, this.usuario.getNombreUsuario());
        this.statement.setString(3, this.usuario.getContrasenia());
	this.statement.setString(4, this.usuario.getCorreo());
	this.statement.setString(5, this.usuario.getEstado().toString());	
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.usuario.getNombreUsuario());
        this.statement.setString(2, this.usuario.getContrasenia());
	this.statement.setString(3, this.usuario.getCorreo());
	this.statement.setString(4, this.usuario.getEstado().toString());
	this.statement.setInt(5, this.usuario.getPersonalId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.usuario.getPersonalId());
    }

    @Override
    public Integer insertar(UsuariosDTO usuario) {
        this.usuario = usuario;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(UsuariosDTO usuario) {
        this.usuario = usuario;
        return super.modificar();
    }

    @Override
    public Integer eliminar(UsuariosDTO usuario) {
        this.usuario = usuario;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.usuario.getPersonalId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.usuario = new UsuariosDTO();
        this.usuario.setPersonalId(this.resultSet.getInt("USUARIO_ID"));
        this.usuario.setNombreUsuario(this.resultSet.getString("NOMBRE_USUARIO"));
        this.usuario.setContrasenia(this.resultSet.getString("CONTRASENHA"));
        this.usuario.setCorreo(this.resultSet.getString("CORREO"));
        this.usuario.setEstado(EstadoUsuario.valueOf(this.resultSet.getString("ESTADO")));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.usuario = null;
    }  
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.usuario);
    }
    
    @Override
    public UsuariosDTO obtenerPorId(Integer usuarioId) {
        UsuariosDTO usuarioDTO = new UsuariosDTO();
        usuarioDTO.setPersonalId(usuarioId);
        this.usuario = usuarioDTO;
        super.obtenerPorId();
        return this.usuario;
    }
    
    @Override
    public ArrayList<UsuariosDTO> listarTodos() {
        return (ArrayList<UsuariosDTO>) super.listarTodos();
    }
    
}
