
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.SiniestroSOATDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;

//public class SiniestroSOATDAOTest {
//    
//    private SiniestroSOATDAO siniestroSOATDAO;
//    
//    public SiniestroSOATDAOTest() {
//        siniestroSOATDAO = new SiniestroSOATDAOImpl();
//    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaSiniestroSOATId= new ArrayList<>();
//        insertarSiniestrosSOAT(listaSiniestroSOATId);
//        eliminarTodo();
//    }
//
//    private void insertarSiniestrosSOAT(ArrayList<Integer> listaSiniestroSOATId) {
//        SiniestrosSOATDTO siniestroSOAT = new SiniestrosSOATDTO();
//        CentrosDeSaludDTO centroDeSalud = new CentrosDeSaludDTO();
//        PolizasSOATDTO polizaSOAT = new PolizasSOATDTO();
//        
//        siniestroSOAT.setSiniestroId(4);
//        siniestroSOAT.setCentroDeSalud(centroDeSalud);
//        siniestroSOAT.getCentroDeSalud().setCentroDeSaludId(1);
//        siniestroSOAT.setGastosMedicos(111.11);
//        siniestroSOAT.setDiagnostico("diagnostico1");
//        siniestroSOAT.setPoliza(polizaSOAT);
//        siniestroSOAT.getPoliza().setPolizaId(1);
//        Integer resultado = this.siniestroSOATDAO.insertar(siniestroSOAT);
//        assertTrue(resultado != 0);
//        listaSiniestroSOATId.add(4);
//
//        siniestroSOAT.setSiniestroId(5);
//        siniestroSOAT.setCentroDeSalud(centroDeSalud);
//        siniestroSOAT.getCentroDeSalud().setCentroDeSaludId(2);
//        siniestroSOAT.setGastosMedicos(222.22);
//        siniestroSOAT.setDiagnostico("diagnostico2");
//        siniestroSOAT.setPoliza(polizaSOAT);
//        siniestroSOAT.getPoliza().setPolizaId(2);
//        resultado = this.siniestroSOATDAO.insertar(siniestroSOAT);
//        assertTrue(resultado != 0);
//        listaSiniestroSOATId.add(5);
//
//        siniestroSOAT.setSiniestroId(6);
//        siniestroSOAT.setCentroDeSalud(centroDeSalud);
//        siniestroSOAT.getCentroDeSalud().setCentroDeSaludId(3);
//        siniestroSOAT.setGastosMedicos(333.33);
//        siniestroSOAT.setDiagnostico("diagnostico3");
//        siniestroSOAT.setPoliza(polizaSOAT);
//        siniestroSOAT.getPoliza().setPolizaId(3);
//        resultado = this.siniestroSOATDAO.insertar(siniestroSOAT);
//        assertTrue(resultado != 0);
//        listaSiniestroSOATId.add(6);      
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaSiniestroSOATId = new ArrayList<>();
//        insertarSiniestrosSOAT(listaSiniestroSOATId);
//        SiniestrosSOATDTO siniestroSOAT = this.siniestroSOATDAO.obtenerPorId(listaSiniestroSOATId.get(0));
//        assertEquals(siniestroSOAT.getSiniestroId(), listaSiniestroSOATId.get(0));
//
//        siniestroSOAT = this.siniestroSOATDAO.obtenerPorId(listaSiniestroSOATId.get(1));
//        assertEquals(siniestroSOAT.getSiniestroId(), listaSiniestroSOATId.get(1));
//
//        siniestroSOAT = this.siniestroSOATDAO.obtenerPorId(listaSiniestroSOATId.get(2));
//        assertEquals(siniestroSOAT.getSiniestroId(), listaSiniestroSOATId.get(2));
//        eliminarTodo();
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaSiniestroSOATId = new ArrayList<>();
//        insertarSiniestrosSOAT(listaSiniestroSOATId);
//
//        ArrayList<SiniestrosSOATDTO> listaSiniestrosSOAT = this.siniestroSOATDAO.listarTodos();
//        assertEquals(listaSiniestroSOATId.size()+3, listaSiniestrosSOAT.size());
//        for (Integer i = 0; i < listaSiniestrosSOAT.size(); i++) {
//            if(listaSiniestrosSOAT.get(i).getSiniestroId()>3){
//                assertEquals(listaSiniestroSOATId.get(i-3), listaSiniestrosSOAT.get(i).getSiniestroId());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaSiniestroSOATId = new ArrayList<>();
//        insertarSiniestrosSOAT(listaSiniestroSOATId);
//
//        ArrayList<SiniestrosSOATDTO> listaSiniestrosSOAT = this.siniestroSOATDAO.listarTodos();
//        assertEquals(listaSiniestroSOATId.size()+3, listaSiniestrosSOAT.size());
//        for (Integer i = 0; i < listaSiniestrosSOAT.size(); i++) {
//            if(listaSiniestrosSOAT.get(i).getSiniestroId()>3){
//                listaSiniestrosSOAT.get(i).setGastosMedicos(1.1);
//                listaSiniestrosSOAT.get(i).setDiagnostico("diagnosticomodificado");
//                this.siniestroSOATDAO.modificar(listaSiniestrosSOAT.get(i));
//            }
//        }
//
//        ArrayList<SiniestrosSOATDTO> listaSiniestrosSOATModificados = this.siniestroSOATDAO.listarTodos();
//        assertEquals(listaSiniestrosSOAT.size(), listaSiniestrosSOATModificados.size());
//        for (Integer i = 0; i < listaSiniestrosSOAT.size(); i++) {
//            if(listaSiniestrosSOAT.get(i).getSiniestroId()>3){
//                assertEquals(listaSiniestrosSOAT.get(i).getGastosMedicos(), listaSiniestrosSOATModificados.get(i).getGastosMedicos());
//                assertEquals(listaSiniestrosSOAT.get(i).getDiagnostico(), listaSiniestrosSOATModificados.get(i).getDiagnostico());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaSiniestroSOATId = new ArrayList<>();
//        insertarSiniestrosSOAT(listaSiniestroSOATId);
//        eliminarTodo();
//    }
//
//    private void eliminarTodo(){                
//        ArrayList<SiniestrosSOATDTO> listaSiniestrosSOAT = this.siniestroSOATDAO.listarTodos();
//        for (Integer i = 0; i < listaSiniestrosSOAT.size(); i++) {
//            if(listaSiniestrosSOAT.get(i).getSiniestroId()>3){
//                Integer resultado = this.siniestroSOATDAO.eliminar(listaSiniestrosSOAT.get(i));
//                assertNotEquals(0, resultado);
//                SiniestrosSOATDTO siniestroSOAT = this.siniestroSOATDAO.obtenerPorId(listaSiniestrosSOAT.get(i).getSiniestroId());
//                assertNull(siniestroSOAT);
//            }
//        }
//    }
//    
//}
