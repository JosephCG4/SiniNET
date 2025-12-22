
package pe.edu.pucp.softaseg.model.usuarios;

import pe.edu.pucp.softaseg.model.util.EstadoUsuario;

public class AdministradoresDTO extends UsuariosDTO {

    private String llaveMaestra;

    public AdministradoresDTO() {
        super();
        this.llaveMaestra = null;
    }

    public AdministradoresDTO(Integer personalId,
                              String dni,
                              String nombres,
                              String apellidoPaterno,
                              String apellidoMaterno,
                              String telefono,
                              String nombreUsuario,
                              String contrasenia,
                              String correo,
                              EstadoUsuario estado,
                              String llaveMaestra) {
        super(personalId, dni, nombres, apellidoPaterno, apellidoMaterno,
              telefono, nombreUsuario, contrasenia, correo, estado);
        this.llaveMaestra = llaveMaestra;
    }

    /** @return la llaveMaestra */
    public String getLlaveMaestra() {
        return llaveMaestra;
    }

    /** @param llaveMaestra la llaveMaestra a setear */
    public void setLlaveMaestra(String llaveMaestra) {
        this.llaveMaestra = llaveMaestra;
    }
}

