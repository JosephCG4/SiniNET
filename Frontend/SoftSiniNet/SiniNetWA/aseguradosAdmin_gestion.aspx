<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="aseguradosAdmin_gestion.aspx.cs" Inherits="SiniNetWA.aseguradosAdmin_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión Asegurados
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
                    <asp:TextBox ID="txtId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
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
            
        </div>

        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>
</asp:Content>
