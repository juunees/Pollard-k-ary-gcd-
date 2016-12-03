import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by junes on 02.12.16.
 */
public class k_ary_gcd {

    BigInteger k = BigInteger.valueOf(7);
    Integer kk = 7;

    int x[] = {0, 1, 2, 3, 4, 5, 6};
    Integer I [] = {1, -3, -2, 2, 3, -1};
    int A [] = {1, 1, 2, 2, 1, 1};
    int G[] = {7, 1, 1, 1, 1, 1, 1};
    int P [] = {2, 3, 7};




     BigInteger find_k_ary_gcd(BigInteger u, BigInteger v){

         BigInteger g = BigInteger.ONE;
         ///////////////////  попытка найти делитель из массива P

         for(int i =0; i < P.length; i++){
             BigInteger d = BigInteger.valueOf( P[i]);

             if(u.mod(d).equals(BigInteger.ZERO)&&v.mod(d).equals(BigInteger.ZERO)){

                 u =  u.divide(d);
                 v =  v.divide(d);
                 g = g.multiply(d);
                 break;

             }
             else continue;
         }

         //System.out.println(">> Try g : " + g);
       /////////////////////////

        if(g.equals(BigInteger.ONE))

        {
            Integer t = 1;
            BigInteger u_temp;
            BigInteger v_temp;

            while (!u.equals(BigInteger.ZERO) && !v.equals(BigInteger.ZERO)) {

                if (u.equals(k)) {
                    u = BigInteger.ONE;
                }
                if (v.equals(k)) {
                    v = BigInteger.ONE;
                }

                u_temp = u.mod(k);
                v_temp = v.mod(k);

                if (u_temp.gcd(k).compareTo(BigInteger.ONE) > 0) {
                    u = u.divide(u_temp.gcd(k));
                }
                else
                    if (v_temp.gcd(k).compareTo(BigInteger.ONE) > 0) {
                    v = v.divide(v_temp.gcd(k));
                } else {

                    // до сюда дойду только u и v < k

                    Integer uu = u_temp.intValue();
                    Integer vv = v_temp.intValue();

                    Integer u_base = u.intValue();
                    Integer v_base = v.intValue();

                  //  System.out.println("uu = " + uu + "  vv = " + vv);

                    Integer x = (uu * I[vv - 1]) % kk;

                    Integer a = A[Math.abs(x) - 1];
                    Integer b = -(a * x) % kk;

                   // System.out.println("x = " + x + "  a = " + a + "  b = " + b);

                    t = (Math.abs(a * u_base + b * v_base)) / kk;

                    if(u.equals(t)&&v.equals(t)){

                    }

                   // System.out.println("t = " + t);

                    if (u.compareTo(v) > 0) {
                        u = BigInteger.valueOf(t);
                    } else {
                        v = BigInteger.valueOf(t);
                    }

                  //  System.out.println("u = " + u + "  v = " + v);


                }


            } // одно из v или u стало = 0

            BigInteger tt;

            if (v.equals(BigInteger.ZERO)) {
                tt = u;
            } else {
                tt = v;
            }


            for (int i = 0; i < P.length; i++) {

                BigInteger d = BigInteger.valueOf(P[i]);
                if (tt.mod(d).equals(BigInteger.ZERO)) {
                    tt = tt.divide(d);
                }
            }


            g = tt.multiply(g);


           // System.out.println(">> FINAL g = " + g);


        }
        else {

           // System.out.println(">> FINAL g = " + g);

        }

        return g;

     }


     public static void main(String [] args){

         k_ary_gcd k_ary_gcd = new k_ary_gcd();

         System.out.println("Enter number1 : ");
         Scanner scan1= new Scanner(System.in);
         BigInteger mNum1 = scan1.nextBigInteger();

         System.out.println("Enter number2 : ");
         Scanner scan2= new Scanner(System.in);


         BigInteger mNum2 = scan2.nextBigInteger();

         k_ary_gcd.find_k_ary_gcd(mNum1,mNum2);

     }


}
