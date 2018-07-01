package api.tests;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;

import java.io.IOException;

public class Apache2 {
    public static void main(String[] args) throws IOException {
        HttpUriRequest request = new HttpGet("https://uinames.com/api/");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        Assert.assertEquals(httpResponse.getStatusLine().getStatusCode(),HttpStatus.SC_OK);

        String result = EntityUtils.toString(httpResponse.getEntity());

        System.out.println(result);

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(result);


        Gson gson = new Gson();
        //P1 p1 = gson.toJson(jsonObject,P1.class);


    }
}

class P1{
    private String name;
    private String surname;
    private String gender;
    private String region;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getRegion() {
        return region;
    }
}
