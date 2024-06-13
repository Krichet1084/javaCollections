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
    static int action;
    static String tempCandidate;
    
    public static void main(String[] args){
        createVote();
        System.out.println("Welcome to the voting system!");
        while(true){
            System.out.print("What action would you like to take?\n1. Start vote\n2. Add Candidate(s)\n3. Remove Candidate\n4. Return to a past vote\n5. Quit");
            switch(intInput()){
                case(1):
                    if(canStart()){
                        System.out.println(CLEARSCREEN);
                        startVote();
                        while(true){
                            System.out.print("Would you like to \n1. Create new vote\n2. Exit program\n");
                            input.next();
                            switch(intInput()){
                                case(1):
                                    createVote();
                                    break;
                                case(2):
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Invalid input");
                            }
                            break;
                        }
                    }
                    else{
                        System.out.println("You need more than two candidates to start a vote ");
                    }
                    break;
                case(2):
                    System.out.println(CLEARSCREEN);
                    addCandidate();
                    break;
                case(3):
                    System.out.println(CLEARSCREEN);
                    removeCandidate();
                    break;
                case(4):
                    System.out.println(CLEARSCREEN);
                    pastVote();
                    break;
                case(5):
                    System.out.println(CLEARSCREEN);
                    return;
                default:
                    System.out.println("Invalid input please try again");
            }
        }
        
        
    }

    public static void pastVote(){
        while(true){
                System.out.println("Which of these votes would you like to redo?");
                for(String x: allTimeVotes.keySet()){
                    System.out.println(x);
                }
                String tempVote =stringInput(1);
                if(allTimeVotes.get(tempVote)!=null){
                    currentVote=allTimeVotes.get(tempVote);
                    return;
                }
        }
    }

    public static void removeCandidate(){
        System.out.println("What of the following candidates would you like to remove?");
        for(int x=0; x<currentCandidates.length-1;x++){
            System.out.println(x+1+". "+currentCandidates[x]);
        }
        do{
            tempCandidate=stringInput(2);
        }while(!currentVote.checkDuplicate(tempCandidate));
        currentVote.remove(tempCandidate);
        System.out.println("Candidate succesfully removed!");
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
        currentCandidates=currentVote.getCandidateNames();
        System.out.print(CLEARSCREEN);
    }

    public static void createVote(){
        System.out.print("Enter a single word for the name of your vote ");
        String voteName = stringInput(1);
        if(allTimeVotes.get(voteName)!=null){
            System.out.println("Vote name already in use please try again");
            createVote();
        }
        else{
            allTimeVotes.put(voteName, new vote(voteName));
            currentVote=allTimeVotes.get(voteName);
            System.out.print(CLEARSCREEN);
        }
        addCandidate();
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
                if(tempVote!=0){
                    tempVote--;
                    System.out.println("Vote for "+currentCandidates[tempVote]+" they current have "+currentCandidates[tempVote]+" votes");
                    votePerCandidate.set(tempVote, votePerCandidate.get(tempVote)+1);
                }
            }
            else if(input.hasNext("quit")){  //stops vote
                break;
            }
            else{ //invalid input
                System.out.println("\nPlease input an integer ");
                input.next();
            }
        }
        System.out.print(CLEARSCREEN);
        System.out.println("Vote complete! ");
        currentVote.voteEnded(votePerCandidate, currentCandidates);
    }

    public static int getVote(){
        int num =input.nextInt();
        if(num>currentCandidates.length-1 || num==0){
            System.out.print("\nPlease input a valid number for this ammount of candidates ");
            if(!input.hasNextInt()){
                return 0;
            }
            return getVote();
            }
        return num;
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
