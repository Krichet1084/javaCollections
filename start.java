import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class start{
    static Scanner input = new Scanner(System.in);
    static HashMap<String, vote> allTimeVotes = new HashMap<>();
    static vote currentVote;
    static String[] currentCandidates;
    static ArrayList<Integer> votePerCandidate = new ArrayList<>();
    static final String CLEARSCREEN ="\u001b[2J";
    
    public static void main(String[] args){
        createVote();
        addCandidate();
        if(canStart()){
            startVote();
        }
        else{
            System.out.println("You need more than two candidates to start a vote ");
        }
        
    }

    public static void addCandidate(){
        System.out.print("How many candidates would you like to add? ");
        int candidateNum = intInput();
        String tempFullName="John Doe";
        for(int x=0; x<candidateNum; x++){
            if(x==0){
                System.out.print("Candidate's full name in the format of first name followed by last name eg. John Doe: ");
            }
            else{
                System.out.print("Next candidate's full name: ");
            }
            tempFullName=stringInput(2);
            if(currentVote.checkDuplicate(tempFullName)){
                System.out.println("This candidate already exists in this vote");
                x--;
            }
            currentVote.addCandidate(tempFullName, new candidate(tempFullName));
        }
        System.out.println("Successfully added candidates. ");
        System.out.print(CLEARSCREEN);
    }

    public static void createVote(){
        System.out.print("Enter a single word for the name of your vote ");
        String voteName = stringInput(1);
        allTimeVotes.put(voteName, new vote(voteName));
        currentVote=allTimeVotes.get(voteName);
        System.out.print(CLEARSCREEN);
    }

    public static void startVote(){
        currentCandidates=currentVote.getCandidateNames();
        for(int x=0; x<currentCandidates.length-1; x++){
            votePerCandidate.add(0);
        }
        while(true){
            System.out.println("Indicate which candidate you would like to vote for using their number or type quit to end vote");
            for(int x=0; x<currentCandidates.length-1; x++){
                System.out.println(x+1+". "+currentCandidates[x]);
            }
            System.out.print("Your vote: ");
            if(input.hasNextInt()){
                int tempVote = getVote();
                votePerCandidate.set(tempVote, votePerCandidate.get(tempVote)+1);
            }
            else if(input.hasNext("quit")){
                break;
            }
            else{
                System.out.println("\nPlease input an integer ");
                input.next();
            }
        }
        System.out.println("Vote complete! ");
        currentVote.voteEnded(votePerCandidate, currentCandidates);
    }

    public static int getVote(){
        int num =input.nextInt();
        if(num>currentCandidates.length-1 || num==0){
            System.out.print("\nPlease input a valid number for this ammount of candidates ");
            return getVote();
            }
        return num-1;
    }

    public static boolean canStart(){
        if((currentVote.candidateNum()<3)){
            System.out.println("Cannot start vote with less than two candidates, please add more and try again.");
            return false;
        }
        return true;
    }

    public static String stringInput(int length){
        String text;
        while(true){
            text = input.nextLine();
            if(text.split(" ").length!=length){
                System.out.print("Please follow the specified input conventions ");
            }
            else{
                break;
            }
        }
        return text;
    }

    public static int intInput(){
        int num;
        try{
            num=input.nextInt();
            return num;
            }
        catch(InputMismatchException e){
            if(input.next().isEmpty()){
            }
            else
                System.out.print("Please input a valid integer ");
            return intInput();
        }
    }
}
