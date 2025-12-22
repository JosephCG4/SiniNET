package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

//public class PersonaDAOTest {
//    
//    private PersonaDAO personaDAO;    
//    
//    public PersonaDAOTest() {
//        this.personaDAO = new PersonaDAOImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        eliminarTodo();
//    }
//    
//    private void insertarPersonas(ArrayList<Integer> listaPersonaId) {
//        PersonasDTO persona = new PersonasDTO();
//        persona.setDni("76501111");
//        persona.setNombres("Jose Ernesto");
//        persona.setApellidoPaterno("Lopez");
//        persona.setApellidoMaterno("Aguirre");
//        persona.setTelefono("999111444");
//        Integer resultado = this.personaDAO.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);
//        
//        persona.setDni("76501112");
//        persona.setNombres("Luis Armando");
//        persona.setApellidoPaterno("Perez");
//        persona.setApellidoMaterno("Mamani");
//        persona.setTelefono("999222555");
//        resultado = this.personaDAO.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);
//        
//        persona.setDni("76501113");
//        persona.setNombres("Marcelo Enrique");
//        persona.setApellidoPaterno("Chavez");
//        persona.setApellidoMaterno("Llican");
//        persona.setTelefono("999333666");
//        resultado = this.personaDAO.insertar(persona);
//        assertTrue(resultado != 0);
//        listaPersonaId.add(resultado);       
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        PersonasDTO persona = this.personaDAO.obtenerPorId(listaPersonaId.get(0));
//        assertEquals(persona.getPersonalId(), listaPersonaId.get(0));
//        
//        persona = this.personaDAO.obtenerPorId(listaPersonaId.get(1));
//        assertEquals(persona.getPersonalId(), listaPersonaId.get(1));
//        
//        persona = this.personaDAO.obtenerPorId(listaPersonaId.get(2));
//        assertEquals(persona.getPersonalId(), listaPersonaId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        
//        ArrayList<PersonasDTO> listaPersonas = this.personaDAO.listarTodos();
//        assertEquals(listaPersonaId.size()+9, listaPersonas.size());
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            if(listaPersonas.get(i).getPersonalId()>9)
//                assertEquals(listaPersonaId.get(i-9), listaPersonas.get(i).getPersonalId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        
//        ArrayList<PersonasDTO> listaPersonas = this.personaDAO.listarTodos();
//        assertEquals(listaPersonaId.size()+9, listaPersonas.size());
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            if(listaPersonas.get(i).getPersonalId()>9){
//                listaPersonas.get(i).setDni("12340001");
//                listaPersonas.get(i).setNombres("NombrePrueba " + i.toString());
//                listaPersonas.get(i).setApellidoPaterno("ApellidoPaternoPrueba " + i.toString());
//                listaPersonas.get(i).setApellidoMaterno("ApellidoMaternoPrueba " + i.toString());
//                listaPersonas.get(i).setTelefono("999000001");
//                this.personaDAO.modificar(listaPersonas.get(i));
//            }
//        }
//        
//        ArrayList<PersonasDTO> listaPersonasModificadas = this.personaDAO.listarTodos();
//        assertEquals( listaPersonas.size(), listaPersonasModificadas.size());
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            if(listaPersonas.get(i).getPersonalId()>9){
//                assertEquals(listaPersonas.get(i).getDni(), listaPersonasModificadas.get(i).getDni());
//                assertEquals(listaPersonas.get(i).getNombres(), listaPersonasModificadas.get(i).getNombres());
//                assertEquals(listaPersonas.get(i).getApellidoPaterno(), listaPersonasModificadas.get(i).getApellidoPaterno());
//                assertEquals(listaPersonas.get(i).getApellidoMaterno(), listaPersonasModificadas.get(i).getApellidoMaterno());
//                assertEquals(listaPersonas.get(i).getTelefono(), listaPersonasModificadas.get(i).getTelefono());
//            }
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaPersonaId = new ArrayList<>();
//        insertarPersonas(listaPersonaId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<PersonasDTO> listaPersonas = this.personaDAO.listarTodos();
//        for (Integer i = 0; i < listaPersonas.size(); i++) {
//            if(listaPersonas.get(i).getPersonalId()>9){
//                Integer resultado = this.personaDAO.eliminar(listaPersonas.get(i));
//                assertNotEquals(0, resultado);
//                PersonasDTO taller = this.personaDAO.obtenerPorId(listaPersonas.get(i).getPersonalId());
//                assertNull(taller);
//            }
//        }
//    }
//}
