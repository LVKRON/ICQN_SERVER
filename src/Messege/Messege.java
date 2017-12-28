package Messege;

public class Messege {

	protected int totalLength;
	protected byte type;
	protected byte[] receiverID;
	protected byte[] senderID;

	public byte[] getSenderID() {
		return senderID;
	}

	public void setSenderID(byte[] senderID) {
		this.senderID = senderID;
	}

	public byte[] getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(byte[] receiverID) {
		this.receiverID = receiverID;
	}

	public byte getType() {
		return type;
	}

	// public void setType(byte type) {
	// this.type = type;
	// }

}
