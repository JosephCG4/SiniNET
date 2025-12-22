using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class llaveMaestra : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnValidar_Click(object sender, EventArgs e)
        {
            // En una aplicación real, esta llave debería estar guardada de forma segura (ej. en Web.config).
            string llaveCorrecta = Session["llaveMaestra"].ToString();

            if (txtLlaveMaestra.Text == llaveCorrecta)
            {
                // La llave es correcta.
                // Guardamos una bandera en la sesión para confirmar este paso.
                Session["AdminAuthenticated"] = true;
                // Redirigimos al menú principal del administrador.
                Response.Redirect("index.aspx");
            }
            else
            {
                lblError.Text = "Llave Maestra incorrecta.";
            }
        }
    }
}