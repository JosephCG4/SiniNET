package pe.edu.pucp.softaseg.services.softasegws.resources;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;

public class CloudinaryService {
    
    private static final String CLOUD_NAME = "dcwkikhly";
    private static final String API_KEY = "869386685541943";
    private static final String API_SECRET = "RqO-0XhxgsJWVLHoc6nSqeMnZP0";
    private static final String UPLOAD_URL = "https://api.cloudinary.com/v1_1/" + CLOUD_NAME + "/image/upload";
    private static final String DESTROY_URL = "https://api.cloudinary.com/v1_1/" + CLOUD_NAME + "/image/destroy";
    
    static {
        configurarSSLGlobal();
    }
    
    private static void configurarSSLGlobal() {
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    
                    @Override
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }
                    
                    @Override
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
            };
            
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
            System.setProperty("com.sun.net.ssl.checkRevocation", "false");
            
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            System.err.println("Error al configurar SSL: " + e.getMessage());
        }
    }
    
    private String generarFirma(Map<String, String> params) {
        try {
            String stringToSign = params.entrySet().stream()
                .filter(entry -> {
                    String key = entry.getKey();
                    return !key.equals("api_key") && 
                           !key.equals("file") && 
                           !key.equals("signature");
                })
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
            
            stringToSign += API_SECRET;
            
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(stringToSign.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String h = Integer.toHexString(0xff & b);
                if (h.length() == 1) {
                    hex.append('0');
                }
                hex.append(h);
            }
            
            return hex.toString();
        } catch (Exception e) {
            System.err.println("Error al generar firma: " + e.getMessage());
            return "";
        }
    }
    
    private String extraerUrlDeJson(String json) {
        int idx = json.indexOf("\"secure_url\"");
        if (idx == -1) {
            idx = json.indexOf("\"url\"");
        }
        if (idx == -1) {
            return null;
        }
        
        int start = json.indexOf(":", idx);
        if (start == -1) {
            return null;
        }
        
        start = json.indexOf("\"", start) + 1;
        if (start == 0) {
            return null;
        }
        
        int end = json.indexOf("\"", start);
        if (end == -1) {
            return null;
        }
        
        return json.substring(start, end);
    }
    
    private String realizarPeticionPost(String url, String body) throws Exception {
        URL urlObj = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.writeBytes(body);
            wr.flush();
        }
        
        int responseCode = conn.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(
            responseCode >= 200 && responseCode < 300 ? conn.getInputStream() : conn.getErrorStream()
        ));
        
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        
        return response.toString();
    }
    
    public String subirImagen(byte[] imagenBytes, String nombreArchivo) {
        try {
            String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
            String dataUri = "data:image/png;base64," + base64Image;
            
            long timestamp = System.currentTimeMillis() / 1000;
            String publicId = nombreArchivo.replaceAll("[^a-zA-Z0-9._-]", "_");
            
            Map<String, String> paramsParaFirma = new HashMap<>();
            paramsParaFirma.put("timestamp", String.valueOf(timestamp));
            paramsParaFirma.put("folder", "siniestros");
            paramsParaFirma.put("public_id", publicId);
            
            String signature = generarFirma(paramsParaFirma);
            
            StringBuilder body = new StringBuilder();
            body.append("file=").append(java.net.URLEncoder.encode(dataUri, StandardCharsets.UTF_8));
            body.append("&api_key=").append(API_KEY);
            body.append("&timestamp=").append(timestamp);
            body.append("&folder=").append(java.net.URLEncoder.encode("siniestros", StandardCharsets.UTF_8));
            body.append("&public_id=").append(java.net.URLEncoder.encode(publicId, StandardCharsets.UTF_8));
            body.append("&signature=").append(signature);
            
            String response = realizarPeticionPost(UPLOAD_URL, body.toString());
            String secureUrl = extraerUrlDeJson(response);
            
            if (secureUrl != null && !secureUrl.isEmpty()) {
                return secureUrl;
            } else {
                System.err.println("Error: No se pudo extraer URL del JSON: " + response);
                return null;
            }
            
        } catch (Exception e) {
            System.err.println("Error al subir imagen: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean eliminarImagen(String publicId) {
        try {
            long timestamp = System.currentTimeMillis() / 1000;
            
            Map<String, String> paramsParaFirma = new HashMap<>();
            paramsParaFirma.put("timestamp", String.valueOf(timestamp));
            paramsParaFirma.put("public_id", publicId);
            
            String signature = generarFirma(paramsParaFirma);
            
            StringBuilder body = new StringBuilder();
            body.append("public_id=").append(java.net.URLEncoder.encode(publicId, StandardCharsets.UTF_8));
            body.append("&api_key=").append(API_KEY);
            body.append("&timestamp=").append(timestamp);
            body.append("&signature=").append(signature);
            
            String response = realizarPeticionPost(DESTROY_URL, body.toString());
            
            if (response.contains("\"result\":\"ok\"") || response.contains("\"result\": \"ok\"")) {
                return true;
            } else {
                System.err.println("Error al eliminar imagen: " + response);
                return false;
            }
            
        } catch (Exception e) {
            System.err.println("Error al eliminar imagen: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}