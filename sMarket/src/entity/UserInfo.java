package entity;

public class UserInfo {
	private int Id;
	private String userName;
	private String userType;
	private int score;
	private String status;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	//To check whether the user exists
	// need to override the hashcode and equals functions
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (Id != other.Id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	public UserInfo(int Id, String userName, String userType, int score, String status) {
		super();
		this.Id = Id;
		this.userName = userName;
		this.userType = userType;
		this.score = score;
		this.status = status;
	}
	public UserInfo() {
		super();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.Id);
		sb.append("\t");
		sb.append(this.userName);
		sb.append("\t");
		sb.append(this.userType);
		sb.append("\t");
		sb.append(this.score);
		sb.append("\t");
		sb.append(this.status);
		sb.append("\t");
		
		return sb.toString();
	}
	
	
}
