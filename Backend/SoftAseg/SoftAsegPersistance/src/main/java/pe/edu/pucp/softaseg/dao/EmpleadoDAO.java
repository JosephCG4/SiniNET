
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;


public interface EmpleadoDAO {

    public Integer insertar(EmpleadosDTO empleado);

    public EmpleadosDTO obtenerPorId(Integer empleadoId);

    public ArrayList<EmpleadosDTO> listarTodos();
    
    public ArrayList<EmpleadosDTO> listarPorNombreApellidoPaternoTipoEmpleado(String filtro);
    
    public ArrayList<EmpleadosDTO> listarProcuradores(String filtro);

    public Integer modificar(EmpleadosDTO empleado);

    public Integer eliminar(EmpleadosDTO empleado);
    
}