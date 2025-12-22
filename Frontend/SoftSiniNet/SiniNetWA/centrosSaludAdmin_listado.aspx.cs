using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSCentrosDeSalud;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class centrosSaludAdmin_listado : System.Web.UI.Page
    {
        private CentroDeSaludBO centroDeSaludBO;
        private IList<centrosDeSaludDTO> listaCentrosDeSalud;

        public centrosSaludAdmin_listado()
        {
            this.centroDeSaludBO = new CentroDeSaludBO();
            this.listaCentrosDeSalud = centroDeSaludBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
           dgvCentroSalud.DataSource = this.listaCentrosDeSalud;
           dgvCentroSalud.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("centrosSaludAdmin_gestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int centroDeSaludId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["centroDeSaludId"] = centroDeSaludId;
            Response.Redirect("centrosSaludAdmin_gestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int centroDeSaludId = Int32.Parse((sender as LinkButton).CommandArgument);
            int resultado = this.centroDeSaludBO.eliminar(centroDeSaludId);

            if (resultado == 0)
            {
                MostrarAdvertencia("No se puede eliminar porque el Centro de Salud está asociado a un siniestro.");
                return;
            }

            Response.Redirect("centrosSaludAdmin_listado.aspx");
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
            int centroDeSaludId = Int32.Parse((sender as LinkButton).CommandArgument);
            centrosDeSaludDTO centro = this.centroDeSaludBO.obtenerPorId(centroDeSaludId);

            txtDireccionVer.Text = centro.ubicacion.direccion;
            txtReferenciaVer.Text = centro.ubicacion.referencia;
            txtLatitudVer.Text = centro.ubicacion.latitud.ToString();
            txtLongitudVer.Text = centro.ubicacion.longitud.ToString();

            // Mostrar modal y centrar el mapa con el pin
            string script = $@"
            window.onload = function() {{
                showMapaVer({centro.ubicacion.latitud}, {centro.ubicacion.longitud});
            }};";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarMapa", script, true);
        }
    }
}