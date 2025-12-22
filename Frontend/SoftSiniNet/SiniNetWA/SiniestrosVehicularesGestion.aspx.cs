using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSImagenesSiniestros;
using SiniNetBusiness.SiniNetWSPolizasSOAT;
using SiniNetBusiness.SiniNetWSSiniestros;
using SiniNetBusiness.SiniNetWSSiniestrosSOAT;
using SiniNetBusiness.SiniNetWSSiniestrosVehiculares;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Text.RegularExpressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftAsegWA
{
    public partial class SiniestrosVehicularesGestion : System.Web.UI.Page
    {
        private SiniestroVehicularBO siniestroVehicularBO;
        private EmpleadoBO empleadoBO;
        private TallerBO tallerBO;
        private PolizaVehicularBO polizaVehicularBO;
        private PersonaBO personaBO;
        private VehiculoBO vehiculoBO;
        private ImagenSiniestroBO imagenBO;
        private bool estaModificando;
        int? siniestroVehicularId;
        private IList<SiniNetBusiness.SiniNetWSPolizasVehiculares.polizasVehicularesDTO> listaPolizasVehiculares;
        public SiniestrosVehicularesGestion()
        {
            this.siniestroVehicularBO = new SiniestroVehicularBO();
            this.empleadoBO = new EmpleadoBO();
            this.tallerBO = new TallerBO();
            this.polizaVehicularBO = new PolizaVehicularBO();
            this.personaBO = new PersonaBO();
            this.vehiculoBO = new VehiculoBO();
            this.imagenBO = new ImagenSiniestroBO();
            this.siniestroVehicularId = null;
            this.estaModificando = false;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.siniestroVehicularId = (int?)Session["SiniestroId"];
            string accion = Request.QueryString["accion"];

            if (accion != null && accion == "modificar")
            {
                this.estaModificando = true;
                this.CargarDatosDelSiniestro();
                lblSubtitulo.Text = "Modificar Siniestro Vehicular";
            }
            else
            {
                this.estaModificando = false;
                lblSubtitulo.Text = "Crear Siniestro Vehicular";
            }
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            AplicarSeguridadPorRol();
        }

        private void CargarDatosDelSiniestro()
        {
            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.siniestrosVehicularesDTO siniestroVehicularDTO = this.siniestroVehicularBO.obtenerPorId((int)this.siniestroVehicularId);
            SiniNetBusiness.SiniNetWSTalleres.talleresDTO tallerDTO = this.tallerBO.obtenerPorId(siniestroVehicularDTO.tallerAsignado.tallerId);
            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO empleadoDTO = this.empleadoBO.obtenerPorId(siniestroVehicularDTO.procurador.personalId);
            SiniNetBusiness.SiniNetWSPolizasVehiculares.polizasVehicularesDTO polizaVehicularDTO = this.polizaVehicularBO.obtenerPorId(siniestroVehicularDTO.poliza.polizaId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO personaDTO = this.personaBO.obtenerPorId(polizaVehicularDTO.asegurado.personalId);
            SiniNetBusiness.SiniNetWSVehiculos.vehiculosDTO vehiculoDTO = this.vehiculoBO.obtenerPorId(siniestroVehicularDTO.vehiculo.vehiculoId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO conductorDTO = this.personaBO.obtenerPorId(siniestroVehicularDTO.conductor.personalId);

            txtCalificacion.Text = siniestroVehicularDTO.calificacionServicio.ToString();
            txtIdSiniestro.Text = siniestroVehicularDTO.siniestroId.ToString();
            txtDescripcion.Text = siniestroVehicularDTO.descripcion;
            txtFechaHora.Text = siniestroVehicularDTO.fechaHora.ToString();

            ddlEstado.SelectedValue = siniestroVehicularDTO.estado.ToString();
            txtCalificacion.Text = siniestroVehicularDTO.calificacionServicio.ToString();
            if (siniestroVehicularDTO.validez) ddlValidez.SelectedValue = "VALIDO";
            else ddlValidez.SelectedValue = "INVALIDO";

            txtCostoEstimado.Text = siniestroVehicularDTO.costoEstimado.ToString();
            ddlTipoDano.SelectedValue = siniestroVehicularDTO.tipoDano.ToString();
            txtDanos.Text = siniestroVehicularDTO.danos.ToString();

            txtDireccion.Text = siniestroVehicularDTO.ubicacion.direccion.ToString();
            txtReferencia.Text = siniestroVehicularDTO.ubicacion.referencia.ToString();
            txtUbicacionId.Text = siniestroVehicularDTO.ubicacion.ubicacionId.ToString();
            txtLatitudForm.Text = siniestroVehicularDTO.ubicacion.latitud.ToString();
            txtLongitudForm.Text = siniestroVehicularDTO.ubicacion.longitud.ToString();

            txtTallerId.Text = siniestroVehicularDTO.tallerAsignado.tallerId.ToString();
            txtTallerNombre.Text = tallerDTO.nombre;

            txtProcuradorId.Text = empleadoDTO.personalId.ToString();
            txtProcuradorNombre.Text = empleadoDTO.nombres;
            txtProcuradorApellidoPaterno.Text = empleadoDTO.apellidoPaterno;
            txtProcuradorApellidoMaterno.Text = empleadoDTO.apellidoMaterno;


            txtPolizaVehicularId.Text = polizaVehicularDTO.polizaId.ToString();
            txtPolizaVehicularAseguradoNombre.Text = personaDTO.nombres.ToString();
            txtPolizaVehicularAseguradoApellidoPaterno.Text = personaDTO.apellidoPaterno.ToString();
            txtPolizaVehicularPorcentaje.Text = polizaVehicularDTO.porcentajeCobertura.ToString();

            txtConductorId.Text = conductorDTO.personalId.ToString();
            txtConductorDni.Text = conductorDTO.dni;
            txtConductorTelefono.Text = conductorDTO.telefono;
            txtConductorNombres.Text = conductorDTO.nombres;
            txtConductorApellidoPaterno.Text = conductorDTO.apellidoPaterno;
            txtConductorApellidoMaterno.Text = conductorDTO.apellidoMaterno;

            txtVehiculoId.Text = vehiculoDTO.vehiculoId.ToString();
            txtVehiculoPlaca.Text = vehiculoDTO.placa;
            txtVehiculoMarca.Text = vehiculoDTO.marca.ToString();
            txtVehiculoModelo.Text = vehiculoDTO.modelo.ToString();
            txtVehiculoTipo.Text = vehiculoDTO.tipo.ToString();
            btnVerImagenes.Visible = true;
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
                btnBuscarTaller.Enabled = false;
                btnBuscarProcurador.Enabled = false;
                btnFiltrarPolizasVehiculares.Enabled = false;
                btnBuscarVehiculo.Enabled = false;
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
            Response.Redirect("siniestrosVehiculares_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (!ValidarCampos()) return;

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.siniestrosVehicularesDTO siniestroVehicularDTO = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.siniestrosVehicularesDTO();

            string descripcion = txtDescripcion.Text;
            string fechaHora = txtFechaHora.Text;

            Enum.TryParse(ddlEstado.SelectedValue, out SiniNetBusiness.SiniNetWSSiniestrosVehiculares.estadoSiniestro estado);
            int calificacion = Convert.ToInt32(txtCalificacion.Text);

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.ubicacionesDTO ubicacion = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.ubicacionesDTO();
            if (this.estaModificando)
                ubicacion.ubicacionId = Int32.Parse(txtUbicacionId.Text);
            ubicacion.latitud = double.Parse(txtLatitudForm.Text);
            ubicacion.longitud = double.Parse(txtLongitudForm.Text);
            ubicacion.ubicacionIdSpecified = true;
            ubicacion.latitudSpecified = true;
            ubicacion.longitudSpecified = true;
            ubicacion.referencia = txtReferencia.Text;
            ubicacion.direccion = txtDireccion.Text;

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.empleadosDTO procurador = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.empleadosDTO();
            procurador.personalId = Convert.ToInt32(txtProcuradorId.Text);
            procurador.personalIdSpecified = true;

            bool validez;
            if (ddlValidez.SelectedValue == "VALIDO") validez = true;
            else validez = false;

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.talleresDTO taller = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.talleresDTO();
            taller.tallerId = Convert.ToInt32(txtTallerId.Text);
            taller.tallerIdSpecified = true;

            double costoEstimado = double.Parse(txtCostoEstimado.Text.ToString());
            string danos = txtDanos.Text.ToString();
            Enum.TryParse(ddlTipoDano.SelectedValue, out SiniNetBusiness.SiniNetWSSiniestrosVehiculares.tipoDanho tipoDano);

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.polizasVehicularesDTO polizaVehicular = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.polizasVehicularesDTO();
            polizaVehicular.polizaId = Convert.ToInt32(txtPolizaVehicularId.Text);
            polizaVehicular.polizaIdSpecified = true;

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.vehiculosDTO vehiculo = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.vehiculosDTO();
            vehiculo.vehiculoId = Convert.ToInt32(txtVehiculoId.Text);
            vehiculo.vehiculoIdSpecified = true;

            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.personasDTO conductor = new SiniNetBusiness.SiniNetWSSiniestrosVehiculares.personasDTO();
            string dniConductor = txtConductorDni.Text;
            string nombresConductor = txtConductorNombres.Text;
            string apellidosaPaternosConductor = txtConductorApellidoPaterno.Text;
            string apellidosaMaternosConductor = txtConductorApellidoMaterno.Text;
            string telefonoConductor = txtConductorTelefono.Text;

            if (this.estaModificando)
            {
                int idConductor = Convert.ToInt32(txtConductorId.Text);
                conductor.personalId = idConductor;
                conductor.personalIdSpecified = true;
                this.personaBO.modificar(idConductor, dniConductor, nombresConductor, apellidosaPaternosConductor, apellidosaMaternosConductor, telefonoConductor);
                this.siniestroVehicularBO.modificar((int)siniestroVehicularId, descripcion, fechaHora, estado, calificacion, ubicacion, procurador, validez, vehiculo, costoEstimado,
                    taller, danos, conductor, tipoDano, polizaVehicular);
                if (Session["rolUsuario"].ToString() == "Procurador")
                    EnviarCorreoNotificacionOperarios(procurador.personalId, (int)siniestroVehicularId);
                else EnviarCorreoNotificacion(procurador.personalId, (int)siniestroVehicularId);
            }
            else
            {
                conductor.personalId = personaBO.insertar(dniConductor, nombresConductor, apellidosaPaternosConductor, apellidosaMaternosConductor, telefonoConductor);
                conductor.personalIdSpecified = true;
                int siniestroID = this.siniestroVehicularBO.insertar(descripcion, fechaHora, estado, calificacion, ubicacion, procurador, validez, vehiculo, costoEstimado,
                    taller, danos, conductor, tipoDano, polizaVehicular);
                EnviarCorreoNotificacion(procurador.personalId, siniestroID);
            }

            Response.Redirect("siniestrosVehiculares_listado.aspx");
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
                string.IsNullOrWhiteSpace(txtCostoEstimado.Text) ||
                ddlTipoDano.SelectedIndex == 0 ||
                string.IsNullOrWhiteSpace(txtDanos.Text) ||
                string.IsNullOrWhiteSpace(txtDireccion.Text) ||
                string.IsNullOrWhiteSpace(txtReferencia.Text) ||
                (string.IsNullOrWhiteSpace(txtUbicacionId.Text) && estaModificando) ||
                string.IsNullOrWhiteSpace(txtTallerId.Text) ||
                string.IsNullOrWhiteSpace(txtProcuradorId.Text) ||
                string.IsNullOrWhiteSpace(txtPolizaVehicularId.Text) ||
                string.IsNullOrWhiteSpace(txtVehiculoId.Text) ||
                string.IsNullOrWhiteSpace(txtConductorDni.Text) ||
                string.IsNullOrWhiteSpace(txtConductorNombres.Text) ||
                string.IsNullOrWhiteSpace(txtConductorApellidoPaterno.Text) ||
                string.IsNullOrWhiteSpace(txtConductorApellidoMaterno.Text) ||
                string.IsNullOrWhiteSpace(txtConductorTelefono.Text)
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

            if (txtDanos.Text.Length < 5)
            {
                MostrarAdvertencia("Los daños debe contener al menos 5 caracteres.");
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

            if (!txtConductorDni.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El DNI debe contener solo números.");
                return false;
            }

            if (txtConductorDni.Text.Length != 8)
            {
                MostrarAdvertencia("El DNI debe tener exactamente 8 dígitos.");
                return false;
            }

            if (!Regex.IsMatch(txtConductorNombres.Text, @"^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$"))
            {
                MostrarAdvertencia("El nombre solo debe contener letras y espacios.");
                return false;
            }

            if (txtConductorNombres.Text.Length < 3)
            {
                MostrarAdvertencia("El nombre debe tener al menos 3 letras.");
                return false;
            }

            if (!txtConductorApellidoPaterno.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido paterno solo debe contener letras.");
                return false;
            }

            if (txtConductorApellidoPaterno.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido paterno debe tener al menos 3 letras.");
                return false;
            }

            if (!txtConductorApellidoMaterno.Text.All(char.IsLetter))
            {
                MostrarAdvertencia("El apellido materno solo debe contener letras.");
                return false;
            }

            if (txtConductorApellidoMaterno.Text.Length < 3)
            {
                MostrarAdvertencia("El apellido materno debe tener al menos 3 letras.");
                return false;
            }

            if (!txtConductorTelefono.Text.All(char.IsDigit))
            {
                MostrarAdvertencia("El teléfono debe contener solo números.");
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
                $"<p>Tipo: Vehicular.</p>" +
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
                    $"<p>Tipo: Vehicular.</p>" +
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
                    $"<p>Tipo: Vehicular.</p>" +
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

        protected void btnBuscarTaller_Click(object sender, EventArgs e)
        {
            ScriptManager.RegisterStartupScript(this, GetType(), "PopTaller", "new bootstrap.Modal(document.getElementById('modalBuscarTaller')).show();", true);
        }

        protected void lbBuscarTaller_Click(object sender, EventArgs e)
        {
            var filtro = txtFiltroTaller.Text;
            IList<SiniNetBusiness.SiniNetWSTalleres.talleresDTO> lista = this.tallerBO.listarPorNombreTalleres(filtro);
            dgvBusquedaTalleres.DataSource = lista;
            dgvBusquedaTalleres.DataBind();
        }

        protected void lbSeleccionarTaller_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSTalleres.talleresDTO dto = this.tallerBO.obtenerPorId(id);
            if (dto != null)
            {
                txtTallerId.Text = dto.tallerId.ToString();
                txtTallerNombre.Text = dto.nombre;
            }

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }

        protected void btnBuscarProcurador_Click(object sender, EventArgs e)
        {
            ScriptManager.RegisterStartupScript(this, GetType(), "PopProcurador", "new bootstrap.Modal(document.getElementById('modalBuscarProcurador')).show();", true);
        }

        protected void lbBuscarProcurador_Click(object sender, EventArgs e)
        {
            string filtro = txtFiltroProcurador.Text;
            var lista = this.empleadoBO.listarProcuradores(filtro);
            dgvBusquedaProcuradores.DataSource = lista;
            dgvBusquedaProcuradores.DataBind();
        }

        protected void lbSeleccionarProcurador_Click(object sender, EventArgs e)
        {
            int idProcurador = Convert.ToInt32(((LinkButton)sender).CommandArgument);
            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO dto = this.empleadoBO.obtenerPorId(idProcurador);
            txtProcuradorId.Text = dto.personalId.ToString();
            txtProcuradorNombre.Text = dto.nombres;
            txtProcuradorApellidoPaterno.Text = dto.apellidoPaterno;
            txtProcuradorApellidoMaterno.Text = dto.apellidoMaterno;
            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
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

        protected void btnFiltrarPolizasVehiculares_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormPolizasVehicularesDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalFiltroPolizaVehicular_lbBuscarPolizaVehicular_Click(object sender, EventArgs e)
        {
            string filtro = ModalFiltroPolizaVehicular_txtFiltroPolizaVehicular.Text.Trim();
            this.listaPolizasVehiculares = this.polizaVehicularBO.listarPorNombreApellidoAsegurado(filtro);
            ModalFiltroPolizaVehicular_gvPolizaVehicular.DataSource = this.listaPolizasVehiculares;
            ModalFiltroPolizaVehicular_gvPolizaVehicular.DataBind();
        }

        protected void ModalFiltroPolizaVehicular_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int polizaId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSPolizasVehiculares.polizasVehicularesDTO poliza = this.polizaVehicularBO.obtenerPorId(polizaId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO persona = this.personaBO.obtenerPorId(poliza.asegurado.personalId);

            txtPolizaVehicularId.Text = poliza.polizaId.ToString();
            txtPolizaVehicularPorcentaje.Text = poliza.porcentajeCobertura.ToString();
            txtPolizaVehicularAseguradoNombre.Text = persona.nombres;
            txtPolizaVehicularAseguradoApellidoPaterno.Text = persona.apellidoPaterno;

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }

        protected void btnBuscarConductor_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormConductoresDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbBuscarConductor_Click(object sender, EventArgs e)
        {
            string filtro = txtFiltroConductor.Text.Trim();
            var lista = this.personaBO.listarPorNombresApellidosDniPersona(filtro);
            gvConductor.DataSource = lista;
            gvConductor.DataBind();
        }
        protected void lbSeleccionarConductor_Click(object sender, EventArgs e)
        {
            int idConductor = Convert.ToInt32(((LinkButton)sender).CommandArgument);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO dto = this.personaBO.obtenerPorId(idConductor);
            txtConductorId.Text = dto.personalId.ToString();
            txtConductorNombres.Text = dto.nombres;
            txtConductorApellidoPaterno.Text = dto.apellidoPaterno;
            txtConductorApellidoMaterno.Text = dto.apellidoMaterno;

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }

        protected void btnBuscarVehiculo_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormVehiculosDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbBuscarVehiculo_Click(object sender, EventArgs e)
        {
            string filtro = txtFiltroVehiculo.Text.Trim();
            var lista = this.vehiculoBO.listarPorPlacaMarcaModeloTipoVehiculo(filtro);
            gvVehiculo.DataSource = lista;
            gvVehiculo.DataBind();
        }

        protected void lbSeleccionarVehicul_Click(object sender, EventArgs e)
        {
            int idVehiculo = Convert.ToInt32(((LinkButton)sender).CommandArgument);
            SiniNetBusiness.SiniNetWSVehiculos.vehiculosDTO dto = this.vehiculoBO.obtenerPorId(idVehiculo);
            txtVehiculoId.Text = dto.vehiculoId.ToString();
            txtVehiculoPlaca.Text = dto.placa;
            txtVehiculoMarca.Text = dto.marca.ToString();
            txtVehiculoModelo.Text = dto.modelo.ToString();
            txtVehiculoTipo.Text = dto.tipo.ToString();

            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }
        protected void btnVerImagenes_Click(object sender, EventArgs e)
        {
            if (this.siniestroVehicularId.HasValue)
            {
                int siniestroId = (int)this.siniestroVehicularId;
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

                if (listaImagenes != null && listaImagenes.Count > 0)
                {
                    rptImagenesGestion.DataSource = listaImagenes;
                    rptImagenesGestion.DataBind();
                    rptImagenesGestion.Visible = true;
                    lblNoImagenesGestion.Visible = false;
                }
                else
                {
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
                CargarImagenesEnModal(siniestroId);
            }
        }

        protected void btnSubirImagenes_Click(object sender, EventArgs e)
        {
            int? siniestroIdActual = this.siniestroVehicularId;

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

            fuImagenes.Attributes.Clear();

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
