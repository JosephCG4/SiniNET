
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

public class PolizasSOATDTO extends PolizasDTO {

    private Integer montoACobertura;

    public PolizasSOATDTO() {
        super();
        this.montoACobertura = null;
    }

    public PolizasSOATDTO(Integer polizaId, PersonasDTO asegurado, EstadoPoliza estado,
                          Integer montoACobertura) {
        super(polizaId, asegurado, estado);
        this.montoACobertura = montoACobertura;
    }

    /**
     * @return el montoACobertura
     */
    public Integer getMontoACobertura() {
        return montoACobertura;
    }

    /**
     * @param montoACobertura el montoACobertura a setear
     */
    public void setMontoACobertura(Integer montoACobertura) {
        this.montoACobertura = montoACobertura;
    }
}
