package Defaultcode;

public interface Interface2 {

    //final 和 default不可以同时修饰同一个方法
    public default void showDefault() {
        System.out.println("hello default");
    }
}
