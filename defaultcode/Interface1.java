package defaultcode;

public interface Interface1 {


    //接口中的所有变量默认 public static final
    public static final String keyword = "keyword";

    //final 和 default不可以同时修饰同一个方法
    public default void showDefault() {
        System.out.println("hello default");
    }

    //static修饰的interface方法，可以直接（实例名.方法名）使用
    //static修饰的方法，继承或实现的子类无法直接使用
    public static void showStatic() {
        System.out.println("hello static");
    }
}
