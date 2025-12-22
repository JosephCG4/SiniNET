
package pe.edu.pucp.softaseg.model.usuarios;

public class PersonasDTO {

    protected Integer personalId;
    protected String dni;
    protected String nombres;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String telefono;

    public PersonasDTO() {
        this.personalId = null;
        this.dni = null;
        this.nombres = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.telefono = null;
    }

    public PersonasDTO(Integer personalId, String dni, String nombres,
                       String apellidoPaterno, String apellidoMaterno, String telefono) {
        this.personalId = personalId;
        this.dni = dni;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
    }

    /**
     * @return el personalId
     */
    public Integer getPersonalId() {
        return personalId;
    }

    /**
     * @param personalId el personalId a setear
     */
    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

    /**
     * @return el dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni el dni a setear
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return los nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres los nombres a setear
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return el apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno el apellidoPaterno a setear
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return el apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno el apellidoMaterno a setear
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return el telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono el telefono a setear
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

