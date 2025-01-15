package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
private String title;
private String author;
private int yearPublished;
private String isbn;
private int quantity;

    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    public Book(String title, String auth, int pub, String isbn, int quant){
        this.title=title;
        author=auth;
        yearPublished=pub;
        this.isbn=isbn;
        quantity=quant;
    }

    // getter and setter methods
    public String getTitle() {
        return title;
    }

    public void setTitle(String newT) {
        title=newT;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String newA) {
        author=newA;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int newY) {
        yearPublished=newY;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String newI) {
        isbn=newI;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQ) {
        quantity=newQ;
    }

    // public  bookInfo(){} //returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []"
       public String bookInfo(){
        return "Title: "+title+", Author: "+author+ ", Year: "+yearPublished+", ISBN: "+isbn+", Quantity: "+quantity;
       }
}