import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class HungryMan{

    int i = 0;
    private static HungryMan hungryMan = new HungryMan();

    private HungryMan(){

    }

    public static HungryMan getInstance(){
        return hungryMan;
    }
}