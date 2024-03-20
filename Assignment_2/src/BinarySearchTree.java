public class BinarySearchTree {
    //declaring local instance variables
        BSTNode rootNode;

    //Constructor class of the BST object
        public BinarySearchTree(){
            rootNode = new BSTNode(null);
            rootNode.setLeftChild(new BSTNode(null));
            rootNode.setRightChild(new BSTNode(null));
        }
    
    //Accessor method that returns the root node of a BST
        public BSTNode getRoot(){
            return rootNode;
        }
    
    //Accessor method that searches through a BST for where an item could be stored, will return an empty node, or a leaf's child, if the item does not exist  
        public BSTNode get(BSTNode r, Key k){
            if (r.isLeaf())
                return r;
            else{
                if (r.getRecord().getKey() == k)
                    return r;
                else if (r.getRecord().getKey().getType() < k.getType()/*TODO: NOT SUPPOSED TO BE K.TYPE, TALK TO SOMEONE!! */)
                    return get(r.getRightChild(), k);
                else
                    return get(r.getLeftChild(), k);
            }

        }

    //see lecture notes for the put() function
        public boolean insert (BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(r, k);
            if (!p.isLeaf())
                return false;
            else{
                p.getRecord().getKey() = k; // should i kill myself?
                p.setLeftChild(new BSTNode(null));
                p.setRightChild(new BSTNode(null));
                return true;
            }
        }   
    
    //Accessor method that removes an item from the BST
        public void remove(BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(r, k);
            if(p.isLeaf())
                return;//throw new DictionaryException("die");
            else {
                if (p.getLeftChild().isLeaf()){
                    BSTNode c = new BSTNode(null);
                    BSTNode pp = new BSTNode(null);
                    c = p.getRightChild();
                    pp = p.getParent();
                    if(pp != null)
                        pp.setRightChild(c);    //TODO: i have no idea which child c should be
                    else
                        rootNode = c;
                    return; // die die die
                }
                else if(p.getRightChild().isLeaf()){
                    //same as above but for the left child [?]
                }
                else{
                    BSTNode s = new BSTNode(null);
                    s = smallest(p.getRightChild());
                    p.getRecord() = s.getRecord();
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
                while (p != null && p.getRecord().getKey().getType() < k.getType()/*TODO: figure out how theyre actually being inserted and arranged into the BST, cuz its not based on type.*/){
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
                while(p != null && p.getRecord().getKey().getType() > k.getType()){
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
