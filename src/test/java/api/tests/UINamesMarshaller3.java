package api.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class UINamesMarshaller3 {
    UINamesPerson1 personTest;

    @Test
    public void marshallTest() {
        //RestAssured.basePath = "";

        Response response =
                given().accept(ContentType.JSON)
                        .and()
                        .params("region", "United States", "amount", 1)
                        .when()
                        .get("https://uinames.com/api/");


        try {
            JAXBContext jaxbContext =JAXBContext.newInstance(UINamesPerson1.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            personTest = response.body().as(UINamesPerson1.class);

            marshaller.marshal(personTest, new FileOutputStream
                    ("C:\\Users\\Dell_J\\Documents\\ReviewSessionsCode\\target\\MarshallOutput\\UINames.xml"));

        } catch (Exception e) {

        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////
        try{
            File file = new File("C:\\Users\\Dell_J\\Documents\\ReviewSessionsCode\\target\\MarshallOutput\\UINames.xml");

            JAXBContext unjaxContext = JAXBContext. newInstance(UINamesPerson1.class);

            Unmarshaller unmarshaller = unjaxContext.createUnmarshaller();

            UINamesPerson1 uiNamesPerson1 = (UINamesPerson1) unmarshaller.unmarshal(file);


            System.out.println(uiNamesPerson1.getName()+", "+ uiNamesPerson1.getSurname());

            Assert.assertEquals(personTest.getName(),uiNamesPerson1.getName());
            Assert.assertEquals(personTest.getSurname(), uiNamesPerson1.getSurname());
            Assert.assertEquals(personTest.getGender(), uiNamesPerson1.getGender());
            Assert.assertEquals(personTest.getRegion(), uiNamesPerson1.getRegion());

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }




}

@XmlRootElement
class UINamesPerson1 {
    private String name;
    private String surname;
    private String gender;
    private String region;

    public UINamesPerson1() {
    }

    public UINamesPerson1(String name, String surname, String gender, String region) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.region = region;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public String getSurname() {
        return surname;
    }
    @XmlElement
    public String getGender() {
        return gender;
    }
    @XmlElement
    public String getRegion() {
        return region;
    }
}
