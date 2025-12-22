
package pe.edu.pucp.softaseg.model.gestionSiniestros;

public class UbicacionesDTO {
    private Integer ubicacionId;
    private String direccion;
    private String referencia;
    private Double latitud;
    private Double longitud;
    
    public UbicacionesDTO(){
        this.ubicacionId = null;
        this.direccion = null;
        this.referencia = null;
        this.latitud = null;
        this.longitud = null;
    }
    
    public UbicacionesDTO(Integer ubicacionId, String direccion, String referencia,
            Double latitud, Double longitud){
        this.ubicacionId = ubicacionId;
        this.direccion = direccion;
        this.referencia = referencia;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    /**
     * @return the ubicacionId
     */
    public Integer getUbicacionId() {
        return ubicacionId;
    }

    /**
     * @param ubicacionId the ubicacionId to set
     */
    public void setUbicacionId(Integer ubicacionId) {
        this.ubicacionId = ubicacionId;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    
}
