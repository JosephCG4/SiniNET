package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;


public class PersonaBO {
    
    private PersonaDAO personaDAO;


    public PersonaBO() {
        this.personaDAO = new PersonaDAOImpl();
    }


    public Integer insertar(PersonasDTO personaDTO) {
        Integer personaId = this.personaDAO.insertar(personaDTO);
        personaDTO.setPersonalId(personaId);
        return personaId;
    }

    
    public PersonasDTO obtenerPorId(Integer personaId) {
        PersonasDTO personaDTO = new PersonasDTO();
        personaDTO.setPersonalId(personaId);
        return this.personaDAO.obtenerPorId(personaId);
    }


    public ArrayList<PersonasDTO> listarTodos() {
        return this.personaDAO.listarTodos();
    }
    
    public ArrayList<PersonasDTO> listarAseguradosPorSiniestro(Integer idSiniestro) {
        return this.personaDAO.listarAseguradosPorSiniestro(idSiniestro);
    }
    
    public ArrayList<PersonasDTO> listarPorNombresApellidosDni(String filtro) {
        return this.personaDAO.listarPorNombresApellidosDni(filtro);
    }


    public Integer modificar(PersonasDTO personaDTO) {
        return this.personaDAO.modificar(personaDTO);
    }


    public Integer eliminar(Integer personaId) {
        PersonasDTO personaDTO = new PersonasDTO();
        personaDTO.setPersonalId(personaId);
        return this.personaDAO.eliminar(personaDTO);
    }
}