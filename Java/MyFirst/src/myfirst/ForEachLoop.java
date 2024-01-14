package myfirst;
import java.util.Scanner;

public class ForEachLoop {
    public  static  void  main(String[] args)
    {
        System.out.println("Enter target: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int  arr[] = {1,2,4};
        for(int a: arr)
        {
            System.out.println("Array: "+a);
        }
        for(int i = 1; i<=target ;i++)
        {
            System.out.print(i*5);
            System.out.print(" ");
        }
        System.out.println("Program finished");
    }
}
