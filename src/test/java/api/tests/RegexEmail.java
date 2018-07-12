package api.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEmail {

    public static void main(String[] args) {

        String email="sdkfja;lfjdjam@es@email.com.com.com";
        String valid="james@email.com";
        String result="";
        Pattern pattern = Pattern.compile("[\\w+][@{1}][.com{1}]");


        Matcher matcher = pattern.matcher(valid);

        while(matcher.find()){
           result+=email.substring(matcher.start(),matcher.end());

        }
        System.out.println(result);
    }
}
