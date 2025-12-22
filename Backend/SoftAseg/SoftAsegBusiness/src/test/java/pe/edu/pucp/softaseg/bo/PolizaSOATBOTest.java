/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoPoliza;


public class PolizaSOATBOTest {
    
    private PolizaSOATBO polizaSOATBO;
    private PersonaBO personaBO;
    
    public PolizaSOATBOTest() {
        this.polizaSOATBO = new PolizaSOATBO();
        this.personaBO = new PersonaBO();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        PolizasSOATDTO polizaDTO = new PolizasSOATDTO();
//        PersonasDTO personaDTO = this.personaBO.obtenerPorId(1);
//        polizaDTO.setAsegurado(personaDTO);
//        polizaDTO.setEstado(EstadoPoliza.VENCIDO);
//        polizaDTO.setMontoACobertura(20);
//        
//        
//        Integer polizaId = this.polizaSOATBO.insertar(polizaDTO);
//        
//        System.out.println("ObtenerPorId:");
//        PolizasSOATDTO polizasSOATDTOObtenido = this.polizaSOATBO.obtenerPorId(polizaId);
//        System.out.println(polizasSOATDTOObtenido.getPolizaId());
//        System.out.println(polizasSOATDTOObtenido.getAsegurado().getPersonalId());
//        System.out.println(polizasSOATDTOObtenido.getEstado());
//        System.out.println(polizasSOATDTOObtenido.getMontoACobertura());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<PolizasSOATDTO> listaPolizasSOATDTO = this.polizaSOATBO.listarTodos();
//        for (Integer i = 0; i < listaPolizasSOATDTO.size(); i++){
//            System.out.println(listaPolizasSOATDTO.get(i).getPolizaId());
//            System.out.println(listaPolizasSOATDTO.get(i).getAsegurado().getPersonalId());
//            System.out.println(listaPolizasSOATDTO.get(i).getEstado());
//            System.out.println(listaPolizasSOATDTO.get(i).getMontoACobertura());
//        }
//        
//        System.out.println("Modificar:");
//        
//        PersonasDTO personaDTOModificar = this.personaBO.obtenerPorId(2);
//        
//        polizasSOATDTOObtenido.setAsegurado(personaDTOModificar);
//        polizasSOATDTOObtenido.setEstado(EstadoPoliza.VIGENTE);
//        polizasSOATDTOObtenido.setMontoACobertura(40);
//        
//        this.polizaSOATBO.modificar(polizasSOATDTOObtenido);
//        
//        PolizasSOATDTO polizasSOATDTOModificado = this.polizaSOATBO.obtenerPorId(polizaId);
//        System.out.println(polizasSOATDTOModificado.getPolizaId());
//        System.out.println(polizasSOATDTOModificado.getAsegurado().getPersonalId());
//        System.out.println(polizasSOATDTOModificado.getEstado());
//        System.out.println(polizasSOATDTOModificado.getMontoACobertura());
//        
//        System.out.println("Eliminar:");
//        this.polizaSOATBO.eliminar(polizaId);
//        polizasSOATDTOModificado = this.polizaSOATBO.obtenerPorId(polizaId);
//        assertNull(polizasSOATDTOModificado);
//    }
    
}
