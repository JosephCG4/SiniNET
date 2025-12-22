
package pe.edu.pucp.softaseg.model.gestionSiniestros;

import pe.edu.pucp.softaseg.model.util.MarcaVehiculo;
import pe.edu.pucp.softaseg.model.util.TipoVehiculo;

public class VehiculosDTO {

    private Integer vehiculoId;
    private String  placa;
    private MarcaVehiculo marca;
    private String  modelo;
    private String  color;
    private TipoVehiculo tipo;

    // Constructor vacío
    public VehiculosDTO() {
        this.vehiculoId = null;
        this.placa = null;
        this.marca = null;
        this.modelo = null;
        this.color = null;
        this.tipo = null;
    }

    // Constructor completo
    public VehiculosDTO(Integer vehiculoId, String placa, MarcaVehiculo marca,
                        String modelo, String color, TipoVehiculo tipo) {
        this.vehiculoId = vehiculoId;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipo = tipo;
    }

    /**
     * @return the vehiculoId
     */
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    /**
     * @param vehiculoId the vehiculoId to set
     */
    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the marca
     */
    public MarcaVehiculo getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(MarcaVehiculo marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the tipo
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    
    

}

