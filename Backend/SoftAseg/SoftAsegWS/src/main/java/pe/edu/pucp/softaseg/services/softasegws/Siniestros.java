package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.SiniestroBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosDTO;

@WebService(serviceName = "Siniestros")
public class Siniestros {

    private SiniestroBO siniestroBO;

    public Siniestros() {
        this.siniestroBO = new SiniestroBO();
    }

    @WebMethod(operationName = "listarTodosSiniestros")
    public ArrayList<SiniestrosDTO> listarTodos() throws IOException, InterruptedException {
        return this.siniestroBO.listarTodos();
    }
    
    @WebMethod(operationName = "obtenerPorIdSiniestros")
    public SiniestrosDTO obtenerPorIdSiniestros(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) throws IOException, InterruptedException {
        return this.siniestroBO.obtenerPorId(siniestroId);
    }
    
    @WebMethod(operationName = "listarPorEmpleadoSiniestros")
    public ArrayList<SiniestrosDTO> listarPorEmpleado(@WebParam(name="filtro") String filtro) throws IOException, InterruptedException {
        return this.siniestroBO.listarPorEmpleado(filtro);
    }
}
