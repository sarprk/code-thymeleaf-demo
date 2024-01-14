package myfirst.myfirst;

import java.util.StringTokenizer;

public class TokenizerDemo {
    public static void main(String[] args)
    {
        String data = "name:rajesh;address:noida;country:india;";
        StringTokenizer st = new StringTokenizer(data, ";");

        while (st.hasMoreTokens())
        {
            System.out.println("Token: \n\t" + st.nextToken().replace(':','-'));
        }
    }
}
