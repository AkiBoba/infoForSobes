package src.intern.collections;

public class MyLinkedList implements CollectionsInterface {
    private MyNode head = null;
    private MyNode tail = null;
    private int size = 0;

    @Override
    public void add(Object element) {
        if (size == 0) {
            head = new MyNode(null, element, null);
            tail = head;
        } else {
            MyNode secTail = tail;
            tail = new MyNode(secTail, element, null);
            secTail.setNext(tail);
        }
        size++;
    }

    @Override
    public void add(int index, Object element) {
        checkIndex(index);
        if (index == 0) {
            MyNode tempHead = new MyNode(null, element, head);
            head = tempHead;
        }
        if (index == size - 1) {
            MyNode prevTail = getNode(index - 1);
            MyNode newNode = new MyNode(prevTail, element, null);
            prevTail.setNext(newNode);
            tail.setPrev(newNode);
            newNode.setNext(tail);
        }
        size++;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        if (index == 0) {
            getNode(index + 1).setPrev(null);
            size--;
            return true;
        }
        if (index == size - 1) {
            MyNode newTail = getNode(index - 1);
            newTail.setNext(null);
            tail = newTail;
            size--;
            return true;
        }
        MyNode remNode = getNode(index);
        MyNode prevInd = remNode.getPrev();
        MyNode nextInd = remNode.getNext();
        prevInd.setNext(nextInd);
        nextInd.setPrev(prevInd);
        size--;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) return head.getValue();
        if (index == size - 1) return tail.getValue();
        MyNode forCheck = head;
        for (int i = 1; i < size - 1; i++) {
            forCheck = forCheck.getNext();
            if (i == index) break;
        }
        return forCheck.getValue();
    }


    private MyNode getNode(int index) {
        checkIndex(index);
        if (index == 0) return head;
        if (index == size - 1) return tail;
        MyNode forCheck = head;
        for (int i = 1; i < size - 1; i++) {
            forCheck = forCheck.getNext();
            if (i == index) break;
        }
        return forCheck;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {

    }

    private void checkIndex(int index) {
        if (index < 0||index > size) throw new IndexOutOfBoundsException();
    }
}
