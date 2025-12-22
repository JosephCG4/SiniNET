
package pe.edu.pucp.softaseg.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;


public class SiniestroSOATBOTest {
    
    private SiniestroSOATBO siniestroSOATBO;
    
    public SiniestroSOATBOTest() {
        this.siniestroSOATBO = new SiniestroSOATBO();
    }
    
//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        UbicacionesDTO ubicacionesDTO = new UbicacionesDTO();
//        ubicacionesDTO.setDireccion("direccionTest");
//        ubicacionesDTO.setReferencia("referenciaTest");
//        ubicacionesDTO.setLatitud(117.14);
//        ubicacionesDTO.setLongitud(89.54);
//        
//        SiniestrosSOATDTO siniestrosSOATDTO = new SiniestrosSOATDTO();
//        EmpleadosDTO procurador = new EmpleadosDTO();
//        siniestrosSOATDTO.setDescripcion("descripciontest");
//        siniestrosSOATDTO.setFechaHora(LocalDateTime.now());
//        siniestrosSOATDTO.setEstado(EstadoSiniestro.EN_PROCESO);
//        siniestrosSOATDTO.setCalificacionServicio(1);
//        siniestrosSOATDTO.setUbicacion(ubicacionesDTO);
//        siniestrosSOATDTO.setProcurador(procurador);
//        siniestrosSOATDTO.getProcurador().setPersonalId(1);
//        siniestrosSOATDTO.setValidez(Boolean.TRUE);
//        
//        CentrosDeSaludDTO centrosDeSaludDTO = new CentrosDeSaludDTO();
//        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();
//        siniestrosSOATDTO.setCentroDeSalud(centrosDeSaludDTO);
//        siniestrosSOATDTO.getCentroDeSalud().setCentroDeSaludId(1);
//        siniestrosSOATDTO.setGastosMedicos(1050.60);
//        siniestrosSOATDTO.setDiagnostico("diagnosticoTest");
//        siniestrosSOATDTO.setPoliza(polizasSOATDTO);
//        siniestrosSOATDTO.getPoliza().setPolizaId(1);
//        
//        Integer SiniestroSOATId = this.siniestroSOATBO.insertar(siniestrosSOATDTO);
//        
//        System.out.println("ObtenerPorId:");
//        siniestrosSOATDTO = this.siniestroSOATBO.obtenerPorId(SiniestroSOATId);
//        System.out.println(siniestrosSOATDTO.getSiniestroId());
//        System.out.println(siniestrosSOATDTO.getDescripcion());
//        System.out.println(siniestrosSOATDTO.getFechaHora());
//        System.out.println(siniestrosSOATDTO.getEstado());
//        System.out.println(siniestrosSOATDTO.getCalificacionServicio());
//        System.out.println(siniestrosSOATDTO.getUbicacion().getUbicacionId());
//        System.out.println(siniestrosSOATDTO.getValidez());
//        System.out.println(siniestrosSOATDTO.getCentroDeSalud().getCentroDeSaludId());
//        System.out.println(siniestrosSOATDTO.getGastosMedicos());
//        System.out.println(siniestrosSOATDTO.getDiagnostico());
//        System.out.println(siniestrosSOATDTO.getPoliza().getPolizaId());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<SiniestrosSOATDTO> listaSiniestrosSOATDTO = this.siniestroSOATBO.listarTodos();
//        for (Integer i = 0; i < listaSiniestrosSOATDTO.size(); i++){
//            System.out.println(listaSiniestrosSOATDTO.get(i).getSiniestroId());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getDescripcion());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getFechaHora());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getEstado());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getCalificacionServicio());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getUbicacion().getUbicacionId());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getValidez());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getCentroDeSalud().getCentroDeSaludId());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getGastosMedicos());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getDiagnostico());
//            System.out.println(listaSiniestrosSOATDTO.get(i).getPoliza().getPolizaId());
//        }
//        
//        System.out.println("Modificar:");
//        ubicacionesDTO.setDireccion("direccionMod");
//        ubicacionesDTO.setReferencia("referenciaMod");
//        ubicacionesDTO.setLatitud(99.99);
//        ubicacionesDTO.setLongitud(99.99);
//        
//        siniestrosSOATDTO.setDescripcion("descripcionMod");
//        siniestrosSOATDTO.setFechaHora(LocalDateTime.now());
//        siniestrosSOATDTO.setEstado(EstadoSiniestro.CANCELADO);
//        siniestrosSOATDTO.setCalificacionServicio(2);
//        siniestrosSOATDTO.setUbicacion(ubicacionesDTO);
//        siniestrosSOATDTO.getProcurador().setPersonalId(2);
//        siniestrosSOATDTO.setValidez(Boolean.FALSE);
//        
//        siniestrosSOATDTO.getCentroDeSalud().setCentroDeSaludId(2);
//        siniestrosSOATDTO.setGastosMedicos(20.20);
//        siniestrosSOATDTO.setDiagnostico("diagnosticoModificado");
//        siniestrosSOATDTO.getPoliza().setPolizaId(2);
//        
//        
//        this.siniestroSOATBO.modificar(siniestrosSOATDTO);
//        siniestrosSOATDTO = this.siniestroSOATBO.obtenerPorId(SiniestroSOATId);
//        System.out.println(siniestrosSOATDTO.getSiniestroId());
//        System.out.println(siniestrosSOATDTO.getDescripcion());
//        System.out.println(siniestrosSOATDTO.getFechaHora());
//        System.out.println(siniestrosSOATDTO.getEstado());
//        System.out.println(siniestrosSOATDTO.getCalificacionServicio());
//        System.out.println(siniestrosSOATDTO.getUbicacion().getUbicacionId());
//        System.out.println(siniestrosSOATDTO.getValidez());
//        System.out.println(siniestrosSOATDTO.getCentroDeSalud().getCentroDeSaludId());
//        System.out.println(siniestrosSOATDTO.getGastosMedicos());
//        System.out.println(siniestrosSOATDTO.getDiagnostico());
//        System.out.println(siniestrosSOATDTO.getPoliza().getPolizaId());
//        
//        System.out.println("Eliminar:");
//        this.siniestroSOATBO.eliminar(SiniestroSOATId);
//        siniestrosSOATDTO = this.siniestroSOATBO.obtenerPorId(SiniestroSOATId);
//        assertNull(siniestrosSOATDTO);
//    }
}
