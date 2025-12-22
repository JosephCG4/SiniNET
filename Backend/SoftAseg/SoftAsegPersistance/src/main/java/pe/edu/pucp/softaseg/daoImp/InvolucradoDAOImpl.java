
package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.InvolucradoDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.usuarios.InvolucradosDTO;
import pe.edu.pucp.softaseg.model.util.TipoInvolucrado;


public class InvolucradoDAOImpl extends DAOImplBase implements InvolucradoDAO{

    private InvolucradosDTO involucrado;
    
    public InvolucradoDAOImpl(){
        super("GU_INVOLUCRADO");
        this.involucrado = null;
        this.retornarLlavePrimaria = false;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("INVOLUCRADO_ID", true, false));
        this.listaColumnas.add(new Columna("TIPO", false, false));
    }
    
    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.involucrado.getPersonalId());
        this.statement.setString(2, this.involucrado.getTipo().toString());	
    }
    
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.involucrado.getTipo().toString());
	this.statement.setInt(2, this.involucrado.getPersonalId());
    }
    
    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.involucrado.getPersonalId());
    }
    
    @Override
    public Integer insertar(InvolucradosDTO involucrado) {
        this.involucrado = involucrado;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(InvolucradosDTO involucrado) {
        this.involucrado = involucrado;
        return super.modificar();
    }

    @Override
    public Integer eliminar(InvolucradosDTO involucrado) {
        this.involucrado = involucrado;
        return super.eliminar();
    }
    
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.involucrado.getPersonalId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.involucrado = new InvolucradosDTO();
        this.involucrado.setPersonalId(this.resultSet.getInt("INVOLUCRADO_ID"));
        this.involucrado.setDni(this.resultSet.getString("DNI"));
	this.involucrado.setNombres(this.resultSet.getString("NOMBRES"));
	this.involucrado.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
	this.involucrado.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
	this.involucrado.setTelefono(this.resultSet.getString("TELEFONO"));
        this.involucrado.setTipo(TipoInvolucrado.valueOf(this.resultSet.getString("TIPO")));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.involucrado = null;
    }  
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.involucrado);
    }
    
    @Override
    public InvolucradosDTO obtenerPorId(Integer usuarioId) {
        InvolucradosDTO involucradoDTO = new InvolucradosDTO();
        involucradoDTO.setPersonalId(usuarioId);
        this.involucrado = involucradoDTO;
        String sql = "SELECT i.INVOLUCRADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, i.TIPO"
                + "  FROM GU_INVOLUCRADO as i JOIN GU_PERSONA as p ON i.INVOLUCRADO_ID = p.PERSONA_ID WHERE i.INVOLUCRADO_ID = ?";
        super.obtenerPorId(sql);
        return this.involucrado;
    }
    
    @Override
    public ArrayList<InvolucradosDTO> listarTodos() {        
        String sql = "SELECT i.INVOLUCRADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, i.TIPO"
                + "  FROM GU_INVOLUCRADO as i JOIN GU_PERSONA as p ON i.INVOLUCRADO_ID = p.PERSONA_ID";
        return (ArrayList<InvolucradosDTO>) super.listarTodos(sql);
    }

    @Override
    public ArrayList<InvolucradosDTO> listarTodosAsegurados() {
        String sql = "SELECT i.INVOLUCRADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, i.TIPO"
                + "  FROM GU_INVOLUCRADO as i JOIN GU_PERSONA as p ON i.INVOLUCRADO_ID = p.PERSONA_ID WHERE i.TIPO='ASEGURADO'";
        return (ArrayList<InvolucradosDTO>) super.listarTodos(sql);
    }
    @Override
    public ArrayList<InvolucradosDTO> listarPorNombreApellidoPaterno(String filtro) {
        String sql = """
                     SELECT i.INVOLUCRADO_ID, p.DNI, p.NOMBRES, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO, p.TELEFONO, i.TIPO
                     FROM GU_INVOLUCRADO as i JOIN GU_PERSONA as p ON i.INVOLUCRADO_ID = p.PERSONA_ID
                     WHERE p.NOMBRES LIKE ? OR p.APELLIDO_PATERNO LIKE ?;""";
        return (ArrayList<InvolucradosDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombreApellidoPaterno, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorNombreApellidoPaterno(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
            this.statement.setString(2, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(InvolucradoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
