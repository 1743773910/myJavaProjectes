package chess.loginSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class LoginScreen extends JFrame{
    private JTextField tfAccount = null;
    private JPasswordField tfPwd = null;
    public LoginScreen(){
        JFrame jFrame = new JFrame();
        jFrame.setSize(400, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLayout(null); // ???????
        jFrame.setLocationRelativeTo(null); // ????
        // ???
        JLabel lbAccount = new JLabel("user");
        lbAccount.setBounds(70,50,50,40);
        jFrame.add(lbAccount);
        tfAccount = new JTextField();
        tfAccount.setBounds(110, 50, 200, 40);
        jFrame.add(tfAccount);

        // ????
        JLabel lbPwd = new JLabel("Pwd");
        lbPwd.setBounds(70,110,50,40);
        jFrame.add(lbPwd);
        tfPwd = new JPasswordField();
        tfPwd.setBounds(110, 110, 200, 40);
        jFrame.add(tfPwd);

        // ???
        JButton btnLogin = new JButton("login");
        btnLogin.setBounds(80,200, 250,60);
        jFrame.add(btnLogin);
        btnLogin.setActionCommand("login");
        // ??????
        JButton btnReg = new JButton("register");
        btnReg.setBounds(80, 300, 120, 30);
        jFrame.add(btnReg);
        btnReg.setActionCommand("register");
        // ????????
        JButton forgetPwd = new JButton("forgetPwd");
        forgetPwd.setBounds(220, 300, 120, 30);
        jFrame.add(forgetPwd);
        forgetPwd.setActionCommand("forget");

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                switch (cmd){
                    case "login":
                        try {
                            login();
                        } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "register":
                        try {
                            register();
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "forget":
                        break;
                }
            }
        };
        btnLogin.addActionListener(actionListener);
        btnReg.addActionListener(actionListener);
        forgetPwd.addActionListener(actionListener);
    }

    public static Socket creatSocket(String ip, int port) throws IOException {
        return new Socket(InetAddress.getByName(ip), port);
    }

    private void login() throws IOException, ClassNotFoundException, InterruptedException {
        String account = tfAccount.getText();
        String pwd = new String(tfPwd.getPassword());
        Socket socket = creatSocket("127.0.0.1", 8080);
        User user = new User(account,pwd, socket);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message msg = new Message();
        msg.setFrom(account);
        msg.setPwd(pwd);
        msg.setType(Message.Type.Login);

        oos.writeObject(msg);
        Message get = (Message) ois.readObject();
        if(get != null){
            System.out.println("login success");
            GameScrren.main(user, oos, ois);
        }else{
            System.out.println("login filed");
        }
    }

    private void register() throws IOException, ClassNotFoundException {
        String account = tfAccount.getText();
        String pwd = new String(tfPwd.getPassword());
        boolean flag = UsersMap.add(account, pwd);
        if(flag){
            System.out.println("register success");
        }else{
            System.out.println("register failed");
        }
    }
    public static void main(String[] args) {
        new LoginScreen();
    }

}
