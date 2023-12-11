package src.intern.collections;

public class MyNode {
    private MyNode prev;
    private Object value;
    private MyNode next;

    public MyNode(MyNode prev, Object value, MyNode next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getPrev() {
        return prev;
    }

    public void setPrev(MyNode prev) {
        this.prev = prev;
    }
}
