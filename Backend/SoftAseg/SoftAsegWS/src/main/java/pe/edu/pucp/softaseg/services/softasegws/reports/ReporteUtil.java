
package pe.edu.pucp.softaseg.services.softasegws.reports;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softaseg.db.DBManager;


public class ReporteUtil {

    public static byte[] reporteCalificacionProcurador(Integer procuradorId, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        HashMap parametros = new HashMap();
        parametros.put("geEMPLEADO_ID", procuradorId);
        parametros.put("FECHA_INICIO", Timestamp.valueOf(fechaInicio));
        parametros.put("FECHA_FIN", Timestamp.valueOf(fechaFin));
        return invocarReporte("reporte_procuradores", parametros);
    }

    public static byte[] reporteSiniestroSOAT(Integer siniestroId) {
        HashMap parametros = new HashMap();
        parametros.put("gssSINIESTRO_ID", siniestroId);
        return invocarReporte("reporte_siniestroSOAT", parametros);
    }

    public static byte[] reporteSiniestroVehicular(Integer siniestroId) {
        HashMap parametros = new HashMap();
        parametros.put("gsvSINIESTRO_ID", siniestroId);
        return invocarReporte("reporte_siniestroVehicular", parametros);    
    }

    private static byte[] invocarReporte(String nombreReporte) {
        return invocarReporte (nombreReporte, null);
    }
    
    private static byte[] invocarReporte(String nombreReporte, HashMap parametros) {
        byte [] reporte = null;
            Connection conexion = DBManager.getInstance().getConnection();
            String nmReporte = "/" + nombreReporte + ".jasper";
        try {   
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteUtil.class.getResource(nmReporte));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            reporte = JasperExportManager.exportReportToPdf(jp);
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return reporte;
    }
    
}
