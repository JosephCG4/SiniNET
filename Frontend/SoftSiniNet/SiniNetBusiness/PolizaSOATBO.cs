using SiniNetBusiness.SiniNetWSPolizasSOAT;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class PolizaSOATBO
    {
        private PolizasSOATClient clienteSOAP;

        public PolizaSOATBO()
        {
            this.clienteSOAP = new PolizasSOATClient();
        }

        public int insertar(
            personasDTO asegurado,
            estadoPoliza estado,
            int montoACobertura)
        {
            return this.clienteSOAP.insertarPolizasSOAT(asegurado, estado, montoACobertura);
        }

        public polizasSOATDTO obtenerPorId(int polizaId)
        {
            return this.clienteSOAP.obtenerPorIdPolizasSOAT(polizaId);
        }

        public IList<polizasSOATDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosPolizasSOAT();
        }

        public IList<polizasSOATDTO> listarPorNombreApellidoAsegurado(string filtro)
        {
            return this.clienteSOAP.listarPorNombreApellidoAseguradoPolizasSOAT(filtro);
        }

        public int modificar(
            int polizaId,
            personasDTO asegurado,
            estadoPoliza estado,
            int montoACobertura)
        {
            return this.clienteSOAP.modificarPolizasSOAT(polizaId, asegurado, estado, montoACobertura);
        }

        public int eliminar(int polizaId)
        {
            return this.clienteSOAP.eliminarPolizasSOAT(polizaId);
        }
    }

}
