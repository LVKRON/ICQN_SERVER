package Messege;

public class ChatMsg extends Messege {

	private byte[] words = new byte[400];

	public ChatMsg() {
		this.type = 0x12;
	}

	public byte[] getWords() {
		return words;
	}

	public void setWords(byte[] words) {
		this.words = words;
	}

}
