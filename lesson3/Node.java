package lesson3;

public class Node {
	int value;
	Node prev;
	Node next;

	public Node(int data) {
		this.value = data;
		this.prev = null;
		this.next = null;
	}
}

class Numbers {
    Node head;
    Node tail;

    public Numbers() {
		this.head = null;
		this.tail = null;
	}

    public void add(int value) {
        Node node = new Node(value); 
        node.value = value;
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void add(int value, Node node) {
        Node next = node.next;
        Node newNode = new Node(value);
        newNode.value = value;
        node.next = newNode;
        newNode.prev = node;
        if (next == null){
            tail = newNode;
        }else{
            next.prev = newNode;
            newNode.next = next;
        }
    }

    public void delete(Node node) {
        Node previous = node.prev;
        Node next = node.next;
        if (previous == null){
            next.prev = null;
            head = next;
        }else{
            if(next == null){
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.prev = previous;
            }
        }
    }

    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void revert() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previuos = currentNode.prev;
            currentNode.next = previuos;
            currentNode.prev = next;
            if (previuos == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }
    public void revert1(){
        if (head != null && head.next !=null){
            revert1net(head.next, head);
        }

    }

    private void revert1net(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert1net(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    public void printList() {
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}

}
