
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

//public class UsuarioDAOTest {
//    
//    private UsuarioDAO usuarioDAO;
//
//    public UsuarioDAOTest() {
//        this.usuarioDAO = new UsuarioDAOImpl();
//    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaUsuarioId = new ArrayList<>();
//        insertarUsuarios(listaUsuarioId);
//        eliminarTodo();
//    }
//
//    private void insertarUsuarios(ArrayList<Integer> listaUsuarioId) {
//        UsuariosDTO usuario = new UsuariosDTO();
//        usuario.setPersonalId(7);
//        usuario.setNombreUsuario("NombreUsuario1");
//        usuario.setContrasenia("contrasenha1");
//        usuario.setCorreo("correo1");
//        usuario.setEstado(EstadoUsuario.ACTIVO);
//        Integer resultado = this.usuarioDAO.insertar(usuario);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(7);
//
//        usuario.setPersonalId(8);
//        usuario.setNombreUsuario("NombreUsuario2");
//        usuario.setContrasenia("contrasenha2");
//        usuario.setCorreo("correo2");
//        usuario.setEstado(EstadoUsuario.ACTIVO);
//        resultado = this.usuarioDAO.insertar(usuario);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(8);
//
//        usuario.setPersonalId(9);
//        usuario.setNombreUsuario("NombreUsuario3");
//        usuario.setContrasenia("contrasenha3");
//        usuario.setCorreo("correo3");
//        usuario.setEstado(EstadoUsuario.ACTIVO);
//        resultado = this.usuarioDAO.insertar(usuario);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(9);      
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaUsuarioId = new ArrayList<>();
//        insertarUsuarios(listaUsuarioId);
//        UsuariosDTO usuario = this.usuarioDAO.obtenerPorId(listaUsuarioId.get(0));
//        assertEquals(usuario.getPersonalId(), listaUsuarioId.get(0));
//
//        usuario = this.usuarioDAO.obtenerPorId(listaUsuarioId.get(1));
//        assertEquals(usuario.getPersonalId(), listaUsuarioId.get(1));
//
//        usuario = this.usuarioDAO.obtenerPorId(listaUsuarioId.get(2));
//        assertEquals(usuario.getPersonalId(), listaUsuarioId.get(2));
//        eliminarTodo();
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaUsuarioId = new ArrayList<>();
//        insertarUsuarios(listaUsuarioId);
//
//        ArrayList<UsuariosDTO> listaUsuarios = this.usuarioDAO.listarTodos();
//        assertEquals(listaUsuarioId.size()+6, listaUsuarios.size());
//        for (Integer i = 0; i < listaUsuarios.size(); i++) {
//            if(listaUsuarios.get(i).getPersonalId()>6){
//                assertEquals(listaUsuarioId.get(i-6), listaUsuarios.get(i).getPersonalId());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaUsuarioId = new ArrayList<>();
//        insertarUsuarios(listaUsuarioId);
//
//        ArrayList<UsuariosDTO> listaUsuarios = this.usuarioDAO.listarTodos();
//        assertEquals(listaUsuarioId.size()+6, listaUsuarios.size());
//        for (Integer i = 0; i < listaUsuarios.size(); i++) {
//            if(listaUsuarios.get(i).getPersonalId()>6){
//                listaUsuarios.get(i).setNombreUsuario("NombreModificado");
//                listaUsuarios.get(i).setContrasenia("Contramodificada");
//                listaUsuarios.get(i).setCorreo("Correomodificado");
//                listaUsuarios.get(i).setEstado(EstadoUsuario.INACTIVO);
//                this.usuarioDAO.modificar(listaUsuarios.get(i));
//            }
//        }
//
//        ArrayList<UsuariosDTO> listaUsuariosModificados = this.usuarioDAO.listarTodos();
//        assertEquals(listaUsuarios.size(), listaUsuariosModificados.size());
//        for (Integer i = 0; i < listaUsuarios.size(); i++) {
//            if(listaUsuarios.get(i).getPersonalId()>6){
//                assertEquals(listaUsuarios.get(i).getNombreUsuario(), listaUsuariosModificados.get(i).getNombreUsuario());
//                assertEquals(listaUsuarios.get(i).getContrasenia(), listaUsuariosModificados.get(i).getContrasenia());
//                assertEquals(listaUsuarios.get(i).getCorreo(), listaUsuariosModificados.get(i).getCorreo());
//                assertEquals(listaUsuarios.get(i).getEstado(), listaUsuariosModificados.get(i).getEstado());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaUsuarioId = new ArrayList<>();
//        insertarUsuarios(listaUsuarioId);
//        eliminarTodo();
//    }
//
//    private void eliminarTodo(){                
//        ArrayList<UsuariosDTO> listaUsuarios = this.usuarioDAO.listarTodos();
//        for (Integer i = 0; i < listaUsuarios.size(); i++) {
//            if(listaUsuarios.get(i).getPersonalId()>6){
//                Integer resultado = this.usuarioDAO.eliminar(listaUsuarios.get(i));
//                assertNotEquals(0, resultado);
//                UsuariosDTO usuario = this.usuarioDAO.obtenerPorId(listaUsuarios.get(i).getPersonalId());
//                assertNull(usuario);
//            }
//        }
//    }
//}
