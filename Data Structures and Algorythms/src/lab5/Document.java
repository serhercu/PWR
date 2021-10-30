package lab5;

import java.util.ListIterator;
import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayCycledOrderedListWithSentinel<Link> link;
    public Document(String name, Scanner scan) {
        this.name=name.toLowerCase();
        link=new TwoWayCycledOrderedListWithSentinel<Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO
        String line = scan.nextLine();

        while (line != null && !line.startsWith("eod")) {
            if (line != null && line.length() > 0) {
                String[] linksA = line.split(" ");

                for (int i = 0; i < linksA.length; i++) {
                    if (correctLink(linksA[i])) {
                        String ref = linksA[i].substring(5);
                        Link l = createLink(ref);
                        if (l != null) {
                            link.add(l);
                        }
                    }
                }
            }
            line = scan.nextLine();
        }
    }

    private static boolean correctLink(String link) {
        if (link.length() > 5 && link.substring(0, 5).equalsIgnoreCase("link=")){
            char first = link.charAt(5);
            if(Character.isLetter(first)){
                return true;
            }
        }
        return false;
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)


    public static boolean isCorrectId(String id) {
        //TODO
        if (!Character.isLetter(id.charAt(0))) {
            return false;
        }
        return true;
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static Link createLink(String link) {
        //TODO
        String[] linkWithWeight = link.split("\\(");
        link = linkWithWeight[0].toLowerCase();
        int weight = 1;

        if (linkWithWeight.length != 1) {
            try {
                String w = linkWithWeight[1];
                if ((w.charAt(w.length() - 1) + "").equals(")")) {
                    w = w.substring(0, linkWithWeight[1].length() - 1);
                    weight = Integer.parseInt(w);
                } else {
                    weight = -1;
                }
            } catch (Exception e) {
                weight = -1;
            }
        }

        if (weight > 0) {
            return (new Link(link, weight));
        }
        return null;
    }

    @Override
    public String toString() {
        String retStr="Document: "+name;
        //TODO
        return retStr + link.toString();
    }

    public String toStringReverse() {
        String retStr="Document: "+ name;
        //TODO
        return retStr + link.toStringReverse();
    }

    public int[] getWeights() {
        //TODO
        int[] weights = new int[link.size()];
        for (int i = 0; i < link.size(); i++) {
            weights[i] = link.get(i).weight;
        }
        return weights;
    }

    public static void showArray(int[] arr) {
        // TODO
        if (arr.length > 0) {
            System.out.print(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }

    void bubbleSort(int[] arr) {
        showArray(arr);
        //TODO
        for (int pass = 1; pass < arr.length; ++pass) {
            for (int left = arr.length - 1; left > 0; --left) {
                int right = left - 1;
                if (arr[left] < arr[right]) {
                    swap(arr, left, right);
                }
            }
            showArray(arr);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int aux = arr[left];
        arr[left] = arr[right];
        arr[right] = aux;
    }

    public void insertSort(int[] arr) {
        showArray(arr);
        //TODO
        for (int i = arr.length - 2; i >= 0; --i) {
            int val = arr[i];
            int j;
            for (j = i + 1; j < arr.length && val > arr[j]; ++j) {
                arr[j - 1] = arr[j];
            }
            arr[j - 1] = val;
            showArray(arr);
        }

    }
    public void selectSort(int[] arr) {
        showArray(arr);
        //TODO
        for (int slot = arr.length; slot > 1; --slot) {
            int maximal = 0;
            for (int check = 0; check < slot; ++check) {
                if (arr[maximal] < arr[check]) {
                    maximal = check;
                }
            }
            swap(arr,slot - 1, maximal);
            showArray(arr);
        }
    }

}