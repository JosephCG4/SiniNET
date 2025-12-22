<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="reportesOperario.aspx.cs" Inherits="SiniNetWA.reportesOperario" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reportes de Siniestros
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_siniestros.js"></script>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card">
        <div class="card-header">
            <h2>Generar Reporte de Siniestro</h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblSiniestroId" runat="server" Text="Siniestro ID:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtSiniestroId" runat="server" Enabled="false" TextMode="Number" CssClass="form-control"></asp:TextBox>
                </div>
                <asp:Button ID="btnFiltrarSiniestros" CssClass="btn btn-primary col-sm-1" runat="server" Text="Buscar" OnClick="btnFiltrarSiniestros_Click" />
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblFechaHora" runat="server" Text="Fecha y hora:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtFechaHora" runat="server" TextMode="DateTimeLocal" Enabled="false" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblDescripcion" runat="server" Text="Descripción:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtDescripcion" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblCalificacion" runat="server" Text="Calificación:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtCalificacion" runat="server" TextMode="Number" Enabled="false" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click"/>
            <asp:Button ID="btnGenerar" runat="server" CssClass="float-end btn btn-primary" Text="Generar" OnClick="btnGenerar_Click" />
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal" id="form-modal-filtro-siniestro">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Siniestros</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-md-4">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar Nombre o Apellido del procurador:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="ModalFiltroSiniestro_txtNombreApellido" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalFiltroSiniestro_lbBuscarSiniestro" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalFiltroSiniestro_lbBuscarSiniestro_Click"></asp:LinkButton>
                                    </div>
                                </div>                     
                                <div class="container row">
                                    <asp:GridView ID="ModalFiltroSiniestro_gvSiniestro" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="siniestroId"/>
                                            <asp:BoundField HeaderText="Descripción" DataField="descripcion"/>
                                            <asp:BoundField HeaderText="Fecha y Hora" DataField="fechaHora"/>
                                            <asp:BoundField HeaderText="Estado" DataField="estado"/>
                                            <asp:BoundField HeaderText="Calificacion" DataField="calificacionServicio"/>
                                            <asp:BoundField HeaderText="Validez" DataField="validez"/>
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalFiltroSiniestro_lbSeleccionar" class="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("siniestroId") %>' OnClick="ModalFiltroSiniestro_lbSeleccionar_Click"></asp:LinkButton>
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

</asp:Content>