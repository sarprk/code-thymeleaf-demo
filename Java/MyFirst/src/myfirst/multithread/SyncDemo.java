package myfirst.multithread;

class MyData
{

    public void display(String data)
    {
        synchronized (this) {
            for (int i = 0; i < data.length(); i++) {
                System.out.print(data.charAt(i));
            }
        }
    }
}

class SyncDemo1 extends Thread
{
    MyData myData;
    public SyncDemo1(MyData d)
    {
        myData = d;
    }
    public void run()
    {
        myData.display("Demo1 Demo1 Demo1 ");
    }
}

class SyncDemo2 extends Thread
{
    MyData myData;
    public SyncDemo2(MyData d)
    {
        myData = d;
    }
    public void run()
    {
        myData.display("Sync Demo2");
    }
}
public class SyncDemo {
    public static void main(String[] args){
        SyncDemo1 demo1 = new SyncDemo1(new MyData());
        SyncDemo2 demo2 = new SyncDemo2(new MyData());
        demo1.start();
        demo2.start();
    }
}
