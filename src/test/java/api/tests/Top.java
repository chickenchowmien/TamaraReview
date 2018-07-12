package api.tests;

public interface Top {

    void spin();
    default void  axis(){
        System.out.println("axis");
    }

}
