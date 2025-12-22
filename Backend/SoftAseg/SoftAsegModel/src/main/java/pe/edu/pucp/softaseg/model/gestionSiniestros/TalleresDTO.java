
package pe.edu.pucp.softaseg.model.gestionSiniestros;

public class TalleresDTO {

    private Integer tallerId;
    private String nombre;
    private UbicacionesDTO ubicacion;
    private String telefono;

    // Constructor vacío
    public TalleresDTO() {
        this.tallerId = null;
        this.nombre = null;
        this.ubicacion = null;
        this.telefono = null;
    }

    // Constructor completo
    public TalleresDTO(Integer tallerId, String nombre, UbicacionesDTO ubicacion, String telefono) {
        this.tallerId = tallerId;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }

    /**
     * @return the tallerId
     */
    public Integer getTallerId() {
        return tallerId;
    }

    /**
     * @param tallerId the tallerId to set
     */
    public void setTallerId(Integer tallerId) {
        this.tallerId = tallerId;
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

