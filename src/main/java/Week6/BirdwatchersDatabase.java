package Week6;
import java.util.Scanner;
import java.util.HashMap;

public class BirdwatchersDatabase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> names = new HashMap<>();
        HashMap<String, Integer> observations = new HashMap<>();

        while(true){
            System.out.print("? ");
            String command = scanner.nextLine();
            if(command.equals("Quit")){
                break;
            }
            processCommand(command, names, observations);
        }

        scanner.close();
    }

    public static void processCommand(String command, HashMap<String,String> names, HashMap<String,Integer> observations){
        if(command.equals("Add")){
            System.out.print("Name: ");
            String name = getInput();
            System.out.print("Latin Name: ");
            String latinName = getInput();

            names.put(name, latinName);
            observations.put(name, 0);
        }
        else if(command.equals("Observation")){
            System.out.print("What was observed:? ");
            String bird = getInput();
            if(observations.containsKey(bird)){
                observations.put(bird, observations.get(bird)+1);
            }
            else{
                System.out.println("Is not a bird!");
            }
        }
        else if(command.equals("Statistics")){
            for(String name: names.keySet()){
                int observationCount = observations.getOrDefault(name, 0);
                System.out.println(name+" ("+names.get(name)+"): "+observationCount+" observations");
            }
        }
        else if(command.equals("Show")){
            System.out.print("What? ");
            String bird = getInput();
            if(observations.containsKey(bird)){
                int observationCount=observations.get(bird);
                System.out.println(bird+" ("+names.get(bird)+"): "+observationCount+" observations");
            }
            else{
                System.out.println("Is not a bird!");
            }
        }
        else{
            System.out.println("Invalid command. Please enter a valid command.");
        }
    }

    private static String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
