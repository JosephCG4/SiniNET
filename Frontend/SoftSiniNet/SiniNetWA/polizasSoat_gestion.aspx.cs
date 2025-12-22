using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSInvolucrados;
using SiniNetBusiness.SiniNetWSPolizasSOAT;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class polizasSoat_gestion : System.Web.UI.Page
    {
        private PolizaSOATBO polizaSoatBO;
        private InvolucradoBO aseguradoBO;
        private IList<involucradosDTO> listaAsegurados;
        private bool estaModificando;
        int? polizaId;

        public polizasSoat_gestion()
        {
            this.polizaSoatBO = new PolizaSOATBO();
            this.aseguradoBO = new InvolucradoBO();
            this.estaModificando = false;
            this.polizaId = null;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.polizaId = (int?)Session["polizaSoatId"];
            string accion = Request.QueryString["accion"];

            if (accion != null && accion == "modificar")
            {
                this.estaModificando = true;
                this.CargarDatosDelSiniestro();
                lblSubtitulo.Text = "Modificar Poliza SOAT";
            }
            else
            {
                this.estaModificando = false;
                lblSubtitulo.Text = "Crear Poliza SOAT";
            }
        }

        private void CargarDatosDelSiniestro()
        {
            polizasSOATDTO poliza = this.polizaSoatBO.obtenerPorId((int)this.polizaId);
            involucradosDTO asegurado = this.aseguradoBO.obtenerPorId(poliza.asegurado.personalId);

            txtId.Text = poliza.polizaId.ToString();
            txtMonto.Text = poliza.montoACobertura.ToString();
            ddlEstado.SelectedValue = poliza.estado.ToString();
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
            Response.Redirect("polizasSoat_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!ValidarCampos()) return;

            SiniNetBusiness.SiniNetWSPolizasSOAT.personasDTO persona = new SiniNetBusiness.SiniNetWSPolizasSOAT.personasDTO();

            persona.personalId = Convert.ToInt32(txtAseguradoId.Text);
            persona.personalIdSpecified = true;
            Enum.TryParse(ddlEstado.SelectedValue, out SiniNetBusiness.SiniNetWSPolizasSOAT.estadoPoliza estado);
            int monto = Convert.ToInt32(txtMonto.Text);

            if (this.estaModificando)
            {
                this.polizaSoatBO.modificar((int)this.polizaId, persona, estado, monto);
            }
            else
            {
                this.polizaSoatBO.insertar(persona, estado, monto);
            }

            Response.Redirect("polizasSoat_listado.aspx");
        }

        private bool ValidarCampos()
        {
            return (ValidarCamposLlenos());
        }

        private bool ValidarCamposLlenos()
        {
            if (
                string.IsNullOrWhiteSpace(txtAseguradoId.Text) ||
                ddlEstado.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtMonto.Text)
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