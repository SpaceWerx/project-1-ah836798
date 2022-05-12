package Models;

public class Reimbursement {

	private int id;
	private int author;
	private int resolver;
	private String description;
	private Reimbursement_Type type;
	private Status status;
	private double amount;
	private String Reimbursement_Type;
	private String Status;
	
	
	public Reimbursement_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement_Model(int id, int author, int resolver, String description, Models.Reimbursement_Type type,
			Models.Status status, double amount, String reimbursement_Type, String status2) {
		super();
		this.id = id;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		Reimbursement_Type = reimbursement_Type;
		Status = status2;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Reimbursement_Type getType() {
		return type;
	}


	public void setType(Reimbursement_Type type) {
		this.type = type;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getReimbursement_Type() {
		return Reimbursement_Type;
	}


	public void setReimbursement_Type(String reimbursement_Type) {
		Reimbursement_Type = reimbursement_Type;
	}


	public String getStatus1() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	@Override
	public String toString() {
		return "Reimbursement_Model [id=" + id + ", author=" + author + ", resolver=" + resolver + ", description="
				+ description + ", type=" + type + ", status=" + status + ", amount=" + amount + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + author;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + resolver;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement_Model other = (Reimbursement_Model) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author != other.author)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (resolver != other.resolver)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
		  

}
