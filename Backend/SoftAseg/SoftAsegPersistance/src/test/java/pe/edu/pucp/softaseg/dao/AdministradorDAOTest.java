
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.AdministradorDAOImpl;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;

//public class AdministradorDAOTest {
//    
//    private AdministradorDAO administradorDAO;
//    private UsuarioDAO usuarioDAO;
//    private PersonaDAO personaDAO;
//    
//    public AdministradorDAOTest() {
//        this.administradorDAO = new AdministradorDAOImpl();
//        this.usuarioDAO = new UsuarioDAOImpl();
//        this.personaDAO = new PersonaDAOImpl();
//    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaAdministradorId = new ArrayList<>();
//        insertarAdministradores(listaAdministradorId);
//        eliminarTodo();
//    }
//    
//    private void insertarAdministradores(ArrayList<Integer> listaUsuarioId) {
//        AdministradoresDTO administrador = new AdministradoresDTO();
//        administrador.setPersonalId(1);
//        administrador.setLlaveMaestra("1234");
//        Integer resultado = this.administradorDAO.insertar(administrador);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(1);
//
//        administrador.setPersonalId(2);
//        administrador.setLlaveMaestra("1234");
//        resultado = this.administradorDAO.insertar(administrador);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(2);
//
//        administrador.setPersonalId(3);
//        administrador.setLlaveMaestra("1234");
//        resultado = this.administradorDAO.insertar(administrador);
//        assertTrue(resultado != 0);
//        listaUsuarioId.add(3);     
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaAdministradorId = new ArrayList<>();
//        insertarAdministradores(listaAdministradorId);
//        AdministradoresDTO administrador = this.administradorDAO.obtenerPorId(listaAdministradorId.get(0));
//        assertEquals(administrador.getPersonalId(), listaAdministradorId.get(0));
//
//        administrador = this.administradorDAO.obtenerPorId(listaAdministradorId.get(1));
//        assertEquals(administrador.getPersonalId(), listaAdministradorId.get(1));
//
//        administrador = this.administradorDAO.obtenerPorId(listaAdministradorId.get(2));
//        assertEquals(administrador.getPersonalId(), listaAdministradorId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaAdministradorId = new ArrayList<>();
//        insertarAdministradores(listaAdministradorId);
//
//        ArrayList<AdministradoresDTO> listaAdministradores = this.administradorDAO.listarTodos();
//        assertEquals(listaAdministradorId.size(), listaAdministradores.size());
//        for (Integer i = 0; i < listaAdministradores.size(); i++) {
//                listaAdministradores.get(i).setLlaveMaestra("9999");
//                this.administradorDAO.modificar(listaAdministradores.get(i));
//        }
//
//        ArrayList<AdministradoresDTO> listaAdministradoresModificados = this.administradorDAO.listarTodos();
//        assertEquals(listaAdministradores.size(), listaAdministradoresModificados.size());
//        for (Integer i = 0; i < listaAdministradores.size(); i++) {
//                assertEquals(listaAdministradores.get(i).getLlaveMaestra(), listaAdministradoresModificados.get(i).getLlaveMaestra());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaAdministradorId = new ArrayList<>();
//        insertarAdministradores(listaAdministradorId);
//
//        ArrayList<AdministradoresDTO> listaAdministradores = this.administradorDAO.listarTodos();
//        assertEquals(listaAdministradorId.size(), listaAdministradores.size());
//        for (Integer i = 0; i < listaAdministradores.size(); i++) {
//            assertEquals(listaAdministradorId.get(i), listaAdministradores.get(i).getPersonalId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaAdministradorId = new ArrayList<>();
//        insertarAdministradores(listaAdministradorId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<AdministradoresDTO> listaAdministradores = this.administradorDAO.listarTodos();
//        for (Integer i = 0; i < listaAdministradores.size(); i++) {
//            Integer resultado = this.administradorDAO.eliminar(listaAdministradores.get(i));
//            assertNotEquals(0, resultado);
//            AdministradoresDTO empleado = this.administradorDAO.obtenerPorId(listaAdministradores.get(i).getPersonalId());
//            assertNull(empleado);
//        }
//    }
//}
