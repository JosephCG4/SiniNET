
package pe.edu.pucp.softaseg.model.usuarios;

import pe.edu.pucp.softaseg.model.util.TipoEmpleado;
import pe.edu.pucp.softaseg.model.util.EstadoUsuario;
import pe.edu.pucp.softaseg.model.util.DesempenhoEmpleado;

public class EmpleadosDTO extends UsuariosDTO {

    private DesempenhoEmpleado desempenio;
    private TipoEmpleado tipo;

    public EmpleadosDTO() {
        super();
        this.desempenio = null;
        this.tipo = null;
    }

    public EmpleadosDTO(Integer personalId,
                        String dni,
                        String nombres,
                        String apellidoPaterno,
                        String apellidoMaterno,
                        String telefono,
                        String nombreUsuario,
                        String contrasenia,
                        String correo,
                        EstadoUsuario estado,
                        DesempenhoEmpleado desempenio,
                        TipoEmpleado tipo) {
        super(personalId, dni, nombres, apellidoPaterno, apellidoMaterno,
              telefono, nombreUsuario, contrasenia, correo, estado);
        this.desempenio = desempenio;
        this.tipo = tipo;
    }

    /** @return el desempenio */
    public DesempenhoEmpleado getDesempenio() {
        return desempenio;
    }

    /** @param desempenio el desempenio a setear */
    public void setDesempenio(DesempenhoEmpleado desempenio) {
        this.desempenio = desempenio;
    }

    /** @return el tipo */
    public TipoEmpleado getTipo() {
        return tipo;
    }

    /** @param tipo el tipo a setear */
    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }
}

