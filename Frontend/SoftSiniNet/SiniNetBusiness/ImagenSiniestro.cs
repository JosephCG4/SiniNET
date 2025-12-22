using SiniNetBusiness.SiniNetWSImagenesSiniestros;
using System;
using System.Collections.Generic;
using System.Linq;

namespace SiniNetBusiness
{
    public class ImagenSiniestroBO
    {
        private ImagenesSiniestrosClient clienteSOAP;

        public ImagenSiniestroBO()
        {
            this.clienteSOAP = new ImagenesSiniestrosClient();
        }

        public int subirImagen(int siniestroId, string nombreArchivo, string contenidoBase64)
        {
            return this.clienteSOAP.subirImagenSiniestro(siniestroId, nombreArchivo, contenidoBase64);
        }

        public IList<imagenSiniestroDTO> listarPorSiniestro(int siniestroId)
        {
            imagenSiniestroDTO[] arrayImagenes = this.clienteSOAP.listarImagenesPorSiniestro(siniestroId);
            return arrayImagenes != null ? arrayImagenes.ToList() : new List<imagenSiniestroDTO>();
        }

        public int eliminar(int imagenId)
        {
            return this.clienteSOAP.eliminarImagenSiniestro(imagenId);
        }
    }
}