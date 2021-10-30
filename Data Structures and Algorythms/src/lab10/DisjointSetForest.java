package lab10;

import java.util.HashSet;
import java.util.Set;

public class DisjointSetForest implements DisjointSetDataStructure {

    class Element{
        int rank;
        int parent;
    }

    Element []arr;

    public DisjointSetForest(int size) {
        //TODO
        arr = new DisjointSetForest.Element[size];
    }

    @Override
    public void makeSet(int item) {
        //TODO
        DisjointSetForest.Element elem = new DisjointSetForest.Element();
        elem.rank = 0;
        elem.parent = item;
        arr[item] = elem;
    }

    @Override
    public int findSet(int item) {
        //TODO
        DisjointSetForest.Element elem = arr[item];

        if (item != elem.parent) {
            elem.parent = findSet(elem.parent);
        }
        return elem.parent;
    }

    @Override
    public boolean union(int itemA, int itemB) {
        //TODO
        int setA = findSet(itemA);
        int setB = findSet(itemB);

        if (setA == setB) {
            return false;
        }

        DisjointSetForest.Element elemA = arr[setA];
        DisjointSetForest.Element elemB = arr[setB];

        if (elemA.rank > elemB.rank) {
            elemB.parent = setA;
        }

        else {
            elemA.parent = setB;
            if (elemA.rank == elemB.rank)
            {
                elemB.rank++;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        //TODO
        String result = "Disjoint sets as forest:\n";

        for (int i = 0; i < arr.length; i++)
        {
            DisjointSetForest.Element elem = arr[i];
            result += i;
            result += " -> ";
            result += elem.parent;

            if (i < arr.length - 1) {
                result += "\n";
            }
        }
        return result;
    }

    @Override
    public int countSets() {
        // TODO
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            uniques.add(arr[i].parent);
        }
        return uniques.size();
    }
}