public class Key {
    //declaring local instance variables
        private String label;
        private int type;
    //Constructor method to initialize the Key Obj
        public Key(String theLabel, int theType){
            label = theLabel.toLowerCase();
            type = theType;
        }

    //returns the string stored in the instance variable label
        public String getLabel(){
            return label;
        }

    //Returns the value of the instance variable type
        public int getType(){
            return type;
        }
    
    /**Returns 0 if this key = k, -1 if this key < k,
     * or 1 otherwise
     * @param k
     * @return 0 || -1 || 1 */
        public int compareTo(Key k){
            if((k.getLabel().compareTo(label) == 0) && type == k.getType())
                return 0;
            else if((k.getLabel().compareTo(label) < 0) || ((k.getLabel().compareTo(label) == 0) && k.getType() < type))
                return -1;
            else
                return 1;
        }
}
