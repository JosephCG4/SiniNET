
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.TallerDAO;
import pe.edu.pucp.softaseg.dao.UbicacionDAO;
import pe.edu.pucp.softaseg.daoImp.TallerDAOImpl;
import pe.edu.pucp.softaseg.daoImp.UbicacionDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;

/**
 *
 * @author josep
 */
public class TallerBO {
    private TallerDAO tallerDAO;
    private UbicacionDAO ubicacionDAO;
    
    public TallerBO(){
        this.tallerDAO = new TallerDAOImpl();
        this.ubicacionDAO = new UbicacionDAOImpl();
    }
    
    public Integer insertar(TalleresDTO talleresDTO){
        int ubicacionId = this.ubicacionDAO.insertar(talleresDTO.getUbicacion());
        talleresDTO.getUbicacion().setUbicacionId(ubicacionId);
        Integer tallerId = this.tallerDAO.insertar(talleresDTO);
        talleresDTO.setTallerId(tallerId);
        return tallerId;
    }
    
    public TalleresDTO obtenerPorId(Integer tallerID){
        TalleresDTO talleresDTO = this.tallerDAO.obtenerPorId(tallerID);
        if(talleresDTO == null) return talleresDTO;
        talleresDTO.setUbicacion(this.ubicacionDAO.obtenerPorId(talleresDTO.getUbicacion().getUbicacionId()));
        return talleresDTO;
    }
    
    public ArrayList<TalleresDTO> listarTodos(){
        return this.tallerDAO.listarTodos();
    }
    
    public ArrayList<TalleresDTO> listarPorNombre(String nombre){
        return this.tallerDAO.listarPorNombre(nombre);
    }
    
    public Integer modificar(TalleresDTO talleresDTO){
        this.ubicacionDAO.modificar(talleresDTO.getUbicacion());
        return this.tallerDAO.modificar(talleresDTO);
    }
    
    public Integer eliminar(Integer tallerId){
        TalleresDTO talleresDTO = this.tallerDAO.obtenerPorId(tallerId);
        this.tallerDAO.eliminar(talleresDTO);
        return this.ubicacionDAO.eliminar(talleresDTO.getUbicacion());
    }
}
