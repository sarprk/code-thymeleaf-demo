package myfirst.myfirst;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args)
    {
        System.out.println("Linked list example !!");
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>(List.of(4,5,6,7));
        list.add(1);
        list.add(2);
        list.addFirst(0);
        list.addAll(list2);

        list.addFirst(-100);
        list.addLast(100);
        for(Integer num: list)
        {
            System.out.println(num);
        }
        Iterator<Integer> it = list.iterator();

        System.out.println("Printing through while loop!!");
        while (it.hasNext())
        {
        System.out.println(it.next());

        }


        System.out.println("Printing through for loop using Iterator!!");
        for(Iterator<Integer> it1 = list.iterator(); it1.hasNext();)
        {
            System.out.println(it1.next());
        }

        System.out.println("Printing through for loop using List Iterator!!");
        for(ListIterator<Integer> it1 = list.listIterator(); it1.hasNext();)
        {
            System.out.print("Has previous element: "+ it1.hasPrevious() +" : ");
            System.out.println(it1.next());

        }

        /*
        foreach loop
        * */
        System.out.println("Printing through for each loop !!");
        list.forEach(n-> System.out.println(n));

        System.out.println("Printing through for each loop ! Scope Resolution Operator!");
        list.forEach(System.out::println);

        //Calling method using forEach loop
        System.out.println("Calling method from forEach loop");
        list.forEach(n-> Show(n));

        Integer peek = list.peek();
        Integer peekFirst = list.peekFirst();
        System.out.println("Peek :" + peek);
        System.out.println("Peek First: " + peekFirst);
        System.out.println("Get first: " + list.getFirst());

        LinkedList<Integer> listDemo = new LinkedList<>();
        try {
            System.out.println("Getting getFirst: " + listDemo.getFirst());
        } catch (Exception ex) {
            System.out.println("Error -> "+ ex.getMessage());
        }
        try {
            System.out.println("Getting peekFirst: "+ listDemo.peekFirst());
        } catch (Exception ex) {
            System.out.println("Error -> "+ ex.getMessage());
        }
    }

    public static void Show(Integer num)
    {
        if(num > 5)
        {
            System.out.println("Number is greater than 5: "+num);
        }
    }
}
