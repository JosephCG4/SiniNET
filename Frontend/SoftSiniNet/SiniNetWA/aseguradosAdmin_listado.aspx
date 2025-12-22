<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="aseguradosAdmin_listado.aspx.cs" Inherits="SiniNetWA.aseguradosAdmin_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Asegurados
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
    <h2>Mantenimiento de Asegurados</h2>

        <div class="container row">
            <div class="text-end" style="margin-bottom: 20px;">
                <asp:Button ID="btnInsertar" runat="server" CssClass="float-end btn btn-primary" Text="Insertar" OnClick="btnInsertar_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="dgvAsegurado" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="personalId" />
                    <asp:BoundField HeaderText="Dni" DataField="dni" />
                    <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                    <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                    <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                    <asp:BoundField HeaderText="Telefono" DataField="telefono" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" ToolTip="Modificar" CommandArgument='<%# Eval("personalId") %>' OnClick="lbModificar_Click"><i class='fa-solid fa-edit'></i></asp:LinkButton>
                            <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar" CommandArgument='<%# Eval("personalId") %>' OnClick="lbEliminar_Click" OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class='fa-solid fa-trash'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>
</asp:Content>
