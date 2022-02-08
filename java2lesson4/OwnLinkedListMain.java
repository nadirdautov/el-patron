package java2lesson4;

public class OwnLinkedListMain {
    public static void main(String[] args) {
        OwnLinkedList<Integer> integerOwnLinkedList = new OwnLinkedList<>();
        integerOwnLinkedList.addNode(123);
        integerOwnLinkedList.addNode(456);
        integerOwnLinkedList.addNode(555);
        integerOwnLinkedList.addNode(999);



        /*integerOwnLinkedList.addNodeForIndex(2,444);
        integerOwnLinkedList.addNodeForIndex(5,444);
        integerOwnLinkedList.display();
        System.out.println();
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.display();
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.display();
        integerOwnLinkedList.deleteNodeForIndex(1);
        integerOwnLinkedList.display();*/
        integerOwnLinkedList.deleteNodeForIndex(3);
        integerOwnLinkedList.display();
        integerOwnLinkedList.deleteNodeForIndex(2);
        integerOwnLinkedList.display();

    }
}
