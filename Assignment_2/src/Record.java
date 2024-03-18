public class Record {
    //declaring local instance variables
        Key theKey;
        String data;

    //Constructor method of the Record object
        public Record(Key k, String theData){
            theKey = k;
            data = theData;
        }

    //Accesssor method for the Key instance variable
        public Key getKey(){
            return theKey;
        }
    //Accessor method for the data instace variable
        public String getDataItem(){
            return data;
        }
}
