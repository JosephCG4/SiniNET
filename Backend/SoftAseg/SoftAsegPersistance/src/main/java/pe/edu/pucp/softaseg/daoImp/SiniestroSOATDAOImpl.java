
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.SiniestroSOATDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.CentrosDeSaludDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasSOATDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosSOATDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;

public class SiniestroSOATDAOImpl extends DAOImplBase implements SiniestroSOATDAO {  

    private SiniestrosSOATDTO siniestroSOAT;
    
    public SiniestroSOATDAOImpl() {
        super("GS_SINIESTRO_SOAT");
        this.siniestroSOAT = null;
        this.retornarLlavePrimaria = false;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("SINIESTRO_ID", true, false));
        this.listaColumnas.add(new Columna("CENTRO_DE_SALUD_ID", false, false));
        this.listaColumnas.add(new Columna("GASTOS_MEDICOS", false, false));
        this.listaColumnas.add(new Columna("DIAGNOSTICO", false, false));
        this.listaColumnas.add(new Columna("POLIZA_SOAT_ID", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.siniestroSOAT.getSiniestroId());
        this.statement.setInt(2, this.siniestroSOAT.getCentroDeSalud().getCentroDeSaludId());
        this.statement.setDouble(3, this.siniestroSOAT.getGastosMedicos());
        this.statement.setString(4, this.siniestroSOAT.getDiagnostico());
        this.statement.setInt(5, this.siniestroSOAT.getPoliza().getPolizaId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.siniestroSOAT.getCentroDeSalud().getCentroDeSaludId());
        this.statement.setDouble(2, this.siniestroSOAT.getGastosMedicos());
        this.statement.setString(3, this.siniestroSOAT.getDiagnostico());
        this.statement.setInt(4, this.siniestroSOAT.getPoliza().getPolizaId());
        this.statement.setInt(5, this.siniestroSOAT.getSiniestroId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.siniestroSOAT.getSiniestroId());
    }

    @Override
    public Integer insertar(SiniestrosSOATDTO siniestroVehicular) {
        this.siniestroSOAT = siniestroVehicular;
        return super.insertar();
    }

    @Override
    public SiniestrosSOATDTO obtenerPorId(Integer siniestroId) {
        SiniestrosSOATDTO siniestroSOATDTO = new SiniestrosSOATDTO();
        siniestroSOATDTO.setSiniestroId(siniestroId);
        this.siniestroSOAT = siniestroSOATDTO;
        String sql = """
                     SELECT
                         ss.SINIESTRO_ID,
                         s.DESCRIPCION,
                         s.FECHA_Y_HORA,
                         s.ESTADO,
                         s.CALIFICACION_SERVICIO,
                         s.UBICACION_ID,
                         s.PROCURADOR_ID,
                         s.VALIDEZ,
                         ss.CENTRO_DE_SALUD_ID,
                         ss.GASTOS_MEDICOS,
                         ss.DIAGNOSTICO,
                         ss.POLIZA_SOAT_ID
                     FROM
                         GS_SINIESTRO_SOAT AS ss
                     JOIN
                         GS_SINIESTRO AS s ON ss.SINIESTRO_ID = s.SINIESTRO_ID
                     WHERE
                         ss.SINIESTRO_ID = ?""";
        super.obtenerPorId(sql);
        return this.siniestroSOAT;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.siniestroSOAT.getSiniestroId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.siniestroSOAT = new SiniestrosSOATDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        EmpleadosDTO procurador = new EmpleadosDTO();
        CentrosDeSaludDTO centroDeSalud = new CentrosDeSaludDTO();
        PolizasSOATDTO poliza = new PolizasSOATDTO();
        
        this.siniestroSOAT.setUbicacion(ubicacion);
        this.siniestroSOAT.setProcurador(procurador);
        this.siniestroSOAT.setCentroDeSalud(centroDeSalud);
        this.siniestroSOAT.setPoliza(poliza);
        
        this.siniestroSOAT.setSiniestroId(this.resultSet.getInt("SINIESTRO_ID"));
        this.siniestroSOAT.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.siniestroSOAT.setFechaHora(this.resultSet.getObject("FECHA_Y_HORA", LocalDateTime.class));
        this.siniestroSOAT.setEstado(EstadoSiniestro.valueOf(this.resultSet.getString("ESTADO")));
        this.siniestroSOAT.setCalificacionServicio(this.resultSet.getInt("CALIFICACION_SERVICIO"));
        this.siniestroSOAT.getUbicacion().setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
        this.siniestroSOAT.getProcurador().setPersonalId(this.resultSet.getInt("PROCURADOR_ID"));
        this.siniestroSOAT.setValidez(this.resultSet.getBoolean("VALIDEZ"));
        this.siniestroSOAT.getCentroDeSalud().setCentroDeSaludId(this.resultSet.getInt("CENTRO_DE_SALUD_ID"));
        this.siniestroSOAT.setGastosMedicos(this.resultSet.getDouble("GASTOS_MEDICOS"));
        this.siniestroSOAT.setDiagnostico(this.resultSet.getString("DIAGNOSTICO"));
        this.siniestroSOAT.getPoliza().setPolizaId(this.resultSet.getInt("POLIZA_SOAT_ID"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.siniestroSOAT = null;
    }    

    @Override
    public ArrayList<SiniestrosSOATDTO> listarTodos() {  
        String sql = """
                     SELECT
                         ss.SINIESTRO_ID,
                         s.DESCRIPCION,
                         s.FECHA_Y_HORA,
                         s.ESTADO,
                         s.CALIFICACION_SERVICIO,
                         s.UBICACION_ID,
                         s.PROCURADOR_ID,
                         s.VALIDEZ,
                         ss.CENTRO_DE_SALUD_ID,
                         ss.GASTOS_MEDICOS,
                         ss.DIAGNOSTICO,
                         ss.POLIZA_SOAT_ID
                     FROM
                         GS_SINIESTRO_SOAT AS ss
                     JOIN
                         GS_SINIESTRO AS s ON ss.SINIESTRO_ID = s.SINIESTRO_ID""";
        return (ArrayList<SiniestrosSOATDTO>) super.listarTodos(sql);
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.siniestroSOAT);
    }


    @Override
    public Integer modificar(SiniestrosSOATDTO almacen) {
        this.siniestroSOAT = almacen; 
        return super.modificar();
    }

    @Override
    public Integer eliminar(SiniestrosSOATDTO siniestroSOAT) {
        this.siniestroSOAT = siniestroSOAT;
        return super.eliminar();
    }

    @Override
    public ArrayList<SiniestrosSOATDTO> listarPorProcurador(Integer idProcurador) {
        String sql = """
                     SELECT
                        ss.SINIESTRO_ID,
                        s.DESCRIPCION,
                        s.FECHA_Y_HORA,
                        s.ESTADO,
                        s.CALIFICACION_SERVICIO,
                        s.UBICACION_ID,
                        s.PROCURADOR_ID,
                        s.VALIDEZ,
                        ss.CENTRO_DE_SALUD_ID,
                        ss.GASTOS_MEDICOS,
                        ss.DIAGNOSTICO,
                        ss.POLIZA_SOAT_ID
                    FROM
                        GS_SINIESTRO_SOAT AS ss
                    JOIN
                        GS_SINIESTRO AS s ON ss.SINIESTRO_ID = s.SINIESTRO_ID
                     JOIN
                     	GU_EMPLEADO AS e ON s.PROCURADOR_ID = e.EMPLEADO_ID
                     WHERE 
                        e.EMPLEADO_ID = ?;
                     """;
         
        return (ArrayList<SiniestrosSOATDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorProcurador, idProcurador);
    }
    
    private void incluirValorDeParametrosParaListarPorProcurador(Object objetoParametros) {
        Integer idProcurador = (Integer) objetoParametros;
        try {
            this.statement.setInt(1, idProcurador);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
