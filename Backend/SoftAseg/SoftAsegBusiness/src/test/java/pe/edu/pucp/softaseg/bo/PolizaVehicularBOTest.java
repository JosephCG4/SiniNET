/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.util.TipoPolizaVehicular;

public class PolizaVehicularBOTest {
    private PolizaVehicularBO polizaVehicularBO;
    private PersonaBO personaBO;
    
    public PolizaVehicularBOTest() {
        this.polizaVehicularBO = new PolizaVehicularBO();
        this.personaBO = new PersonaBO();
    }
    
//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        PolizasVehicularesDTO polizaDTO = new PolizasVehicularesDTO();
//        PersonasDTO personaDTO = this.personaBO.obtenerPorId(1);
//        polizaDTO.setAsegurado(personaDTO);
//        polizaDTO.setEstado(EstadoPoliza.VENCIDO);
//        polizaDTO.setTipo(TipoPolizaVehicular.PERDIDATOTAL);
//        polizaDTO.setPorcentajeCobertura(40);
//        
//        Integer polizaId = this.polizaVehicularBO.insertar(polizaDTO);
//        
//        System.out.println("ObtenerPorId:");
//        PolizasVehicularesDTO polizasVehicularesDTOObtenido = this.polizaVehicularBO.obtenerPorId(polizaId);
//        System.out.println(polizasVehicularesDTOObtenido.getPolizaId());
//        System.out.println(polizasVehicularesDTOObtenido.getAsegurado().getPersonalId());
//        System.out.println(polizasVehicularesDTOObtenido.getEstado());
//        System.out.println(polizasVehicularesDTOObtenido.getTipo());
//        System.out.println(polizasVehicularesDTOObtenido.getPorcentajeCobertura());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<PolizasVehicularesDTO> listaPolizasVehicularesDTO = this.polizaVehicularBO.listarTodos();
//        for (Integer i = 0; i < listaPolizasVehicularesDTO.size(); i++){
//            System.out.println(listaPolizasVehicularesDTO.get(i).getPolizaId());
//            System.out.println(listaPolizasVehicularesDTO.get(i).getAsegurado().getPersonalId());
//            System.out.println(listaPolizasVehicularesDTO.get(i).getEstado());
//            System.out.println(listaPolizasVehicularesDTO.get(i).getTipo());
//            System.out.println(listaPolizasVehicularesDTO.get(i).getPorcentajeCobertura());
//        }
//        
//        System.out.println("Modificar:");
//        
//        PersonasDTO personaDTOModificar = this.personaBO.obtenerPorId(1);
//        polizasVehicularesDTOObtenido.setAsegurado(personaDTOModificar);
//        polizasVehicularesDTOObtenido.setEstado(EstadoPoliza.VIGENTE);
//        polizasVehicularesDTOObtenido.setTipo(TipoPolizaVehicular.TODORIESGO);
//        polizasVehicularesDTOObtenido.setPorcentajeCobertura(70);
//        this.polizaVehicularBO.modificar(polizasVehicularesDTOObtenido);
//        PolizasVehicularesDTO polizasVehicularesDTOModificado = this.polizaVehicularBO.obtenerPorId(polizaId);
//        System.out.println(polizasVehicularesDTOModificado.getPolizaId());
//        System.out.println(polizasVehicularesDTOModificado.getAsegurado().getPersonalId());
//        System.out.println(polizasVehicularesDTOModificado.getEstado());
//        System.out.println(polizasVehicularesDTOModificado.getTipo());
//        System.out.println(polizasVehicularesDTOModificado.getPorcentajeCobertura());
//        
//        System.out.println("Eliminar:");
//        this.polizaVehicularBO.eliminar(polizaId);
//        polizasVehicularesDTOModificado = this.polizaVehicularBO.obtenerPorId(polizaId);
//        assertNull(polizasVehicularesDTOModificado);
//    }
    
}
