package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.CentroDeSaludBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

@WebService(serviceName = "CentrosDeSalud")
public class CentrosDeSalud {

    private CentroDeSaludBO centroDeSaludBO;

    public CentrosDeSalud() {
        this.centroDeSaludBO = new CentroDeSaludBO();
    }

    @WebMethod(operationName = "insertarCentrosDeSalud")
    public Integer insertarCentrosDeSalud(
            @WebParam(name = "codigoRenipress") String codigoRenipress,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "telefono") String telefono
    )  {
        
        CentrosDeSaludDTO centrosDeSaludDTO = new CentrosDeSaludDTO();
        centrosDeSaludDTO.setCodigoRenipress(codigoRenipress);
        centrosDeSaludDTO.setNombre(nombre);
        centrosDeSaludDTO.setUbicacion(ubicacion);
        centrosDeSaludDTO.setTelefono(telefono);        
                
        return this.centroDeSaludBO.insertar(centrosDeSaludDTO);
    }

    @WebMethod(operationName = "obtenerPorIdCentrosDeSalud")
    public CentrosDeSaludDTO obtenerPorIdCentrosDeSalud(@WebParam(name = "centroDeSaludId") Integer centroDeSaludId)
            throws IOException, InterruptedException {
        return this.centroDeSaludBO.obtenerPorId(centroDeSaludId);
    }

    @WebMethod(operationName = "listarTodosCentrosDeSalud")
    public ArrayList<CentrosDeSaludDTO> listarTodosCentrosDeSalud() throws IOException, InterruptedException {
        return this.centroDeSaludBO.listarTodos();
    }

    @WebMethod(operationName = "modificarCentrosDeSalud")
    public Integer modificarCentrosDeSalud(
            @WebParam(name = "centroDeSaludId") Integer centroDeSaludId,
            @WebParam(name = "codigoRenipress") String codigoRenipress,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "telefono") String telefono
    )  {
        CentrosDeSaludDTO centrosDeSaludDTO = new CentrosDeSaludDTO();
        centrosDeSaludDTO.setCentroDeSaludId(centroDeSaludId);
        centrosDeSaludDTO.setCodigoRenipress(codigoRenipress);
        centrosDeSaludDTO.setNombre(nombre);
        centrosDeSaludDTO.setUbicacion(ubicacion);
        centrosDeSaludDTO.setTelefono(telefono);  
        return this.centroDeSaludBO.modificar(centrosDeSaludDTO);
    }

    @WebMethod(operationName = "eliminarCentrosDeSalud")
    public Integer eliminarCentrosDeSalud(@WebParam(name = "centroDeSaludId") Integer centroDeSaludId)
            throws IOException, InterruptedException {
        return this.centroDeSaludBO.eliminar(centroDeSaludId);
    }
    
    
    @WebMethod(operationName = "listarPorNombreCodigoRENIPRESS")
    public ArrayList<CentrosDeSaludDTO> listarPorNombreCodigoRENIPRESS(@WebParam(name = "filtro") String filtroCentroSalud)
            throws IOException, InterruptedException {
        return this.centroDeSaludBO.listarPorNombreCodigoRENIPRESS(filtroCentroSalud);
    }
}
