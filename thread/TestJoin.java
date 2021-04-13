package Thread;

public class TestJoin {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        private B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
       

    }

    public static void main(String[] args) {
        TestJoin join = new TestJoin();
        A a = join.new A();
        B b = join.new B(a);
        b.start();
        a.start();
    }
}
