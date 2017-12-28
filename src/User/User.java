package User;

public class User {

	private byte[] userID = new byte[4];
	private byte[] userPassword = new byte[20];
	private byte[] userName = new byte[10];

	public byte[] getUserID() {
		return userID;
	}

	public void setUserID(byte[] userID) {
		this.userID = userID;
	}

	public byte[] getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(byte[] userPassword) {
		this.userPassword = userPassword;
	}

	public byte[] getUserName() {
		return userName;
	}

	public void setUserName(byte[] userName) {
		this.userName = userName;
	}

}
