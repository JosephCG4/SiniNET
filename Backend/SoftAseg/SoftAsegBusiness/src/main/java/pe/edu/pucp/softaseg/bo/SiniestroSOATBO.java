
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.AfectadoDAO;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.dao.SiniestroDAO;
import pe.edu.pucp.softaseg.dao.SiniestroSOATDAO;
import pe.edu.pucp.softaseg.dao.UbicacionDAO;
import pe.edu.pucp.softaseg.daoImp.AfectadoDAOImpl;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.daoImp.SiniestroDAOImpl;
import pe.edu.pucp.softaseg.daoImp.SiniestroSOATDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.AfectadosDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

public class SiniestroSOATBO {
    
    private SiniestroSOATDAO siniestroSOATDAO;
    private SiniestroDAO siniestroDAO;
    private UbicacionDAO ubicacionDAO;
    private AfectadoDAO afectadoDAO;
    private PersonaDAO personaDAO;
    
    public SiniestroSOATBO(){
        this.siniestroSOATDAO = new SiniestroSOATDAOImpl();
        this.siniestroDAO = new SiniestroDAOImpl();
        this.ubicacionDAO = new UbicacionDAOImpl();
        this.afectadoDAO = new AfectadoDAOImpl();
        this.personaDAO = new PersonaDAOImpl();
    }
    
    public Integer insertar(SiniestrosSOATDTO siniestrosSOATDTO){
        int ubicacionId = this.ubicacionDAO.insertar(siniestrosSOATDTO.getUbicacion());
        siniestrosSOATDTO.getUbicacion().setUbicacionId(ubicacionId);
        int siniestroId = this.siniestroDAO.insertar(siniestrosSOATDTO);
        siniestrosSOATDTO.setSiniestroId(siniestroId);
        this.siniestroSOATDAO.insertar(siniestrosSOATDTO);
        AfectadosDTO afectadosDTO = new AfectadosDTO();
        afectadosDTO.setSiniestroId(siniestroId);
        int personaId;
        for(PersonasDTO persona : siniestrosSOATDTO.getAfectados() ){
            personaId = this.personaDAO.insertar(persona);
            persona.setPersonalId(personaId);
            afectadosDTO.setPersonaId(persona.getPersonalId());
            this.afectadoDAO.insertar(afectadosDTO);
       }
        return siniestroId;
    }
    
    public SiniestrosSOATDTO obtenerPorId(Integer siniestroId){
       SiniestrosSOATDTO siniestrosSOATDTO = this.siniestroSOATDAO.obtenerPorId(siniestroId);
       if(siniestrosSOATDTO == null) return siniestrosSOATDTO;
       siniestrosSOATDTO.setUbicacion(this.ubicacionDAO.obtenerPorId(siniestrosSOATDTO.getUbicacion().getUbicacionId()));
       siniestrosSOATDTO.setAfectados(this.personaDAO.listarAseguradosPorSiniestro(siniestrosSOATDTO.getSiniestroId()));
        return siniestrosSOATDTO;
    }
    
    public ArrayList<SiniestrosSOATDTO> listarTodos(){
        return this.siniestroSOATDAO.listarTodos();
    }
    
    public ArrayList<SiniestrosSOATDTO> listarPorProcurador(Integer idProcurador){
        return this.siniestroSOATDAO.listarPorProcurador(idProcurador);
    }
    
    public Integer modificar(SiniestrosSOATDTO siniestrosSOATDTO){
        this.ubicacionDAO.modificar(siniestrosSOATDTO.getUbicacion());
        this.siniestroDAO.modificar(siniestrosSOATDTO);
        //listar las antiguas personas
        ArrayList<PersonasDTO> personasAntiguas = this.personaDAO.listarAseguradosPorSiniestro(siniestrosSOATDTO.getSiniestroId());
        //Eliminar tabla intermedia
        AfectadosDTO afectadosDTO = new AfectadosDTO();
        afectadosDTO.setSiniestroId(siniestrosSOATDTO.getSiniestroId());
        this.afectadoDAO.eliminar(afectadosDTO);
        //Eliminar personas antiguas
        for(PersonasDTO persona : personasAntiguas){
            this.personaDAO.eliminar(persona);
        }
        //Insertar las nuevas personas y la tabla intermedia
        int personaId;
        for(PersonasDTO persona : siniestrosSOATDTO.getAfectados() ){
            personaId = this.personaDAO.insertar(persona);
            persona.setPersonalId(personaId);
            afectadosDTO.setPersonaId(persona.getPersonalId());
            this.afectadoDAO.insertar(afectadosDTO);
        }
        return this.siniestroSOATDAO.modificar(siniestrosSOATDTO);
    }
    
    public Integer eliminar(Integer siniestroSOATId){
        SiniestrosSOATDTO siniestrosSOATDTO = this.siniestroSOATDAO.obtenerPorId(siniestroSOATId);
         //listar las antiguas personas
        ArrayList<PersonasDTO> personasAntiguas = this.personaDAO.listarAseguradosPorSiniestro(siniestrosSOATDTO.getSiniestroId());
        //Eliminar tabla intermedia
        AfectadosDTO afectadosDTO = new AfectadosDTO();
        afectadosDTO.setSiniestroId(siniestrosSOATDTO.getSiniestroId());
        this.afectadoDAO.eliminar(afectadosDTO);
        //Eliminar personas antiguas
        for(PersonasDTO persona : personasAntiguas){
            this.personaDAO.eliminar(persona);
        }
        this.siniestroSOATDAO.eliminar(siniestrosSOATDTO);
        this.siniestroDAO.eliminar(siniestrosSOATDTO);
        return this.ubicacionDAO.eliminar(siniestrosSOATDTO.getUbicacion());
    }
}
