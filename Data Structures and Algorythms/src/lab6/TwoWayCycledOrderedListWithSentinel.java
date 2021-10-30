package lab6;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class TwoWayCycledOrderedListWithSentinel<E> implements IList<E> {

    private class Element{
        public Element(E e) {
            //TODO
            this.object = e;
            this.next = null;
            this.prev = null;
        }
        public Element(E e, Element next, Element prev) {
            //TODO
            this.object = e;
            this.next = next;
            this.prev = prev;
        }
        // add element e after this
        public void addAfter(Element elem) {
            //TODO
            elem.next = this.next;
            elem.prev = this;
            this.next.prev = elem;
            this.next = elem;
        }
        // assert it is NOT a sentinel
        public void remove() {
            //TODO
            this.next.prev = this.prev;
            this.prev.next = this.next;
        }
        E object;
        Element next=null;
        Element prev=null;
    }


    Element sentinel;
    int size;

    private class InnerIterator implements Iterator<E>{
        //TODO
        Element actElem;
        public InnerIterator() {
            //TODO
            actElem = sentinel;
        }
        @Override
        public boolean hasNext() {
            //TODO
            return this.actElem.next != sentinel;
        }

        @Override
        public E next() {
            //TODO
            E element = actElem.object;
            actElem = actElem.next;
            return element;
        }
    }

    private class InnerListIterator implements ListIterator<E>{
        //TODO
        Element actElem;
        public InnerListIterator() {
            //TODO
            actElem = sentinel;
        }
        @Override
        public boolean hasNext() {
            //TODO
            return this.actElem.next != sentinel;
        }

        @Override
        public E next() {
            //TODO
            E element = actElem.object;
            actElem = actElem.next;
            return element;
        }
        @Override
        public void add(E arg0) {
            throw new UnsupportedOperationException();
        }
        @Override
        public boolean hasPrevious() {
            //TODO
            return this.actElem.prev != sentinel;
        }
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }
        @Override
        public E previous() {
            //TODO
            actElem = actElem.prev;
            return actElem.object;
        }
        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
        @Override
        public void set(E arg0) {
            throw new UnsupportedOperationException();
        }
    }
    public TwoWayCycledOrderedListWithSentinel() {
        //TODO
        sentinel = new Element(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        this.size = 0;
    }

    //@SuppressWarnings("unchecked")
    @Override
    public boolean add(E e) {
        //TODO
        Element newElem = new Element(e);
        Element actElem = this.sentinel;
        Link link = (Link) e;

        while (actElem.next != this.sentinel) {
            Link nextLink = (Link) actElem.next.object;

            if (link.compareTo(nextLink) < 0) {
                actElem.addAfter(newElem);
                this.size++;
                return true;
            } else {
                actElem = actElem.next;
            }
        }
        actElem.addAfter(newElem);
        this.size++;
        return true;
    }

    private Element getElement(int index) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();

        while (index >= 0 && iterator.hasNext()) {
            iterator.next();
            index--;
        }

        if (iterator.actElem == null || index >= 0) {
            throw new NoSuchElementException();
        } else {
            return iterator.actElem;
        }
    }

    private Element getElement(E obj) {
        //TODO
        return null;
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void clear() {
        //TODO
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
        this.size = 0;
    }

    @Override
    public boolean contains(E element) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();

        while (iterator.hasNext()) {
            iterator.next();

            if (iterator.actElem.object.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        //TODO
        if (index >= 0 && index < size) {
            return this.getElement(index).object;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(E element) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();
        int index = 0;

        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.actElem.object.equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return this.sentinel.next == sentinel && size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new InnerIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new InnerListIterator();
    }

    @Override
    public E remove(int index) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();
        E removed = null;

        while (iterator.hasNext() && index >= 0) {
            index--;
            iterator.next();
        }

        if (iterator.actElem == null || index >= 0) {
            throw new NoSuchElementException();
        } else {
            removed = iterator.actElem.object;
            iterator.actElem.prev.next = iterator.actElem.next;
            iterator.actElem.next.prev = iterator.actElem.prev;
            size--;
        }

        return removed;
    }

    @Override
    public boolean remove(E e) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();

        while (iterator.hasNext()) {
            iterator.next();
            if (iterator.actElem.object.equals(e)) {
                iterator.actElem.prev.next = iterator.actElem.next;
                iterator.actElem.next.prev = iterator.actElem.prev;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        //TODO
        return size;
    }

    //@SuppressWarnings("unchecked")
    public void add(TwoWayCycledOrderedListWithSentinel<E> other) {
        //TODO
        if (!this.equals(other) && !other.isEmpty()) {
            Element last = sentinel;
            ListIterator<E> iterator = other.listIterator();
            iterator.next();

            while (iterator.hasNext()) {
                this.add(iterator.next());
            }
            this.add(iterator.next());
            other.clear();
        }
    }

    //@SuppressWarnings({ "unchecked", "rawtypes" })
    public void removeAll(E e) {
        //TODO
        InnerListIterator iterator = new InnerListIterator();

        if (!this.isEmpty()) {
            iterator.next();
            while (iterator.hasNext()) {
                E next = iterator.next();

                if (next.equals(e)) {
                    iterator.actElem.prev.prev.next = iterator.actElem;
                    iterator.actElem.prev = iterator.actElem.prev.prev;
                }
            }
        }
    }

    public String toString() {
        String retStr = "";
        InnerListIterator iterator = new InnerListIterator();

        if (iterator.hasNext()) {
            retStr = "\n";
        }

        while (iterator.hasNext()) {
            iterator.next();
            retStr = retStr + iterator.actElem.object.toString() + " ";
        }

        return retStr;
    }

    public String toStringReverse() {
        String retStr = "";
        InnerListIterator iterator = new InnerListIterator();

        while (iterator.hasNext()) {
            iterator.next();
        }

        if (!this.isEmpty()) {
            retStr += "\n";
            iterator.next();
        }

        while (iterator.hasPrevious()) {
            iterator.previous();
            retStr = retStr + iterator.actElem.object.toString() + " ";
        }
        return retStr;
    }
}
