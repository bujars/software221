import java.util.Random;
import java.security.SecureRandom;


public class Navigator {


    public void navigate(Node tree, int iterations) {
        Node treeTraverse = tree; /*This will be used to go back and fourth.*/

        int time = 1;
        for(int i = 0; i < iterations; i++){
            while(treeTraverse!=null){ /*NOTE THIS ends before end.*/
                SecureRandom random = new SecureRandom();
                int rand = random.nextInt(101);
                if((tree.getUpChild()).getPercentVal() <= rand){ /*NOTE I made the option to do greater or equal to*/
                    treeTraverse = treeTraverse.getUpChild();
                    System.out.println("Time: " + time + ". Percent: " + rand + ". Direction: Up.");
                }
                else{
                    treeTraverse = treeTraverse.getDownChild();
                    System.out.println("Time: " + time + ". Percent: " + rand + ". Direction: Down.");
                }
                time++;
            }
            time = 1;
            treeTraverse = tree;
            System.out.println("\n");

        }



        /* NOTE the below code is my original solution, but Professor wanted me to do it his way.  */
        /*while (tempIterations > 0) {
            System.out.print("First Iteration ");
            for (int i = 0; i <= depth; i++) {
                SecureRandom random = new SecureRandom();
                int rand = random.nextInt(101);
                if (rand >= percentage) {
                    tree.setRoot((tree.getRoot()).getUpChild());
                    System.out.println("Percent: " + rand + ". Direction: Up.");
                } else {
                    //tree.setRoot((tree.getRoot()).getDownChild());
                    System.out.println("Percent: " + rand + ". Direction: Down.");
                }

            }
            tree.setRoot(originalRoot);
            tempIterations--;
            System.out.println("\n");
        }*/

    }
}
