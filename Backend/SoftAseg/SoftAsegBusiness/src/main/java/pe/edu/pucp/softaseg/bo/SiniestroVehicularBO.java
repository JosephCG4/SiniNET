
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.SiniestroDAO;
import pe.edu.pucp.softaseg.dao.SiniestroVehicularDAO;
import pe.edu.pucp.softaseg.dao.UbicacionDAO;
import pe.edu.pucp.softaseg.daoImp.SiniestroDAOImpl;
import pe.edu.pucp.softaseg.daoImp.SiniestroVehicularDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;

public class SiniestroVehicularBO {
    
    private SiniestroVehicularDAO siniestroVehicularDAO;
    private SiniestroDAO siniestroDAO;
    private UbicacionDAO ubicacionDAO;
    
    public SiniestroVehicularBO(){
        this.siniestroVehicularDAO = new SiniestroVehicularDAOImpl();
        this.siniestroDAO = new SiniestroDAOImpl();
        this.ubicacionDAO = new UbicacionDAOImpl();
    }
    
    public Integer insertar(SiniestrosVehicularesDTO siniestrosVehicularesDTO){
        int ubicacionId = this.ubicacionDAO.insertar(siniestrosVehicularesDTO.getUbicacion());
        siniestrosVehicularesDTO.getUbicacion().setUbicacionId(ubicacionId);
        int siniestroId = this.siniestroDAO.insertar(siniestrosVehicularesDTO);
        siniestrosVehicularesDTO.setSiniestroId(siniestroId);
        this.siniestroVehicularDAO.insertar(siniestrosVehicularesDTO);
        return siniestroId;
    }
    
    public SiniestrosVehicularesDTO obtenerPorId(Integer siniestroId){
        SiniestrosVehicularesDTO siniestrosVehicularesDTO = this.siniestroVehicularDAO.obtenerPorId(siniestroId);
        if(siniestrosVehicularesDTO == null) return siniestrosVehicularesDTO;
        siniestrosVehicularesDTO.setUbicacion(this.ubicacionDAO.obtenerPorId(siniestrosVehicularesDTO.getUbicacion().getUbicacionId()));
        return siniestrosVehicularesDTO;
    }
    
    public ArrayList<SiniestrosVehicularesDTO> listarTodos(){
        return this.siniestroVehicularDAO.listarTodos();
    }
    
    public ArrayList<SiniestrosVehicularesDTO> listarPorProcurador(Integer idProcurador){
        return this.siniestroVehicularDAO.listarPorProcurador(idProcurador);
    }
    
    public Integer modificar(SiniestrosVehicularesDTO siniestrosVehicularesDTO){
        this.ubicacionDAO.modificar(siniestrosVehicularesDTO.getUbicacion());
        this.siniestroDAO.modificar(siniestrosVehicularesDTO);
        return this.siniestroVehicularDAO.modificar(siniestrosVehicularesDTO);
    }
    
    public Integer eliminar(Integer siniestroId){
        SiniestrosVehicularesDTO siniestrosVehicularesDTO = this.siniestroVehicularDAO.obtenerPorId(siniestroId);
        this.siniestroVehicularDAO.eliminar(siniestrosVehicularesDTO);
        this.siniestroDAO.eliminar(siniestrosVehicularesDTO);
        return this.ubicacionDAO.eliminar(siniestrosVehicularesDTO.getUbicacion());
    }
}
