package lab7;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashTable{
    LinkedList arr[]; // use pure array
    private final static int defaultInitSize=8;
    private final static double defaultMaxLoadFactor=0.7;
    private int size;
    private final double maxLoadFactor;

    private int threshold;

    public HashTable() {
        this(defaultInitSize);
    }

    public HashTable(int size) {
        this(size,defaultMaxLoadFactor);
    }

    @SuppressWarnings("unchecked")
    public HashTable(int initCapacity, double maxLF) {
        //TODO
        this.maxLoadFactor=maxLF;

        if (initCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initCapacity);
        }

        if (maxLF <= 0 || Double.isNaN(maxLF)) {
            throw new IllegalArgumentException("Illegal load: " + maxLF);
        }

        if (initCapacity == 0) {
            initCapacity = 1;
        }

        arr = new LinkedList[initCapacity];
        threshold = (int) (initCapacity * maxLoadFactor);
    }

    public boolean add(Object elem) {
        //TODO
        if (!(elem instanceof IWithName)) {
            return false;
        }

        IWithName value = (IWithName) elem;

        if (size >= threshold) {
            doubleArray();
        }

        int index = (value.hashCode() & 0x7FFFFFFF) % arr.length;

        if (arr[index] == null) {
            arr[index] = new LinkedList<>();
        }

        if (arr[index].contains(value)) {
            return false;
        }

        arr[index].add(value);
        size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void doubleArray() {
        //TODO
        int prevSize = arr.length;
        int newSize = prevSize * 2;
        int index;

        LinkedList<IWithName>[] prevArr = arr;
        arr = new LinkedList[newSize];

        threshold = (int) (newSize * maxLoadFactor);

        for (int i = 0; i < prevSize; i++) {
            List<IWithName> prevList = prevArr[i];

            if (prevList == null) {
                continue;
            }

            for (int j = 0; j < prevList.size(); j++) {
                index = (prevList.get(j).hashCode() & 0x7FFFFFFF) % newSize;
                if (arr[index] == null) {
                    arr[index] = new LinkedList<>();
                }
                arr[index].add(prevList.get(j));
            }
        }
    }


    @Override
    public String toString() {
        //TODO
        // use	IWithName x=(IWithName)elem;
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result = result + i + ":";
            LinkedList<IWithName> list = arr[i];

            if (list != null) {
                Iterator<IWithName> iterator = list.iterator();

                while (iterator.hasNext()) {
                    IWithName element = iterator.next();
                    result = result + " " + element.getName();

                    if (iterator.hasNext()) {
                        result = result + ",";
                    }
                }
            }
            result += "\n";
        }
        return result;
    }

    public Object get(Object toFind) {
        //TODO
        if (toFind == null) {
            return null;
        }

        int index = (toFind.hashCode() & 0x7FFFFFFF) % arr.length;
        LinkedList<IWithName> list = arr[index];

        if (list == null) {
            return null;
        }

        for (int i = 0; i < list.size(); i++) {
            if (toFind.equals(list.get(i))) {
                return list.get(i);
            }
        }
        return null;
    }
}
