package lab9;

import java.util.HashSet;
import java.util.Set;

public class DisjointSetLinkedList implements DisjointSetDataStructure {

    private class Element{
        Element representant;
        Element next;
        int length;
        Element last;
        int value;
    }

    private static final int NULL=-1;

    Element arr[];

    public DisjointSetLinkedList(int size) {
        //TODO
        arr = new Element[size];
    }

    @Override
    public void makeSet(int item) {
        //TODO
        Element elem = new Element();
        elem.representant = elem;
        elem.next = null;
        elem.length = 1;
        elem.last = elem;
        elem.value= item;
        arr[item] = elem;
    }

    @Override
    public int findSet(int item) {
        //TODO
        return arr[item].representant.value;
    }

    @Override
    public boolean union(int itemA, int itemB) {
        //TODO
        Element repA = arr[itemA].representant;
        Element repB = arr[itemB].representant;

        if (repA.value == repB.value) {
            return false;
        }

        if (repB.length > repA.length) {
            Element aux = repA;
            repA = repB;
            repB = aux;
        }

        Element lastA = repA.last;
        lastA.next = repB;
        repA.last = repB.last;

        while (repB != null) {
            repA.length++;
            repB.representant = repA;
            repB = repB.next; 
        }
        return true;
    }


    @Override
    public String toString() {
        //TODO
        String result = "Disjoint sets as linked list:\n";
        Set<Integer> processed = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            Element e = arr[i].representant;
            if (!processed.contains(e.value)) {
                processed.add(e.value);
                while (e != null) {
                    result += e.value;
                    e = e.next;

                    if (e != null) {
                        result += ", ";
                    }
                }

                if (i < arr.length - 2) {
                    result += "\n";
                }
            }
        }
        return result;
    }
}