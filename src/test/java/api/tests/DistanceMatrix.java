package api.tests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DistanceMatrix {
    Response response;
    @Test
    public void distanceMatrixTest(){
        RestAssured.baseURI="https://maps.googleapis.com/maps/api";
        response=
                given()
                .param("key", "AIzaSyCT4GUmWrOLe8tP0SVha34APXI9JiyNPyI")

                .param("destinations", "New+York+City,NY")
                .param("origins", "Washington,DC")
                .param("units", "imperial")

                        .when()
                        .get("/distancematrix/json");
        JsonPath json = response.jsonPath();
        Assert.assertEquals("[[225 mi]]",json.getString("rows.elements.distance.text"));
    }
}
