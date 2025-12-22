package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.ImagenSiniestroDTO;

public interface ImagenSiniestroDAO {
    Integer insertar(ImagenSiniestroDTO imagen);
    
    ImagenSiniestroDTO obtenerPorId(Integer imagenId);
    
    ArrayList<ImagenSiniestroDTO> listarPorSiniestro(Integer siniestroId);
    
    Integer eliminar(Integer imagenId);
}
