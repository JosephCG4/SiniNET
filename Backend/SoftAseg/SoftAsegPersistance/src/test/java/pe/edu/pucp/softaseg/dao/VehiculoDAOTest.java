package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.VehiculoDAOImpl;
import pe.edu.pucp.softaseg.model.util.MarcaVehiculo;
import pe.edu.pucp.softaseg.model.util.TipoVehiculo;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;

//public class VehiculoDAOTest {
//    
//    private VehiculoDAO vehiculoDAO;    
//    
//    public VehiculoDAOTest() {
//        this.vehiculoDAO = new VehiculoDAOImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaVehiculoId = new ArrayList<>();
//        insertarVehiculos(listaVehiculoId);
//        eliminarTodo();
//    }
//    
//    private void insertarVehiculos(ArrayList<Integer> listaVehiculoId) {
//        VehiculosDTO vehiculo = new VehiculosDTO();
//        vehiculo.setPlaca("GRT1456");
//        vehiculo.setMarca(MarcaVehiculo.CHERY);
//        vehiculo.setModelo("Tiggo 9");
//        vehiculo.setColor("Rojo");
//        vehiculo.setTipo(TipoVehiculo.CAMIONETA);
//        Integer resultado = this.vehiculoDAO.insertar(vehiculo);
//        assertTrue(resultado != 0);
//        listaVehiculoId.add(resultado);
//        
//        vehiculo.setPlaca("VNM2331");
//        vehiculo.setMarca(MarcaVehiculo.CHEVROLET);
//        vehiculo.setModelo("Onix");
//        vehiculo.setColor("Azul");
//        vehiculo.setTipo(TipoVehiculo.HATCHBACK);
//        resultado = this.vehiculoDAO.insertar(vehiculo);
//        assertTrue(resultado != 0);
//        listaVehiculoId.add(resultado);
//        
//        vehiculo.setPlaca("GRT1456");
//        vehiculo.setMarca(MarcaVehiculo.CHERY);
//        vehiculo.setModelo("Tiggo 9");
//        vehiculo.setColor("Blanco");
//        vehiculo.setTipo(TipoVehiculo.SUV);
//        resultado = this.vehiculoDAO.insertar(vehiculo);
//        assertTrue(resultado != 0);
//        listaVehiculoId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaVehiculoId = new ArrayList<>();
//        insertarVehiculos(listaVehiculoId);
//        VehiculosDTO vehiculo = this.vehiculoDAO.obtenerPorId(listaVehiculoId.get(0));
//        assertEquals(vehiculo.getVehiculoId(), listaVehiculoId.get(0));
//        
//        vehiculo = this.vehiculoDAO.obtenerPorId(listaVehiculoId.get(1));
//        assertEquals(vehiculo.getVehiculoId(), listaVehiculoId.get(1));
//        
//        vehiculo = this.vehiculoDAO.obtenerPorId(listaVehiculoId.get(2));
//        assertEquals(vehiculo.getVehiculoId(), listaVehiculoId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaVehiculoId = new ArrayList<>();
//        insertarVehiculos(listaVehiculoId);
//        
//        ArrayList<VehiculosDTO> listaVehiculos = this.vehiculoDAO.listarTodos();
//        assertEquals(listaVehiculoId.size()+3, listaVehiculos.size());
//        for (Integer i = 0; i < listaVehiculos.size(); i++) {
//            if(listaVehiculos.get(i).getVehiculoId()>3)
//                assertEquals(listaVehiculoId.get(i-3), listaVehiculos.get(i).getVehiculoId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaVehiculoId = new ArrayList<>();
//        insertarVehiculos(listaVehiculoId);
//        
//        ArrayList<VehiculosDTO> listaVehiculos = this.vehiculoDAO.listarTodos();
//        assertEquals(listaVehiculoId.size()+3, listaVehiculos.size());
//        for (Integer i = 0; i < listaVehiculos.size(); i++) {
//            if(listaVehiculos.get(i).getVehiculoId()>3){
//                listaVehiculos.get(i).setPlaca("PLA000" + i.toString());
//                listaVehiculos.get(i).setMarca(MarcaVehiculo.TOYOTA);
//                listaVehiculos.get(i).setModelo("ModeloPrueba");
//                listaVehiculos.get(i).setColor("Amarillo");
//                listaVehiculos.get(i).setTipo(TipoVehiculo.VAN);
//                this.vehiculoDAO.modificar(listaVehiculos.get(i));
//            }
//        }
//        
//        ArrayList<VehiculosDTO> listaVehiculosModificados = this.vehiculoDAO.listarTodos();
//        assertEquals( listaVehiculos.size(), listaVehiculosModificados.size());
//        for (Integer i = 0; i < listaVehiculos.size(); i++) {
//            if(listaVehiculos.get(i).getVehiculoId()>3){
//                assertEquals(listaVehiculos.get(i).getPlaca(), listaVehiculosModificados.get(i).getPlaca());
//                assertEquals(listaVehiculos.get(i).getMarca(), listaVehiculosModificados.get(i).getMarca());
//                assertEquals(listaVehiculos.get(i).getModelo(), listaVehiculosModificados.get(i).getModelo());
//                assertEquals(listaVehiculos.get(i).getColor(), listaVehiculosModificados.get(i).getColor());
//                assertEquals(listaVehiculos.get(i).getTipo(), listaVehiculosModificados.get(i).getTipo());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaVehiculoId = new ArrayList<>();
//        insertarVehiculos(listaVehiculoId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<VehiculosDTO> listaVehiculos = this.vehiculoDAO.listarTodos();
//        for (Integer i = 0; i < listaVehiculos.size(); i++) {
//            if(listaVehiculos.get(i).getVehiculoId()>3){
//                Integer resultado = this.vehiculoDAO.eliminar(listaVehiculos.get(i));
//                assertNotEquals(0, resultado);
//                VehiculosDTO vehiculo = this.vehiculoDAO.obtenerPorId(listaVehiculos.get(i).getVehiculoId());
//                assertNull(vehiculo);
//            }
//        }
//    }
//}