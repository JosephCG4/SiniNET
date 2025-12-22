using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class SinniNet : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string rol = Session["rolUsuario"]?.ToString(); // guarda el rol al loguearse

                // Oculta todo por defecto
                liCentrosSaludAdmin.Visible = false;
                liTalleresAdmin.Visible = false;
                liEmpleadosAdmin.Visible = false;
                lireportesAdmin.Visible = false;
                liExpedientesAdmin.Visible = false;
                liAseguradosAdmin.Visible = false;
                liVehiculosAdmin.Visible = false;

                liSiniestrosSoatOperario.Visible = false;
                liSiniestrosVehicularesOperario.Visible = false;
                liReportesOperario.Visible = false;

                liSiniestrosSoatProcurador.Visible = false;
                liSiniestrosVehicularesProcurador.Visible = false;

                liPolizasSoat.Visible = false;
                liPolizasVehiculares.Visible = false;

                // Mostrar según rol
                switch (rol)
                {
                    case "Administrador":
                        liCentrosSaludAdmin.Visible = true;
                        liTalleresAdmin.Visible = true;
                        liEmpleadosAdmin.Visible = true;
                        lireportesAdmin.Visible = true;
                        liAseguradosAdmin.Visible = true;
                        liVehiculosAdmin.Visible = true;
                        liExpedientesAdmin.Visible = false;
                        liPolizasSoat.Visible = true;
                        liPolizasVehiculares.Visible = true;
                        lblUsuarioRol.Text = "Administrador";
                        break;

                    case "Operario":
                        liSiniestrosSoatOperario.Visible = true;
                        liSiniestrosVehicularesOperario.Visible = true;
                        liReportesOperario.Visible = true;
                        lblUsuarioRol.Text = "Operario";
                        break;

                    case "Procurador":
                        liSiniestrosSoatProcurador.Visible = true;
                        liSiniestrosVehicularesProcurador.Visible = true;
                        lblUsuarioRol.Text = "Procurador";
                        break;
                }
            }
        }

        protected void btnCerrarSesion_Click(object sender, EventArgs e)
        {
            Session.Clear();
            Session.Abandon();

            Response.Redirect("login.aspx");
        }
    }
}