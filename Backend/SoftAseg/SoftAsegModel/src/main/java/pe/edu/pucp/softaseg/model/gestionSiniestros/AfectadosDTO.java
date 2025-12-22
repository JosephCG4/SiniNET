
package pe.edu.pucp.softaseg.model.gestionSiniestros;

public class AfectadosDTO {
    
    private Integer personaId;
    private Integer siniestroId;
    
    public AfectadosDTO(){
        this.personaId = null;
        this.siniestroId = null;
    }

    /**
     * @return the personaId
     */
    public Integer getPersonaId() {
        return personaId;
    }

    /**
     * @param personaId the personaId to set
     */
    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    /**
     * @return the siniestroId
     */
    public Integer getSiniestroId() {
        return siniestroId;
    }

    /**
     * @param siniestroId the siniestroId to set
     */
    public void setSiniestroId(Integer siniestroId) {
        this.siniestroId = siniestroId;
    }
}
