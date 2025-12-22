<%@ Page Title="Gestión de Siniestro SOAT" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="SiniestrosSoatGestion.aspx.cs" Inherits="SoftAsegWA.SiniestrosSoatGestion" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Siniestro SOAT
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_mapas.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_empleados.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_polizas_soat.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_afectados.js"></script>
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
                        <asp:Label ID="lblSiniestroId" Text ="Id Siniestro:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtIdSiniestro" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblDescripcion" Text="Descripción:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtDescripcion" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblFechaHora" Text="Fecha y Hora:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtFechaHora" TextMode="DateTimeLocal" runat="server" CssClass="form-control" Enabled="true"></asp:TextBox></div>
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
                        <asp:Label ID="lblGastosMedicos" Text="Gastos Médicos:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtGastosMedicos" TextMode="Number" step="0.01" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblDiagnostico" Text="Diagnóstico:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtDiagnostico" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox></div>
                    </div>
                    <hr />
                    <div class="mb-3 row">
                        <asp:Label ID="lblImagenes" Text="Imágenes:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
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
                    <hr />

                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblAfectados" Text="Número de Afectados:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>    
                        <div class="d-flex justify-content-end mt-2">
                            <asp:Button ID="btnAgregarAfectados" CssClass="btn btn-primary" runat="server" Text="Agregar" OnClick="btnAgregarAfectados_Click" />
                        </div>                        
                    </div>

                    <asp:GridView ID="gdvAfectados" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                        <Columns>                            
                            <asp:BoundField HeaderText="Dni" DataField="dni" />
                            <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                            <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                            <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                            <asp:BoundField HeaderText="Telefono" DataField="telefono" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <div class="d-flex justify-content-center gap-2">                                        
                                        <asp:LinkButton ID="lbEliminarAfectado"
                                            runat="server"
                                            CssClass="btn btn-sm btn-danger"
                                            ToolTip="Eliminar"
                                            CommandArgument='<%# Eval("dni") %>'                                            
                                            OnClick="lbEliminarAfectado_Click">
                                            <i class="fa-solid fa-trash"></i>
                                        </asp:LinkButton>
                                    </div>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>

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
                        <asp:Label ID="lblCentroDeSaludId" Text="Centro de Salud Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtCentroSaludId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>                        
                            <asp:Button ID="btnFiltrarCentroSalud" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnFiltrarCentroSalud_Click" />                        
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblCentroDeSaludNombre" Text="Centro de Salud Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtCentroSaludNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblCentroSaludCodigo" Text="Centro de Salud Código RENIPRESS:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtCentroSaludCodigo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <hr />
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblProcuradorId" Text="Procurador Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtProcuradorId" Enabled="false" runat="server" CssClass="form-control" ></asp:TextBox>
                        </div>                        
                            <asp:Button ID="btnFiltrarProcurador" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnFiltrarProcurador_Click" />                        
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
                        <asp:Label ID="lblPolizaSoatId" Text="Poliza SOAT Id:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaSoatId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                        <asp:Button ID="btnFiltrarPolizasSoat" CssClass="btn btn-primary col-sm-3" runat="server" Text="Buscar" OnClick="btnFiltrarPolizasSoat_Click" />
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaSoatAseguradoNombre" Text="Asegurado Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaSoatAseguradoNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaSoatAseguradoApellidoPaterno" Text="Asegurado Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaSoatAseguradoApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                        </div>
                    </div>
                    <div class="mb-3 row align-items-center">
                        <asp:Label ID="lblPolizaSoatMonto" Text="Poliza Monto de Cobertura:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                        <div class="col-sm-5">
                            <asp:TextBox ID="txtPolizaSoatMonto" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
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
    <div class="modal fade" id="modalBuscarCentroSalud" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header"><h5 class="modal-title">Búsqueda de Centros de Salud</h5><button type="button" class="btn-close" data-bs-dismiss="modal"></button></div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="row align-items-center mb-3">
                                <div class="col-auto"><asp:Label Text="Buscar por Nombre:" runat="server" /></div>
                                <div class="col-sm-4"><asp:TextBox CssClass="form-control" ID="txtFiltroCentroSalud" runat="server"></asp:TextBox></div>
                                <div class="col-auto"><asp:LinkButton ID="lbBuscarCentroSalud" runat="server" CssClass="btn btn-info" OnClick="lbBuscarCentroSalud_Click"><i class='fa-solid fa-magnifying-glass'></i> Buscar</asp:LinkButton></div>
                            </div>
                            <asp:GridView ID="dgvBusquedaCentrosSalud" runat="server" AutoGenerateColumns="false" CssClass="table table-hover">
                                <Columns>
                                    <asp:BoundField HeaderText="Id" DataField="centroDeSaludId" />
                                    <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                                    <asp:BoundField HeaderText="Codigo RENIPRESS" DataField="codigoRenipress" />
                                    <asp:TemplateField><ItemTemplate><asp:LinkButton ID="lbSeleccionarCentroSalud" CssClass="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("centroDeSaludId") %>' OnClick="lbSeleccionarCentroSalud_Click"></asp:LinkButton></ItemTemplate></asp:TemplateField>
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
                            <asp:HiddenField ID="hfProcuradorId" runat="server" />
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

    <div class="modal" id="form-modal-filtrar-poliza-soat">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Polizas Soat</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center mb-4">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar Nombre o Apellido Paterno del Asegurado:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalFiltroPolizaSoat_txtFiltroPolizaSoat" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalFiltroPolizaSoat_lbBuscarPolizaSoat" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalFiltroPolizaSoat_lbBuscarPolizaSoat_Click"></asp:LinkButton>
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="ModalFiltroPolizaSoat_gvPolizaSoat" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="polizaId" />
                                            <asp:BoundField HeaderText="Asegurado Nombres" DataField="asegurado.nombres" />
                                            <asp:BoundField HeaderText="Asegurado Apellido Paterno" DataField="asegurado.apellidoPaterno" />
                                            <asp:BoundField HeaderText="Apellido Materno" DataField="asegurado.apellidoMaterno" />
                                            <asp:BoundField HeaderText="Estado de la Poliza" DataField="estado" />
                                            <asp:BoundField HeaderText="Monto Cobertura" DataField="montoACobertura" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalFiltroPolizaSoat_lbSeleccionar" class="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("polizaId") %>' OnClick="ModalFiltroPolizaSoat_lbSeleccionar_Click"></asp:LinkButton>
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

    <div class="modal" id="form-modal-agregar-afectados">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Agregar Afectados</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="container row">
                                    <div class="card">
                                        <div class="card-header">
                                            <h2>
                                                <asp:Label ID="lblSubtituloCard" runat="server" Text="Afectado"></asp:Label>
                                            </h2>
                                        </div>
                                        <div class="card-body">
                                            <div class="mb-3 row">
                                                <asp:Label ID="lblModalDniAfectado" Text="Dni :" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                                                <div class="col-sm-5">
                                                    <asp:TextBox ID="txtModalDniAfectado" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                                                </div>
                                            </div>

                                            <div class="mb-3 row">
                                                <asp:Label ID="lblModalNombresAfectado" Text="Nombres :" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                                                <div class="col-sm-5">
                                                    <asp:TextBox ID="txtModalNombresAfectado" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                                                </div>
                                            </div>

                                            <div class="mb-3 row">
                                                <asp:Label ID="lblModalApellidoPaternoAfectado" Text="Apellido Paterno:" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                                                <div class="col-sm-5">
                                                    <asp:TextBox ID="txtModalApellidoPaternoAfectado" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                                                </div>
                                            </div>

                                            <div class="mb-3 row">
                                                <asp:Label ID="lblModalApellidoMaternoAfectado" Text="Apellido Materno :" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                                                <div class="col-sm-5">
                                                    <asp:TextBox ID="txtModalApellidoMaternoAfectado" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                                                </div>
                                            </div>

                                            <div class="mb-3 row">
                                                <asp:Label ID="lblModalTelefonoAfectado" Text="Teléfono :" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                                                <div class="col-sm-5">
                                                    <asp:TextBox ID="txtModalTelefonoAfectado" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="card-footer">                                            
                                            <asp:LinkButton ID="lbModalAgregarAfectado" runat="server" CssClass="float-end btn btn-primary" Text="Agregar" OnClick="lbModalAgregarAfectado_Click"></asp:LinkButton>
                                        </div>
                                    </div>
                                </div>                                
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

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
</asp:Content>