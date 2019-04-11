
import java.util.InputMismatchException;
import java.util.Scanner;


public class sample{

    /*get the size of the string right, like from before and after the decimal point.
    have a for loop that inserts into the string from the beginning, and then appends the values in the end.
    Must keep track of the number of digits in the decimal*/
    //again hardest thing is just checking 1, that we get a double. 2 that we arent handed in more than 3 decimals....

    //convert double to string? https://stackoverflow.com/questions/35611725/finding-number-of-digits-before-a-decimal-point-in-java
    //easier method is to just convert to int... then convert to string everything adter that lol


    //https://stackoverflow.com/questions/35792590/how-to-check-number-of-digits-from-bigdecimal

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double inputtedVal;
        boolean passedTryCatch = false;
        while(!passedTryCatch) {
            try {
                inputtedVal = input.nextDouble();
                System.out.println(inputtedVal);
                /*Can potentially make users only input two decimals, that way we never have to round? lol*/
                System.out.println("bujar");
                passedTryCatch = true;
            } catch (InputMismatchException e) { /* NOTE this is the type of error thrown into the compiler. */
                System.out.println("Wrong format. Try Again.");
                input.next(); /*SET US BACK TO NEW LINE SO WE AREN'T STUCK ON THAT SPECIFIC WORD.*/
                passedTryCatch = false;

            }
        }
    }

}