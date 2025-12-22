package pe.edu.pucp.softaseg.dao;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;

public interface PolizaSOATDAO {
    public Integer insertar(PolizasSOATDTO polizasSOAT);

    public PolizasSOATDTO obtenerPorId(Integer polizasSOATID);

    public ArrayList<PolizasSOATDTO> listarTodos();
    
    public ArrayList<PolizasSOATDTO> listarPorNombreApellidoAsegurado(String filtro);

    public Integer modificar(PolizasSOATDTO polizasSOAT);

    public Integer eliminar(PolizasSOATDTO polizasSOAT);
}
