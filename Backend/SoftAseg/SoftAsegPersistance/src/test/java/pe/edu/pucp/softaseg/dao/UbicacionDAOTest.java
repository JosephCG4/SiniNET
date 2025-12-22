
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

//public class UbicacionDAOTest {
//    
//    private UbicacionDAO ubicacionDAO;    
//    
//    public UbicacionDAOTest() {
//        this.ubicacionDAO = new UbicacionDAOImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaUbicacionId = new ArrayList<>();
//        insertarUbicaciones(listaUbicacionId);
//        eliminarTodo();
//    }
//    
//    private void insertarUbicaciones(ArrayList<Integer> listaUbicacionId) {
//        UbicacionesDTO ubicacion = new UbicacionesDTO();
//        ubicacion.setDireccion("Av. La Marina 871");
//        ubicacion.setReferencia("cerca a la pucp");
//        ubicacion.setLatitud(12.1);
//        ubicacion.setLongitud(14.5);
//        Integer resultado = this.ubicacionDAO.insertar(ubicacion);
//        assertTrue(resultado != 0);
//        listaUbicacionId.add(resultado);
//        
//        ubicacion.setDireccion("Av. La Marina 872");
//        ubicacion.setReferencia("cerca a la pucp");
//        ubicacion.setLatitud(22.1);
//        ubicacion.setLongitud(24.5);
//        resultado = this.ubicacionDAO.insertar(ubicacion);
//        assertTrue(resultado != 0);
//        listaUbicacionId.add(resultado);
//        
//        ubicacion.setDireccion("Av. La Marina 873");
//        ubicacion.setReferencia("cerca a la pucp");
//        ubicacion.setLatitud(32.1);
//        ubicacion.setLongitud(34.5);
//        resultado = this.ubicacionDAO.insertar(ubicacion);
//        assertTrue(resultado != 0);
//        listaUbicacionId.add(resultado);       
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaUbicacionId = new ArrayList<>();
//        insertarUbicaciones(listaUbicacionId);
//        UbicacionesDTO ubicacion = this.ubicacionDAO.obtenerPorId(listaUbicacionId.get(0));
//        assertEquals(ubicacion.getUbicacionId(), listaUbicacionId.get(0));
//        
//        ubicacion = this.ubicacionDAO.obtenerPorId(listaUbicacionId.get(1));
//        assertEquals(ubicacion.getUbicacionId(), listaUbicacionId.get(1));
//        
//        ubicacion = this.ubicacionDAO.obtenerPorId(listaUbicacionId.get(2));
//        assertEquals(ubicacion.getUbicacionId(), listaUbicacionId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaUbicacionId = new ArrayList<>();
//        insertarUbicaciones(listaUbicacionId);
//        
//        ArrayList<UbicacionesDTO> listaUbicaciones = this.ubicacionDAO.listarTodos();
//        for (Integer i = 0; i < listaUbicaciones.size(); i++) {
//            if(listaUbicaciones.get(i).getUbicacionId()>3){
//                assertEquals(listaUbicacionId.get(i-3), listaUbicaciones.get(i).getUbicacionId());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaUbicacionId = new ArrayList<>();
//        insertarUbicaciones(listaUbicacionId);
//        
//        ArrayList<UbicacionesDTO> listaUbicaciones = this.ubicacionDAO.listarTodos();
//        assertEquals(listaUbicacionId.size()+3, listaUbicaciones.size());
//        for (Integer i = 0; i < listaUbicaciones.size(); i++) {
//            if(listaUbicaciones.get(i).getUbicacionId()>3){
//                listaUbicaciones.get(i).setDireccion("DireccionTest");
//                listaUbicaciones.get(i).setReferencia("ReferenciaTest");
//                listaUbicaciones.get(i).setLatitud(11.1);
//                listaUbicaciones.get(i).setLongitud(22.2);
//                this.ubicacionDAO.modificar(listaUbicaciones.get(i));
//            }
//        }
//        
//        ArrayList<UbicacionesDTO> listaUbicacionesModificadas = this.ubicacionDAO.listarTodos();
//        assertEquals(listaUbicaciones.size(), listaUbicacionesModificadas.size());
//        for (Integer i = 0; i < listaUbicaciones.size(); i++) {
//            if(listaUbicaciones.get(i).getUbicacionId()>3){
//                assertEquals(listaUbicaciones.get(i).getDireccion(), listaUbicacionesModificadas.get(i).getDireccion());
//                assertEquals(listaUbicaciones.get(i).getReferencia(), listaUbicacionesModificadas.get(i).getReferencia());
//                assertEquals(listaUbicaciones.get(i).getLatitud(), listaUbicacionesModificadas.get(i).getLatitud());
//                assertEquals(listaUbicaciones.get(i).getLongitud(), listaUbicacionesModificadas.get(i).getLongitud());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaUbicacionId = new ArrayList<>();
//        insertarUbicaciones(listaUbicacionId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<UbicacionesDTO> listaUbicaciones = this.ubicacionDAO.listarTodos();
//        for (Integer i = 0; i < listaUbicaciones.size(); i++) {
//            if(listaUbicaciones.get(i).getUbicacionId()>3){
//                Integer resultado = this.ubicacionDAO.eliminar(listaUbicaciones.get(i));
//                assertNotEquals(0, resultado);
//                UbicacionesDTO ubicacion = this.ubicacionDAO.obtenerPorId(listaUbicaciones.get(i).getUbicacionId());
//                assertNull(ubicacion);
//            }
//        }
//    }
//    
//}
