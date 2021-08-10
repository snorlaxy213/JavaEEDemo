package Lock.SingleMode;

public class LazyMan {
    
    int i = 0;
    private volatile static LazyMan LAZY_MAN = null;

    private LazyMan(){
        System.out.println("线程启动"+Thread.currentThread().getName());
    }

    public static LazyMan getInstance(){
        if(LAZY_MAN==null){
            synchronized (LazyMan.class){
                if(LAZY_MAN==null){
                    LAZY_MAN=new LazyMan();
                }
            }
        }
    
        return LAZY_MAN;
    }
}
