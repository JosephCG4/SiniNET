<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="talleresAdmin_listado.aspx.cs" Inherits="SiniNetWA.talleresAdmin_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Talleres
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/ver_mapa.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Mantenimiento de Talleres</h2>

        <div class="container row">
            <div class="text-end" style="margin-bottom: 20px;">
                <asp:Button ID="btnInsertar" runat="server" CssClass="float-end btn btn-primary" Text="Insertar" OnClick="btnInsertar_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="dgvTalleres" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="tallerId" />                    
                    <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                    
                    <asp:TemplateField HeaderText="Ubicación">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerUbicacion" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("tallerId") %>' OnClick="lbVerUbicacion_Click"></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:BoundField HeaderText="Teléfono" DataField="telefono" />

                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" ToolTip="Modificar" CommandArgument='<%# Eval("tallerId") %>' OnClick="lbModificar_Click"><i class='fa-solid fa-edit'></i></asp:LinkButton>
                            <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar" CommandArgument='<%# Eval("tallerId") %>' OnClick="lbEliminar_Click" OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class='fa-solid fa-trash'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                </Columns>
            </asp:GridView>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <!-- Modal Ver Ubicación -->
    <div class="modal fade" id="form-modal-mapa-ver" tabindex="-1" aria-labelledby="modalVerMapaLabel" aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="modalVerMapaLabel">Ubicación del Centro de Salud</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Cerrar"></button>
                </div>

                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container pb-3 pt-3">

                                <!-- Mapa -->
                                <div class="row mb-4 justify-content-center">
                                    <div class="col-sm-10">
                                        <div id="mapViewVer" style="height: 400px; border-radius: 10px; border: 2px solid #d4ad32;"></div>
                                    </div>
                                </div>

                                <!-- Campos de dirección, referencia y coordenadas -->
                                <div class="row mb-3">
                                    <div class="col-sm-6">
                                        <asp:Label ID="lblDireccionVer" runat="server" Text="Dirección:" CssClass="form-label"></asp:Label>
                                        <asp:TextBox ID="txtDireccionVer" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-6">
                                        <asp:Label ID="lblReferenciaVer" runat="server" Text="Referencia:" CssClass="form-label"></asp:Label>
                                        <asp:TextBox ID="txtReferenciaVer" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                                    </div>
                                </div>

                                <div class="row mb-3">
                                    <div class="col-sm-6">
                                        <asp:Label ID="lblLatitudVer" runat="server" Text="Latitud:" CssClass="form-label"></asp:Label>
                                        <asp:TextBox ID="txtLatitudVer" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-6">
                                        <asp:Label ID="lblLongitudVer" runat="server" Text="Longitud:" CssClass="form-label"></asp:Label>
                                        <asp:TextBox ID="txtLongitudVer" runat="server" CssClass="form-control" ReadOnly="true"></asp:TextBox>
                                    </div>
                                </div>

                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>

            </div>
        </div>
    </div>
</asp:Content>
