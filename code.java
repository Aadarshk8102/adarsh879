import java.util.*;
import java.io.*;

class Utility {
    // Utility method for prime checking
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Utility method for factorial calculation
    public static long factorial(int n) {
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Utility method for Fibonacci sequence
    public static List<Integer> generateFibonacci(int n) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fibonacci.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return fibonacci;
    }

    // Utility method for GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Utility method for LCM
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Utility method for Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

// A basic implementation of a Stack
class CustomStack<T> {
    private LinkedList<T> stack;

    public CustomStack() {
        this.stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}

// A basic implementation of a Queue
class CustomQueue<T> {
    private LinkedList<T> queue;

    public CustomQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue.removeFirst();
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

// Custom LinkedList Implementation
class CustomLinkedList<T> {
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int size() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Prime Number Check");
            System.out.println("3. Factorial Calculation");
            System.out.println("4. Fibonacci Sequence");
            System.out.println("5. Stack Operations");
            System.out.println("6. Queue Operations");
            System.out.println("7. LinkedList Operations");
            System.out.println("8. GCD and LCM");
            System.out.println("9. Bubble Sort");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performArithmetic(scanner);
                    break;
                case 2:
                    checkPrime(scanner);
                    break;
                case 3:
                    calculateFactorial(scanner);
                    break;
                case 4:
                    generateFibonacciSequence(scanner);
                    break;
                case 5:
                    handleStackOperations(scanner);
                    break;
                case 6:
                    handleQueueOperations(scanner);
                    break;
                case 7:
                    handleLinkedListOperations(scanner);
                    break;
                case 8:
                    calculateGcdAndLcm(scanner);
                    break;
                case 9:
                    performBubbleSort(scanner);
                    break;
                case 10:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void performArithmetic(Scanner scanner) {
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.println("Addition: " + (num1 + num2));
        System.out.println("Subtraction: " + (num1 - num2));
        System.out.println("Multiplication: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("Division: " + ((double) num1 / num2));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }

    private static void checkPrime(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (Utility.isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    private static void calculateFactorial(Scanner scanner) {
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("Factorial of " + num + " is " + Utility.factorial(num));
    }

    private static void generateFibonacciSequence(Scanner scanner) {
    System.out.print("Enter the number of terms: ");
    int n = scanner.nextInt();

    List<Integer> fibonacci = Utility.generateFibonacci(n);
    System.out.println("Fibonacci Sequence: " + fibonacci);
}
private static void checkPrime(Scanner scanner) {
    System.out.print("Enter a number: ");
    int num = scanner.nextInt();

    if (Utility.isPrime(num)) {
        System.out.println(num + " is a prime number.");
    } else {
        System.out.println(num + " is not a prime number.");
    }
}
private static void performArithmetic(Scanner scanner) {
    System.out.print("Enter first number: ");
    int num1 = scanner.nextInt();
    System.out.print("Enter second number: ");
    int num2 = scanner.nextInt();

    System.out.println("Addition: " + (num1 + num2));
    System.out.println("Subtraction: " + (num1 - num2));
    System.out.println("Multiplication: " + (num1 * num2));
    if (num2 != 0) {
        System.out.println("Division: " + ((double) num1 / num2));
    } else {
        System.out.println("Division by zero is not allowed.");
    }
}
private static void handleStackOperations(Scanner scanner) {
    CustomStack<Integer> stack = new CustomStack<>();
    boolean stackExit = false;

    while (!stackExit) {
        System.out.println("\n=== Stack Menu ===");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Size");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number to push: ");
                int value = scanner.nextInt();
                stack.push(value);
                System.out.println("Pushed " + value);
                break;
            case 2:
                try {
                    System.out.println("Popped: " + stack.pop());
                } catch (EmptyStackException e) {
                    System.out.println("Stack is empty.");
                }
                break;
            case 3:
                try {
                    System.out.println("Peek: " + stack.peek());
                } catch (EmptyStackException e) {
                    System.out.println("Stack is empty.");
                }
                break;
            case 4:
                System.out.println("Stack size: " + stack.size());
                break;
            case 5:
                stackExit = true;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
private static void handleQueueOperations(Scanner scanner) {
    CustomQueue<Integer> queue = new CustomQueue<>();
    boolean queueExit = false;

    while (!queueExit) {
        System.out.println("\n=== Queue Menu ===");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek");
        System.out.println("4. Size");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter a number to enqueue: ");
                int value = scanner.nextInt();
                queue.enqueue(value);
                System.out.println("Enqueued " + value);
                break;
            case 2:
                try {
                    System.out.println("Dequeued: " + queue.dequeue());
                } catch (NoSuchElementException e) {
                    System.out.println("Queue is empty.");
                }
                break;
            case 3:
                try {
                    System.out.println("Peek: " + queue.peek());
                } catch (NoSuchElementException e) {
                    System.out.println("Queue is empty.");
                }
                break;
            case 4:
                System.out.println("Queue size: " + queue.size());
                break;
            case 5:
                queueExit = true;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
private static void calculateGcdAndLcm(Scanner scanner) {
    System.out.print("Enter first number: ");
    int num1 = scanner.nextInt();
    System.out.print("Enter second number: ");
    int num2 = scanner.nextInt();

    System.out.println("GCD: " + Utility.gcd(num1, num2));
    System.out.println("LCM: " + Utility.lcm(num1, num2));
}
private static void performBubbleSort(Scanner scanner) {
    System.out.print("Enter the size of the array: ");
    int size = scanner.nextInt();
    int[] arr = new int[size];

    System.out.println("Enter array elements:");
    for (int i = 0; i < size; i++) {
        arr[i] = scanner.nextInt();
    }

    Utility.bubbleSort(arr);

    System.out.println("Sorted array: " + Arrays.toString(arr));
}
private static void checkPalindrome(Scanner scanner) {
    System.out.print("Enter a string: ");
    String input = scanner.next();
    String reversed = new StringBuilder(input).reverse().toString();

    if (input.equalsIgnoreCase(reversed)) {
        System.out.println(input + " is a palindrome.");
    } else {
        System.out.println(input + " is not a palindrome.");
    }
}
private static void playNumberGuessingGame(Scanner scanner) {
    Random random = new Random();
    int numberToGuess = random.nextInt(100) + 1;
    int attempts = 0;
    boolean guessed = false;

    System.out.println("Guess a number between 1 and 100!");

    while (!guessed) {
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        attempts++;

        if (guess == numberToGuess) {
            System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
            guessed = true;
        } else if (guess < numberToGuess) {
            System.out.println("Too low! Try again.");
        } else {
            System.out.println("Too high! Try again.");
        }
    }
}
private static void performBinarySearch(Scanner scanner) {
    System.out.print("Enter the size of the array: ");
    int size = scanner.nextInt();
    int[] arr = new int[size];

    System.out.println("Enter sorted array elements:");
    for (int i = 0; i < size; i++) {
        arr[i] = scanner.nextInt();
    }

    System.out.print("Enter the element to search: ");
    int key = scanner.nextInt();

    int index = Utility.binarySearch(arr, key);
    if (index != -1) {
        System.out.println("Element found at index: " + index);
    } else {
        System.out.println("Element not found.");
    }
}
private static void simpleCalculator(Scanner scanner) {
    System.out.println("Enter first number: ");
    double num1 = scanner.nextDouble();
    System.out.println("Enter second number: ");
    double num2 = scanner.nextDouble();
    System.out.println("Enter operation (+, -, *, /): ");
    char operation = scanner.next().charAt(0);

    double result;
    switch (operation) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Division by zero is not allowed.");
                return;
            }
            break;
        default:
            System.out.println("Invalid operation.");
            return;
    }
    System.out.println("The result is: " + result);
}
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Prime Number Check");
            System.out.println("3. Factorial Calculation");
            System.out.println("4. Fibonacci Sequence");
            System.out.println("5. Stack Operations");
            System.out.println("6. Queue Operations");
            System.out.println("7. LinkedList Operations");
            System.out.println("8. GCD and LCM");
            System.out.println("9. Bubble Sort");
            System.out.println("10. Palindrome Checker");
            System.out.println("11. Number Guessing Game");
            System.out.println("12. Binary Search");
            System.out.println("13. Simple Calculator");
            System.out.println("14. Matrix Multiplication");
            System.out.println("15. File Read/Write");
            System.out.println("16. Sort Strings Alphabetically");
            System.out.println("17. Generate Random Numbers");
            System.out.println("18. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performArithmetic(scanner);
                    break;
                case 2:
                    checkPrime(scanner);
                    break;
                case 3:
                    calculateFactorial(scanner);
                    break;
                case 4:
                    generateFibonacciSequence(scanner);
                    break;
                case 5:
                    handleStackOperations(scanner);
                    break;
                case 6:
                    handleQueueOperations(scanner);
                    break;
                case 7:
                    handleLinkedListOperations(scanner);
                    break;
                case 8:
                    calculateGcdAndLcm(scanner);
                    break;
                case 9:
                    performBubbleSort(scanner);
                    break;
                case 10:
                    checkPalindrome(scanner);
                    break;
                case 11:
                    playNumberGuessingGame(scanner);
                    break;
                case 12:
                    performBinarySearch(scanner);
                    break;
                case 13:
                    simpleCalculator(scanner);
                    break;
                case 14:
                    performMatrixMultiplication(scanner);
                    break;
                case 15:
                    handleFileOperations(scanner);
                    break;
                case 16:
                    sortStrings(scanner);
                    break;
                case 17:
                    generateRandomNumbers(scanner);
                    break;
                case 18:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    private static void checkPalindrome(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.next();
        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equalsIgnoreCase(reversed)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    private static void playNumberGuessingGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessed = false;

        System.out.println("Guess a number between 1 and 100!");

        while (!guessed) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessed = true;
            } else if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
    }

    private static void performBinarySearch(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the element to search: ");
        int key = scanner.nextInt();

        int index = Utility.binarySearch(arr, key);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }

    private static void simpleCalculator(Scanner scanner) {
        System.out.println("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("Enter operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        double result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }
        System.out.println("The result is: " + result);
    }

    private static void performMatrixMultiplication(Scanner scanner) {
        System.out.println("Enter the dimensions of the first matrix (rows and columns): ");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();
        System.out.println("Enter the dimensions of the second matrix (rows and columns): ");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        if (cols1 != rows2) {
            System.out.println("Matrix multiplication not possible with these dimensions.");
            return;
        }

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] result = new int[rows1][cols2];

        System.out.println("Enter elements of the first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter elements of the second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Resulting matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void handleFileOperations(Scanner scanner) {
        System.out.print("Enter the file name: ");
        String fileName = scanner.next();

        System.out.print("Enter text to write to the file: ");
        scanner.nextLine(); // Consume the leftover newline
        String content = scanner.nextLine();

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

        System.out.println("Reading the file content:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    private static void sortStrings(Scanner scanner) {
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        String[] strings = new String[n];

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }

        Arrays.sort(strings);
        System.out.println("Sorted strings:");
        for (String str : strings) {
            System.out.println(str);
        }
    }
}