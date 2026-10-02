public class LinkedList<E> implements List<E> {
    private Nodo<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(E e) {
        Nodo<E> node = new Nodo<>(e);
        if (isEmpty()) {
            head = node;
        } else {
            Nodo<E> cursor = head;
            while (cursor.getNext() != null) {
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
        size++;
    }

    @Override
    public void add(E e, int index) {
        if (index >= 0 && index <= size()) {
            if (index == 0) {
                head = new Nodo<>(e, head);
            } else {
                Nodo<E> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                Nodo<E> node = new Nodo<>(e);
                node.setNext(cursor.getNext());
                cursor.setNext(node);
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index < size) {
            Nodo<E> aux;
            if (index == 0) {
                aux = head;
                head = head.getNext();
            } else {
                Nodo<E> cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.getNext();
                }
                aux = cursor.getNext();
                cursor.setNext(aux.getNext());
            }
            size--;
            return aux.getData();
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < size) {
            Nodo<E> cursor = head;
            for (int i=0;i<index;i++) {
                cursor = cursor.getNext();
            }
            return cursor.getData();
        } else {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean removeDuplicates() {
        if (isEmpty()) {
            return false;
        }
        Nodo<E> cursor = head;
        while (cursor != null) {
            Nodo<E> cursor1 = cursor;
            while (cursor1.getNext() != null) {
                if (cursor.getData().equals(cursor1.getNext().getData())) {
                    cursor1.setNext(cursor1.getNext().getNext());
                    size--;
                } else {
                    cursor1 = cursor1.getNext();
                }
            }
            cursor = cursor.getNext();
        }
        return true;
    }

    public void rotateRight(){
        if(size <= 1){
            return;
        }
        Nodo<E> cursor = head;
        while(cursor.getNext().getNext() != null){
            cursor = cursor.getNext();
        }
        Nodo<E> lastNode = cursor.getNext();
        cursor.setNext(null);
        lastNode.setNext(head);
        head = lastNode;
    }

    public void concatenate(LinkedList<E> other){
        if(other.isEmpty()){
            return;
        }
        if(this.isEmpty()){
            this.head = other.head;
            this.size = other.size;
            return;
        }
        Nodo<E> cursor = head;
        while(cursor.getNext() != null){
            cursor = cursor.getNext();
        }
        cursor.setNext(other.head);
        this.size += other.size;
    }
}