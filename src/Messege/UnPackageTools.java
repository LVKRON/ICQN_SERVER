package Messege;

import java.io.DataInputStream;
import java.io.IOException;

public class UnPackageTools {

	private UnPackageTools() {
	}

	public static Messege unpackMsg(DataInputStream dins) throws IOException {
		byte type = dins.readByte();
		switch (type) {
		case 0x10:
			RegisterMsg regMsg = makeRegMsg(dins);
			return regMsg;
		case 0x11:
			LoginMsg logMsg = makeLogMsg(dins);
			return logMsg;
		case 0x12:
			ChatMsg chatMsg = makeChatMsg(dins);
			return chatMsg;
		default:
			Messege Msg = new Messege();
			return Msg;
		}
	}

	private static RegisterMsg makeRegMsg(DataInputStream dins) throws IOException {
		byte[] receiverID = new byte[4];
		byte[] senderID = new byte[4];
		byte[] userID = new byte[4];
		byte[] userPassword = new byte[20];

		dins.readFully(receiverID);
		dins.readFully(senderID);
		dins.readFully(userID);
		dins.readFully(userPassword);

		RegisterMsg regMsg = new RegisterMsg();
		regMsg.setReceiverID(receiverID);
		regMsg.setSenderID(senderID);
		regMsg.setUserID(userID);
		regMsg.setUserPassword(userPassword);

		return regMsg;
	}

	private static LoginMsg makeLogMsg(DataInputStream dins) throws IOException {
		byte[] receiverID = new byte[4];
		byte[] senderID = new byte[4];
		byte[] userID = new byte[4];
		byte[] userPassword = new byte[20];

		dins.readFully(receiverID);
		dins.readFully(senderID);
		dins.readFully(userID);
		dins.readFully(userPassword);

		LoginMsg logMsg = new LoginMsg();
		logMsg.setReceiverID(receiverID);
		logMsg.setSenderID(senderID);
		logMsg.setUserID(userID);
		logMsg.setUserPassword(userPassword);

		return logMsg;
	}

	private static ChatMsg makeChatMsg(DataInputStream dins) throws IOException {
		byte[] receiverID = new byte[4];
		byte[] senderID = new byte[4];
		byte[] words = new byte[400];

		dins.readFully(receiverID);
		dins.readFully(senderID);
		dins.readFully(words);

		ChatMsg chatMsg = new ChatMsg();
		chatMsg.setReceiverID(receiverID);
		chatMsg.setSenderID(senderID);
		chatMsg.setWords(words);

		return chatMsg;
	}
}
