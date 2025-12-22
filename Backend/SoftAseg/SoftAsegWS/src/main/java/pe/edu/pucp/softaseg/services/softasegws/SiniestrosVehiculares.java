package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.SiniestroVehicularBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.util.TipoDanho;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.services.softasegws.reports.ReporteUtil;

@WebService(serviceName = "SiniestrosVehiculares")
public class SiniestrosVehiculares {

    private SiniestroVehicularBO siniestroVehicularBO;

    public SiniestrosVehiculares() {
        this.siniestroVehicularBO = new SiniestroVehicularBO();
    }

    @WebMethod(operationName = "insertarSiniestrosVehiculares")
    public Integer insertarSiniestrosVehiculares(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaHora") String fechaHora,
            @WebParam(name = "estado") EstadoSiniestro estado,
            @WebParam(name = "calificacionServicio") Integer calificacionServicio,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "procurador") EmpleadosDTO procurador,
            @WebParam(name = "validez") Boolean validez,
            @WebParam(name = "vehiculo") VehiculosDTO vehiculo,
            @WebParam(name = "costoEstimado") Double costoEstimado,
            @WebParam(name = "tallerAsignado") TalleresDTO tallerAsignado,
            @WebParam(name = "danos") String danos,
            @WebParam(name = "conductor") PersonasDTO conductor,
            @WebParam(name = "tipoDano") TipoDanho tipoDano,
            @WebParam(name = "poliza") PolizasVehicularesDTO poliza
    )  {
        SiniestrosVehicularesDTO siniestrosVehicularesDTO = new SiniestrosVehicularesDTO();        
        siniestrosVehicularesDTO.setDescripcion(descripcion);
        siniestrosVehicularesDTO.setFechaHora(LocalDateTime.parse(fechaHora));
        siniestrosVehicularesDTO.setEstado(estado);
        siniestrosVehicularesDTO.setCalificacionServicio(calificacionServicio);
        siniestrosVehicularesDTO.setUbicacion(ubicacion);
        siniestrosVehicularesDTO.setProcurador(procurador);
        siniestrosVehicularesDTO.setValidez(validez);
        siniestrosVehicularesDTO.setVehiculo(vehiculo);
        siniestrosVehicularesDTO.setCostoEstimado(costoEstimado);
        siniestrosVehicularesDTO.setTallerAsignado(tallerAsignado);
        siniestrosVehicularesDTO.setDanos(danos);
        siniestrosVehicularesDTO.setConductor(conductor);        
        siniestrosVehicularesDTO.setTipoDano(tipoDano);
        siniestrosVehicularesDTO.setPoliza(poliza);               
        return this.siniestroVehicularBO.insertar(siniestrosVehicularesDTO);
    }

    @WebMethod(operationName = "obtenerPorIdSiniestrosVehiculares")
    public SiniestrosVehicularesDTO obtenerPorIdSiniestrosVehiculares(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) throws IOException, InterruptedException {
        return this.siniestroVehicularBO.obtenerPorId(siniestroId);
    }

    @WebMethod(operationName = "listarTodosSiniestrosVehiculares")
    public ArrayList<SiniestrosVehicularesDTO> listarTodosSiniestrosVehiculares() throws IOException, InterruptedException {
        return this.siniestroVehicularBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorProcuradorSiniestrosVehiculares")
    public ArrayList<SiniestrosVehicularesDTO> listarPorProcuradorSiniestrosVehiculares(@WebParam(name="idProcurador") Integer idProcurador) throws IOException, InterruptedException {
        return this.siniestroVehicularBO.listarPorProcurador(idProcurador);
    }
    
    @WebMethod(operationName = "modificarSiniestrosVehiculares")
    public Integer modificarSiniestrosVehiculares(
            @WebParam(name = "siniestroId") Integer siniestroId,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaHora") String fechaHora,
            @WebParam(name = "estado") EstadoSiniestro estado,
            @WebParam(name = "calificacionServicio") Integer calificacionServicio,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "procurador") EmpleadosDTO procurador,
            @WebParam(name = "validez") Boolean validez,
            @WebParam(name = "vehiculo") VehiculosDTO vehiculo,
            @WebParam(name = "costoEstimado") Double costoEstimado,
            @WebParam(name = "tallerAsignado") TalleresDTO tallerAsignado,
            @WebParam(name = "danos") String danos,
            @WebParam(name = "conductor") PersonasDTO conductor,
            @WebParam(name = "tipoDano") TipoDanho tipoDano,
            @WebParam(name = "poliza") PolizasVehicularesDTO poliza
    )  {
        SiniestrosVehicularesDTO siniestrosVehicularesDTO = new SiniestrosVehicularesDTO();        
        siniestrosVehicularesDTO.setSiniestroId(siniestroId);
        siniestrosVehicularesDTO.setDescripcion(descripcion);
        siniestrosVehicularesDTO.setFechaHora(LocalDateTime.parse(fechaHora));
        siniestrosVehicularesDTO.setEstado(estado);
        siniestrosVehicularesDTO.setCalificacionServicio(calificacionServicio);
        siniestrosVehicularesDTO.setUbicacion(ubicacion);
        siniestrosVehicularesDTO.setProcurador(procurador);
        siniestrosVehicularesDTO.setValidez(validez);
        siniestrosVehicularesDTO.setVehiculo(vehiculo);
        siniestrosVehicularesDTO.setCostoEstimado(costoEstimado);
        siniestrosVehicularesDTO.setTallerAsignado(tallerAsignado);
        siniestrosVehicularesDTO.setDanos(danos);
        siniestrosVehicularesDTO.setConductor(conductor);        
        siniestrosVehicularesDTO.setTipoDano(tipoDano);
        siniestrosVehicularesDTO.setPoliza(poliza);    
        return this.siniestroVehicularBO.modificar(siniestrosVehicularesDTO);
    }

    @WebMethod(operationName = "eliminarSiniestrosVehiculares")
    public Integer eliminarSiniestrosVehiculares(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) throws IOException, InterruptedException {
        return this.siniestroVehicularBO.eliminar(siniestroId);
    }
    
    @WebMethod(operationName = "reporteSiniestrosVehiculares")
    public byte[] reporteSiniestroVehicular (@WebParam(name = "siniestroId")Integer siniestroId){
        return ReporteUtil.reporteSiniestroVehicular(siniestroId);
    }
}
