package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.PolizaSOATBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;

@WebService(serviceName = "PolizasSOAT")
public class PolizasSOAT {

    private PolizaSOATBO polizaSOATBO;

    public PolizasSOAT() {
        this.polizaSOATBO = new PolizaSOATBO();
    }

    @WebMethod(operationName = "insertarPolizasSOAT")
    public Integer insertarPolizasSOAT(
            @WebParam(name = "asegurado") PersonasDTO asegurado,
            @WebParam(name = "estado") EstadoPoliza estado,
            @WebParam(name = "montoACobertura") Integer montoACobertura
    )  {
        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();        
        polizasSOATDTO.setAsegurado(asegurado);        
        polizasSOATDTO.setEstado(estado);
        polizasSOATDTO.setMontoACobertura(montoACobertura);        
        return this.polizaSOATBO.insertar(polizasSOATDTO);
    }

    @WebMethod(operationName = "obtenerPorIdPolizasSOAT")
    public PolizasSOATDTO obtenerPorIdPolizasSOAT(
            @WebParam(name = "polizaId") Integer polizaId
    ) throws IOException, InterruptedException {
        return this.polizaSOATBO.obtenerPorId(polizaId);
    }

    @WebMethod(operationName = "listarTodosPolizasSOAT")
    public ArrayList<PolizasSOATDTO> listarTodosPolizasSOAT() throws IOException, InterruptedException {
        return this.polizaSOATBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorNombreApellidoAseguradoPolizasSOAT")
    public ArrayList<PolizasSOATDTO> listarPorNombreApellidoAseguradoPolizasSOAT(
            @WebParam(name = "filtro") String filtro)
            throws IOException, InterruptedException {
        return this.polizaSOATBO.listarPorNombreApellidoAsegurado(filtro);
    }

    @WebMethod(operationName = "modificarPolizasSOAT")
    public Integer modificarPolizasSOAT(
            @WebParam(name = "polizaId") Integer polizaId,
            @WebParam(name = "asegurado") PersonasDTO asegurado,
            @WebParam(name = "estado") EstadoPoliza estado,
            @WebParam(name = "montoACobertura") Integer montoACobertura
    )  {
        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();        
        polizasSOATDTO.setPolizaId(polizaId);
        polizasSOATDTO.setAsegurado(asegurado);        
        polizasSOATDTO.setEstado(estado);
        polizasSOATDTO.setMontoACobertura(montoACobertura);
        return this.polizaSOATBO.modificar(polizasSOATDTO);
    }

    @WebMethod(operationName = "eliminarPolizasSOAT")
    public Integer eliminarPolizasSOAT(
            @WebParam(name = "polizaId") Integer polizaId
    ) throws IOException, InterruptedException {
        return this.polizaSOATBO.eliminar(polizaId);
    }
}