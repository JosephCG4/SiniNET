
package pe.edu.pucp.softaseg.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.SiniestroDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;

public class SiniestroDAOTest {
    
    private SiniestroDAO siniestroDAO = new SiniestroDAOImpl();
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaSiniestroId = new ArrayList<>();
//        insertarSiniestros(listaSiniestroId);
//        eliminarTodo();
//    }
    
    private void insertarSiniestros(ArrayList<Integer> listaSiniestroId) {
        SiniestrosDTO siniestro = new SiniestrosDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        EmpleadosDTO procurador = new EmpleadosDTO();
        
        siniestro.setDescripcion("DescripcionPrueba1");
        siniestro.setFechaHora(LocalDateTime.now());
        siniestro.setEstado(EstadoSiniestro.EN_PROCESO);
        siniestro.setCalificacionServicio(1);
        siniestro.setUbicacion(ubicacion);
        siniestro.getUbicacion().setUbicacionId(1);
        siniestro.setProcurador(procurador);
        siniestro.getProcurador().setPersonalId(1);
        siniestro.setValidez(true);
        Integer resultado = this.siniestroDAO.insertar(siniestro);
        assertTrue(resultado != 0);
        listaSiniestroId.add(resultado);
        
        siniestro.setDescripcion("DescripcionPrueba2");
        siniestro.setFechaHora(LocalDateTime.now());
        siniestro.setEstado(EstadoSiniestro.CANCELADO);
        siniestro.setCalificacionServicio(2);
        siniestro.setUbicacion(ubicacion);
        siniestro.getUbicacion().setUbicacionId(2);
        siniestro.setProcurador(procurador);
        siniestro.getProcurador().setPersonalId(2);
        siniestro.setValidez(false);
        resultado = this.siniestroDAO.insertar(siniestro);
        listaSiniestroId.add(resultado);
        
        siniestro.setDescripcion("DescripcionPrueba3");
        siniestro.setFechaHora(LocalDateTime.now());
        siniestro.setEstado(EstadoSiniestro.FINALIZADO);
        siniestro.setCalificacionServicio(3);
        siniestro.setUbicacion(ubicacion);
        siniestro.getUbicacion().setUbicacionId(3);
        siniestro.setProcurador(procurador);
        siniestro.getProcurador().setPersonalId(3);
        siniestro.setValidez(true);
        resultado = this.siniestroDAO.insertar(siniestro);
        assertTrue(resultado != 0);
        listaSiniestroId.add(resultado);       
    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaSiniestroId = new ArrayList<>();
//        insertarSiniestros(listaSiniestroId);
//        SiniestrosDTO siniestro = this.siniestroDAO.obtenerPorId(listaSiniestroId.get(0));
//        assertEquals(siniestro.getSiniestroId(), listaSiniestroId.get(0));
//        
//        siniestro = this.siniestroDAO.obtenerPorId(listaSiniestroId.get(1));
//        assertEquals(siniestro.getSiniestroId(), listaSiniestroId.get(1));
//        
//        siniestro = this.siniestroDAO.obtenerPorId(listaSiniestroId.get(2));
//        assertEquals(siniestro.getSiniestroId(), listaSiniestroId.get(2));
//        eliminarTodo();
//    }
    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaSiniestroId = new ArrayList<>();
//        insertarSiniestros(listaSiniestroId);
//        
//        ArrayList<SiniestrosDTO> listaSiniestros = this.siniestroDAO.listarTodos();
//        assertEquals(listaSiniestroId.size()+6, listaSiniestros.size());
//        for (Integer i = 0; i < listaSiniestros.size(); i++) {
//            if(listaSiniestros.get(i).getSiniestroId()>6){
//                assertEquals(listaSiniestroId.get(i-6), listaSiniestros.get(i).getSiniestroId());
//            }
//        }
//        eliminarTodo();
//    }
    
//    @Test
//    public void testListarPorNombreApellidoPaternoTipoEmpleado(){
//        System.out.println("listarPorNombreApellidoPaternoTipoEmpleado");
//
//        ArrayList<SiniestrosDTO> listaSiniestros = this.siniestroDAO.listarPorEmpleado("patern");
//        for (Integer i = 0; i < listaSiniestros.size(); i++) {
//            System.out.println(listaSiniestros.get(i).getSiniestroId());
//            System.out.println(listaSiniestros.get(i).getProcurador().getNombres());
//            System.out.println(listaSiniestros.get(i).getProcurador().getApellidoPaterno());
//        }
//        
//        listaSiniestros = this.siniestroDAO.listarPorEmpleado("2");
//        for (Integer i = 0; i < listaSiniestros.size(); i++) {
//            System.out.println(listaSiniestros.get(i).getSiniestroId());
//            System.out.println(listaSiniestros.get(i).getProcurador().getNombres());
//            System.out.println(listaSiniestros.get(i).getProcurador().getApellidoPaterno());
//        }
//        
//    }
    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaSiniestroId = new ArrayList<>();
//        insertarSiniestros(listaSiniestroId);
//        
//        ArrayList<SiniestrosDTO> listaSiniestros = this.siniestroDAO.listarTodos();
//        assertEquals(listaSiniestroId.size()+6, listaSiniestros.size());
//        for (Integer i = 0; i < listaSiniestros.size(); i++) {
//            if(listaSiniestros.get(i).getSiniestroId()>6){
//                listaSiniestros.get(i).setDescripcion("descripcionmodificada");
//                listaSiniestros.get(i).setFechaHora(Timestamp.valueOf("2025-10-08 19:08:17").toLocalDateTime());
//                listaSiniestros.get(i).setEstado(EstadoSiniestro.CANCELADO);
//                listaSiniestros.get(i).setCalificacionServicio(5);
//                listaSiniestros.get(i).setValidez(false);
//                this.siniestroDAO.modificar(listaSiniestros.get(i));
//            }
//        }
//        
//        ArrayList<SiniestrosDTO> listaSiniestrosModificados = this.siniestroDAO.listarTodos();
//        assertEquals(listaSiniestros.size(), listaSiniestrosModificados.size());
//        for (Integer i = 0; i < listaSiniestros.size(); i++) {
//            if(listaSiniestros.get(i).getSiniestroId()>6){
//                assertEquals(listaSiniestros.get(i).getDescripcion(), listaSiniestrosModificados.get(i).getDescripcion());
//                assertEquals(listaSiniestros.get(i).getFechaHora(), listaSiniestrosModificados.get(i).getFechaHora());
//                assertEquals(listaSiniestros.get(i).getEstado(), listaSiniestrosModificados.get(i).getEstado());
//                assertEquals(listaSiniestros.get(i).getCalificacionServicio(), listaSiniestrosModificados.get(i).getCalificacionServicio());
//                assertEquals(listaSiniestros.get(i).getValidez(), listaSiniestrosModificados.get(i).getValidez());
//            }
//        }
//        eliminarTodo();
//    }
    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaSiniestroId = new ArrayList<>();
//        insertarSiniestros(listaSiniestroId);
//        eliminarTodo();
//    }
    
    private void eliminarTodo(){                
        ArrayList<SiniestrosDTO> listaSiniestros = this.siniestroDAO.listarTodos();
        for (Integer i = 0; i < listaSiniestros.size(); i++) {
            if(listaSiniestros.get(i).getSiniestroId()>6){
                Integer resultado = this.siniestroDAO.eliminar(listaSiniestros.get(i));
                assertNotEquals(0, resultado);
                SiniestrosDTO siniestro = this.siniestroDAO.obtenerPorId(listaSiniestros.get(i).getSiniestroId());
                assertNull(siniestro);
            }
        }
    }
    
}
