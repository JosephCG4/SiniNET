
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SiniestrosSOATDTO extends SiniestrosDTO {

    private CentrosDeSaludDTO centroDeSalud;
    private Double gastosMedicos;
    private String diagnostico;
    private ArrayList<PersonasDTO> afectados;
    private PolizasSOATDTO poliza;

    public SiniestrosSOATDTO() {
        super();
        this.centroDeSalud = null;
        this.gastosMedicos = null;
        this.diagnostico = null;
        this.afectados = new ArrayList<>();
        this.poliza = null;
    }

    public SiniestrosSOATDTO(
            Integer siniestroId,
            String descripcion,
            LocalDateTime fechaHora,
            EstadoSiniestro estado,
            Integer calificacionServicio,
            UbicacionesDTO ubicacion,
            EmpleadosDTO procurador,
            Boolean validez,
            CentrosDeSaludDTO centroDeSalud,
            Double gastosMedicos,
            String diagnostico,
            ArrayList<PersonasDTO> afectados,
            PolizasSOATDTO poliza) {

        super(siniestroId, descripcion, fechaHora, estado, calificacionServicio, 
               ubicacion, procurador, validez);

        this.centroDeSalud = centroDeSalud;
        this.gastosMedicos = gastosMedicos;
        this.diagnostico = diagnostico;
        this.afectados = afectados;
        this.poliza = poliza;
    }

    /** @return el centroDeSalud */
    public CentrosDeSaludDTO getCentroDeSalud() {
        return centroDeSalud;
    }

    /** @param centroDeSalud el centroDeSalud a setear */
    public void setCentroDeSalud(CentrosDeSaludDTO centroDeSalud) {
        this.centroDeSalud = centroDeSalud;
    }

    /** @return los gastosMedicos */
    public Double getGastosMedicos() {
        return gastosMedicos;
    }

    /** @param gastosMedicos los gastosMedicos a setear */
    public void setGastosMedicos(Double gastosMedicos) {
        this.gastosMedicos = gastosMedicos;
    }

    /** @return el diagnostico */
    public String getDiagnostico() {
        return diagnostico;
    }

    /** @param diagnostico el diagnostico a setear */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /** @return la lista de afectados */
    public ArrayList<PersonasDTO> getAfectados() {
        return afectados;
    }

    /** @param afectados la lista de afectados a setear */
    public void setAfectados(ArrayList<PersonasDTO> afectados) {
        this.afectados = afectados;
    }

    /** @return la poliza */
    public PolizasSOATDTO getPoliza() {
        return poliza;
    }

    /** @param poliza la poliza a setear */
    public void setPoliza(PolizasSOATDTO poliza) {
        this.poliza = poliza;
    }
}


