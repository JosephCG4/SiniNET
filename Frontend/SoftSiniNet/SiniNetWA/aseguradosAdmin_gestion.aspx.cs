using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSInvolucrados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class aseguradosAdmin_gestion : System.Web.UI.Page
    {
        private InvolucradoBO involucradoBO;
        int? id;
        private bool estaModificando;

        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public aseguradosAdmin_gestion()
        {
            this.involucradoBO = new InvolucradoBO();
            this.EstaModificando = false;
            this.id = null;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.id = (int?)Session["involucradoId"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.cargarEntidad();
                lblSubtitulo.Text = "Modificar Asegurado";
            }
            else
            {
                this.EstaModificando = false;
                lblSubtitulo.Text = "Crear Asegurado";
            }
        }

        private void cargarEntidad()
        {
            involucradosDTO involucrado = this.involucradoBO.obtenerPorId((int)this.id);
            txtId.Text = involucrado.personalId.ToString();
            txtDni.Text = involucrado.dni;
            txtApellidoPaterno.Text = involucrado.apellidoPaterno;
            txtApellidoMaterno.Text = involucrado.apellidoMaterno;
            txtNombres.Text = involucrado.nombres;
            txtTelefono.Text = involucrado.telefono;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("aseguradosAdmin_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCampos()) return;

            string dni = txtDni.Text;
            string apellidoPaterno = txtApellidoPaterno.Text;
            string apellidoMaterno = txtApellidoMaterno.Text;
            string nombres = txtNombres.Text;
            string telefono = txtTelefono.Text;

            if (estaModificando)
            {
                this.involucradoBO.modificar((int)this.id, dni, nombres,apellidoPaterno, apellidoMaterno, telefono, tipoInvolucrado.ASEGURADO);
            }
            else
            {
                this.involucradoBO.insertar(dni, nombres, apellidoPaterno, apellidoMaterno, telefono, tipoInvolucrado.ASEGURADO);
            }
            Response.Redirect("aseguradosAdmin_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (this.ValidarCamposLenos() && this.ValidarCamposValidos());
        }

        private bool ValidarCamposValidos()
        {
            if (!Regex.IsMatch(txtNombres.Text, @"^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$"))
            {
                MostrarAdvertencia("El nombre solo debe contener letras y espacios.");
                return false;
            }

            if (!txtDni.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El DNI debe contener solo números.");
                return false;
            }
            if (txtTelefono.Text.Length < 7)
            {
                this.MostrarAdvertencia("El teléfono debe tener al menos 7 caracteres.");
                return false;
            }
            if (txtDni.Text.Length != 8)
            {
                this.MostrarAdvertencia("El dni debe tener exactamente 8 caracteres.");
                return false;
            }
            if (!txtTelefono.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El teléfono debe contener solo números.");
                return false;
            }
            return true;
        }

        private bool ValidarCamposLenos()
        {
            if (string.IsNullOrWhiteSpace(txtDni.Text) ||
                string.IsNullOrWhiteSpace(txtNombres.Text) ||
                string.IsNullOrWhiteSpace(txtApellidoPaterno.Text) ||
                string.IsNullOrWhiteSpace(txtApellidoMaterno.Text) ||
                string.IsNullOrWhiteSpace(txtTelefono.Text))
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
    }
}
