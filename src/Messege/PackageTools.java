package Messege;

import java.io.DataOutputStream;
import java.io.IOException;

public class PackageTools {

	private PackageTools() {
	}

	public static void packMsg(Messege Msg, DataOutputStream dous) throws IOException {
		byte type = Msg.getType();
		switch (type) {
		case 0x10:
			packRegMsg((RegisterMsg) Msg, dous);
		case 0x11:
			packLogMsg((LoginMsg) Msg, dous);
		case 0x12:
			packChatMsg((ChatMsg) Msg, dous);
		default:

		}
	}

	private static void packRegMsg(RegisterMsg regMsg, DataOutputStream dous) throws IOException {
		byte type = regMsg.getType();
		byte[] registerID = regMsg.getReceiverID();
		byte[] senderID = regMsg.getSenderID();
		byte[] userID = regMsg.getUserID();
		byte[] userPasword = regMsg.getUserPassword();

		dous.writeByte(type);
		dous.write(registerID);
		dous.write(senderID);
		dous.write(userID);
		dous.write(userPasword);
	}

	private static void packLogMsg(LoginMsg logMsg, DataOutputStream dous) throws IOException {
		byte type = logMsg.getType();
		byte[] registerID = logMsg.getReceiverID();
		byte[] senderID = logMsg.getSenderID();
		byte[] userID = logMsg.getUserID();
		byte[] userPasword = logMsg.getUserPassword();

		dous.writeByte(type);
		dous.write(registerID);
		dous.write(senderID);
		dous.write(userID);
		dous.write(userPasword);
	}

	private static void packChatMsg(ChatMsg chatMsg, DataOutputStream dous) throws IOException {
		byte type = chatMsg.getType();
		byte[] registerID = chatMsg.getReceiverID();
		byte[] senderID = chatMsg.getSenderID();
		byte[] words = chatMsg.getWords();

		dous.writeByte(type);
		dous.write(registerID);
		dous.write(senderID);
		dous.write(words);
	}
}
