
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import pe.edu.pucp.softaseg.dao.UsuarioDAO;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.DesempenhoEmpleado;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;
import pe.edu.pucp.softaseg.model.util.TipoEmpleado;

public class EmpleadoBOTest {
    private EmpleadoBO empleadoBO;
    private PersonaBO personaBO;
    private UsuarioDAO usuarioDAO;
    
    public EmpleadoBOTest() {
        this.empleadoBO = new EmpleadoBO();
        this.personaBO = new PersonaBO();
        this.usuarioDAO = new UsuarioDAOImpl();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("=== TEST EmpleadoBO ===");
//
//        // INSERTAR
//        System.out.println("Insertar:");
//        EmpleadosDTO empleado = new EmpleadosDTO();
//        
//        empleado.setDni("12345678");
//        empleado.setNombres("Luis");
//        empleado.setApellidoPaterno("Carhuayo");
//        empleado.setApellidoMaterno("Gomez");
//        empleado.setTelefono("987654321");
//
//        empleado.setNombreUsuario("luisUsuario");
//        empleado.setContrasenia("contrasenhaTest");
//        empleado.setCorreo("luis@gmail.com");
//        empleado.setEstado(EstadoUsuario.ACTIVO);
//        
//        empleado.setDesempenio(DesempenhoEmpleado.VALIDO);
//        empleado.setTipo(TipoEmpleado.PROCURADOR);
//        int personaId = this.empleadoBO.insertar(empleado);
//
//        // OBTENER
//        System.out.println("ObtenerPorId:");
//        EmpleadosDTO empleadoObtenido = this.empleadoBO.obtenerPorId(personaId);
//        System.out.println(empleadoObtenido.getPersonalId());
//        System.out.println(empleadoObtenido.getDni());
//        System.out.println(empleadoObtenido.getNombres());
//        System.out.println(empleadoObtenido.getApellidoPaterno());
//        System.out.println(empleadoObtenido.getTelefono());
//        System.out.println(empleadoObtenido.getNombreUsuario());
//        System.out.println(empleadoObtenido.getContrasenia());
//        System.out.println(empleadoObtenido.getCorreo());
//        System.out.println(empleadoObtenido.getEstado());
//        System.out.println(empleadoObtenido.getDesempenio());
//        System.out.println(empleadoObtenido.getTipo());
//
//        // LISTAR
//        System.out.println("ListarTodos:");
//        ArrayList<EmpleadosDTO> lista = this.empleadoBO.listarTodos();
//        for (EmpleadosDTO p : lista) {
//            System.out.println(p.getPersonalId() + " - " + p.getNombres());
//        }
//
//        // MODIFICAR
//        System.out.println("Modificar:");
//        
//        //modificar persona
//        empleadoObtenido.setDni("12345678");
//        empleadoObtenido.setNombres("Luis Mod");
//        empleadoObtenido.setApellidoPaterno("Carhuayo");
//        empleadoObtenido.setApellidoMaterno("Gomez");
//        empleadoObtenido.setTelefono("999888777");
//        
//        empleadoObtenido.setNombreUsuario("luisUsuarioMod");
//        empleadoObtenido.setContrasenia("contraMod");
//        empleadoObtenido.setCorreo("luismod@gmail.com");
//        empleadoObtenido.setEstado(EstadoUsuario.INACTIVO);
//    
//        
//
//        empleadoObtenido.setDesempenio(DesempenhoEmpleado.SOBRESALIENTE);
//        empleadoObtenido.setTipo(TipoEmpleado.OPERADOR);
//        
//        this.empleadoBO.modificar(empleadoObtenido);
//        
//        EmpleadosDTO empleadoModificado = this.empleadoBO.obtenerPorId(personaId);
//        System.out.println(empleadoModificado.getNombres());
//        assertEquals("Luis Mod", empleadoModificado.getNombres());
//
//        // ELIMINAR
//        System.out.println("Eliminar:");
//        this.empleadoBO.eliminar(personaId);
//        empleadoModificado = this.empleadoBO.obtenerPorId(personaId);
//        assertNull(empleadoModificado);
//    }
}
