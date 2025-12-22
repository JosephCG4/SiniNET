using SiniNetBusiness.SiniNetWSSiniestrosSOAT;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace SiniNetBusiness
{
    public class SiniestroSOATBO
    {
        private SiniestrosSOATClient clienteSOAP;

        public SiniestroSOATBO()
        {
            this.clienteSOAP = new SiniestrosSOATClient();
        }

        public int insertar(
            string descripcion,
            string fechaHora,
            estadoSiniestro estado,
            int calificacionReporte,
            ubicacionesDTO ubicacion,
            empleadosDTO procurador,
            bool validez,
            centrosDeSaludDTO centroDeSalud,
            double gastosMedicos,
            string diagnostico,
            IList<personasDTO> afectados,
            polizasSOATDTO poliza)
        {
            return this.clienteSOAP.insertarSiniestrosSOAT(
                descripcion, fechaHora, estado, calificacionReporte, ubicacion,
                procurador, validez, centroDeSalud, gastosMedicos, diagnostico, afectados.ToArray(), poliza);
        }

        public siniestrosSOATDTO obtenerPorId(int siniestroId)
        {
            return this.clienteSOAP.obtenerPorIdSiniestrosSOAT(siniestroId);
        }

        public IList<siniestrosSOATDTO> listarTodos()
        {
            return this.clienteSOAP.listarTodosSiniestrosSOAT();
        }

        public IList<siniestrosSOATDTO> listarPorProcuradorSiniestrosSOAT(int idProcurador)
        {
            return this.clienteSOAP.listarPorProcuradorSiniestrosSOAT(idProcurador);
        }

        public int modificar(
            int siniestroId,
            string descripcion,
            string fechaHora,
            estadoSiniestro estado,
            int calificacionReporte,
            ubicacionesDTO ubicacion,
            empleadosDTO procurador,
            bool validez,
            centrosDeSaludDTO centroDeSalud,
            double gastosMedicos,
            string diagnostico,
            IList<personasDTO> afectados,
            polizasSOATDTO poliza)
        {
            return this.clienteSOAP.modificarSiniestrosSOAT(
                siniestroId, descripcion, fechaHora, estado, calificacionReporte,
                ubicacion, procurador, validez, centroDeSalud, gastosMedicos, diagnostico, afectados.ToArray(), poliza);
        }

        public int eliminar(int siniestroId)
        {
            return this.clienteSOAP.eliminarSiniestrosSOAT(siniestroId);
        }

        public byte[] ReporteSiniestrosSOAT(int siniestroId)
        {
            return this.clienteSOAP.reporteSiniestrosSOAT(siniestroId);
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
