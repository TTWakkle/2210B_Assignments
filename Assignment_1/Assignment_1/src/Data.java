public class Data {
    //Declaring local fields of the Data object
        private String config;
        private int score;

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
