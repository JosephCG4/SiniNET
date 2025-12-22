package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.EmpleadoDAO;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.dao.UsuarioDAO;
import pe.edu.pucp.softaseg.daoImp.EmpleadoDAOImpl;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UsuarioDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;



public class EmpleadoBO {
    
    private EmpleadoDAO empleadoDAO;
    private UsuarioDAO usuarioDAO;
    private PersonaDAO personaDAO;

    // Constructor
    public EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAOImpl();
        this.usuarioDAO = new UsuarioDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }


    // INSERTAR
    public Integer insertar(EmpleadosDTO empleadoDTO) {
        
        
        int personaId = this.personaDAO.insertar(empleadoDTO);
        empleadoDTO.setPersonalId(personaId);
        
        this.usuarioDAO.insertar(empleadoDTO);      
        
        this.empleadoDAO.insertar(empleadoDTO);
        return personaId;
    }
    
    public EmpleadosDTO obtenerPorId(Integer empleadoId) {
        return this.empleadoDAO.obtenerPorId(empleadoId);
    }
    
    public ArrayList<EmpleadosDTO> listarTodos() {
        return this.empleadoDAO.listarTodos();
    }

    public ArrayList<EmpleadosDTO> listarPorNombreApellidoPaternoTipoEmpleado(String filtro) {
        return this.empleadoDAO.listarPorNombreApellidoPaternoTipoEmpleado(filtro);
    }
    public ArrayList<EmpleadosDTO> listarProcuradores(String filtro) {
        return this.empleadoDAO.listarProcuradores(filtro);
    }
    
    public Integer modificar(EmpleadosDTO empleadoDTO) {
        
        this.personaDAO.modificar(empleadoDTO);

        this.usuarioDAO.modificar(empleadoDTO);
        
        return this.empleadoDAO.modificar(empleadoDTO);
    }
    
    public Integer eliminar(Integer empleadoId) {
        EmpleadosDTO empleadoDTO = this.empleadoDAO.obtenerPorId(empleadoId);
        this.empleadoDAO.eliminar(empleadoDTO);
        this.usuarioDAO.eliminar(empleadoDTO);
        return this.personaDAO.eliminar(empleadoDTO); // elimina también la persona asociada
    }
}
