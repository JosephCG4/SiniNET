
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.util.TipoDanho;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import java.time.LocalDateTime;

public class SiniestrosVehicularesDTO extends SiniestrosDTO {

    private VehiculosDTO vehiculo;
    private Double costoEstimado;
    private TalleresDTO tallerAsignado;
    private String danos;
    private PersonasDTO conductor;
    private TipoDanho tipoDano;
    private PolizasVehicularesDTO poliza;

    public SiniestrosVehicularesDTO() {
        super();
        this.vehiculo = null;
        this.costoEstimado = null;
        this.tallerAsignado = null;
        this.danos = null;
        this.conductor = null;
        this.tipoDano = null;
        this.poliza = null;
    }

    public SiniestrosVehicularesDTO(
            Integer siniestroId,
            String descripcion,
            LocalDateTime fechaHora,
            EstadoSiniestro estado,
            Integer calificacionServicio,
            UbicacionesDTO ubicacion,
            EmpleadosDTO procurador,
            Boolean validez,
            VehiculosDTO vehiculo,
            Double costoEstimado,
            TalleresDTO tallerAsignado,
            String danos,
            PersonasDTO conductor,
            TipoDanho tipoDano,
            PolizasVehicularesDTO poliza) {

        super(siniestroId, descripcion, fechaHora, estado, calificacionServicio, 
               ubicacion, procurador, validez);

        this.vehiculo = vehiculo;
        this.costoEstimado = costoEstimado;
        this.tallerAsignado = tallerAsignado;
        this.danos = danos;
        this.conductor = conductor;
        this.tipoDano = tipoDano;
        this.poliza = poliza;
    }

    /** @return el vehiculo */
    public VehiculosDTO getVehiculo() { return vehiculo; }
    /** @param vehiculo el vehiculo a setear */
    public void setVehiculo(VehiculosDTO vehiculo) { this.vehiculo = vehiculo; }

    /** @return el costoEstimado */
    public Double getCostoEstimado() { return costoEstimado; }
    /** @param costoEstimado el costoEstimado a setear */
    public void setCostoEstimado(Double costoEstimado) { this.costoEstimado = costoEstimado; }

    /** @return el tallerAsignado */
    public TalleresDTO getTallerAsignado() { return tallerAsignado; }
    /** @param tallerAsignado el tallerAsignado a setear */
    public void setTallerAsignado(TalleresDTO tallerAsignado) { this.tallerAsignado = tallerAsignado; }

    /** @return los danos */
    public String getDanos() { return danos; }
    /** @param danos los danos a setear */
    public void setDanos(String danos) { this.danos = danos; }

    /** @return el conductor */
    public PersonasDTO getConductor() { return conductor; }
    /** @param conductor el conductor a setear */
    public void setConductor(PersonasDTO conductor) { this.conductor = conductor; }

    /** @return el tipoDano */
    public TipoDanho getTipoDano() { return tipoDano; }
    /** @param tipoDano el tipoDano a setear */
    public void setTipoDano(TipoDanho tipoDano) { this.tipoDano = tipoDano; }

    /** @return la poliza */
    public PolizasVehicularesDTO getPoliza() { return poliza; }
    /** @param poliza la poliza a setear */
    public void setPoliza(PolizasVehicularesDTO poliza) { this.poliza = poliza; }
}

