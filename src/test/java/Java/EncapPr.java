package Java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EncapPr {


    public static void main (String []args){

List <locators> lc= new ArrayList<>();
lc.add(new locators("//td[preceding-sibling::td='t']", "E[A*='t']"));
lc.add(new locators("E[contains(@A,'t')" ,"E[A*='t']"));
lc.add(new locators("//div[. = ' ']" ,"#id"));
lc.add(new locators("remove" ,"#id"));
lc.add(new locators("//div[. = ' ']" ,"#id"));
lc.add(new locators("remove" ,"remove"));
lc.add(new locators("//div[. = ' ']" ,"#id"));


Iterator it =lc.iterator();

while (it.hasNext()) {
	System.out.println(it.next());
}
    }

}
/*System.out.println("Size Before "+ lc.size());
for(int i=0; i<lc.size();i++) {
	if (lc.get(i).getXpath().equals("remove")) {
	lc.remove(i);
		
	}
}
System.out.println("Size After "+ lc.size());
}

}*/

 class locators{

@Override
	public String toString() {
		return "locators [xpath=" + xpath + ", css=" + css + "]";
	}

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

