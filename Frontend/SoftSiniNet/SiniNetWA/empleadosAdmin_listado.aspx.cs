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
    public partial class empleadosAdmin_listado : System.Web.UI.Page
    {
        private EmpleadoBO empleadoBO;
        private IList<empleadosDTO> listaEmpleados;

        public empleadosAdmin_listado()
        {
            this.empleadoBO = new EmpleadoBO();
            this.listaEmpleados = empleadoBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvEmpleados.DataSource = listaEmpleados;
            dgvEmpleados.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("empleadosAdmin_gestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int personalId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["personalId"] = personalId;
            Response.Redirect("empleadosAdmin_gestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int personalId = Int32.Parse((sender as LinkButton).CommandArgument);
            int resultado = this.empleadoBO.eliminar(personalId);

            if (resultado == 0)
            {
                MostrarAdvertencia("No se puede eliminar porque el Empleado está asociado a un siniestro.");
                return;
            }

            Response.Redirect("empleadosAdmin_listado.aspx");
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