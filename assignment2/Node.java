public class Node {

    private Node downChild;
    private Node upChild;
    private Node parent;
    private double percentVal;

    /*

    public Node(){
        this.downChild = NULL;
        this.upChild = NULL;
        this.parent = NULL;
        this.percentVal = 0.5;
    }
*/
    public Node(Node downChild, Node upChild, Node parent, double percentVal){
        this.downChild = downChild;
        this.upChild = upChild;
        this.parent = parent;
        this.percentVal = percentVal;
    }

    public Node getDownChild(){
        return downChild;
    }

    public Node getUpChild(){
        return upChild;
    }

    public Node getParent(){
        return parent;
    }

    public double getPercentVal(){
	    return percentVal;
    }

    public void setDownChild(Node downChild){
        this.downChild = downChild;
    }

    public void setUpChild(Node upChild){
        this.upChild = upChild;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public void setPrecentVal(double precentVal){
        this.percentVal = percentVal;
    }


}

/*Recursive function that is run n times and bascially creates a new node one it gets to 0000000000,
*
*   store price as a instance variable
*
*
*  return NODE createTree(depth){
*       if(depth = 1){
*            return NOde(NULL, NULL, NULL, percentVal);
*       }
*       Node left = createTree(depth--);
*       Node Right = create Tree(depth --);
*
*       return (left, right, NULL, price)
*  }
*
*
*
* */
