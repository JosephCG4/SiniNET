
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.InvolucradoDAO;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.daoImp.InvolucradoDAOImpl;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.InvolucradosDTO;

public class InvolucradoBO {
    private InvolucradoDAO involucradoDAO;
    private PersonaDAO personaDAO;
    
    public InvolucradoBO(){
        this.involucradoDAO = new InvolucradoDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public Integer insertar(InvolucradosDTO involucradosDTO){
        int personaId = this.personaDAO.insertar(involucradosDTO);
        involucradosDTO.setPersonalId(personaId);
        return this.involucradoDAO.insertar(involucradosDTO);
    }
    
    public InvolucradosDTO obtenerPorId(Integer involucradoId){
        return this.involucradoDAO.obtenerPorId(involucradoId);
    }
    
    public ArrayList<InvolucradosDTO> listarTodos(){
        return this.involucradoDAO.listarTodos();
    }
    
    public ArrayList<InvolucradosDTO> listarTodosAsegurados(){
        return this.involucradoDAO.listarTodosAsegurados();
    }
    
    public ArrayList<InvolucradosDTO> listarPorNombreApellidoPaterno(String filtro){
        return this.involucradoDAO.listarPorNombreApellidoPaterno(filtro);
    }
    
    public Integer modificar(InvolucradosDTO involucradosDTO){
        this.personaDAO.modificar(involucradosDTO);
        return this.involucradoDAO.modificar(involucradosDTO);
    }
    
    public Integer eliminar(Integer involucradoId){
        InvolucradosDTO involucradosDTO = this.involucradoDAO.obtenerPorId(involucradoId);
        this.involucradoDAO.eliminar(involucradosDTO);
        return this.personaDAO.eliminar(involucradosDTO);
    }
}
