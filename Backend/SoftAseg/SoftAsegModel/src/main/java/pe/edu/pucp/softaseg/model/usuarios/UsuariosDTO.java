
package pe.edu.pucp.softaseg.model.usuarios;

import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

public class UsuariosDTO extends PersonasDTO {

    protected String nombreUsuario;
    protected String contrasenha;
    private String correo;
    protected EstadoUsuario estado;

    public UsuariosDTO() {
        super();
        this.nombreUsuario = null;
        this.contrasenha = null;
        this.correo=null;
        this.estado = null;
    }

    public UsuariosDTO(
            Integer personalId,
            String dni,
            String nombres,
            String apellidoPaterno,
            String apellidoMaterno,
            String telefono,
            String nombreUsuario,
            String contrasenia,
            String correo,
            EstadoUsuario estado) {

        super(personalId, dni, nombres, apellidoPaterno, apellidoMaterno, telefono);
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenia;
        this.correo = correo;
        this.estado = estado;
    }

    /** @return el nombreUsuario */
    public String getNombreUsuario() { return nombreUsuario; }
    /** @param nombreUsuario el nombreUsuario a setear */
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    /** @return la contrasenia */
    public String getContrasenia() { return contrasenha; }
    /** @param contrasenia la contrasenia a setear */
    public void setContrasenia(String contrasenia) { this.contrasenha = contrasenia; }

    /** @return el estado */
    public EstadoUsuario getEstado() { return estado; }
    /** @param estado el estado a setear */
    public void setEstado(EstadoUsuario estado) { this.estado = estado; }

    /** @return the correo */
    public String getCorreo() { return correo; }

    /**@param correo the correo to set */
    public void setCorreo(String correo) { this.correo = correo; }
}

