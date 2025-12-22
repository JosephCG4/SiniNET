
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosDTO;


public interface SiniestroDAO {
    
    public Integer insertar(SiniestrosDTO siniestro);
    
    public SiniestrosDTO obtenerPorId (Integer siniestroId);
    
    public ArrayList<SiniestrosDTO> listarTodos();
    
    public ArrayList<SiniestrosDTO> listarPorEmpleado(String filtro);
    
    public Integer modificar(SiniestrosDTO siniestro);

    public Integer eliminar(SiniestrosDTO siniestro);
}
