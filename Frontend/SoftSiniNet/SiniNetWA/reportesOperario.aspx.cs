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
    public partial class reportesOperario : System.Web.UI.Page
    {
        private SiniestroBO siniestroBO;
        private SiniestroVehicularBO siniestroVehicularBO;
        private SiniestroSOATBO siniestroSOATBO;

        public reportesOperario()
        {
            siniestroBO = new SiniestroBO();
            siniestroVehicularBO = new SiniestroVehicularBO();
            siniestroSOATBO = new SiniestroSOATBO();
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
            int idSiniestro = Int32.Parse(txtSiniestroId.Text);

            string nombreArchivo;
            

            if (this.siniestroSOATBO.obtenerPorId(idSiniestro) == null)
            {
                //generar reporte vehicular;
                byte[] reporte = this.siniestroVehicularBO.ReporteSiniestrosVehiculares(idSiniestro);
                nombreArchivo = "Reporte_Siniestro_Vehicular_" + idSiniestro + ".pdf";

                this.siniestroVehicularBO.AbrirReporte(Response, nombreArchivo, reporte);
            }
            else
            {
                //generar reporte soat;
                byte[] reporte = this.siniestroSOATBO.ReporteSiniestrosSOAT(idSiniestro);
                nombreArchivo = "Reporte_Siniestro_SOAT_" + idSiniestro + ".pdf";
                this.siniestroVehicularBO.AbrirReporte(Response, nombreArchivo, reporte);
            }
            
        }

        protected void btnFiltrarSiniestros_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormSiniestrosFiltro() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalFiltroSiniestro_lbBuscarSiniestro_Click(object sender, EventArgs e)
        {
            string filtro = ModalFiltroSiniestro_txtNombreApellido.Text;
            IList<SiniNetBusiness.SiniNetWSSiniestros.siniestrosDTO> lista = this.siniestroBO.listarPorEmpleado(filtro);
            ModalFiltroSiniestro_gvSiniestro.DataSource = lista;
            ModalFiltroSiniestro_gvSiniestro.DataBind();
        }

        protected void ModalFiltroSiniestro_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int siniestroId = Convert.ToInt32(((LinkButton)sender).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestros.siniestrosDTO siniestro = this.siniestroBO.obtenerPorId(siniestroId);

            txtSiniestroId.Text = siniestro.siniestroId.ToString();
            txtCalificacion.Text = siniestro.calificacionServicio.ToString();
            txtDescripcion.Text = siniestro.descripcion;
            txtFechaHora.Text = siniestro.fechaHora;

            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
        }
    }
}