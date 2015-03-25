package quant.common.util;

import java.io.IOException;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
  static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  private static CloseableHttpClient httpClient = HttpClients.createDefault();

  private static int default_time_out = 10000;

  public static String httpGet(String url) throws IOException {
    return httpGet(url, default_time_out);
  }

  public static String httpGet(String url, int timeout) throws IOException {
    Request request = Request.Get(url);
    request.connectTimeout(timeout);
    request.socketTimeout(timeout);
    Content content = request.execute().returnContent();
    return content.toString();
  }

  public static String httpGet(String url, BasicHeader header) throws IOException {
    Request request = Request.Get(url);
    request.connectTimeout(default_time_out);
    request.socketTimeout(default_time_out);
    request.setHeader(header);
    Content content = request.execute().returnContent();
    return content.toString();
  }

  public static String httpPost(String url, UrlEncodedFormEntity entity, BasicHeader header)
      throws IOException {
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(entity);
    httpPost.setHeader(header);
    String result = null;
    CloseableHttpResponse response = httpClient.execute(httpPost);
    try {
      logger.info("Status", response.getStatusLine());
      result = EntityUtils.toString(response.getEntity());
    } catch (Exception e) {
      logger.error("HTTP post error URL:{} ", url, e);
    } finally {
      response.close();
    }
    return result;
  }

  public static String httpPost(String url, StringEntity entity, BasicHeader header)
      throws IOException {
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(entity);
    httpPost.setHeader(header);
    String result = null;
    CloseableHttpResponse response = httpClient.execute(httpPost);
    try {
      logger.info("Status", response.getStatusLine());
      result = EntityUtils.toString(response.getEntity());
    } catch (Exception e) {
      logger.error("HTTP post error URL:{} ", url, e);
    } finally {
      response.close();
    }
    return result;
  }

  public static String httpPost(String url, StringEntity entity, BasicHeader header, int timeout)
      throws IOException {
    HttpPost httpPost = new HttpPost(url);
    httpPost.setEntity(entity);
    httpPost.setHeader(header);
    String result = null;
    RequestConfig defaultRequestConfig =
        RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout)
            .setConnectionRequestTimeout(timeout).setStaleConnectionCheckEnabled(true).build();
    CloseableHttpClient httpclient =
        HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
    CloseableHttpResponse response = httpclient.execute(httpPost);
    try {
      logger.info("Status", response.getStatusLine());
      result = EntityUtils.toString(response.getEntity());
    } catch (Exception e) {
      logger.error("HTTP post error URL:{} ", url, e);
    } finally {
      response.close();
    }
    return result;
  }

  public static String httpPut(String url, StringEntity entity, BasicHeader header)
      throws IOException {
    HttpPut httpPut = new HttpPut(url);
    httpPut.setEntity(entity);
    httpPut.setHeader(header);
    String result = null;
    CloseableHttpResponse response = httpClient.execute(httpPut);
    try {
      logger.info("Status: " + response.getStatusLine());
      result = EntityUtils.toString(response.getEntity());
    } catch (Exception e) {
      logger.error("HTTP post error URL:{} ", url, e);
    } finally {
      response.close();
    }
    return result;
  }

}
