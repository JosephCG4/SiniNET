
package pe.edu.pucp.softaseg.bo;

import java.util.ArrayList;
import pe.edu.pucp.softaseg.dao.SiniestroDAO;
import pe.edu.pucp.softaseg.daoImp.SiniestroDAOImpl;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosDTO;

public class SiniestroBO {
    
    private SiniestroDAO siniestroDAO;
    
    public SiniestroBO(){
        this.siniestroDAO = new SiniestroDAOImpl();
    }
    
    public ArrayList<SiniestrosDTO> listarTodos() {
        return this.siniestroDAO.listarTodos();
    }
    
    public SiniestrosDTO obtenerPorId(Integer siniestroId){
        return this.siniestroDAO.obtenerPorId(siniestroId);
    }
    
    public ArrayList<SiniestrosDTO> listarPorEmpleado(String filtro) {
        return this.siniestroDAO.listarPorEmpleado(filtro);
    }
}
