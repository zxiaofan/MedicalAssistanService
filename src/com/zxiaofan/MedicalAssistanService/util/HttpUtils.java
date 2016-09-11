package com.zxiaofan.MedicalAssistanService.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpMethod;

import com.zxiaofan.MedicalAssistanService.constant.Constant;

/**
 * 基于HttpClient/Jsoup的Http辅助类.
 * 
 * @author yunhai
 */
public class HttpUtils {
    @Resource(name = "logging")
    private Logging logging;

    /**
     * 构造函数.
     *
     */
    private HttpUtils() {
        throw new RuntimeException("this is a util class,can not instance");
    }

    /**
     * Jsoup返回Document.
     * 
     * @param url
     *            访问地址
     * @return Document
     */
    public static Document JsoupGetDoc(String url) {
        Connection connection = Jsoup.connect(url);
        connection.timeout(Constant.timeOut); // 设置连接超时时间
        // 给服务器发消息头，告诉服务器，俺不是java程序。CSDN不允许java程序访问
        connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)");
        connection.header("Accept", "text/html, application/xhtml+xml, */*");
        connection.header("Connection", "Keep-Alive");
        connection.header("Host", "www.drmed.cn");
        Document doc = null;
        try {
            doc = connection.get();
        } catch (IOException e) {
            Logging.log.error(e.getMessage());
        } // 获取返回的html的document对象
        return doc;
    }

    /**
     * Jsoup Post返回Document.
     * 
     * @param url
     *            访问地址
     * @return Document
     * @throws Exception
     */
    public static Document jsoupPostDoc(String url, Map<String, String> map) throws Exception {
        Connection connection = Jsoup.connect(url);

        connection.timeout(500); // 设置连接超时时间
        // 给服务器发消息头，告诉服务器，俺不是java程序。CSDN不允许java程序访问
        connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)");
        connection.header("Accept", "text/html, application/xhtml+xml, */*");
        connection.header("Content-Type", "Keep-Alive");
        connection.header("Host", "www.drmed.cn");
        Response doc = null;
        try {
            connection.get();
            doc = connection.ignoreContentType(true).method(Method.POST).data(map).execute();
        } catch (IOException e) {
            e.printStackTrace();
        } // 获取返回的html的document对象
        return doc.parse();
    }

    /**
     * 请求执行函数.
     * 
     * @param httpclient
     *            httpclient
     * @param url
     *            url
     * @param method
     *            method
     * @param config
     *            config
     * @param param
     *            param
     * @return CloseableHttpResponse
     * @throws Exception
     *             Exception
     */
    public static CloseableHttpResponse excute(CloseableHttpClient httpclient, String url, String method, RequestConfig config, List<NameValuePair> param) throws Exception {
        HttpEntity entity = new UrlEncodedFormEntity(param, "UTF-8");
        HttpUriRequest request = RequestBuilder.create(method).setUri(url).setEntity(entity).setConfig(config).build();
        CloseableHttpResponse response = httpclient.execute(request);
        return response;
    }

    /**
     * 请求执行函数.
     * 
     * @param httpclient
     *            httpclient
     * @param url
     *            url
     * @param method
     *            method
     * @param config
     *            config
     * @return CloseableHttpResponse
     * @throws Exception
     *             Exception
     */
    public static CloseableHttpResponse excute(CloseableHttpClient httpclient, String url, String method, RequestConfig config) throws Exception {
        HttpUriRequest request = RequestBuilder.create(method).setUri(url).setConfig(config).build();
        CloseableHttpResponse response = httpclient.execute(request);
        return response;
    }

    /**
     * 请求执行函数.
     * 
     * @param httpclient
     *            httpclient
     * @param url
     *            url
     * @param method
     *            method
     * @param config
     *            config
     * @param param
     *            param
     * @param urlCharset
     *            urlCharset
     * @param headers
     *            headers
     * @return CloseableHttpResponse
     * @throws Exception
     *             Exception
     */
    public static CloseableHttpResponse excute(CloseableHttpClient httpclient, String url, String method, RequestConfig config, List<NameValuePair> param, String urlCharset,
            Map<String, String> headers) throws Exception {
        HttpUriRequest request = null;
        // 设置参数
        if (param != null) {
            HttpEntity entity = new UrlEncodedFormEntity(param, urlCharset);
            request = RequestBuilder.create(method).setUri(url).setConfig(config).setEntity(entity).build();
        } else {
            request = RequestBuilder.create(method).setUri(url).setConfig(config).build();
        }
        // 设置请求头

        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.setHeader(entry.getKey(), entry.getValue());
            }
        }
        CloseableHttpResponse response = httpclient.execute(request);
        return response;
    }

    /**
     * TODO 添加方法注释.
     * 
     * @param httpclient
     *            .
     * @param url
     *            .
     * @param method
     *            .
     * @param config
     *            .
     * @param param
     *            .
     * @return byte
     * @throws Exception
     *             异常
     */
    public static byte[] methodExcute(CloseableHttpClient httpclient, String url, String method, RequestConfig config, List<NameValuePair> param) throws Exception {
        HttpEntity entity = new UrlEncodedFormEntity(param, "UTF-8");
        HttpUriRequest request = RequestBuilder.create(method).setUri(url).setEntity(entity).setConfig(config).build();
        CloseableHttpResponse response = httpclient.execute(request);
        byte[] btyeArray = EntityUtils.toByteArray(response.getEntity());
        response.close();
        return btyeArray;
    }

    /**
     * 用HttpClient返回Jsoup可解析的Document对象.
     * 
     * @param url
     *            url
     * @param param
     *            请求参数
     * @return document
     */
    public static Document jsoupPostDoc(String url, List<NameValuePair> param) {
        String html = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpclient = null;
        RequestConfig config = RequestConfig.custom().setConnectTimeout(Constant.timeOut).build();
        try {
            httpclient = HttpClients.custom().build();
            HttpUriRequest request = null;
            if (param != null) {
                HttpEntity entity = new UrlEncodedFormEntity(param, Constant.ENCODE);
                request = RequestBuilder.create(HttpMethod.POST.name()).setUri(url).setEntity(entity).setConfig(config).build();
            } else {
                request = RequestBuilder.create(HttpMethod.POST.name()).setUri(url).setConfig(config).build();
            }
            response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            byte[] strbyte = EntityUtils.toByteArray(entity);
            html = new String(strbyte, Constant.ENCODE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Document doc = Jsoup.parse(html);
        return doc;
    }
}
