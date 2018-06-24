package Java;

import java.util.ArrayList;
import java.util.List;

public class EncapPr {


    public static void main (String []args){

List <locators> lc= new ArrayList<>();
lc.add(new locators("//td[preceding-sibling::td='t']", "E[A*='t']"));
lc.add(new locators("E[contains(@A,'t')" ,"E[A*='t']"));

    }

}

 class locators{

public locators(String xpath, String css){
    this.xpath=xpath;
    this.css=css;

}

private String xpath;
private String css;

public String getXpath(){
return xpath;

}

public void setXpath(String xpath){
this.xpath= xpath;
}

public String getCss(){
    return css;

}

public void setCss(String css){
    this.css=css;

}

}
