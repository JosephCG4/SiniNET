
package pe.edu.pucp.softaseg.model.gestionSiniestros;

public class CentrosDeSaludDTO {

    private Integer centroDeSaludId;
    private String codigoRenipress;
    private String nombre;
    private UbicacionesDTO ubicacion;
    private String telefono;

    public CentrosDeSaludDTO() {
        this.centroDeSaludId = null;
        this.codigoRenipress = null;
        this.nombre = null;
        this.ubicacion = null;
        this.telefono = null;
    }

    public CentrosDeSaludDTO(Integer centroDeSaludId, String codigoRenipress, String nombre,
                             UbicacionesDTO ubicacion, String telefono) {
        this.centroDeSaludId = centroDeSaludId;
        this.codigoRenipress = codigoRenipress;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    /**
     * @return the centroDeSaludId
     */
    public Integer getCentroDeSaludId() {
        return centroDeSaludId;
    }

    /**
     * @param centroDeSaludId the centroDeSaludId to set
     */
    public void setCentroDeSaludId(Integer centroDeSaludId) {
        this.centroDeSaludId = centroDeSaludId;
    }

    /**
     * @return the codigoRenipress
     */
    public String getCodigoRenipress() {
        return codigoRenipress;
    }

    /**
     * @param codigoRenipress the codigoRenipress to set
     */
    public void setCodigoRenipress(String codigoRenipress) {
        this.codigoRenipress = codigoRenipress;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
