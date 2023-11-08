package Week6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String, String> translations;

    public Dictionary(){
        this.translations=new HashMap<>();
    }

    public void add(String word, String translation){
        translations.put(word, translation);
    }

    public String translate(String word){
        return translations.get(word);
    }

    public int amountOfWords(){
        return translations.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> translationList = new ArrayList<>();
        for(String word: translations.keySet()){
            String translation = translations.get(word);
            translationList.add(word+" = "+translation);
        }
        return translationList;
    }
}

class TextUserInterface{

    private Scanner reader;
    private Dictionary dictionary;
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader=reader;
        this.dictionary=dictionary;
    }
    public void start(){

        System.out.println("Statements: ");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quits the text user interface");

        while(true){
            System.out.println();
            System.out.print("Statement: ");
            String command = reader.nextLine();

            if(command.equals("quit")){
                System.out.println("Cheers!");
                break;
            }
            else if(command.equals("add")){
                System.out.print("In Finnish: ");
                String word = reader.nextLine();
                System.out.print("Translation: ");
                String translation = reader.nextLine();
                dictionary.add(word, translation);
            }
            else if(command.equals("translate")){
                System.out.print("Give a word:");
                String word = reader.nextLine();
                String translation = dictionary.translate(word);
                if(translation!=null){
                    System.out.println("Translation: "+translation);
                }
                else{
                    System.out.println("Word not found in the dictionary.");
                }
            }
            else{
                System.out.println("Unknown statement.");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        TextUserInterface ui = new TextUserInterface(new Scanner(System.in), dictionary);
        ui.start();
    }
}