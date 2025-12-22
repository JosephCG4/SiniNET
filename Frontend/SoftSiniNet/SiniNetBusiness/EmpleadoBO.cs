using SiniNetBusiness.SiniNetWSEmpleados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace SiniNetBusiness
{
    public class EmpleadoBO
    {
        private EmpleadosClient clienteSOAP;

        public EmpleadoBO()
        {
            this.clienteSOAP = new EmpleadosClient();
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
            desempenhoEmpleado desempenho,
            tipoEmpleado tipo)
        {
            return this.clienteSOAP.insertarEmpleados(
                dni, nombres, apellidoPaterno, apellidoMaterno, telefono,
                nombreUsuario, contrasenia, correo, estado, desempenho, tipo
            );
        }

        public empleadosDTO obtenerPorId(int empleadoId)
        {
            return this.clienteSOAP.obtenerPorIdEmpleados(empleadoId);
        }

        public IList<empleadosDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosEmpleados();
        }

        public int modificar(
            int personalId,
            string dni,
            string nombres,
            string apellidoPaterno,
            string apellidoMaterno,
            string telefono,
            string nombreUsuario,
            string contrasenia,
            string correo,
            estadoUsuario estado,
            desempenhoEmpleado desempenho,
            tipoEmpleado tipo)
        {
            return this.clienteSOAP.modificarEmpleados(
                personalId, dni, nombres, apellidoPaterno, apellidoMaterno,
                telefono, nombreUsuario, contrasenia, correo, estado, desempenho, tipo
            );
        }

        public int eliminar(int empleadoId)
        {
            return this.clienteSOAP.eliminarEmpleados(empleadoId);
        }

        public IList<empleadosDTO> listarPorNombreApellidoPaternoTipo(string filtro)
        {
            return this.clienteSOAP.listarPorNombreApellidoPaternoTipoEmpleados(filtro);
        }
        public IList<empleadosDTO> listarProcuradores(string filtro)
        {
            return this.clienteSOAP.listarProcuradores (filtro);
        }

        public byte[] ReporteCalificacionProcurador(int procuradorId, string fechaInicio, string fechaFin)
        {
            return this.clienteSOAP.reporteCalificacionProcurador(procuradorId, fechaInicio, fechaFin);
        }

        public void AbrirReporte(HttpResponse response, string nombreReporte, byte[] reporte)
        {
            if (reporte == null || reporte.Length == 0)
                return;

            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "attachment; filename=" + nombreReporte);
            response.BinaryWrite(reporte);
            response.End();
        }
    }

}
