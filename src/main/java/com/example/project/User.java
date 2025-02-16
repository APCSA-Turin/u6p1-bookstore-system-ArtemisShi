package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
private String name;
private String Id;
private Book[] book=new Book[5];
    //requires 1 contructor with two parameters that will initialize the name and id
    public User(String na, String ID){
        name=na;
        Id=ID;
        for(int i=0; i<book.length;i++){
            book[i]=null;
        }
    }
 
    //getter and setters
    public String getName() {
        return name;
    }

    public void setName(String newN) {
        name=newN;
    }

    public String getId() {
        return Id;
    }

    public void setId(String newI) {
        Id=newI;
    }

    public Book[] getBooks() {
        return book;
    }

    public void setBooks(Book[] newB) {
        book=newB;
    }

    // public String bookListInfo(){} //returns a booklist for the user, if empty, output "empty"
    public String bookListInfo(){
        String out="";
        for(Book b: book){
            if(b!=null){
            out+=b.bookInfo()+"\n";
        }
        else{
            out+="empty\n";
        }
    }
        return out;
    }

    // public String userInfo(){} //returns  "Name: []\nID: []\nBooks:\n[]"
    public String userInfo(){
        return "Name: " +name+ "\nId: "+Id+"\nBooks: \n"+bookListInfo();
    }
       
}