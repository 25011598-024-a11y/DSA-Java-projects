
import java.util.Scanner;

public class QUEUE_L {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node front = null;
    static Node rear = null;

    // Enqueue: Insert element
    static void enqueue(int value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Value inserted successfully.");
    }

    // Dequeue: Delete element
    static void dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println("Deleted value: " + front.data);
        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    // Display queue
    static void display() {
        if (front == null) {
            System.out.println("Queue is Empty!");
            return;
        }

        Node temp = front;

        System.out.println("Queue elements:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Peek: Show front element
    static void peek() {
        if (front == null) {
            System.out.println("Queue is Empty!");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- QUEUE MENU -----");
            System.out.println("1. Enqueue (Insert)");
            System.out.println("2. Dequeue (Delete)");
            System.out.println("3. Display");
            System.out.println("4. Peek");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    peek();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
