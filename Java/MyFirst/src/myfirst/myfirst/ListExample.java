package myfirst.myfirst;
import java.util.*;
public class ListExample {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(List.of(4,5,6,7));
        list.add(1);
        list.addFirst(0);
        list.addAll(list2);

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
    }

    public static void Show(Integer num)
    {
        if(num > 3)
        {
            System.out.println("Number is greater than 3: "+num);
        }
    }
}
