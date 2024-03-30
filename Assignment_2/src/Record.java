public class Record {
    //declaring local instance variables
        private Key theKey;
        private String data;

    //Constructor method of the Record object
        public Record(Key k, String theData){
            theKey = k;
            data = theData.toLowerCase();
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
