package pe.edu.pucp.softaseg.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softaseg.dao.PersonaDAO;
import pe.edu.pucp.softaseg.daoImp.util.Columna;
import pe.edu.pucp.softaseg.model.usuarios.PersonasDTO;


public class PersonaDAOImpl extends DAOImplBase implements PersonaDAO {

    private PersonasDTO persona;

    public PersonaDAOImpl() {
        super("GU_PERSONA");
        this.persona = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PERSONA_ID", true, true));
        this.listaColumnas.add(new Columna("DNI", false, false));
        this.listaColumnas.add(new Columna("NOMBRES", false, false));
	this.listaColumnas.add(new Columna("APELLIDO_PATERNO", false, false));
	this.listaColumnas.add(new Columna("APELLIDO_MATERNO", false, false));
	this.listaColumnas.add(new Columna("TELEFONO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.persona.getDni());
        this.statement.setString(2, this.persona.getNombres());
	this.statement.setString(3, this.persona.getApellidoPaterno());
	this.statement.setString(4, this.persona.getApellidoMaterno());
	this.statement.setString(5, this.persona.getTelefono());
		
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.persona.getDni());
        this.statement.setString(2, this.persona.getNombres());
	this.statement.setString(3, this.persona.getApellidoPaterno());
	this.statement.setString(4, this.persona.getApellidoMaterno());
	this.statement.setString(5, this.persona.getTelefono());
	this.statement.setInt(6, this.persona.getPersonalId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.persona.getPersonalId());
    }

    @Override
    public Integer insertar(PersonasDTO persona) {
        this.persona = persona;
        return super.insertar();
    }
    
    @Override
    public Integer modificar(PersonasDTO persona) {
        this.persona = persona;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PersonasDTO persona) {
        this.persona = persona;
        return super.eliminar();
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.persona.getPersonalId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.persona = new PersonasDTO();
        this.persona.setPersonalId(this.resultSet.getInt("PERSONA_ID"));
        this.persona.setDni(this.resultSet.getString("DNI"));
	this.persona.setNombres(this.resultSet.getString("NOMBRES"));
	this.persona.setApellidoPaterno(this.resultSet.getString("APELLIDO_PATERNO"));
	this.persona.setApellidoMaterno(this.resultSet.getString("APELLIDO_MATERNO"));
	this.persona.setTelefono(this.resultSet.getString("TELEFONO"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.persona = null;
    }   
    
    @Override
    protected void agregarObjetoALaLista(List lista)throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.persona);
    }
    
    @Override
    public PersonasDTO obtenerPorId(Integer personaId) {
        PersonasDTO personasDTO = new PersonasDTO();
        personasDTO.setPersonalId(personaId);
        this.persona = personasDTO;
        super.obtenerPorId();
        return this.persona;
    }

    @Override
    public ArrayList<PersonasDTO> listarTodos() {        
        return (ArrayList<PersonasDTO>) super.listarTodos();
    }
    
    @Override
    public ArrayList<PersonasDTO> listarAseguradosPorSiniestro(Integer idSiniestro) {
        String sql = """
                     SELECT
                        p.PERSONA_ID,
                        p.DNI,
                        p.NOMBRES,
                        p.APELLIDO_PATERNO,
                        p.APELLIDO_MATERNO,
                        p.TELEFONO
                     FROM
                           GU_PERSONA AS p
                     JOIN
                           GS_SINIESTRO_SOAT_X_PERSONA AS a ON a.PERSONA_ID = p.PERSONA_ID
                     JOIN
                           GS_SINIESTRO_SOAT AS s ON s.SINIESTRO_ID = a.SINIESTRO_ID
                     WHERE 
                           s.SINIESTRO_ID = ?;
                     """;
         
        return (ArrayList<PersonasDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarAseguradosPorSiniestro, idSiniestro);
    }
    
    private void incluirValorDeParametrosParaListarAseguradosPorSiniestro(Object objetoParametros) {
        Integer idSiniestro = (Integer) objetoParametros;
        try {
            this.statement.setInt(1, idSiniestro);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<PersonasDTO> listarPorNombresApellidosDni(String filtro) {
        String sql = """
                     SELECT
                        p.PERSONA_ID,
                        p.DNI,
                        p.NOMBRES,
                        p.APELLIDO_PATERNO,
                        p.APELLIDO_MATERNO,
                        p.TELEFONO
                     FROM
                           GU_PERSONA AS p
                     WHERE 
                           (p.DNI LIKE ? OR p.NOMBRES LIKE ? OR p.APELLIDO_PATERNO LIKE ? OR p.APELLIDO_MATERNO LIKE ?);
                     """;
         
        return (ArrayList<PersonasDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorNombresApellidosDni, filtro);
    }
    
    private void incluirValorDeParametrosParaListarPorNombresApellidosDni(Object objetoParametros) {
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