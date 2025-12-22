
package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.InvolucradoBO;
import pe.edu.pucp.softaseg.model.usuarios.InvolucradosDTO;
import pe.edu.pucp.softaseg.model.util.TipoInvolucrado;

@WebService(serviceName = "Involucrados")
public class Involucrados {
    
    private InvolucradoBO involucradoBO;

    public Involucrados() {
        this.involucradoBO = new InvolucradoBO();
    }
    
    @WebMethod(operationName = "insertarInvolucrados")
    public Integer insertarInvolucrados(
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "tipo") TipoInvolucrado tipo
    )  {
        InvolucradosDTO involucradoDTO = new InvolucradosDTO();        
        involucradoDTO.setDni(dni);
        involucradoDTO.setNombres(nombres);
        involucradoDTO.setApellidoPaterno(apellidoPaterno);
        involucradoDTO.setApellidoMaterno(apellidoMaterno);
        involucradoDTO.setTelefono(telefono);
        involucradoDTO.setTipo(tipo);        
        return this.involucradoBO.insertar(involucradoDTO);
    }

    @WebMethod(operationName = "obtenerPorIdInvolucrados")
    public InvolucradosDTO obtenerPorIdInvolucrados(@WebParam(name = "empleadoId") Integer involucradoId)
            throws IOException, InterruptedException {
        return this.involucradoBO.obtenerPorId(involucradoId);
    }

    @WebMethod(operationName = "listarTodosInvolucrados")
    public ArrayList<InvolucradosDTO> listarTodosInvolucrados() throws IOException, InterruptedException {
        return this.involucradoBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarTodosAseguradosInvolucrados")
    public ArrayList<InvolucradosDTO> listarTodosAseguradosInvolucrados() throws IOException, InterruptedException {
        return this.involucradoBO.listarTodosAsegurados();
    }
    @WebMethod(operationName = "listarPorNombreApellidoPaternoInvolucrados")
    public ArrayList<InvolucradosDTO> listarPorNombreApellidoPaternoInvolucrados(
            @WebParam(name = "filtro") String filtro)
            throws IOException, InterruptedException {
        return this.involucradoBO.listarPorNombreApellidoPaterno(filtro);
    }
    @WebMethod(operationName = "modificarInvolucrados")
    public Integer modificarInvolucrados(
            @WebParam(name = "personalId") Integer personalId,
             @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "tipo") TipoInvolucrado tipo
    )  {
        InvolucradosDTO involucradoDTO = new InvolucradosDTO();        
        involucradoDTO.setPersonalId(personalId);
        involucradoDTO.setDni(dni);
        involucradoDTO.setNombres(nombres);
        involucradoDTO.setApellidoPaterno(apellidoPaterno);
        involucradoDTO.setApellidoMaterno(apellidoMaterno);
        involucradoDTO.setTelefono(telefono);
        involucradoDTO.setTipo(tipo);       
        return this.involucradoBO.modificar(involucradoDTO);
    }

    @WebMethod(operationName = "eliminarInvolucrados")
    public Integer eliminarInvolucrados(@WebParam(name = "involucradoId") Integer involucradoId)
            throws IOException, InterruptedException {
        return this.involucradoBO.eliminar(involucradoId);
    }
    
}
