
package pe.edu.pucp.softaseg.dao;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;

public interface AdministradorDAO {
    
    public Integer insertar(AdministradoresDTO administrador);

    public AdministradoresDTO obtenerPorId(Integer administradorId);

    public ArrayList<AdministradoresDTO> listarTodos();

    public Integer modificar(AdministradoresDTO administrador);

    public Integer eliminar(AdministradoresDTO administrador);
}
