package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.AdministradorBO;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

@WebService(serviceName = "Administradores")
public class Administradores {

    private AdministradorBO administradorBO;

    public Administradores() {
        this.administradorBO = new AdministradorBO();
    }

    @WebMethod(operationName = "insertarAdministradores")
    public Integer insertarAdministradores(
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "estado") EstadoUsuario estado,
            @WebParam(name = "llaveMaestra") String llaveMaestra
    )  {
        AdministradoresDTO administradorDTO = new AdministradoresDTO();
        administradorDTO.setDni(dni);
        administradorDTO.setNombres(nombres);
        administradorDTO.setApellidoPaterno(apellidoPaterno);
        administradorDTO.setApellidoMaterno(apellidoMaterno);
        administradorDTO.setTelefono(telefono);                      
        administradorDTO.setNombreUsuario(nombreUsuario);
        administradorDTO.setContrasenia(contrasenia);
        administradorDTO.setCorreo(correo);
        administradorDTO.setEstado(estado);                
        administradorDTO.setLlaveMaestra(llaveMaestra);        
        return this.administradorBO.insertar(administradorDTO);
    }

    @WebMethod(operationName = "obtenerPorIdAdministradores")
    public AdministradoresDTO obtenerPorIdAdministradores(@WebParam(name = "administradorId") Integer administradorId)
            throws IOException, InterruptedException {
        return this.administradorBO.obtenerPorId(administradorId);
    }

    @WebMethod(operationName = "listarTodosAdministradores")
    public ArrayList<AdministradoresDTO> listarTodosAdministradores() throws IOException, InterruptedException {
        return this.administradorBO.listarTodos();
    }

    @WebMethod(operationName = "modificarAdministradores")
    public Integer modificarAdministradores(
            @WebParam(name = "administradorId") Integer administradorId,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "estado") EstadoUsuario estado,
            @WebParam(name = "llaveMaestra") String llaveMaestra
    ) {
        AdministradoresDTO administradorDTO = new AdministradoresDTO();
        administradorDTO.setPersonalId(administradorId);
        administradorDTO.setDni(dni);
        administradorDTO.setNombres(nombres);
        administradorDTO.setApellidoPaterno(apellidoPaterno);
        administradorDTO.setApellidoMaterno(apellidoMaterno);
        administradorDTO.setTelefono(telefono);                      
        administradorDTO.setNombreUsuario(nombreUsuario);
        administradorDTO.setContrasenia(contrasenia);
        administradorDTO.setCorreo(correo);
        administradorDTO.setEstado(estado);                
        administradorDTO.setLlaveMaestra(llaveMaestra);  
        return this.administradorBO.modificar(administradorDTO);
    }

    @WebMethod(operationName = "eliminarAdministradores")
    public Integer eliminarAdministradores(@WebParam(name = "administradorId") Integer administradorId)
            throws IOException, InterruptedException {
        return this.administradorBO.eliminar(administradorId);
    }

}
