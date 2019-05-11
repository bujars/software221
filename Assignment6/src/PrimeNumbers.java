
import java.util.*;

class PrimeNumbers {

    /** Notice the function must be static because value from main is static,
     * and thus this cannot be non-static because the compiler will not know which one to do.*/
    public static Set<Integer> primeFactorization(int number) {
        /** GO through each number n-1 to 2 and if it divides by something, then it means its not prime :(
         * THen, you must add it to the set which will be returned. */

        Set<Integer> primeFactors = new TreeSet<>();
        for(int i = number-1; i > 1; i--) {
            if(number%i == 0){
                primeFactors.add(i);
            }
        }
        return primeFactors;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Prime Numbers. Please enter a positive Integer. \nIf the number is not prime, you will get the unique factorization.");
        boolean val = true;

        while(val) {
            try {
                int value = input.nextInt();
                if (value <= 0) {
                    throw new InputMismatchException("Can't be - or 0.");
                }
                Set<Integer> primeFactors = primeFactorization(value);
                Iterator<Integer> integerIterator = primeFactors.iterator();

                StringBuilder primeFacs = new StringBuilder();

                while (integerIterator.hasNext()) {
                    primeFacs.append(integerIterator.next() + ", ");
                }


                String formattedStatement = "unique prime factorization other than 1 and " + value;
                if (value == 1) {
                    formattedStatement = "unique prime factorization other than 1";
                }


                if (primeFacs.length() == 0) {
                    System.out.println("Hooray! This is a Prime Number! There is no " + formattedStatement + ".");
                } else {
                    System.out.println("The Factors of this Non-Prime Number other than the " + formattedStatement + "\n are: " + primeFacs.substring(0,primeFacs.length()-2)+".");
                }

                val = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong format. By definition, \nPrime numbers are those natural numbers that are divisible solely by the unity (1) and themselves.\nPlease enter a positive Integer Number.");
                input.nextLine();
            }
        }
    }
}