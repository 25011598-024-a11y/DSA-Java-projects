
import java.util.Scanner;

public class QUEUEusingarr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] queue = new int[5];
        int front = -1;
        int rear = -1;
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
                    if (rear == queue.length - 1) {
                        System.out.println("Queue is Full!");
                    } else {
                        System.out.print("Enter value: ");
                        int value = sc.nextInt();

                        if (front == -1) {
                            front = 0;
                        }

                        rear++;
                        queue[rear] = value;

                        System.out.println("Value inserted successfully.");
                    }
                    break;

                case 2:
                    if (front == -1 || front > rear) {
                        System.out.println("Queue is Empty!");
                    } else {
                        System.out.println(
                            "Deleted value: " + queue[front]);
                        front++;

                        if (front > rear) {
                            front = -1;
                            rear = -1;
                        }
                    }
                    break;

                case 3:
                    if (front == -1) {
                        System.out.println("Queue is Empty!");
                    } else {
                        System.out.println("Queue elements:");
                        for (int i = front; i <= rear; i++) {
                            System.out.print(queue[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    if (front == -1) {
                        System.out.println("Queue is Empty!");
                    } else {
                        System.out.println(
                            "Front element: " + queue[front]);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
