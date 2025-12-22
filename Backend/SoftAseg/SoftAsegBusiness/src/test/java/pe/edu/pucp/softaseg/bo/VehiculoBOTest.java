
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.util.MarcaVehiculo;
import pe.edu.pucp.softaseg.model.util.TipoVehiculo;

public class VehiculoBOTest {
    
    private VehiculoBO vehiculoBO;
    
    public VehiculoBOTest() {
        this.vehiculoBO = new VehiculoBO();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        VehiculosDTO vehiculosDTO = new VehiculosDTO();
//        vehiculosDTO.setPlaca("platest");
//        vehiculosDTO.setMarca(MarcaVehiculo.CHERY);
//        vehiculosDTO.setModelo("modelotest");
//        vehiculosDTO.setColor("rojo");
//        vehiculosDTO.setTipo(TipoVehiculo.HATCHBACK);
//        Integer vehiculoId = this.vehiculoBO.insertar(vehiculosDTO);
//        
//        System.out.println("ObtenerPorId:");
//        vehiculosDTO = this.vehiculoBO.obtenerPorId(vehiculoId);
//        System.out.println(vehiculosDTO.getVehiculoId());
//        System.out.println(vehiculosDTO.getPlaca());
//        System.out.println(vehiculosDTO.getMarca());
//        System.out.println(vehiculosDTO.getModelo());
//        System.out.println(vehiculosDTO.getColor());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<VehiculosDTO> listaVehiculosDTO = this.vehiculoBO.listarTodos();
//        for (Integer i = 0; i < listaVehiculosDTO.size(); i++){
//            System.out.println(listaVehiculosDTO.get(i).getVehiculoId());
//            System.out.println(listaVehiculosDTO.get(i).getPlaca());
//            System.out.println(listaVehiculosDTO.get(i).getMarca());
//            System.out.println(listaVehiculosDTO.get(i).getModelo());
//            System.out.println(listaVehiculosDTO.get(i).getColor());
//        }
//        
//        System.out.println("Modificar:");
//        vehiculosDTO.setPlaca("placmod");
//        vehiculosDTO.setMarca(MarcaVehiculo.CHEVROLET);
//        vehiculosDTO.setModelo("modelomodificado");
//        vehiculosDTO.setColor("azul");
//        vehiculosDTO.setTipo(TipoVehiculo.CAMIONETA);
//        this.vehiculoBO.modificar(vehiculosDTO);
//        
//        vehiculosDTO = this.vehiculoBO.obtenerPorId(vehiculoId);
//        System.out.println(vehiculosDTO.getVehiculoId());
//        System.out.println(vehiculosDTO.getPlaca());
//        System.out.println(vehiculosDTO.getMarca());
//        System.out.println(vehiculosDTO.getModelo());
//        System.out.println(vehiculosDTO.getColor());
//        
//        System.out.println("Eliminar:");
//        this.vehiculoBO.eliminar(vehiculoId);
//        vehiculosDTO = this.vehiculoBO.obtenerPorId(vehiculoId);
//        assertNull(vehiculosDTO);
//    }
    
}
