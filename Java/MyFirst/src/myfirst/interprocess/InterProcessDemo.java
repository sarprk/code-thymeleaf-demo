package myfirst.interprocess;

class MyData
{
    int value;
    boolean flag = true;
    synchronized public void set(int v)
    {
        while (flag !=true)
        {
           try
           {
               wait();
           }
           catch (Exception ex )
           {
               System.out.println("Error occurred");
           }
        }
        value = v;
        flag = false;
        notify();

    }
   synchronized public  int get()
    {

        int x = 0;
        try {
            while (flag !=false) {

                wait();
            }
        } catch (Exception e) {
            System.out.println("Error occurred");
        }
        x = value;
        flag = true;
        notify();
        return x;
    }
}

class Producer extends Thread
{
    MyData myData;
    public Producer(MyData d)
    {
        myData = d;
    }
    public void run()
    {
        int count =1;
        while (true) {
            System.out.println("Producer: " + count);
            myData.set(count);

            count ++;
        }
    }
}

class Consumer extends Thread
{
    MyData myData;
    public Consumer(MyData d)
    {
        myData = d;
    }
    public void run()
    {

        while (true) {
            var data = myData.get();

            System.out.println("Consumer: "+ data);
        }
    }
}
public class InterProcessDemo {
    public static void main(String[] args){
        MyData data = new MyData();
        Producer producer = new Producer(data);
        Consumer consumer = new Consumer(data);
        producer.start();
        consumer.start();
    }
}


