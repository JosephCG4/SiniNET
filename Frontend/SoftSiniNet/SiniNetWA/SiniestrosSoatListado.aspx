<%@ Page Title="Listado de Siniestros SOAT" Language="C#" MasterPageFile="~/SiniNet.Master" AutoEventWireup="true" CodeBehind="SiniestrosSoatListado.aspx.cs" Inherits="SoftAsegWA.SiniestrosSoatListado" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Siniestros SOAT
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">  
    <script src="Scripts/SiniNetScripts/gestionar_modales_siniestros_soat.js"></script>
    <script src="Scripts/SiniNetScripts/ver_mapa.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>

    <div class="container-fluid">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Mantenimiento de Siniestros SOAT</h2>
            <button id="btnInsertar" runat="server" class="btn btn-primary" onserverclick="btnInsertar_Click">Insertar</button>
        </div>

        <div class="table-responsive">
            <asp:GridView ID="dgvSiniestros" runat="server" AutoGenerateColumns="false" 
                CssClass="table table-hover table-striped" 
                OnRowDataBound="dgvSiniestros_RowDataBound">

                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="siniestroId" />
                    
                    <asp:TemplateField HeaderText="Descripción">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerDescripcion" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerDescripcion_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:BoundField HeaderText="Fecha y Hora" DataField="fechaHora" />

                    <asp:TemplateField HeaderText="Estado">
                        <ItemTemplate>
                            <%# 
                                Eval("estado").ToString() == "EN_PROCESO" ? "En Proceso" :
                                Eval("estado").ToString() == "CANCELADO" ? "Cancelado" :
                                "Finalizado"
                            %>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:BoundField HeaderText="Calificación" DataField="calificacionServicio" />
                    
                    <asp:TemplateField HeaderText="Ubicación">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerUbicacion" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerUbicacion_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Validez">
                        <ItemTemplate>
                            <%# (bool)Eval("validez") ? "Válido" : "Inválido" %>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Imágenes">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerImagenes" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerImagenes_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Centro de Salud">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerCentroDeSalud" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("centroDeSalud.centroDeSaludId") %>' OnClick="lbVerCentroDeSalud_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:BoundField HeaderText="Gastos médicos" DataField="gastosMedicos" />                    

                    <asp:TemplateField HeaderText="Diagnóstico">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerDiagnostico" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerDiagnostico_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Afectados">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerAfectados" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbVerAfectados_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Poliza SOAT">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerPolizaSOAT" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("poliza.polizaId") %>' OnClick="lbVerPolizaSOAT_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField HeaderText="Procurador Asignado">
                        <ItemTemplate>
                            <asp:LinkButton ID="lbVerProcurador" runat="server" CssClass="me-2" ToolTip="Ver Detalles" CommandArgument='<%# Eval("procurador.personalId") %>' OnClick="lbVerProcurador_Click"><i class='fa-solid fa-eye'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>

                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CssClass="btn btn-sm btn-primary me-1" ToolTip="Modificar" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbModificar_Click"><i class='fa-solid fa-edit'></i></asp:LinkButton>
                            <asp:LinkButton ID="lbEliminar" runat="server" CssClass="btn btn-sm btn-danger" ToolTip="Eliminar" CommandArgument='<%# Eval("siniestroId") %>' OnClick="lbEliminar_Click" OnClientClick="return confirm('¿Está seguro de que desea eliminar este registro?');"><i class='fa-solid fa-trash'></i></asp:LinkButton>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>


    <%-- =================== MODAL PARA VER LA UBICACIÓN =================== --%>
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

    <%-- =================== MODAL PARA VER LA POLIZA SOAT =================== --%>
    <div class="modal fade" id="modalVerPolizaSOAT" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles de la Poliza SOAT</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="ID Poliza SOAT:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Estado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATEstado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Monto a cobertura:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATMontoCobertura" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Dni del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATDniAsegurado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombre del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATNombreAsegurado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Paterno del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATApellidoPaternoAsegurado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Materno del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATApellidoMaternoAsegurado" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Teléfono del asegurado:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalPolizaSOATTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

       <%-- =================== MODAL PARA VER IMAGENES =================== --%>
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

    <%-- =================== MODAL PARA VER EL CENTRO DE SALUD =================== --%>
    <div class="modal fade" id="modalVerCentroDeSalud" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Centro de Salud</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="ID Centro de Salud:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludId" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombre:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludNombre" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Código RENIPRESS:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludCodRENIPRESS" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Teléfono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>                            
                            <div class="mb-3 row">
                                <asp:Label Text="Dirección:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludDireccion" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>                            
                            <div class="mb-3 row">
                                <asp:Label Text="Referencia:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalCentroDeSaludReferencia" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>

                            <div class="row mb-4 justify-content-center">
                                <div class="col-sm-10">
                                    <div id="mapViewVer2" style="height: 400px; border-radius: 10px; border: 2px solid #d4ad32;"></div>
                                </div>
                            </div>

                        </ContentTemplate>
                    </asp:UpdatePanel>                   
                </div>
            </div>
        </div>
    </div>


    <%-- =================== MODAL PARA VER PROCURADOR =================== --%>
    <div class="modal fade" id="modalVerProcurador" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Detalles del Procurador</h5>
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
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorDni" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Nombres:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorNombres" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Paterno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorApellidoPaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Apellido Materno:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorApellidoMaterno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>                            
                            <div class="mb-3 row">
                                <asp:Label Text="Teléfono:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorTelefono" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                            <div class="mb-3 row">
                                <asp:Label Text="Desempeño:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalProcuradorDesempeno" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <%-- =================== MODAL PARA VER DESCRIPCION =================== --%>
    <div class="modal fade" id="modal-ver-descripcion-soat" tabindex="-1">
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
                                    <asp:TextBox ID="txtModalDescripcion" Enabled="false" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox></div>
                            </div>                            
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <%-- =================== MODAL PARA VER DIAGNOSTICO =================== --%>
    <div class="modal fade" id="modal-ver-diagnostico-soat" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Diagnóstico</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="mb-3 row">
                                <asp:Label Text="Diagnóstico:" CssClass="col-sm-4 col-form-label fw-bold" runat="server"></asp:Label>
                                <div class="col-sm-8">
                                    <asp:TextBox ID="txtModalDiagnostico" Enabled="false" TextMode="MultiLine" Rows="3" runat="server" CssClass="form-control"></asp:TextBox>
                                </div>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

    <%-- =================== MODAL PARA VER AFECTADOS =================== --%>
    <div class="modal fade" id="modal-ver-afectados-soat" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Afectados</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>                            
                            <asp:GridView ID="gdvModalAfectados" runat="server" AllowPaging="false" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
                                <Columns>
                                    <asp:BoundField HeaderText="Dni" DataField="dni" />
                                    <asp:BoundField HeaderText="Nombres" DataField="nombres" />
                                    <asp:BoundField HeaderText="Apellido Paterno" DataField="apellidoPaterno" />
                                    <asp:BoundField HeaderText="Apellido Materno" DataField="apellidoMaterno" />
                                    <asp:BoundField HeaderText="Telefono" DataField="telefono" />                                    
                                </Columns>
                            </asp:GridView>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
