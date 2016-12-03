import java.math.BigInteger;

/**
 * Created by junes on 01.12.16.
 */
public class Poll_Factor {

    BigInteger TWO = BigInteger.valueOf(2);


    BigInteger find_prime_pollard(BigInteger mNumber){

       if(Miller_test.isProbablePrime(mNumber,5)) {System.out.print(mNumber+"\n"+"Number is prime"); return mNumber;}

       // if(PrimeCheck.is_prime(mNumber)) {System.out.print(mNumber+"\n"+"Number is prime"); return mNumber;}

        BigInteger a = TWO;
        BigInteger div = BigInteger.ONE;
        BigInteger div_subtract_one = BigInteger.ONE;
        int r = 3;
        BigInteger exponent = BigInteger.valueOf(2);

        BigInteger gcd = a.gcd(mNumber);

        if(gcd.compareTo(BigInteger.ONE)>0){
            return gcd;
        }

        do{

            div = a.modPow(exponent,mNumber);

            exponent = exponent.multiply(BigInteger.valueOf(r));
            r++;
            //div = a.modPow(exponent.subtract(BigInteger.ONE),mNumber);
            div_subtract_one = div.subtract(BigInteger.ONE);

            if(div_subtract_one.equals(mNumber)){a = Miller_test.uniformRandom(TWO,mNumber.subtract(BigInteger.ONE));}

            gcd = div_subtract_one.gcd(mNumber);
        }

        while(gcd.equals(BigInteger.ONE));

        System.out.println(gcd);


        // рекурсивно вызываем следующие делители

        find_prime_pollard(mNumber.divide(gcd));
        return div;


    }

}
