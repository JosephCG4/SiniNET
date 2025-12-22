<%@ Page Title="" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="siniestrosVehiculares_listado.aspx.cs" Inherits="SiniNetWA.siniestrosVehiculares_listado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Siniestro Vehicular
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <script src="Scripts/SiniNetScripts/gestionar_modales_vehiculos.js"></script>   
    <script src="Scripts/SiniNetScripts/gestionar_modales_personas.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_polizas_vehiculares.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_empleados.js"></script>
    <script src="Scripts/SiniNetScripts/ver_mapa.js"></script>
    <script src="Scripts/SiniNetScripts/gestionar_modales_siniestros_vehicular.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    
    <div class="container-fluid">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Mantenimiento de Siniestros Vehiculares</h2>
            <asp:Button ID="btnInsertar" runat="server" CssClass="float-end btn btn-primary" Text="Insertar" OnClick="btnInsertar_Click" />
        </div>
        
        <div class="table-responsive">
            <asp:GridView ID="dgvSiniestroVehicular" runat="server" AllowPaging="false" AutoGenerateColumns="false" OnRowDataBound="dgvSiniestroVehicular_RowDataBound" CssClass="table table-hover table-responsive table-striped">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="siniestroId"/>

                    <asp:TemplateField HeaderText="Descripción">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerDescripcion" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerDescripcion_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                    
                    <asp:BoundField HeaderText="Fecha y Hora" DataField="fechaHora"/>
                    
                    <asp:TemplateField HeaderText="Estado">
                        <ItemTemplate>
                            <%# 
                                Eval("estado").ToString() == "EN_PROCESO" ? "En Proceso" :
                                Eval("estado").ToString() == "CANCELADO" ? "Cancelado" :
                                "Finalizado"
                            %>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:BoundField HeaderText="Calificacion" DataField="calificacionServicio"/>
                    <asp:TemplateField HeaderText="Ubicacion">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbUbicacion" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbUbicacion_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Validez">
                        <ItemTemplate>
                            <%# (bool)Eval("validez") ? "Válido" : "Inválido" %>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Imagenes">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbImagenes" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbImagenes_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Vehiculo">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVehiculo" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("Vehiculo.vehiculoId") %>' OnClick="lbVehiculo_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:BoundField HeaderText="Costo Estimado" DataField="CostoEstimado"/>
                    <asp:TemplateField HeaderText="Taller">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbTaller" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("TallerAsignado.tallerId") %>' OnClick="lbTaller_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                   
                    <asp:TemplateField HeaderText="Daños">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerDanos" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerDanos_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                    
                    <asp:TemplateField HeaderText="Tipo de daño">
                        <ItemTemplate>
                            <%# 
                                Eval("tipoDano").ToString() == "LEVE" ? "Leve" :
                                Eval("tipoDano").ToString() == "MEDIANO" ? "Mediano" :
                                "Fuerte"
                            %>
                        </ItemTemplate>
                    </asp:TemplateField>
                    
                    <asp:TemplateField HeaderText="Conductor">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbConductor" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("Conductor.personalId") %>' OnClick="lbConductor_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Poliza Vehicular">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbPolizaVehicular" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("Poliza.polizaId") %>' OnClick="lbPolizaVehicular_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Procurador Asignado">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbProcurador" runat="server" Text="<i class='fa-solid fa-eye'></i>" CommandArgument='<%# Eval("Procurador.personalId") %>' OnClick="lbProcurador_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField>
                        <ItemTemplate>
                            <div class="d-flex justify-content-center align-items-center gap-2">
                                <asp:LinkButton ID="lbModificar"
                                    runat="server"
                                    CssClass="btn btn-sm btn-primary"
                                    ToolTip="Modificar"
                                    CommandArgument='<%# Eval("siniestroId") %>'
                                    OnClick="lbModificar_Click"><i class="fa-solid fa-edit"></i>
                                </asp:LinkButton>

                                <asp:LinkButton ID="lbEliminar"
                                    runat="server"
                                    CssClass="btn btn-sm btn-danger"
                                    ToolTip="Eliminar"
                                    CommandArgument='<%# Eval("siniestroId") %>'
                                    OnClick="lbEliminar_Click"
                                    OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class="fa-solid fa-trash"></i>
                                </asp:LinkButton>
                            </div>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal fade" id="modalVerVehiculo" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Vehiculo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Id Vehiculo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalVehiculoId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Placa:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalVehiculoPlaca" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Marca:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalVehiculoMarca" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Modelo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalVehiculoModelo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Color:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalVehiculoColor" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Tipo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalVehiculoTipo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalVerTaller" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Taller</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Id Taller:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalTallerId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalTallerNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Telefono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalTallerTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>

                            <div class="mb-3 row">
                                <asp:Label Text="Dirección:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalTallerDireccion" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Referencia:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalTallerReferencia" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="row mb-4 justify-content-center">
                                <div class="col-sm-10">
                                    <div id="mapViewVer3" style="height: 400px; border-radius: 10px; border: 2px solid #d4ad32;"></div>
                                </div>
                            </div>

                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalVerConductor" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Conductor</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Id Conductor:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalConductorId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Dni:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalConductorDNI" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalConductorNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalConductorApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalConductorApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Telefono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalConductorTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="modalVerPolizaVehicular" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles de la Poliza</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="ID Poliza Vehicular:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaVehicularId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Estado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularEstado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Tipo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularTipo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Porcentaje de cobertura:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularPorcentaje" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>                            
                            <div class="mb-3 row">
                                <asp:Label Text="Dni del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularDNI" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombres del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido paterno del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido materno del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Telefono del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalPolizaVehicularTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalVerProcurador" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles de la Poliza</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Id Procurador:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Dni:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorDNI" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Telefono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Correo:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8"><asp:TextBox ID="txtModalProcuradorCorreo" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

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
        <div class="modal fade" id="modalVerImagenes" tabindex="-1">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Imágenes del Siniestro</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <asp:Repeater ID="rptImagenes" runat="server">
                                <ItemTemplate>
                                    <div class="mb-4 text-center border rounded p-3">
                                        <img src='<%# Eval("url") %>' 
                                             class="img-fluid rounded" 
                                             alt='<%# Eval("nombreArchivo") %>' 
                                             style="max-height: 500px; max-width: 100%;" />
                                        <p class="text-muted mt-2 mb-2">
                                            <small><%# Eval("nombreArchivo") %></small>
                                        </p>
                                    </div>
                                </ItemTemplate>
                            </asp:Repeater>
                            <asp:Label ID="lblNoImagenes" runat="server" Text="No hay imágenes para este siniestro." 
                                CssClass="text-muted" Visible="false"></asp:Label>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <%-- =================== MODAL PARA VER DESCRIPCION =================== --%>
    <div class="modal fade" id="modal-ver-descripcion-vehicular" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Descripción</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Descripción:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalDescripcion" Enabled="false" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <%-- =================== MODAL PARA VER DAÑOS =================== --%>
    <div class="modal fade" id="modal-ver-danos-vehicular" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Daños</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Daños:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalDanos" Enabled="false" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>
</asp:Content>