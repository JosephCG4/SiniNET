
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

public class PolizasDTO {

    protected Integer polizaId;
    protected PersonasDTO asegurado;
    protected EstadoPoliza estado;

    public PolizasDTO() {
        this.polizaId = null;
        this.asegurado = null;
        this.estado = null;
    }

    public PolizasDTO(Integer polizaId, PersonasDTO asegurado, EstadoPoliza estado) {
        this.polizaId = polizaId;
        this.asegurado = asegurado;
        this.estado = estado;
    }

    /**
     * @return el polizaId
     */
    public Integer getPolizaId() {
        return polizaId;
    }

    /**
     * @param polizaId el polizaId a setear
     */
    public void setPolizaId(Integer polizaId) {
        this.polizaId = polizaId;
    }

    /**
     * @return el asegurado
     */
    public PersonasDTO getAsegurado() {
        return asegurado;
    }

    /**
     * @param asegurado el asegurado a setear
     */
    public void setAsegurado(PersonasDTO asegurado) {
        this.asegurado = asegurado;
    }

    /**
     * @return el estado
     */
    public EstadoPoliza getEstado() {
        return estado;
    }

    /**
     * @param estado el estado a setear
     */
    public void setEstado(EstadoPoliza estado) {
        this.estado = estado;
    }
}
