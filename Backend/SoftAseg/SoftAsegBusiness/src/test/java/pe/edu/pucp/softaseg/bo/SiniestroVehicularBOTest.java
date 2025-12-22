
package pe.edu.pucp.softaseg.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.util.TipoDanho;

public class SiniestroVehicularBOTest {
    
    private SiniestroVehicularBO siniestroVehicularBO;
    
    public SiniestroVehicularBOTest() {
        this.siniestroVehicularBO = new SiniestroVehicularBO();
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
//        SiniestrosVehicularesDTO siniestrosVehicularesDTO = new SiniestrosVehicularesDTO();
//        EmpleadosDTO procurador = new EmpleadosDTO();
//        siniestrosVehicularesDTO.setDescripcion("descripciontest");
//        siniestrosVehicularesDTO.setFechaHora(LocalDateTime.now());
//        siniestrosVehicularesDTO.setEstado(EstadoSiniestro.EN_PROCESO);
//        siniestrosVehicularesDTO.setCalificacionServicio(1);
//        siniestrosVehicularesDTO.setUbicacion(ubicacionesDTO);
//        siniestrosVehicularesDTO.setProcurador(procurador);
//        siniestrosVehicularesDTO.getProcurador().setPersonalId(1);
//        siniestrosVehicularesDTO.setValidez(Boolean.TRUE);
//        
//        VehiculosDTO vehiculosDTO = new VehiculosDTO();
//        TalleresDTO talleresDTO = new TalleresDTO();
//        PersonasDTO conductor = new PersonasDTO();
//        PolizasVehicularesDTO poliza = new PolizasVehicularesDTO();
//        siniestrosVehicularesDTO.setVehiculo(vehiculosDTO);
//        siniestrosVehicularesDTO.getVehiculo().setVehiculoId(1);
//        siniestrosVehicularesDTO.setCostoEstimado(100.10);
//        siniestrosVehicularesDTO.setTallerAsignado(talleresDTO);
//        siniestrosVehicularesDTO.getTallerAsignado().setTallerId(1);
//        siniestrosVehicularesDTO.setDanos("danhosTest");
//        siniestrosVehicularesDTO.setConductor(conductor);
//        siniestrosVehicularesDTO.getConductor().setPersonalId(1);
//        siniestrosVehicularesDTO.setTipoDano(TipoDanho.FUERTE);
//        siniestrosVehicularesDTO.setPoliza(poliza);
//        siniestrosVehicularesDTO.getPoliza().setPolizaId(1);
//        Integer SiniestroVehicularId = this.siniestroVehicularBO.insertar(siniestrosVehicularesDTO);
//        
//        System.out.println("ObtenerPorId:");
//        siniestrosVehicularesDTO = this.siniestroVehicularBO.obtenerPorId(SiniestroVehicularId);
//        System.out.println(siniestrosVehicularesDTO.getSiniestroId());
//        System.out.println(siniestrosVehicularesDTO.getDescripcion());
//        System.out.println(siniestrosVehicularesDTO.getFechaHora());
//        System.out.println(siniestrosVehicularesDTO.getEstado());
//        System.out.println(siniestrosVehicularesDTO.getCalificacionServicio());
//        System.out.println(siniestrosVehicularesDTO.getUbicacion().getUbicacionId());
//        System.out.println(siniestrosVehicularesDTO.getValidez());
//        System.out.println(siniestrosVehicularesDTO.getVehiculo().getVehiculoId());
//        System.out.println(siniestrosVehicularesDTO.getCostoEstimado());
//        System.out.println(siniestrosVehicularesDTO.getTallerAsignado().getTallerId());
//        System.out.println(siniestrosVehicularesDTO.getDanos());
//        System.out.println(siniestrosVehicularesDTO.getTipoDano());
//        System.out.println(siniestrosVehicularesDTO.getPoliza().getPolizaId());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<SiniestrosVehicularesDTO> listaSiniestrosVehicularesDTO = this.siniestroVehicularBO.listarTodos();
//        for (Integer i = 0; i < listaSiniestrosVehicularesDTO.size(); i++){
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getSiniestroId());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getDescripcion());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getFechaHora());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getEstado());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getCalificacionServicio());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getUbicacion().getUbicacionId());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getValidez());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getVehiculo().getVehiculoId());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getCostoEstimado());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getTallerAsignado().getTallerId());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getDanos());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getTipoDano());
//            System.out.println(listaSiniestrosVehicularesDTO.get(i).getPoliza().getPolizaId());
//        }
//        
//        System.out.println("Modificar:");
//        ubicacionesDTO.setDireccion("direccionMod");
//        ubicacionesDTO.setReferencia("referenciaMod");
//        ubicacionesDTO.setLatitud(99.99);
//        ubicacionesDTO.setLongitud(99.99);
//        
//        siniestrosVehicularesDTO.setDescripcion("descripcionMod");
//        siniestrosVehicularesDTO.setFechaHora(LocalDateTime.now());
//        siniestrosVehicularesDTO.setEstado(EstadoSiniestro.CANCELADO);
//        siniestrosVehicularesDTO.setCalificacionServicio(2);
//        siniestrosVehicularesDTO.setUbicacion(ubicacionesDTO);
//        siniestrosVehicularesDTO.getProcurador().setPersonalId(2);
//        siniestrosVehicularesDTO.setValidez(Boolean.FALSE);
//        
//        siniestrosVehicularesDTO.getVehiculo().setVehiculoId(2);
//        siniestrosVehicularesDTO.setCostoEstimado(200.20);
//        siniestrosVehicularesDTO.getTallerAsignado().setTallerId(2);
//        siniestrosVehicularesDTO.setDanos("danhosModificados");
//        siniestrosVehicularesDTO.getConductor().setPersonalId(2);
//        siniestrosVehicularesDTO.setTipoDano(TipoDanho.MEDIANO);
//        siniestrosVehicularesDTO.getPoliza().setPolizaId(2);
//        
//        this.siniestroVehicularBO.modificar(siniestrosVehicularesDTO);
//        
//        siniestrosVehicularesDTO = this.siniestroVehicularBO.obtenerPorId(SiniestroVehicularId);
//        System.out.println(siniestrosVehicularesDTO.getSiniestroId());
//        System.out.println(siniestrosVehicularesDTO.getDescripcion());
//        System.out.println(siniestrosVehicularesDTO.getFechaHora());
//        System.out.println(siniestrosVehicularesDTO.getEstado());
//        System.out.println(siniestrosVehicularesDTO.getCalificacionServicio());
//        System.out.println(siniestrosVehicularesDTO.getUbicacion().getUbicacionId());
//        System.out.println(siniestrosVehicularesDTO.getValidez());
//        System.out.println(siniestrosVehicularesDTO.getVehiculo().getVehiculoId());
//        System.out.println(siniestrosVehicularesDTO.getCostoEstimado());
//        System.out.println(siniestrosVehicularesDTO.getTallerAsignado().getTallerId());
//        System.out.println(siniestrosVehicularesDTO.getDanos());
//        System.out.println(siniestrosVehicularesDTO.getTipoDano());
//        System.out.println(siniestrosVehicularesDTO.getPoliza().getPolizaId());
//        
//        System.out.println("Eliminar:");
//        this.siniestroVehicularBO.eliminar(SiniestroVehicularId);
//        siniestrosVehicularesDTO = this.siniestroVehicularBO.obtenerPorId(SiniestroVehicularId);
//        assertNull(siniestrosVehicularesDTO);
//    }
    
}
