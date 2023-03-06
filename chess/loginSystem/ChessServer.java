package chess.loginSystem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


public class ChessServer{
    private static ServerSocket serverSocket = null;
    public static ArrayList<Socket> clients = new ArrayList<>();
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clients.add(socket);
            ServerThread serverThread = new ServerThread();
            serverThread.setSocket(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
}


class ServerThread implements Runnable {
    private static Socket socket;
    private static HashMap<Socket, ObjectOutputStream> oosMap = new HashMap<>();
    private static HashMap<String, Socket> ssMap = new HashMap<>();
    public void setSocket(Socket socket) {
        ServerThread.socket = socket;
    }
    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;

    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            oosMap.put(socket, oos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            Message msg = null;
            try {
                msg = (Message) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            switch (msg.getType()) {
                case Login:
                    boolean flag = UsersMap.add(msg.getFrom(), msg.getPwd());
                    ssMap.put(msg.getFrom(), socket);
                    loginBack(msg, socket);
                    break;
                case Fighting:
                    try {
                        fighting(msg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case Regard:
                    try {
                        regard(msg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                case Moveover:
                    try {
//                        System.out.println("moveOver");
                        moveOver(msg);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }

    private void loginBack (Message msg, Socket socket){
        if (UsersMap.find(msg)) {
            try {
                msg.setType(Message.Type.LoginBack);
                msg.setSocket(socket);
                oos.writeObject(msg);
                User user = new User((String) msg.getFrom(), msg.getPwd());
                OnlineUsers.onlineUsers.add(user);
                updateTable();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                oos.writeObject(null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void fighting (Message msg) throws IOException {
        String from = msg.getFrom();
        String to = msg.getTo();
        Socket socketFrom = ssMap.get(msg.getFrom());
        Socket socketTo = ssMap.get(msg.getTo());
        ObjectOutputStream oosFrom = oosMap.get(socketFrom);
        ObjectOutputStream oosTo = oosMap.get(socketTo);
        Message newMsg1 = new Message();
        Message newMsg2 = new Message();
        newMsg1.setFrom(from);
        newMsg2.setFrom(to);
        newMsg1.setType(Message.Type.Fighted);
        newMsg2.setType(Message.Type.Fighted);
        newMsg1.setTo(to);
        newMsg2.setTo(from);
        oosFrom.writeObject(newMsg1);
        oosTo.writeObject(newMsg2);
    }

    public void moveOver (Message msg) throws IOException {
        // 把棋盘发送给双方，更新双方棋盘
        Message msgnew = new Message();
        msgnew.setType(Message.Type.Move);
        msgnew.setMyChesses(msg.getMyChesses());
        msgnew.setMyChessescnt(msg.getMyChessescnt());
        Socket socket1 = ssMap.get(msg.getFrom());
        Socket socket2 = ssMap.get(msg.getTo());
        ObjectOutputStream oos1 = oosMap.get(socket1);
        ObjectOutputStream oos2 = oosMap.get(socket2);
        oos1.writeObject(msgnew);
        oos2.writeObject(msgnew);
    }

    public void regard(Message msg) throws IOException {
        Message msgnew = new Message();
        msgnew.setType(Message.Type.Regard);
        msgnew.setMyChesses(msg.getMyChesses());
        msgnew.setMyChessescnt(msg.getMyChessescnt());
        Socket socket1 = ssMap.get(msg.getFrom());
        Socket socket2 = ssMap.get(msg.getTo());
        ObjectOutputStream oos1 = oosMap.get(socket1);
        ObjectOutputStream oos2 = oosMap.get(socket2);
        oos1.writeObject(msgnew);
        oos2.writeObject(msgnew);
    }

    public static void updateTable () throws IOException {
        // 向全体在线用户通告更新对战表,服务端发给客户端
        for (Socket socket1:ChessServer.clients) {
            Message usermessage = new Message();
            usermessage.setType(Message.Type.Update);
            for(User user1:OnlineUsers.onlineUsers){
                usermessage.setArr(user1);
            }
            ObjectOutputStream oos = oosMap.get(socket1);
            oos.writeObject(usermessage);
        }
    }

}
