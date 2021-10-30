package lab3;

import java.util.Iterator;
import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayUnorderedListWithHeadAndTail<Link> link;
    public Document(String name, Scanner scan) {
        this.name=name;
        link=new TwoWayUnorderedListWithHeadAndTail<Link>();
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
                        link.add(new Link(ref));
                    }
                }
                line = scan.nextLine();
            }
        }
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        //TODO
        if (link.length() > 5 && link.substring(0, 5).equalsIgnoreCase("link=")){
            char first = link.charAt(5);
            if(Character.isLetter(first)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO
        String res = "Document: " + name;

        if (link.get(link.size()-1) == null) {
            res+="";
        }

        else {
            res+="\n";
            for (int i = 0; i < link.size() - 1; i++) {
                if (link.get(i) != null) {
                    res = res + link.get(i).ref + "\n";
                }
            }

            res += link.get(link.size() - 1) + "";
        }
        return res;
    }

    public String toStringReverse() {
        String retStr="Document: "+name;
        return retStr+link.toStringReverse();
    }

}