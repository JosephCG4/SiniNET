using SiniNetBusiness.SiniNetWSPolizasVehiculares;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class PolizaVehicularBO
    {
        private PolizasVehicularesClient clienteSOAP;

        public PolizaVehicularBO()
        {
            this.clienteSOAP = new PolizasVehicularesClient();
        }

        public int insertar(
            personasDTO asegurado,
            estadoPoliza estado,
            tipoPolizaVehicular tipo,
            int porcentajeCobertura)
        {
            return this.clienteSOAP.insertarPolizasVehiculares(asegurado, estado, tipo, porcentajeCobertura);
        }

        public polizasVehicularesDTO obtenerPorId(int polizaId)
        {
            return this.clienteSOAP.obtenerPorIdPolizasVehiculares(polizaId);
        }

        public IList<polizasVehicularesDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosPolizasVehiculares();
        }

        public IList<polizasVehicularesDTO> listarPorNombreApellidoAsegurado(string filtro)
        {
            return this.clienteSOAP.listarPorNombreApellidoAseguradoPolizasVehiculares(filtro);
        }

        public int modificar(
            int polizaId,
            personasDTO asegurado,
            estadoPoliza estado,
            tipoPolizaVehicular tipo,
            int porcentajeCobertura)
        {
            return this.clienteSOAP.modificarPolizasVehiculares(polizaId, asegurado, estado, tipo, porcentajeCobertura);
        }

        public int eliminar(int polizaId)
        {
            return this.clienteSOAP.eliminarPolizasVehiculares(polizaId);
        }
    }

}
