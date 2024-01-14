package myfirst.myfirst;

import java.util.ArrayDeque;

public class DoublyArrayExample {
    public static void main(String[] args)
    {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(10);
        dq.offerLast(11);
        dq.offerLast(12);
        dq.offerLast(13);
        dq.offerLast(14);

        dq.offerFirst(1);
        dq.offerFirst(2);
        dq.offerFirst(3);
        dq.offerFirst(4);
        dq.offerFirst(5);

        dq.pollFirst();
        System.out.println("Printing Array Deque Element");
        for(Integer n: dq)
        {
            System.out.println(n);
        }
    }
}
