<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="llaveMaestra.aspx.cs" Inherits="SiniNetWA.llaveMaestra" %>

<!DOCTYPE html>
<html>
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <title>SiniNet - Acceso de Administrador</title>

    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/Fonts/css/all.css" rel="stylesheet" />
    <link href="Content/sininet.css" rel="stylesheet" />
</head>
<body class="auth-body">
    <form id="form1" runat="server">
        <div class="card shadow-lg" style="width: 100%; max-width: 420px; border-radius: 0.75rem;">
            <div class="card-body p-5">
                <h1 class="card-title text-center mb-4" style="color: #1E3A5F;">SiniNet</h1>
                <h5 class="text-center text-muted mb-4">Acceso de Administrador</h5>

                <div class="form-floating mb-3">
                    <asp:TextBox ID="txtLlaveMaestra" runat="server" TextMode="Password" CssClass="form-control" placeholder="Llave Maestra"></asp:TextBox>
                    <label for="<%= txtLlaveMaestra.ClientID %>"><i class="fas fa-key me-2"></i>Llave Maestra</label>
                </div>

                <div class="d-grid mt-4">
                    <asp:Button ID="btnValidar" runat="server" Text="Validar Acceso" OnClick="btnValidar_Click" CssClass="btn btn-primary" />
                </div>

                <div class="text-center mt-3">
                    <a href="Login.aspx" class="btn btn-link text-secondary">Regresar al Login</a>
                </div>

                <div class="mt-3 text-center">
                    <asp:Label ID="lblError" runat="server" CssClass="text-danger fw-bold"></asp:Label>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
