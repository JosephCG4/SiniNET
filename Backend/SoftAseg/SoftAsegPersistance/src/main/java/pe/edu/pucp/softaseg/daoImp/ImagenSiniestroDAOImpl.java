package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softaseg.dao.ImagenSiniestroDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.ImagenSiniestroDTO;

public class ImagenSiniestroDAOImpl extends DAOImplBase implements ImagenSiniestroDAO {

    private ImagenSiniestroDTO imagen;

    public ImagenSiniestroDAOImpl() {
        super("GS_IMAGEN_SINIESTRO");
        this.imagen = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("IMAGEN_SINIESTRO_ID", true, true));
        this.listaColumnas.add(new Columna("SINIESTRO_ID", false, false));
        this.listaColumnas.add(new Columna("URL", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.imagen.getSiniestroId());
        this.statement.setString(2, this.imagen.getUrl());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        throw new UnsupportedOperationException("No implementado");
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.imagen.getImagenId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.imagen.getImagenId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.imagen = new ImagenSiniestroDTO();
        this.imagen.setImagenId(this.resultSet.getInt("IMAGEN_SINIESTRO_ID"));
        this.imagen.setSiniestroId(this.resultSet.getInt("SINIESTRO_ID"));
        this.imagen.setUrl(this.resultSet.getString("URL"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.imagen = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.imagen);
    }

    @Override
    public Integer insertar(ImagenSiniestroDTO imagen) {
        this.imagen = imagen;
        return super.insertar();
    }

    @Override
    public ImagenSiniestroDTO obtenerPorId(Integer imagenId) {
        ImagenSiniestroDTO dto = new ImagenSiniestroDTO();
        dto.setImagenId(imagenId);
        this.imagen = dto;
        super.obtenerPorId();
        return this.imagen;
    }

    
    @Override
    public ArrayList<ImagenSiniestroDTO> listarPorSiniestro(Integer siniestroId) {
        // SQL que filtra por SINIESTRO_ID para agrupar las imágenes
        String sql = "SELECT IMAGEN_SINIESTRO_ID, SINIESTRO_ID, URL "
                   + "FROM GS_IMAGEN_SINIESTRO "
                   + "WHERE SINIESTRO_ID = ? "  // ← FILTRO POR ID DE SINIESTRO
                   + "ORDER BY IMAGEN_SINIESTRO_ID DESC";  // Más recientes primero
        
        return (ArrayList<ImagenSiniestroDTO>) super.listarTodos(sql, (obj) -> {
            try {
                // Asignar el parámetro ? con el siniestroId
                this.statement.setInt(1, siniestroId);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }, null);
    }

    @Override
    public Integer eliminar(Integer imagenId) {
        ImagenSiniestroDTO dto = new ImagenSiniestroDTO();
        dto.setImagenId(imagenId);
        this.imagen = dto;
        return super.eliminar();
    }
}