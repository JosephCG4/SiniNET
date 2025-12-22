
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;


public interface VehiculoDAO {

    public Integer insertar(VehiculosDTO vehiculo);

    public VehiculosDTO obtenerPorId(Integer vehiculoId);

    public ArrayList<VehiculosDTO> listarTodos();

    public ArrayList<VehiculosDTO> listarPorPlacaMarcaModeloTipoVehiculo(String filtro);
    
    public Integer modificar(VehiculosDTO vehiculo);

    public Integer eliminar(VehiculosDTO vehiculo);
}