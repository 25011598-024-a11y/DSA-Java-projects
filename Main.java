import java.util.Scanner;

public class Main {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static int size = 0;

    static final int CAPACITY = 5;
    static Scanner sc = new Scanner(System.in);

    static int getIndex(String message) {
        System.out.print(message);

        if (!sc.hasNextInt()) {
            System.out.println("Invalid index!");
            sc.nextLine();
            return -1;
        }

        int index = sc.nextInt();
        sc.nextLine();
        return index;
    }

    static Node getNode(int index) {
        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    static void add(String value) {
        Node newNode = new Node(value);

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

    static void insert(int index, String value) {
        Node newNode = new Node(value);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = getNode(index - 1);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        size++;
    }

    static String delete(int index) {
        String deleted;

        if (index == 0) {
            deleted = head.data;
            head = head.next;
        } else {
            Node previous = getNode(index - 1);
            deleted = previous.next.data;
            previous.next = previous.next.next;
        }

        size--;
        return deleted;
    }

    static void display() {
        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        Node current = head;
        System.out.print("Book IDs: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n----- LINKED LIST MENU -----");
            System.out.println("1. Add value");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill list");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search value");
            System.out.println("8. Get value at index");
            System.out.println("9. Replace/Update value at index");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice! Enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    if (size >= CAPACITY) {
                        System.out.println("List is full!");
                    } else {
                        System.out.print("Enter book ID: ");
                        add(sc.nextLine());
                        System.out.println("Book ID added.");
                    }
                    break;

                case 2: {
                    if (size >= CAPACITY) {
                        System.out.println("List is full!");
                        break;
                    }

                    int index = getIndex("Enter index: ");

                    if (index < 0 || index > size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.print("Enter book ID: ");
                        insert(index, sc.nextLine());
                        System.out.println("Book ID inserted.");
                    }
                    break;
                }

                case 3:
                    while (size < CAPACITY) {
                        System.out.print("Enter book ID: ");
                        add(sc.nextLine());

                        if (size == CAPACITY) {
                            System.out.println("List is full!");
                            break;
                        }

                        System.out.print("Add another? (y/n): ");

                        if (!sc.nextLine().equalsIgnoreCase("y")) {
                            break;
                        }
                    }

                    System.out.println("Filling completed.");
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("List is empty!");
                    } else {
                        System.out.println(
                            "Deleted: " + delete(size - 1)
                        );
                    }
                    break;

                case 5: {
                    if (size == 0) {
                        System.out.println("List is empty!");
                        break;
                    }

                    int index = getIndex("Enter index to delete: ");

                    if (index < 0 || index >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.println(
                            "Deleted: " + delete(index)
                        );
                    }
                    break;
                }

                case 6:
                    display();
                    break;

                case 7: {
                    System.out.print("Enter book ID to search: ");
                    String value = sc.nextLine();

                    Node current = head;
                    int index = 0;
                    boolean found = false;

                    while (current != null) {
                        if (current.data.equals(value)) {
                            System.out.println(
                                "Book ID found at index: " + index
                            );
                            found = true;
                        }

                        current = current.next;
                        index++;
                    }

                    if (!found) {
                        System.out.println("Book ID not found.");
                    }
                    break;
                }

                case 8: {
                    int index = getIndex("Enter index: ");

                    if (index < 0 || index >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.println(
                            "Value: " + getNode(index).data
                        );
                    }
                    break;
                }

                case 9: {
                    int index = getIndex("Enter index to update: ");

                    if (index < 0 || index >= size) {
                        System.out.println("Invalid index!");
                    } else {
                        System.out.print("Enter new book ID: ");
                        getNode(index).data = sc.nextLine();
                        System.out.println("Book ID updated.");
                    }
                    break;
                }

                case 10:
                    System.out.println("Current size: " + size);
                    System.out.println("Maximum capacity: " + CAPACITY);
                    break;

                case 11:
                    System.out.println("Program exited successfully.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Select 1-11.");
            }
        }
    }
}