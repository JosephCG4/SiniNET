package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softaseg.bo.VehiculoBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.util.MarcaVehiculo;
import pe.edu.pucp.softaseg.model.util.TipoVehiculo;

@WebService(serviceName = "Vehiculos")
public class Vehiculos {

    private VehiculoBO vehiculoBO;

    public Vehiculos() {
        this.vehiculoBO = new VehiculoBO();
    }

    @WebMethod(operationName = "insertarVehiculos")
    public Integer insertarVehiculos(
            @WebParam(name = "placa") String placa,
            @WebParam(name = "marca") MarcaVehiculo marca,
            @WebParam(name = "modelo") String modelo,
            @WebParam(name = "color") String color,
            @WebParam(name = "tipo") TipoVehiculo tipo
    )  {
        VehiculosDTO vehiculosDTO = new VehiculosDTO();
        vehiculosDTO.setPlaca(placa);
        vehiculosDTO.setMarca(marca);
        vehiculosDTO.setModelo(modelo);
        vehiculosDTO.setColor(color);
        vehiculosDTO.setTipo(tipo);
        return this.vehiculoBO.insertar(vehiculosDTO);
    }

    @WebMethod(operationName = "obtenerPorIdVehiculos")
    public VehiculosDTO obtenerPorIdVehiculos(
            @WebParam(name = "vehiculoId") Integer vehiculoId
    ) throws IOException, InterruptedException {
        return this.vehiculoBO.obtenerPorId(vehiculoId);
    }

    @WebMethod(operationName = "listarTodosVehiculos")
    public ArrayList<VehiculosDTO> listarTodosVehiculos() throws IOException, InterruptedException {
        return this.vehiculoBO.listarTodos();
    }
    
    @WebMethod(operationName = "listarPorPlacaMarcaModeloTipoVehiculo")
    public ArrayList<VehiculosDTO> listarPorPlacaMarcaModeloTipoVehiculo(
            @WebParam(name = "filtro") String filtro)
            throws IOException, InterruptedException {
        return this.vehiculoBO.listarPorPlacaMarcaModeloTipoVehiculo(filtro);
    }
    
    @WebMethod(operationName = "modificarVehiculos")
    public Integer modificarVehiculos(
            @WebParam(name = "vehiculoId") Integer vehiculoId,
            @WebParam(name = "placa") String placa,
            @WebParam(name = "marca") MarcaVehiculo marca,
            @WebParam(name = "modelo") String modelo,
            @WebParam(name = "color") String color,
            @WebParam(name = "tipo") TipoVehiculo tipo
    )  {
        VehiculosDTO vehiculosDTO = new VehiculosDTO();
        vehiculosDTO.setVehiculoId(vehiculoId);
        vehiculosDTO.setPlaca(placa);
        vehiculosDTO.setMarca(marca);
        vehiculosDTO.setModelo(modelo);
        vehiculosDTO.setColor(color);
        vehiculosDTO.setTipo(tipo);
        return this.vehiculoBO.modificar(vehiculosDTO);
    }

    @WebMethod(operationName = "eliminarVehiculos")
    public Integer eliminarVehiculos(
            @WebParam(name = "vehiculoId") Integer vehiculoId
    ) throws IOException, InterruptedException {
        return this.vehiculoBO.eliminar(vehiculoId);
    }
    
}
