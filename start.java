import java.util.*;

public start{
    private static ArrayList<int> arrayListTest = new ArrayList<>();
    private static LinkedList<double> linkedListTest = new LinkedList<>();
    private static HashSet<String> hashSetTest = new HashSet<>();
    private static Queue<String> queueTest = new PriorityQueue<>();
    private static HashMap<String, Integer> hashMapTest = new HashMap<>();
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("Which collection type would you like to test?\n1.Array Lists\n2. Linked Lists\n3. Hash Sets\n4. Queues\n5. Hash Maps?");
        switch(intInput()){
            case(1):
                arrayListTests();
                break;
            case(2):
                linkedListTests();
                break;
            case(3);
                hashSetTests();
                break;
            case(4):
                queueTests();
                break;
            case(5):
                hashMapTests();
                break;
            default:
                System.out.println("That was NOT supposed to happen.");
        }
    }

    public static void arrayListTests(){
        //add stuff

    }

    public static void linkedListTests(){
        //add stuff

    }

    public static void hashSetTests(){
        //add stuff
    }

    public static void queueTests(){
        //add stuff

    }

    public static void hashMapTests(){
        //add stuff
    }

    public static int intInput(int r){
        int num;
        try{
            num=input.nextInt();
            if(num>r){
                System.out.println("Please input within the valid range of 1-"+r);
                return intInput(r);
            }
            return num;
        }
        catch(InputMissMatchException e){
            System.out.println("Please input an integer. ");
            return intInput();
        }
    }
}