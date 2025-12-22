
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.EstadoPoliza;
import pe.edu.pucp.softaseg.model.util.TipoPolizaVehicular;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;

public class PolizasVehicularesDTO extends PolizasDTO {

    private TipoPolizaVehicular tipo;
    private Integer porcentajeCobertura;

    public PolizasVehicularesDTO() {
        super();
        this.tipo = null;
        this.porcentajeCobertura = null;
    }

    public PolizasVehicularesDTO(Integer polizaId,
                                 PersonasDTO asegurado,
                                 EstadoPoliza estado,
                                 TipoPolizaVehicular tipo,
                                 Integer porcentajeCobertura) {
        super(polizaId, asegurado, estado);
        this.tipo = tipo;
        this.porcentajeCobertura = porcentajeCobertura;
    }

    /**
     * @return el tipo
     */
    public TipoPolizaVehicular getTipo() {
        return tipo;
    }

    /**
     * @param tipo el tipo a setear
     */
    public void setTipo(TipoPolizaVehicular tipo) {
        this.tipo = tipo;
    }

    /**
     * @return el porcentajeCobertura
     */
    public Integer getPorcentajeCobertura() {
        return porcentajeCobertura;
    }

    /**
     * @param porcentajeCobertura el porcentajeCobertura a setear
     */
    public void setPorcentajeCobertura(Integer porcentajeCobertura) {
        this.porcentajeCobertura = porcentajeCobertura;
    }
}


