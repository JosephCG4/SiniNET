<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="vehiculosAdmin_listado.aspx.cs" Inherits="SiniNetWA.vehiculosAdmin_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Vehiculos
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
    <h2>Mantenimiento de Vehiculos</h2>

        <div class="container row">
            <div class="text-end" style="margin-bottom: 20px;">
                <asp:Button ID="btnInsertar" runat="server" CssClass="float-end btn btn-primary" Text="Insertar" OnClick="btnInsertar_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="dgvVehiculo" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="vehiculoId" />
                    <asp:BoundField HeaderText="Placa" DataField="placa" />
                    <asp:BoundField HeaderText="Marca" DataField="marca" />
                    <asp:BoundField HeaderText="Modelo" DataField="modelo" />
                    <asp:BoundField HeaderText="Color" DataField="color" />
                    <asp:BoundField HeaderText="Tipo" DataField="tipo" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" ToolTip="Modificar" CommandArgument='<%# Eval("vehiculoId") %>' OnClick="lbModificar_Click"><i class='fa-solid fa-edit'></i></asp:LinkButton>
                            <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar" CommandArgument='<%# Eval("vehiculoId") %>' OnClick="lbEliminar_Click" OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class='fa-solid fa-trash'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                </Columns>
            </asp:GridView>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>
</asp:Content>
