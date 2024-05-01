import java.util.*;

public class start{
    HashMap<String, vote> votes = new HashMap<String, vote>;
    vote currentVote;
    
    public static void main(String[] args){
        createVote();
        addCandidate();
        startVote();
    }

    public static void addCandidate(){
        System.out.print("How many candidates would you like to add?");
        int candidateNum = intInput();
        String tempFirstName;
        String tempLastName;
        for(int x=0; x<candidateNum; x++){
            System.out.print("Candidate's first name: ");
            tempFirstName=stringInput;
            System.out.print()

        }
    }

    public static void createVote(){
        String voteName = stringInput;
        votes.put(voteName, new vote(voteName));
        currentVote=votes.get(voteName);
    }

    public static void startVote(){
        if(currentVote.candidateNum()<2){
            System.out.println("Cannot start vote with less than two candidates, please add more and try again.");
            return;
        }
    }

    public static String stringInput(){
        Scanenr input = new Scanner(System.in);
        String text;
        while(true){
            text = input.nextLine();
            if(text.split(" ").length()!=1){
                System.out.print("Please only input a name with no spaces ");
            }
        }
        input.close();
        return text;
    }

    public static int intInput(){
        Scanner input = new Scanner(System.in);
        int num;
        while(true){
            try{
                num=input.nextInt();
                break;
            }
            catch(InputMissmatchException e){
                if(input.next().isEmpty()){
                    continue;
                }
            }
        }
        input.close();
        return num;
    }
}
