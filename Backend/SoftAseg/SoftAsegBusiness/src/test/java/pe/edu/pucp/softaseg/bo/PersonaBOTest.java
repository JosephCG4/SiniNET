package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

public class PersonaBOTest {

    private PersonaBO personaBO;

    public PersonaBOTest() {
        this.personaBO = new PersonaBO();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("=== TEST PersonaBO ===");
//
//        // INSERTAR
//        System.out.println("Insertar:");
//        PersonasDTO personaDTO = new PersonasDTO();
//        personaDTO.setDni("12345678");
//        personaDTO.setNombres("Luis");
//        personaDTO.setApellidoPaterno("Carhuayo");
//        personaDTO.setApellidoMaterno("Gomez");
//        personaDTO.setTelefono("987654321");
//        Integer personaBuscar = this.personaBO.insertar(personaDTO);
//        
//        
//        // OBTENER
//        System.out.println("ObtenerPorId:");
//        PersonasDTO persona = this.personaBO.obtenerPorId(personaBuscar);
//        System.out.println(persona.getPersonalId());
//        System.out.println(persona.getNombres());
//        System.out.println(persona.getApellidoPaterno());
//        System.out.println(persona.getTelefono());
//
//        // LISTAR
//        System.out.println("ListarTodos:");
//        ArrayList<PersonasDTO> lista = this.personaBO.listarTodos();
//        for (PersonasDTO p : lista) {
//            System.out.println(p.getPersonalId() + " - " + p.getNombres());
//        }
//
//        // MODIFICAR
//        System.out.println("Modificar:");
//        persona = this.personaBO.obtenerPorId(personaBuscar);
//        
//        persona.setDni("12345678");
//        persona.setNombres("Luis Mod");
//        persona.setApellidoPaterno("Carhuayo");
//        persona.setApellidoMaterno("Gomez");
//        persona.setTelefono("999888777");
//        this.personaBO.modificar(persona);
//        System.out.println(persona.getNombres());
//        assertEquals("Luis Mod", persona.getNombres());
//
//        // ELIMINAR
//        System.out.println("Eliminar:");
//        this.personaBO.eliminar(persona.getPersonalId());
//        persona = this.personaBO.obtenerPorId(persona.getPersonalId());
//        assertNull(persona);
//    }
}

