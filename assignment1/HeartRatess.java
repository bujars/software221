import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class HeartRatess
{
    private String firstName;
    private String lastName;
    private int month;
    private int day;
    private int year;
    //private int age;

    public HeartRatess(String firstName, String lastName, int month, int day, int year){//, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.month = month;
        this.day = day;
        this.year = year;
        //this.age = age;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName() { return this.lastName; }

    public void setLastName(String lastName){ this.lastName = lastName; }

    public String getFullName(){ return this.firstName + " " + this.lastName; }

    public void setFullName(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int maximimHeartRate(){
        return (220 - age());
    }

    public String getBirhDate(){
        return month + "/" + day + "/" + year;
    }

    public void setBirthDate(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /*Ignore this comment below as I figured a simple fix to my original problem.*/
    /*PLease note, this gets a rough estimation of a persons age, only off of years. It can be off by 1 year depending on when the persons birthday falls...*/
    public int age(){
        //To calculate age,
        //First convert age
        int age = 2019-this.year;
        if(!(this.month <= 2 && this.day<=3)){ /*Note birthday is calculated based on today's date*/
            age--; /*If the person's birtdhay was not before or on today, subtract 1 because I overcaluclated */
        }

        return age;
    }

    /*Note the book says to return the range. I will return it as a string sentence*/
    public String targetHeartRateRange(){
        double lowerBound = maximimHeartRate()*.5;
        double higherBound = maximimHeartRate()*.85;
        return "The target heart rate is between " + lowerBound + " - " + higherBound + ".";
    }


    public boolean checkDay(int month, int day){
        if(day < 1 || day > 31){
            return false;
        }
        if(month == 2){
            if(day <= 29) {
                return true;
            }
            else{
                return false;
            }
        }
        else if((month == 4 || month == 6 || month == 9 || month == 11)){
            if(day <=30){
                return true;
            }
            return false;
        }
        else{
            return true;
        }
    }


    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Hello and welcome to my Heart Rate Calculator");
        String firstName = JOptionPane.showInputDialog("Let us begin by getting your first name. Please enter your first name: ");
        //String message = String.format("Welcome, %s, to Java!", firstName);
        String lastName = JOptionPane.showInputDialog("Thank You. Now, please enter your last name: ");
        //int month = Integer.parseInt(JOptionPane.showInputDialog("Thank You. Now, please enter the month that you were born in, in the form of an integer: "));

        String[] possibilities = {"01", "02", "03", "04","05","06","07","08","09","10","11","12"};
        String monthString = (JOptionPane.showInputDialog(
                null, "Enter your month\n"  + "",
                "Month",  JOptionPane.PLAIN_MESSAGE,  null, possibilities, "month")).toString();

        //If a string was returned, say so.
       /* if ((s != null) && (s.length() > 0)) {
            setLabel("Green eggs and... " + s + "!");
            return;
        }*/
        int month = Integer.parseInt(monthString);

        String[] possibilities31 = {"01", "02", "03", "04","05","06","07","08","09","10","11","12", "13", "14", "15", "16", "17","18","19","20","21","22","23","24","25","26","27","28","29","30", "31"};
        String[] possibilities30 = {"01", "02", "03", "04","05","06","07","08","09","10","11","12", "13", "14", "15", "16", "17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
        String[] possibilities28 = {"01", "02", "03", "04","05","06","07","08","09","10","11","12", "13", "14", "15", "16", "17","18","19","20","21","22","23","24","25","26","27","28"};

        String dayString = "";
        if((month == 4 || month == 6 || month == 9 || month == 11)) {
            dayString = (JOptionPane.showInputDialog(null, "Enter your day\n"  + "", "Day",  JOptionPane.PLAIN_MESSAGE,  null, possibilities30, "Day")).toString();

        }
        else if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month==12)){
            dayString = (JOptionPane.showInputDialog(null, "Enter your day\n"  + "", "Day",  JOptionPane.PLAIN_MESSAGE,  null, possibilities31, "Day")).toString();

        } else if(month ==2){
            dayString = (JOptionPane.showInputDialog(null, "Enter your day\n"  + "", "Day",  JOptionPane.PLAIN_MESSAGE,  null, possibilities28, "Day")).toString();
        }

        int day = Integer.parseInt(dayString);

        String[] yearPossibiliites = new String[2020];
        int j = 0;
        for(int i = 2019; i > 0; i--){
            yearPossibiliites[j] = "" + i;
            j++;
        }

        String yearString = (JOptionPane.showInputDialog(null, "Enter your year\n"  + "", "Year",  JOptionPane.PLAIN_MESSAGE,  null, yearPossibiliites, "Year")).toString();
        int year = Integer.parseInt(yearString);

        JOptionPane.showMessageDialog(null, "Thank You for this information. I will now calculate everything. Please give me a moment.");

        //System.out.println("Thank You for this information. I will now calculate everything. Please give me a moment.");

        HeartRatess person = new HeartRatess(firstName, lastName, month, day, year);


        String sol=  ("Thank you again, " + person.getFullName() +". Your age is, " + person.age() + ". " + "Your maximum heart rate is: " + person.maximimHeartRate() + ".") + (" Now: " + person.targetHeartRateRange()+ "\nThanks for using the calculator!");
        JOptionPane.showMessageDialog(null, sol);



        /*NOTE that the dialogue box handles not having to check this. */
        /*while(!(month > 0 && month < 13)){
            month = Integer.parseInt(JOptionPane.showInputDialog("This is an invalid month. Please enter the month that you were born in, in the form of an integer: "));
            //month = input.nextInt();
        }*/

        /*System.out.println("Hello World");*/


        /* Need while loops to check that we are entering correct information, else we need to give out error statements.
        Note this is just a personal preference, because I could have made functions specifically that hndle this
        and print out themselves. */
        /*Also, note, I am not sure how exact the above is supposed to be.*/

        /*
        System.out.println("Hello, and welcome to my Heart Rate Calculator.\n");
        System.out.println("Let us begin by getting your first name. Please enter your first name: ");
        Scanner input = new Scanner(System.in);
        String firstName = input.nextLine();
        System.out.println("Thank You. Now, please enter your last name: ");
        String lastName=input.nextLine();
        System.out.println("Thank You. Now, please enter the month that you were born in, in the form of an integer: ");
        int month = input.nextInt();
        while(!(month > 0 && month < 13)){
            System.out.println("This is an invalid month. Please enter the month that you were born in, in the form of an integer: ");
            month = input.nextInt();
        }
        System.out.println("Thank You. Now, please enter the day that you were born in: ");
        int day = input.nextInt();
        boolean checkDay = false;
        while(!checkDay){
            if(day < 1 || day > 31){
                checkDay = false;
            }
            else if(month == 2){
                if(day <= 29) {
                    checkDay = true;
                }
                else{
                    checkDay = false;
                }
            }
            else if((month == 4 || month == 6 || month == 9 || month == 11)){
                if(day <=30){
                    checkDay = true;
                }
                checkDay = false;
            }
            else if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month==12)){
                if(day <= 31){
                    checkDay = true;
                }
            }
            if(!checkDay){
                System.out.println("This is an invalid day. Please enter the day that you were born in: ");
                day = input.nextInt();
            }
        }
        System.out.println("Thank You. Now, please enter in the year in which you were born: ");
        int year = input.nextInt();
        while(!(year > 0 && year < 2020)){
            System.out.println("Invalid year. Please enter in the year in which you were born: ");
            year = input.nextInt();
        }

        System.out.println("Thank You for this information. I will now calculate everything. Please give me a moment.");

        HeartRatess person = new HeartRatess(firstName, lastName, month, day, year);
        System.out.println("Thank you again, " + person.getFullName() +". Your age is, " + person.age() + ". " + "Your maximum heart rate is: " + person.maximimHeartRate() + ".");
        System.out.println("Now: " + person.targetHeartRateRange()+ "\nThanks for using the calculator!");

        */


        /* HeartRates person1 = new HeartRates("bujar", "sefa", 8, 20, 1999);
        System.out.println(person1.age() + " " + person1.maximimHeartRate() + " " + person1.targetHeartRateRange());*/
    }


}