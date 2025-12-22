using SiniNetBusiness.SiniNetWSPersonas;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class PersonaBO
    {
        private PersonasClient clienteSOAP;

        public PersonaBO()
        {
            this.clienteSOAP = new PersonasClient();
        }

        public int insertar(
            string dni,
            string nombres,
            string apellidoPaterno,
            string apellidoMaterno,
            string telefono)
        {
            return this.clienteSOAP.insertarPersonas(dni, nombres, apellidoPaterno, apellidoMaterno, telefono);
        }

        public personasDTO obtenerPorId(int personalId)
        {
            return this.clienteSOAP.obtenerPorIdPersonas(personalId);
        }

        public IList<personasDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosPersonas();
        }

        public IList<personasDTO> listarAseguradosPorSiniestro(int idSiniestro)
        {
            return this.clienteSOAP.listarAseguradosPorSiniestro(idSiniestro);
        }

        public IList<personasDTO> listarPorNombresApellidosDniPersona(string filtro)
        {
            return this.clienteSOAP.listarPorNombresApellidosDniPersona(filtro);
        }

        public int modificar(
            int personalId,
            string dni,
            string nombres,
            string apellidoPaterno,
            string apellidoMaterno,
            string telefono)
        {
            return this.clienteSOAP.modificarPersonas(personalId, dni, nombres, apellidoPaterno, apellidoMaterno, telefono);
        }

        public int eliminar(int personalId)
        {
            return this.clienteSOAP.eliminarPersonas(personalId);
        }
    }

}
