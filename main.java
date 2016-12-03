import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by junes on 01.12.16.
 */
public class main {

    public static void main(String[] args) {


        System.out.println("Enter number : ");
        Scanner scan= new Scanner(System.in);



        BigInteger mNum = scan.nextBigInteger();



        if (mNum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            int exp_of_2 = 0;
            while (mNum.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                mNum = mNum.divide(BigInteger.valueOf(2));
                exp_of_2++;
            }
            System.out.println("2^" + exp_of_2);
        }




        Poll_Factor2 PF = new Poll_Factor2();
        PF.find_prime_pollard2(mNum);

        //55899625488530333221530


    }
}
