package bb;

public class Book {
	private String id = "";
	private String name = "";
	private String writer = "";
	
	
	public Book(String id , String name, String writer) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.writer = writer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId() + ":\t" + this.getName() + ":\t" + this.getWriter();
	}
}
