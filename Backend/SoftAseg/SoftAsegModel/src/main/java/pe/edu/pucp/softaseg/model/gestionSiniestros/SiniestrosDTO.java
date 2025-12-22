
package pe.edu.pucp.softaseg.model.gestionSiniestros;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import java.time.LocalDateTime;

public class SiniestrosDTO {
    
    private Integer siniestroId;
    private String descripcion;    
    private LocalDateTime fechaHora;
    private EstadoSiniestro estado;
    private Integer calificacionServicio;
    private UbicacionesDTO ubicacion;
    private EmpleadosDTO procurador;
    private Boolean validez;

    public SiniestrosDTO() {
        this.siniestroId = null;
        this.descripcion = null;
        this.fechaHora = null;
        this.estado = null;
        this.calificacionServicio = null;
        this.ubicacion = null;
        this.procurador = null;
        this.validez = null;
    }

    public SiniestrosDTO(Integer siniestroId, String descripcion, LocalDateTime fechaHora,
                         EstadoSiniestro estado, Integer calificacionServicio,
                         UbicacionesDTO ubicacion, EmpleadosDTO procurador,
                         Boolean validez){
        this.siniestroId = siniestroId;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.calificacionServicio = calificacionServicio;
        this.ubicacion = ubicacion;
        this.procurador = procurador;
        this.validez = validez;
    }
    
    /**
     * @return the siniestroId
     */
    public Integer getSiniestroId() {
        return siniestroId;
    }

    /**
     * @param siniestroId the siniestroId to set
     */
    public void setSiniestroId(Integer siniestroId) {
        this.siniestroId = siniestroId;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaHora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the estado
     */
    public EstadoSiniestro getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoSiniestro estado) {
        this.estado = estado;
    }

    /**
     * @return the calificacionServicio
     */
    public Integer getCalificacionServicio() {
        return calificacionServicio;
    }

    /**
     * @param calificacionServicio the calificacionServicio to set
     */
    public void setCalificacionServicio(Integer calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
    }

    /**
     * @return the ubicacion
     */
    public UbicacionesDTO getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(UbicacionesDTO ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the procurador
     */
    public EmpleadosDTO getProcurador() {
        return procurador;
    }

    /**
     * @param procurador the procurador to set
     */
    public void setProcurador(EmpleadosDTO procurador) {
        this.procurador = procurador;
    }

    /**
     * @return the validez
     */
    public Boolean getValidez() {
        return validez;
    }

    /**
     * @param validez the validez to set
     */
    public void setValidez(Boolean validez) {
        this.validez = validez;
    }

}