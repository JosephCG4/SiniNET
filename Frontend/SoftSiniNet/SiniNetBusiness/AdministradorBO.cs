using SiniNetBusiness.SiniNetWSAdministradores;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace SiniNetBusiness
{
    public class AdministradorBO
    {
        private AdministradoresClient clienteSOAP;

        public AdministradorBO()
        {
            this.clienteSOAP = new AdministradoresClient();
        }

        public int insertar(
            string dni,
            string nombres,
            string apellidoPaterno,
            string apellidoMaterno,
            string telefono,
            string nombreUsuario,
            string contrasenia,
            string correo,
            estadoUsuario estado,
            string llaveMaestra)
        {
            return this.clienteSOAP.insertarAdministradores(dni, nombres, apellidoPaterno, apellidoMaterno, telefono, nombreUsuario, contrasenia, correo, estado, llaveMaestra);
        }
        
        public administradoresDTO obtenerPorId(int administradorId)
        {            
            return this.clienteSOAP.obtenerPorIdAdministradores(administradorId);
        }
        
        public IList<administradoresDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosAdministradores();
        }
      
        public int modificar(
            int administradorId,
            string dni,
            string nombres,
            string apellidoPaterno,
            string apellidoMaterno,
            string telefono,
            string nombreUsuario,
            string contrasenia,
            string correo,
            estadoUsuario estado,
            string llaveMaestra)
        {            
            return this.clienteSOAP.modificarAdministradores(administradorId, dni, nombres, apellidoPaterno, apellidoMaterno, telefono, nombreUsuario, contrasenia, correo, estado, llaveMaestra);
        }
        
        public int eliminar(int administradorId)
        {
            return this.clienteSOAP.eliminarAdministradores(administradorId);
        }
    }
}
