
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.EmpleadoDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.DesempenhoEmpleado;
import pe.edu.pucp.softaseg.model.util.TipoEmpleado;


public class EmpleadoDAOTest {
    
    private EmpleadoDAO empleadoDAO;
    
    public EmpleadoDAOTest() {
        this.empleadoDAO = new EmpleadoDAOImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaEmpleadoId = new ArrayList<>();
//        insertarEmpleados(listaEmpleadoId);
//        eliminarTodo();
//    }
    
    private void insertarEmpleados(ArrayList<Integer> listaUsuarioId) {
        EmpleadosDTO empleado = new EmpleadosDTO();
        empleado.setPersonalId(4);
        empleado.setDesempenio(DesempenhoEmpleado.INACEPTABLE);
        empleado.setTipo(TipoEmpleado.OPERADOR);
        Integer resultado = this.empleadoDAO.insertar(empleado);
        assertTrue(resultado != 0);
        listaUsuarioId.add(4);

        empleado.setPersonalId(5);
        empleado.setDesempenio(DesempenhoEmpleado.INACEPTABLE);
        empleado.setTipo(TipoEmpleado.OPERADOR);
        resultado = this.empleadoDAO.insertar(empleado);
        assertTrue(resultado != 0);
        listaUsuarioId.add(5);

        empleado.setPersonalId(6);
        empleado.setDesempenio(DesempenhoEmpleado.INACEPTABLE);
        empleado.setTipo(TipoEmpleado.OPERADOR);
        resultado = this.empleadoDAO.insertar(empleado);
        assertTrue(resultado != 0);
        listaUsuarioId.add(6);     
    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaEmpleadoId = new ArrayList<>();
//        insertarEmpleados(listaEmpleadoId);
//        EmpleadosDTO empleado = this.empleadoDAO.obtenerPorId(listaEmpleadoId.get(0));
//        assertEquals(empleado.getPersonalId(), listaEmpleadoId.get(0));
//
//        empleado = this.empleadoDAO.obtenerPorId(listaEmpleadoId.get(1));
//        assertEquals(empleado.getPersonalId(), listaEmpleadoId.get(1));
//
//        empleado = this.empleadoDAO.obtenerPorId(listaEmpleadoId.get(2));
//        assertEquals(empleado.getPersonalId(), listaEmpleadoId.get(2));
//        eliminarTodo();
//    }
    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaEmpleadoId = new ArrayList<>();
//        insertarEmpleados(listaEmpleadoId);
//
//        ArrayList<EmpleadosDTO> listaEmpleados = this.empleadoDAO.listarTodos();
//        assertEquals(listaEmpleadoId.size()+3, listaEmpleados.size());
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            if(listaEmpleados.get(i).getPersonalId()>3){
//                listaEmpleados.get(i).setDesempenio(DesempenhoEmpleado.SOBRESALIENTE);
//                listaEmpleados.get(i).setTipo(TipoEmpleado.PROCURADOR);
//                this.empleadoDAO.modificar(listaEmpleados.get(i));
//            }
//        }
//
//        ArrayList<EmpleadosDTO> listaEmpleadosModificados = this.empleadoDAO.listarTodos();
//        assertEquals(listaEmpleados.size(), listaEmpleadosModificados.size());
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            if(listaEmpleados.get(i).getPersonalId()>3){
//                assertEquals(listaEmpleados.get(i).getDesempenio(), listaEmpleadosModificados.get(i).getDesempenio());
//                assertEquals(listaEmpleados.get(i).getTipo(), listaEmpleadosModificados.get(i).getTipo());
//            }
//        }
//        eliminarTodo();
//    }
    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaEmpleadoId = new ArrayList<>();
//        insertarEmpleados(listaEmpleadoId);
//
//        ArrayList<EmpleadosDTO> listaEmpleados = this.empleadoDAO.listarTodos();
//        assertEquals(listaEmpleadoId.size()+3, listaEmpleados.size());
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            if(listaEmpleados.get(i).getPersonalId()>3){
//                assertEquals(listaEmpleadoId.get(i-3), listaEmpleados.get(i).getPersonalId());
//            }
//        }
//        eliminarTodo();
//    }
//    @Test
//    public void testListarPorNombreApellidoPaternoTipoEmpleado(){
//        System.out.println("listarPorNombreApellidoPaternoTipoEmpleado");
//
//        ArrayList<EmpleadosDTO> listaEmpleados = this.empleadoDAO.listarPorNombreApellidoPaternoTipoEmpleado("patern");
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            System.out.println(listaEmpleados.get(i).getPersonalId());
//            System.out.println(listaEmpleados.get(i).getNombres());
//            System.out.println(listaEmpleados.get(i).getApellidoPaterno());
//            System.out.println(listaEmpleados.get(i).getTipo());
//        }
//        
//        listaEmpleados = this.empleadoDAO.listarPorNombreApellidoPaternoTipoEmpleado("2");
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            System.out.println(listaEmpleados.get(i).getPersonalId());
//            System.out.println(listaEmpleados.get(i).getNombres());
//            System.out.println(listaEmpleados.get(i).getApellidoPaterno());
//            System.out.println(listaEmpleados.get(i).getTipo());
//        }
//        
//        listaEmpleados = this.empleadoDAO.listarPorNombreApellidoPaternoTipoEmpleado("Procur");
//        for (Integer i = 0; i < listaEmpleados.size(); i++) {
//            System.out.println(listaEmpleados.get(i).getPersonalId());
//            System.out.println(listaEmpleados.get(i).getNombres());
//            System.out.println(listaEmpleados.get(i).getApellidoPaterno());
//            System.out.println(listaEmpleados.get(i).getTipo());
//        }
//        
//    }
    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaEmpleadoId = new ArrayList<>();
//        insertarEmpleados(listaEmpleadoId);
//        eliminarTodo();
//    }
    
    private void eliminarTodo(){                
        ArrayList<EmpleadosDTO> listaEmpleados = this.empleadoDAO.listarTodos();
        for (Integer i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).getPersonalId()>3){
                Integer resultado = this.empleadoDAO.eliminar(listaEmpleados.get(i));
                assertNotEquals(0, resultado);
                EmpleadosDTO empleado = this.empleadoDAO.obtenerPorId(listaEmpleados.get(i).getPersonalId());
                assertNull(empleado);
            }
        }
    }
}
