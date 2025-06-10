package kleave;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class linkedlist {
    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void rehead(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void read() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public String whole() {
        if (head == null) return "List is empty.";

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }

        return sb.toString();
    }
    public void traverse(java.util.function.IntConsumer action) {
        traverseRecursive(head, action);
    }

    private void traverseRecursive(Node node, java.util.function.IntConsumer action) {
        if (node == null) return;
        action.accept(node.data);
        traverseRecursive(node.next, action);
    }

    public linkedlist reverse() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        return this;
    }
}