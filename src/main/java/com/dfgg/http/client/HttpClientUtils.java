package com.dfgg.http.client;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * HttpClient utils
 */
public final class HttpClientUtils {

    private static Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final String TEST_URL = "http://111.231.144.35:8999/dfggads/api/sinaForex";

    public JSONObject httpGet(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();

        return null;
    }

    public JSONObject httpPost(String url) {
        return httpPost(url, null);
    }

    public JSONObject httpPost(String url, JSONObject jsonParam) {

        return null;
    }

    public void test(){

    }

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClientMinimal = HttpClients.createMinimal();

        HttpClientConnectionManager clientConnectionManager = new HttpClientConnectionManager() {
            @Override
            public ConnectionRequest requestConnection(HttpRoute httpRoute, Object o) {

                return null;
            }

            @Override
            public void releaseConnection(HttpClientConnection httpClientConnection, Object o, long l, TimeUnit timeUnit) {

            }

            @Override
            public void connect(HttpClientConnection httpClientConnection, HttpRoute httpRoute, int i, HttpContext httpContext) throws IOException {

            }

            @Override
            public void upgrade(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {

            }

            @Override
            public void routeComplete(HttpClientConnection httpClientConnection, HttpRoute httpRoute, HttpContext httpContext) throws IOException {

            }

            @Override
            public void closeIdleConnections(long l, TimeUnit timeUnit) {

            }

            @Override
            public void closeExpiredConnections() {

            }

            @Override
            public void shutdown() {
                System.out.println("shutdown");
            }
        };

        CloseableHttpClient httpClientMinimal2 = HttpClients.createMinimal(clientConnectionManager);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpClient httpClient1 = HttpClients.createSystem();

        HttpGet httpGet = new HttpGet(TEST_URL);


        CloseableHttpResponse httpResponse = httpClient1.execute(httpGet);
        System.out.println(httpResponse.getStatusLine());
//        HttpClients.custom();
    }
}
