
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.usuarios.InvolucradosDTO;


public interface InvolucradoDAO {
    
    public Integer insertar(InvolucradosDTO involucrado);
    
    public InvolucradosDTO obtenerPorId(Integer involucradoId);
    
    public ArrayList<InvolucradosDTO> listarTodos();
    
    public ArrayList<InvolucradosDTO> listarPorNombreApellidoPaterno(String filtro);
    
    public ArrayList<InvolucradosDTO> listarTodosAsegurados();
    
    public Integer modificar(InvolucradosDTO usuario);
    
    public Integer eliminar(InvolucradosDTO involucrado);
    
}
