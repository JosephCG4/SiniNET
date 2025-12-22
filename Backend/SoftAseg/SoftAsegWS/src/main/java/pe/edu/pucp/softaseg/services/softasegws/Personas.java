package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.PersonaBO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

@WebService(serviceName = "Personas")
public class Personas {

    private PersonaBO personaBO;

    public Personas() {
        this.personaBO = new PersonaBO();
    }

    @WebMethod(operationName = "insertarPersonas")
    public Integer insertarPersonas(
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono
    )  {
        PersonasDTO personaDTO = new PersonasDTO();
        personaDTO.setDni(dni);
        personaDTO.setNombres(nombres);
        personaDTO.setApellidoPaterno(apellidoPaterno);
        personaDTO.setApellidoMaterno(apellidoMaterno);
        personaDTO.setTelefono(telefono);
        return this.personaBO.insertar(personaDTO);
    }

    @WebMethod(operationName = "obtenerPorIdPersonas")
    public PersonasDTO obtenerPorIdPersonas(
            @WebParam(name = "personalId") Integer personalId
    ) throws IOException, InterruptedException {
        return this.personaBO.obtenerPorId(personalId);
    }

    @WebMethod(operationName = "listarTodosPersonas")
    public ArrayList<PersonasDTO> listarTodosPersonas() throws IOException, InterruptedException {
        return this.personaBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarAseguradosPorSiniestro")
    public ArrayList<PersonasDTO> listarAseguradosPorSiniestro(
            @WebParam(name = "idSiniestro") Integer idSiniestro
    ) throws IOException, InterruptedException {
        return this.personaBO.listarAseguradosPorSiniestro(idSiniestro);
    }
    
    @WebMethod(operationName = "listarPorNombresApellidosDniPersona")
    public ArrayList<PersonasDTO> listarPorNombresApellidosDniPersona(
            @WebParam(name = "filtro") String filtro
    ) throws IOException, InterruptedException {
        return this.personaBO.listarPorNombresApellidosDni(filtro);
    }

    @WebMethod(operationName = "modificarPersonas")
    public Integer modificarPersonas(
            @WebParam(name = "personalId") Integer personalId,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono
    )  {
        PersonasDTO personaDTO = new PersonasDTO();
        personaDTO.setPersonalId(personalId);
        personaDTO.setDni(dni);
        personaDTO.setNombres(nombres);
        personaDTO.setApellidoPaterno(apellidoPaterno);
        personaDTO.setApellidoMaterno(apellidoMaterno);
        personaDTO.setTelefono(telefono);
        return this.personaBO.modificar(personaDTO);
    }

    @WebMethod(operationName = "eliminarPersonas")
    public Integer eliminarPersonas(
            @WebParam(name = "personalId") Integer personalId
    ) throws IOException, InterruptedException {
        return this.personaBO.eliminar(personalId);
    }
}
