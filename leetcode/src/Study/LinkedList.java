package Study;

/**
 * @author Administrator
 * @Date 2025/8/23 20:29
 * @package Study
 * @Description: 链表在的java中实现，带哨兵，双向
 */
public class LinkedList {
    private Node head = null;
    private int length;
    private Node tail = null;

    public LinkedList() {
        head = new Node(0);
        tail = new Node(0);
        head.setNextNode(tail);
        tail.setPreNode(head);
        this.length = 0;

    }
    public Node findNode(int index){
            int i = 0;
        for (Node curr = head.getNextNode();curr!=tail;curr = curr.getNextNode(),i++){
            if (i == index)
                return curr;
        }
        return null;
    }

    public void addNode(int value){

        Node newNode = new Node(value);
        this.tail.setNextNode(newNode);
        this.tail = newNode;
        length++;
    }


    }

class Node{
    private Node nextNode;
    private Node preNode;
    private int value;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
        this.preNode = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }
}
