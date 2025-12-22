
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.dao.UsuarioDAO;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

public class AdministradorBOTest {
    
    private AdministradorBO administradorBO;
    private PersonaBO personaBO;
    private UsuarioDAO usuarioDAO;
    
    public AdministradorBOTest() {
        this.administradorBO = new AdministradorBO();
        this.personaBO = new PersonaBO();
        this.usuarioDAO = new UsuarioDAOImpl();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("=== TEST AdministradorBO ===");
//
//        // INSERTAR
//        
//        System.out.println("Insertar:");
//        AdministradoresDTO administrador = new AdministradoresDTO();
//        administrador.setDni("12345678");
//        administrador.setNombres("Luis");
//        administrador.setApellidoPaterno("Carhuayo");
//        administrador.setApellidoMaterno("Gomez");
//        administrador.setTelefono("987654321");
//
//        administrador.setNombreUsuario("luisUsuario");
//        administrador.setContrasenia("contrasenhaTest");
//        administrador.setCorreo("luis@gmail.com");
//        administrador.setEstado(EstadoUsuario.ACTIVO);
//        
//        administrador.setLlaveMaestra("test");
//        int personaId = this.administradorBO.insertar(administrador);
//        
//        
//        // OBTENER
//        System.out.println("ObtenerPorId:");
//        AdministradoresDTO administradorObtenido = this.administradorBO.obtenerPorId(personaId);
//        
//        System.out.println(administradorObtenido.getPersonalId());
//        System.out.println(administradorObtenido.getDni());
//        System.out.println(administradorObtenido.getNombres());
//        System.out.println(administradorObtenido.getApellidoPaterno());
//        System.out.println(administrador.getTelefono());
//        System.out.println(administradorObtenido.getNombreUsuario());
//        System.out.println(administradorObtenido.getContrasenia());
//        System.out.println(administradorObtenido.getCorreo());
//        System.out.println(administradorObtenido.getEstado());
//        System.out.println(administradorObtenido.getLlaveMaestra());
//
//        // LISTAR
//        System.out.println("ListarTodos:");
//        ArrayList<AdministradoresDTO> lista = this.administradorBO.listarTodos();
//        for (AdministradoresDTO p : lista) {
//            System.out.println(p.getPersonalId() + " - " + p.getNombres());
//        }
//
//        // MODIFICAR
//        System.out.println("Modificar:");
//        
//        administradorObtenido.setDni("12345678");
//        administradorObtenido.setNombres("Luis Mod");
//        administradorObtenido.setApellidoPaterno("Carhuayo");
//        administradorObtenido.setApellidoMaterno("Gomez");
//        administradorObtenido.setTelefono("999888777");
//        
//        administradorObtenido.setNombreUsuario("luisUsuarioMod");
//        administradorObtenido.setContrasenia("contraMod");
//        administradorObtenido.setCorreo("luismod@gmail.com");
//        administradorObtenido.setEstado(EstadoUsuario.INACTIVO);
//        
//        administradorObtenido.setLlaveMaestra("tmod");
//        
//        this.administradorBO.modificar(administradorObtenido);
//        
//        AdministradoresDTO adminModificado = this.administradorBO.obtenerPorId(personaId);
//        System.out.println(adminModificado.getNombres());
//        assertEquals("Luis Mod", adminModificado.getNombres());
//
//        // ELIMINAR
//        System.out.println("Eliminar:");
//        this.administradorBO.eliminar(personaId);
//        adminModificado = this.administradorBO.obtenerPorId(personaId);
//        assertNull(adminModificado);
//    }
    
}
