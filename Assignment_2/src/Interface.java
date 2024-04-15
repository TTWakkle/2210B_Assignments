import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Interface {
    /**This function Acts as a switchgate to determine which
     * operation the program should run.
     * @param line
     * @param bst
     * @return   true if & only if the user entered "exit", otherwise false */
        private static boolean commandGate(String line, BSTDictionary bst){
            boolean tp = false;
            String[] commands = line.split(" "); 
            switch (commands[0]) {
                case "define":
                    define(commands[1], bst);
                    break;
                case "translate":
                    translate(commands[1], bst);
                    break;
                case "sound":
                    sound(commands[1], bst);
                    break;
                case "play":
                    play(commands[1], bst);
                    break;
                case "say":
                    say(commands[1], bst);
                    break;
                case "show":
                    show(commands[1], bst);
                    break;
                case "animate":
                    animate(commands[1], bst);
                    break;
                case "browse":
                    browse(commands[1], bst);
                    break;
                case "delete":
                    delete(new Key(commands[1], Integer.parseInt(commands[2])), bst );
                    break;
                case "add":
                    add(new Record(new Key(commands[1], Integer.parseInt(commands[2])), sumCommands(commands)), bst); 
                    break;
                case "list":
                    List<String> labels = new ArrayList<>();
                    list(commands[1],labels, bst);
                    break;
                case "first":
                    first(bst);
                    break;
                case "last":
                    last(bst);
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

    /**This method groups any words that have been seperated by the .split()
     *  function in order to be passed as a single string of data into a Record
     * @param commands
     * @return data */
        private static String sumCommands(String[] commands){
            String data = new String();
            for(int i = 3; i < commands.length; i++){
                data += commands[i] + " ";
            }
            return data;
        }

    /**
     * 
     * @param line
     * @return type */
        private static int dataType(String line){
            int type;
            switch (line.charAt(0)) {
                case '-':
                    type  = 3;
                    break;
                case '+':
                    type = 4;
                    break;
                case '*':
                    type = 5;
                    break;
                case '/':
                    type  = 2;
                    break;
                default:
                    if(line.substring(line.length() - 3,line.length() - 1) == "gif")
                        type = 7;
                    else if(line.substring(line.length() - 3, line.length() - 1) == "jpg")
                        type = 6;
                    else if(line.substring(line.length() - 4, line.length() - 1) == "html")
                        type  = 8;
                    else
                        type = 1;
                    break;
            }
            return type;
        }

    /**This function prints the data attribute that's 
     * a String containing a definition (type 1) of the provided label
     * @param label
     * @param bst */
        private static void define(String label, BSTDictionary bst){
            Record rec = new Record(null,null);
            rec = bst.get(new Key(label, 1));

            if (rec.getDataItem() != null)
                System.out.println(rec.getDataItem());
            else
                System.out.println("The word " + label + " is not in the ordered Dictionary");
        }

    /**This function prints the data attribute that's 
     * a String containing a translation (type 2) of the provided label
     * @param label 
     * @param bst */
        private static void translate(String label, BSTDictionary bst){
            Record rec = new Record(null,null);
            rec = bst.get(new Key(label, 2));

            if (rec.getDataItem() != null)
                System.out.println(rec.getDataItem());
            else
                System.out.println("There is no definition for the word " + label);
        }

    /**This function plays the audio file that's a
     * sound (type 3) based on the provided label 
     * @param label 
     * @param bst */
        private static void sound(String label, BSTDictionary bst){
            Record rec = new Record(null,null);
            rec = bst.get(new Key(label, 3));
            SoundPlayer sp = new SoundPlayer();

            if(rec.getDataItem() != null){
                try {
                    sp.play(rec.getDataItem());
                } catch(MultimediaException e){
                    System.out.println("There is no sound file for " + label);    
                }
            }
            else
                System.out.println("There is no sound file for " + label);
        }

    /**This function plays an audio file that's a
     * song (type 4) based on the provided label
     * @param label 
     * @param bst */
        private static void play(String label, BSTDictionary bst){
            Record rec = new Record(null,null);
            rec = bst.get(new Key(label, 4));
            SoundPlayer sp = new SoundPlayer();

            if(rec.getDataItem() != null){
                try {
                    sp.play(rec.getDataItem());
                } catch(MultimediaException e){
                    System.out.println("There is no music file for " + label);    
                }
            }
            else
                System.out.println("There is no music file for " + label);
        }

    /**This function plays an audio file that's a 
     * vocal recording (type 5) based on the provided label
     * @param label 
     * @param bst */
        private static void say(String label, BSTDictionary bst){
            Record rec = new Record(null,null);
            rec = bst.get(new Key(label, 5));
            SoundPlayer sp = new SoundPlayer();

            if(rec.getDataItem() != null){
                try {
                    sp.play(rec.getDataItem());
                } catch(MultimediaException e){
                    System.out.println("There is no voice file for " + label);    
                }
            }
            else
                System.out.println("There is no voice file for " + label);
        }
        
    /**This function displays an image that's a
     * jpg (Type 6) based on the provided label
     * @param label 
     * @param bst */
        private static void show(String label, BSTDictionary bst){
            Record rec = new Record(null, null);
            rec = bst.get(new Key(label, 6));
            PictureViewer pv = new PictureViewer();

            if(rec.getDataItem() != null){
                try{
                    pv.show(rec.getDataItem());
                } catch( MultimediaException e){
                    System.out.println("There is no image file for " + label);
                }
            }
            else
                System.out.println("There is no image file for " + label);
        }

    /**this function displays an animated image that's
     * a gif (Type 7) based on the provided label
     * @param label 
     * @param bst */
        private static void animate(String label, BSTDictionary bst){
            Record rec = new Record(null, null);
            rec = bst.get(new Key(label, 7));
            PictureViewer pv = new PictureViewer();

            if(rec.getDataItem() != null){
                try{
                    pv.show(rec.getDataItem());
                } catch( MultimediaException e){
                    System.out.println("There is no animated image file for " + label);
                }
            }
            else
                System.out.println("There is no animated image file for " + label);
        }

    /**This function will open a webpage of an html
     * file (Type 8) based on the provided label
     * @param label 
     * @param bst */
        private static void browse(String label, BSTDictionary bst){
            Record rec = new Record(null, null);
            rec = bst.get(new Key(label, 8));
            ShowHTML shtml = new ShowHTML();
            if(rec.getDataItem() != null)
                shtml.show(rec.getDataItem());
            else
                System.out.println("There is no webpage called " + label);
        }

    /**This function will search through the bst for any items that 
     * have a label starting with the given prefix, and display their labels
     * @param prefix 
     * @param bst */
        private static void list(String prefix, List<String> labels, BSTDictionary bst){
            bst.get(new Key(prefix, 0));









            
        }

    /**This function prints all the attributes of a Record 
     * in the BST with the smallest key
     * @param bst */
        private static void first(BSTDictionary bst){
            Record rec = new Record(null, null);
            rec = bst.smallest();
            System.out.println(rec.getKey().getLabel() + ", " + rec.getKey().getType() + ", " + rec.getDataItem());
        }

    /**This function prints all the attributes of a Record
     * in the BST with the largest key
     * @param bst */
        private static void last(BSTDictionary bst){
            Record rec = new Record(null, null);
            rec = bst.largest();
            System.out.println(rec.getKey().getLabel() + ", " + rec.getKey().getType() + ", " + rec.getDataItem());
        }

    /**This function attempts to remove a Record that matches
     * the provided key from the BST
     * @param k
     * @param bst */
        private static void delete(Key k, BSTDictionary bst){
            try{
                bst.remove(k);
            } catch(DictionaryException e){
                System.out.println("No record in the ordered dictionary has Key ("+k.getLabel()+","+k.getType()+")");
            }
        }

    /**This function attepmts to insert a Record into the BST
     * @param obj
     * @param bst */
        private static void add(Record obj, BSTDictionary bst){
            try{
                bst.put(obj);
            } catch(DictionaryException e) {
                System.out.println("A record with the given key ("+obj.getKey().getLabel()+","+obj.getKey().getType()+") is already in the ordered dictionary");
            }
        }

    //Main method
        public static void main(String[] args){
            //declaring and initialisng local variables
                boolean terminateProg = false;
                StringReader keyboard = new StringReader();
                String line  = new String();
                String label = new String();
                String data = new String();
    
                BSTDictionary bst = new BSTDictionary();
            //reading the name of the input file, and importing each line into the BST
                String inputFile = args[0];
                try{
                    FileReader fRead = new FileReader(inputFile);
                    BufferedReader bRead = new BufferedReader(fRead);
                    //reading each line until EOF
                        try{
                            while((label = bRead.readLine()) != null){
                                data = bRead.readLine();
                                try{
                                    bst.put(new Record(new Key(label, dataType(data)), data));
                                }
                                catch(DictionaryException e){
                                    System.out.println("Error: Dictionary Exception occured");
                                }
                            }
                            bRead.close();
                        } catch(IOException e){
                            System.out.println("Error: I/O error occured");
                            System.exit(0);
                        }
                }catch(FileNotFoundException e){
                    System.out.println("Error: File Not found");
                    System.exit(0);
                }
            //Requesting user input and deciding on an action based on the input
                do {
                    line = keyboard.read("Enter Next Command: ");
                    terminateProg = commandGate(line, bst);
                } while (!terminateProg);

        }
}