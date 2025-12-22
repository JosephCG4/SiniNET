package pe.edu.pucp.softaseg.model.gestionSiniestros;

import java.time.LocalDateTime;

public class ImagenSiniestroDTO {
    private Integer imagenId;
    private Integer siniestroId;
    private String url;
    private String nombreArchivo;
    private LocalDateTime fechaSubida;
    private Boolean validez;

    public ImagenSiniestroDTO() {
        this.imagenId = null;
        this.siniestroId = null;
        this.url = null;
        this.nombreArchivo = null;
        this.fechaSubida = null;
        this.validez = null;
    }

    public Integer getImagenId() {
        return imagenId;
    }

    public void setImagenId(Integer imagenId) {
        this.imagenId = imagenId;
    }

    public Integer getSiniestroId() {
        return siniestroId;
    }

    public void setSiniestroId(Integer siniestroId) {
        this.siniestroId = siniestroId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public LocalDateTime getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDateTime fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    public Boolean getValidez() {
        return validez;
    }

    public void setValidez(Boolean validez) {
        this.validez = validez;
    }
}
