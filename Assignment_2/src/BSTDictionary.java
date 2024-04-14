 public class BSTDictionary implements BSTDictionaryADT {
    //kill me now
        private BinarySearchTree bst = new BinarySearchTree();
    //
        public Record get(Key k) {
            return bst.get(bst.getRoot(), k).getRecord();
        }

    //put
        public void put(Record d) throws DictionaryException {
            BSTNode node = new BSTNode(d);
            if(!bst.insert(node, d.getKey())){
                throw new DictionaryException("Error: Item already exists in BST");
            }
        }

    //remove 
        public void remove(Key k) throws DictionaryException {
            bst.remove(bst.getRoot(), k);
        }
    
    //successor
        public Record successor(Key k) {
            return bst.successor(bst.getRoot(), k).getRecord();
        }

    //predecessor
        public Record predecessor(Key k) {
            return bst.successor(bst.getRoot(), k).getRecord();
        }
    
    //smallest
        public Record smallest(){
            return bst.smallest(bst.getRoot()).getRecord();
        }
    
    //largest
        public Record largest(){
            return bst.largest(bst.getRoot()).getRecord();
        }
}
