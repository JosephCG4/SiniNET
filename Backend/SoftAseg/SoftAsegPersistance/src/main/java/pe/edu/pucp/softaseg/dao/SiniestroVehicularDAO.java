package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;

public interface SiniestroVehicularDAO {
    
    public Integer insertar(SiniestrosVehicularesDTO siniestroVehicular);
    
    public SiniestrosVehicularesDTO obtenerPorId(Integer siniestroVehicularId);
    
    public ArrayList<SiniestrosVehicularesDTO> listarTodos();
    
    public ArrayList<SiniestrosVehicularesDTO> listarPorProcurador(Integer idProcurador);
    
    public Integer modificar(SiniestrosVehicularesDTO almacen);
    
    public Integer eliminar(SiniestrosVehicularesDTO almacen);
}
