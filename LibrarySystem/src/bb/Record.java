package bb;

public class Record {
	
	private String userID = "";
	private String bookID = "";
	private String time = "";
	
	public Record(String userID, String bookID, String time) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
		this.bookID = bookID;
		this.time = time;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getUserID() + ":\t" + this.getBookID() + ":\t" + this.getTime();
	}
}
