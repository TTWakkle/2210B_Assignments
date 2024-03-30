public class Interface {
    //This function Acts as a switchgate to determine which operation the program should run
        private static boolean commandGate(String line){
            boolean tp = false;
            String[] commands = line.split(" "); 
            switch (commands[0]) {
                case "define":
                    define(commands[1]);
                    break;
                case "translate":
                    translate(commands[1]);
                    break;
                case "sound":
                    sound(commands[1]);
                    break;
                case "play":
                    play(commands[1]);
                    break;
                case "say":
                    say(commands[1]);
                    break;
                case "show":
                    show(commands[1]);
                    break;
                case "animate":
                    animate(commands[1]);
                    break;
                case "browse":
                    browse(commands[1]);
                    break;
                case "delete":
                    delete(new Key(commands[1], Integer.parseInt(commands[2])) );
                    break;
                case "add":
                    add(new Record(new Key(commands[1], Integer.parseInt(commands[2])), commands[3]));
                    break;
                case "list":
                    list(commands[1]);
                    break;
                case "first":
                    first();
                    break;
                case "last":
                    last();
                    break;
                case "exit":
                    tp = true;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        
            return tp;
        }

    //
        private static void define(String label){

        }
    //
        private static void translate(String label){

        }
    //
        private static void sound(String label){

        }
    //
      private static void play(String label){

        }
    //
        private static void say(String label){

        }
    //
        private static void show(String label){

        }
    //
        private static void animate(String label){

        }
    //
        private static void browse(String label){

        }
    //
        private static void list(String prefix){

        }
    //
        private static void first(){

        }
    //
        private static void last(){

        }
    //
        private static void delete(Key k){

        }
    //
        private static void add(Record obj){

        }

    //Method
    //Main method
        public static void main(String[] args) {
            //declaring and initialisng local variables
                boolean terminateProg = false;
                StringReader keyboard = new StringReader();
                String line = new String();
            //reading the name of the input file from the terminal
                String inputFile = args[0];    

            //Requesting user input and deciding on an action based on the input
                do {
                    line = keyboard.read("Enter Next Command: ");
                    terminateProg = commandGate(line);
                } while (!terminateProg);

        }
}
