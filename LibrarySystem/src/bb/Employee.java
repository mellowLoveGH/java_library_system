package bb;

public class Employee {
	private String id = "";
	private String name = "";
	
	public Employee(String id , String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId() + ":\t" + this.getName();
	}
}