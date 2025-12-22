
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.CentroDeSaludDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

//public class CentroDeSaludDAOTest {
//    
//    private CentroDeSaludDAO centroDeSaludDAO;
//    
//    public CentroDeSaludDAOTest() {
//        this.centroDeSaludDAO = new CentroDeSaludDAOImpl();
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaCentroDeSaludId = new ArrayList<>();
//        insertarCentrosDeSalud(listaCentroDeSaludId);
//        eliminarTodo();
//    }
//    
//    private void insertarCentrosDeSalud(ArrayList<Integer> listaCentroDeSaludId) {
//        CentrosDeSaludDTO centroDeSalud = new CentrosDeSaludDTO();
//        UbicacionesDTO ubicacion = new UbicacionesDTO();
//        centroDeSalud.setCodigoRenipress("CodigoPrueba1");
//        centroDeSalud.setNombre("NombrePrueba1");
//        centroDeSalud.setUbicacion(ubicacion);
//        centroDeSalud.getUbicacion().setUbicacionId(1);
//        centroDeSalud.setTelefono("Prueba111");
//        Integer resultado = this.centroDeSaludDAO.insertar(centroDeSalud);
//        assertTrue(resultado != 0);
//        listaCentroDeSaludId.add(resultado);
//        
//        ubicacion = new UbicacionesDTO();
//        centroDeSalud.setCodigoRenipress("CodigoPrueba2");
//        centroDeSalud.setNombre("NombrePrueba2");
//        centroDeSalud.setUbicacion(ubicacion);
//        centroDeSalud.getUbicacion().setUbicacionId(2);
//        centroDeSalud.setTelefono("Prueba222");
//        resultado = this.centroDeSaludDAO.insertar(centroDeSalud);
//        assertTrue(resultado != 0);
//        listaCentroDeSaludId.add(resultado);
//        
//        ubicacion = new UbicacionesDTO();
//        centroDeSalud.setCodigoRenipress("CodigoPrueba3");
//        centroDeSalud.setNombre("NombrePrueba3");
//        centroDeSalud.setUbicacion(ubicacion);
//        centroDeSalud.getUbicacion().setUbicacionId(3);
//        centroDeSalud.setTelefono("Prueba333");
//        resultado = this.centroDeSaludDAO.insertar(centroDeSalud);
//        assertTrue(resultado != 0);
//        listaCentroDeSaludId.add(resultado);       
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaCentroDeSaludId = new ArrayList<>();
//        insertarCentrosDeSalud(listaCentroDeSaludId);
//        CentrosDeSaludDTO centroDeSalud = this.centroDeSaludDAO.obtenerPorId(listaCentroDeSaludId.get(0));
//        assertEquals(centroDeSalud.getCentroDeSaludId(), listaCentroDeSaludId.get(0));
//        
//        centroDeSalud = this.centroDeSaludDAO.obtenerPorId(listaCentroDeSaludId.get(1));
//        assertEquals(centroDeSalud.getCentroDeSaludId(), listaCentroDeSaludId.get(1));
//        
//        centroDeSalud = this.centroDeSaludDAO.obtenerPorId(listaCentroDeSaludId.get(2));
//        assertEquals(centroDeSalud.getCentroDeSaludId(), listaCentroDeSaludId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaCentroDeSaludId = new ArrayList<>();
//        insertarCentrosDeSalud(listaCentroDeSaludId);
//        
//        ArrayList<CentrosDeSaludDTO> listaCentrosDeSalud = this.centroDeSaludDAO.listarTodos();
//        assertEquals(listaCentroDeSaludId.size()+3, listaCentrosDeSalud.size());
//        for (Integer i = 0; i < listaCentrosDeSalud.size(); i++) {
//            if(listaCentrosDeSalud.get(i).getCentroDeSaludId()>3){
//                assertEquals(listaCentroDeSaludId.get(i-3), listaCentrosDeSalud.get(i).getCentroDeSaludId());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaCentroDeSaludId = new ArrayList<>();
//        insertarCentrosDeSalud(listaCentroDeSaludId);
//        
//        ArrayList<CentrosDeSaludDTO> listaCentrosDeSalud = this.centroDeSaludDAO.listarTodos();
//        assertEquals(listaCentroDeSaludId.size()+3, listaCentrosDeSalud.size());
//        for (Integer i = 0; i < listaCentrosDeSalud.size(); i++) {
//            if(listaCentrosDeSalud.get(i).getCentroDeSaludId()>3){
//                listaCentrosDeSalud.get(i).setCodigoRenipress("CodigoModificado");
//                listaCentrosDeSalud.get(i).setNombre("NombreModificado");
//                listaCentrosDeSalud.get(i).setTelefono("Mod999999");
//                this.centroDeSaludDAO.modificar(listaCentrosDeSalud.get(i));
//            }
//        }
//        
//        ArrayList<CentrosDeSaludDTO> listaCentrosDeSaludModificados = this.centroDeSaludDAO.listarTodos();
//        assertEquals(listaCentrosDeSalud.size(), listaCentrosDeSaludModificados.size());
//        for (Integer i = 0; i < listaCentrosDeSalud.size(); i++) {
//            if(listaCentrosDeSalud.get(i).getCentroDeSaludId()>3){
//                assertEquals(listaCentrosDeSalud.get(i).getCodigoRenipress(), listaCentrosDeSaludModificados.get(i).getCodigoRenipress());
//                assertEquals(listaCentrosDeSalud.get(i).getNombre(), listaCentrosDeSaludModificados.get(i).getNombre());
//                assertEquals(listaCentrosDeSalud.get(i).getTelefono(), listaCentrosDeSaludModificados.get(i).getTelefono());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaCentroDeSaludId = new ArrayList<>();
//        insertarCentrosDeSalud(listaCentroDeSaludId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<CentrosDeSaludDTO> listaCentrosDeSalud = this.centroDeSaludDAO.listarTodos();
//        for (Integer i = 0; i < listaCentrosDeSalud.size(); i++) {
//            if(listaCentrosDeSalud.get(i).getCentroDeSaludId()>3){
//                Integer resultado = this.centroDeSaludDAO.eliminar(listaCentrosDeSalud.get(i));
//                assertNotEquals(0, resultado);
//                CentrosDeSaludDTO centroDeSalud = this.centroDeSaludDAO.obtenerPorId(listaCentrosDeSalud.get(i).getCentroDeSaludId());
//                assertNull(centroDeSalud);
//            }
//        }
//    }
//    
//}
