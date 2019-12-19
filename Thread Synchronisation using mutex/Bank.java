package thread.sync;

public class Bank extends Thread{
    
    public int t_no;
    
    public Bank(int t_no)
    {
        this.t_no = t_no;
    }
    
    @Override
    public void run()
    {
        if(this.t_no == 1)
        {
            for(int i=0;i<5;i++)
            {
                while(ThreadSync.mutex == 1)
                {
                    //wait
                }
                ThreadSync.mutex = 1;
                operation();
            }
        }
        else
        {
            for(int i=0;i<5;i++)
            {
                while(ThreadSync.mutex == 1)
                {
                    //wait
                }
                ThreadSync.mutex = 1;
                operation();
            }
        }
    }
    
    synchronized public void operation()
    {
        if(this.t_no == 1)
        {
            ThreadSync.balance = ThreadSync.balance + 1000;
            System.out.println("New balance is " + ThreadSync.balance + " for Thread " + this.t_no);
            ThreadSync.mutex = 0;
        }
        else if(this.t_no == 2)
        {
            ThreadSync.balance = ThreadSync.balance - 1000;
            System.out.println("New balance is " + ThreadSync.balance + " for Thread " + this.t_no);
            ThreadSync.mutex = 0;
        }
    }
}
