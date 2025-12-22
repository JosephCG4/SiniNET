
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.SiniestroVehicularDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.TipoDanho;

//public class SiniestroVehicularDAOTest {
//    
//    private SiniestroVehicularDAO siniestroVehicularDAO;
//    
//    public SiniestroVehicularDAOTest() {
//        siniestroVehicularDAO = new SiniestroVehicularDAOImpl();
//    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaSiniestroVehicularId= new ArrayList<>();
//        insertarSiniestrosVehiculares(listaSiniestroVehicularId);
//        eliminarTodo();
//    }
//
//    private void insertarSiniestrosVehiculares(ArrayList<Integer> listaSiniestroVehicularId) {
//        SiniestrosVehicularesDTO siniestroVehicular = new SiniestrosVehicularesDTO();
//        VehiculosDTO vehiculo = new VehiculosDTO();
//        TalleresDTO taller = new TalleresDTO();
//        PersonasDTO conductor = new PersonasDTO();
//        PolizasVehicularesDTO polizaVehicular = new PolizasVehicularesDTO();
//        
//        siniestroVehicular.setSiniestroId(4);
//        siniestroVehicular.setVehiculo(vehiculo);
//        siniestroVehicular.getVehiculo().setVehiculoId(1);
//        siniestroVehicular.setCostoEstimado(111.11);
//        siniestroVehicular.setTallerAsignado(taller);
//        siniestroVehicular.getTallerAsignado().setTallerId(1);
//        siniestroVehicular.setDanos("danhos1");
//        siniestroVehicular.setConductor(conductor);
//        siniestroVehicular.getConductor().setPersonalId(1);
//        siniestroVehicular.setTipoDano(TipoDanho.LEVE);
//        siniestroVehicular.setPoliza(polizaVehicular);
//        siniestroVehicular.getPoliza().setPolizaId(1);
//        Integer resultado = this.siniestroVehicularDAO.insertar(siniestroVehicular);
//        assertTrue(resultado != 0);
//        listaSiniestroVehicularId.add(4);
//
//        siniestroVehicular.setSiniestroId(5);
//        siniestroVehicular.setVehiculo(vehiculo);
//        siniestroVehicular.getVehiculo().setVehiculoId(2);
//        siniestroVehicular.setCostoEstimado(222.22);
//        siniestroVehicular.setTallerAsignado(taller);
//        siniestroVehicular.getTallerAsignado().setTallerId(2);
//        siniestroVehicular.setDanos("danhos2");
//        siniestroVehicular.setConductor(conductor);
//        siniestroVehicular.getConductor().setPersonalId(2);
//        siniestroVehicular.setTipoDano(TipoDanho.MEDIANO);
//        siniestroVehicular.setPoliza(polizaVehicular);
//        siniestroVehicular.getPoliza().setPolizaId(2);
//        resultado = this.siniestroVehicularDAO.insertar(siniestroVehicular);
//        assertTrue(resultado != 0);
//        listaSiniestroVehicularId.add(5);
//
//        siniestroVehicular.setSiniestroId(6);
//        siniestroVehicular.setVehiculo(vehiculo);
//        siniestroVehicular.getVehiculo().setVehiculoId(3);
//        siniestroVehicular.setCostoEstimado(333.33);
//        siniestroVehicular.setTallerAsignado(taller);
//        siniestroVehicular.getTallerAsignado().setTallerId(3);
//        siniestroVehicular.setDanos("danhos3");
//        siniestroVehicular.setConductor(conductor);
//        siniestroVehicular.getConductor().setPersonalId(3);
//        siniestroVehicular.setTipoDano(TipoDanho.FUERTE);
//        siniestroVehicular.setPoliza(polizaVehicular);
//        siniestroVehicular.getPoliza().setPolizaId(3);
//        resultado = this.siniestroVehicularDAO.insertar(siniestroVehicular);
//        assertTrue(resultado != 0);
//        listaSiniestroVehicularId.add(6);      
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaSiniestroVehicularId = new ArrayList<>();
//        insertarSiniestrosVehiculares(listaSiniestroVehicularId);
//        SiniestrosVehicularesDTO siniestroVehicular = this.siniestroVehicularDAO.obtenerPorId(listaSiniestroVehicularId.get(0));
//        assertEquals(siniestroVehicular.getSiniestroId(), listaSiniestroVehicularId.get(0));
//
//        siniestroVehicular = this.siniestroVehicularDAO.obtenerPorId(listaSiniestroVehicularId.get(1));
//        assertEquals(siniestroVehicular.getSiniestroId(), listaSiniestroVehicularId.get(1));
//
//        siniestroVehicular = this.siniestroVehicularDAO.obtenerPorId(listaSiniestroVehicularId.get(2));
//        assertEquals(siniestroVehicular.getSiniestroId(), listaSiniestroVehicularId.get(2));
//        eliminarTodo();
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaSiniestroVehicularId = new ArrayList<>();
//        insertarSiniestrosVehiculares(listaSiniestroVehicularId);
//
//        ArrayList<SiniestrosVehicularesDTO> listaSiniestrosVehiculares = this.siniestroVehicularDAO.listarTodos();
//        assertEquals(listaSiniestroVehicularId.size()+3, listaSiniestrosVehiculares.size());
//        for (Integer i = 0; i < listaSiniestrosVehiculares.size(); i++) {
//            if(listaSiniestrosVehiculares.get(i).getSiniestroId()>3){
//                assertEquals(listaSiniestroVehicularId.get(i-3), listaSiniestrosVehiculares.get(i).getSiniestroId());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaSiniestroVehicularId = new ArrayList<>();
//        insertarSiniestrosVehiculares(listaSiniestroVehicularId);
//
//        ArrayList<SiniestrosVehicularesDTO> listaSiniestrosVehiculares = this.siniestroVehicularDAO.listarTodos();
//        assertEquals(listaSiniestroVehicularId.size()+3, listaSiniestrosVehiculares.size());
//        for (Integer i = 0; i < listaSiniestrosVehiculares.size(); i++) {
//            if(listaSiniestrosVehiculares.get(i).getSiniestroId()>3){
//                listaSiniestrosVehiculares.get(i).setCostoEstimado(444.44);
//                listaSiniestrosVehiculares.get(i).setDanos("danhosmodificados");
//                listaSiniestrosVehiculares.get(i).setTipoDano(TipoDanho.FUERTE);
//                this.siniestroVehicularDAO.modificar(listaSiniestrosVehiculares.get(i));
//            }
//        }
//
//        ArrayList<SiniestrosVehicularesDTO> listaSiniestrosVehicularesModificados = this.siniestroVehicularDAO.listarTodos();
//        assertEquals(listaSiniestrosVehiculares.size(), listaSiniestrosVehicularesModificados.size());
//        for (Integer i = 0; i < listaSiniestrosVehiculares.size(); i++) {
//            if(listaSiniestrosVehiculares.get(i).getSiniestroId()>3){
//                assertEquals(listaSiniestrosVehiculares.get(i).getCostoEstimado(), listaSiniestrosVehicularesModificados.get(i).getCostoEstimado());
//                assertEquals(listaSiniestrosVehiculares.get(i).getDanos(), listaSiniestrosVehicularesModificados.get(i).getDanos());
//                assertEquals(listaSiniestrosVehiculares.get(i).getTipoDano(), listaSiniestrosVehicularesModificados.get(i).getTipoDano());
//            }
//        }
//        eliminarTodo();
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaSiniestroVehicularId = new ArrayList<>();
//        insertarSiniestrosVehiculares(listaSiniestroVehicularId);
//        eliminarTodo();
//    }
//
//    private void eliminarTodo(){                
//        ArrayList<SiniestrosVehicularesDTO> listaSiniestrosVehiculares = this.siniestroVehicularDAO.listarTodos();
//        for (Integer i = 0; i < listaSiniestrosVehiculares.size(); i++) {
//            if(listaSiniestrosVehiculares.get(i).getSiniestroId()>3){
//                Integer resultado = this.siniestroVehicularDAO.eliminar(listaSiniestrosVehiculares.get(i));
//                assertNotEquals(0, resultado);
//                SiniestrosVehicularesDTO siniestroVehicular = this.siniestroVehicularDAO.obtenerPorId(listaSiniestrosVehiculares.get(i).getSiniestroId());
//                assertNull(siniestroVehicular);
//            }
//        }
//    }
//}
