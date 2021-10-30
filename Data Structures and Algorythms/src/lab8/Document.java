package lab8;

import java.util.Objects;
import java.util.Scanner;

public class Document implements IWithName {
    public String name;
    public BST<Link> link;
    private static final int[] HASHCODE_SEQUENCE = {7, 11, 13, 17, 19};

    public Document(String name) {
        this.name=name.toLowerCase();
        link=new BST<Link>();
    }

    public Document(String name, Scanner scan) {
        this.name=name.toLowerCase();
        link=new BST<Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO
        String line = scan.nextLine();
        String lineLowerCase = "";

        while (line != null && !line.startsWith("eod")) {
            if (line != null && line.length() > 0) {
                lineLowerCase = line.toLowerCase();
                String[] linksA = lineLowerCase.split(" ");

                for (int i = 0; i < linksA.length; i++) {
                    String[] splitted = linksA[i].split("=");

                    if (splitted.length == 2) {
                        if (isCorrectId(splitted[1])) {
                            Link l = createLink(splitted[1]);
                            if (l != null) {
                                link.add(l);
                            }
                        }
                    }
                }
            }
            line = scan.nextLine();
        }
    }

    private static boolean correctLink(String link) {
        if (link.length() > 5 && link.substring(0, 5).equalsIgnoreCase("link=")) {
            char first = link.charAt(5);
            if (Character.isLetter(first)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCorrectId(String id) {
        //TODO
        if (!Character.isLetter(id.charAt(0))) {
            return false;
        }
        return true;
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    static Link createLink(String link) {
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
        String retStr="Document: "+name+"\n";
        retStr+=link.toStringInOrder();
        return retStr;
    }

    public String toStringPreOrder() {
        String retStr="Document: "+name+"\n";
        retStr+=link.toStringPreOrder();
        return retStr;
    }

    public String toStringPostOrder() {
        String retStr="Document: "+name+"\n";
        retStr+=link.toStringPostOrder();
        return retStr;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

}