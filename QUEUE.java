
import java.util.Scanner;

public class QUEUE {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the maximum capacity of the queue: ");
        int capacity = input.nextInt();

        int[] queue = new int[capacity];
        int front = 0;
        int rear = -1;
        int size = 0;
        int choice;

        do {
            System.out.println("\n----- QUEUE MENU -----");
            System.out.println("1. Enqueue (Add value)");
            System.out.println("2. Dequeue (Remove value)");
            System.out.println("3. Display queue");
            System.out.println("4. Peek (Front value)");
            System.out.println("5. Search value");
            System.out.println("6. Size");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    // Enqueue
                    if (size == capacity) {
                        System.out.println("Queue is full!");
                    } else {
                        System.out.print("Enter value: ");
                        int value = input.nextInt();

                        rear = (rear + 1) % capacity;
                        queue[rear] = value;
                        size++;

                        System.out.println("Value added successfully.");
                    }
                    break;

                case 2:
                    // Dequeue
                    if (size == 0) {
                        System.out.println("Queue is empty!");
                    } else {
                        int deleted = queue[front];
                        front = (front + 1) % capacity;
                        size--;

                        System.out.println("Removed value: " + deleted);
                    }
                    break;

                case 3:
                    // Display queue
                    if (size == 0) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println("Queue elements:");
                        for (int i = 0; i < size; i++) {
                            int index = (front + i) % capacity;
                            System.out.print(queue[index] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    // Peek
                    if (size == 0) {
                        System.out.println("Queue is empty!");
                    } else {
                        System.out.println(
                                "Front value: " + queue[front]);
                    }
                    break;

                case 5:
                    // Search
                    System.out.print("Enter value to search: ");
                    int search = input.nextInt();
                    boolean found = false;

                    for (int i = 0; i < size; i++) {
                        int index = (front + i) % capacity;

                        if (queue[index] == search) {
                            System.out.println(
                                    "Value found at queue position " + i);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Value not found.");
                    }
                    break;

                case 6:
                    // Size
                    System.out.println("Current size: " + size);
                    System.out.println("Maximum capacity: " + capacity);
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        input.close();
    }
}
