<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="vehiculosAdmin_gestion.aspx.cs" Inherits="SiniNetWA.vehiculosAdmin_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión Vehículos
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
                <asp:Label ID="lblVehiculoId" runat="server" Text="Id: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtVehiculoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblPlaca" runat="server" Text="Placa: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtPlaca" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblMarca" runat="server" Text="Marca: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlMarca" runat="server" CssClass="form-select">
                        <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                        <asp:ListItem Value="TOYOTA">Toyota</asp:ListItem>
                        <asp:ListItem Value="HYUNDAI">Hyundai</asp:ListItem>
                        <asp:ListItem Value="KIA">Kia</asp:ListItem>
                        <asp:ListItem Value="CHANGAN">Changan</asp:ListItem>
                        <asp:ListItem Value="CHEVROLET">Chevrolet</asp:ListItem>
                        <asp:ListItem Value="JAC">Jac</asp:ListItem>
                        <asp:ListItem Value="DFSK">Dfsk</asp:ListItem>
                        <asp:ListItem Value="JETOUR">Jetour</asp:ListItem>
                        <asp:ListItem Value="CHERY">Chery</asp:ListItem>
                        <asp:ListItem Value="FORD">Ford</asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblModelo" runat="server" Text="Modelo: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtModelo" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>                   
            <div class="mb-3 row">
                <asp:Label ID="lblColor" runat="server" Text="Color: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtColor" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblTipo" runat="server" Text="Tipo: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlTipo" runat="server" CssClass="form-select">
                        <asp:ListItem Text="-- Seleccione --" Value="" Selected="True"></asp:ListItem>
                        <asp:ListItem Value="SEDAN">Sedan</asp:ListItem>
                        <asp:ListItem Value="SUV">Suv</asp:ListItem>
                        <asp:ListItem Value="CAMIONETA">Camioneta</asp:ListItem>
                        <asp:ListItem Value="MOTOCICLETA">Motocicleta</asp:ListItem>
                        <asp:ListItem Value="VAN">Van</asp:ListItem>
                        <asp:ListItem Value="COUPE">Coupe</asp:ListItem>
                        <asp:ListItem Value="MINIVAN">Minivan</asp:ListItem>
                        <asp:ListItem Value="HATCHBACK">Hatchback</asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
        </div>

        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>
</asp:Content>