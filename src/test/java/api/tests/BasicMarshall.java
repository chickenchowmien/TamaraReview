package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.FileOutputStream;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BasicMarshall {
    @Test
    public void marshallUINames(){
        RestAssured.basePath="https://uinames.com/api/";
        Response response =
                given().accept(ContentType.JSON)
                .and().params("amount", 1, "region", "United States")

                .when().get();

//        try{
//            JAXBContext jaxbContext = JAXBContext.newInstance(Marshall.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            Marshall marshall = response.body().as(Marshall.class);
//
//            marshaller.marshal(marshall, new FileOutputStream("/target/MarshallOutput.UINames.xml"));
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

    }
}
class Marshall{
    private String name;
    private String surname;
    private String gender;
    private String region;
}

