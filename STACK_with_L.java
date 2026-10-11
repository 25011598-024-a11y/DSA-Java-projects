
import java.util.Scanner;

public class STACK_with_L {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    // Push: Insert element
    static void push(int value) {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println("Value pushed successfully.");
    }

    // Pop: Delete top element
    static void pop() {
        if (top == null) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            System.out.println("Popped value: " + top.data);
            top = top.next;
        }
    }

    // Display stack
    static void display() {
        if (top == null) {
            System.out.println("Stack is empty!");
        } else {
            Node temp = top;

            System.out.println("Stack elements (Top to Bottom):");

            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    // Peek: Show top element
    static void peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    // Size: Count elements
    static void size() {
        int count = 0;
        Node temp = top;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Current size: " + count);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- STACK MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    push(value);
                    break;

                case 2:
                    pop();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    peek();
                    break;

                case 5:
                    size();
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
