package lab4;

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

    public static boolean isCorrectId(String id) {
        //TODO
        if (!Character.isLetter(id.charAt(0))) {
            return false;
        }
        return true;
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static Link createLink(String link) {
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
        String retStr="Document: "+ name;
        //TODO
        return retStr + link.toString();
    }

    public String toStringReverse() {
        String retStr="Document: "+ name;
        //TODO
        return retStr + link.toStringReverse();
    }
}
