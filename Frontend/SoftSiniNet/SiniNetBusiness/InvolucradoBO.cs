using SiniNetBusiness.SiniNetWSInvolucrados;
using SiniNetBusiness.SiniNetWSVehiculos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class InvolucradoBO
    {
        private InvolucradosClient clienteSOAP;

        public InvolucradoBO()
        {
            this.clienteSOAP = new InvolucradosClient();
        }

        public int insertar(string dni, string nombres, string apellidoPaterno, string apellidoMaterno, string telefono,tipoInvolucrado tipo)
        {
            return this.clienteSOAP.insertarInvolucrados(dni, nombres, apellidoPaterno, apellidoMaterno, telefono, tipo);
        }

        public involucradosDTO obtenerPorId(int involucradoId)
        {
            return this.clienteSOAP.obtenerPorIdInvolucrados(involucradoId);
        }

        public IList<involucradosDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosInvolucrados();
        }

        public IList<involucradosDTO> listarTodosAsegurados()
        {
            return this.clienteSOAP.listarTodosAseguradosInvolucrados();
        }

        public IList<involucradosDTO> listarPorNombresApellidoPaterno(string filtro)
        {
            return this.clienteSOAP.listarPorNombreApellidoPaternoInvolucrados(filtro);
        }

        public int modificar(int involucradoId, string dni, string nombres, string apellidoPaterno, string apellidoMaterno, string telefono, tipoInvolucrado tipo)
        {
            return this.clienteSOAP.modificarInvolucrados(involucradoId, dni, nombres, apellidoPaterno, apellidoMaterno, telefono, tipo);
        }

        public int eliminar(int involucradoId)
        {
            return this.clienteSOAP.eliminarInvolucrados(involucradoId);
        }
    }
}
