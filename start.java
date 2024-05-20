import java.util.*;

public class start {
    private static ArrayList<Integer> arrayListTest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    private static LinkedList<Double> linkedListTest = new LinkedList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5));
    private static HashSet<String> hashSetTest = new HashSet<>(Arrays.asList("one", "two", "three", "four", "five"));
    private static Queue<String> queueTest = new PriorityQueue<>(Arrays.asList("one", "two", "three", "four", "five"));
    private static HashMap<String, Integer> hashMapTest = new HashMap<>();
    private static Scanner input = new Scanner(System.in);
    private static final String INVALID = "Invalid choice. Please try again.";
    private static final String WHAT = "What would you like to test?";

    static {
        hashMapTest.put("one", 1);
        hashMapTest.put("two", 2);
        hashMapTest.put("three", 3);
        hashMapTest.put("four", 4);
        hashMapTest.put("five", 5);
    }

    public static void main(String[] args) {
        run();
        input.close(); // Close the scanner properly
    }

    public static void run() {
        System.out.println("Which collection type would you like to test?");
        System.out.println("1. Array Lists");
        System.out.println("2. Linked Lists");
        System.out.println("3. Hash Sets");
        System.out.println("4. Queues");
        System.out.println("5. Hash Maps");
        switch (intInput(5)) {
            case 1:
                arrayListTests();
                break;
            case 2:
                linkedListTests();
                break;
            case 3:
                hashSetTests();
                break;
            case 4:
                queueTests();
                break;
            case 5:
                hashMapTests();
                break;
            default:
                System.out.println(INVALID);
        }
    }

    public static void arrayListTests() {
        System.out.println(WHAT);
        System.out.println("1. Adding elements");
        System.out.println("2. Accessing items");
        System.out.println("3. Removing elements");
        System.out.println("4. Sorting using built-in sort");
        System.out.println("5. Replacing elements");
        System.out.println("6. Size of array list");
        System.out.println("7. Print array list");
        switch (intInput(7)) {
            case 1:
                System.out.print("How many items would you like to add? ");
                int elementNum = intInput();
                for (int x = 0; x < elementNum; x++) {
                    System.out.print("Input an integer to add to the array list: ");
                    arrayListTest.add(intInput());
                }
                System.out.println("Successfully added " + elementNum + " elements to the array list!");
                break;
            case 2:
                System.out.print("Which element of the list would you like to see (0-based index)? ");
                int elementToFind = intInput();
                if (elementToFind < arrayListTest.size()) {
                    int item = arrayListTest.get(elementToFind);
                    System.out.println("The element at position " + elementToFind + " of the array list is " + item);
                } else {
                    System.out.println("Index out of bounds.");
                }
                break;
            case 3:
                System.out.print("Which element of the list would you like to remove (0-based index)? ");
                int elementToRemove = intInput();
                if (elementToRemove < arrayListTest.size()) {
                    System.out.println("The element at position " + elementToRemove + " of the array list was " + arrayListTest.get(elementToRemove) + " and has now been removed");
                    arrayListTest.remove(elementToRemove);
                } else {
                    System.out.println("Index out of bounds.");
                }
                break;
            case 4:
                Collections.sort(arrayListTest);
                System.out.println("The array list has been sorted!");
                break;
            case 5:
                System.out.print("Which element of the array list would you like to change (0-based index)? ");
                int elementToChange = intInput();
                if (elementToChange < arrayListTest.size()) {
                    System.out.print("What would you like the replacement value to be? ");
                    arrayListTest.set(elementToChange, intInput());
                } else {
                    System.out.println("Index out of bounds.");
                }
                break;
            case 6:
                System.out.println("The array list has a size of " + arrayListTest.size());
                break;
            case 7:
                for (int x : arrayListTest) {
                    System.out.print(x + " ");
                }
                System.out.println();
                break;
            default:
                System.out.println(INVALID);
        }
        run();
    }

    public static void linkedListTests() {
        System.out.println(WHAT);
        System.out.println("1. Add an element");
        System.out.println("2. Access an element");
        System.out.println("3. Change an element");
        System.out.println("4. Remove an element");
        System.out.println("5. Get the size of linked list");
        System.out.println("6. Sort linked list");
        System.out.println("7. Print linked list");
        System.out.println("8. Pop first element");
        System.out.println("9. Pop last element");
        switch (intInput(9)) {
            case 1:
                linkedListAddElement(linkedListTest);
                break;
            case 2:
                linkedListGetElement(linkedListTest);
                break;
            case 3:
                System.out.print("Which element would you like to change? ");
                int elementToSet = intInput(linkedListTest.size());
                System.out.print("What would you like the element to be? ");
                linkedListTest.set(elementToSet, doubleInput());
                break;
            case 4:
                linkedListRemoveElement(linkedListTest);
                break;
            case 5:
                System.out.println("The linked list has " + linkedListTest.size() + " elements");
                break;
            case 6:
                Collections.sort(linkedListTest);
                System.out.println("The linked list has been sorted!");
                break;
            case 7:
                for (double x : linkedListTest) {
                    System.out.print(x + " ");
                }
                System.out.println();
                break;
            case 8:
                linkedListPopFirst(linkedListTest);
                break;
            case 9:
                linkedListPopLast(linkedListTest);
                break;
            default:
                System.out.println(INVALID);
        }
        run();
    }

    public static void linkedListAddElement(LinkedList<Double> l) {
        System.out.println("Where would you like to add the element?");
        System.out.println("1. First index");
        System.out.println("2. Last index");
        System.out.println("3. Custom index");
        switch (intInput(3)) {
            case 1:
                System.out.print("Please enter a value to be added to the front of the linked list: ");
                l.addFirst(doubleInput());
                break;
            case 2:
                System.out.print("Please enter a value to be added to the end of the linked list: ");
                l.addLast(doubleInput());
                break;
            case 3:
                System.out.print("Please enter a custom index: ");
                int customIndex = intInput(l.size());
                System.out.print("Please enter a value to be added to the linked list at your custom index: ");
                l.add(customIndex, doubleInput());
                break;
            default:
                System.out.println(INVALID);
        }
    }

    public static void linkedListRemoveElement(LinkedList<Double> l) {
        System.out.println("Where would you like to remove an element?");
        System.out.println("1. First index");
        System.out.println("2. Last index");
        System.out.println("3. Custom index");
        switch (intInput(3)) {
            case 1:
                l.removeFirst();
                System.out.println("First element has been removed.");
                break;
            case 2:
                l.removeLast();
                System.out.println("Last element has been removed.");
                break;
            case 3:
                System.out.print("Please enter a custom index: ");
                l.remove(intInput(l.size()));
                System.out.println("Element has been removed.");
                break;
            default:
                System.out.println(INVALID);
        }
    }

    public static void linkedListGetElement(LinkedList<Double> l) {
        System.out.println("What element would you like to get?");
        System.out.println("1. First element");
        System.out.println("2. Last element");
        System.out.println("3. Custom element");
        switch (intInput(3)) {
            case 1:
                System.out.println("The first element is " + l.getFirst());
                break;
            case 2:
                System.out.println("The last element is " + l.getLast());
                break;
            case 3:
                System.out.print("Which element would you like to see? ");
                int customIndex = intInput(l.size());
                System.out.println("The element at your custom index is " + l.get(customIndex));
                break;
            default:
                System.out.println(INVALID);
        }
    }

    public static void linkedListPopFirst(LinkedList<Double> l) {
        if (!l.isEmpty()) {
            System.out.println("Popped the first element: " + l.removeFirst());
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public static void linkedListPopLast(LinkedList<Double> l) {
        if (!l.isEmpty()) {
            System.out.println("Popped the last element: " + l.removeLast());
        } else {
            System.out.println("The linked list is empty.");
        }
    }

    public static void hashSetTests() {
        System.out.println(WHAT);
        System.out.println("1. Add an element");
        System.out.println("2. Remove an element");
        System.out.println("3. Check if an element exists");
        System.out.println("4. Get the size of hash set");
        System.out.println("5. Print hash set");
        System.out.println("6. Get hash code of the hash set");
        switch (intInput(6)) {
            case 1:
                System.out.print("Please enter a string to add to the hash set: ");
                hashSetTest.add(input.next());
                System.out.println("Element added.");
                break;
            case 2:
                System.out.print("Please enter a string to remove from the hash set: ");
                String elementToRemove = input.next();
                if (hashSetTest.remove(elementToRemove)) {
                    System.out.println("Element removed.");
                } else {
                    System.out.println("Element not found.");
                }
                break;
            case 3:
                System.out.print("Please enter a string to check: ");
                String elementToCheck = input.next();
                if (hashSetTest.contains(elementToCheck)) {
                    System.out.println("Element exists in the hash set.");
                } else {
                    System.out.println("Element does not exist in the hash set.");
                }
                break;
            case 4:
                System.out.println("The hash set has " + hashSetTest.size() + " elements.");
                break;
            case 5:
                for (String s : hashSetTest) {
                    System.out.print(s + " ");
                }
                System.out.println();
                break;
            case 6:
                System.out.println("The hash code of the hash set is: " + hashSetTest.hashCode());
                break;
            default:
                System.out.println(INVALID);
        }
        run();
    }

    public static void queueTests() {
        System.out.println(WHAT);
        System.out.println("1. Add an element");
        System.out.println("2. Remove an element");
        System.out.println("3. Peek at the first element");
        System.out.println("4. Get the size of queue");
        System.out.println("5. Print queue");
        switch (intInput(5)) {
            case 1:
                System.out.print("Please enter a string to add to the queue: ");
                queueTest.add(input.next());
                System.out.println("Element added.");
                break;
            case 2:
                String removedElement = queueTest.poll();
                if (removedElement != null) {
                    System.out.println("Element removed: " + removedElement);
                } else {
                    System.out.println("Queue is empty.");
                }
                break;
            case 3:
                String peekedElement = queueTest.peek();
                if (peekedElement != null) {
                    System.out.println("First element: " + peekedElement);
                } else {
                    System.out.println("Queue is empty.");
                }
                break;
            case 4:
                System.out.println("The queue has " + queueTest.size() + " elements.");
                break;
            case 5:
                for (String s : queueTest) {
                    System.out.print(s + " ");
                }
                System.out.println();
                break;
            default:
                System.out.println(INVALID);
        }
        run();
    }

    public static void hashMapTests() {
        System.out.println(WHAT);
        System.out.println("1. Add a key-value pair");
        System.out.println("2. Remove a key-value pair");
        System.out.println("3. Get a value by key");
        System.out.println("4. Get the size of hash map");
        System.out.println("5. Print hash map");
        System.out.println("6. Get hash code of the hash map");
        switch (intInput(6)) {
            case 1:
                System.out.print("Please enter a key (string): ");
                String key = input.next();
                System.out.print("Please enter a value (integer): ");
                int value = intInput();
                hashMapTest.put(key, value);
                System.out.println("Key-value pair added.");
                break;
            case 2:
                System.out.print("Please enter a key to remove: ");
                String keyToRemove = input.next();
                if (hashMapTest.remove(keyToRemove) != null) {
                    System.out.println("Key-value pair removed.");
                } else {
                    System.out.println("Key not found.");
                }
                break;
            case 3:
                System.out.print("Please enter a key to get its value: ");
                String keyToGet = input.next();
                Integer val = hashMapTest.get(keyToGet);
                if (val != null) {
                    System.out.println("The value for key \"" + keyToGet + "\" is " + val);
                } else {
                    System.out.println("Key not found.");
                }
                break;
            case 4:
                System.out.println("The hash map has " + hashMapTest.size() + " key-value pairs.");
                break;
            case 5:
                for (Map.Entry<String, Integer> entry : hashMapTest.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
                break;
            case 6:
                System.out.println("The hash code of the hash map is: " + hashMapTest.hashCode());
                break;
            default:
                System.out.println(INVALID);
        }
        run();
    }

    public static int intInput(int range) {
        while (true) {
            try {
                int num = input.nextInt();
                if (num >= 1 && num <= range) {
                    return num;
                } else {
                    System.out.println("Please input within the valid range of 1-" + range);
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer.");
                input.next(); // clear the invalid input
            }
        }
    }

    public static int intInput() {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please input an integer.");
                input.next(); // clear the invalid input
            }
        }
    }

    public static double doubleInput() {
        while (true) {
            try {
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please input a double.");
                input.next(); // clear the invalid input
            }
        }
    }
}
