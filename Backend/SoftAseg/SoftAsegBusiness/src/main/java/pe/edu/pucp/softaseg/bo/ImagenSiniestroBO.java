package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.ImagenSiniestroDAO;
import pe.edu.pucp.softaseg.daoImp.ImagenSiniestroDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.ImagenSiniestroDTO;

public class ImagenSiniestroBO {
    private final ImagenSiniestroDAO dao;

    public ImagenSiniestroBO() {
        this.dao = new ImagenSiniestroDAOImpl();
    }

    public Integer insertar(ImagenSiniestroDTO dto) {
        return this.dao.insertar(dto);
    }

    public ImagenSiniestroDTO obtenerPorId(Integer imagenId) {
        return this.dao.obtenerPorId(imagenId);
    }

    public ArrayList<ImagenSiniestroDTO> listarPorSiniestro(Integer siniestroId) {
        return this.dao.listarPorSiniestro(siniestroId);
    }

    public Integer eliminar(Integer imagenId) {
        return this.dao.eliminar(imagenId);
    }
}