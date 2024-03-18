public class BSTNode {
    //declaring local instance variables
        Record item = null;

    //Constructor method of the BSTNode object
        public BSTNode(Record item){
            this.item = item;
        }
    
    //Accessor method to the item instance variable
        public Record getRecord(){
            return item;
        }
    
    //Accessor method that stores a given record in a BSTNode object
        public void setRecord(Record d){
            item = d;
        }

    //
        public BSTNode getLeftChild(){

        }

    //
        public BSTNode getRightNote(){

        }

    //
        public BSTNode getParent(){

        }
    //
        public void setLeftChild(BSTNode u){

        }

    //
        public void setRightChild(BSTNode u){

        }

    //
        public void setParent(BSTNode u){

        }

    //
        public boolean isLeaf(){
            return false;
        }

}
