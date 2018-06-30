package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class UINames2 {

    @Before
    public void setUp(){

        RestAssured.baseURI="https://uinames.com";
        RestAssured.basePath="/api/";
    }

    @Test
    public void getExtract(){
        Map<String, Object> map = new HashMap<>();
        map.put("amount",501);
        map.put("region","United States");


        Response response=
        given()
                .log().all()
                .accept(ContentType.JSON)
                .params(map)
                .param("ext")
                .when()
                .get()
                .then()
                .statusCode(400)
                .assertThat().body("error",equalTo("Amount of requested names exceeds maximum allowed"))
                .extract().response();




    }
}
