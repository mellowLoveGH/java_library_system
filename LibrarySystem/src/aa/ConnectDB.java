package aa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import bb.Book;
import bb.Employee;
import bb.Record;
import bb.User;

public class ConnectDB {
	
	public static List<Object> reading(String path){
		
		List<Object> list = new LinkedList<Object>();
		
		Connection con = connecting();
		
		try {
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			String Table_name = path;
			Statement statement = con.createStatement();
			String sql = "select * from " + Table_name;
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()){
				if(path.equals("users")){
					String id = rs.getString("userID");
					String name = rs.getString("name");
					User us = new User(id, name);
					list.add(us);
				}else if(path.equals("employees")){
					String id = rs.getString("emID");
					String name = rs.getString("name");
					Employee em = new Employee(id, name);
					list.add(em);
				}else if(path.equals("books")){
					String id = rs.getString("bookID");
					String name = rs.getString("name");
					String writer = rs.getString("writer");
					Book b = new Book(id, name, writer);
					list.add(b);
				}else if(path.equals("records")){
					String userID = rs.getString("userID");
					String bookID = rs.getString("bookID");
					String time = rs.getString("bookTime");
					Record re = new Record(userID, bookID, time);
					list.add(re);
				}else{
					System.out.println("wrong operation!");
				}
				
			}
			
			System.out.println("reading finished!");
			closing(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	
	
	
	
	public static void writing(Object obj){
		
		Connection con = connecting();
		try {
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			if(obj instanceof User){
				String Table_name = "users";
				String sql = "insert into " + Table_name + " values (?,?)";
				PreparedStatement preStmt=con.prepareStatement(sql); 
				preStmt.setString(1, ((User) obj).getId());  
	            preStmt.setString(2, ((User) obj).getName()); 
	            preStmt.executeUpdate();
			}
			
			//write in employee
			if(obj instanceof Employee){
				String Table_name = "employees";
				String sql = "insert into " + Table_name + " values (?,?)";
				PreparedStatement preStmt=con.prepareStatement(sql); 
				preStmt.setString(1, ((Employee) obj).getId());  
	            preStmt.setString(2, ((Employee) obj).getName()); 
	            preStmt.executeUpdate();
			}
			
			if(obj instanceof Book){
				String Table_name = "books";
				String sql = "insert into " + Table_name + " values (?,?,?)";
				PreparedStatement preStmt=con.prepareStatement(sql); 
				preStmt.setString(1, ((Book) obj).getId());  
	            preStmt.setString(2, ((Book) obj).getName()); 
	            preStmt.setString(3, ((Book) obj).getWriter()); 
	            preStmt.executeUpdate();
			}
			
			if(obj instanceof Record){
				String Table_name = "records";
				String sql = "insert into " + Table_name + "(userID,bookID) values (?,?)";
				PreparedStatement preStmt=con.prepareStatement(sql); 
				preStmt.setString(1, ((Record) obj).getUserID());  
	            preStmt.setString(2, ((Record) obj).getBookID()); 
//	            preStmt.setInt(3, 0); 
	            preStmt.executeUpdate();
			}
			
			
			System.out.println("write successfully!");
			closing(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void deleting(Object obj){
		
		Connection con = connecting();
		
		
		try {
			if(!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			
			Statement statement = con.createStatement();
			
			if(obj instanceof User){
				String Table_name = "users";
				String sql = "delete from " + Table_name + " where userID ='" + ((User) obj).getId() + "'";
				statement.executeUpdate(sql);
			}
			
			//write in employee
			if(obj instanceof Employee){
				String Table_name = "employees";
				String sql = "delete from " + Table_name + " where emID ='" + ((Employee) obj).getId() + "'";
				statement.executeUpdate(sql);
			}
			
			if(obj instanceof Book){
				String Table_name = "books";
				String sql = "delete from " + Table_name + " where bookID ='" + ((Book) obj).getId() + "'";
				statement.executeUpdate(sql);
			}
			
			if(obj instanceof Record){
				String Table_name = "records";
				String sql = "delete from " + Table_name + " where userID ='" + ((Record) obj).getUserID() + "'"
						+ " and bookID ='" + ((Record) obj).getBookID() + "'";
				statement.executeUpdate(sql);
			}
			
			
			System.out.println("write successfully!");
			closing(con);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	public static Connection connecting(){
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String database = "library";
		String url = "jdbc:mysql://localhost:3306/"+ database +"?useSSL=false";
		String user = "root";
		String password = "";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
	public static void closing(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printing(List<Object> list){
		
		Iterator<Object> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args) {
//		User[] user = Test.createUsers();
//		for (int i = 0; i < user.length; i++) {
//			writing(user[i]);
//		}
//		Employee[] emp = Test.createEmployees();
//		for (int i = 0; i < emp.length; i++) {
//			writing(emp[i]);
//		}
//		Book[] book = Test.createBooks();
//		for (int i = 0; i < book.length; i++) {
//			writing(book[i]);
//		}
//		Record[] record = Test.createRecords(user, book);
//		for (int i = 0; i < record.length; i++) {
//			writing(record[i]);
//		}
		
//		printing(reading("records"));
//		deleting(new User("000000000" , "david_0"));
//		deleting(new Employee("000000000", "jack_0"));
//		deleting(new Book("000000000", "computer_0", "tom_0"));
		deleting(new Record("000000001", "000010000", ""));
	}
}
