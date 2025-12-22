using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSVehiculos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class vehiculosAdmin_gestion : System.Web.UI.Page
    {
        private VehiculoBO vehiculoBO;
        int? id;
        private bool estaModificando;

        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public vehiculosAdmin_gestion()
        {
            this.vehiculoBO = new VehiculoBO();
            this.EstaModificando = false;
            this.id = null;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.id = (int?)Session["vehiculoId"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.cargarEntidad();
                lblSubtitulo.Text = "Modificar Vehiculo";
            }
            else
            {
                this.EstaModificando = false;
                lblSubtitulo.Text = "Crear Vehiculo";
            }
        }

        private void cargarEntidad()
        {
            vehiculosDTO vehiculo = this.vehiculoBO.obtenerPorId((int)this.id);
            txtVehiculoId.Text = vehiculo.vehiculoId.ToString();
            txtPlaca.Text = vehiculo.placa;
            ddlMarca.SelectedValue = vehiculo.marca.ToString();
            txtModelo.Text = vehiculo.modelo;
            ddlTipo.SelectedValue = vehiculo.tipo.ToString();
            txtColor.Text = vehiculo.color;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("vehiculosAdmin_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCampos()) return;

            string placa = txtPlaca.Text;
            Enum.TryParse(ddlMarca.SelectedValue, out SiniNetBusiness.SiniNetWSVehiculos.marcaVehiculo marca);
            string modelo = txtModelo.Text;
            string color = txtColor.Text;
            
            Enum.TryParse(ddlTipo.SelectedValue, out SiniNetBusiness.SiniNetWSVehiculos.tipoVehiculo tipo);
            if (estaModificando)
            {
                this.vehiculoBO.modificar((int)this.id, placa, marca, modelo, color, tipo);
            }
            else
            {
                this.vehiculoBO.insertar(placa, marca, modelo, color, tipo);
            }
            Response.Redirect("vehiculosAdmin_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (this.ValidarCamposLenos() && this.ValidarCamposValidos());
        }

        private bool ValidarCamposValidos()
        {

            if (txtPlaca.Text.Length != 7)
            {
                this.MostrarAdvertencia("La placa debe tener exactamente 7 caracteres.");
                return false;
            }
            if (txtModelo.Text.Length < 3)
            {
                MostrarAdvertencia("El modelo debe tener al menos 3 letras.");
                return false;
            }
            return true;
        }

        private bool ValidarCamposLenos()
        {
            if (string.IsNullOrWhiteSpace(txtPlaca.Text) ||
                ddlMarca.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtModelo.Text) ||
                string.IsNullOrWhiteSpace(txtColor.Text) ||
                ddlMarca.SelectedIndex == 0)
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