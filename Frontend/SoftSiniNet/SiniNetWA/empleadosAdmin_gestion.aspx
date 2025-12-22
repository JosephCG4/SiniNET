<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="empleadosAdmin_gestion.aspx.cs" Inherits="SiniNetWA.empleadosAdmin_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Empleados
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
                    <asp:TextBox ID="txtEmpleadoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblDni" runat="server" Text="Dni: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtDni" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNombres" runat="server" Text="Nombres: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtNombres" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblApellidoPaterno" runat="server" Text="Apellido Paterno: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtApellidoPaterno" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblApellidoMaterno" runat="server" Text="Apellido Materno: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtApellidoMaterno" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>            
            <div class="mb-3 row">
                <asp:Label ID="lblTelefono" runat="server" Text="Telefono: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtTelefono" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblUsuario" runat="server" Text="Usuario: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtUsuario" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblContraseña" runat="server" Text="Contraseña: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtContraseña" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblCorreo" runat="server" Text="Correo: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtCorreo" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Estado:</label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlEstado" runat="server" CssClass="form-select">
                        <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                        <asp:ListItem Text="Activo" Value="ACTIVO"></asp:ListItem>
                        <asp:ListItem Text="Inactivo" Value="INACTIVO"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>

            <div class="mb-3 row">
                <label ID="lblDesempeno" runat="server" class="col-sm-4 col-form-label">Desempeño:</label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlDesempeno" runat="server"  CssClass="form-select">
                        <asp:ListItem Text="Inaceptable" Value="INACEPTABLE"></asp:ListItem>
                        <asp:ListItem Text="Válido" Value="VALIDO"></asp:ListItem>
                        <asp:ListItem Text="Satisfactorio" Value="SATISFACTORIO"></asp:ListItem>
                        <asp:ListItem Text="Sobresaliente" Value="SOBRESALIENTE"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>

            <div class="mb-3 row">
                <label class="col-sm-4 col-form-label">Tipo:</label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlTipo" runat="server" CssClass="form-select">
                        <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                        <asp:ListItem Text="Operario" Value="OPERADOR"></asp:ListItem>
                        <asp:ListItem Text="Procurador" Value="PROCURADOR"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>

        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>
</asp:Content>
