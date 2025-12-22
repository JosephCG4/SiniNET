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
    public partial class centrosSaludAdmin_gestion : System.Web.UI.Page
    {
        private CentroDeSaludBO centroDeSaludBO;
        int? id;
        private bool estaModificando;

        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public centrosSaludAdmin_gestion()
        {
            this.centroDeSaludBO = new CentroDeSaludBO();
            this.id = null;
            this.EstaModificando = false;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.id = (int?)Session["centroDeSaludId"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.cargarEntidad();
                lblSubtitulo.Text = "Modificar Centro de Salud";
            }
            else
            {
                this.EstaModificando = false;
                lblSubtitulo.Text = "Crear Centro de Salud";
            }
        }

        private void cargarEntidad()
        {
            centrosDeSaludDTO centro = this.centroDeSaludBO.obtenerPorId((int)this.id);
            txtCentroSaludId.Text = centro.centroDeSaludId.ToString();
            txtCodigo.Text = centro.codigoRenipress;
            txtDireccion.Text = centro.ubicacion.direccion;
            txtLatitudForm.Text = centro.ubicacion.latitud.ToString();
            txtLongitudForm.Text = centro.ubicacion.longitud.ToString();
            txtNombre.Text = centro.nombre;
            txtReferencia.Text = centro.ubicacion.referencia;
            txtTelefono.Text = centro.telefono;
            txtUbicacionId.Text = centro.ubicacion.ubicacionId.ToString();

        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("centrosSaludAdmin_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCampos()) return;

            string codigoRenipress = txtCodigo.Text;
            string nombre = txtNombre.Text;
            string telefono = txtTelefono.Text;

            ubicacionesDTO ubicacion = new ubicacionesDTO();
            ubicacion.latitud = double.Parse(txtLatitudForm.Text);
            ubicacion.longitud = double.Parse(txtLongitudForm.Text);
            ubicacion.latitudSpecified = true;
            ubicacion.longitudSpecified = true;
            ubicacion.referencia = txtReferencia.Text;
            ubicacion.direccion = txtDireccion.Text;

            if (estaModificando)
            {
                ubicacion.ubicacionId = int.Parse(txtUbicacionId.Text);
                ubicacion.ubicacionIdSpecified = true;
                this.centroDeSaludBO.modificar((int)this.id, codigoRenipress, nombre, ubicacion, telefono);
            }
            else
            {
                this.centroDeSaludBO.insertar(codigoRenipress, nombre, ubicacion, telefono);
            }
            Response.Redirect("centrosSaludAdmin_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (this.ValidarCamposLenos() && this.ValidarCamposValidos());
        }

        private bool ValidarCamposValidos()
        {
            if (!txtCodigo.Text.All(char.IsDigit))
            {
                this.MostrarAdvertencia("El código Renipress debe contener solo números.");
                return false;
            }

            if (!txtTelefono.Text.All(char.IsDigit))
            {
                this.MostrarAdvertencia("El teléfono debe contener solo números.");
                return false;
            }
            if (txtNombre.Text.Length < 3)
            {
                MostrarAdvertencia("El nombre debe tener al menos 3 letras.");
                return false;
            }
            if (txtDireccion.Text.Length < 3)
            {
                MostrarAdvertencia("La dirección debe tener al menos 3 letras.");
                return false;
            }
            if (txtReferencia.Text.Length < 3)
            {
                MostrarAdvertencia("La referencia debe tener al menos 3 letras.");
                return false;
            }
            return true;
        }

        private bool ValidarCamposLenos()
        {
            if (string.IsNullOrWhiteSpace(txtCodigo.Text) ||
               string.IsNullOrWhiteSpace(txtNombre.Text) ||
               string.IsNullOrWhiteSpace(txtTelefono.Text) ||
               string.IsNullOrWhiteSpace(txtDireccion.Text) ||
               string.IsNullOrWhiteSpace(txtReferencia.Text) ||
               string.IsNullOrWhiteSpace(txtLatitudForm.Text) ||
               string.IsNullOrWhiteSpace(txtLongitudForm.Text))
            {
                this.MostrarAdvertencia("Debe completar todos los campos antes de continuar.");
                return false;
            }
            return true;
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

        protected void btnAbrirMapa_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalMapas() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalVerMapa_lbConfirmar_Click(object sender, EventArgs e)
        {
            txtLatitudForm.Text = txtLatitud.Text;
            txtLongitudForm.Text = txtLongitud.Text;
            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }
    }
}