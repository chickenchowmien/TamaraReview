package api.tests;

public class Runner {
    static Top top = () -> {
        System.out.println("spin lambda");
    };
    public static void main(String[] args) {
        top.spin();
    }

}
