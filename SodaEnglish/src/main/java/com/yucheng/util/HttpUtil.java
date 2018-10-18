package com.yucheng.util;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: HttpUtil 
* @Description: 完成https请求的工具类
* @author worker 
* @date 2018年6月7日 下午5:18:02 
*  
*/
public class HttpUtil {

    private static class TrustAnyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static String httpRequest(String requestUrl, String requestMethod, String content) throws IOException {
        StringBuffer buffer = null;

        URL url = new URL(requestUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod(requestMethod);
        conn.connect();
        //往服务器端写内容 也就是发起http请求需要带的参数  
        if (null != content) {
            OutputStream os = conn.getOutputStream();
            os.write(content.getBytes("utf-8"));
            os.close();
        }

        //读取服务器端返回的内容  
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public static String httpPost(String requestUrl, String content) throws IOException {
        return httpRequest(requestUrl, "POST", content);
    }

    public static String httpsRequest(String url, String requestMethod, String content, String charset)
            throws NoSuchAlgorithmException, KeyManagementException, IOException {

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());

        URL console = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
        conn.setSSLSocketFactory(sc.getSocketFactory());
        conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
        conn.setRequestMethod("POST");
        conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("content-Type", "application/json;charset=utf-8");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();

        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.write(content.getBytes(charset));
        // 刷新、关闭  
        out.flush();
        out.close();

        StringBuffer buffer = null;
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "utf-8");
        BufferedReader br = new BufferedReader(isr);
        buffer = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }

    public static String httpsPost(String url, String content, String charset)
            throws NoSuchAlgorithmException, KeyManagementException, IOException {
        return httpsRequest(url, "POST", content, charset);
    }

    public static void setTextPlainToResponse(HttpServletResponse response, String data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        pw.append(data);
        pw.flush();
    }

    public static String getPostByTextPlain(HttpServletRequest request) throws IOException {

        BufferedReader reader = request.getReader();
        char[] buf = new char[512];
        int len = 0;
        StringBuffer contentBuffer = new StringBuffer();
        while ((len = reader.read(buf)) != -1) {
            contentBuffer.append(buf, 0, len);
        }
        String content = contentBuffer.toString();
        return content;
    }
}
