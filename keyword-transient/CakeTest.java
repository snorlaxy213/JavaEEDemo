import java.io.*;

public class CakeTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializeCake();
        deSerializeCake();
    }

    private static void serializeCake() throws IOException {
        Cake cake = new Cake();
        cake.setColor("white");
        cake.setShape("cylinder");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./keyword-transient/Cake.txt"));
        oos.writeObject(cake);
        oos.close();
        System.out.println("添加transient关键字序列化：color = " + cake.getColor());
    }

    //使用transient之后，反序列化后得到的值为null
    private static void deSerializeCake() throws IOException, ClassNotFoundException {
        File file = new File("./keyword-transient/Cake.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Cake cake = (Cake) ois.readObject();
        System.out.println("添加transient关键字反序列化：color = " + cake.getColor());
    }

    /* result:
     * 添加transient关键字序列化：color = white
     * 添加transient关键字反序列化：color = null
     *
     */
}
