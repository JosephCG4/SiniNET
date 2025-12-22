<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="SiniNetWA.login" %>

<!DOCTYPE html>
<html>
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <title>SiniNet - Inicio de Sesión</title>

    <link href="Content/bootstrap.min.css" rel="stylesheet" />
    <link href="Content/Fonts/css/all.css" rel="stylesheet" />
    <link href="Content/sininet.css" rel="stylesheet" />
</head>
<body class="auth-body">
    <form id="form1" runat="server">
        <div class="card shadow-lg" style="width: 100%; max-width: 420px; border-radius: 0.75rem;">
            <div class="card-body p-5">
                <h1 class="card-title text-center mb-4" style="color: #1E3A5F;">SiniNet</h1>
                <div class="form-floating mb-3">
                    <asp:TextBox ID="txtUsuario" runat="server" CssClass="form-control" placeholder="Usuario"></asp:TextBox>
                    <label for="<%= txtUsuario.ClientID %>"><i class="fas fa-user me-2"></i>Usuario</label>
                </div>
                <div class="form-floating mb-3 position-relative">
                    <asp:TextBox ID="txtPassword" runat="server" TextMode="Password" CssClass="form-control pe-5" placeholder="Contraseña"></asp:TextBox>
                    <label for="<%= txtPassword.ClientID %>"><i class="fas fa-lock me-2"></i>Contraseña</label>
                    <span id="togglePassword" class="position-absolute top-50 end-0 translate-middle-y me-3" style="cursor: pointer;"><i class="fa-solid fa-eye"></i></span>
                </div>
                <div class="d-grid mt-4">
                    <asp:Button ID="btnLogin" runat="server" Text="Iniciar Sesión" OnClick="btnLogin_Click" CssClass="btn btn-primary btn-lg" />
                </div>
                <div class="mt-3 text-center">
                    <asp:Label ID="lblError" runat="server" CssClass="text-danger fw-bold"></asp:Label>
                </div>
            </div>
        </div>
    </form>
    <script>
        const togglePassword = document.querySelector('#togglePassword');
        const password = document.querySelector('#<%= txtPassword.ClientID %>');
        const eyeIcon = togglePassword.querySelector('i');

        togglePassword.addEventListener('click', function (e) {
            const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
            password.setAttribute('type', type);

            eyeIcon.classList.toggle('fa-eye');
            eyeIcon.classList.toggle('fa-eye-slash');
        });
    </script>
</body>
</html>
