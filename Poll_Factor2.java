import java.math.BigInteger;

/**
 * Created by junes on 01.12.16.
 */
public class Poll_Factor2 {

    BigInteger TWO = BigInteger.valueOf(2);
    BigInteger FOUR = BigInteger.valueOf(4);
    BigInteger SIX = BigInteger.valueOf(2);


    k_ary_gcd k_ary_gcd = new k_ary_gcd();


    BigInteger find_prime_pollard2(BigInteger mNumber) {

        if (Miller_test.isProbablePrime(mNumber, 5)) {
            System.out.println(mNumber + "\n" + "Number is prime");
            return mNumber;
        }

        Integer b1 = 10;
        Integer b2 = 50;

        Integer q[] = {2, 3, 5, 7};
        Integer p[] = {13, 17, 19, 23, 29, 31, 37, 41, 43, 47};




        BigInteger mas_exp[] = {BigInteger.valueOf(8),
                BigInteger.valueOf(9),
                BigInteger.valueOf(5),
                BigInteger.valueOf(7),
        };


        BigInteger gcd = BigInteger.ONE;
        BigInteger a = TWO;

        Boolean b = true;

            for (  int i = 0; i < q.length  && b ; i++) {

                a = a.modPow(mas_exp[i], mNumber);

               gcd = a.subtract(BigInteger.ONE).gcd(mNumber);
               // gcd = k_ary_gcd.find_k_ary_gcd( a.subtract(BigInteger.ONE),(mNumber));

                if(!gcd.equals(BigInteger.ONE)){
                     b = false;
                    System.out.println(" >> First stage done");
                    //System.out.println(gcd);

                    System.out.println(gcd);
                    find_prime_pollard2(mNumber.divide(gcd));
                    return gcd;
                }

            }

       // gcd = a.subtract(BigInteger.ONE).gcd(mNumber);



       /* if(!gcd.equals(BigInteger.ONE)){
            //System.out.println(" >> First stage done");
            //System.out.println(gcd);
            find_prime_pollard2(mNumber.divide(gcd));
        }*/



            System.out.println(" >> Go to second stage");

            BigInteger aa = a;        // the last gcd

            BigInteger mas_differ_p [] = { TWO , FOUR , TWO , FOUR , SIX , TWO , SIX , FOUR , TWO , FOUR };


            a = a.modPow(BigInteger.valueOf(11),mNumber);

            BigInteger pp = BigInteger.ONE;

            int i = 0;

          do{

               a = a.multiply(aa.modPow(mas_differ_p[i],mNumber)).mod(mNumber);
               pp = pp.multiply(a.subtract(BigInteger.ONE)).mod(mNumber);

             gcd = pp.gcd(mNumber);
           //gcd = k_ary_gcd.find_k_ary_gcd(pp,mNumber);

           }while (gcd.equals(BigInteger.ONE));


            System.out.println(gcd);
            find_prime_pollard2(mNumber.divide(gcd));



        return a;



    }

}
