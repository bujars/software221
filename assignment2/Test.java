import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //System.out.println("HI");
        //String text = input.nextLine();
       // System.out.println(text);
        System.out.println("Please enter the depth of the tree");
        int depth = input.nextInt();
        System.out.println("Please enter the percentage of the tree");
        int percent = input.nextInt();
        System.out.println("Please enter the number of times to interate in the tree");
        int iteration = input.nextInt();

        System.out.println("One moment please.\n");

        Node tree = BinaomialTreeFactory.create(depth, percent);

        Navigator nav = new Navigator();
        nav.navigate(tree, iteration);



        //Node n = new Node(null, null, null, p);
        //BinaomialTreeFactory b = new BinaomialTreeFactory();
        //Node j = b.create(2, 2); /*Figure out if this is what we want to happen.....*/


        //System.out.println(n.getUpChild());  /*Note may need to make to string method. */
        //System.out.println(n.getPercentVal());
        //System.out.println("\n");
        //System.out.println(j.getUpChild().getPercentVal());  /*Note may need to make to string method. */
        //System.out.println(j.getPercentVal());




    }
}