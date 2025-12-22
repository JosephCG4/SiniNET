using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSEmpleados;
using SiniNetBusiness.SiniNetWSSiniestrosSOAT;
using SiniNetBusiness.SiniNetWSTalleres;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml.Linq;

namespace SoftAsegWA
{
    public partial class SiniestrosSoatListado : System.Web.UI.Page
    {
        private SiniestroSOATBO siniestroSoatBO;
        private IList<SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO> listaSiniestros;
        private EmpleadoBO empleadoBO;
        private CentroDeSaludBO centroDeSaludBO;
        private PolizaSOATBO polizaSOATBO;
        private PersonaBO personaBO;
        private ImagenSiniestroBO imagenBO;

        public SiniestrosSoatListado()
        {
            this.siniestroSoatBO = new SiniestroSOATBO();
            this.empleadoBO = new EmpleadoBO();
            this.centroDeSaludBO = new CentroDeSaludBO();
            this.polizaSOATBO = new PolizaSOATBO();
            this.personaBO = new PersonaBO();
            this.imagenBO = new ImagenSiniestroBO();
            this.listaSiniestros = this.siniestroSoatBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                AplicarSeguridadPorRol();                
            }

            string rol = Session["rolUsuario"].ToString();
            if (rol == "Procurador")
            {
                int procuradorId = Convert.ToInt32(Session["procuradorId"].ToString());
                this.listaSiniestros = this.siniestroSoatBO.listarPorProcuradorSiniestrosSOAT(procuradorId);
                dgvSiniestros.Columns[13].Visible = false;
            }
            dgvSiniestros.DataSource = listaSiniestros;
            dgvSiniestros.DataBind();

        }

        protected void lbVerImagenes_Click(object sender, EventArgs e)
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
            ScriptManager.RegisterStartupScript(this, this.GetType(), "PopImagenes",
                "new bootstrap.Modal(document.getElementById('modalVerImagenes')).show();", true);
        }
        private void AplicarSeguridadPorRol()
        {
            string rol = (Session["rolUsuario"] as string ?? "").Trim();
            if (rol.Equals("Procurador", StringComparison.OrdinalIgnoreCase))
            {
                btnInsertar.Visible = false;
            }
        }

        protected void dgvSiniestros_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                string rol = (Session["rolUsuario"] as string ?? "").Trim();
                if (rol.Equals("Procurador", StringComparison.OrdinalIgnoreCase))
                {
                    LinkButton lbEliminar = (LinkButton)e.Row.FindControl("lbEliminar");
                    if (lbEliminar != null) lbEliminar.Visible = false;
                }
            }
        }

        // --- MANEJADORES DE EVENTOS ---

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SiniestrosSoatGestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32((sender as LinkButton).CommandArgument);
            Session["SiniestroId"] = id;
            Response.Redirect("SiniestrosSoatGestion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int id = Convert.ToInt32((sender as LinkButton).CommandArgument);
            this.siniestroSoatBO.eliminar(id);
            Response.Redirect("SiniestrosSoatListado.aspx");
        }

        protected void lbVerProcurador_Click(object sender, EventArgs e)
        {
            int procuradorId = Convert.ToInt32((sender as LinkButton).CommandArgument);

            SiniNetBusiness.SiniNetWSEmpleados.empleadosDTO procurador = this.empleadoBO.obtenerPorId(procuradorId);

            txtModalProcuradorId.Text = procurador.personalId.ToString();
            txtModalProcuradorDni.Text = procurador.dni.ToString();
            txtModalProcuradorNombres.Text = procurador.nombres;
            txtModalProcuradorApellidoPaterno.Text = procurador.apellidoPaterno;
            txtModalProcuradorApellidoMaterno.Text = procurador.apellidoMaterno;
            txtModalProcuradorTelefono.Text = procurador.telefono;
            txtModalProcuradorDesempeno.Text = procurador.desempenio.ToString();

            ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "new bootstrap.Modal(document.getElementById('modalVerProcurador')).show();", true);
        }

        protected void lbVerUbicacion_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO sini = this.siniestroSoatBO.obtenerPorId(siniId);

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
        

        protected void lbVerPolizaSOAT_Click(object sender, EventArgs e)
        {
            int polizaSOATId = Convert.ToInt32((sender as LinkButton).CommandArgument);


            SiniNetBusiness.SiniNetWSPolizasSOAT.polizasSOATDTO polizaSOAT = this.polizaSOATBO.obtenerPorId(polizaSOATId);
            SiniNetBusiness.SiniNetWSPersonas.personasDTO asegurado = this.personaBO.obtenerPorId(polizaSOAT.asegurado.personalId);

            txtModalPolizaSOATId.Text = polizaSOAT.polizaId.ToString();
            txtModalPolizaSOATEstado.Text = polizaSOAT.estado.ToString();
            txtModalPolizaSOATMontoCobertura.Text = polizaSOAT.montoACobertura.ToString();
            txtModalPolizaSOATDniAsegurado.Text = asegurado.dni.ToString();
            txtModalPolizaSOATNombreAsegurado.Text =asegurado.nombres;
            txtModalPolizaSOATApellidoPaternoAsegurado.Text = asegurado.apellidoPaterno;
            txtModalPolizaSOATApellidoMaternoAsegurado.Text = asegurado.apellidoMaterno;
            txtModalPolizaSOATTelefono.Text = asegurado.telefono;

            ScriptManager.RegisterStartupScript(this, this.GetType(), "Pop", "new bootstrap.Modal(document.getElementById('modalVerPolizaSOAT')).show();", true);
        }

        protected void lbVerCentroDeSalud_Click(object sender, EventArgs e)
        {
            int centroDeSaludId = Convert.ToInt32((sender as LinkButton).CommandArgument);


            SiniNetBusiness.SiniNetWSCentrosDeSalud.centrosDeSaludDTO centroDeSalud = this.centroDeSaludBO.obtenerPorId(centroDeSaludId);

            txtModalCentroDeSaludId.Text = centroDeSalud.centroDeSaludId.ToString();
            txtModalCentroDeSaludNombre.Text = centroDeSalud.nombre;
            txtModalCentroDeSaludCodRENIPRESS.Text = centroDeSalud.codigoRenipress;
            txtModalCentroDeSaludTelefono.Text = centroDeSalud.telefono;
            txtModalCentroDeSaludDireccion.Text = centroDeSalud.ubicacion.direccion;
            txtModalCentroDeSaludReferencia.Text = centroDeSalud.ubicacion.referencia;

            string script = $@"
            window.onload = function() {{
                modalVerCentroSalud({centroDeSalud.ubicacion.latitud}, {centroDeSalud.ubicacion.longitud});
            }};";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarMapa", script, true);
        }

        protected void lbVerAfectados_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);

            IList<SiniNetBusiness.SiniNetWSPersonas.personasDTO> listaAfectados = this.personaBO.listarAseguradosPorSiniestro(siniId);

            gdvModalAfectados.DataSource = listaAfectados;
            gdvModalAfectados.DataBind();

            string script = "window.onload = function() { showModalFormAfectados() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbVerDescripcion_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO sini = this.siniestroSoatBO.obtenerPorId(siniId);

            txtModalDescripcion.Text = sini.descripcion;

            string script = "window.onload = function() { showModalFormDescripcionDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void lbVerDiagnostico_Click(object sender, EventArgs e)
        {
            int siniId = Int32.Parse((sender as LinkButton).CommandArgument);
            SiniNetBusiness.SiniNetWSSiniestrosSOAT.siniestrosSOATDTO sini = this.siniestroSoatBO.obtenerPorId(siniId);

            txtModalDiagnostico.Text = sini.diagnostico;

            string script = "window.onload = function() { showModalFormDiagnosticoDetalles() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }
    }
}