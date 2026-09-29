package project3;
import java.util.*;

//Main class
public class LibraryManagementSystem {
    static Scanner sc=new Scanner(System.in);
    
    //List to store the books
    List<Books> books=new ArrayList<>();
    
    //List to store the members
    List<Member> member=new ArrayList<>();
    
    //Add member functionality
    void addmember() {
    	System.out.println("\n===ADD MEMBER===\n");
    	System.out.println("-".repeat(100));
    	System.out.println("Enter member Id");
    	sc.nextLine();
    	String id=sc.nextLine();
    	System.out.println("Enter member name");
    	String name=sc.nextLine();
    	System.out.println("Enter member contact");
    	String contact=sc.nextLine();
    	member.add(new Member(id,name,contact));
    	System.out.println("-".repeat(100));
    }
    
  //Add book functionality
    void addBook() {
    	System.out.println("\n===ADD BOOK===\n");
    	System.out.println("-".repeat(100));
    	System.out.println("Enter ISBN no.");
    	sc.nextLine();
    	String isbn=sc.nextLine();
    	System.out.println("Enter Book title");
    	String title=sc.nextLine();
    	System.out.println("Enter Book author");
    	String author=sc.nextLine();
    	System.out.println("Enter Book genre");
    	String genre=sc.nextLine();
    	books.add(new Books(isbn,title,author,genre));
    	System.out.println("-".repeat(100));
    }
    
    //Display books
    void displayAllBooks() {
    	System.out.println("\n===DISPLAY BOOKS===\n");
    	System.out.println("-".repeat(100));
    	for(Books book:books) {
    		book.displaydetails();
    	}
    	System.out.println("-".repeat(100));
    }
    
    //Display available books
    void displayAvailableBooks() {
    	System.out.println("\n===DISPLAY AVAILABLE BOOKS===\n");
    	System.out.println("-".repeat(100));
    	for(Books book:books) {
    		if(book.isAvailable()) {
    			book.displaydetails();
    		}
    	}
    	System.out.println("-".repeat(100));
    }
    
    //Search books by a keyword
    void searchBooks() {
    	System.out.println("\n===SEARCH BOOKS===\n");
    	System.out.println("-".repeat(100));
            ArrayList<Books> results = new ArrayList<>();
            System.out.println("Enter keyword");
            sc.nextLine();
            String keyword=sc.nextLine();
            keyword = keyword.toLowerCase();
            for(Books book : books) {
                if(book.getTitle().toLowerCase().contains(keyword) || 
                   book.getAuthor().toLowerCase().contains(keyword) ||
                   book.getGenre().toLowerCase().contains(keyword)) {
                    results.add(book);
                }
            }
            System.out.println("List of Books that matches your search are:");
            for(Books book: results) {
            	book.displaydetails();
        }
            System.out.println("-".repeat(100));
    }
    
    //Borrow books
    void borrowbook() {
    	System.out.println("\n===BORROW BOOK===\n");
    	System.out.println("-".repeat(100));
    	System.out.println("Enter your memberId");
    	sc.nextLine();
    	String memberId=sc.nextLine();
    	System.out.println("Enter isbn number of book");
    	String isbn=sc.nextLine();
    	Member borrower=null;
    	Books toBorrow=null;
    	for(Member m:member) {
    		if(m.getMemberId().equalsIgnoreCase(memberId)) {
    			borrower=m;
    		}
    	}
    	for(Books b:books) {
    		if(b.getIsbn().equalsIgnoreCase(isbn)) {
    			toBorrow=b;
    		}
    	}
    	if((borrower!=null)&&(toBorrow!=null)) {
    	borrower.borrowBook(toBorrow);
    	}
    	else {
    		System.out.println("Invalid input!!!");
    	}
    	System.out.println("-".repeat(100));
    }
    
    //Return books
    void returnbook() {
    	System.out.println("\n===RETURN BOOK===\n");
    	System.out.println("-".repeat(100));
    	System.out.println("Enter your memberId");
    	sc.nextLine();
    	String memberId=sc.nextLine();
    	System.out.println("Enter isbn number of book");
    	String isbn=sc.nextLine();
    	Member returner=null;
    	Books toReturn=null;
    	for(Member m:member) {
    		if(m.getMemberId().equalsIgnoreCase(memberId)) {
    			returner=m;
    		}
    	}
    	for(Books b:books) {
    		if(b.getIsbn().equalsIgnoreCase(isbn)) {
    			toReturn=b;
    		}
    	}
    	List<Books> borrowed=returner.getBorrowed();
    	if((returner!=null)&&(toReturn!=null)&&(borrowed.contains(toReturn))) {
    	returner.returnBook(toReturn);
    	}
    	else {
    	System.out.println("Inavlid entry!!!");
    	}
    	System.out.println("-".repeat(100));
    }
    
    //Main function
    public static void main(String args[]) {
    	int choice=0;
    	System.out.println("\n===Library Management System===\n");
    	LibraryManagementSystem lms= new LibraryManagementSystem();
    	while(choice!=8) {
    		System.out.println("1. Add New Book\r\n"
    				+ "2. Register New Member\r\n"
    				+ "3. Display All Books\r\n"
    				+ "4. Display Available Books\r\n"
    				+ "5. Search Books\r\n"
    				+ "6. Borrow Book\r\n"
    				+ "7. Return Book\r\n"
    				+ "8. Exit\r\n"
    				+ "Enter your choice:");
    		choice=sc.nextInt();
    		if(choice==1) {
    			lms.addBook();
    		}
    		else if(choice==2) {
    			lms.addmember();
    		}
    		else if(choice==3) {
    			lms.displayAllBooks();
    		}
    		else if(choice==4) {
    			lms.displayAvailableBooks();
    		}
    		else if(choice==5) {
    			lms.searchBooks();
    		}
    		else if(choice==6) {
    			lms.borrowbook();
    		}
    		else if(choice==7) {
    			lms.returnbook();
    		}
    	}
    }
    
}
