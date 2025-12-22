using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSPersonas;
using SiniNetBusiness.SiniNetWSPolizasSOAT;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class polizasSoat_listado : System.Web.UI.Page
    {
        private PolizaSOATBO polizaSOATBO;
        private PersonaBO personaBO;
        private IList<polizasSOATDTO> listaPolizasSoat;

        public polizasSoat_listado()
        {
            this.polizaSOATBO = new PolizaSOATBO();
            this.personaBO = new PersonaBO();
            this.listaPolizasSoat = this.polizaSOATBO.listarTodos();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            dgvPolizasSoat.DataSource = this.listaPolizasSoat;
            dgvPolizasSoat.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("polizasSoat_gestion.aspx");
        }

        protected void lbVerAsegurado_Click(object sender, EventArgs e)
        {
            int aseguradoId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO asegurado = this.personaBO.obtenerPorId(aseguradoId);

            txtModalAseguradoId.Text = asegurado.personalId.ToString();
            txtModalAseguradoDni.Text = asegurado.dni;
            txtModalAseguradoNombres.Text = asegurado.nombres;
            txtModalAseguradoApellidoPaterno.Text = asegurado.apellidoPaterno;
            txtModalAseguradoApellidoMaterno.Text = asegurado.apellidoMaterno;
            txtModalAseguradoTelefono.Text = asegurado.telefono;

            string script = "window.onload = function() { showModalFormAseguradoDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int polizaSoatId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["polizaSoatId"] = polizaSoatId;
            Response.Redirect("polizasSoat_gestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int polizaSoatId = Int32.Parse((sender as LinkButton).CommandArgument);
            int resultado = this.polizaSOATBO.eliminar(polizaSoatId);

            if (resultado == 0)
            {
                MostrarAdvertencia("No se puede eliminar porque la Poliza SOAT está asociado a un siniestro.");
                return;
            }

            Response.Redirect("polizasSoat_listado.aspx");
        }

        private void MostrarAdvertencia(string texto)
        {
            string script = @" document.body.insertAdjacentHTML('afterbegin', 
                    '<div id=""msgWarn"" style=""position:fixed;top:20px;left:50%;transform:translateX(-50%);background:#ffc107;color:#000;padding:12px 20px;border-radius:6px;box-shadow:0 4px 10px rgba(0,0,0,0.2);z-index:9999;font-family:Arial;font-size:14px;"">' +
                    '⚠ " + texto + @"</div>');
                    setTimeout(()=>{ var m = document.getElementById('msgWarn'); if(m) m.remove(); }, 3000);";

            ScriptManager.RegisterStartupScript(
                this,
                this.GetType(),
                "alerta",
                script,
             true
            );
        }
    }
}