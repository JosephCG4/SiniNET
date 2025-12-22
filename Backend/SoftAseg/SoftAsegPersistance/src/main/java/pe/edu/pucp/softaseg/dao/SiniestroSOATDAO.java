/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;

/**
 *
 * @author josep
 */
public interface SiniestroSOATDAO {
    
    public Integer insertar(SiniestrosSOATDTO siniestroVehicular);
    
    public SiniestrosSOATDTO obtenerPorId(Integer siniestroVehicularId);
    
    public ArrayList<SiniestrosSOATDTO> listarTodos();
    
    public ArrayList<SiniestrosSOATDTO> listarPorProcurador(Integer idProcurador);
    
    public Integer modificar(SiniestrosSOATDTO almacen);
    
    public Integer eliminar(SiniestrosSOATDTO almacen);
}
