<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="polizasSoat_listado.aspx.cs" Inherits="SiniNetWA.polizasSoat_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Manteniminento de Polizas SOAT
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_polizas.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    
    <div class="container">
        <h2>Mantenimiento de Polizas SOAT</h2>

        <div class="container row">
            <div class="text-end" style="margin-bottom: 20px;">
                <asp:Button ID="btnInsertar" runat="server" CssClass="float-end btn btn-primary" Text="Insertar" OnClick="btnInsertar_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="dgvPolizasSoat" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="polizaId" />
                    <asp:BoundField HeaderText="Estado" DataField="estado" />
                    <asp:BoundField HeaderText="Monto a Cobertura" DataField="montoACobertura" />

                    <asp:TemplateField HeaderText="Asegurado">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerAsegurado" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("asegurado.personalId") %>' OnClick="lbVerAsegurado_Click"></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" ToolTip="Modificar" CommandArgument='<%# Eval("polizaId") %>' OnClick="lbModificar_Click"><i class='fa-solid fa-edit'></i></asp:LinkButton>
                            <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar" CommandArgument='<%# Eval("polizaId") %>' OnClick="lbEliminar_Click" OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class='fa-solid fa-trash'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                </Columns>
            </asp:GridView>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal fade" id="modal-ver-asegurado" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Asegurado</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Id Asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Dni:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoDni" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Teléfono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalAseguradoTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
