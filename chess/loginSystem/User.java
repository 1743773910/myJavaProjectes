package chess.loginSystem;

import java.io.Serializable;
import java.net.Socket;

public class User implements Serializable {
    private String account;
    private String pwd;
    private transient Socket socket;

    public User(String account, String pwd, Socket socket){
        this.account = account;
        this.pwd = pwd;
        this.socket = socket;
    }
    public User(String account, String pwd){
        this.account = account;
        this.pwd = pwd;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account = account;
    }
    public String getPwd(){
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
