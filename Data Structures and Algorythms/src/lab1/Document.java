package lab1;

import java.util.Scanner;

public class Document {
    public static void loadDocument(String name, Scanner scan) {
        //TODO
        String line = scan.nextLine();
        while(line != null && !line.startsWith("eod")){
            String[] links = line.split(" ");
            for(int i = 0; i < links.length; i++){
                if(correctLink(links[i])){
                    System.out.println(links[i].substring(5).toLowerCase());
                }
            }
            line = scan.nextLine();
        }
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        // TODO
        if (link.length() > 5 && link.substring(0, 5).equalsIgnoreCase("link=")){
            char first = link.charAt(5);
            if(Character.isLetter(first)){
                return true;
            }
        }
        return false;
    }
}