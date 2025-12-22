package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.EmpleadoBO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;
import pe.edu.pucp.softaseg.model.util.DesempenhoEmpleado;
import pe.edu.pucp.softaseg.model.util.TipoEmpleado;
import pe.edu.pucp.softaseg.services.softasegws.reports.ReporteUtil;

@WebService(serviceName = "Empleados")
public class Empleados {

    private EmpleadoBO empleadoBO;

    public Empleados() {
        this.empleadoBO = new EmpleadoBO();
    }

    @WebMethod(operationName = "insertarEmpleados")
    public Integer insertarEmpleados(
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "estado") EstadoUsuario estado,
            @WebParam(name = "desempenio") DesempenhoEmpleado desempenio,
            @WebParam(name = "tipo") TipoEmpleado tipo
    )  {
        EmpleadosDTO empleadoDTO = new EmpleadosDTO();        
        empleadoDTO.setDni(dni);
        empleadoDTO.setNombres(nombres);
        empleadoDTO.setApellidoPaterno(apellidoPaterno);
        empleadoDTO.setApellidoMaterno(apellidoMaterno);
        empleadoDTO.setTelefono(telefono);
        empleadoDTO.setNombreUsuario(nombreUsuario);
        empleadoDTO.setContrasenia(contrasenia);
        empleadoDTO.setCorreo(correo);
        empleadoDTO.setEstado(estado);       
        empleadoDTO.setDesempenio(desempenio);
        empleadoDTO.setTipo(tipo);        
        return this.empleadoBO.insertar(empleadoDTO);
    }

    @WebMethod(operationName = "obtenerPorIdEmpleados")
    public EmpleadosDTO obtenerPorIdEmpleados(@WebParam(name = "empleadoId") Integer empleadoId)
            throws IOException, InterruptedException {
        return this.empleadoBO.obtenerPorId(empleadoId);
    }

    @WebMethod(operationName = "listarTodosEmpleados")
    public ArrayList<EmpleadosDTO> listarTodosEmpleados() throws IOException, InterruptedException {
        return this.empleadoBO.listarTodos();
    }

    @WebMethod(operationName = "modificarEmpleados")
    public Integer modificarEmpleados(
            @WebParam(name = "personalId") Integer personalId,
            @WebParam(name = "dni") String dni,
            @WebParam(name = "nombres") String nombres,
            @WebParam(name = "apellidoPaterno") String apellidoPaterno,
            @WebParam(name = "apellidoMaterno") String apellidoMaterno,
            @WebParam(name = "telefono") String telefono,
            @WebParam(name = "nombreUsuario") String nombreUsuario,
            @WebParam(name = "contrasenia") String contrasenia,
            @WebParam(name = "correo") String correo,
            @WebParam(name = "estado") EstadoUsuario estado,
            @WebParam(name = "desempenio") DesempenhoEmpleado desempenio,
            @WebParam(name = "tipo") TipoEmpleado tipo
    )  {
        EmpleadosDTO empleadoDTO = new EmpleadosDTO();        
        empleadoDTO.setPersonalId(personalId);
        empleadoDTO.setDni(dni);
        empleadoDTO.setNombres(nombres);
        empleadoDTO.setApellidoPaterno(apellidoPaterno);
        empleadoDTO.setApellidoMaterno(apellidoMaterno);
        empleadoDTO.setTelefono(telefono);
        empleadoDTO.setNombreUsuario(nombreUsuario);
        empleadoDTO.setContrasenia(contrasenia);
        empleadoDTO.setCorreo(correo);
        empleadoDTO.setEstado(estado);       
        empleadoDTO.setDesempenio(desempenio);
        empleadoDTO.setTipo(tipo);
        return this.empleadoBO.modificar(empleadoDTO);
    }

    @WebMethod(operationName = "eliminarEmpleados")
    public Integer eliminarEmpleados(@WebParam(name = "empleadoId") Integer empleadoId)
            throws IOException, InterruptedException {
        return this.empleadoBO.eliminar(empleadoId);
    }

    @WebMethod(operationName = "listarPorNombreApellidoPaternoTipoEmpleados")
    public ArrayList<EmpleadosDTO> listarPorNombreApellidoPaternoTipoEmpleados(
            @WebParam(name = "filtro") String filtro)
            throws IOException, InterruptedException {
        return this.empleadoBO.listarPorNombreApellidoPaternoTipoEmpleado(filtro);
    }
    
    @WebMethod(operationName = "listarProcuradores")
    public ArrayList<EmpleadosDTO> listarProcuradores(
            @WebParam(name = "filtroProcurador") String filtro)
            throws IOException, InterruptedException {
        return this.empleadoBO.listarProcuradores(filtro);
    }
    
    @WebMethod(operationName = "reporteCalificacionProcurador")
    public byte[] reporteCalificacionProcurador (@WebParam(name = "procuradorId")Integer procuradorId, 
            @WebParam(name = "fechaInicio")String fechaInicio, @WebParam(name = "fechaFin")String fechaFin){
        
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio);
        LocalDateTime fin = LocalDateTime.parse(fechaFin);
        return ReporteUtil.reporteCalificacionProcurador(procuradorId, inicio, fin);
    }
}
