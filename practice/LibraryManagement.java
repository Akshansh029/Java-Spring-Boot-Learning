package practice;
/*
Concepts: Constructors, overloading

Problem Statement:
Create a Book class with:
- title, author, price, isbn

Constructors:
- Only title and author
- All fields
- Copy constructor

Task:
- Create multiple Book objects using different constructors
- Display details
 */

class Book{
      private String title;
      private String author;
      private double price;
      private String isbn;

      public Book(String title, String author) {
            this(title, author, 0.0, null);
      }

      public Book(String t, String a, double p, String i){
            if(t.length() == 0 || a.length() == 0){
                  throw new IllegalArgumentException("Title or Author cannot be empty");
            }
            if(p < 0){
                  throw new IllegalArgumentException("Price cannot be negative");
            }
            this.title = t;
            this.author = a;
            this.price = p;
            this.isbn = i;
      }

      public Book(Book b){
            this(b.title, b.author, b.price, b.isbn);
      }

      public String getTitle() {
            return title;
      }

      public String getAuthor() {
            return author;
      }

      public double getPrice() {
            return price;
      }

      @Override
      public String toString() {
            return String.format(
                  "Book[name=%s, author=%s, price=%.2f, isbn=%s]",
                  title, author, price, isbn
            );
      }
}

public class LibraryManagement {
      public static void main(String[] args) {
            Book b1 = new Book("Alchemist", "Paulo Coelho");  
            Book b2 = new Book("Psychology of Money", "Morgan Housel", 1200, "978-0140449136");
            Book b3 = new Book(b1);

            System.out.println(b1.toString());
            System.out.println(b2.toString());
            System.out.println(b3.toString());
      }
}
