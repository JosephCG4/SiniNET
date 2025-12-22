using SiniNetBusiness.SiniNetWSVehiculos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class VehiculoBO
    {
        private VehiculosClient clienteSOAP;

        public VehiculoBO()
        {
            this.clienteSOAP = new VehiculosClient();
        }

        public int insertar(string placa, marcaVehiculo marca, string modelo, string color, tipoVehiculo tipo)
        {
            return this.clienteSOAP.insertarVehiculos(placa, marca, modelo, color, tipo);
        }

        public vehiculosDTO obtenerPorId(int vehiculoId)
        {
            return this.clienteSOAP.obtenerPorIdVehiculos(vehiculoId);
        }

        public IList<vehiculosDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosVehiculos();
        }

        public IList<vehiculosDTO> listarPorPlacaMarcaModeloTipoVehiculo(string filtro)
        {
            return this.clienteSOAP.listarPorPlacaMarcaModeloTipoVehiculo(filtro);
        }

        public int modificar(int vehiculoId, string placa, marcaVehiculo marca, string modelo, string color, tipoVehiculo tipo)
        {
            return this.clienteSOAP.modificarVehiculos(vehiculoId, placa, marca, modelo, color, tipo);
        }

        public int eliminar(int vehiculoId)
        {
            return this.clienteSOAP.eliminarVehiculos(vehiculoId);
        }
    }

}
