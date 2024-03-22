public class BinarySearchTree {
    //declaring local instance variables
        BSTNode rootNode;

    //Constructor class of the BST object, This creates a null node and sets it as the root, defining an 'empty' BST
        public BinarySearchTree(){
            rootNode = null;
        }
    
    //Accessor method that returns the root node of a BST
        public BSTNode getRoot(){
            return rootNode;
        }
    
    //Accessor method that searches through a BST for where an item could be stored, will return an empty node, or a leaf's child, if the item does not exist  
        public BSTNode get(BSTNode r, Key k){
            if(rootNode ==  null)
                return null;
            if (r.isLeaf())
                return r;
            else{
                if (r.getRecord().getKey() == k)
                    return r;
                else if (Integer.parseInt(r.getRecord().getKey().getLabel()) < Integer.parseInt(k.getLabel())) /*TODO: i have zero clue how they're meant to be ordered in the BST, TALK TO SOMEONE!! */
                    return get(r.getRightChild(), k);
                else
                    return get(r.getLeftChild(), k);
            }

        }

    //This function inserts a node into the tree, utilizing the get() function to determine where it exists
        public boolean insert (BSTNode r, Key k){
            //checking whether the tree is empty or not
                if (rootNode == null){
                    rootNode = r;
                    return true;
                }
            //inserting based on where get() dictates a node should be placed
                BSTNode p = new BSTNode(null);
                p = get(r, k);
                
                if (!p.isLeaf())
                    return false; //OR throw new DictionaryException("Item already exists in BST")
                else{
                    p.setRecord(r.getRecord());
                    p.setLeftChild(new BSTNode(null));
                    p.setRightChild(new BSTNode(null));
                    return true;
                }
        }   
    
    //Accessor method that removes an item from the BST
        public void remove(BSTNode r, Key k) throws DictionaryException{
            BSTNode p = new BSTNode(null);
            p = get(r, k);
            if(p.isLeaf())
                throw new DictionaryException("item does not exist in BST");
            else {
                BSTNode c = new BSTNode(null);
                BSTNode pp = new BSTNode(null);
                if (p.getLeftChild().isLeaf()){
                    c = p.getRightChild();
                    pp = p.getParent();
                    if(pp != null) {
                        if(Integer.parseInt(pp.getRecord().getKey().getLabel()) < Integer.parseInt(c.getRecord().getKey().getLabel()))    //TODO: i have no idea which child c should be
                            pp.setRightChild(c);
                        else
                            pp.setLeftChild(c);
                    }
                    else
                        rootNode = c;
                    return; // die die die
                }
                else if(p.getRightChild().isLeaf()){
                    c = p.getLeftChild();
                    pp = p.getParent();
                    if(pp != null){
                        if(Integer.parseInt(pp.getRecord().getKey().getLabel()) < Integer.parseInt(c.getRecord().getKey().getLabel()))  //kill me please
                            pp.setRightChild(c);
                        else
                            pp.setLeftChild(c);
                    }    
                    else
                        rootNode = c;
                }
                else{
                    BSTNode s = new BSTNode(null);
                    s = smallest(p.getRightChild());
                    p.setRecord(s.getRecord());
                    remove(s, s.getRecord().getKey());
                }
            }


        }

    //
        public BSTNode successor(BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(r, k);
            if(!p.getRightChild().isLeaf())
                return smallest(p.getRightChild());
            else {
                p = p.getParent();
                while (p != null && Integer.parseInt(p.getRecord().getKey().getLabel()) < Integer.parseInt(k.getLabel())/*TODO: figure out how theyre actually being inserted and arranged into the BST, cuz its not based on type.*/){
                    p = p.getParent();
                }
                return p;
            }
        }
    
    //
        public BSTNode predecessor(BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(r, k);
            if(!p.getLeftChild().isLeaf())
                return largest(p.getLeftChild());
            else {
                p = p.getParent();
                while(p != null && Integer.parseInt(p.getRecord().getKey().getLabel()) > Integer.parseInt(k.getLabel())){
                    p = p.getParent();
                }
                return p;
            }
        }
    
    //
        public BSTNode smallest(BSTNode r){
            if (r == null)
                return null;
            else {
                BSTNode p = new BSTNode(null);
                p = r;
                while(!p.isLeaf()){
                    p = p.getLeftChild();
                }
                return p.getParent();
            }
        }

    //
        public BSTNode largest(BSTNode r){
            if(r == null)
                return null;
            else {
                BSTNode p = new BSTNode(null);
                p = r;
                while (!p.isLeaf()) {
                    p = p.getRightChild();
                }
                return p.getParent();
            }
        }
}
