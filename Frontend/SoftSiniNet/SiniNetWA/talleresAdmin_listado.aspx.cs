using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSTalleres;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class talleresAdmin_listado : System.Web.UI.Page
    {
        private TallerBO tallerBO;
        private IList<talleresDTO> listaTalleres;

        public talleresAdmin_listado()
        {
            this.tallerBO = new TallerBO();
            this.listaTalleres = this.tallerBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvTalleres.DataSource = this.listaTalleres;
            dgvTalleres.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("talleresAdmin_gestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int tallerId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["tallerId"] = tallerId;
            Response.Redirect("talleresAdmin_gestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int tallerId = Int32.Parse((sender as LinkButton).CommandArgument);
            int resultado = this.tallerBO.eliminar(tallerId);

            if (resultado == 0)
            {
                MostrarAdvertencia("No se puede eliminar porque el Taller está asociado a un siniestro.");
                return;
            }

            Response.Redirect("talleresAdmin_listado.aspx");
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

        protected void lbVerUbicacion_Click(object sender, EventArgs e)
        {
            //aca se debe traer latitud y longitud con un obteneer por id
            int tallerId = Int32.Parse((sender as LinkButton).CommandArgument);
            talleresDTO taller = this.tallerBO.obtenerPorId(tallerId);

            txtDireccionVer.Text = taller.ubicacion.direccion;
            txtReferenciaVer.Text = taller.ubicacion.referencia;
            txtLatitudVer.Text = taller.ubicacion.latitud.ToString();
            txtLongitudVer.Text = taller.ubicacion.longitud.ToString();

            // Mostrar modal y centrar el mapa con el pin
            string script = $@"
            window.onload = function() {{
                showMapaVer({taller.ubicacion.latitud}, {taller.ubicacion.longitud});
            }};";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarMapa", script, true);
        }
    }
}