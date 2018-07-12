package api.tests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpGetRequest {
    public static void main(String[] args) {
        HttpGet get = new HttpGet("https://uinames.com/api/");
        try(
              CloseableHttpClient client = HttpClientBuilder.create().build();
              CloseableHttpResponse response = client.execute(get);){

        }catch (Exception e){

        }
    }
}
