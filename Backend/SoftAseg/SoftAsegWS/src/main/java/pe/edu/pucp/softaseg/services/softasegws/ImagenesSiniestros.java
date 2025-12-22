package pe.edu.pucp.softaseg.services.softasegws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import pe.edu.pucp.softaseg.bo.ImagenSiniestroBO;
import pe.edu.pucp.softaseg.bo.SiniestroVehicularBO;
import pe.edu.pucp.softaseg.bo.SiniestroSOATBO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.ImagenSiniestroDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;
import pe.edu.pucp.softaseg.services.softasegws.resources.CloudinaryService;

@WebService(serviceName = "ImagenesSiniestros")
public class ImagenesSiniestros {

    private final ImagenSiniestroBO bo;
    private final CloudinaryService cloudinaryService;
    private final SiniestroVehicularBO siniestroVehicularBO;
    private final SiniestroSOATBO siniestroSOATBO;

    public ImagenesSiniestros() {
        this.bo = new ImagenSiniestroBO();
        this.cloudinaryService = new CloudinaryService();
        this.siniestroVehicularBO = new SiniestroVehicularBO();
        this.siniestroSOATBO = new SiniestroSOATBO();
    }

    private boolean verificarSiniestroExiste(Integer siniestroId) {
        try {
            SiniestrosVehicularesDTO siniestroVehicular = this.siniestroVehicularBO.obtenerPorId(siniestroId);
            if (siniestroVehicular != null && siniestroVehicular.getSiniestroId() != null) {
                return true;
            }
        } catch (Exception e) {
        }
        
        try {
            SiniestrosSOATDTO siniestroSOAT = this.siniestroSOATBO.obtenerPorId(siniestroId);
            if (siniestroSOAT != null && siniestroSOAT.getSiniestroId() != null) {
                return true;
            }
        } catch (Exception e) {
        }
        
        return false;
    }

    @WebMethod(operationName = "subirImagenSiniestro")
    public Integer subirImagenSiniestro(
            @WebParam(name = "siniestroId") Integer siniestroId,
            @WebParam(name = "nombreArchivo") String nombreArchivo,
            @WebParam(name = "contenidoBase64") String contenidoBase64
    ) {
        try {
            if (!verificarSiniestroExiste(siniestroId)) {
                System.err.println("Error: El siniestro con ID " + siniestroId + " no existe");
                return 0;
            }
            
            if (contenidoBase64 == null || contenidoBase64.trim().isEmpty()) {
                System.err.println("Error: Base64 está vacío");
                return 0;
            }
            
            String base64Limpio = contenidoBase64
                .replaceAll("\\s+", "")
                .replaceAll("\\r", "")
                .replaceAll("\\n", "")
                .trim();
            
            byte[] imagenBytes;
            try {
                imagenBytes = Base64.getDecoder().decode(base64Limpio);
                if (imagenBytes.length < 10) {
                    System.err.println("Error: La imagen es demasiado pequeña");
                    return 0;
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: Base64 inválido - " + e.getMessage());
                return 0;
            }
            
            String nombreUnico = siniestroId + "_" + System.currentTimeMillis() + "_" + nombreArchivo;
            String urlImagen = cloudinaryService.subirImagen(imagenBytes, nombreUnico);
            
            if (urlImagen == null || urlImagen.isEmpty()) {
                System.err.println("Error: No se pudo subir la imagen a Cloudinary");
                return 0;
            }
            
            ImagenSiniestroDTO dto = new ImagenSiniestroDTO();
            dto.setSiniestroId(siniestroId);
            dto.setUrl(urlImagen);
            dto.setNombreArchivo(nombreArchivo);
            dto.setFechaSubida(LocalDateTime.now());
            dto.setValidez(true);

            Integer imagenId = this.bo.insertar(dto);
            
            if (imagenId == null || imagenId == 0) {
                System.err.println("Error: No se pudo insertar en BD");
                return 0;
            }
            
            return imagenId;
            
        } catch (Exception e) {
            System.err.println("Error general al subir imagen: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    @WebMethod(operationName = "listarImagenesPorSiniestro")
    public ArrayList<ImagenSiniestroDTO> listarImagenesPorSiniestro(
            @WebParam(name = "siniestroId") Integer siniestroId
    ) {
        return this.bo.listarPorSiniestro(siniestroId);
    }

    @WebMethod(operationName = "eliminarImagenSiniestro")
    public Integer eliminarImagenSiniestro(
            @WebParam(name = "imagenId") Integer imagenId
    ) {
        try {
            ImagenSiniestroDTO imagen = this.bo.obtenerPorId(imagenId);
            if (imagen == null) {
                System.err.println("Error: La imagen con ID " + imagenId + " no existe");
                return 0;
            }
            
            String url = imagen.getUrl();
            String publicId = null;
            
            if (url != null && url.contains("/siniestros/")) {
                int startIdx = url.indexOf("/siniestros/") + "/siniestros/".length();
                int endIdx = url.indexOf(".", startIdx);
                if (endIdx == -1) {
                    endIdx = url.length();
                }
                publicId = "siniestros/" + url.substring(startIdx, endIdx);
            }
            
            if (publicId != null) {
                cloudinaryService.eliminarImagen(publicId);
            }
            
            Integer resultado = this.bo.eliminar(imagenId);
            return resultado;
            
        } catch (Exception e) {
            System.err.println("Error al eliminar imagen: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}