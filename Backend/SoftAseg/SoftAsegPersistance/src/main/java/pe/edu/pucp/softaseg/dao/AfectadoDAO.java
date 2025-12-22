
package pe.edu.pucp.softaseg.dao;

import pe.edu.pucp.softaseg.model.gestionSiniestros.AfectadosDTO;

public interface AfectadoDAO {
    Integer insertar(AfectadosDTO afectado);
    
    Integer eliminar(AfectadosDTO afectado);
}
