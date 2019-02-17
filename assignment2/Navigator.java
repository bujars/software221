import java.util.Random;
import java.security.SecureRandom;


public class Navigator {

    private int iterations; /*Mod this by the depth of the tree to see how many times it loops around.*/
    private int depth;
    private int percentage;

    public Navigator(int depth, int percentage, int iterations) {
        this.iterations = iterations;
        this.depth = depth;
        this.percentage = percentage;
    }

    public int getIterations() {
        return this.iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }


    /*This function is used to create a tree, navigate through the tree, and etc...*/
    public void navigate() {
        BinaomialTreeFactory tree = new BinaomialTreeFactory(depth,percentage);
        tree.createTree();
        //Node root = tree.create(depth, percentage);
        Node originalRoot = tree.getRoot();
        int tempIterations = iterations;
        while (tempIterations > 0) {
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
        }

    }
}
