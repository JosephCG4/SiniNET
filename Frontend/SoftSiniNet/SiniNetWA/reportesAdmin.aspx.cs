using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSEmpleados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class reportesAdmin : System.Web.UI.Page
    {
        EmpleadoBO empleadoBO;
        IList<empleadosDTO> listaEmpleados;

        public reportesAdmin()
        {
            this.empleadoBO = new EmpleadoBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }

        protected void btnGenerar_Click(object sender, EventArgs e)
        {
            int empleadoId = Int32.Parse(txtEmpleadoId.Text);

            //// Convertir fechas a formato ISO 8601
            DateTime fechaInicio = DateTime.Parse(txtFechaInicio.Text);
            DateTime fechaFin = DateTime.Parse(txtFechaFin.Text);

            string fechaInicioStr = fechaInicio.ToString("yyyy-MM-ddT00:00:00");
            string fechaFinStr = fechaFin.ToString("yyyy-MM-ddT23:59:59");

            empleadosDTO empleado = this.empleadoBO.obtenerPorId(empleadoId);
            string nombreArchivo = "Reporte_Empleado_" + empleado.nombres + empleado.apellidoPaterno + ".pdf";

            byte[] reporte = this.empleadoBO.ReporteCalificacionProcurador(empleadoId, fechaInicioStr, fechaFinStr);

            if (reporte == null || reporte.Length == 0)
            {
                Response.Write("Error: El reporte está vacío");
                return;
            }

            this.empleadoBO.AbrirReporte(Response, nombreArchivo, reporte);
        }

        protected void btnFiltrarEmpleados_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormEmpleadosFiltro() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalFiltroEmpleado_lbBuscarEmpleado_Click(object sender, EventArgs e)
        {
            string filtro = ModalFiltroEmpleado_txtFiltroEmpleado.Text.Trim();
            this.listaEmpleados = this.empleadoBO.listarProcuradores(filtro);
            ModalFiltroEmpleado_gvEmpleado.DataSource = this.listaEmpleados;
            ModalFiltroEmpleado_gvEmpleado.DataBind();
        }

        protected void ModalFiltroEmpleado_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int empleadoId = Int32.Parse((sender as LinkButton).CommandArgument);
            empleadosDTO empleado = new empleadosDTO();

            empleado = this.empleadoBO.obtenerPorId(empleadoId);

            txtEmpleadoId.Text = empleado.personalId.ToString();
            txtApellidoPaternoEmpleado.Text = empleado.apellidoPaterno;
            txtNombresEmpleado.Text = empleado.nombres;
            txtTipoEmpleado.Text = empleado.tipo.ToString();

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }
    }
}