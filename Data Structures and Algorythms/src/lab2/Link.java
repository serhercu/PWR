package lab2;

public class Link{
    public String ref;
    public Link(String ref) {
        this.ref=ref;
    }
    // in the future there will be more fields

    public boolean equals(Object o) {
        return this.ref.equals(((Link) o).ref);
    }
}