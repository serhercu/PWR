package lab2;

import java.util.Scanner;

public class Document{
    public String name;
    public OneWayLinkedList<Link> links;
    public Document(String name, Scanner scan) {
        // TODO
        this.name = name;
        links = new OneWayLinkedList<Link>();
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
                        links.add(new Link(ref));
                    }
                }
                line = scan.nextLine();
            }
        }
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static boolean correctLink(String link) {
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
        String res = "Document: " + name + "\n";

        for(int i = 0; i < links.size(); i++) {
            if(links.get(i) != null) {
                res = res + links.get(i).ref + "\n";
            }
        }
        return res;
    }
}
