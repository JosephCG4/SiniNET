using SiniNetBusiness.SiniNetWSSiniestrosVehiculares;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace SiniNetBusiness
{
    public class SiniestroVehicularBO
    {
        private SiniestrosVehicularesClient clienteSOAP;

        public SiniestroVehicularBO()
        {
            this.clienteSOAP = new SiniestrosVehicularesClient();
        }

        public int insertar(
            string descripcion,
            string fechaHora,
            estadoSiniestro estado,
            int calificacionServicio,
            ubicacionesDTO ubicacion,
            empleadosDTO procurador,
            bool validez,
            vehiculosDTO vehiculo,
            double costoEstimado,
            talleresDTO tallerAsignado,
            string danos,
            personasDTO conductor,
            tipoDanho tipoDano,
            polizasVehicularesDTO poliza)
        {
            return this.clienteSOAP.insertarSiniestrosVehiculares(
                descripcion, fechaHora, estado, calificacionServicio, ubicacion,
                procurador, validez, vehiculo, costoEstimado, tallerAsignado,
                danos, conductor, tipoDano, poliza);
        }

        public siniestrosVehicularesDTO obtenerPorId(int siniestroId)
        {
            return this.clienteSOAP.obtenerPorIdSiniestrosVehiculares(siniestroId);
        }

        public IList<siniestrosVehicularesDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosSiniestrosVehiculares();
        }

        public IList<siniestrosVehicularesDTO> listarPorProcuradorSiniestrosVehiculares(int idProcurador)
        {
            return this.clienteSOAP.listarPorProcuradorSiniestrosVehiculares(idProcurador);
        }

        public int modificar(
            int siniestroId,
            string descripcion,
            string fechaHora,
            estadoSiniestro estado,
            int calificacionServicio,
            ubicacionesDTO ubicacion,
            empleadosDTO procurador,
            bool validez,
            vehiculosDTO vehiculo,
            double costoEstimado,
            talleresDTO tallerAsignado,
            string danos,
            personasDTO conductor,
            tipoDanho tipoDano,
            polizasVehicularesDTO poliza)
        {
            return this.clienteSOAP.modificarSiniestrosVehiculares(
                siniestroId, descripcion, fechaHora, estado, calificacionServicio,
                ubicacion, procurador, validez, vehiculo, costoEstimado,
                tallerAsignado, danos, conductor, tipoDano, poliza);
        }

        public int eliminar(int siniestroId)
        {
            return this.clienteSOAP.eliminarSiniestrosVehiculares(siniestroId);
        }

        public byte[] ReporteSiniestrosVehiculares(int siniestroId)
        {
            return this.clienteSOAP.reporteSiniestrosVehiculares(siniestroId);
        }

        public void AbrirReporte(HttpResponse response, string nombreReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "attachment; filename=" + nombreReporte);
            response.BinaryWrite(reporte);
            response.End();
        }
    }

}
