using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSEmpleados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class empleadosAdmin_gestion : System.Web.UI.Page
    {
        private EmpleadoBO empleadoBO;
        int? personalId;
        private bool estaModificando;

        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public empleadosAdmin_gestion()
        {
            this.empleadoBO = new EmpleadoBO();
            this.personalId = null;
            this.EstaModificando = false;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.personalId = (int?)Session["personalId"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.CargarEntidad();
                lblSubtitulo.Text = "Modificar Empleado";
            }
            else
            {
                this.EstaModificando = false;
                lblSubtitulo.Text = "Crear Empleado";
            }
        }

        private void CargarEntidad()
        {
            empleadosDTO empleado = this.empleadoBO.obtenerPorId((int)this.personalId);
            txtApellidoMaterno.Text = empleado.apellidoMaterno;
            txtApellidoPaterno.Text = empleado.apellidoPaterno;
            txtContraseña.Text = empleado.contrasenia;
            txtCorreo.Text = empleado.correo;
            txtDni.Text = empleado.dni;
            txtEmpleadoId.Text = empleado.personalId.ToString();
            txtNombres.Text = empleado.nombres;
            txtTelefono.Text = empleado.telefono;
            txtUsuario.Text = empleado.nombreUsuario;

            ddlEstado.SelectedValue = empleado.estado.ToString();
            ddlDesempeno.SelectedValue = empleado.desempenio.ToString();
            ddlTipo.SelectedValue = empleado.tipo.ToString();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            lblDesempeno.Visible = this.EstaModificando;
            ddlDesempeno.Visible = this.EstaModificando;
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("empleadosAdmin_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCampos()) return;

            string dni = txtDni.Text;
            string nombres = txtNombres.Text;
            string apellidoPaterno = txtApellidoPaterno.Text;
            string apellidoMaterno = txtApellidoMaterno.Text;
            string telefono = txtTelefono.Text;
            string nombreUsuario = txtUsuario.Text;
            string contrasenia = txtContraseña.Text;
            string correo = txtCorreo.Text;

            Enum.TryParse(ddlEstado.SelectedValue, out estadoUsuario estado);
            Enum.TryParse(ddlTipo.SelectedValue, out tipoEmpleado tipo);
            desempenhoEmpleado desempeno = desempenhoEmpleado.VALIDO;

            if (this.estaModificando)
            {
                Enum.TryParse(ddlDesempeno.SelectedValue, out desempenhoEmpleado desempenho);
                this.empleadoBO.modificar((int)this.personalId, dni, nombres, apellidoPaterno, apellidoMaterno,
                telefono, nombreUsuario, contrasenia, correo, estado, desempenho, tipo);
            }
            else
            {
                this.empleadoBO.insertar(dni, nombres, apellidoPaterno, apellidoMaterno, telefono,
                nombreUsuario, contrasenia, correo, estado, desempeno, tipo);
            }
            Response.Redirect("empleadosAdmin_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (this.ValidarCamposLenos() && this.ValidarCamposValidos());
        }

        private bool ValidarCamposValidos()
        {
            // --- DNI: solo números y 8 dígitos ---
            if (!txtDni.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El DNI debe contener solo números.");
                return false;
            }
            if (txtDni.Text.Length != 8)
            {
                MostrarAdvertencia("El DNI debe tener exactamente 8 dígitos.");
                return false;
            }

            // --- Nombres: solo letras y mínimo 3 ---
            if (!Regex.IsMatch(txtNombres.Text, @"^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$"))
            {
                MostrarAdvertencia("El nombre solo debe contener letras y espacios.");
                return false;
            }

            if (txtNombres.Text.Length < 3)
            {
                MostrarAdvertencia("El nombre debe tener al menos 3 letras.");
                return false;
            }

            // --- Apellido Paterno ---
            if (!txtApellidoPaterno.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido paterno solo debe contener letras.");
                return false;
            }
            if (txtApellidoPaterno.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido paterno debe tener al menos 3 letras.");
                return false;
            }

            // --- Apellido Materno ---
            if (!txtApellidoMaterno.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido materno solo debe contener letras.");
                return false;
            }
            if (txtApellidoMaterno.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido materno debe tener al menos 3 letras.");
                return false;
            }

            // --- Teléfono: solo números ---
            if (!txtTelefono.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El teléfono debe contener solo números.");
                return false;
            }

            // --- Usuario: mínimo 3 letras ---
            if (txtUsuario.Text.Length < 3)
            {
                MostrarAdvertencia("El usuario debe tener al menos 3 caracteres.");
                return false;
            }

            // --- Contraseña: mínimo 6 caracteres ---
            if (txtContraseña.Text.Length < 6)
            {
                MostrarAdvertencia("La contraseña debe tener al menos 6 caracteres.");
                return false;
            }

            // --- Correo: mínimo 10 caracteres y contener @ ---
            if (txtCorreo.Text.Length < 10)
            {
                MostrarAdvertencia("El correo debe tener al menos 10 caracteres.");
                return false;
            }
            if (!txtCorreo.Text.Contains("@"))
            {
                MostrarAdvertencia("El correo debe contener un @ válido.");
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
                string.IsNullOrWhiteSpace(txtTelefono.Text) ||
                string.IsNullOrWhiteSpace(txtUsuario.Text) ||
                string.IsNullOrWhiteSpace(txtContraseña.Text) ||
                string.IsNullOrWhiteSpace(txtCorreo.Text) ||
                ddlEstado.SelectedIndex == 0 ||
                ddlTipo.SelectedIndex == 0 ||
                (!this.estaModificando && ddlDesempeno.Visible && ddlDesempeno.SelectedIndex == 0))
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