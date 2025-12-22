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
    public partial class talleresAdmin_gestion : System.Web.UI.Page
    {
        private TallerBO tallerBO;
        int? id;
        private bool estaModificando;

        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public talleresAdmin_gestion()
        {
            this.tallerBO = new TallerBO();
            this.EstaModificando = false;
            this.id = null;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.id = (int?)Session["tallerId"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.cargarEntidad();
                lblSubtitulo.Text = "Modificar Taller";
            }
            else
            {
                this.EstaModificando = false;
                lblSubtitulo.Text = "Crear Taller";
            }
        }

        private void cargarEntidad()
        {
            talleresDTO taller = this.tallerBO.obtenerPorId((int)this.id);                
            txtTallerId.Text = taller.tallerId.ToString();
            txtNombre.Text = taller.nombre;
            txtTelefono.Text = taller.telefono;
            txtDireccion.Text = taller.ubicacion.direccion;
            txtReferencia.Text = taller.ubicacion.referencia;
            txtLatitudForm.Text = taller.ubicacion.latitud.ToString();
            txtLongitudForm.Text = taller.ubicacion.longitud.ToString();
            txtUbicacionId.Text = taller.ubicacion.ubicacionId.ToString();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("talleresAdmin_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCampos()) return;

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
                this.tallerBO.modificar((int)this.id, nombre, ubicacion, telefono);
            }
            else
            {
                this.tallerBO.insertar(nombre, ubicacion, telefono);
            }
            Response.Redirect("talleresAdmin_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (this.ValidarCamposLenos() && this.ValidarCamposValidos());
        }

        private bool ValidarCamposValidos()
        {

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
            if (string.IsNullOrWhiteSpace(txtNombre.Text) ||
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