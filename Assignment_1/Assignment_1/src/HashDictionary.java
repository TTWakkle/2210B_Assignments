import java.util.LinkedList;


public class HashDictionary implements DictionaryADT {
    //Declaring local fields of the HashDictionary object
        private LinkedList<Data>[] hashTable;
        private static int PRIME = 53;    //1543 has given me great results
        private int HASH_SIZE, storedRecords;

    /**Constructor of the HashDictionary object that requires 1 arguement: size
     * @param size */
        public HashDictionary(int size){
            HASH_SIZE = size;
            hashTable = new LinkedList[size];   
            storedRecords = 0;
        }

    /**A hashing function that utilizes the config field of a Data object to
     * generate a unique integer hashCode
     * @param record
     * @return hashCode */
        private int hash(String recordConfig){
            //declaring and intitializing local variables
                int hashCode = 0;

            /*since config will only consist of 3 different unicode characters, 
            *some operation must be done to identify each instance of a character 
            based on its position in config*/
                for(int i = 0; i < recordConfig.length(); i++){
                    hashCode = (hashCode*PRIME + (int)recordConfig.charAt(i)*i ) % HASH_SIZE;
                }
            return hashCode;
        }
     
        
    /**Accessor method that puts an item (of type Data) somewhere into the 
     * HashDictionary Object, by utilizing the hash() method
     * @param record */
        public int put(Data record) throws DictionaryException {
            //generating a hash value for the provided data
                int hashCode = hash(record.getConfig());

            /*incrementing recordsStored and returning control back to main upon
            successful insertion, throws an exception otherwise*/
                if( hashTable[hashCode] == null ){
                    hashTable[hashCode] = new LinkedList<Data>();
                    hashTable[hashCode].add(record);
                    storedRecords++;
                    return 0;
                }
                else {
                    for(int index = 0; index < hashTable[hashCode].size(); index++) {
                        if(hashTable[hashCode].get(index).getConfig().equals(record.getConfig())){
                            throw new DictionaryException();
                        }
                    }
                    hashTable[hashCode].add(record);
                    storedRecords++;
                    return 1;
                }    
        }
    
    /**Accessor methot that removes an item (of type Data) from the HashDictionary 
     * based on the hashed integer value of a given string
     * @param config */
        public void remove(String config) throws DictionaryException {
            //generating a hash value for the provided data
                int hashCode = hash(config);

            //checking if the config exists within a data object on the hashTable
                if(hashTable[hashCode] == null){
                    throw new DictionaryException();
                }
                else {
                    for (int index = 0; index < hashTable[hashCode].size(); index++) {
                        if(hashTable[hashCode].get(index).getConfig().equals(config)){
                            hashTable[hashCode].remove(index);
                            storedRecords--;
                            return;
                        }
                    }
                    throw new DictionaryException();
                }
        }
    
        
    /**Helper method that returns the score of a Data item based on a given string
     * @param config */
        public int get(String config) {
            //generating a hash value for the provided data
            int hashCode = hash(config);

            if(hashTable[hashCode] ==  null){
                return -1;
            }
            else{
                for (int index = 0; index < hashTable[hashCode].size(); index++) {
                    if(hashTable[hashCode].get(index).getConfig().equals(config)) {
                        return hashTable[hashCode].get(index).getScore();
                    }
                }
                return -1;
            }
        }

    /**Helper method that returns the number of Data objects stored in the hashTable*/
        public int numRecords() {
            return storedRecords;
        }
    
}
