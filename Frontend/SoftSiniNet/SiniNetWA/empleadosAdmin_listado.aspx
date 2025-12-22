<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="empleadosAdmin_listado.aspx.cs" Inherits="SiniNetWA.empleadosAdmin_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Empleados
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <!-- Contenedor GLOBAL centrado respecto al área blanca -->
    <div class="d-flex justify-content-center mt-4">
        <div class="w-100" style="max-width:1900px;">   <!-- AJUSTA AQUÍ EL ANCHO -->

            <!-- TÍTULO + BOTÓN -->
            <div class="d-flex justify-content-between align-items-center mb-3 px-3">
                <h2 class="m-0">Mantenimiento de Empleados</h2>

                <asp:Button ID="btnInsertar"
                            runat="server"
                            CssClass="btn btn-primary"
                            Text="Insertar"
                            OnClick="btnInsertar_Click" />
            </div>

            <!-- TABLA CENTRADA -->
            <div class="table-responsive px-3">
                <asp:GridView ID="dgvEmpleados"
                              runat="server"
                              AllowPaging="false"
                              AutoGenerateColumns="false"
                              CssClass="table table-hover table-striped text-center mx-auto">

                    <Columns>
                        <asp:BoundField HeaderText="Id"              DataField="personalId"      />
                        <asp:BoundField HeaderText="Dni"             DataField="dni"             />
                        <asp:BoundField HeaderText="Nombres"         DataField="nombres"         />
                        <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                        <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                        <asp:BoundField HeaderText="Teléfono"        DataField="telefono"        />
                        <asp:BoundField HeaderText="Usuario"         DataField="nombreUsuario"   />
                        <asp:BoundField HeaderText="Contraseña"      DataField="contrasenia"     />
                        <asp:BoundField HeaderText="Correo"          DataField="correo"          />
                        <asp:BoundField HeaderText="Estado"          DataField="estado"          />
                        <asp:BoundField HeaderText="Desempeño"       DataField="desempenio"       />
                        <asp:BoundField HeaderText="Tipo"            DataField="tipo"            />

                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="d-flex justify-content-center gap-2">
                                    <asp:LinkButton ID="lbModificar"
                                                    runat="server"
                                                    CssClass="btn btn-sm btn-primary"
                                                    ToolTip="Modificar"
                                                    CommandArgument='<%# Eval("personalId") %>'
                                                    OnClick="lbModificar_Click">
                                        <i class="fa-solid fa-edit"></i>
                                    </asp:LinkButton>

                                    <asp:LinkButton ID="lbEliminar"
                                                    runat="server"
                                                    CssClass="btn btn-sm btn-danger"
                                                    ToolTip="Eliminar"
                                                    CommandArgument='<%# Eval("personalId") %>'
                                                    OnClientClick="return confirm('¿Está seguro de eliminar este registro?');"
                                                    OnClick="lbEliminar_Click">
                                        <i class="fa-solid fa-trash"></i>
                                    </asp:LinkButton>
                                </div>
                            </ItemTemplate>
                        </asp:TemplateField>

                    </Columns>
                </asp:GridView>
            </div>

        </div>
    </div>

</asp:Content>

