package myfirst.multithread;

class MyThread extends Thread
{
    public void run()
    {
        int i = 1;
        while (true)
        {
            System.out.println(i + ": Hello");
            i++;
        }
    }
}
public class MultithreadDemo {
public static void main(String[] args)
{
    MyThread mt = new MyThread();
    mt.start();

}
}
