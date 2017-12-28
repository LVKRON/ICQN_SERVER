package OlineData;

import java.util.ArrayList;

import Messege.Messege;
import User.User;
import UserThread.UserThread;

public class OlineDataTools {

	private OlineDataTools() {
	}

	private static ArrayList<UserThread> userThrList = new ArrayList<UserThread>();

	public static void addUserThr(UserThread userThread) {
		userThrList.add(userThread);
	}

	public static void findUserThr(Messege Msg) {
		byte[] receiverID = Msg.getReceiverID();
		UserThread userThread;
		User user;
		byte[] userID;
		int n = 0;
		for (int i = 0; i < userThrList.size(); i++) {
			userThread = (UserThread) userThrList.get(i);
			user = userThread.getUser();
			userID = user.getUserID();
			for (int j = 0; j < 4; j++) {
				if (receiverID[j] == userID[j])
					n++;
			}
			if (n == 4) {
				userThread.setMsg(Msg);
				userThread.setFlag_send(true);
				n = 0;
				break;
			}
			n = 0;
		}
	}
}
