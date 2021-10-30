package lab10;


import java.util.Scanner;
import java.util.*;

public class Document implements IWithName{
    public String name;
    // TODO? You can change implementation of Link collection
    public SortedMap<String,Link> link;

    public Document(String name) {
        this.name=name.toLowerCase();
        link=new TreeMap<String,Link>();
    }

    public Document(String name, Scanner scan) {
        this.name=name.toLowerCase();
        link=new TreeMap<String,Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO
        String marker = "link=";
        String endMarker = "eod";
        String line = scan.nextLine().toLowerCase();
        while (!line.equalsIgnoreCase(endMarker))
        {
            String arr[] = line.split(" ");
            for (String word : arr)
            {
                if (word.startsWith(marker))
                {
                    String linkStr = word.substring(marker.length());
                    Link l;
                    if ((l = createLink(linkStr)) != null)
                    {
                        link.put(l.ref, l);
                    }
                }

            }
            line = scan.nextLine().toLowerCase();
        }

    }

    public static boolean isCorrectId(String id) {
        //TODO
        id = id.toLowerCase();
        if (id.length() == 0)
        {
            return false;
        }
        if (id.charAt(0) < 'a' || id.charAt(0) > 'z')
        {
            return false;
        }
        for (int i = 1; i < id.length(); i++)
        {
            if (!(id.charAt(i) >= 'a' && id.charAt(i) <= 'z' || id.charAt(i) >= '0' && id.charAt(i) <= '9' || id.charAt(i) == '_'))
            {
                return false;
            }
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
        //TODO?
        retStr += link;
        return retStr;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String getName() {
        return name;
    }
}