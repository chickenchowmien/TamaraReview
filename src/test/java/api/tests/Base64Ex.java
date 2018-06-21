package api.tests;

import org.apache.commons.codec.binary.Base64;

public class Base64Ex {
    public static void main(String[] args) {
        String password = "password";
        Base64 base64 = new Base64();

        System.out.println("Password is : "+password);
        String encodedPassword = new String(base64.encode(password.getBytes()));

        System.out.println("Encoded Password: "+encodedPassword);

        String decodedVersion = new String(base64.decode(encodedPassword.getBytes()));
        System.out.println("Decoded back to password: "+decodedVersion);

    }
}
