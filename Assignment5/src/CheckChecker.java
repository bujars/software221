
import java.util.InputMismatchException;
import java.util.Scanner;

/* Maybe useful resource. */



public class CheckChecker{

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
                System.out.println("Please input the value that you want represented as a check.");
                inputtedVal = input.nextDouble();
                /*String s = ""+inputtedVal;*/
                StringBuilder val = new StringBuilder(""+inputtedVal);

                /*NOTE might need to just get everything after the decimal, and then */
                int decimalPos = val.indexOf(".");
                if(!(val.length() <= decimalPos+3) || decimalPos==-1) { //Index + 1 for length
                    throw new InputMismatchException("Small Length");
                }
                StringBuilder valAfDec = new StringBuilder(val.substring(decimalPos));
                StringBuilder valBefDec = new StringBuilder(val.substring(0, decimalPos));

                if(valAfDec.length() < 3){
                    valAfDec.append("0");
                }
                int digitLength = valBefDec.length()+valAfDec.length();



                if(digitLength > 9){
                    throw new NumberFormatException("");
                }



                String astriks = "*********";

                String output = astriks.substring(0, 9-digitLength) + valBefDec + valAfDec;

                System.out.println(val);
                System.out.println(valAfDec);
                System.out.println(valBefDec);
                /*Can potentially make users only input two decimals, that way we never have to round? lol*/
                System.out.println("bujar");
                System.out.println("/n");
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