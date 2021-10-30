package lab2;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OneWayLinkedList<E> implements IList<E>{

    private class Element{
        public Element(E e) {
            this.object=e;
        }
        E object;
        Element next=null;

        public E getValue() {
            return object;
        }

        public void setValue(E value) {
            this.object = value;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    Element sentinel;

    private class InnerIterator implements Iterator<E>{
        // TODO
        Element actElem;
        public InnerIterator() {
            // TODO
            actElem = sentinel;
        }
        @Override
        public boolean hasNext() {
            // TODO
            return actElem != null;
        }

        @Override
        public E next() {
            // TODO
            E value = actElem.getValue();
            actElem = actElem.getNext();
            return value;
        }
    }

    public OneWayLinkedList() {
        // make a sentinel
        // TODO
        sentinel = new Element(null);
        sentinel.next = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(E e) {
        // TODO Auto-generated method stub
        Element actElem = sentinel;
        Element newElem = new Element(e);

        while(actElem.getNext() != null) {
            actElem = actElem.getNext();
        }

        actElem.setNext(newElem);
        newElem.setNext(null);

        return true;
    }

    @Override
    public void add(int index, E element) throws NoSuchElementException {
        // TODO Auto-generated method stub
        if (index < 0) { throw new NoSuchElementException(); }

        Element newElem = new Element(element);
        Element actElem = sentinel;

        while(index > 0 && actElem != null) {
            index--;
            actElem = actElem.getNext();
        }

        if(actElem == null) {throw new NoSuchElementException(); }

        newElem.setNext(actElem.getNext());
        actElem.setNext(newElem);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        sentinel.next = null;

    }

    @Override
    public boolean contains(E element) {
        // TODO Auto-generated method stub
        Element actElem = sentinel;

        while (actElem.getNext() != null) {
            actElem = actElem.getNext();
            if (actElem.getValue().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) throws NoSuchElementException {
        // TODO Auto-generated method stub
        if(index < 0) { throw new NoSuchElementException(); }

        Element actElem = sentinel;

        while(actElem != null && index >= 0) {
            actElem = actElem.getNext();
            index--;
        }

        if(actElem == null) { throw new NoSuchElementException(); }

        return actElem.getValue();
    }

    @Override
    public E set(int index, E element) throws NoSuchElementException {
        // TODO Auto-generated method stub
        Element actElem = sentinel;

        while(actElem != null && index >= 0) {
            actElem = actElem.getNext();
            index--;
        }

        if(actElem == null) { throw new NoSuchElementException(); }

        E previousElement = actElem.getValue();
        actElem.setValue(element);
        return previousElement;
    }

    @Override
    public int indexOf(E element) {
        // TODO Auto-generated method stub
        int index = 0;
        Element actElem = sentinel;

        while(actElem.getNext() != null) {
            actElem = actElem.getNext();
            if (actElem.getValue().equals(element)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return sentinel.next == null;
    }

    @Override
    public E remove(int index) throws NoSuchElementException {
        // TODO Auto-generated method stub
        Element actElem = sentinel;

        while(index > 0 && actElem != null) {
            actElem = actElem.getNext();
            index--;
        }

        if(actElem == null || actElem.getNext() == null) { throw new NoSuchElementException(); }

        E removedElement = actElem.getNext().getValue();
        actElem.setNext(actElem.getNext().getNext());

        return removedElement;
    }

    @Override
    public boolean remove(E e) {
        // TODO Auto-generated method stub
        Element actElem = sentinel;

        while(actElem.getNext() != null) {
            if(actElem.getNext().getValue().equals(e)) {
                actElem.setNext(actElem.getNext().getNext());
                return true;
            }
            actElem = actElem.getNext();
        }
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        int size = 0;
        Element actElem = sentinel;

        while(actElem.getNext() != null) {
            size++;
            actElem = actElem.getNext();
        }
        return size;
    }

}
