
public class Product {
	private int ID;
	private int vendorID;
	private int partNumber;
	private String name;
	private double price;
	private String user;
	
	public Product(int iD, int vendorID, int partNumber, String name, double price, String user) {
		super();
		ID = iD;
		this.vendorID = vendorID;
		this.partNumber = partNumber;
		this.name = name;
		this.price = price;
		this.user = user;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", vendorID=" + vendorID + ", partNumber=" + partNumber + ", name=" + name
				+ ", price=" + price + ", user=" + user + "]";
	}
	
	
	
	
	

}
