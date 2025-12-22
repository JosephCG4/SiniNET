/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;

/**
 *
 * @author JOAQUIN
 */
public interface UbicacionDAO {

    public Integer insertar(UbicacionesDTO ubicacion);

    public UbicacionesDTO obtenerPorId (Integer ubicacionId);
    
    public ArrayList<UbicacionesDTO> listarTodos();
    
    public Integer modificar(UbicacionesDTO centroDeSalud);

    public Integer eliminar(UbicacionesDTO centroDeSalud);
}
