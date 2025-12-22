
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.AdministradorDAO;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.dao.UsuarioDAO;
import pe.edu.pucp.softaseg.daoImp.AdministradorDAOImpl;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.AdministradoresDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.UsuariosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

public class AdministradorBO {
    
    private AdministradorDAO administradorDAO;
    private UsuarioDAO usuarioDAO;
    private PersonaDAO personaDAO;

    // Constructor
    public AdministradorBO() {
        this.administradorDAO = new AdministradorDAOImpl();
        this.usuarioDAO = new UsuarioDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }


    // INSERTAR
    public Integer insertar(AdministradoresDTO administradorDTO) {
        
        int personaId = this.personaDAO.insertar(administradorDTO);
 
        administradorDTO.setPersonalId(personaId);
        
        this.usuarioDAO.insertar(administradorDTO);
        this.administradorDAO.insertar(administradorDTO);
        
        return personaId;
    }
    
    public AdministradoresDTO obtenerPorId(Integer administradorId) {
        return this.administradorDAO.obtenerPorId(administradorId);
    }
    
    public ArrayList<AdministradoresDTO> listarTodos() {
        return this.administradorDAO.listarTodos();
    }


    public Integer modificar(AdministradoresDTO administradorDTO) {
        
        this.personaDAO.modificar(administradorDTO);
        this.usuarioDAO.modificar(administradorDTO);
        
        return this.administradorDAO.modificar(administradorDTO);
    }
    
    public Integer eliminar(Integer administradorId) {
        AdministradoresDTO administradorDTO = this.administradorDAO.obtenerPorId(administradorId);
        this.administradorDAO.eliminar(administradorDTO);
        this.usuarioDAO.eliminar(administradorDTO);
        return this.personaDAO.eliminar(administradorDTO); // elimina también la persona asociada
    }
}
