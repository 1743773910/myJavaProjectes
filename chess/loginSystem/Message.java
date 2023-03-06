package chess.loginSystem;

import chess.Chesses;

import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

public class Message implements Serializable {
    private Object content;
    private Type type;
    private transient Socket socket;
    public int getMyChessescnt() {
        return myChessescnt;
    }
    public void setMyChessescnt(int myChessescnt) {
        this.myChessescnt = myChessescnt;
    }
    private Chesses[] myChesses;

    public Chesses[] getMyChesses() {
        return myChesses;
    }

    public void setMyChesses(Chesses[] myChesses) {
        this.myChesses = myChesses;
    }

    private int myChessescnt;
    // false表示客户端发往服务端
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    private ArrayList<User> arr = new ArrayList<>();
    public ArrayList<User> getArr(){
        return  arr;
    }

    public void setArr(User user) {
        arr.add(user);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    private String pwd;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    private String from;
    private String to;

    public static enum Type implements Serializable{
        Login,
        Forget,
        Fighting,
        Move,
        Peace,
        GiveUp,
        Update,
        Fighted,
        Moveover,
        LoginBack,
        Regard;
    }

    public Message(Object content, Type type, String from, String to){
        this.content = content;
        this.type = type;
        this.from = from;
        this.to = to;
    }
    public Message(){

    }
    public Message(Object content, Type type){
        this.content = content;
        this.type = type;
    }

}
