
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;


public class CentroDeSaludBOTest {
    
    private CentroDeSaludBO centroDeSaludBO;
    
    public CentroDeSaludBOTest() {
        this.centroDeSaludBO = new CentroDeSaludBO();
    }

//    @Test
//    public void testTodo() {
//        System.out.println("Insertar:");
//        UbicacionesDTO ubicacionesDTO = new UbicacionesDTO();
//        ubicacionesDTO.setDireccion("direccionTest");
//        ubicacionesDTO.setReferencia("referenciaTest");
//        ubicacionesDTO.setLatitud(11.11);
//        ubicacionesDTO.setLongitud(11.11);
//        CentrosDeSaludDTO centroDeSaludDTO = new CentrosDeSaludDTO();
//        centroDeSaludDTO.setCodigoRenipress("codigoTest");
//        centroDeSaludDTO.setNombre("nombreTest");
//        centroDeSaludDTO.setTelefono("telefTest");
//        centroDeSaludDTO.setUbicacion(ubicacionesDTO);
//        Integer centroDeSaludId = this.centroDeSaludBO.insertar(centroDeSaludDTO);
//        
//        System.out.println("ObtenerPorId:");
//        centroDeSaludDTO = this.centroDeSaludBO.obtenerPorId(centroDeSaludId);
//        System.out.println(centroDeSaludDTO.getCentroDeSaludId());
//        System.out.println(centroDeSaludDTO.getCodigoRenipress());
//        System.out.println(centroDeSaludDTO.getNombre());
//        System.out.println(centroDeSaludDTO.getTelefono());
//        System.out.println(centroDeSaludDTO.getUbicacion().getUbicacionId());
//        System.out.println(centroDeSaludDTO.getUbicacion().getDireccion());
//        System.out.println(centroDeSaludDTO.getUbicacion().getReferencia());
//        System.out.println(centroDeSaludDTO.getUbicacion().getLatitud());
//        System.out.println(centroDeSaludDTO.getUbicacion().getLongitud());
//        
//        System.out.println("ListarTodos:");
//        ArrayList<CentrosDeSaludDTO> listaCentrosDeSaludDTO= this.centroDeSaludBO.listarTodos();
//        for (Integer i = 0; i < listaCentrosDeSaludDTO.size(); i++){
//            System.out.println(listaCentrosDeSaludDTO.get(i).getCentroDeSaludId());
//            System.out.println(listaCentrosDeSaludDTO.get(i).getCodigoRenipress());
//            System.out.println(listaCentrosDeSaludDTO.get(i).getNombre());
//            System.out.println(listaCentrosDeSaludDTO.get(i).getTelefono());
//            System.out.println(listaCentrosDeSaludDTO.get(i).getUbicacion().getUbicacionId());
//        }
//        
//        System.out.println("Modificar:");
//        
//        ubicacionesDTO.setDireccion("direccionMod");
//        ubicacionesDTO.setReferencia("referenciaMod");
//        ubicacionesDTO.setLatitud(99.99);
//        ubicacionesDTO.setLongitud(99.99);
//        centroDeSaludDTO.setCodigoRenipress("codigoMod");
//        centroDeSaludDTO.setNombre("nombreMod");
//        centroDeSaludDTO.setTelefono("telefoMod");
//        centroDeSaludDTO.setUbicacion(ubicacionesDTO);
//        
//        this.centroDeSaludBO.modificar(centroDeSaludDTO);
//        centroDeSaludDTO = this.centroDeSaludBO.obtenerPorId(centroDeSaludId);
//        System.out.println(centroDeSaludDTO.getCentroDeSaludId());
//        System.out.println(centroDeSaludDTO.getCodigoRenipress());
//        System.out.println(centroDeSaludDTO.getNombre());
//        System.out.println(centroDeSaludDTO.getTelefono());
//        System.out.println(centroDeSaludDTO.getUbicacion().getUbicacionId());
//        System.out.println(centroDeSaludDTO.getUbicacion().getDireccion());
//        System.out.println(centroDeSaludDTO.getUbicacion().getReferencia());
//        System.out.println(centroDeSaludDTO.getUbicacion().getLatitud());
//        System.out.println(centroDeSaludDTO.getUbicacion().getLongitud());
//        
//        System.out.println("Eliminar:");
//        this.centroDeSaludBO.eliminar(centroDeSaludId);
//        centroDeSaludDTO = this.centroDeSaludBO.obtenerPorId(centroDeSaludId);
//        assertNull(centroDeSaludDTO);
//        
//    }
    
}
