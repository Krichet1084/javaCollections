import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class start{
    static Scanner input = new Scanner(System.in);
    static HashMap<String, vote> votes = new HashMap<>();
    static vote currentVote;
    
    public static void main(String[] args){
        createVote();
        addCandidate();
        startVote();
    }

    public static void addCandidate(){
        System.out.print("How many candidates would you like to add?");
        int candidateNum = intInput();
        String tempFullName="John Doe";
        for(int x=0; x<candidateNum; x++){
            System.out.print("Candidate's full name in the format of first name followed by last name eg. John Doe: ");
            tempFullName=stringInput(2);
            currentVote.addCandidate(tempFullName, new candidate(tempFullName));

        }
    }

    public static void createVote(){
        System.out.print("What would you like to name your vote? ");
        String voteName = stringInput(1);
        votes.put(voteName, new vote(voteName));
        System.out.print("");
        currentVote=votes.get(voteName);
    }

    public static void startVote(){
        if(currentVote.candidateNum()<2){
            System.out.println("Cannot start vote with less than two candidates, please add more and try again.");
            return;
        }
    }

    public static String stringInput(int length){
        String text;
        while(true){
            text = input.nextLine();
            if(text.split(" ").length!=length){
                System.out.print("Please only input a name with no spaces ");
            }
            else{
                break;
            }
        }
        return text;
    }

    public static int intInput(){
        int num;
        while(true){
            try{
                if(input.hasNextLine()){
                    num=input.nextInt();
                    break;
                }
            }
            catch(InputMismatchException e){
                System.out.print("Please input a valid integer ");
            }
        }
        return num;
    }
}
