import java.util.*;

public class start{
    private static ArrayList<Integer> arrayListTest = new ArrayList<>();
    private static LinkedList<Double> linkedListTest = new LinkedList<>();
    private static HashSet<String> hashSetTest = new HashSet<>();
    private static Queue<String> queueTest = new PriorityQueue<>();
    private static HashMap<String, Integer> hashMapTest = new HashMap<>();
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        run();
    }

    public static void run(){
        System.out.println("Which collection type would you like to test?\n1. Array Lists\n2. Linked Lists\n3. Hash Sets\n4. Queues\n5. Hash Maps");
        switch(intInput(5)){
            case(1):
                arrayListTests();
                break;
            case(2):
                linkedListTests();
                break;
            case(3):
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
        System.out.println("What would you like to test?\n1. Adding elements \n2. Accessing items \n3. Removing elements \n4. Sorting using built in sort \n5. Replacing elements \n6. Size of array list");
        switch(intInput(6)){
            case(1): //adding
                System.out.print("How many items would you like to add? ");
                int elementNum = intInput();
                for(int x=0; x<elementNum; x++){
                    System.out.print("Input an integer to add to the array list: ");
                    arrayListTest.add(intInput());
                }
                System.out.print("Succesfully added "+elementNum+" elements to the array list!");
                break;
            case(2): //finding
                System.out.print("Which element of the list would you like to see, the first element being represented by the number 0?     ");
                int elementToFind = intInput();
                int item = arrayListTest.get(elementToFind);
                System.out.println("The element at position "+elementToFind+" of the array list is "+item);
                break;
            case(3)://removing
                System.out.print("Which element of the list would you like to remove, the first element being represented by the number 0? ");
                int elementToRemove = intInput();
                System.out.println("The element at position "+elementToRemove+" of the array list was "+arrayListTest.get(elementToRemove)+" and has now been removed");
                arrayListTest.remove(elementToRemove);
                break;
            case(4)://sorting
                System.out.println("The array list has been sorted!");
                Collections.sort(arrayListTest);
                break;
            case(5)://changing
                System.out.print("What element of the array list would you like to change, the first element being represented by the number 0? ");
                int elementToChange = intInput();
                System.out.print("What would you like the replacement value to be? ");
                arrayListTest.set(elementToChange, intInput());
                break;
            case(6)://get size
                int arrayListSize = arrayListTest.size();
                System.out.println("The array list has a size of "+arrayListSize);
                break;
            default:
                System.out.print("WHAT DA HELL!??!?!?!");
        }
        run();
    }

    public static void linkedListTests(){
        System.out.println("What would you like to test? \n1. Add an element \n2. Access an element \n3. Change an element \n4. Remove an element \n5. Get the size of linked list \n6. Sort linked list");
        switch(intInput(6)){
            case(1):
                linkedListAddElement(linkedListTest);
                break;
            case(2):
                linkedListGetElement(linkedListTest);
                break;
            case(4):
                linkedListRemoveElement(linkedListTest);
                break;
        }
    }

    public static void linkedListAddElement(LinkedList<Double> l){
        System.out.println("Where would you like to add the element? \n1. First index \n2. Last index \n3. Custom index");
        switch(intInput(3)){
            case(1):
                System.out.print("Please enter a value to be added to the front of the linked list: ");
                l.addFirst(doubleInput());
                break;
            case(2):
                System.out.print("Please enter a value to be added to the end of the linked list: ");
                l.addLast(doubleInput());
                break;
            case(3):
                System.out.print("Please enter a custom index: ")
                int customIndex = intInput(l.size());
                System.out.print("Please enter a value to be added to the linked list at your custom index: ");
                l.add(customIndex, doubleInput());
            default:
                System.out.print("Huh??");
        }
    }

    public static void linkedListRemoveElement(LinkedList<Double> l){
        System.out.println("Where would you like to remove an element? \n1. First index \n2. Last index \n3. Custom index");
        switch(intInput(3)){
            case(1):
                System.out.print("First element has been removed ");
                l.removeFirst();
                break;
            case(2):
                System.out.print("Last element has been removed ");
                l.removeLast();
                break;
            case(3):
                System.out.print("Please enter a custom index: ")
                l.remove(intInput());
                System.out.print("Element has been removed ");
            default:
                System.out.print("Huh??");
        }
    }

    public static void linkedListGetElement(LinkedList<Double> l){
        System.out.println("What element would you like to get? \n1. First element \n2. Last element \n3. Custom element ");
        switch(intInput(3)){
            case(1):
                System.out.print("The first element is "+l.peakFirst());
        }
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
            if(num>r||num==0){
                System.out.println("Please input within the valid range of 1-"+r);
                return intInput(r);
            }
            return num;
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer. ");
            return intInput(r);
        }
    }

    public static int intInput(){
        int num;
        try{
            num=input.nextInt();
            return num;
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer. ");
            return intInput();
        }
        
    }
    
    public static double doubleInput(){
        double dub;
        try{
            dub=input.nextInt();
            return dub;
        }
        catch(InputMismatchException e){
            System.out.println("Please input an integer. ");
            return doubleInput();
        }
    }
}
