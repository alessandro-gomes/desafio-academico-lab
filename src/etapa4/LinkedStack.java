package etapa4;

public class LinkedStack<E> implements Stack<E> {

    private int size;
    private Node<E> top;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("O elemento não pode ser nulo.");
        }
        Node<E> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getElement();
    }

    public String toString() {
        String result = "[";
        Node<E> current = top;
        while (current != null) {
            result += current.getElement();
            current = current.getNext();
            if (current != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

}
