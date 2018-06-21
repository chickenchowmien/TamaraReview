package api.tests;

public class ControlledCar {
    public static void main(String[] args) {
        Remote remote = ()-> {
            System.out.println("Remote");
        };
        remote.go();

        Thread thread1 = new Thread(()-> {
            System.out.println("New Thread");
        });
        thread1.start();


    }
}
