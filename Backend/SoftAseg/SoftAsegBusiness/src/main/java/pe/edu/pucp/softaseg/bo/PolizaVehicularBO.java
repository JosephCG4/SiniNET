
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.PolizaVehicularDAO;
import pe.edu.pucp.softaseg.daoImp.PolizaVehicularDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;

public class PolizaVehicularBO {
    private PolizaVehicularDAO polizaVehicularDAO;
    
    public PolizaVehicularBO(){
        this.polizaVehicularDAO = new PolizaVehicularDAOImpl();
    }
    
    public Integer insertar(PolizasVehicularesDTO polizasVehicularesDTO){
        Integer polizaId = this.polizaVehicularDAO.insertar(polizasVehicularesDTO);
        polizasVehicularesDTO.setPolizaId(polizaId);
        return polizaId;
    }
    
    public PolizasVehicularesDTO obtenerPorId(Integer polizaId){
        PolizasVehicularesDTO polizasVehicularesDTO = new PolizasVehicularesDTO();
        polizasVehicularesDTO.setPolizaId(polizaId);
        return this.polizaVehicularDAO.obtenerPorId(polizaId);
    }
    
    public ArrayList<PolizasVehicularesDTO> listarTodos(){
        return this.polizaVehicularDAO.listarTodos();
    }
    
    public ArrayList<PolizasVehicularesDTO> listarPorNombreApellidoAsegurado(String filtro){
        return this.polizaVehicularDAO.listarPorNombreApellidoAsegurado(filtro);
    }
    
    public Integer modificar(PolizasVehicularesDTO polizasVehicularesDTO){
        return this.polizaVehicularDAO.modificar(polizasVehicularesDTO);
    }
    
    public Integer eliminar(Integer polizaId){
        PolizasVehicularesDTO polizasSOATDTO = new PolizasVehicularesDTO();
        polizasSOATDTO.setPolizaId(polizaId);
        return this.polizaVehicularDAO.eliminar(polizasSOATDTO);
    }
}
