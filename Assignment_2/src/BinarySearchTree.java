public class BinarySearchTree {
    //declaring local instance variables
        BSTNode rootNode;

    //Constructor class of the BST object, This creates a null node and sets it as the root, defining an 'empty' BST
        public BinarySearchTree(){
            rootNode = new BSTNode(null);
        }
    
    //Accessor method that returns the root node of a BST
        public BSTNode getRoot(){
            return rootNode;
        }
    
    //Accessor method that searches through a BST for where an item could be stored, will return an empty node, or a leaf's child, if the item does not exist  
        public BSTNode get(BSTNode r, Key k){
            if(rootNode.getRecord() ==  null)
                return null;
            if (r.isLeaf())
                return r;
            else{
                switch (r.getRecord().getKey().compareTo(k)) {
                    case 0:
                        return r;
                    case -1:
                        return get(r.getRightChild(), k);
                    default:
                        return get(r.getLeftChild(), k);
                }
            }
        }

    //This function inserts a node into the tree, utilizing the get() function to determine where it exists
        public boolean insert (BSTNode r, Key k){
            //checking whether the tree is empty or not
                if (rootNode.getRecord() == null){
                    rootNode.setRecord(new Record(k, r.getRecord().getDataItem()));
                    rootNode.setLeftChild(new BSTNode(null));
                    rootNode.setRightChild(new BSTNode(null));
                    rootNode.getLeftChild().setParent(rootNode);
                    rootNode.getRightChild().setParent(rootNode);
                    rootNode.setParent(null);
                    return true;
                }
            //inserting based on where get() dictates a node should be placed
                BSTNode p = new BSTNode(null);
                p = get(rootNode, k);
                
                if (!p.isLeaf())
                    return false; //OR throw new DictionaryException("Item already exists in BST")
                else{
                    p.setRecord(r.getRecord());
                    p.setLeftChild(new BSTNode(null));
                    p.setRightChild(new BSTNode(null));
                    p.getLeftChild().setParent(p);
                    p.getRightChild().setParent(p);
                    return true;
                }
        }   
    
    //Accessor method that removes an item from the BST
        public void remove(BSTNode r, Key k) throws DictionaryException{
            BSTNode p =  new BSTNode(null);
            p = get(r, k);
            if (p.isLeaf())
                throw new DictionaryException("Item does not exist in BST");
            else{
                BSTNode c = new BSTNode(null);
                BSTNode pp = new BSTNode(null);

                //if eiter child of p is null, or if p is an internal node 
                    pp = p.getParent();
                    if(p.getRightChild().getRecord() == null){
                        c = p.getLeftChild();
                        if(pp.getRecord() != null){
                            if(pp.getLeftChild().getRecord() == p.getRecord())
                                pp.setLeftChild(c);
                            else
                                pp.setRightChild(c);
                        }
                        else{
                            rootNode.setRecord(c.getRecord());
                        }
                    }
                    else if(p.getLeftChild().getRecord() == null){
                        c = p.getRightChild();
                        if(pp.getRecord() != null){
                            if(pp.getLeftChild().getRecord() == p.getRecord())
                                pp.setLeftChild(c);
                            else
                                pp.setRightChild(c);
                        }
                        else{
                            rootNode.setRecord(c.getRecord());
                        }
                    }
                    else{
                        BSTNode s = smallest(p.getRightChild());
                        p.setRecord(s.getRecord());
                        remove(s, s.getRecord().getKey());
                    }

            }
        }

    //
        public BSTNode successor(BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(rootNode, k);
            if(!p.getRightChild().getRecord() != null){
                return smallest(p.getRightChild());
            }
            else{
                p = p.getParent();
                while((p.getRecord() != null) && (p.getRecord().getKey().compareTo(k) == -1)){
                    p = p.getParent();
                }
                return p;
            }
        }
    
    //
        public BSTNode predecessor(BSTNode r, Key k){
            BSTNode p = new BSTNode(null);
            p = get(rootNode, k);
            if(!p.getLeftChild().getRecord() !=  null)
                return largest(p.getLeftChild());
            else {
                p = p.getParent();
                while((p.getRecord() != null) && (p.getRecord().getKey().compareTo(k) == 1)){
                    p = p.getParent();
                }
                return p;
            }
        }
    
    //
        public BSTNode smallest(BSTNode r){
            if (r.getRecord() == null)
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
            if(r.getRecord() == null)
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
