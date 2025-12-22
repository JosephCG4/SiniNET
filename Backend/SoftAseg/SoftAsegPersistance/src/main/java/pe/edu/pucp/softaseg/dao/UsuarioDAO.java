
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;

public interface UsuarioDAO {
    
    public Integer insertar(UsuariosDTO usuario);
    
    public UsuariosDTO obtenerPorId(Integer usuarioId);

    public ArrayList<UsuariosDTO> listarTodos();

    public Integer modificar(UsuariosDTO usuario);

    public Integer eliminar(UsuariosDTO usuario);
}
