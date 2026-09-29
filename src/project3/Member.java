package project3;
import java.util.*;

//Member class- to contain member detail and borrowing and returning functionality
public class Member {
   private String memberId;
   private String name;
   private String contact;
   private List<Books> Borrowed;
   
   //Parameterized constructor
   public Member(String memberId,String name,String contact) {
	super();
	this.memberId = memberId;
	this.name = name;
	this.contact = contact;
	Borrowed = new ArrayList<>();
   }
   
   //Getters and Setters
   public String getMemberId() {
	return memberId;
   }
   public void setMemberId(String memberId) {
	this.memberId = memberId;
   }
   public String getName() {
	return name;
   }
   public void setName(String name) {
	this.name = name;
   }
   public String getContact() {
	return contact;
   }
   public void setContact(String contact) {
	this.contact = contact;
   }
   public List<Books> getBorrowed() {
	return Borrowed;
   }
   
   //Book borrowing functionality
   public void borrowBook(Books book) {
	   if(book.isAvailable()) {
		   Borrowed.add(book);
		   book.setAvailablilty(false);
		   System.out.println("Book has been borrowed succesfully");
	   }
	   else {
		   System.out.println("We are sorry! Book is currently unavailable");
	   }
   }
   
   //Book returning functionality
   public void returnBook(Books book) {
	   Borrowed.remove(book);
	   book.setAvailablilty(true);
	   System.out.println("Book returned succesfully");
   }
   
   
}
