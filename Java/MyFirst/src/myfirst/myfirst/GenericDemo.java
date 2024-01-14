package myfirst.myfirst;

import java.util.ArrayList;
import java.util.Objects;

class MyArray<T extends Number>
{
    ArrayList<T> list = new ArrayList<>();
    public void addValue(T number)
    {
        list.add(number);
    }
    public  void display()
    {
        for (T x: list){
            System.out.println(x);
        }
    }
}
public class GenericDemo {
    public  static void main(String[] args)
    {
        System.out.println("This is generic number demo");
        MyArray<Integer> myArray = new MyArray<>();
        myArray.addValue(10);
        myArray.addValue(11);
        myArray.addValue(12);
        myArray.addValue(13);

        //myArray.display();

//        System.out.println();
//        System.out.println("Generic method demo");
//        show(new String[]{"This", " is", " show ", " test ", " method"});
//        show(new Integer[]{10, 20, 30, 40, 50});
//
//        System.out.println();
//        System.out.println("Generic Variable arguments demo");
//        display("This", " is", " show ", " test ", " method");
//        display(10, 20, 30, 40, 50);

        inform(myArray);
    }
    //This is wild card generic. Also, called unbounded generic class
    static void inform(MyArray<?> list)
    {
        list.display();
    }
    static <T> void show(T[] list)
    {
        for (T x: list)
        {
            System.out.println(x);
        }
    }

    static <T> void display(T... list)
    {
        for (T x: list)
        {
            System.out.println(x);
        }
    }
}
