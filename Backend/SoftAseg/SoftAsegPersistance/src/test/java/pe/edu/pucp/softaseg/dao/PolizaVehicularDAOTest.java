
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.PolizaVehicularDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.util.TipoPolizaVehicular;

//public class PolizaVehicularDAOTest {
//    
//    private PolizaVehicularDAO polizaVehicularDAO;
//    
//    public PolizaVehicularDAOTest() {
//        this.polizaVehicularDAO = new PolizaVehicularDAOImpl();
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaPolizaVehicularId = new ArrayList<>();
//        insertarPolizasVehiculares(listaPolizaVehicularId);
//        eliminarTodo();
//    }
//    
//    private void insertarPolizasVehiculares(ArrayList<Integer> listaPolizaVehicularId) {
//        PolizasVehicularesDTO polizaVehicular = new PolizasVehicularesDTO();
//        PersonasDTO persona = new PersonasDTO();
//        
//        polizaVehicular.setAsegurado(persona);
//        polizaVehicular.getAsegurado().setPersonalId(1);
//        polizaVehicular.setEstado(EstadoPoliza.VIGENTE);
//        polizaVehicular.setTipo(TipoPolizaVehicular.PERDIDATOTAL);
//        polizaVehicular.setPorcentajeCobertura(10);
//        Integer resultado = this.polizaVehicularDAO.insertar(polizaVehicular);
//        assertTrue(resultado != 0);
//        listaPolizaVehicularId.add(resultado);
//        
//        polizaVehicular.setAsegurado(persona);
//        polizaVehicular.getAsegurado().setPersonalId(2);
//        polizaVehicular.setEstado(EstadoPoliza.VIGENTE);
//        polizaVehicular.setTipo(TipoPolizaVehicular.PERDIDATOTAL);
//        polizaVehicular.setPorcentajeCobertura(20);
//        resultado = this.polizaVehicularDAO.insertar(polizaVehicular);
//        assertTrue(resultado != 0);
//        listaPolizaVehicularId.add(resultado);
//        
//        polizaVehicular.setAsegurado(persona);
//        polizaVehicular.getAsegurado().setPersonalId(3);
//        polizaVehicular.setEstado(EstadoPoliza.VIGENTE);
//        polizaVehicular.setTipo(TipoPolizaVehicular.RESPONSABILIDADCIVIL);
//        polizaVehicular.setPorcentajeCobertura(30);
//        resultado = this.polizaVehicularDAO.insertar(polizaVehicular);
//        assertTrue(resultado != 0);
//        listaPolizaVehicularId.add(resultado);   
//    }
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaPolizaVehicularId = new ArrayList<>();
//        insertarPolizasVehiculares(listaPolizaVehicularId);
//        PolizasVehicularesDTO polizaVehicular = this.polizaVehicularDAO.obtenerPorId(listaPolizaVehicularId.get(0));
//        assertEquals(polizaVehicular.getPolizaId(), listaPolizaVehicularId.get(0));
//        
//        polizaVehicular = this.polizaVehicularDAO.obtenerPorId(listaPolizaVehicularId.get(1));
//        assertEquals(polizaVehicular.getPolizaId(), listaPolizaVehicularId.get(1));
//        
//        polizaVehicular = this.polizaVehicularDAO.obtenerPorId(listaPolizaVehicularId.get(2));
//        assertEquals(polizaVehicular.getPolizaId(), listaPolizaVehicularId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaPolizaVehicularId = new ArrayList<>();
//        insertarPolizasVehiculares(listaPolizaVehicularId);
//        
//        ArrayList<PolizasVehicularesDTO> listaPolizasVehiculares = this.polizaVehicularDAO.listarTodos();
//        assertEquals(listaPolizaVehicularId.size()+3, listaPolizasVehiculares.size());
//        for (Integer i = 0; i < listaPolizasVehiculares.size(); i++) {
//            if(listaPolizasVehiculares.get(i).getPolizaId()>3){
//                assertEquals(listaPolizaVehicularId.get(i-3), listaPolizasVehiculares.get(i).getPolizaId());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaPolizaVehicularId = new ArrayList<>();
//        insertarPolizasVehiculares(listaPolizaVehicularId);
//        
//        ArrayList<PolizasVehicularesDTO> listaPolizasVehiculares = this.polizaVehicularDAO.listarTodos();
//        assertEquals(listaPolizaVehicularId.size()+3, listaPolizasVehiculares.size());
//        for (Integer i = 0; i < listaPolizasVehiculares.size(); i++) {
//            if(listaPolizasVehiculares.get(i).getPolizaId()>3){
//                listaPolizasVehiculares.get(i).setEstado(EstadoPoliza.VENCIDO);
//                listaPolizasVehiculares.get(i).setTipo(TipoPolizaVehicular.TODORIESGO);
//                listaPolizasVehiculares.get(i).setPorcentajeCobertura(40);
//                this.polizaVehicularDAO.modificar(listaPolizasVehiculares.get(i));
//            }
//        }
//        
//        ArrayList<PolizasVehicularesDTO> listaPolizasVehicularesModificadas = this.polizaVehicularDAO.listarTodos();
//        assertEquals(listaPolizasVehiculares.size(), listaPolizasVehicularesModificadas.size());
//        for (Integer i = 0; i < listaPolizasVehiculares.size(); i++) {
//            if(listaPolizasVehiculares.get(i).getPolizaId()>3){
//                assertEquals(listaPolizasVehiculares.get(i).getEstado(), listaPolizasVehicularesModificadas.get(i).getEstado());
//                assertEquals(listaPolizasVehiculares.get(i).getTipo(), listaPolizasVehicularesModificadas.get(i).getTipo());
//                assertEquals(listaPolizasVehiculares.get(i).getPorcentajeCobertura(), listaPolizasVehicularesModificadas.get(i).getPorcentajeCobertura());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaPolizaVehicularId = new ArrayList<>();
//        insertarPolizasVehiculares(listaPolizaVehicularId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<PolizasVehicularesDTO> listaPolizasVehiculares = this.polizaVehicularDAO.listarTodos();
//        for (Integer i = 0; i < listaPolizasVehiculares.size(); i++) {
//            if(listaPolizasVehiculares.get(i).getPolizaId()>3){
//                Integer resultado = this.polizaVehicularDAO.eliminar(listaPolizasVehiculares.get(i));
//                assertNotEquals(0, resultado);
//                PolizasVehicularesDTO polizaVehicular = this.polizaVehicularDAO.obtenerPorId(listaPolizasVehiculares.get(i).getPolizaId());
//                assertNull(polizaVehicular);
//            }
//        }
//    }
//    
//}
