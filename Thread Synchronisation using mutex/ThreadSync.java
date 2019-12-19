package thread.sync;


public class ThreadSync {

    public static int mutex,balance;
    public static void main(String[] args) {
        
        mutex = 0;
        balance = 10000;
        
        Bank acc1 = new Bank(1);
        Bank acc2 = new Bank(2);
        
        acc1.start();
        acc2.start();
        
    }
    
}
