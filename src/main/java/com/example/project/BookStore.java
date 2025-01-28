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
        boolean check=false;
        int i=0;
        while(check==false){
            if(users[i]==null){
                check=true;
                i--;
            }
            i++;
        }
        if(check==true){
            users[i]=user;
        }
        if(check==false){
        addU();
        users[users.length-1]=user;
        }
    } 

    public void removeUser(User user){
        int ind=0;
        for(int i=0;i<users.length;i++){
            if(users[i]==user){
              users[i]=null;
            }
        }
        if(users[0]==null){
            ind=0;
            for(int j=ind;j<users.length-1;j++){
                users[j]=users[j+1];
            }
        }else{
        for(int k=0;users[k]!=null;k++){
            ind=k;
        }
        
        //0,1,2,null,4,5;  shift 4,5 left; 3=4;4=5; ind+1=null's position
        for(int j=ind+1;j<users.length-1;j++){
            users[j]=users[j+1];
        }
        }
        subU();
        if(users.length<10){
            User[] place = new User[10];
            for(int i=0;i<users.length;i++){
                place[i]=users[i];
            }
            users=place;
        }
    }

    //organize then group together
    public void consolidateUsers(){
        int count=0;
        int nu=0;
        for(int i=0; i<users.length;i++){
            if(users[i]!=null){
                count++;
            }
            else{
                nu++;
            }
        }
        User[] place = new User[count];
        count=0;
        for(int i=0; i<users.length;i++){
            if(users[i]!=null){
                place[count]=users[i];
                count++;
            }
        }


        int k=0; // null,null,2,null,3
        User use= place[k]; //k is index of first ids; keep the id in a placeholder

        for(int i=100;i<=max();i++){
            // User use= users[k]; //k is index of first ids; keep the id in a placeholder
            for(int j=0; j<place.length;j++){ //iterates through users
                    if(Integer.valueOf(place[j].getId())==i){ //if users[j] has an id that is smaller than or equal to i(id) then you switch positions
                    place[k]=place[j];  //8,3,4,9,2
                }
            }
            k++;
        }
        users=place;
        int le=users.length;
        place= new User[le+nu];
        for(int i=0;i<users.length;i++){
            place[i]=users[i];
        }
        users=place;
        for(int j=le; j<le+nu;j++){
            users[j]=null;
        }
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
            books[index]=book;
        }
    }
    else{
    shift(index);
    books[index]=book;
    }
    }

    //searches for book and removes it. It deletes the book from the array and shifts everything after the deleted book to the left 
    
    public void removeBook(Book book){
        int ind=0;
        boolean check=false;
        for(int p=0;p<books.length;p++){
            if(books[p]==book){
                books[p].setQuantity(books[p].getQuantity()-1);
                ind=p;
            }
        }
        if(books[ind].getQuantity()==0){
            ind=0;
        
        for(int i=0;i<books.length;i++){ //replaces book you want to remove with null
            if(books[i]==book){
              books[i]=null;
              check=true;
            }
        }
        if(check==true){
            if(books[0]==null){
               for(int m=0; m<books.length-1;m++){
                books[m]=books[m+1];
               } // shifts everything down if null is in position 0
            }
            else{
        for(int k=0;books[k]!=null;k++){ //finds the position of the book right before the null
            ind=k;
        }
        //0,1,2,null,4,5;  shift 4,5 left; 3=4;4=5; ind+1=null's position
        for(int j=ind+1;j<books.length-1;j++){
            books[j]=books[j+1];
        }}
        subB();
    }}}

    //help method
    private int max(){
        int p=0;
        while(users[p]==null){
            p++;
        }
        int max=Integer.valueOf(users[p].getId());
        for(int i=0; i<users.length;i++){
            if(users[i]!=null){
            if(Integer.valueOf(users[i].getId())>max){
                max=Integer.valueOf(users[i].getId());
            }
        }}
        return max;
    }

    //dynamic
    private void shift(int in){
        addB();
        // Book place= books[books.length-1]; possibly unnecessary
        for(int i=books.length-1; i>in;i--){ // 12340 12034
            books[i]=books[i-1];
        }

    }
    private void addB(){
        Book[] place;
        bam++;
        if(books!=null){
        place=books;
        }
        else{
            place=new Book[bam];
        }
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
        User[] place;
        um++;
        if(users!=null){
        place=users;
        }
        else{
            place=new User[um];
        }
        users=new User[um];
        for(int i=0;i<place.length;i++){
            users[i]=place[i];
        }
    }

    private void subU(){
        User[] place=users;
        um--;
        users=new User[um];
        for(int i=0;i<users.length;i++){
            users[i]=place[i];
        }
    }

       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}