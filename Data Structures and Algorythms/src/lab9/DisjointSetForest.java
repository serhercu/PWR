package lab9;

public class DisjointSetForest implements DisjointSetDataStructure {

    private class Element{
        int rank;
        int parent;
    }

    Element []arr;

    public DisjointSetForest(int size) {
        //TODO
        arr = new Element[size];
    }

    @Override
    public void makeSet(int item) {
        //TODO
        Element elem = new Element();
        elem.rank = 0;
        elem.parent = item;
        arr[item] = elem;
    }

    @Override
    public int findSet(int item) {
        //TODO
        Element elem = arr[item];

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

        Element elemA = arr[setA];
        Element elemB = arr[setB];

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
            Element elem = arr[i];
            result += i;
            result += " -> ";
            result += elem.parent;

            if (i < arr.length - 1) {
                result += "\n";
            }
        }
        return result;
    }
}
