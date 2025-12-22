package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.SiniestroSOATBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.services.softasegws.reports.ReporteUtil;

@WebService(serviceName = "SiniestrosSOAT")
public class SiniestrosSOAT {

    private SiniestroSOATBO siniestroSOATBO;

    public SiniestrosSOAT() {
        this.siniestroSOATBO = new SiniestroSOATBO();
    }

    @WebMethod(operationName = "insertarSiniestrosSOAT")
    public Integer insertarSiniestrosSOAT(
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaHora") String fechaHora,
            @WebParam(name = "estado") EstadoSiniestro estado,
            @WebParam(name = "calificacionReporte") Integer calificacionReporte,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "procurador") EmpleadosDTO procurador,
            @WebParam(name = "validez") Boolean validez,
            @WebParam(name = "centroDeSalud") CentrosDeSaludDTO centroDeSalud,
            @WebParam(name = "gastosMedicos") Double gastosMedicos,
            @WebParam(name = "diagnostico") String diagnostico,
            @WebParam(name = "afectados") ArrayList<PersonasDTO> afectados,
            @WebParam(name = "poliza") PolizasSOATDTO poliza
    )  {
        SiniestrosSOATDTO siniestroSOATDTO = new SiniestrosSOATDTO();        
        siniestroSOATDTO.setDescripcion(descripcion);
        siniestroSOATDTO.setFechaHora(LocalDateTime.parse(fechaHora));
        siniestroSOATDTO.setEstado(estado);
        siniestroSOATDTO.setCalificacionServicio(calificacionReporte);
        siniestroSOATDTO.setUbicacion(ubicacion);        
        siniestroSOATDTO.setProcurador(procurador);
        siniestroSOATDTO.setValidez(validez);
        siniestroSOATDTO.setCentroDeSalud(centroDeSalud);
        siniestroSOATDTO.setGastosMedicos(gastosMedicos);
        siniestroSOATDTO.setDiagnostico(diagnostico);
        siniestroSOATDTO.setAfectados(afectados);
        siniestroSOATDTO.setPoliza(poliza);                       
        return this.siniestroSOATBO.insertar(siniestroSOATDTO);
    }

    @WebMethod(operationName = "obtenerPorIdSiniestrosSOAT")
    public SiniestrosSOATDTO obtenerPorIdSiniestrosSOAT(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) throws IOException, InterruptedException {
        return this.siniestroSOATBO.obtenerPorId(siniestroId);
    }

    @WebMethod(operationName = "listarTodosSiniestrosSOAT")
    public ArrayList<SiniestrosSOATDTO> listarTodosSiniestrosSOAT() throws IOException, InterruptedException {
        return this.siniestroSOATBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorProcuradorSiniestrosSOAT")
    public ArrayList<SiniestrosSOATDTO> listarPorProcuradorSiniestrosSOAT(@WebParam(name="idProcurador") Integer idProcurador) throws IOException, InterruptedException {
        return this.siniestroSOATBO.listarPorProcurador(idProcurador);
    }

    @WebMethod(operationName = "modificarSiniestrosSOAT")
    public Integer modificarSiniestrosSOAT(
            @WebParam(name = "siniestroId") Integer siniestroId,
            @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "fechaHora") String fechaHora,
            @WebParam(name = "estado") EstadoSiniestro estado,
            @WebParam(name = "calificacionReporte") Integer calificacionReporte,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "procurador") EmpleadosDTO procurador,
            @WebParam(name = "validez") Boolean validez,
            @WebParam(name = "centroDeSalud") CentrosDeSaludDTO centroDeSalud,
            @WebParam(name = "gastosMedicos") Double gastosMedicos,
            @WebParam(name = "diagnostico") String diagnostico,
            @WebParam(name = "afectados") ArrayList<PersonasDTO> afectados,
            @WebParam(name = "poliza") PolizasSOATDTO poliza
    )  {
        SiniestrosSOATDTO siniestroSOATDTO = new SiniestrosSOATDTO();        
        siniestroSOATDTO.setSiniestroId(siniestroId);
        siniestroSOATDTO.setDescripcion(descripcion);
        siniestroSOATDTO.setFechaHora(LocalDateTime.parse(fechaHora));
        siniestroSOATDTO.setEstado(estado);
        siniestroSOATDTO.setCalificacionServicio(calificacionReporte);
        siniestroSOATDTO.setUbicacion(ubicacion);        
        siniestroSOATDTO.setProcurador(procurador);
        siniestroSOATDTO.setValidez(validez);
        siniestroSOATDTO.setCentroDeSalud(centroDeSalud);
        siniestroSOATDTO.setGastosMedicos(gastosMedicos);
        siniestroSOATDTO.setDiagnostico(diagnostico);
        siniestroSOATDTO.setAfectados(afectados);
        siniestroSOATDTO.setPoliza(poliza);  
        return this.siniestroSOATBO.modificar(siniestroSOATDTO);
    }

    @WebMethod(operationName = "eliminarSiniestrosSOAT")
    public Integer eliminarSiniestrosSOAT(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) throws IOException, InterruptedException {
        return this.siniestroSOATBO.eliminar(siniestroId);
    }
    
    @WebMethod(operationName = "reporteSiniestrosSOAT")
    public byte[] reporteSiniestroSOAT (@WebParam(name = "siniestroId")Integer siniestroId){
        return ReporteUtil.reporteSiniestroSOAT(siniestroId);
    }
}
