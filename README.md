# ICQN_SERVER
without packMsg
//***********定义协议**********//

消息头
               消息长度 消息类型 消息接收者 消息发送者
                1 int    1byte     byte[4]    byte[4]
消息体

1、登陆消息 类型码 0x11
               userID  userPassword 
               byte[4]    byte[20]
2、注册消息 类型码 0x10
               userID  userPassword
               byte[4]    byte[20]

3、聊天消息 类型码 0x12
               words
              byte[400]
                 



消息接收者
     服务器 0000
     群聊   0001
     
     +客户机
后台

后台

//************用户*************//

1、用户类User
         private byte[4] userID
         private byte[20] userPassword
         private String userName
         get和set方法

2、用户数据处理类UserDateTools
         a. public static boolean userRegister(User)用户注册
         b. public static boolean userLogin(USer)用户登陆






//***********消息类************//


3、消息类Messege
         private int totalLength
         private byte[4] senderID
         private byte[4] receiverID
         
         get set

4、登陆消息LoginMsg extends Messege
         private byte[4] userID
         private byte[20] userPassword
         
         get set

5、注册消息RegisterMsg extends Messege 
         private byte[4] userID
         private byte[20] userPassword
          
         get set

6、聊天消息ChatMsg extends Messege
         private byte[400] words
         get set

//***********打包和解包*******//

7、PackageTools类
          private PackageTools

          public static Messege unpackMsg(DataInputStream) 
          public static void packMsg(DataOutputstream)
          解包打包分不同消息类分别处理

          private LoginMsg makeLoginMsg(DataInputStream dins)
          private RegisterMsg makeRegisterMsg(DataInputStream dins)
          private ChatMsg makeChatMsg(DataInputStream dins)

          private void packLoginMsg(Messege msg, DataOutputStream dous)
          private void packRegisterMsg(Messege msg, DataOutputStream dous)
          private void packChatMsg(Messege msg, DataOutputStream dous)

//***********用户服务线程****//

8、SocketThread extends Thread
          private User user
          private Socket client
          private InputStream ins
          private OutputStream ous
          private DataInputStream dins
          private DataOutputstream dous 

          user get set        
          
          public SocketThread(Socket) .....client ins ous dins dous
          
          public void run() ...... process()
          
          private void process()
 
          private void closeMe()

//***********客户机主线程****// 

9、ServerThread extends Thread
          private ServerSocket
          public SeerverThread(int)..........ServerSocket
          public void run()................process()
          private void process()........while(true)....
          



         
   1、登陆界面
    Start_UI类

    JText userID
    JText userPassword
    Button loginBtn ..... listener_log
    Button registerBtn ...... listener_reg

    public static User make_User()获取两个JText内容从而获得User的方法

2、Listener_Log类
       调用方法建立和服务器的连接
       调用make_User()
       调用方法生成消息对象，并调用打包发送 
       
3、Listener_Reg类
       调用方法建立和服务器的连接
       调用make_User()
       调用方法生成消息对象，并调用打包发送

4、Make_UserTools类
       private Make_UserTools()

       public static User make_User()从登陆界面JText获得user的方法
       
//********************************************************************************//

5、聊天界面
      MainUI extends Thread类

      JText viewText 聊天记录窗口
      Jtext inputText 聊天输入窗口
      JList contactsList 好友列表（暂不实现，保留组件）
      JButton sendBtn 消息发送按钮......Listener_SendBtn

      public static byte[] make_Msg()从聊天界面JText获得消息byte的方法
      public static void view_Msg()将显示推送到JText的方法

6、Listener_SendBtn类
      调用make_Msg()获得聊天消息
      调用make_Rec()得到接收者ID
      调用方法生成消息对象，并调用打包发送

//********************************************************************************//

7、PackageTools类
          private PackageTools

          public static Messege unpackMsg()
          public static void packMessege()
          打包和解包不同消息类分别处理

//********************************************************************************//

8、通信线程
    
   MainThread extends Thread
         完成输入输出的方法
          















