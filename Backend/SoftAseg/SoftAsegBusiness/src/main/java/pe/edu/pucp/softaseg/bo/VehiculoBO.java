
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.VehiculoDAO;
import pe.edu.pucp.softaseg.daoImp.VehiculoDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;

public class VehiculoBO {
    private VehiculoDAO vehiculoDAO;
    
    public VehiculoBO(){
        this.vehiculoDAO = new VehiculoDAOImpl();
    }
    
    public Integer insertar(VehiculosDTO vehiculosDTO){
        Integer vehiculoId = this.vehiculoDAO.insertar(vehiculosDTO);
        vehiculosDTO.setVehiculoId(vehiculoId);
        return vehiculoId;
    }
    
    public VehiculosDTO obtenerPorId(Integer vehiculoId){
        return this.vehiculoDAO.obtenerPorId(vehiculoId);
    }
    
    public ArrayList<VehiculosDTO> listarTodos(){
        return this.vehiculoDAO.listarTodos();
    }
    
    public ArrayList<VehiculosDTO> listarPorPlacaMarcaModeloTipoVehiculo(String filtro) {
        return this.vehiculoDAO.listarPorPlacaMarcaModeloTipoVehiculo(filtro);
    }
    
    public Integer modificar(VehiculosDTO vehiculosDTO){
        return this.vehiculoDAO.modificar(vehiculosDTO);
    }
    
    public Integer eliminar(Integer vehiculoId){
        VehiculosDTO vehiculosDTO = new VehiculosDTO();
        vehiculosDTO.setVehiculoId(vehiculoId);
        return this.vehiculoDAO.eliminar(vehiculosDTO);
    }
}
