package defaultcode;

public class InterfaceTest implements Interface1,Interface2  {
    //class 中使用default会直接报错
    /*default void hello() {

    }*/


    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.showDefault();

        Interface1.showStatic();
    }

    //当implement的接口同时拥有default修饰的同名方法，编译报错
    //重写default方法，即可以正常运行
    @Override
    public void showDefault() {
        System.out.println("hello demo test default");
    }
}
