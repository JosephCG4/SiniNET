using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSInvolucrados;
using SiniNetBusiness.SiniNetWSPolizasVehiculares;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class polizasVehiculares_gestion : System.Web.UI.Page
    {
        private PolizaVehicularBO polizaVehicularBO;
        private InvolucradoBO aseguradoBO;
        private IList<involucradosDTO> listaAsegurados;
        private bool estaModificando;
        int? polizaId;

        public polizasVehiculares_gestion()
        {
            this.polizaVehicularBO = new PolizaVehicularBO();
            this.aseguradoBO = new InvolucradoBO();
            this.estaModificando = false;
            this.polizaId = null;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.polizaId = (int?)Session["polizaVehicularId"];
            string accion = Request.QueryString["accion"];

            if (accion != null && accion == "modificar")
            {
                this.estaModificando = true;
                this.CargarDatosDelSiniestro();
                lblSubtitulo.Text = "Modificar Poliza Vehicular";
            }
            else
            {
                this.estaModificando = false;
                lblSubtitulo.Text = "Crear Poliza Vehicular";
            }
        }

        private void CargarDatosDelSiniestro()
        {
            polizasVehicularesDTO poliza = this.polizaVehicularBO.obtenerPorId((int)this.polizaId);
            involucradosDTO asegurado = this.aseguradoBO.obtenerPorId(poliza.asegurado.personalId);

            txtId.Text = poliza.polizaId.ToString();
            txtPorcentaje.Text = poliza.porcentajeCobertura.ToString();
            ddlEstado.SelectedValue = poliza.estado.ToString();
            ddlTipo.SelectedValue = poliza.tipo.ToString();
            txtAseguradoId.Text = asegurado.personalId.ToString();
            txtAseguradoDni.Text = asegurado.dni;
            txtAseguradoNombres.Text = asegurado.nombres;
            txtAseguradoApellidoPaterno.Text = asegurado.apellidoPaterno;
            txtAseguradoApellidoMaterno.Text = asegurado.apellidoMaterno;           
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("polizaVehicular_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!ValidarCampos()) return;

            SiniNetBusiness.SiniNetWSPolizasVehiculares.personasDTO persona = new SiniNetBusiness.SiniNetWSPolizasVehiculares.personasDTO();

            persona.personalId = Convert.ToInt32(txtAseguradoId.Text);
            persona.personalIdSpecified = true;
            Enum.TryParse(ddlEstado.SelectedValue, out SiniNetBusiness.SiniNetWSPolizasVehiculares.estadoPoliza estado);
            Enum.TryParse(ddlTipo.SelectedValue, out SiniNetBusiness.SiniNetWSPolizasVehiculares.tipoPolizaVehicular tipo);
            int porcentaje = Convert.ToInt32(txtPorcentaje.Text);

            if (this.estaModificando)
            {
                this.polizaVehicularBO.modificar((int)this.polizaId, persona, estado, tipo, porcentaje);
            }
            else
            {
                this.polizaVehicularBO.insertar(persona, estado, tipo, porcentaje);
            }

            Response.Redirect("polizaVehicular_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (ValidarCamposLlenos() && ValidarCamposCorrectos());
        }

        private bool ValidarCamposCorrectos()
        {
            if (Int32.Parse(txtPorcentaje.Text) < 1 || Int32.Parse(txtPorcentaje.Text) > 100)
            {
                MostrarAdvertencia("La calificación debe ser un valor entre 0 y 10");
                return false;
            }
            return true;
        }

        private bool ValidarCamposLlenos()
        {
            if (
                string.IsNullOrWhiteSpace(txtAseguradoId.Text) ||
                ddlEstado.SelectedIndex == 0 ||
                ddlTipo.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtPorcentaje.Text)
               )
            {
                this.MostrarAdvertencia("Debe completar todos los campos antes de continuar.");
                return false;
            }
            return true;
        }

        private void MostrarAdvertencia(string texto)
        {
            string script = $"document.body.insertAdjacentHTML('afterbegin', " +
                            $"'<div id=\"msgWarn\" style=\"position:fixed;top:20px;left:50%;transform:translateX(-50%);" +
                            $"background:#ffc107;color:#000;padding:12px 20px;border-radius:6px;" +
                            $"box-shadow:0 4px 10px rgba(0,0,0,0.2);z-index:9999;font-family:Arial;font-size:14px;\">" +
                            $"⚠ {texto}</div>'); " +
                            $"setTimeout(()=>{{ document.getElementById('msgWarn').remove(); }}, 3000);";

            ScriptManager.RegisterStartupScript(this, this.GetType(), "msgAlerta", script, true);
        }

        protected void btnFiltrarAsegurados_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormAseguradoBuscar() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbBuscarAsegurado_Click(object sender, EventArgs e)
        {
            string filtro = txtModalFiltroAsegurado.Text;
            listaAsegurados = aseguradoBO.listarPorNombresApellidoPaterno(filtro);
            gdvModalAsegurados.DataSource = listaAsegurados;
            gdvModalAsegurados.DataBind();
        }

        protected void lbModalSeleccionarAsegurado_Click(object sender, EventArgs e)
        {
            int aseguradoId = Convert.ToInt32((sender as LinkButton).CommandArgument);
            involucradosDTO asegurado = this.aseguradoBO.obtenerPorId(aseguradoId);

            txtAseguradoId.Text = asegurado.personalId.ToString();
            txtAseguradoDni.Text = asegurado.dni;
            txtAseguradoNombres.Text = asegurado.nombres;
            txtAseguradoApellidoPaterno.Text = asegurado.apellidoPaterno;
            txtAseguradoApellidoMaterno.Text = asegurado.apellidoMaterno;  

            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
        }
    }
}