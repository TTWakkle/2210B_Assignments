import java.util.LinkedList;


public class HashDictionary implements DictionaryADT {
    //Declaring local fields of the HashDictionary object
        private LinkedList<Data>[] hashTable;
        private static int HASH_SIZE, PRIME = 31;
        private int recordsStored;

    //Generic constructor of the HashDictionary object
        public HashDictionary(){
            //undefined
        }

    //Constructor of the HashDictionary object that requires 1 arguement: size
        public HashDictionary(int size){
            HASH_SIZE = size;
            hashTable = new LinkedList[size];
            recordsStored = 0;
        }

    /*A hashing function that utilizes both fields of a Data object to
    generate a unique integer hashcode*/
        private int hash(Data record){
            //declaring and intitializing local variables
                int hashCode = 0;

            /*since config will only consist of 3 different unicode characters, 
            *some operation must be done to identify each instance of a character 
            based on its position in config*/
                for(int i = 0; i < record.getConfig().length(); i++){
                    hashCode = (hashCode + (int)(record.getConfig().charAt(i))*PRIME^i) % HASH_SIZE;
                }
            return hashCode;
        }
     
    /*Accessor method that puts an item (of type Data) somewhere into the 
    HashDictionary Object, by utilizing the hash() method*/    
        @Override
        public int put(Data record) throws DictionaryException {
            // TODO Auto-generated method stub
            //Declaring and initializing local variables
                int hashCode;

            //generating a hash value for the provided data
                hashCode = hash(record);

            /*incrementing recordsStored and returning control back to main upon
            successful insertion, throws an exception otherwise*/
                if(hashTable[hashCode] == null ){
                    hashTable[hashCode] = new LinkedList<Data>();
                    hashTable[hashCode].add(record);
                    recordsStored++;
                    return 1;
                }
                else if(hashTable[hashCode].contains(record)){
                    throw new DictionaryException();
                }
                else{
                    hashTable[hashCode].add(record);
                    recordsStored++;
                    return 1;
                }    
        }
    
    /*Accessor methot that removes an item (of type Data) from the HashDictionary 
    based on the hashed, seperate-chaining of a given string*/
        @Override
        public void remove(String config) throws DictionaryException {
            // TODO Auto-generated method stub
            throw new DictionaryException();
        }
    //Helper method that returns the hash code of a Data item based on a given string
        @Override
        public int get(String config) {
            //declaring local variables required to find a Dataset within the HashDictionary
            return -1;
        }
    //Helper
        @Override
        public int numRecords() {
            // TODO Auto-generated method stub
            return recordsStored;
        }
    
}
