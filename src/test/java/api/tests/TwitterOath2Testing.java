package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TwitterOath2Testing {
    String oath2;
    @Test
    public void getToken(){
        RestAssured.baseURI="https://api.twitter.com/";
        RestAssured.basePath="oauth2/token";

        Response response =  given().accept(ContentType.URLENC)
                .auth()
                .preemptive()
                .basic("GcExgJg85VjOL3apjp3kqC75b","6ji2yWmc2VnQsSXlp3am6OXqiKTcm1aQldTwDlIfBCQGtK3ECS")
                .param("grant_type", "client_credentials")
                .expect()
                .statusCode(200)
                .when()
                .post();
        JsonPath jsonPath = response.jsonPath();
        oath2 = jsonPath.getString("access_token");
        System.out.println(oath2);

    }
    @Test
    public void getFollowers(){
        RestAssured.baseURI="https://api.twitter.com/";

    }



}
