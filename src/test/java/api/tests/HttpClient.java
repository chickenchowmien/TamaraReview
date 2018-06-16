package api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClient {
    @Test
    public void httpPostTest()throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://uinames.com/api/");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("gender", "female"));
        params.add(new BasicNameValuePair("region", "United States"));
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        CloseableHttpResponse response = client.execute(httpGet);





    }
}
