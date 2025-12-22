
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.PolizaSOATDAO;
import pe.edu.pucp.softaseg.daoImp.PolizaSOATDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;

public class PolizaSOATBO {
    private PolizaSOATDAO polizaSOATDAO;
    
    public PolizaSOATBO(){
        this.polizaSOATDAO = new PolizaSOATDAOImpl();
    }
    
    public Integer insertar(PolizasSOATDTO polizasSOATDTO){
        Integer polizaId = this.polizaSOATDAO.insertar(polizasSOATDTO);
        polizasSOATDTO.setPolizaId(polizaId);
        return polizaId;
    }
    
    public PolizasSOATDTO obtenerPorId(Integer polizaId){
        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();
        polizasSOATDTO.setPolizaId(polizaId);
        return this.polizaSOATDAO.obtenerPorId(polizaId);
    }
    
    public ArrayList<PolizasSOATDTO> listarTodos(){
        return this.polizaSOATDAO.listarTodos();
    }
    
    public ArrayList<PolizasSOATDTO> listarPorNombreApellidoAsegurado(String filtro){
        return this.polizaSOATDAO.listarPorNombreApellidoAsegurado(filtro);
    }
    
    public Integer modificar(PolizasSOATDTO polizasSOATDTO){
        
        return this.polizaSOATDAO.modificar(polizasSOATDTO);
    }
    
    public Integer eliminar(Integer polizaId){
        PolizasSOATDTO polizasSOATDTO = new PolizasSOATDTO();
        polizasSOATDTO.setPolizaId(polizaId);
        return this.polizaSOATDAO.eliminar(polizasSOATDTO);
    }
}
