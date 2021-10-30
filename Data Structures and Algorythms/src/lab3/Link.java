package lab3;

public class Link{
    public String ref;
    // in the future there will be more fields
    public Link(String ref) {
        this.ref=ref;
    }
    @Override
    public boolean equals(Object obj) {
        //TODO
        return this.ref.equals(((Link) obj).ref);
    }

    public String toString() {
        return ref;
    }

}