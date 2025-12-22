package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.TallerBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

@WebService(serviceName = "Talleres")
public class Talleres {

    private TallerBO tallerBO;

    public Talleres() {
        this.tallerBO = new TallerBO();
    }

    @WebMethod(operationName = "insertarTalleres")
    public Integer insertarTalleres(
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "telefono") String telefono
    )  {
        TalleresDTO talleresDTO = new TalleresDTO();
        talleresDTO.setNombre(nombre);
        talleresDTO.setUbicacion(ubicacion);
        talleresDTO.setTelefono(telefono);        
        return this.tallerBO.insertar(talleresDTO);
    }

    @WebMethod(operationName = "obtenerPorIdTalleres")
    public TalleresDTO obtenerPorIdTalleres(
            @WebParam(name = "tallerId") Integer tallerId
    ) throws IOException, InterruptedException {
        return this.tallerBO.obtenerPorId(tallerId);
    }

    @WebMethod(operationName = "listarTodosTalleres")
    public ArrayList<TalleresDTO> listarTodosTalleres() {
        return this.tallerBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorNombreTalleres")
    public ArrayList<TalleresDTO> listarPorNombreTalleres(
            @WebParam(name = "nombre") String nombre
    ) {
        return this.tallerBO.listarPorNombre(nombre);
    }

    @WebMethod(operationName = "modificarTalleres")
    public Integer modificarTalleres(
            @WebParam(name = "tallerId") Integer tallerId,
            @WebParam(name = "nombre") String nombre,
            @WebParam(name = "ubicacion") UbicacionesDTO ubicacion,
            @WebParam(name = "telefono") String telefono
    )  {
        TalleresDTO talleresDTO = new TalleresDTO();
        talleresDTO.setTallerId(tallerId);
        talleresDTO.setNombre(nombre);
        talleresDTO.setUbicacion(ubicacion);
        talleresDTO.setTelefono(telefono);
        return this.tallerBO.modificar(talleresDTO);
    }

    @WebMethod(operationName = "eliminarTalleres")
    public Integer eliminarTalleres(
            @WebParam(name = "tallerId") Integer tallerId
    ) throws IOException, InterruptedException {
        return this.tallerBO.eliminar(tallerId);
    }
}
