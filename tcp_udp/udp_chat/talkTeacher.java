package tcp_udp.udp_chat;

public class talkTeacher {
    public static void main(String[] args) {
        new Thread(new send(10000, "localhost", 8888)).start();
        new Thread(new recv(9999, "学生")).start();
    }
}
