public class Data {
    //Declaring local fields of the Data object
        private String config;
        private int score;
    
    //Default constructor for the Data object
        public Data(){
            //all undefined data objects are null if no arguement is passed during construction
                config = null;
                score = 0;
        }

    //Constructor that requires two arguements: config, and score
        public Data(String config, int score){
            this.config = config;
            this.score = score;
        }

    //Acessor methods for the config and score fields of the Data object
        public String getConfig(){
            return config;
        }

        public int getScore(){
            return score;
        }
        
}
