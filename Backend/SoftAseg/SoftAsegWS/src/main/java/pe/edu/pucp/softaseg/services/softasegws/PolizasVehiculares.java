package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.PolizaVehicularBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.util.TipoPolizaVehicular;

@WebService(serviceName = "PolizasVehiculares")
public class PolizasVehiculares {

    private PolizaVehicularBO polizaVehicularBO;

    public PolizasVehiculares() {
        this.polizaVehicularBO = new PolizaVehicularBO();
    }

    @WebMethod(operationName = "insertarPolizasVehiculares")
    public Integer insertarPolizasVehiculares(
            @WebParam(name = "asegurado") PersonasDTO asegurado,
            @WebParam(name = "estado") EstadoPoliza estado,
            @WebParam(name = "tipo") TipoPolizaVehicular tipo,
            @WebParam(name = "porcentajeCobertura") Integer porcentajeCobertura
    )  {
        PolizasVehicularesDTO polizasVehicularesDTO = new PolizasVehicularesDTO();        
        polizasVehicularesDTO.setAsegurado(asegurado);        
        polizasVehicularesDTO.setEstado(estado);
        polizasVehicularesDTO.setTipo(tipo);
        polizasVehicularesDTO.setPorcentajeCobertura(porcentajeCobertura);        
        return this.polizaVehicularBO.insertar(polizasVehicularesDTO);
    }

    @WebMethod(operationName = "obtenerPorIdPolizasVehiculares")
    public PolizasVehicularesDTO obtenerPorIdPolizasVehiculares(
            @WebParam(name = "polizaId") Integer polizaId
    ) throws IOException, InterruptedException {
        return this.polizaVehicularBO.obtenerPorId(polizaId);
    }

    @WebMethod(operationName = "listarTodosPolizasVehiculares")
    public ArrayList<PolizasVehicularesDTO> listarTodosPolizasVehiculares() throws IOException, InterruptedException {
        return this.polizaVehicularBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorNombreApellidoAseguradoPolizasVehiculares")
    public ArrayList<PolizasVehicularesDTO> listarPorNombreApellidoAseguradoPolizasVehiculares(
            @WebParam(name = "filtro") String filtro)
            throws IOException, InterruptedException {
        return this.polizaVehicularBO.listarPorNombreApellidoAsegurado(filtro);
    }

    @WebMethod(operationName = "modificarPolizasVehiculares")
    public Integer modificarPolizasVehiculares(
            @WebParam(name = "polizaId") Integer polizaId,
            @WebParam(name = "asegurado") PersonasDTO asegurado,
            @WebParam(name = "estado") EstadoPoliza estado,
            @WebParam(name = "tipo") TipoPolizaVehicular tipo,
            @WebParam(name = "porcentajeCobertura") Integer porcentajeCobertura
    )  {
        PolizasVehicularesDTO polizasVehicularesDTO = new PolizasVehicularesDTO();     
        polizasVehicularesDTO.setPolizaId(polizaId);
        polizasVehicularesDTO.setAsegurado(asegurado);        
        polizasVehicularesDTO.setEstado(estado);
        polizasVehicularesDTO.setTipo(tipo);
        polizasVehicularesDTO.setPorcentajeCobertura(porcentajeCobertura);
        return this.polizaVehicularBO.modificar(polizasVehicularesDTO);
    }

    @WebMethod(operationName = "eliminarPolizasVehiculares")
    public Integer eliminarPolizasVehiculares(
            @WebParam(name = "polizaId") Integer polizaId
    ) throws IOException, InterruptedException {
        return this.polizaVehicularBO.eliminar(polizaId);
    }
}
