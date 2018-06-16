package api.tests;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileOutputStream;

public class EvenMoreBasicMarshall {
    @Test
    public void basicMarshaller(){
        try{
            //creating the JAXB context
            JAXBContext jContext = JAXBContext.newInstance(Student.class);
            //creating the marshaller object
            Marshaller marshallObj = jContext.createMarshaller();
            //setting the property to show xml format output
            marshallObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //setting the values in POJO class
            Student student = new Student("abhishek", 1163, "hadoop");
            //calling the marshall method
            marshallObj.marshal(student, new FileOutputStream
                    ("C:\\Users\\Dell_J\\Documents\\ReviewSessionsCode\\target\\MarshallOutput\\Test2.xml"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
@XmlRootElement
class Student {
    private String name;
    private int id;
    private String subject;
    Student(){
    }
    Student(String name,int id,String subject){
        this.name=name;
        this.id=id;
        this.subject=subject;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}