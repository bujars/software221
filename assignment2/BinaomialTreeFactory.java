public final class BinaomialTreeFactory {


    /*How is the tree saved? What do we need a constructor for if T and P are passed in the next argument?
    This tree needs to be stored somehow???*/

    /*Saving these variable so they are perminant.*/
    /*private int T;
    private int P;
    private Node tree;

    public BinaomialTreeFactory(int T, int P){
        this.depth = depth;
        this.tree = create()
    }*/

    /*Most current update. Ignore the above.  I did some googling and found out that what I am doing is called Factory
    Method Pattern, where instead of using a construcotr, we just have a stait c function that performs everything that
    I need it to. With that said, we only need to return a node from this class, because a tree is just a node??????
    noooooo idk this might also need to implement iterator functions. */


    private Node root; //no becuse how do we traverse it? Navigate???? Where do the go left/go right functions go????
    private int depth;
    private int percentage;


    // I think they just go in navigate??


    public BinaomialTreeFactory(int T, int P){
        this.depth = T;
        this.percentage = P;
    }

    public void createTree(){
        root = create(depth, percentage);
    }

    public Node getRoot(){
        return this.root;
    }

    public void setRoot(Node root){
        this.root = root;
    }



    /*This is the recursive function that creates the node????*/
    public static Node create(int T, int P){
        if(T == 0) {
            return new Node(null, null, null, P);
        } else {
            T--; /*Decrement T*/
            Node leftNode = create(T, P);
            Node rightNode = create(T, P);
            return new Node(leftNode, rightNode, null, P);
        }
    }




}