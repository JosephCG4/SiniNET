
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.PolizaSOATDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;

//public class PolizaSOATDAOTest {
//    
//    private PolizaSOATDAO polizaSOATDAO;
//    
//    public PolizaSOATDAOTest() {
//        this.polizaSOATDAO = new PolizaSOATDAOImpl();
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaPolizaSOATId = new ArrayList<>();
//        insertarPolizasSOAT(listaPolizaSOATId);
//        eliminarTodo();
//    }
//    
//    private void insertarPolizasSOAT(ArrayList<Integer> listaPolizaSOATId) {
//        PolizasSOATDTO polizaSOAT = new PolizasSOATDTO();
//        PersonasDTO persona = new PersonasDTO();
//        
//        polizaSOAT.setAsegurado(persona);
//        polizaSOAT.getAsegurado().setPersonalId(1);
//        polizaSOAT.setEstado(EstadoPoliza.VIGENTE);
//        polizaSOAT.setMontoACobertura(10);
//        Integer resultado = this.polizaSOATDAO.insertar(polizaSOAT);
//        assertTrue(resultado != 0);
//        listaPolizaSOATId.add(resultado);
//        
//        polizaSOAT.setAsegurado(persona);
//        polizaSOAT.getAsegurado().setPersonalId(2);
//        polizaSOAT.setEstado(EstadoPoliza.VIGENTE);
//        polizaSOAT.setMontoACobertura(20);
//        resultado = this.polizaSOATDAO.insertar(polizaSOAT);
//        assertTrue(resultado != 0);
//        listaPolizaSOATId.add(resultado);
//        
//        polizaSOAT.setAsegurado(persona);
//        polizaSOAT.getAsegurado().setPersonalId(3);
//        polizaSOAT.setEstado(EstadoPoliza.VIGENTE);
//        polizaSOAT.setMontoACobertura(30);
//        resultado = this.polizaSOATDAO.insertar(polizaSOAT);
//        assertTrue(resultado != 0);
//        listaPolizaSOATId.add(resultado);   
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaPolizaSOATId = new ArrayList<>();
//        insertarPolizasSOAT(listaPolizaSOATId);
//        PolizasSOATDTO polizaSOAT = this.polizaSOATDAO.obtenerPorId(listaPolizaSOATId.get(0));
//        assertEquals(polizaSOAT.getPolizaId(), listaPolizaSOATId.get(0));
//        
//        polizaSOAT = this.polizaSOATDAO.obtenerPorId(listaPolizaSOATId.get(1));
//        assertEquals(polizaSOAT.getPolizaId(), listaPolizaSOATId.get(1));
//        
//        polizaSOAT = this.polizaSOATDAO.obtenerPorId(listaPolizaSOATId.get(2));
//        assertEquals(polizaSOAT.getPolizaId(), listaPolizaSOATId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaPolizaSOATId = new ArrayList<>();
//        insertarPolizasSOAT(listaPolizaSOATId);
//        
//        ArrayList<PolizasSOATDTO> listaPolizasSOAT = this.polizaSOATDAO.listarTodos();
//        assertEquals(listaPolizaSOATId.size()+3, listaPolizasSOAT.size());
//        for (Integer i = 0; i < listaPolizasSOAT.size(); i++) {
//            if(listaPolizasSOAT.get(i).getPolizaId()>3){
//                assertEquals(listaPolizaSOATId.get(i-3), listaPolizasSOAT.get(i).getPolizaId());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaPolizaSOATId = new ArrayList<>();
//        insertarPolizasSOAT(listaPolizaSOATId);
//        
//        ArrayList<PolizasSOATDTO> listaPolizasSOAT = this.polizaSOATDAO.listarTodos();
//        assertEquals(listaPolizaSOATId.size()+3, listaPolizasSOAT.size());
//        for (Integer i = 0; i < listaPolizasSOAT.size(); i++) {
//            if(listaPolizasSOAT.get(i).getPolizaId()>3){
//                listaPolizasSOAT.get(i).setEstado(EstadoPoliza.VENCIDO);
//                listaPolizasSOAT.get(i).setMontoACobertura(40);
//                this.polizaSOATDAO.modificar(listaPolizasSOAT.get(i));
//            }
//        }
//        
//        ArrayList<PolizasSOATDTO> listaPolizasSOATModificadas = this.polizaSOATDAO.listarTodos();
//        assertEquals(listaPolizasSOAT.size(), listaPolizasSOATModificadas.size());
//        for (Integer i = 0; i < listaPolizasSOAT.size(); i++) {
//            if(listaPolizasSOAT.get(i).getPolizaId()>3){
//                assertEquals(listaPolizasSOAT.get(i).getEstado(), listaPolizasSOATModificadas.get(i).getEstado());
//                assertEquals(listaPolizasSOAT.get(i).getMontoACobertura(), listaPolizasSOATModificadas.get(i).getMontoACobertura());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaPolizaSOATId = new ArrayList<>();
//        insertarPolizasSOAT(listaPolizaSOATId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<PolizasSOATDTO> listaPolizasSOAT = this.polizaSOATDAO.listarTodos();
//        for (Integer i = 0; i < listaPolizasSOAT.size(); i++) {
//            if(listaPolizasSOAT.get(i).getPolizaId()>3){
//                Integer resultado = this.polizaSOATDAO.eliminar(listaPolizasSOAT.get(i));
//                assertNotEquals(0, resultado);
//                PolizasSOATDTO polizaSOAT = this.polizaSOATDAO.obtenerPorId(listaPolizasSOAT.get(i).getPolizaId());
//                assertNull(polizaSOAT);
//            }
//        }
//    }
//    
//}
