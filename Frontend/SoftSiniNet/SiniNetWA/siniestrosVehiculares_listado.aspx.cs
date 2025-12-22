using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSCentrosDeSalud;
using SiniNetBusiness.SiniNetWSSiniestrosVehiculares;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class siniestrosVehiculares_listado : System.Web.UI.Page
    {
        private SiniestroVehicularBO siniestroVehicularBO;
        private IList<siniestrosVehicularesDTO> listaSiniestrosVehiculares;
        private VehiculoBO vehiculoBO;
        private TallerBO tallerBO;
        private PersonaBO personaBO;
        private PolizaVehicularBO polizaVehicularBO;
        private EmpleadoBO empleadoBO;
        private ImagenSiniestroBO imagenBO;

        public siniestrosVehiculares_listado()
        {
            this.siniestroVehicularBO = new SiniestroVehicularBO();
            this.vehiculoBO = new VehiculoBO();
            this.tallerBO = new TallerBO();
            this.personaBO = new PersonaBO();
            this.polizaVehicularBO = new PolizaVehicularBO();
            this.empleadoBO = new EmpleadoBO();
            this.imagenBO = new ImagenSiniestroBO();
        }

        public SiniestroVehicularBO SiniestroVehicularBO { get => siniestroVehicularBO; set => siniestroVehicularBO = value; }
        public IList<siniestrosVehicularesDTO> ListaSiniestrosVehiculares { get => listaSiniestrosVehiculares; set => listaSiniestrosVehiculares = value; }
        protected void lbImagenes_Click(object sender, EventArgs e)
        {
            int siniestroId = Int32.Parse((sender as LinkButton).CommandArgument);

            // Obtener imágenes del backend (ya tienen URLs de Cloudinary)
            var listaImagenes = imagenBO.listarPorSiniestro(siniestroId);

            // Cargar imágenes en el Repeater
            if (listaImagenes != null && listaImagenes.Count > 0)
            {
                rptImagenes.DataSource = listaImagenes;
                rptImagenes.DataBind();
                rptImagenes.Visible = true;
                lblNoImagenes.Visible = false;
            }
            else
            {
                rptImagenes.Visible = false;
                lblNoImagenes.Visible = true;
            }

            // Guardar en Session por si lo necesitas
            Session["SiniestroIdImagenes"] = siniestroId;

            // Mostrar modal
            ScriptManager.RegisterStartupScript(this, GetType(), "PopImagenes",
                "new bootstrap.Modal(document.getElementById('modalVerImagenes')).show();", true);
        }
        protected void Page_Load(object sender, EventArgs e)
        {


            if (Session["rolUsuario"].ToString() == "Operario")
                this.listaSiniestrosVehiculares = this.siniestroVehicularBO.listarTodos();
            else
                //Luego hay que cambiar ese 1 por el id del procurador que ha iniciado sesion
                this.listaSiniestrosVehiculares = this.siniestroVehicularBO.listarPorProcuradorSiniestrosVehiculares(Int32.Parse(Session["procuradorId"].ToString()));
            dgvSiniestroVehicular.DataSource = this.listaSiniestrosVehiculares;
            if (Session["rolUsuario"].ToString() == "Operario")
            {
                btnInsertar.Visible = true;
                dgvSiniestroVehicular.Columns[15].Visible = true;
            }
            else
            {
                dgvSiniestroVehicular.Columns[15].Visible = false;
                btnInsertar.Visible = false;
            }
            dgvSiniestroVehicular.DataBind();
        }


        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int siniestroVehicularId = Int32.Parse((sender as LinkButton).CommandArgument);
            this.SiniestroVehicularBO.eliminar(siniestroVehicularId);
            Response.Redirect("siniestrosVehiculares_listado.aspx");
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SiniestrosVehicularesGestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int siniestroVehicularId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["SiniestroId"] = siniestroVehicularId;
            Response.Redirect("SiniestrosVehicularesGestion.aspx?accion=modificar");
        }

        protected void lbUbicacion_Click(object sender, EventArgs e)
        {
            int siniestroId = Int32.Parse((sender as LinkButton).CommandArgument);
            siniestrosDTO sini = this.siniestroVehicularBO.obtenerPorId(siniestroId);

            txtDireccionVer.Text = sini.ubicacion.direccion;
            txtReferenciaVer.Text = sini.ubicacion.referencia;
            txtLatitudVer.Text = sini.ubicacion.latitud.ToString();
            txtLongitudVer.Text = sini.ubicacion.longitud.ToString();

            // Mostrar modal y centrar el mapa con el pin
            string script = $@"
            window.onload = function() {{
                showMapaVer({sini.ubicacion.latitud}, {sini.ubicacion.longitud});
            }};";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarMapa", script, true);
        }

        protected void lbVehiculo_Click(object sender, EventArgs e)
        {
            int vehiculoId = Convert.ToInt32((sender as LinkButton).CommandArgument);

            SiniNetBusiness.SiniNetWSVehiculos.vehiculosDTO vehiculo = this.vehiculoBO.obtenerPorId(vehiculoId);

            if (vehiculo != null)
            {
                txtModalVehiculoId.Text = vehiculo.vehiculoId.ToString();
                txtModalVehiculoPlaca.Text = vehiculo.placa.ToString();
                txtModalVehiculoMarca.Text = vehiculo.marca.ToString();
                txtModalVehiculoModelo.Text = vehiculo.modelo.ToString();
                txtModalVehiculoColor.Text = vehiculo.color.ToString();
                txtModalVehiculoTipo.Text = vehiculo.tipo.ToString();
            }
            string script = "window.onload = function() { showModalFormVehiculosDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbTaller_Click(object sender, EventArgs e)
        {
            int tallerId = Convert.ToInt32((sender as LinkButton).CommandArgument);

            SiniNetBusiness.SiniNetWSTalleres.talleresDTO taller = this.tallerBO.obtenerPorId(tallerId);

            if (taller != null)
            {
                txtModalTallerId.Text = taller.tallerId.ToString();
                txtModalTallerNombre.Text = taller.nombre;
                txtModalTallerTelefono.Text = taller.telefono;
                txtModalTallerDireccion.Text = taller.ubicacion.direccion;
                txtModalTallerReferencia.Text = taller.ubicacion.referencia;
            }
            string script = $@"
            window.onload = function() {{
                modalVerTaller({taller.ubicacion.latitud}, {taller.ubicacion.longitud});
            }};";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarMapa", script, true);
        }

        protected void lbConductor_Click(object sender, EventArgs e)
        {
            int conductorId = Convert.ToInt32((sender as LinkButton).CommandArgument);

            SiniNetBusiness.SiniNetWSPersonas.personasDTO conductor = this.personaBO.obtenerPorId(conductorId);

            if (conductor != null)
            {
                txtModalConductorId.Text = conductor.personalId.ToString();
                txtModalConductorDNI.Text = conductor.dni.ToString();
                txtModalConductorNombres.Text = conductor.nombres.ToString();
                txtModalConductorApellidoPaterno.Text = conductor.apellidoPaterno.ToString();
                txtModalConductorApellidoMaterno.Text = conductor.apellidoMaterno.ToString();
                txtModalConductorTelefono.Text = conductor.telefono.ToString();
            }
            string script = "window.onload = function() { showModalFormConductoresDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbPolizaVehicular_Click(object sender, EventArgs e)
        {
            int polizaId = Convert.ToInt32((sender as LinkButton).CommandArgument);            

            SiniNetBusiness.SiniNetWSPolizasVehiculares.polizasVehicularesDTO poliza = this.polizaVehicularBO.obtenerPorId(polizaId);
            int aseguradoId = poliza.asegurado.personalId;
            SiniNetBusiness.SiniNetWSPersonas.personasDTO asegurado = this.personaBO.obtenerPorId(aseguradoId);

            if (poliza != null)
            {
                txtModalPolizaVehicularEstado.Text = poliza.estado.ToString();
                txtModalPolizaVehicularTipo.Text = poliza.tipo.ToString();
                txtModalPolizaVehicularPorcentaje.Text = poliza.porcentajeCobertura.ToString();
                txtModalPolizaVehicularId.Text = poliza.polizaId.ToString();
                txtModalPolizaVehicularDNI.Text = asegurado.dni.ToString();
                txtModalPolizaVehicularNombres.Text = asegurado.nombres.ToString();
                txtModalPolizaVehicularApellidoPaterno.Text = asegurado.apellidoPaterno.ToString();
                txtModalPolizaVehicularApellidoMaterno.Text = asegurado.apellidoMaterno.ToString();
                txtModalPolizaVehicularTelefono.Text = asegurado.telefono.ToString();
            }
            string script = "window.onload = function() { showModalFormPolizasVehicularesDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbProcurador_Click(object sender, EventArgs e)
        {
            int procuradorId = Convert.ToInt32((sender as LinkButton).CommandArgument);

            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO procurador = this.empleadoBO.obtenerPorId(procuradorId);

            if (procurador != null)
            {
                txtModalProcuradorId.Text = procurador.personalId.ToString();
                txtModalProcuradorDNI.Text = procurador.dni.ToString();
                txtModalProcuradorNombres.Text = procurador.nombres.ToString();
                txtModalProcuradorApellidoPaterno.Text = procurador.apellidoPaterno.ToString();
                txtModalProcuradorApellidoMaterno.Text = procurador.apellidoMaterno.ToString();
                txtModalProcuradorTelefono.Text = procurador.telefono.ToString();
                txtModalProcuradorCorreo.Text = procurador.correo.ToString();
            }
            string script = "window.onload = function() { showModalFormProcuradoresDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void dgvSiniestroVehicular_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                // Buscamos el LinkButton dentro del ItemTemplate
                LinkButton lbEliminar = (LinkButton)e.Row.FindControl("lbEliminar");

                // Obtenemos el rol del usuario desde la sesión
                string rol = Session["rolUsuario"]?.ToString();

                // Ejemplo: solo los operarios pueden ver el botón
                if (rol == "Procurador")
                {
                    lbEliminar.Visible = false;
                }
            }
        }

        protected void lbVerDescripcion_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.siniestrosVehicularesDTO sini = this.siniestroVehicularBO.obtenerPorId(siniId);

            txtModalDescripcion.Text = sini.descripcion;

            string script = "window.onload = function() { showModalFormDescripcionDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbVerDanos_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestrosVehiculares.siniestrosVehicularesDTO sini = this.siniestroVehicularBO.obtenerPorId(siniId);

            txtModalDanos.Text = sini.danos;

            string script = "window.onload = function() { showModalFormDanosDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }
    }
}