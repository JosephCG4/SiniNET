
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.CentroDeSaludDAO;
import pe.edu.pucp.softaseg.dao.UbicacionDAO;
import pe.edu.pucp.softaseg.daoImp.CentroDeSaludDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;

public class CentroDeSaludBO {
    
    private CentroDeSaludDAO centroDeSaludDAO;
    private UbicacionDAO ubicacionDAO;
    
    public CentroDeSaludBO(){
        this.centroDeSaludDAO = new CentroDeSaludDAOImpl();
        this.ubicacionDAO = new UbicacionDAOImpl();
    }
    
    public Integer insertar(CentrosDeSaludDTO centrosDeSaludDTO){
        int ubicacionId = this.ubicacionDAO.insertar(centrosDeSaludDTO.getUbicacion());
        centrosDeSaludDTO.getUbicacion().setUbicacionId(ubicacionId);
        Integer centroDeSaludId = this.centroDeSaludDAO.insertar(centrosDeSaludDTO);
        centrosDeSaludDTO.setCentroDeSaludId(centroDeSaludId);
        return centroDeSaludId;
    }
    
    public CentrosDeSaludDTO obtenerPorId(Integer centroDeSaludId){
        CentrosDeSaludDTO centrosDeSaludDTO = this.centroDeSaludDAO.obtenerPorId(centroDeSaludId);
        if(centrosDeSaludDTO == null) return centrosDeSaludDTO;
        centrosDeSaludDTO.setUbicacion(this.ubicacionDAO.obtenerPorId(centrosDeSaludDTO.getUbicacion().getUbicacionId()));
        return centrosDeSaludDTO;
    }
    
    
    public ArrayList<CentrosDeSaludDTO> listarTodos(){
        return this.centroDeSaludDAO.listarTodos();
    }
    
    public ArrayList<CentrosDeSaludDTO> listarPorNombreCodigoRENIPRESS(String filtro){
        return this.centroDeSaludDAO.listarPorNombreCodigoRENIPRESS(filtro);
    }
    
    public Integer modificar(CentrosDeSaludDTO centrosDeSaludDTO){
        this.ubicacionDAO.modificar(centrosDeSaludDTO.getUbicacion());
        return this.centroDeSaludDAO.modificar(centrosDeSaludDTO);
    }
    
    public Integer eliminar(Integer centroDeSaludId){
        CentrosDeSaludDTO centrosDeSaludDTO = this.centroDeSaludDAO.obtenerPorId(centroDeSaludId);
        this.centroDeSaludDAO.eliminar(centrosDeSaludDTO);
        return this.ubicacionDAO.eliminar(centrosDeSaludDTO.getUbicacion());
    }
    
}
