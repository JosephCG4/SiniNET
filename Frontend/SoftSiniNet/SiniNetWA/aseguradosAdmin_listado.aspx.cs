using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSInvolucrados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class aseguradosAdmin_listado : System.Web.UI.Page
    {
        private InvolucradoBO involucradoBO;
        private IList<involucradosDTO> listaInvolucrados;

        public aseguradosAdmin_listado()
        {
            this.involucradoBO = new InvolucradoBO();
            this.listaInvolucrados = involucradoBO.listarTodosAsegurados();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            dgvAsegurado.DataSource = this.listaInvolucrados;
            dgvAsegurado.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("aseguradosAdmin_gestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int involucradoId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["involucradoId"] = involucradoId;
            Response.Redirect("aseguradosAdmin_gestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int involucradoId = Int32.Parse((sender as LinkButton).CommandArgument);
            int resultado = this.involucradoBO.eliminar(involucradoId);

            if (resultado == 0)
            {
                MostrarAdvertencia("No se puede eliminar porque el asegurado está asociado a una poliza.");
                return;
            }

            Response.Redirect("aseguradosAdmin_listado.aspx");
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