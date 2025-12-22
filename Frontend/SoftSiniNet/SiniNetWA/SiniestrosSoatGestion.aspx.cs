
using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSImagenesSiniestros;
using SiniNetBusiness.SiniNetWSPolizasSOAT;
using SiniNetBusiness.SiniNetWSSiniestros;
using SiniNetBusiness.SiniNetWSSiniestrosSOAT;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftAsegWA
{
    public partial class SiniestrosSoatGestion : System.Web.UI.Page
    {
        private SiniestroSOATBO siniestroSoatBO;
        private EmpleadoBO empleadoBO;
        private CentroDeSaludBO centroDeSaludBO;
        private PolizaSOATBO polizaSOATBO;
        private PersonaBO personaBO;
        private bool estaModificando;
        int? siniestroSoatId;
        private ImagenSiniestroBO imagenBO;
        private IList<SiniNetBusiness.SiniNetWSPolizasSOAT.polizasSOATDTO> listaPolizasSoat;       
        public SiniestrosSoatGestion()
        {
            this.siniestroSoatBO = new SiniestroSOATBO();
            this.empleadoBO = new EmpleadoBO();
            this.centroDeSaludBO = new CentroDeSaludBO();
            this.polizaSOATBO = new PolizaSOATBO();
            this.personaBO = new PersonaBO();   
            this.siniestroSoatId = null;
            this.estaModificando = false;
            this.imagenBO = new ImagenSiniestroBO();            
        }
      
        protected void Page_Init(object sender, EventArgs e)
        {
            this.siniestroSoatId = (int?)Session["SiniestroId"];
            string accion = Request.QueryString["accion"];

            if (accion != null && accion == "modificar")
            {
                this.estaModificando = true;
                this.CargarDatosDelSiniestro();
                lblSubtitulo.Text = "Modificar Siniestro SOAT";
            }
            else
            {
                this.estaModificando = false;
                lblSubtitulo.Text = "Crear Siniestro SOAT";
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> listaInicial =
                    new List<SiniNetBusiness.SiniNetWSPersonas.personasDTO>();
                if (this.estaModificando)
                {
                    listaInicial = personaBO.listarAseguradosPorSiniestro((int)this.siniestroSoatId).ToList();
                }

                Session["Afectados"] = listaInicial;    
            }
            AplicarSeguridadPorRol();
            CargarAfectadosEnTabla();
        }

        private void CargarAfectadosEnTabla()
        {
            IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> lista = (IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO>)Session["Afectados"];

            gdvAfectados.DataSource = lista;
            gdvAfectados.DataBind();
        }

        private void CargarDatosDelSiniestro()
        {
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO siniestroSOATDTO = this.siniestroSoatBO.obtenerPorId((int)this.siniestroSoatId);
            SiniNetBusiness.SiniNetWSCentrosDeSalud.centrosDeSaludDTO centroDeSaludDTO = this.centroDeSaludBO.obtenerPorId(siniestroSOATDTO.centroDeSalud.centroDeSaludId);
            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO empleadoDTO = this.empleadoBO.obtenerPorId(siniestroSOATDTO.procurador.personalId);
            SiniNetBusiness.SiniNetWSPolizasSOAT.polizasSOATDTO polizaSOATDTO = this.polizaSOATBO.obtenerPorId(siniestroSOATDTO.poliza.polizaId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO personaDTO = this.personaBO.obtenerPorId(polizaSOATDTO.asegurado.personalId);


            txtCalificacion.Text = siniestroSOATDTO.calificacionServicio.ToString();
            txtIdSiniestro.Text = siniestroSOATDTO.siniestroId.ToString();
            txtDescripcion.Text = siniestroSOATDTO.descripcion;
            txtFechaHora.Text = siniestroSOATDTO.fechaHora.ToString();
            
            ddlEstado.SelectedValue = siniestroSOATDTO.estado.ToString();
            txtCalificacion.Text = siniestroSOATDTO.calificacionServicio.ToString();
            if (siniestroSOATDTO.validez) ddlValidez.SelectedValue = "VALIDO";
            else ddlValidez.SelectedValue = "INVALIDO";

            txtGastosMedicos.Text = siniestroSOATDTO.gastosMedicos.ToString();
            txtDiagnostico.Text = siniestroSOATDTO.diagnostico.ToString();

            txtDireccion.Text = siniestroSOATDTO.ubicacion.direccion.ToString();
            txtReferencia.Text = siniestroSOATDTO.ubicacion.referencia.ToString();
            txtUbicacionId.Text = siniestroSOATDTO.ubicacion.ubicacionId.ToString();
            txtLatitudForm.Text = siniestroSOATDTO.ubicacion.latitud.ToString();
            txtLongitudForm.Text = siniestroSOATDTO.ubicacion.longitud.ToString();

            txtCentroSaludId.Text = siniestroSOATDTO.centroDeSalud.centroDeSaludId.ToString();
            txtCentroSaludNombre.Text = centroDeSaludDTO.nombre;
            txtCentroSaludCodigo.Text = centroDeSaludDTO.codigoRenipress;
            
            txtProcuradorId.Text = empleadoDTO.personalId.ToString();
            txtProcuradorNombre.Text = empleadoDTO.nombres;
            txtProcuradorApellidoPaterno.Text = empleadoDTO.apellidoPaterno;
            txtProcuradorApellidoMaterno.Text = empleadoDTO.apellidoMaterno;
            btnVerImagenes.Visible = true;

            txtPolizaSoatId.Text = polizaSOATDTO.polizaId.ToString();
            txtPolizaSoatAseguradoNombre.Text = personaDTO.nombres.ToString();
            txtPolizaSoatAseguradoApellidoPaterno.Text = personaDTO.apellidoPaterno.ToString();
            txtPolizaSoatMonto.Text = polizaSOATDTO.montoACobertura.ToString();
        }

        private void AplicarSeguridadPorRol()
        {
            string rol = Session["rolUsuario"].ToString();
            if (rol == "Procurador")
            {
                ddlEstado.Enabled = false;
                txtFechaHora.Enabled = false;
                txtDireccion.Enabled = false;
                txtReferencia.Enabled = false;
                btnAbrirMapa.Enabled = false;
                btnFiltrarProcurador.Enabled = false;
                btnFiltrarPolizasSoat.Enabled = false;
            }
            if (!this.estaModificando)
            {
                lblEstado.Visible = false;
                ddlEstado.Visible = false;
                ddlEstado.SelectedValue = "EN_PROCESO";

                lblCalificacion.Visible = false;
                txtCalificacion.Visible = false;
                txtCalificacion.Text = "1";

                lblValidez.Visible = false;
                ddlValidez.Visible = false;
                ddlValidez.SelectedValue = "INVALIDO";
                
                lblImagenes.Visible = false;
                fuImagenes.Visible = false;
                btnSubirImagenes.Visible = false;
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SiniestrosSoatListado.aspx");
        }
        
        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!ValidarCampos()) return;

            SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO siniestrosSOATDTO = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO();

            string descripcion = txtDescripcion.Text;
            string fechaHora = txtFechaHora.Text;

            Enum.TryParse(ddlEstado.SelectedValue, out SiniNetBusiness.SiniNetWSSiniestrosSOAT.estadoSiniestro estado);
            int calificacion = Convert.ToInt32(txtCalificacion.Text);
            
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.ubicacionesDTO ubicacion = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.ubicacionesDTO();
            if(this.estaModificando)
                ubicacion.ubicacionId = Int32.Parse(txtUbicacionId.Text);
            ubicacion.latitud = double.Parse(txtLatitudForm.Text);
            ubicacion.longitud = double.Parse(txtLongitudForm.Text);
            ubicacion.ubicacionIdSpecified = true;
            ubicacion.latitudSpecified = true;
            ubicacion.longitudSpecified = true;
            ubicacion.referencia = txtReferencia.Text;
            ubicacion.direccion = txtDireccion.Text;

            SiniNetBusiness.SiniNetWSSiniestrosSOAT.empleadosDTO procurador = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.empleadosDTO();
            procurador.personalId = Convert.ToInt32(txtProcuradorId.Text);
            procurador.personalIdSpecified = true;

            bool validez;
            if (ddlValidez.SelectedValue == "VALIDO") validez = true;
            else validez = false;

            SiniNetBusiness.SiniNetWSSiniestrosSOAT.centrosDeSaludDTO centroSalud = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.centrosDeSaludDTO();
            centroSalud.centroDeSaludId = Convert.ToInt32(txtCentroSaludId.Text);
            centroSalud.centroDeSaludIdSpecified = true;

            double gastos = double.Parse(txtGastosMedicos.Text);
            string diagnostico = txtDiagnostico.Text;


            IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> listaAfectados = (IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO>)Session["Afectados"];

            IList<SiniNetBusiness.SiniNetWSSiniestrosSOAT.personasDTO> listaAfectados2 =
                    new List<SiniNetBusiness.SiniNetWSSiniestrosSOAT.personasDTO>();
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.personasDTO personaAux;
            foreach ( var a in listaAfectados)
            {
                personaAux = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.personasDTO();
                personaAux.dni = a.dni;
                personaAux.nombres = a.nombres;
                personaAux.apellidoPaterno = a.apellidoPaterno;
                personaAux.apellidoMaterno = a.apellidoMaterno;
                personaAux.telefono = a.telefono;

                listaAfectados2.Add(personaAux);
            }


            SiniNetBusiness.SiniNetWSSiniestrosSOAT.polizasSOATDTO polizaSOAT = new SiniNetBusiness.SiniNetWSSiniestrosSOAT.polizasSOATDTO();
            polizaSOAT.polizaId = Convert.ToInt32(txtPolizaSoatId.Text);
            polizaSOAT.polizaIdSpecified = true;

            if (this.estaModificando)
            {
                this.siniestroSoatBO.modificar((int)siniestroSoatId, descripcion, fechaHora, estado, calificacion, ubicacion, procurador, validez, centroSalud, gastos, diagnostico, listaAfectados2, polizaSOAT);
                if (Session["rolUsuario"].ToString() == "Procurador")
                    EnviarCorreoNotificacionOperarios(procurador.personalId, (int)siniestroSoatId);
                else EnviarCorreoNotificacion(procurador.personalId, (int)siniestroSoatId);
            }
            else
            {
                int siniestroID = this.siniestroSoatBO.insertar(descripcion, fechaHora, estado, calificacion, ubicacion, procurador, validez, centroSalud, gastos, diagnostico, listaAfectados2, polizaSOAT);
                EnviarCorreoNotificacion(procurador.personalId, siniestroID);
            }

            Response.Redirect("SiniestrosSoatListado.aspx");
        }

        private bool ValidarCampos()
        {
            return (ValidarCamposLlenos() && ValidarCamposCorrectos());
        }

        private bool ValidarCamposLlenos()
        {
            if (
                string.IsNullOrWhiteSpace(txtDescripcion.Text) ||
                string.IsNullOrWhiteSpace(txtFechaHora.Text) ||
                ddlEstado.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtCalificacion.Text) ||
                ddlValidez.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtGastosMedicos.Text) ||
                string.IsNullOrWhiteSpace(txtDiagnostico.Text) ||
                gdvAfectados.Rows.Count == 0 ||
                string.IsNullOrWhiteSpace(txtDireccion.Text) ||
                string.IsNullOrWhiteSpace(txtReferencia.Text) ||
                (string.IsNullOrWhiteSpace(txtUbicacionId.Text)  && estaModificando)||
                string.IsNullOrWhiteSpace(txtCentroSaludId.Text) ||
                string.IsNullOrWhiteSpace(txtProcuradorId.Text) ||
                string.IsNullOrWhiteSpace(txtPolizaSoatId.Text)
               )
            {
                this.MostrarAdvertencia("Debe completar todos los campos antes de continuar.");
                return false;
            }
            return true;
        }

        private bool ValidarCamposCorrectos()
        {
            if (txtDescripcion.Text.Length < 5)
            {
                MostrarAdvertencia("La descripción debe contener al menos 5 caracteres.");
                return false;
            }
                        
            if (txtDiagnostico.Text.Length < 5)
            {
                MostrarAdvertencia("El diagnóstico debe contener al menos 5 caracteres.");
                return false;
            }

            if (txtDireccion.Text.Length < 5)
            {
                MostrarAdvertencia("La dirección debe contener al menos 5 caracteres.");
                return false;
            }

            if (txtReferencia.Text.Length < 5)
            {
                MostrarAdvertencia("La referencia debe contener al menos 5 caracteres.");
                return false;
            }

            if (Int32.Parse(txtCalificacion.Text) < 1 || Int32.Parse(txtCalificacion.Text) > 10)
            {
                MostrarAdvertencia("La calificación debe ser un valor entre 0 y 10");
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

        private void EnviarCorreoNotificacionOperarios(int idProcurador, int siniestroID)
        {
            try
            {
                var procurador = this.empleadoBO.obtenerPorId(idProcurador);
                var listaOperarios = this.empleadoBO.listarPorNombreApellidoPaternoTipo("operador");
                string emailOrigen = "smot.fer.dm21@gmail.com";
                string password = "pcdzplpewiabifwl"; // No cambiar

                MailMessage mail = new MailMessage();
                mail.From = new MailAddress(emailOrigen, "Sistema SiniNet");
                foreach (var operario in listaOperarios)
                {
                    mail.To.Add(operario.correo);
                }
                mail.Subject = "Notificación de siniestro";
                mail.IsBodyHtml = true;
                mail.Body =
                $"<h2>Siniestro modificado</h2>" +
                $"<p>Procurador:</p>" +
                $"<p>{procurador.nombres} {procurador.apellidoPaterno} {procurador.apellidoMaterno}</p>" +
                $"<p>Con ID: {idProcurador}</p>" +
                $"<p>Estimados operadores, se les notifica que se ha modificado el siguiente siniestro:</p>" +
                $"<p><strong>ID Siniestro:</strong> {siniestroID}</p>" +
                $"<p>Tipo: SOAT.</p>" +
                $"<p>Por favor ingresar al sistema para revisarlo.</p>" +
                $"<br>" +
                $"<p>Atentamente,</p>" +
                $"<p><b>Equipo SiniNet</b></p>";
                SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                smtp.UseDefaultCredentials = false;
                smtp.Credentials = new NetworkCredential(emailOrigen, password);
                smtp.EnableSsl = true;

                smtp.Send(mail);

                ScriptManager.RegisterStartupScript(this, GetType(), "msgOk",
                    "alert('Correo enviado correctamente.');", true);
            }
            catch (Exception ex)
            {
                ScriptManager.RegisterStartupScript(this, GetType(), "msgErr",
                    $"alert('Error al enviar correo: {ex.Message}');", true);
            }
        }

        private void EnviarCorreoNotificacion(int idProcurador, int siniestroID)
        {
            try
            {
                var procurador = this.empleadoBO.obtenerPorId(idProcurador);
                string emailOrigen = "smot.fer.dm21@gmail.com";
                string password = "pcdzplpewiabifwl"; // No cambiar

                MailMessage mail = new MailMessage();
                mail.From = new MailAddress(emailOrigen, "Sistema SiniNet");

                mail.To.Add(procurador.correo);
                if (this.estaModificando)
                {
                    mail.Subject = "Notificación de siniestro actualizado";
                    mail.IsBodyHtml = true;
                    mail.Body =
                    $"<h2>Siniestro Modificado</h2>" +
                    $"<p>Estimado procurador, {procurador.nombres} {procurador.apellidoPaterno} {procurador.apellidoMaterno}</p>" +
                    $"<p>Se le notifica que se ha modificado el siguiente siniestro:</p>" +
                    $"<p><strong>ID Siniestro:</strong> {siniestroID}</p>" +
                    $"<p>Tipo: SOAT.</p>" +
                    $"<p>Por favor ingrese al sistema para revisarlo.</p>" +
                    $"<br>" +
                    $"<p>Atentamente,</p>" +
                    $"<p><b>Equipo SiniNet</b></p>";
                }
                else
                {
                    mail.Subject = "Notificación de nuevo siniestro asignado";
                    mail.IsBodyHtml = true;
                    mail.Body =
                    $"<h2>Nuevo Siniestro Asignado</h2>" +
                    $"<p>Estimado procurador, {procurador.nombres} {procurador.apellidoPaterno} {procurador.apellidoMaterno}</p>" +
                    $"<p>Se le ha asignado el siguiente siniestro para revisión:</p>" +
                    $"<p><strong>ID Siniestro:</strong> {siniestroID}</p>" +
                    $"<p>Tipo: SOAT.</p>" +
                    $"<p>Por favor ingrese al sistema para revisarlo.</p>" +
                    $"<br>" +
                    $"<p>Atentamente,</p>" +
                    $"<p><b>Equipo SiniNet</b></p>";
                }
                SmtpClient smtp = new SmtpClient("smtp.gmail.com", 587);
                smtp.UseDefaultCredentials = false;
                smtp.Credentials = new NetworkCredential(emailOrigen, password);
                smtp.EnableSsl = true;

                smtp.Send(mail);

                ScriptManager.RegisterStartupScript(this, GetType(), "msgOk",
                    "alert('Correo enviado correctamente.');", true);
            }
            catch (Exception ex)
            {
                ScriptManager.RegisterStartupScript(this, GetType(), "msgErr",
                    $"alert('Error al enviar correo: {ex.Message}');", true);
            }
        }

        // --- LÓGICA DE MODALES (CONECTADA A BO) ---

        protected void btnFiltrarCentroSalud_Click(object sender, EventArgs e)
        {
            ScriptManager.RegisterStartupScript(this, GetType(), "PopCentroSalud", "new bootstrap.Modal(document.getElementById('modalBuscarCentroSalud')).show();", true);
        }

        protected void lbBuscarCentroSalud_Click(object sender, EventArgs e)
        {
            string filtro = txtFiltroCentroSalud.Text;
            IList<SiniNetBusiness.SiniNetWSCentrosDeSalud.centrosDeSaludDTO> lista = this.centroDeSaludBO.listarPorNombreCodigoRENIPRESS(filtro);
            dgvBusquedaCentrosSalud.DataSource = lista;
            dgvBusquedaCentrosSalud.DataBind();
        }

        protected void lbSeleccionarCentroSalud_Click(object sender, EventArgs e)
        {
            int centroSaludId = Convert.ToInt32((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSCentrosDeSalud.centrosDeSaludDTO centroSalud = this.centroDeSaludBO.obtenerPorId(centroSaludId);

            txtCentroSaludId.Text = centroSalud.centroDeSaludId.ToString();
            txtCentroSaludNombre.Text = centroSalud.nombre;
            txtCentroSaludCodigo.Text = centroSalud.codigoRenipress.ToString();

            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
        }

        protected void btnFiltrarProcurador_Click(object sender, EventArgs e)
        {            
            ScriptManager.RegisterStartupScript(this, GetType(), "PopProcurador", "new bootstrap.Modal(document.getElementById('modalBuscarProcurador')).show();", true);
        }

        protected void lbBuscarProcurador_Click(object sender, EventArgs e)
        {
            string filtro = txtFiltroProcurador.Text;
            IList<SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO> lista = this.empleadoBO.listarProcuradores(filtro);
            dgvBusquedaProcuradores.DataSource = lista;
            dgvBusquedaProcuradores.DataBind();
        }

        protected void lbSeleccionarProcurador_Click(object sender, EventArgs e)
        {
            int procuradorId = Convert.ToInt32(((LinkButton)sender).CommandArgument);
            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO procurador = this.empleadoBO.obtenerPorId(procuradorId);

            txtProcuradorId.Text = procurador.personalId.ToString();
            txtProcuradorNombre.Text = procurador.nombres;
            txtProcuradorApellidoPaterno.Text = procurador.apellidoPaterno;
            txtProcuradorApellidoMaterno.Text = procurador.apellidoMaterno;           

            ScriptManager.RegisterStartupScript(this, GetType(), "", "__doPostBack('','');", true);
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

        protected void btnFiltrarPolizasSoat_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormPolizasSoatDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalFiltroPolizaSoat_lbBuscarPolizaSoat_Click(object sender, EventArgs e)
        {
            string filtro = ModalFiltroPolizaSoat_txtFiltroPolizaSoat.Text.Trim();
            this.listaPolizasSoat = this.polizaSOATBO.listarPorNombreApellidoAsegurado(filtro);
            ModalFiltroPolizaSoat_gvPolizaSoat.DataSource = this.listaPolizasSoat;
            ModalFiltroPolizaSoat_gvPolizaSoat.DataBind();
        }

        protected void ModalFiltroPolizaSoat_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int polizaId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSPolizasSOAT.polizasSOATDTO poliza = this.polizaSOATBO.obtenerPorId(polizaId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO asegurado = this.personaBO.obtenerPorId(poliza.asegurado.personalId);

            txtPolizaSoatId.Text = poliza.polizaId.ToString();
            txtPolizaSoatMonto.Text = poliza.montoACobertura.ToString();
            txtPolizaSoatAseguradoNombre.Text = asegurado.nombres;
            txtPolizaSoatAseguradoApellidoPaterno.Text = asegurado.apellidoPaterno;

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }

        protected void btnAgregarAfectados_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormAfectadosDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }
        protected void btnVerImagenes_Click(object sender, EventArgs e)
        {
            if (this.siniestroSoatId.HasValue)
            {
                int siniestroId = (int)this.siniestroSoatId;
                CargarImagenesEnModal(siniestroId);
                ScriptManager.RegisterStartupScript(this, GetType(), "PopGestionImagenes",
                    "new bootstrap.Modal(document.getElementById('modalGestionImagenes')).show();", true);
            }
        }

        private void CargarImagenesEnModal(int siniestroId)
        {
            try
            {
                var listaImagenes = imagenBO.listarPorSiniestro(siniestroId);

                // Verificar si hay imágenes
                if (listaImagenes != null && listaImagenes.Count > 0)
                {
                    // Hay imágenes: mostrar el Repeater
                    rptImagenesGestion.DataSource = listaImagenes;
                    rptImagenesGestion.DataBind();
                    rptImagenesGestion.Visible = true;
                    lblNoImagenesGestion.Visible = false;
                }
                else
                {
                    // No hay imágenes: limpiar el Repeater y mostrar mensaje
                    rptImagenesGestion.DataSource = null;
                    rptImagenesGestion.DataBind();
                    rptImagenesGestion.Visible = false;
                    lblNoImagenesGestion.Visible = true;
                    lblNoImagenesGestion.Text = "No hay imágenes registradas para este siniestro.";
                }

                Session["SiniestroIdImagenes"] = siniestroId;
            }
            catch (Exception ex)
            {
                // Manejar cualquier error y mostrar mensaje
                rptImagenesGestion.Visible = false;
                lblNoImagenesGestion.Visible = true;
                lblNoImagenesGestion.Text = "No hay imágenes registradas para este siniestro.";
                Session["SiniestroIdImagenes"] = siniestroId;
            }
        }

        protected void lbEliminarImagen_Click(object sender, EventArgs e)
        {
            int imagenId = Int32.Parse((sender as LinkButton).CommandArgument);
            int siniestroId = (int)Session["SiniestroIdImagenes"];

            int resultado = imagenBO.eliminar(imagenId);

            if (resultado > 0)
            {
                // Recargar imágenes
                CargarImagenesEnModal(siniestroId);
            }
        }

        protected void lbModalAgregarAfectado_Click(object sender, EventArgs e)
        {
            if (!this.ValidarCamposAfectado()) return;
            SiniNetBusiness.SiniNetWSPersonas.personasDTO persona = new SiniNetBusiness.SiniNetWSPersonas.personasDTO();

            persona.personalId = Int32.Parse(txtModalDniAfectado.Text);
            persona.dni = txtModalDniAfectado.Text;
            persona.nombres = txtModalNombresAfectado.Text;
            persona.apellidoPaterno = txtModalApellidoPaternoAfectado.Text;
            persona.apellidoMaterno = txtModalApellidoMaternoAfectado.Text;
            persona.telefono = txtModalTelefonoAfectado.Text;

            IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> listaAfectados = (IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO>)Session["Afectados"];

            listaAfectados.Add(persona);
            gdvAfectados.DataSource = listaAfectados;
            gdvAfectados.DataBind();

            txtModalDniAfectado.Text = "";
            txtModalNombresAfectado.Text = "";
            txtModalApellidoPaternoAfectado.Text = "";
            txtModalApellidoMaternoAfectado.Text = "";
            txtModalTelefonoAfectado.Text = "";

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }

        private bool ValidarCamposAfectado()
        {
            return (this.ValidarCamposLenosAfectado() && this.ValidarCamposValidosAfectado());
        }

        private bool ValidarCamposValidosAfectado()
        {
            // --- DNI: solo números y 8 dígitos ---
            if (!txtModalDniAfectado.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El DNI debe contener solo números.");
                return false;
            }
            if (txtModalDniAfectado.Text.Length != 8)
            {
                MostrarAdvertencia("El DNI debe tener exactamente 8 dígitos.");
                return false;
            }

            // --- Nombres: solo letras y mínimo 3 ---
            if (!Regex.IsMatch(txtModalNombresAfectado.Text, @"^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$"))
            {
                MostrarAdvertencia("El nombre solo debe contener letras y espacios.");
                return false;
            }
            if (txtModalNombresAfectado.Text.Length < 3)
            {
                MostrarAdvertencia("El nombre debe tener al menos 3 letras.");
                return false;
            }

            // --- Apellido Paterno ---
            if (!txtModalApellidoPaternoAfectado.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido paterno solo debe contener letras.");
                return false;
            }
            if (txtModalApellidoPaternoAfectado.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido paterno debe tener al menos 3 letras.");
                return false;
            }

            // --- Apellido Materno ---
            if (!txtModalApellidoMaternoAfectado.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido materno solo debe contener letras.");
                return false;
            }
            if (txtModalApellidoMaternoAfectado.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido materno debe tener al menos 3 letras.");
                return false;
            }

            // --- Teléfono: solo números ---
            if (!txtModalTelefonoAfectado.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El teléfono debe contener solo números.");
                return false;
            }

            // --- Usuario: mínimo 3 letras ---
            if (txtModalTelefonoAfectado.Text.Length < 3)
            {
                MostrarAdvertencia("El usuario debe tener al menos 3 caracteres.");
                return false;
            }            
            return true;
        }

        private bool ValidarCamposLenosAfectado()
        {
            if (string.IsNullOrWhiteSpace(txtModalDniAfectado.Text) ||
                string.IsNullOrWhiteSpace(txtModalNombresAfectado.Text) ||
                string.IsNullOrWhiteSpace(txtModalApellidoPaternoAfectado.Text) ||
                string.IsNullOrWhiteSpace(txtModalApellidoMaternoAfectado.Text) ||
                string.IsNullOrWhiteSpace(txtModalTelefonoAfectado.Text)
                )
            {
                this.MostrarAdvertencia("Debe completar todos los campos antes de continuar.");
                return false;
            }
            return true;
        }

        protected void lbEliminarAfectado_Click(object sender, EventArgs e)
        {
            string dni = (sender as LinkButton).CommandArgument;

            IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> listaAfectados = (IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO>)Session["Afectados"];
            
            SiniNetBusiness.SiniNetWSPersonas.personasDTO afectado = listaAfectados.FirstOrDefault(x => x.dni == dni);

            if (afectado != null)
            {
                listaAfectados.Remove(afectado);
            }
            
            Session["Afectados"] = listaAfectados;

            gdvAfectados.DataSource = listaAfectados;
            gdvAfectados.DataBind();
        }

        protected void btnSubirImagenes_Click(object sender, EventArgs e)
        {
            // Verificar que haya un siniestro (ya sea en modo modificación o recién insertado)
            int? siniestroIdActual = this.siniestroSoatId;

            // Si no hay siniestroId, verificar si hay uno en Session (por si acaba de insertar)
            if (!siniestroIdActual.HasValue)
            {
                object sessionId = Session["SiniestroId"];
                if (sessionId != null)
                {
                    siniestroIdActual = Convert.ToInt32(sessionId);
                }
            }

            if (!siniestroIdActual.HasValue)
            {
                MostrarMensajeModal("Debe guardar el siniestro primero antes de subir imágenes.");
                return;
            }

            if (!fuImagenes.HasFiles)
            {
                MostrarMensajeModal("Por favor seleccione al menos una imagen para subir.");
                return;
            }

            // Subir las imágenes
            int imagenesSubidas = 0;
            int imagenesError = 0;

            foreach (HttpPostedFile archivo in fuImagenes.PostedFiles)
            {
                if (archivo.ContentLength > 0)
                {
                    try
                    {
                        byte[] imagenBytes = new byte[archivo.ContentLength];
                        archivo.InputStream.Read(imagenBytes, 0, archivo.ContentLength);
                        string base64 = Convert.ToBase64String(imagenBytes);
                        string nombreArchivo = System.IO.Path.GetFileName(archivo.FileName);

                        int imagenId = imagenBO.subirImagen((int)siniestroIdActual, nombreArchivo, base64);
                        if (imagenId > 0)
                        {
                            imagenesSubidas++;
                        }
                        else
                        {
                            imagenesError++;
                        }
                    }
                    catch (Exception ex)
                    {
                        imagenesError++;
                        System.Diagnostics.Debug.WriteLine("Error al subir imagen: " + ex.Message);
                    }
                }
            }

            // Mostrar mensaje de resultado
            if (imagenesSubidas > 0 && imagenesError == 0)
            {
                MostrarMensajeModal($"Se subieron {imagenesSubidas} imagen(es) correctamente.");
            }
            else if (imagenesSubidas > 0 && imagenesError > 0)
            {
                MostrarMensajeModal($"Se subieron {imagenesSubidas} imagen(es) correctamente. Error al subir {imagenesError} imagen(es).");
            }
            else if (imagenesError > 0)
            {
                MostrarMensajeModal($"Error al subir {imagenesError} imagen(es).");
            }

            // Limpiar el FileUpload después de subir
            fuImagenes.Attributes.Clear();

            // Si estamos en modo modificación, recargar las imágenes en el modal si está abierto
            if (this.estaModificando && imagenesSubidas > 0)
            {
                CargarImagenesEnModal((int)siniestroIdActual);
            }
        }

        private void MostrarMensajeModal(string mensaje)
        {
            string mensajeEscapado = mensaje.Replace("'", "\\'").Replace("\r\n", "\\n").Replace("\n", "\\n");

            string script = $@"
                            document.getElementById('mensajeTexto').textContent = '{mensajeEscapado}';
                            var modal = new bootstrap.Modal(document.getElementById('modalMensaje'), {{
                                backdrop: false
                            }});
                            modal.show();
                        ";
            ScriptManager.RegisterStartupScript(this, GetType(), "MostrarMensaje_" + Guid.NewGuid().ToString(), script, true);
        }
    }

}