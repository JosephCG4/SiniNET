
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;


public interface CentroDeSaludDAO {

    public Integer insertar(CentrosDeSaludDTO centroDeSalud);

    public CentrosDeSaludDTO obtenerPorId(Integer centroDeSaludId);

    public ArrayList<CentrosDeSaludDTO> listarTodos();

    public ArrayList<CentrosDeSaludDTO> listarPorNombreCodigoRENIPRESS(String filtro);
    
    public Integer modificar(CentrosDeSaludDTO centroDeSalud);

    public Integer eliminar(CentrosDeSaludDTO centroDeSalud);
}
