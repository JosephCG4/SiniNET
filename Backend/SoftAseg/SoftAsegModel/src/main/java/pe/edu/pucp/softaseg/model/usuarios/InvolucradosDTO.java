
package pe.edu.pucp.softaseg.model.usuarios;

import pe.edu.pucp.softaseg.model.util.TipoInvolucrado;

public class InvolucradosDTO extends PersonasDTO{
    private TipoInvolucrado tipo;
    
    public InvolucradosDTO(){
        this.tipo = null;
    }
    
    public InvolucradosDTO(
            Integer personalId,
            String dni,
            String nombres,
            String apellidoPaterno,
            String apellidoMaterno,
            String telefono,
            TipoInvolucrado tipo) {

        super(personalId, dni, nombres, apellidoPaterno, apellidoMaterno, telefono);
        this.tipo = tipo;
    }
    
    /**
     * @return the tipo
     */
    public TipoInvolucrado getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoInvolucrado tipo) {
        this.tipo = tipo;
    }
}
