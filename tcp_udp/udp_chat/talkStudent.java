package tcp_udp.udp_chat;

public class talkStudent {
    public static void main(String[] args) {
        new Thread(new send(7777, "localhost", 9999)).start();
        new Thread(new recv(8888, "老师")).start();
    }
}
