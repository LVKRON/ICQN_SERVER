package UserThread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Messege.LoginMsg;
import Messege.Messege;
import Messege.PackageTools;
import Messege.RegisterMsg;
import Messege.UnPackageTools;
import User.User;
import User.UserDataTools;
import OlineData.OlineDataTools;

public class UserThread extends Thread {

	private User user;
	private Socket client;
	private InputStream ins;
	private OutputStream ous;
	private DataInputStream dins;
	private DataOutputStream dous;
	boolean flag = false;
	boolean flag_send = false;
	private Messege Msg;

	public UserThread(Socket client) throws IOException {
		this.client = client;
		this.ins = client.getInputStream();
		this.ous = client.getOutputStream();
		this.dins = new DataInputStream(ins);
		this.dous = new DataOutputStream(ous);
	}

	public User getUser() {
		return user;
	}

	public void setFlag_send(boolean flag_send) {
		this.flag_send = flag_send;
	}

	public void setMsg(Messege msg) {
		Msg = msg;
	}

	public void run() {
		try {
			process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeMe() throws IOException {
		this.client.close();
	}

	public void process() throws IOException {
		flag = true;
		while (flag) {
			Msg = UnPackageTools.unpackMsg(dins);
			recMsg(Msg);
			if (flag_send) {
				PackageTools.packMsg(Msg, dous);
				flag_send = false;
			}
		}
	}

	private void recMsg(Messege Msg) {
		byte type = Msg.getType();
		switch (type) {
		case 0x10:
			recRegMsg((RegisterMsg) Msg);
			UserDataTools.userRegister(user);
			OlineDataTools.addUserThr(this);
		case 0x11:
			recLogMsg((LoginMsg) Msg);
			UserDataTools.userLogin(user);
			OlineDataTools.addUserThr(this);
		case 0x12:
			OlineDataTools.findUserThr(Msg);
		default:

		}
	}

	private void recRegMsg(RegisterMsg regmsg) {
		user.setUserID(regmsg.getUserID());
		user.setUserPassword(regmsg.getUserPassword());
	}

	private void recLogMsg(LoginMsg logmsg) {
		user.setUserID(logmsg.getUserID());
		user.setUserPassword(logmsg.getUserPassword());
	}

}
