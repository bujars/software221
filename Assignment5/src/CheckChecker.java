
import java.util.InputMismatchException;
import java.util.Scanner;



public class CheckChecker{


    /* Just my thought process */
    /*get the size of the string right, like from before and after the decimal point.
    have a for loop that inserts into the string from the beginning, and then appends the values in the end.
    Must keep track of the number of digits in the decimal*/
    //again hardest thing is just checking 1, that we get a double. 2 that we arent handed in more than 3 decimals....

    //convert double to string?
    //easier method is to just convert to int... then convert to string everything adter that lol


    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        double inputtedVal;
        boolean passedTryCatch = false;
        while(!passedTryCatch) {
            /*Try block checks if we give in a double and if the value meets the other requirements*/
            try {
                System.out.println("Please input the value that you want represented as a check.");
                inputtedVal = input.nextDouble();

                /*Store our value into a StringBuilder*/
                StringBuilder val = new StringBuilder(""+inputtedVal);

                /*This makes sure we have a decimal, and if not, then user must input a new value*/
                int decimalPos = val.indexOf(".");
                if(!(val.length() <= decimalPos+3) || decimalPos==-1) { //Index + 1 for length
                    throw new InputMismatchException("Small Length");
                }
                StringBuilder valAfDec = new StringBuilder(val.substring(decimalPos));
                StringBuilder valBefDec = new StringBuilder(val.substring(0, decimalPos));

                /*Make sure we dont have more than two decimal points, User should be expected to round.*/
                if(valAfDec.length() < 3){
                    valAfDec.append("0");
                }
                int digitLength = valBefDec.length()+valAfDec.length();


                /*WE want to make sure no one outputs a big value.*/
                if(digitLength > 9){
                    throw new NumberFormatException("");
                }



                String astriks = "*********";

                String output = astriks.substring(0, 9-digitLength) + valBefDec + valAfDec;

                /* Testing print statements
                System.out.println(val);

                System.out.println(valAfDec);
                System.out.println(valBefDec);
                System.out.println("bujar");
                System.out.println("/n");*/
                System.out.println(output);

                passedTryCatch = true;
            } catch (NumberFormatException | InputMismatchException e) { /* NOTE this is the type of error thrown into the compiler. */

                //input.next();
                System.out.println("Wrong format. Try Again. ");
                input.nextLine();
                //System.out.println("Write Message. ");/*SET US BACK TO NEW LINE SO WE AREN'T STUCK ON THAT SPECIFIC WORD.*/
                //passedTryCatch = false;

            }
        }


    }

}