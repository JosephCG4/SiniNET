<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="polizasSoat_gestion.aspx.cs" Inherits="SiniNetWA.polizasSoat_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Polizas SOAT
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_asegurados.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
   
    <div class="card">
        <div class="card-header">
            <h2>
                <asp:Label ID="lblSubtitulo" runat="server" Text=""></asp:Label>
            </h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblId" runat="server" Text="Id: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblAseguradoId" Text="Asegurado Id:" CssClass="col-sm-4 col-form-label" runat="server"></asp:Label>
                <div class="col-sm-3">
                    <asp:TextBox ID="txtAseguradoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
                <asp:Button ID="btnFiltrarAsegurados" CssClass="btn btn-primary col-sm-1" runat="server" Text="Buscar" OnClick="btnFiltrarAsegurados_Click" />
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblAseguradoDni" runat="server" Text="Asegurado Dni:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtAseguradoDni" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblAseguradoNombres" runat="server" Text="Asegurado Nombres:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtAseguradoNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblAseguradoApellidoPaterno" runat="server" Text="Asegurado Apellido Paterno:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtAseguradoApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblAseguradoApellidoMaterno" runat="server" Text="Asegurado Apellido Materno:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtAseguradoApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Estado:</label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-select">
                        <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                        <asp:ListItem Text="Vigente" Value="VIGENTE"></asp:ListItem>
                        <asp:ListItem Text="Vencido" Value="VENCIDO"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblMonto" runat="server" Text="Monto de Cobertura: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtMonto" TextMode="Number" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal" id="form-modal-filtro-asegurado">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Asegurados</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" arial-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center mb-4">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar Nombre o Apellido Paterno:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="txtModalFiltroAsegurado" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="lbBuscarAsegurado" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="lbBuscarAsegurado_Click"></asp:LinkButton>
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="gdvModalAsegurados" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="personalId" />
                                            <asp:BoundField HeaderText="Dni" DataField="dni" />
                                            <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                                            <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                                            <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="lbModalSeleccionarAsegurado" class="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("personalId") %>' OnClick="lbModalSeleccionarAsegurado_Click"></asp:LinkButton>
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
