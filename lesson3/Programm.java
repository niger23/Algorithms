package lesson3;

public class Programm {
    public static void main(String[] args) {
        Numbers newNode = new Numbers();
        newNode.add(123);
        newNode.add(234);
        newNode.add(345);

        newNode.printList();

        newNode.revert();

        newNode.printList();
    }
}
