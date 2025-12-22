using SiniNetBusiness.SiniNetWSTalleres;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SiniNetBusiness
{
    public class TallerBO
    {
        private TalleresClient clienteSOAP;

        public TallerBO()
        {
            this.clienteSOAP = new TalleresClient();
        }

        public int insertar(string nombre, ubicacionesDTO ubicacion, string telefono)
        {
            return this.clienteSOAP.insertarTalleres(nombre, ubicacion, telefono);
        }

        public talleresDTO obtenerPorId(int tallerId)
        {
            return this.clienteSOAP.obtenerPorIdTalleres(tallerId);
        }

        public IList<talleresDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosTalleres();
        }

        public IList<talleresDTO> listarPorNombreTalleres(string nombre)
        {
            return this.clienteSOAP.listarPorNombreTalleres(nombre);
        }

        public int modificar(int tallerId, string nombre, ubicacionesDTO ubicacion, string telefono)
        {
            return this.clienteSOAP.modificarTalleres(tallerId, nombre, ubicacion, telefono);
        }

        public int eliminar(int tallerId)
        {
            return this.clienteSOAP.eliminarTalleres(tallerId);
        }
    }
}
