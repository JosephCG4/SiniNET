package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.VehiculoDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.util.MarcaVehiculo;
import pe.edu.pucp.softaseg.model.util.TipoVehiculo;
import pe.edu.pucp.softaseg.model.gestionSiniestros.VehiculosDTO;

public class VehiculoDAOImpl extends DAOImplBase implements VehiculoDAO {

    private VehiculosDTO vehiculo;

    public VehiculoDAOImpl() {
        super("GS_VEHICULO");
        this.vehiculo = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("VEHICULO_ID", true, true));
        this.listaColumnas.add(new Columna("PLACA", false, false));
        this.listaColumnas.add(new Columna("MARCA", false, false));
        this.listaColumnas.add(new Columna("MODELO", false, false));
        this.listaColumnas.add(new Columna("COLOR", false, false));
        this.listaColumnas.add(new Columna("TIPO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.vehiculo.getPlaca());
        this.statement.setString(2, this.vehiculo.getMarca().name());
        this.statement.setString(3, this.vehiculo.getModelo());
        this.statement.setString(4, this.vehiculo.getColor());
        this.statement.setString(5, this.vehiculo.getTipo().name());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.vehiculo.getPlaca());
        this.statement.setString(2, this.vehiculo.getMarca().name());
        this.statement.setString(3, this.vehiculo.getModelo());
        this.statement.setString(4, this.vehiculo.getColor());
        this.statement.setString(5, this.vehiculo.getTipo().name());
        this.statement.setInt(6, this.vehiculo.getVehiculoId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.vehiculo.getVehiculoId());
    }

    @Override
    public Integer insertar(VehiculosDTO vehiculo) {
        this.vehiculo = vehiculo;
        return super.insertar();
    }

    @Override
    public VehiculosDTO obtenerPorId(Integer vehiculoId) {
        VehiculosDTO vehiculoDTO = new VehiculosDTO();
        vehiculoDTO.setVehiculoId(vehiculoId);
        this.vehiculo = vehiculoDTO;
        super.obtenerPorId();
        return this.vehiculo;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.vehiculo.getVehiculoId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.vehiculo = new VehiculosDTO();
        this.vehiculo.setVehiculoId(this.resultSet.getInt("VEHICULO_ID"));
        this.vehiculo.setPlaca(this.resultSet.getString("PLACA"));
        this.vehiculo.setMarca(MarcaVehiculo.valueOf(this.resultSet.getString("MARCA")));
        this.vehiculo.setModelo(this.resultSet.getString("MODELO"));
        this.vehiculo.setColor(this.resultSet.getString("COLOR"));
        this.vehiculo.setTipo(TipoVehiculo.valueOf(this.resultSet.getString("TIPO")));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.vehiculo = null;
    }    

    @Override
    public ArrayList<VehiculosDTO> listarTodos() {        
        return (ArrayList<VehiculosDTO>) super.listarTodos();
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.vehiculo);
    }


    @Override
    public Integer modificar(VehiculosDTO vehiculo) {
        this.vehiculo = vehiculo;
        return super.modificar();
    }

    @Override
    public Integer eliminar(VehiculosDTO vehiculo) {
        this.vehiculo = vehiculo;
        return super.eliminar();
    }

    @Override
    public ArrayList<VehiculosDTO> listarPorPlacaMarcaModeloTipoVehiculo(String filtro) {
        String sql = """
                     SELECT
                        VEHICULO_ID,
                        PLACA,
                        MARCA,
                        MODELO,
                        COLOR,
                        TIPO
                     FROM
                         GS_VEHICULO
                     WHERE 
                        (PLACA LIKE ? OR MARCA LIKE ? OR MODELO LIKE ? OR TIPO LIKE ?);""";
        return (ArrayList<VehiculosDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorPlacaMarcaModeloTipoVehiculo, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorPlacaMarcaModeloTipoVehiculo(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
            this.statement.setString(2, cadena);
            this.statement.setString(3, cadena);
            this.statement.setString(4, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
