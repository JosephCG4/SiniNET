package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
        
public interface PolizaVehicularDAO {
    public Integer insertar(PolizasVehicularesDTO polizasVehiculares);

    public PolizasVehicularesDTO obtenerPorId(Integer polizasVehiculares);

    public ArrayList<PolizasVehicularesDTO> listarTodos();
    
    public ArrayList<PolizasVehicularesDTO> listarPorNombreApellidoAsegurado(String filtro);

    public Integer modificar(PolizasVehicularesDTO polizasVehiculares);

    public Integer eliminar(PolizasVehicularesDTO polizasVehiculares);
}
