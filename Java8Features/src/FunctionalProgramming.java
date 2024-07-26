public class FunctionalProgramming {
    //passing funtionality as argument
    //Lambda enables Functional Programming
    public static void main(String[] args) {
        Add ad = new Addition();
        ad.add(10,20);

        //no need to create separate class and implement Add interface.
        Add ad1 = (x,y)->{
           int z = x+y;
           System.out.println(z);
        };

        ad1.add(20,30);

        Runnable r = ()->{
            System.out.println("Run method");
        };

        Thread t=new Thread(r);
        t.run();

        //simplified way
        Thread t1=new Thread(()->System.out.println("Simplified Run"));
        t1.run();
    }

}
