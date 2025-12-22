package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;


public interface TallerDAO {
    
    public Integer insertar(TalleresDTO taller);
    
    public TalleresDTO obtenerPorId (Integer tallerId);
    
    public ArrayList<TalleresDTO> listarTodos();
    
    public ArrayList<TalleresDTO> listarPorNombre(String nombre);
    
    public Integer modificar (TalleresDTO taller);
    
    public Integer eliminar (TalleresDTO taller);
}
