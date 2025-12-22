using SiniNetBusiness.SiniNetWSCentrosDeSalud;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class CentroDeSaludBO
    {
        private CentrosDeSaludClient clienteSOAP;

        public CentroDeSaludBO()
        {
            this.clienteSOAP = new CentrosDeSaludClient();
        }

        public int insertar(
            string codigoRenipress,
            string nombre,
            ubicacionesDTO ubicacion,
            string telefono)
        {
            return this.clienteSOAP.insertarCentrosDeSalud(codigoRenipress, nombre, ubicacion, telefono);
        }

        public centrosDeSaludDTO obtenerPorId(int centroDeSaludId)
        {
            return this.clienteSOAP.obtenerPorIdCentrosDeSalud(centroDeSaludId);
        }

        public IList<centrosDeSaludDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosCentrosDeSalud();
        }

        public int modificar(
            int centroDeSaludId,
            string codigoRenipress,
            string nombre,
            ubicacionesDTO ubicacion,
            string telefono)
        {
            return this.clienteSOAP.modificarCentrosDeSalud(centroDeSaludId, codigoRenipress, nombre, ubicacion, telefono);
        }

        public int eliminar(int centroDeSaludId)
        {
            return this.clienteSOAP.eliminarCentrosDeSalud(centroDeSaludId);
        }

        public IList<centrosDeSaludDTO> listarPorNombreCodigoRENIPRESS(string filtro)
        {
            return this.clienteSOAP.listarPorNombreCodigoRENIPRESS(filtro);
        }
    }

}
