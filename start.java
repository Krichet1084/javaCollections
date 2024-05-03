import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class start{
    static Scanner input = new Scanner(System.in);
    static HashMap<String, vote> votes = new HashMap<>();
    static vote currentVote;
    static Array currentCandidates;
    static ArrayList<int> vote = new ArrayList<>();
    
    public static void main(String[] args){
        createVote();
        addCandidate();
        if(canVote()){
            startVote();
        }
        
    }

    public static void addCandidate(){
        System.out.print("How many candidates would you like to add?");
        int candidateNum = intInput();
        String tempFullName="John Doe";
        for(int x=0; x<candidateNum; x++){
            if(x=0)
                System.out.print("Candidate's full name in the format of first name followed by last name eg. John Doe: ");
            else
                System.out.print("Next candidate's full name: ");
            tempFullName=stringInput(2);
            currentVote.addCandidate(tempFullName, new candidate(tempFullName));
        }
        System.out.println("Successfully added candidates. ");
    }

    public static void createVote(){
        System.out.print("What would you like to name your vote? ");
        String voteName = stringInput(1);
        votes.put(voteName, new vote(voteName));
        currentVote=votes.get(voteName);
    }

    public static void startVote(){
        currentCandidates=currentVote.getCandidateNames();
        do{
            System.out.print("Indicate which candidate you would like to vote for using their number ");
            for(int x; x<currentCandidates.length(); x++){
                System.out.println(x+". "+currentCandidates[x]);
            }
            if(input.hasInt()){
                
            }
        }while(input.HasNext("quit"))
    }

    public static boolean canVote(){
        if(currentVote.candidateNum()<2){
            System.out.println("Cannot start vote with less than two candidates, please add more and try again.");
            return true;
        }
        return false;
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
                num=input.nextInt();
                break;
                }
            catch(InputMismatchException e){
                System.out.print("Please input a valid integer ");
            }
        }
        return num;
    }
}
