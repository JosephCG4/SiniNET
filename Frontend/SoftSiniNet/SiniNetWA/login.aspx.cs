using SiniNetBusiness;
using SiniNetBusiness.SiniNetWSAdministradores;
using SiniNetBusiness.SiniNetWSEmpleados;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SiniNetWA
{
    public partial class login : System.Web.UI.Page
    {
        private EmpleadoBO empleadoBO;
        private AdministradorBO administradorBO;
        private IList<empleadosDTO> listaEmpleados;
        private IList<administradoresDTO> listaAdministradores;
        public login()
        {
            empleadoBO = new EmpleadoBO();
            administradorBO = new AdministradorBO();
            listaEmpleados = this.empleadoBO.listarTodos();
            listaAdministradores = this.administradorBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            // 1. Obtenemos los datos que el usuario escribió en los TextBox
            string usuario = txtUsuario.Text.Trim(); // .Trim() quita espacios en blanco
            string password = txtPassword.Text;
            string llaveMaestra = null;
            string rol = null;
            
            if (listaEmpleados != null)
            {
                foreach (empleadosDTO empleado in listaEmpleados)
                {
                    if (usuario == empleado.nombreUsuario && password == empleado.contrasenia)
                    {
                        if (empleado.tipo.Equals(tipoEmpleado.PROCURADOR))
                        {
                            rol = "Procurador";
                            Session["procuradorId"] = empleado.personalId;
                        } 
                        if (empleado.tipo.Equals(tipoEmpleado.OPERADOR))
                            rol = "Operario";
                        break;
                    }
                }
            }
            if (listaAdministradores != null)
            {
                foreach (administradoresDTO administrador in listaAdministradores)
                {
                    if (usuario == administrador.nombreUsuario && password == administrador.contrasenia)
                    {
                        rol = "Administrador";
                        llaveMaestra = administrador.llaveMaestra;
                        break;
                    }
                }
            }


            // 3. Verificamos el resultado
            if (rol != null)
            {
                // ¡Login exitoso! Guardamos los datos en la Sesión.
                Session["rolUsuario"] = rol;
                Session["nombreUsuario"] = usuario;

                // Redirigimos al usuario a la página principal del sistema.
                if (rol == "Administrador")
                {
                    Session["llaveMaestra"] = llaveMaestra;
                    Response.Redirect("llaveMaestra.aspx");
                }
                
                if (rol == "Procurador")
                    Response.Redirect("index.aspx");

                if (rol == "Operario")
                    Response.Redirect("index.aspx");
            }
            else
            {
                // Login fallido: Mostramos un mensaje de error.
                lblError.Text = "Usuario o contraseña incorrectos.";
            }
        }
    }
}