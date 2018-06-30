package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Twitter2 {
    String consumerKey = "ubhe5nnmztzlJMzdLihtKEgsT";
    String consumerSecret = "KjDJDSJw2o882K71cK33PqUdRbIlp5DNxCxYknDrSvQwNsb2S1";
    String accessToken = "886092793365409792-mBtgcXzcn9IOC1WmWp5c1fXMn3HDZHr";
    String accessSecret = "jUIEOAnEiZLlICLBlpR6UhVKZ98CMpQ7banbfcP5gW3eS";
    String tweetId = "";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.twitter.com";
        RestAssured.basePath = "/1.1/statuses";
    }

    @Test
    public void postTweet() {
        Response response =
                given()
                        .auth()
                        .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                        .queryParam("status", "My First Tweet")
                        .when()
                        .post("/update.json")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        tweetId = response.path("id_str");
        System.out.println("The response.path: " + tweetId);
    }

    @Test
    public void readTweet() {
        Response response =
                given()
                        .auth()
                        .oauth(consumerKey, consumerSecret, accessToken, accessSecret)
                        .queryParam("id", tweetId)
                        .when()
                        .get("/show.json")
                        .then()
                        .extract()
                        .response();

        String text = response.path("text");
        System.out.println("The tweet text is: " + text);
    }
}
