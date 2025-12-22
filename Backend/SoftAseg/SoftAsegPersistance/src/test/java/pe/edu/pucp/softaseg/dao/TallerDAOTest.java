
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.TallerDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

//public class TallerDAOTest {
//    
//    private TallerDAO tallerDAO;
//    
//    public TallerDAOTest() {
//        this.tallerDAO = new TallerDAOImpl();
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaTallerId = new ArrayList<>();
//        insertarTalleres(listaTallerId);
//        eliminarTodo();
//    }
//    
//    private void insertarTalleres(ArrayList<Integer> listaTallerId) {
//        TalleresDTO taller = new TalleresDTO();
//        UbicacionesDTO ubicacion = new UbicacionesDTO();
//        taller.setNombre("NombrePrueba1");
//        taller.setUbicacion(ubicacion);
//        taller.getUbicacion().setUbicacionId(1);
//        taller.setTelefono("Prueba111");
//        Integer resultado = this.tallerDAO.insertar(taller);
//        assertTrue(resultado != 0);
//        listaTallerId.add(resultado);
//        
//        ubicacion = new UbicacionesDTO();
//        taller.setNombre("NombrePrueba2");
//        taller.setUbicacion(ubicacion);
//        taller.getUbicacion().setUbicacionId(2);
//        taller.setTelefono("Prueba222");
//        resultado = this.tallerDAO.insertar(taller);
//        assertTrue(resultado != 0);
//        listaTallerId.add(resultado);
//        
//        ubicacion = new UbicacionesDTO();
//        taller.setNombre("NombrePrueba3");
//        taller.setUbicacion(ubicacion);
//        taller.getUbicacion().setUbicacionId(3);
//        taller.setTelefono("Prueba333");
//        resultado = this.tallerDAO.insertar(taller);
//        assertTrue(resultado != 0);
//        listaTallerId.add(resultado);       
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaTallerId = new ArrayList<>();
//        insertarTalleres(listaTallerId);
//        TalleresDTO taller = this.tallerDAO.obtenerPorId(listaTallerId.get(0));
//        assertEquals(taller.getTallerId(), listaTallerId.get(0));
//        
//        taller = this.tallerDAO.obtenerPorId(listaTallerId.get(1));
//        assertEquals(taller.getTallerId(), listaTallerId.get(1));
//        
//        taller = this.tallerDAO.obtenerPorId(listaTallerId.get(2));
//        assertEquals(taller.getTallerId(), listaTallerId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaTallerId = new ArrayList<>();
//        insertarTalleres(listaTallerId);
//        
//        ArrayList<TalleresDTO> listaTalleres = this.tallerDAO.listarTodos();
//        assertEquals(listaTallerId.size()+3, listaTalleres.size());
//        for (Integer i = 0; i < listaTalleres.size(); i++) {
//            if(listaTalleres.get(i).getTallerId()>3){
//                assertEquals(listaTallerId.get(i-3), listaTalleres.get(i).getTallerId());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaTallerId = new ArrayList<>();
//        insertarTalleres(listaTallerId);
//        
//        ArrayList<TalleresDTO> listaTalleres = this.tallerDAO.listarTodos();
//        assertEquals(listaTallerId.size()+3, listaTalleres.size());
//        for (Integer i = 0; i < listaTalleres.size(); i++) {
//            if(listaTalleres.get(i).getTallerId()>3){
//                listaTalleres.get(i).setNombre("NombreModificado");
//                listaTalleres.get(i).setTelefono("Mod999999");
//                this.tallerDAO.modificar(listaTalleres.get(i));
//            }
//        }
//        
//        ArrayList<TalleresDTO> listaTalleresModificados = this.tallerDAO.listarTodos();
//        assertEquals(listaTalleres.size(), listaTalleresModificados.size());
//        for (Integer i = 0; i < listaTalleres.size(); i++) {
//            if(listaTalleres.get(i).getTallerId()>3){
//                assertEquals(listaTalleres.get(i).getNombre(), listaTalleresModificados.get(i).getNombre());
//                assertEquals(listaTalleres.get(i).getTelefono(), listaTalleresModificados.get(i).getTelefono());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaTallerId = new ArrayList<>();
//        insertarTalleres(listaTallerId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<TalleresDTO> listaTalleres = this.tallerDAO.listarTodos();
//        for (Integer i = 0; i < listaTalleres.size(); i++) {
//            if(listaTalleres.get(i).getTallerId()>3){
//                Integer resultado = this.tallerDAO.eliminar(listaTalleres.get(i));
//                assertNotEquals(0, resultado);
//                TalleresDTO taller = this.tallerDAO.obtenerPorId(listaTalleres.get(i).getTallerId());
//                assertNull(taller);
//            }
//        }
//    }
//    
//}
