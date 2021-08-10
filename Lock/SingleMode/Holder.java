package Lock.SingleMode;

public class Holder {
   

    private Holder(){}

    public static Holder getInstance(){
        return  Inner.HOLDER;
    }

    private static class Inner {
        private static Holder HOLDER = new Holder();
    }
}
