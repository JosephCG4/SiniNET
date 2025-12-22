
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import pe.edu.pucp.softaseg.dao.AfectadoDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.AfectadosDTO;


public class AfectadoDAOImpl extends DAOImplBase implements AfectadoDAO {

    private AfectadosDTO afectado;
    
    public AfectadoDAOImpl() {
        super("GS_SINIESTRO_SOAT_X_PERSONA");
        this.afectado = null;
        this.retornarLlavePrimaria = true;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("SINIESTRO_ID", true, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.afectado.getPersonaId());
        this.statement.setInt(2, this.afectado.getSiniestroId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.afectado.getSiniestroId());
    }
    
    @Override
    public Integer insertar(AfectadosDTO afectado) {
        this.afectado = afectado;
        return super.insertar();
    }

    @Override
    public Integer eliminar(AfectadosDTO afectado) {
        this.afectado = afectado;
        return super.eliminar();
    }
    
}
