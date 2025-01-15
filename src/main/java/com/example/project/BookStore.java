package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books; //dynamic
    private User[] users= new User[10]; //dynamic
    private int bam=0;
    private int um=10;

    //requires 1 empty constructor
    public BookStore(){}

    public User[] getUsers(){
        return users;
    }

    public void setUsers(User[] newU){
        users=newU;
    }

    public Book[] getBooks(){
        return books;
    }

    //need dynamic array
    public void addUser(User user){

    } 

    public void removeUser(User user){

    }

    public void consolidateUsers(){

    }

    public void addBook(Book book){
        addB();
        books[books.length-1]=book;
    }

    //if book is already in the catalog and youre just shifting positions
    public void insertBook(Book book, int index){
        boolean al=false;
        int ind=0;
        for(int i=0;i<books.length;i++){
            if(books[i]==book){
                al=true;
                ind=i;
            }
        }
    if(al==true){
        Book place=book;
        if(ind>index){ //greater= shift the ones that come before right 1234 1204 1024 1324
            for(int i=ind-index;i>0;i--){
                books[i]=books[i-1];
            }
            books[index]=book;
        }
        if(ind<index){//lesser= shift the ones that come after left 12345 12045 12405 12435
            for(int i=index-ind;i>0;i--){
                books[ind]=books[index-i+1];
            }
        }
    }
    else{
shift(index);
    }
    }

    //searches for book and removes it. It deletes the book from the array and shifts everything after the deleted book to the left 
    
    public void removeBook(Book book){
        int ind=0;
        for(int i=0;i<books.length;i++){
            if(books[i]==book){
              books[i]=null;
            }
        }
        for(int k=0;books[k]!=null;k++){
            ind=k;
        }
        //0,1,2,null,4,5;  shift 4,5 left; 3=4;4=5; ind+1=null's position
        for(int j=ind+1;j<books.length-1;j++){
            books[j]=books[j+1];
        }
        subB();
    }


    //dynamic
    private void shift(int in){
        Book[] place=books;
        bam++;
        books=new Book[bam];
        for(int i=0;i<place.length;i++){
            books[i]=place[i];
        }
        for(int i=in; i<books.length;i++){
            
        }

    }
    private void addB(){
        Book[] place=books;
        bam++;
        books=new Book[bam];
        for(int i=0;i<place.length;i++){
            books[i]=place[i];
        }
    }

    private void subB(){
        Book[] place=books;
        bam--;
        books=new Book[bam];
        for(int i=0;i<books.length;i++){
            books[i]=place[i];
        }
    }

    private void addU(){
        User[] place=users;
        um++;
        users=new User[bam];
        for(int i=0;i<place.length;i++){
            users[i]=place[i];
        }
    }

    private void subU(){

    }

       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}