package Messege;

public class LoginMsg extends Messege {

	private byte[] userID = new byte[4];
	private byte[] userPassword = new byte[20];

	public LoginMsg() {
		this.type = 0x11;
	}

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

}
