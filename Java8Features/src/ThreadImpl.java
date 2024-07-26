public class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("ThreadImpl run method");
    }

    public static void main(String[] args) {
        Runnable r=new ThreadImpl();
        Thread r1= new Thread(r);
        r1.run();
        //second way
        Thread t=new Thread(new ThreadImpl());
        t.run();
    }
}

