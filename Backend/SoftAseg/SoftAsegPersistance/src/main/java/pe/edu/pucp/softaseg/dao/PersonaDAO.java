
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;


public interface PersonaDAO {

    public Integer insertar(PersonasDTO persona);

    public PersonasDTO obtenerPorId(Integer personaId);

    public ArrayList<PersonasDTO> listarTodos();
    
    public ArrayList<PersonasDTO> listarPorNombresApellidosDni(String filtro);
    
    public ArrayList<PersonasDTO> listarAseguradosPorSiniestro(Integer idSiniestro);

    public Integer modificar(PersonasDTO persona);

    public Integer eliminar(PersonasDTO persona);
    
}
