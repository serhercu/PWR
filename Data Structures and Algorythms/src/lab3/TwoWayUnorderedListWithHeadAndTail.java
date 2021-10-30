package lab3;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class TwoWayUnorderedListWithHeadAndTail<E> implements IList<E>{

    private class Element{
        public Element(E e) {
            object = e;
            next = null;
            prev = null;
        }
        public Element(E e, Element next, Element prev) {
            object = e;
            this.next = next;
            this.prev = prev;
        }
        E object;
        Element next;
        Element prev;
    }

    Element head;
    Element tail;
    // can be realization with the field size or without
    //int size;

    private class InnerIterator implements Iterator<E>{
        Element pos;
        // TODO maybe more fields....

        public InnerIterator() {
            pos = head;
        }
        @Override
        public boolean hasNext() {
            return pos.next!=null && pos.next!=tail;
        }

        @Override
        public E next() {
            pos = pos.next;
            return pos.object;
        }
    }

    private class InnerListIterator implements ListIterator<E>{
        Element p;
        // TODO maybe more fields....

        public InnerListIterator() {
            p = head;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();

        }

        @Override
        public boolean hasNext() {
            return p.next != null && p.next != tail;
        }

        @Override
        public boolean hasPrevious() {
            return p.prev != null && p.prev != head;
        }

        @Override
        public E next() {
            p = p.next;
            return p.object;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public E previous() {
            p = p.prev;
            return p.object;
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
        public void set(E e) {
            p.object = e;

        }
    }

    public TwoWayUnorderedListWithHeadAndTail() {
        // make a head and a tail
        head = new Element(null, tail,null);
        tail =new Element(null,null, head);
        clear();
    }

    @Override
    public boolean add(E e) {
        InnerListIterator iterator = new InnerListIterator();
        Element newElement = new Element(e);

        while (iterator.hasNext()) {
            iterator.next();
        }

        newElement.prev = iterator.p;
        newElement.next = tail;
        iterator.p.next = newElement;
        tail.prev = newElement;

        return true;
    }

    @Override
    public void add(int index, E element) {
        InnerListIterator iterator = new InnerListIterator();
        Element newElement = new Element(element);

        while (iterator.hasNext() && index > 0) {
            iterator.next();
            index--;
        }

        if (iterator.p ==null || index > 0) {
            throw new NoSuchElementException();
        } else {
            newElement.prev =  iterator.p;
            newElement.next = iterator.p.next;
            iterator.p.next.prev = newElement;
            iterator.p.next = newElement;
        }
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public boolean contains(E element) {
        InnerListIterator iterator = new InnerListIterator();
        while(iterator.hasNext()) {
            iterator.next();
            if (iterator.p.object.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        InnerListIterator iterator = new InnerListIterator();

        while (iterator.hasNext() && index >= 0) {
            iterator.next();
            index--;
        }

        if(iterator.p == null || index >= 0) {
            throw new NoSuchElementException();
        } else {
            return iterator.p.object;
        }
    }

    @Override
    public E set(int index, E element) {
        E res = null;
        InnerListIterator iterator = new InnerListIterator();
        Element newElem = new Element(element);

        while (iterator.hasNext() && index >= 0) {
            iterator.next();
            index--;
        }

        if (iterator.p.equals(head) || iterator.p.equals(tail)|| index >= 0) {
            throw new NoSuchElementException();
        } else {
            res = iterator.p.object;
            newElem.next = iterator.p.next;
            newElem.prev =  iterator.p.prev;
            iterator.p.next.prev = newElem;
            iterator.p.prev.next = newElem;
        }

        return res;
    }

    @Override
    public int indexOf(E element) {
        int index = 0;
        InnerListIterator iter = new InnerListIterator();

        while (iter.hasNext()) {
            iter.next();
            if(iter.p.object.equals(element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return head.next == tail && tail.prev == head;
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
    public E remove(int index) {
        E res = null;
        InnerListIterator iterator = new InnerListIterator();
        
        while(iterator.hasNext() && index >= 0) {
            iterator.next();
            index--;
            
        }
        if(iterator.p ==null || index >= 0) {
            throw new NoSuchElementException();
        } else {
            res = iterator.p.object;
            iterator.p.prev.next = iterator.p.next;
            iterator.p.next.prev = iterator.p.prev;
        }
        return res;
    }

    @Override
    public boolean remove(E e) {
        InnerListIterator iterator = new InnerListIterator();
        while(iterator.hasNext()) {
            iterator.next();
            if (iterator.p.object.equals(e)) {
                iterator.p.prev.next = iterator.p.next;
                iterator.p.next.prev = iterator.p.prev;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        InnerListIterator iterator = new InnerListIterator();

        while (iterator.hasNext() ) {
            iterator.next();
            size++;
        }

        return size;
    }

    public String toStringReverse() {
        String retStr = "";
        InnerListIterator iter = new InnerListIterator();

        while (iter.hasNext()) {
            iter.next();
        }

        retStr += "\n";

        while (iter.hasPrevious()) {
            retStr = retStr + iter.p.object.toString() + "\n";
            iter.previous();
        }

        if (!this.isEmpty()) {
            retStr += iter.p.object.toString();
        } else {
            return "";
        }
        return retStr;
    }

    public void add(TwoWayUnorderedListWithHeadAndTail<E> other) {
        if(!this.equals(other) && other.isEmpty()) {
            Element elemTailThis = this.tail.prev;
            Element elemHeadOther = other.head.next;

            elemTailThis.next = elemHeadOther;
            elemHeadOther.prev = elemTailThis;

            tail.prev = other.tail.prev;
            other.tail.prev.next = tail;

            other.clear();
        }
    }
}
