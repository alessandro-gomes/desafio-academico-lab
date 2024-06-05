package etapa4;

public class LinkedQueue<E> implements Queue<E> {

    private Node<E> front;
    private Node<E> back;
    private int size;

    public LinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
    public void enqueue(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("O elemento não pode ser nulo.");
        }

        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        E element = front.getElement();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            back = null;
        }

        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return front.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return back.getElement();
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        String result = "[";
        Node<E> current = front;

        while (current != null) {
            result += current.getElement();
            if (current.getNext() != null) {
                result += ", ";
            }
            current = current.getNext();
        }
        result += "]";

        return result;
    }

}
