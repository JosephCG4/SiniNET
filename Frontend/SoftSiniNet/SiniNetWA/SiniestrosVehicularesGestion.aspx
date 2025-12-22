<%@ Page Title="Gestión de Siniestro Vehicular" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="SiniestrosVehicularesGestion.aspx.cs" Inherits="SoftAsegWA.SiniestrosVehicularesGestion" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Siniestro Vehicular
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_mapas.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_empleados.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_polizas_vehiculares.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_personas.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_vehiculos.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <%-- El ScriptManager DEBE ir al principio para los UpdatePanels --%>
    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="card">
        <div class="card-header">
            <h2><asp:Label ID="lblSubtitulo" runat="server"></asp:Label></h2>
        </div>
        <div class="card-body">
            <div class="row">
                <%-- ================= COLUMNA IZQUIERDA ================= --%>
                <div class="col-md-6">
                    <div class="mb-3 row">
                        <asp:Label Text="Id Siniestro:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8"><asp:TextBox ID="txtIdSiniestro" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label Text="Descripción:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8"><asp:TextBox ID="txtDescripcion" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label Text="Fecha y Hora:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8"><asp:TextBox ID="txtFechaHora" TextMode="DateTimeLocal" runat="server" CssClass="form-control" Enabled="true"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblEstado" Text="Estado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-select"> 
                                <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                                <asp:ListItem Value="EN_PROCESO">En Proceso</asp:ListItem>
                                <asp:ListItem Value="CANCELADO">Cancelado</asp:ListItem>
                                <asp:ListItem Value="FINALIZADO">Finalizado</asp:ListItem>
                            </asp:DropDownList>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblCalificacion" Text="Calificación:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtCalificacion" TextMode="Number" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblValidez" Text="Validez:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlValidez" runat="server" CssClass="form-select">
                                <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                                <asp:ListItem Value="VALIDO">Válido</asp:ListItem>
                                <asp:ListItem Value="INVALIDO">Inválido</asp:ListItem>
                            </asp:DropDownList>
                        </div>
                    </div>
                    <hr />
                    <div class="mb-3 row">
                        <asp:Label Text="Costo estimado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtCostoEstimado" TextMode="Number" step="0.01" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="Label10" Text="Tipo de daño:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlTipoDano" runat="server" CssClass="form-select"> 
                                <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                                <asp:ListItem Value="LEVE">LEVE</asp:ListItem>
                                <asp:ListItem Value="MEDIANO">MEDIANO</asp:ListItem>
                                <asp:ListItem Value="FUERTE">FUERTE</asp:ListItem>
                            </asp:DropDownList>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label Text="Daños:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtDanos" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <hr />
                    <div class="mb-3 row">
                        <asp:Label Id="lblImagenes" Text="Imágenes:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:FileUpload ID="fuImagenes" runat="server" CssClass="form-control" AllowMultiple="true" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <div class="col-sm-8 offset-sm-4">
                            <asp:Button ID="btnSubirImagenes" runat="server"
                                CssClass="btn btn-success btn-sm me-2"
                                Text="Subir Imágenes"
                                OnClick="btnSubirImagenes_Click" />
                            <asp:Button ID="btnVerImagenes" runat="server"
                                CssClass="btn btn-info btn-sm"
                                Text="Ver Imágenes Existentes"
                                OnClick="btnVerImagenes_Click"
                                Visible="false" />
                        </div>
                    </div>
                    <%-- Modal para gestionar imágenes --%>
                    <div class="modal fade" id="modalGestionImagenes" tabindex="-1">
                        <div class="modal-dialog modal-xl">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Gestionar Imágenes del Siniestro</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <asp:UpdatePanel runat="server">
                                        <ContentTemplate>
                                            <asp:Repeater ID="rptImagenesGestion" runat="server">
                                                <ItemTemplate>
                                                    <div class="mb-4 text-center border rounded p-3">
                                                        <img src='<%# Eval("url") %>'
                                                            class="img-fluid rounded"
                                                            alt='<%# Eval("nombreArchivo") %>'
                                                            style="max-height: 500px; max-width: 100%;" />
                                                        <p class="text-muted mt-2 mb-2">
                                                            <small><%# Eval("nombreArchivo") %></small>
                                                        </p>
                                                        <asp:LinkButton ID="lbEliminarImagen" runat="server"
                                                            CssClass="btn btn-danger btn-sm"
                                                            CommandArgument='<%# Eval("imagenId") %>'
                                                            OnClick="lbEliminarImagen_Click"
                                                            OnClientClick="return confirm('¿Está seguro de eliminar esta imagen?');">
                        <i class="fa-solid fa-trash"></i> Eliminar
                                                        </asp:LinkButton>
                                                    </div>
                                                </ItemTemplate>
                                            </asp:Repeater>
                                            <asp:Label ID="lblNoImagenesGestion" runat="server"
                                                Text="No hay imágenes registradas para este siniestro."
                                                CssClass="text-muted text-center d-block p-4"
                                                Visible="false">
                                            </asp:Label>
                                        </ContentTemplate>
                                    </asp:UpdatePanel>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-- Modal para mensajes sin fondo gris --%>
                    <div class="modal fade" id="modalMensaje" tabindex="-1" data-bs-backdrop="false">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-body text-center py-4">
                                    <p id="mensajeTexto" class="mb-0"></p>
                                </div>
                                <div class="modal-footer justify-content-center">
                                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Aceptar</button>
                                </div>
                            </div>
                        </div>
                    </div>                
                    <hr />
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label1" Text="Conductor Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorId" Enabled="false" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>                                                    
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label11" Text="Conductor Dni:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorDni" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label2" Text="Conductor Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorNombres" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label3" Text="Conductor Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorApellidoPaterno" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label4" Text="Conductor Apellido Materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorApellidoMaterno" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label12" Text="Conductor Teléfono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtConductorTelefono" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <hr />
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblTallerId" Text="Taller Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtTallerId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                        <asp:Button ID="btnBuscarTaller" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnBuscarTaller_Click" />
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblTallerNombre" Text="Taller Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtTallerNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>

                </div>

                <%-- ================= COLUMNA DERECHA ================= --%>
                <div class="col-md-6">    
                    <div class="mb-3 row">
                        <asp:Label ID="lblDireccion" runat="server" Text="Dirección: " CssClass="col-sm-4 col-form-label fw-bold"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtDireccion" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblReferencia" runat="server" Text="Referencia: " CssClass="col-sm-4 col-form-label fw-bold"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtReferencia" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblMapa" runat="server" Text="Mapa Id:" CssClass="col-sm-4 col-form-label fw-bold"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtUbicacionId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                        <asp:Button ID="btnAbrirMapa" CssClass="btn btn-primary col-sm-3" runat="server" Text="Abrir" OnClick="btnAbrirMapa_Click" />
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblLatitudForm" runat="server" Text="Latitud: " CssClass="col-sm-4 col-form-label fw-bold"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtLatitudForm" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblLongitudForm" runat="server" Text="Longitud: " CssClass="col-sm-4 col-form-label fw-bold"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtLongitudForm" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>                    
                    <hr />
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblProcuradorId" Text="Procurador Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtProcuradorId" Enabled="false" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>                        
                            <asp:Button ID="btnBuscarProcurador" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnBuscarProcurador_Click" />                        
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblProcuradorNombre" Text="Procurador Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtProcuradorNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblProcuradorApellidoPaterno" Text="Procurador Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtProcuradorApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblProcuradorApellidoMaterno" Text="Procurador Apellido Materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtProcuradorApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>

                    <hr />
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaVehicularId" Text="Poliza Vehicular Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaVehicularId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                        <asp:Button ID="btnFiltrarPolizasVehiculares" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnFiltrarPolizasVehiculares_Click" />
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaVehicularAseguradoNombre" Text="Asegurado Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaVehicularAseguradoNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaVehicularAseguradoApellidoPaterno" Text="Asegurado Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaVehicularAseguradoApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaVehicularPorcentaje" Text="Poliza Porcentaje de cobertura:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaVehicularPorcentaje" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <hr />

                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label5" Text="Vehiculo Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtVehiculoId" Enabled="false" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>                        
                            <asp:Button ID="btnBuscarVehiculo" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnBuscarVehiculo_Click" />                        
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label6" Text="Vehiculo Placa:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtVehiculoPlaca" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label7" Text="Vehiculo Marca:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtVehiculoMarca" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label8" Text="Vehiculo Modelo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtVehiculoModelo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="Label9" Text="Vehiculo Tipo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtVehiculoTipo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="card-footer">                       
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>
    
    <%-- =================== MODALES DE BÚSQUEDA =================== --%>
    <div class="modal fade" id="modalBuscarTaller" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header"><h5 class="modal-title">Búsqueda de Talleres</h5><button type="button" class="btn-close" data-bs-dismiss="modal"></button></div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="row align-items-center mb-3">
                                <div class="col-auto"><asp:Label Text="Buscar por Nombre:" runat="server" /></div>
                                <div class="col-sm-4"><asp:TextBox CssClass="form-control" ID="txtFiltroTaller" runat="server"></asp:TextBox></div>
                                <div class="col-auto"><asp:LinkButton ID="lbBuscarTaller" runat="server" CssClass="btn btn-info" OnClick="lbBuscarTaller_Click"><i class='fa-solid fa-magnifying-glass'></i> Buscar</asp:LinkButton></div>
                            </div>
                            <asp:GridView ID="dgvBusquedaTalleres" runat="server" AutoGenerateColumns="false" CssClass="table table-hover">
                                <Columns>
                                    <asp:BoundField HeaderText="Id" DataField="tallerId" />
                                    <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                                    <asp:TemplateField><ItemTemplate><asp:LinkButton ID="lbSeleccionarTaller" CssClass="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("tallerId") %>' OnClick="lbSeleccionarTaller_Click"></asp:LinkButton></ItemTemplate></asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalBuscarProcurador" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header"><h5 class="modal-title">Búsqueda de Procuradores</h5><button type="button" class="btn-close" data-bs-dismiss="modal"></button></div>
                <div class="modal-body">
                     <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="row align-items-center mb-3">
                                <div class="col-auto"><asp:Label Text="Buscar por Nombre o Apellido:" runat="server" /></div>
                                <div class="col-sm-4"><asp:TextBox CssClass="form-control" ID="txtFiltroProcurador" runat="server"></asp:TextBox></div>
                                <div class="col-auto"><asp:LinkButton ID="lbBuscarProcurador" runat="server" CssClass="btn btn-info" OnClick="lbBuscarProcurador_Click"><i class='fa-solid fa-magnifying-glass'></i> Buscar</asp:LinkButton></div>
                            </div>
                            <asp:GridView ID="dgvBusquedaProcuradores" runat="server" AutoGenerateColumns="false" CssClass="table table-hover">
                                <Columns>
                                    <asp:BoundField HeaderText="Id" DataField="personalId" /> 
                                    <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                                    <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                                    <asp:BoundField HeaderText="Tipo" DataField="tipo" />
                                    <asp:TemplateField><ItemTemplate><asp:LinkButton ID="lbSeleccionarProcurador" CssClass="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("personalId") %>' OnClick="lbSeleccionarProcurador_Click"></asp:LinkButton></ItemTemplate></asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <div class="modal" id="form-modal-mapa">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Mapa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingrese la ubicación moviendo el pin:"></asp:Label>
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="col-sm-8">
                                        <div id="map" style="height: 400px; border-radius: 10px; border: 2px solid #d4ad32;"></div>
                                        <br />
                                        <div class="mb-3 row">
                                            <asp:Label ID="lblLatitud" runat="server" Text="Latitud: " CssClass="col-sm-4 col-form-label"></asp:Label>
                                            <div class="col-sm-4">
                                                <asp:TextBox ID="txtLatitud" runat="server" CssClass="form-control" Enabled="false" ClientIDMode="Static"></asp:TextBox>
                                            </div>
                                        </div>
                                        <div class="mb-3 row">
                                            <asp:Label ID="lblLongitud" runat="server" Text="Longitud: " CssClass="col-sm-4 col-form-label"></asp:Label>
                                            <div class="col-sm-4">
                                                <asp:TextBox ID="txtLongitud" runat="server" CssClass="form-control" Enabled="false" ClientIDMode="Static"></asp:TextBox>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="d-flex justify-content-end mt-3">
                                    <asp:LinkButton ID="ModalVerMapa_lbConfirmar" runat="server" CssClass="btn btn-primary"
                                        Text="Confirmar" OnClick="ModalVerMapa_lbConfirmar_Click"></asp:LinkButton>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <div class="modal" id="modalVerPolizaVehicular">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Polizas Vehiculares</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center mb-4">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar Nombre o Apellidos del Asegurado:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalFiltroPolizaVehicular_txtFiltroPolizaVehicular" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalFiltroPolizaVehicular_lbBuscarPolizaVehicular" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalFiltroPolizaVehicular_lbBuscarPolizaVehicular_Click"></asp:LinkButton>
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="ModalFiltroPolizaVehicular_gvPolizaVehicular" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="polizaId" />
                                            <asp:BoundField HeaderText="Asegurado Nombres" DataField="asegurado.nombres" />
                                            <asp:BoundField HeaderText="Asegurado Apellido Paterno" DataField="asegurado.apellidoPaterno" />
                                            <asp:BoundField HeaderText="Asegurado Apellido Materno" DataField="asegurado.apellidoMaterno" />
                                            <asp:BoundField HeaderText="Estado de la Poliza" DataField="estado" />
                                            <asp:BoundField HeaderText="Tipo de la Poliza" DataField="tipo" />
                                            <asp:BoundField HeaderText="Porcentaje de Cobertura" DataField="porcentajeCobertura" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalFiltroPolizaVehicular_lbSeleccionar" class="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("polizaId") %>' OnClick="ModalFiltroPolizaVehicular_lbSeleccionar_Click"></asp:LinkButton>
                                                </ItemTemplate>
                                            </asp:TemplateField>
                                        </Columns>
                                    </asp:GridView>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalVerConductor" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header"><h5 class="modal-title">Búsqueda de Conductores</h5><button type="button" class="btn-close" data-bs-dismiss="modal"></button></div>
                <div class="modal-body">
                     <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="row align-items-center mb-3">
                                <div class="col-auto"><asp:Label Text="Buscar por Nombre o Apellido:" runat="server" /></div>
                                <div class="col-sm-4"><asp:TextBox CssClass="form-control" ID="txtFiltroConductor" runat="server"></asp:TextBox></div>
                                <div class="col-auto"><asp:LinkButton ID="lbBuscarConductor" runat="server" CssClass="btn btn-info" OnClick="lbBuscarConductor_Click"><i class='fa-solid fa-magnifying-glass'></i> Buscar</asp:LinkButton></div>
                            </div>
                            <asp:GridView ID="gvConductor" runat="server" AutoGenerateColumns="false" CssClass="table table-hover">
                                <Columns>
                                    <asp:BoundField HeaderText="id" DataField="personalId" /> 
                                    <asp:BoundField HeaderText="Dni" DataField="dni" /> 
                                    <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                                    <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                                    <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                                    <asp:TemplateField><ItemTemplate><asp:LinkButton ID="lbSeleccionarConductor" CssClass="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("personalId") %>' OnClick="lbSeleccionarConductor_Click"></asp:LinkButton></ItemTemplate></asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalVerVehiculo" tabindex="-1">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header"><h5 class="modal-title">Búsqueda de Vehículos</h5><button type="button" class="btn-close" data-bs-dismiss="modal"></button></div>
            <div class="modal-body">
                 <asp:UpdatePanel runat="server">
                    <ContentTemplate>
                        <div class="row align-items-center mb-3">
                            <div class="col-auto"><asp:Label Text="Buscar por placa, marca, modelo o tipo:" runat="server" /></div>
                            <div class="col-sm-4"><asp:TextBox CssClass="form-control" ID="txtFiltroVehiculo" runat="server"></asp:TextBox></div>
                            <div class="col-auto"><asp:LinkButton ID="lbBuscarVehiculo" runat="server" CssClass="btn btn-info" OnClick="lbBuscarVehiculo_Click"><i class='fa-solid fa-magnifying-glass'></i> Buscar</asp:LinkButton></div>
                        </div>
                        <asp:GridView ID="gvVehiculo" runat="server" AutoGenerateColumns="false" CssClass="table table-hover">
                            <Columns>
                                <asp:BoundField HeaderText="Id" DataField="vehiculoId" /> 
                                <asp:BoundField HeaderText="Placa" DataField="placa" />
                                <asp:BoundField HeaderText="Marca" DataField="marca" />
                                <asp:BoundField HeaderText="Modelo" DataField="modelo" />
                                <asp:BoundField HeaderText="Tipo" DataField="tipo" />
                                <asp:TemplateField><ItemTemplate><asp:LinkButton ID="lbSeleccionarVehiculo" CssClass="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("vehiculoId") %>' OnClick="lbSeleccionarVehicul_Click"></asp:LinkButton></ItemTemplate></asp:TemplateField>
                            </Columns>
                        </asp:GridView>
                    </ContentTemplate>
                </asp:UpdatePanel>
            </div>
        </div>
    </div>
</div>
    <%--<script type="text/javascript">
        document.addEventListener("DOMContentLoaded", function () {

            const campos = [
            '<%= txtDescripcion.ClientID %>',
            '<%= txtFechaHora.ClientID %>',
            '<%= ddlEstado.ClientID %>',
            '<%= txtDanosEstimados.ClientID %>',
            '<%= txtUbicacion.ClientID %>',
            '<%= txtVehiculo.ClientID %>',
            '<%= txtProcurador.ClientID %>'
        ];

        const btnGuardar = document.getElementById('<%= btnGuardar.ClientID %>');

        function verificarCampos() {
            let todosLlenos = true;

            campos.forEach(id => {
                const el = document.getElementById(id);
                if (el) {
                    if (el.tagName === "INPUT" || el.tagName === "TEXTAREA" || el.tagName === "SELECT") {
                        if (el.value.trim() === "") todosLlenos = false;
                    }
                }
            });

            btnGuardar.disabled = !todosLlenos;
        }

        campos.forEach(id => {
            const el = document.getElementById(id);
            if (el) {
                el.addEventListener("input", verificarCampos);
                el.addEventListener("change", verificarCampos);
            }
        });

        verificarCampos(); // revisión inicial
    });
    </script>
        <div class="modal fade" id="modalGestionImagenes" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Gestionar Imágenes del Siniestro</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <asp:Repeater ID="rptImagenesGestion" runat="server">
                                <ItemTemplate>
                                    <div class="mb-4 text-center border rounded p-3">
                                        <img src='<%# Eval("url") %>' 
                                             class="img-fluid rounded" 
                                             alt='<%# Eval("nombreArchivo") %>' 
                                             style="max-height: 500px; max-width: 100%;" />
                                        <p class="text-muted mt-2 mb-2">
                                            <small><%# Eval("nombreArchivo") %></small>
                                        </p>
                                        <asp:LinkButton ID="lbEliminarImagen" runat="server" 
                                            CssClass="btn btn-danger btn-sm" 
                                            CommandArgument='<%# Eval("imagenId") %>'
                                            OnClick="lbEliminarImagen_Click"
                                            OnClientClick="return confirm('¿Está seguro de eliminar esta imagen?');">
                                            <i class="fa-solid fa-trash"></i> Eliminar
                                        </asp:LinkButton>
                                    </div>
                                </ItemTemplate>
                            </asp:Repeater>
                            <asp:Label ID="lblNoImagenesGestion" runat="server" Text="No hay imágenes para este siniestro." 
                                CssClass="text-muted" Visible="false"></asp:Label>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>--%>

</asp:Content>
