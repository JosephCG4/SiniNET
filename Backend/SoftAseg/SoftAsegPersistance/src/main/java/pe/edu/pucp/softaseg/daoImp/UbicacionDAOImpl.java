
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softaseg.dao.UbicacionDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.gestionSiniestros.UbicacionesDTO;


public class UbicacionDAOImpl extends DAOImplBase implements UbicacionDAO{
    
    private UbicacionesDTO ubicacion;

    public UbicacionDAOImpl() {
        super("GS_UBICACION");
        this.ubicacion = null;
        this.retornarLlavePrimaria = true;
    }
    
    
    @Override
    protected void configurarListaDeColumnas(){
        this.listaColumnas.add(new Columna("UBICACION_ID", true, true));
        this.listaColumnas.add(new Columna("DIRECCION", false, false));
        this.listaColumnas.add(new Columna("REFERENCIA", false, false));
        this.listaColumnas.add(new Columna("LATITUD", false, false));
        this.listaColumnas.add(new Columna("LONGITUD", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion () throws SQLException{
        this.statement.setString(1, this.ubicacion.getDireccion());
        this.statement.setString(2, this.ubicacion.getReferencia());
        this.statement.setDouble(3, this.ubicacion.getLatitud());
	this.statement.setDouble(4, this.ubicacion.getLongitud());
    }
    

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.ubicacion.getDireccion());
        this.statement.setString(2, this.ubicacion.getReferencia());
        this.statement.setDouble(3, this.ubicacion.getLatitud());
	this.statement.setDouble(4, this.ubicacion.getLongitud());
	this.statement.setInt(5, this.ubicacion.getUbicacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.ubicacion.getUbicacionId());
    }

    @Override
    public Integer insertar(UbicacionesDTO ubicacion) {
        this.ubicacion = ubicacion;
        return super.insertar();
    }  


    @Override
    public Integer modificar(UbicacionesDTO ubicacion) {
        this.ubicacion = ubicacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(UbicacionesDTO ubicacion) {
        this.ubicacion = ubicacion;
        return super.eliminar();
    }
    
    @Override
    public UbicacionesDTO obtenerPorId(Integer ubicacionId) {
        UbicacionesDTO ubicacionDTO = new UbicacionesDTO();
        ubicacionDTO.setUbicacionId(ubicacionId);
        this.ubicacion = ubicacionDTO;
        super.obtenerPorId();
        return this.ubicacion;
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.ubicacion.getUbicacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.ubicacion = new UbicacionesDTO();
        this.ubicacion.setUbicacionId(this.resultSet.getInt("UBICACION_ID"));
        this.ubicacion.setDireccion(this.resultSet.getString("DIRECCION"));
        this.ubicacion.setReferencia(this.resultSet.getString("REFERENCIA"));
        this.ubicacion.setLatitud(this.resultSet.getDouble("LATITUD"));
        this.ubicacion.setLongitud(this.resultSet.getDouble("LONGITUD"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.ubicacion = null;
    }    

    @Override
    public ArrayList<UbicacionesDTO> listarTodos() {        
        return (ArrayList<UbicacionesDTO>) super.listarTodos();
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.ubicacion);
    }

}
