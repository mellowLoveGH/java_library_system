package cc;

import bb.Book;
import bb.Employee;
import bb.Record;
import bb.User;

public class Test {
	public static User[] createUsers(){
		User[] user = new User[10]; 
		
		for (int i = 0; i < 10; i++) {
			String id = "00000000"+i;
			String name = "david_" + i;
			User u = new User(id, name);
			user[i] = u;
		}
		
		return user;
	}
	
	public static Employee[] createEmployees(){
		Employee[] emp = new Employee[10]; 
		
		for (int i = 0; i < 10; i++) {
			String id = i + "00000000";
			String name = "jack_" + i;
			Employee e = new Employee(id, name);
			emp[i] = e;
		}
		
		return emp;
	}
	
	public static Book[] createBooks(){
		Book[] book = new Book[10]; 
		
		for (int i = 0; i < 10; i++) {
			String id = "0000" + i + "0000";
			String name = "computer_" + i;
			String writer = "tom_" + i;
			Book b = new Book(id, name, writer);
			book[i] = b;
		}
		
		return book;
	}
	
//	public static Writer[] createWritersO(){
//		Writer[] writer = new Writer[10]; 
//		
//		for (int i = 0; i < 10; i++) {
//			String name = "computer_" + i;
//			String bookname = "tom_" + i;
//			writer[i] = null;
//		}
//		
//		return writer;
//	}
	
	public static Record[] createRecords(User[] user , Book[] book){
		Record[] record = new Record[9];
		for (int i = 0; i < record.length; i++) {
			String userID = user[i+1].getId();
			String bookID = book[i+1].getId();
			String time = "";
			Record re = new Record(userID, bookID, time);
			record[i] = re;
		}
		return record;
	}
	
}
