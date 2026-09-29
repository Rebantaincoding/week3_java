package project3;

//Books class-to store book details
public class Books {
         private String isbn;
         private String title;
         private String author;
         private String genre;
         private boolean availablilty;
         
         //Parameterized constructor
		 public Books(String isbn, String title, String author, String genre) {
			super();
			this.isbn = isbn;
			this.title = title;
			this.author = author;
			this.genre = genre;
			this.availablilty = true;
		 }
		 
		 //Getters and Setters
		 public String getIsbn() {
			 return isbn;
		 }
		 public void setIsbn(String isbn) {
			 this.isbn = isbn;
		 }
		 public String getTitle() {
			 return title;
		 }
		 public void setTitle(String title) {
			 this.title = title;
		 }
		 public String getAuthor() {
			 return author;
		 }
		 public void setAuthor(String author) {
			 this.author = author;
		 }
		 public String getGenre() {
			 return genre;
		 }
		 public void setGenre(String genre) {
			 this.genre = genre;
		 }
		 public boolean isAvailable() {
			 return availablilty;
		 }
		 public void setAvailablilty(boolean availablilty) {
			 this.availablilty = availablilty;
		 }
		 
		 //Display details
		 public void displaydetails() {
			 System.out.println("ISBN :"+isbn);
			 System.out.println("Title :"+title);
			 System.out.println("Author :"+author);
			 System.out.println("Genre :"+ genre);
			 System.out.println("Availability :"+(availablilty ? "Yes":"No"));
		 }
         
}
