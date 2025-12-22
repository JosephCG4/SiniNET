<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="reportesAdmin.aspx.cs" Inherits="SiniNetWA.reportesAdmin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reportes de Empleados
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_empleados.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card">
        <div class="card-header">
            <h2>Generar Reporte de Desempeño</h2>
        </div>
        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblEmpleadoId" runat="server" Text="Empleado Id:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtEmpleadoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
                <asp:Button ID="btnFiltrarEmpleados" CssClass="btn btn-primary col-sm-1" runat="server" Text="Buscar" OnClick="btnFiltrarEmpleados_Click" />
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblEmpleadoNombres" runat="server" Text="Nombres :" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtNombresEmpleado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblEmpleadoApellidoPaterno" runat="server" Text="Apellido Paterno:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtApellidoPaternoEmpleado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblEmpleadoTipo" runat="server" Text="Tipo:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtTipoEmpleado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblFechaInicio" runat="server" Text="Fecha Inicio:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtFechaInicio" runat="server" CssClass="form-control" TextMode="Date"></asp:TextBox>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblFechaFin" runat="server" Text="Fecha Fin:" CssClass="col-sm-4 col-form-label"></asp:Label>
                <div class="col-sm-4">
                    <asp:TextBox ID="txtFechaFin" runat="server" CssClass="form-control" TextMode="Date"></asp:TextBox>
                </div>
            </div>
        </div>
        <div class="card-footer">
            <asp:Button ID="btnRegresar" runat="server" CssClass="float-start btn btn-secondary" Text="Regresar" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnGenerar" runat="server" CssClass="float-end btn btn-primary" Text="Generar" OnClick="btnGenerar_Click" />
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal" id="form-modal-filtro-empleado">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Empleados</h5>
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
                                        <asp:TextBox CssClass="form-control" ID="ModalFiltroEmpleado_txtFiltroEmpleado" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="ModalFiltroEmpleado_lbBuscarEmpleado" runat="server" CssClass="btn btn-info" Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="ModalFiltroEmpleado_lbBuscarEmpleado_Click"></asp:LinkButton>
                                    </div>
                                </div>
                                <div class="container row">
                                    <asp:GridView ID="ModalFiltroEmpleado_gvEmpleado" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                        <Columns>
                                            <asp:BoundField HeaderText="Id" DataField="personalId" /> 
                                            <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                                            <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                                            <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                                            <asp:BoundField HeaderText="Estado" DataField="estado" />
                                            <asp:BoundField HeaderText="Tipo" DataField="tipo" />
                                            <asp:TemplateField>
                                                <ItemTemplate>
                                                    <asp:LinkButton ID="ModalFiltroEmpleado_lbSeleccionar" class="btn btn-success" runat="server" Text="Seleccionar" CommandArgument='<%# Eval("personalId") %>' OnClick="ModalFiltroEmpleado_lbSeleccionar_Click"></asp:LinkButton>
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
