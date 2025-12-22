using SiniNetBusiness.SiniNetWSSiniestros;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class SiniestroBO
    {
        private SiniestrosClient clienteSOAP;

        public SiniestroBO()
        {
            this.clienteSOAP = new SiniestrosClient();
        }

        public IList<siniestrosDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosSiniestros();
        }

        public siniestrosDTO obtenerPorId(int siniestroId)
        {
            return this.clienteSOAP.obtenerPorIdSiniestros(siniestroId);
        }

        public IList<siniestrosDTO> listarPorEmpleado(string filtro)
        {
            return this.clienteSOAP.listarPorEmpleadoSiniestros(filtro);
        }
    }
}
