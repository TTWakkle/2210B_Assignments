public class BSTNode {
    //declaring local instance variables
        private Record item = null;
        private BSTNode parentNode;
        private BSTNode leftChild, rightChild;

    //Constructor method of the BSTNode object
        public BSTNode(Record item){
            this.item = item;
            parentNode = null;
            leftChild = null;
            rightChild = null;
        }
    
    //Accessor method to the item instance variable
        public Record getRecord(){
            return item;
        }
    
    //Accessor method that stores a given record in a BSTNode object
        public void setRecord(Record d){
            item = d;
        }

    //Accessor method that returns the left BSTN child of the current BSTN
        public BSTNode getLeftChild(){
            return leftChild;
        }

    //Accessor method that returns the right BSTN child of the current BSTN
        public BSTNode getRightChild(){
            return rightChild;
        }

    //Accessor method that returns the parent BSTN of the current BSTN
        public BSTNode getParent(){
            return parentNode;
        }
    
    //setter method that defines the left child of the current BSTN 
        public void setLeftChild(BSTNode u){
            leftChild = u;
            leftChild.setParent(u);
        }

    //setter method that defines the right child of the current BSTN
        public void setRightChild(BSTNode u){
            rightChild = u;
            rightChild.setParent(u);
        }

    //setter method that defines the parent of the current BSTN
        public void setParent(BSTNode u){
            parentNode = u;
        }

    //Helper method that checks if a node is a leaf or not. ie, if both its children are null.
        public boolean isLeaf(){
            return (leftChild == null && rightChild == null);
        }

}
