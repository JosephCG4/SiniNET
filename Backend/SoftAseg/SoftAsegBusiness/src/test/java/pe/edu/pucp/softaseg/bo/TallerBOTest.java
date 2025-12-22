
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

public class TallerBOTest {
    
    private TallerBO tallerBO;
    
    public TallerBOTest() {
        this.tallerBO = new TallerBO();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        UbicacionesDTO ubicacionesDTO = new UbicacionesDTO();
//        ubicacionesDTO.setDireccion("direccionTest");
//        ubicacionesDTO.setReferencia("referenciaTest");
//        ubicacionesDTO.setLatitud(11.11);
//        ubicacionesDTO.setLongitud(11.11);
//        TalleresDTO tallerDTO = new TalleresDTO();
//        tallerDTO.setNombre("nombreTest");
//        tallerDTO.setTelefono("telefTest");
//        tallerDTO.setUbicacion(ubicacionesDTO);
//        Integer tallerId = this.tallerBO.insertar(tallerDTO);
//        
//        System.out.println("ObtenerPorId:");
//        tallerDTO = this.tallerBO.obtenerPorId(tallerId);
//        System.out.println(tallerDTO.getTallerId());
//        System.out.println(tallerDTO.getNombre());
//        System.out.println(tallerDTO.getTelefono());
//        System.out.println(tallerDTO.getUbicacion().getUbicacionId());
//        System.out.println(tallerDTO.getUbicacion().getDireccion());
//        System.out.println(tallerDTO.getUbicacion().getReferencia());
//        System.out.println(tallerDTO.getUbicacion().getLatitud());
//        System.out.println(tallerDTO.getUbicacion().getLongitud());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<TalleresDTO> listaTalleresDTO= this.tallerBO.listarTodos();
//        for (Integer i = 0; i < listaTalleresDTO.size(); i++){
//            System.out.println(listaTalleresDTO.get(i).getTallerId());
//            System.out.println(listaTalleresDTO.get(i).getNombre());
//            System.out.println(listaTalleresDTO.get(i).getTelefono());
//            System.out.println(listaTalleresDTO.get(i).getUbicacion().getUbicacionId());
//        }
//        
//        System.out.println("Modificar:");
//        ubicacionesDTO.setDireccion("direccionMod");
//        ubicacionesDTO.setReferencia("referenciaMod");
//        ubicacionesDTO.setLatitud(99.99);
//        ubicacionesDTO.setLongitud(99.99);
//        tallerDTO.setNombre("nombreMod");
//        tallerDTO.setTelefono("telefoMod");
//        tallerDTO.setUbicacion(ubicacionesDTO);
//        this.tallerBO.modificar(tallerDTO);
//        
//        tallerDTO = this.tallerBO.obtenerPorId(tallerId);
//        System.out.println(tallerDTO.getTallerId());
//        System.out.println(tallerDTO.getNombre());
//        System.out.println(tallerDTO.getTelefono());
//        System.out.println(tallerDTO.getUbicacion().getUbicacionId());
//        
//        System.out.println("Eliminar:");
//        this.tallerBO.eliminar(tallerId);
//        tallerDTO = this.tallerBO.obtenerPorId(tallerId);
//        assertNull(tallerDTO);
//        
//    }
}
