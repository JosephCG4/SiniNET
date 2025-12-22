package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.SiniestroVehicularDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.PolizasVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.SiniestrosVehicularesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.TalleresDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;
import pe.edu.pucp.softaseg.model.usuarios.EmpleadosDTO;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;
import pe.edu.pucp.softaseg.model.util.EstadoSiniestro;
import pe.edu.pucp.softaseg.model.util.TipoDanho;

public class SiniestroVehicularDAOImpl extends DAOImplBase implements SiniestroVehicularDAO {

    private SiniestrosVehicularesDTO siniestroVehicular;

    public SiniestroVehicularDAOImpl() {
        super("GS_SINIESTRO_VEHICULAR");
        this.siniestroVehicular = null;
        this.retornarLlavePrimaria = false;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("SINIESTRO_ID", true, false));
        this.listaColumnas.add(new Columna("VEHICULO_ID", false, false));
        this.listaColumnas.add(new Columna("COSTO_ESTIMADO", false, false));
        this.listaColumnas.add(new Columna("TALLER_ID", false, false));
        this.listaColumnas.add(new Columna("DANHOS", false, false));
        this.listaColumnas.add(new Columna("CONDUCTOR_ID", false, false));
        this.listaColumnas.add(new Columna("TIPO_DANHO", false, false));
        this.listaColumnas.add(new Columna("POLIZA_VEHICULAR_ID", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.siniestroVehicular.getSiniestroId());
        this.statement.setInt(2, this.siniestroVehicular.getVehiculo().getVehiculoId());
        this.statement.setDouble(3, this.siniestroVehicular.getCostoEstimado());
        this.statement.setInt(4, this.siniestroVehicular.getTallerAsignado().getTallerId());
        this.statement.setString(5, this.siniestroVehicular.getDanos()); 
        this.statement.setInt(6, this.siniestroVehicular.getConductor().getPersonalId());
        this.statement.setString(7, this.siniestroVehicular.getTipoDano().name()); 
        this.statement.setInt(8, this.siniestroVehicular.getPoliza().getPolizaId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.siniestroVehicular.getVehiculo().getVehiculoId());
        this.statement.setDouble(2, this.siniestroVehicular.getCostoEstimado());
        this.statement.setInt(3, this.siniestroVehicular.getTallerAsignado().getTallerId());
        this.statement.setString(4, this.siniestroVehicular.getDanos()); 
        this.statement.setInt(5, this.siniestroVehicular.getConductor().getPersonalId());
        this.statement.setString(6, this.siniestroVehicular.getTipoDano().name()); 
        this.statement.setInt(7, this.siniestroVehicular.getPoliza().getPolizaId());
        this.statement.setInt(8, this.siniestroVehicular.getSiniestroId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.siniestroVehicular.getSiniestroId());
    }

    @Override
    public Integer insertar(SiniestrosVehicularesDTO siniestroVehicular) {
        this.siniestroVehicular = siniestroVehicular;
        return super.insertar();
    }

    @Override
    public SiniestrosVehicularesDTO obtenerPorId(Integer siniestroId) {
        SiniestrosVehicularesDTO siniestroVehicularDTO = new SiniestrosVehicularesDTO();
        siniestroVehicularDTO.setSiniestroId(siniestroId);
        this.siniestroVehicular = siniestroVehicularDTO;
        String sql = """
                     SELECT
                         sv.SINIESTRO_ID,
                         s.DESCRIPCION,
                         s.FECHA_Y_HORA,
                         s.ESTADO,
                         s.CALIFICACION_SERVICIO,
                         s.UBICACION_ID,
                         s.PROCURADOR_ID,
                         s.VALIDEZ,
                         sv.VEHICULO_ID,
                         sv.COSTO_ESTIMADO,
                         sv.TALLER_ID,
                         sv.DANHOS,
                         sv.CONDUCTOR_ID,
                         sv.TIPO_DANHO,
                         sv.POLIZA_VEHICULAR_ID
                     FROM
                         GS_SINIESTRO_VEHICULAR AS sv
                     JOIN
                         GS_SINIESTRO AS s ON sv.SINIESTRO_ID = s.SINIESTRO_ID
                     WHERE 
                     sv.SINIESTRO_ID = ?""";
        super.obtenerPorId(sql);
        return this.siniestroVehicular;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.siniestroVehicular.getSiniestroId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.siniestroVehicular = new SiniestrosVehicularesDTO();
        UbicacionesDTO ubicacion = new UbicacionesDTO();
        EmpleadosDTO procurador = new EmpleadosDTO();
        VehiculosDTO vehiculo = new VehiculosDTO();
        TalleresDTO taller = new TalleresDTO();
        PersonasDTO conductor = new PersonasDTO();
        PolizasVehicularesDTO poliza = new PolizasVehicularesDTO();
        
        this.siniestroVehicular.setUbicacion(ubicacion);
        this.siniestroVehicular.setProcurador(procurador);
        this.siniestroVehicular.setVehiculo(vehiculo);
        this.siniestroVehicular.setTallerAsignado(taller);
        this.siniestroVehicular.setConductor(conductor);
        this.siniestroVehicular.setPoliza(poliza);
        
        this.siniestroVehicular.setSiniestroId(this.resultSet.getInt("SINIESTRO_ID"));
        this.siniestroVehicular.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.siniestroVehicular.setFechaHora(this.resultSet.getObject("FECHA_Y_HORA", LocalDateTime.class));
        this.siniestroVehicular.setEstado(EstadoSiniestro.valueOf(this.resultSet.getString("ESTADO")));
        this.siniestroVehicular.setCalificacionServicio(this.resultSet.getInt("CALIFICACION_SERVICIO"));
        this.siniestroVehicular.getUbicacion().setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
        this.siniestroVehicular.getProcurador().setPersonalId(this.resultSet.getInt("PROCURADOR_ID"));
        this.siniestroVehicular.setValidez(this.resultSet.getBoolean("VALIDEZ"));
        this.siniestroVehicular.getVehiculo().setVehiculoId(this.resultSet.getInt("VEHICULO_ID"));
        this.siniestroVehicular.setCostoEstimado(this.resultSet.getDouble("COSTO_ESTIMADO"));
        this.siniestroVehicular.getTallerAsignado().setTallerId(this.resultSet.getInt("TALLER_ID"));
        this.siniestroVehicular.setDanos(this.resultSet.getString("DANHOS"));
        this.siniestroVehicular.getConductor().setPersonalId(this.resultSet.getInt("CONDUCTOR_ID"));
        this.siniestroVehicular.setTipoDano(TipoDanho.valueOf(this.resultSet.getString("TIPO_DANHO")) );
        this.siniestroVehicular.getPoliza().setPolizaId(this.resultSet.getInt("POLIZA_VEHICULAR_ID"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.siniestroVehicular = null;
    }    

    @Override
    public ArrayList<SiniestrosVehicularesDTO> listarTodos() {  
        String sql = """
                     SELECT
                         sv.SINIESTRO_ID,
                         s.DESCRIPCION,
                         s.FECHA_Y_HORA,
                         s.ESTADO,
                         s.CALIFICACION_SERVICIO,
                         s.UBICACION_ID,
                         s.PROCURADOR_ID,
                         s.VALIDEZ,
                         sv.VEHICULO_ID,
                         sv.COSTO_ESTIMADO,
                         sv.TALLER_ID,
                         sv.DANHOS,
                         sv.CONDUCTOR_ID,
                         sv.TIPO_DANHO,
                         sv.POLIZA_VEHICULAR_ID
                     FROM
                         GS_SINIESTRO_VEHICULAR AS sv
                     JOIN
                         GS_SINIESTRO AS s ON sv.SINIESTRO_ID = s.SINIESTRO_ID
                     """;
        return (ArrayList<SiniestrosVehicularesDTO>) super.listarTodos(sql);
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.siniestroVehicular);
    }


    @Override
    public Integer modificar(SiniestrosVehicularesDTO siniestroVehicular) {
        this.siniestroVehicular = siniestroVehicular;
        return super.modificar();
    }

    @Override
    public Integer eliminar(SiniestrosVehicularesDTO siniestroVehicular) {
        this.siniestroVehicular = siniestroVehicular;
        return super.eliminar();
    }

    @Override
    public ArrayList<SiniestrosVehicularesDTO> listarPorProcurador(Integer idProcurador) {
        String sql = """
                     SELECT
                         sv.SINIESTRO_ID,
                         s.DESCRIPCION,
                         s.FECHA_Y_HORA,
                         s.ESTADO,
                         s.CALIFICACION_SERVICIO,
                         s.UBICACION_ID,
                         s.PROCURADOR_ID,
                         s.VALIDEZ,
                         sv.VEHICULO_ID,
                         sv.COSTO_ESTIMADO,
                         sv.TALLER_ID,
                         sv.DANHOS,
                         sv.CONDUCTOR_ID,
                         sv.TIPO_DANHO,
                         sv.POLIZA_VEHICULAR_ID
                     FROM
                         GS_SINIESTRO_VEHICULAR AS sv
                     JOIN
                         GS_SINIESTRO AS s ON sv.SINIESTRO_ID = s.SINIESTRO_ID
                     JOIN
                     	GU_EMPLEADO AS e ON s.PROCURADOR_ID = e.EMPLEADO_ID
                     WHERE 
                        e.EMPLEADO_ID = ?;
                     """;
         
        return (ArrayList<SiniestrosVehicularesDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorProcurador, idProcurador);
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
