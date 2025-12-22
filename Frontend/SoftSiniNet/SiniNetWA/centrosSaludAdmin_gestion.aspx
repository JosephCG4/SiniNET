<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="centrosSaludAdmin_gestion.aspx.cs" Inherits="SiniNetWA.centrosSaludAdmin_gestion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión Centros de Salud
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_mapas.js"></script>
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
                    <asp:TextBox ID="txtCentroSaludId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblCodigo" runat="server" Text="Código Renipress: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtCodigo" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNombre" runat="server" Text="Nombre: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtNombre" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblTelefono" runat="server" Text="Telefono: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtTelefono" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>                   
            <div class="mb-3 row">
                <asp:Label ID="lblDireccion" runat="server" Text="Dirección: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtDireccion" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblReferencia" runat="server" Text="Referencia: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtReferencia" Enabled="true" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblMapa" runat="server" Text="Mapa:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-3">
                    <asp:TextBox ID="txtUbicacionId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
                <asp:Button ID="btnAbrirMapa" CssClass="btn btn-primary col-sm-1" runat="server" Text="Abrir" OnClick="btnAbrirMapa_Click" />
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblLatitudForm" runat="server" Text="Latitud: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtLatitudForm" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblLongitudForm" runat="server" Text="Longitud: " CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtLongitudForm" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
        </div>

        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGuardar" runat="server" CssClass="float-end btn btn-primary" Text="Guardar" OnClick="btnGuardar_Click" />
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

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

</asp:Content>
