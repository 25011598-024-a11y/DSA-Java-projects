
import java.util.Scanner;

public class STACK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] stack = new int[5];
        int top = -1;
        int choice;

        do {
            System.out.println("\n----- STACK MENU -----");
            System.out.println("1. Push (Insert)");
            System.out.println("2. Pop (Delete)");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Push
                    if (top == stack.length - 1) {
                        System.out.println("Stack Overflow! Stack is full.");
                    } else {
                        System.out.print("Enter value: ");
                        int value = sc.nextInt();

                        top++;
                        stack[top] = value;

                        System.out.println("Value pushed successfully.");
                    }
                    break;

                case 2:
                    // Pop
                    if (top == -1) {
                        System.out.println("Stack Underflow! Stack is empty.");
                    } else {
                        System.out.println("Popped value: " + stack[top]);
                        top--;
                    }
                    break;

                case 3:
                    // Display
                    if (top == -1) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Stack elements (top to bottom):");
                        for (int i = top; i >= 0; i--) {
                            System.out.println(stack[i]);
                        }
                    }
                    break;

                case 4:
                    // Peek
                    if (top == -1) {
                        System.out.println("Stack is empty!");
                    } else {
                        System.out.println("Top element: " + stack[top]);
                    }
                    break;

                case 5:
                    // Size
                    System.out.println("Current size: " + (top + 1));
                    System.out.println("Maximum capacity: " + stack.length);
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
