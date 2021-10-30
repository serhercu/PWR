package Tutorials.Tut.Tut3.List8.Books;

import com.sun.org.apache.xpath.internal.operations.String;

public class Book {
    private String name;
    private BookAuthors authors;
    private double price;
    private int qty = 0;

    public Book(String name, BookAuthors authors, double price){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, BookAuthors authors, double price, int qty){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName(){
        return name;
    }

    public BookAuthors getAuthor(){
        return authors;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }

    public int getQty(){
        return qty;
    }

    public void setQty(int newQty){
        qty = newQty;
    }

    @Override
    public java.lang.String toString() {
        return "Book{" +
                "name=" + name +
                ", authors=" + authors +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
