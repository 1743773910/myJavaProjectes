package chess.loginSystem;

import chess.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GameScrren extends JFrame{
    private User user;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private MainFrame mainFrame;
    private boolean player = false; // 先走
    private boolean shouldlock = false;
    public GameScrren(User user, ObjectOutputStream oos, ObjectInputStream ois){
        this.user = user;
        this.oos = oos;
        this.ois = ois;
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle(user.getAccount());

        Container contentPane = jFrame.getContentPane();
        ListModel mode = new DataModel();
        JList list = new JList(mode);
        list.setVisibleRowCount(10); // 打开时能看到数据项目个数
        list.setBorder(BorderFactory.createTitledBorder("选择对战玩家:")); // title
        contentPane.add(new JScrollPane(list));
        jFrame.pack();

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    String targetAccount = (String) mode.getElementAt(list.getSelectedIndex());
                    Message msg = new Message();
                    msg.setFrom(user.getAccount());
                    msg.setTo(targetAccount);
                    msg.setType(Message.Type.Fighting);
                    try {
                        oos.writeObject(msg);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    shouldlock = true;
                    player = true; // 后走
                }
            }
        });

        new Thread(() -> {
            while(true){
                Message msg = null;
                try {
                    msg = (Message) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                switch (msg.getType()){
                    case Update:
                        try {
                            update(list, msg);
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case Fighted:
                        try {
                            fighted(msg);
                            if(shouldlock) mainFrame.setLock(true);
                            if(player) mainFrame.setPlayer(player); // 后走
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case Move:
                        move(msg);
                        break;
                    case Regard:
                        regard(msg);
                        break;
                    case Peace:
                        break;
                    case GiveUp:
                        break;
                }
            }
        }).start();
    }

    public static void main(User user, ObjectOutputStream oos, ObjectInputStream ois) {
        new GameScrren(user, oos, ois);
    }
    public void update(JList list,Message msg) throws IOException, ClassNotFoundException {
        DataModel.add(msg.getArr());
        list.updateUI();
    }
    public void fighted(Message msg) throws Exception {
        MainFrame mainFrame = new MainFrame(oos, msg.getFrom(), msg.getTo());
        this.mainFrame = mainFrame;
        this.dispose();
    }

    public void move(Message msg){
        shouldlock = !shouldlock;
        if(shouldlock) mainFrame.setLock(true);
        else mainFrame.setLock(false);
        mainFrame.repaintChesses(msg.getMyChesses(), msg.getMyChessescnt());
    }

    public void regard(Message msg){
//        shouldlock = !shouldlock;
        if(shouldlock) mainFrame.setLock(true);
        else mainFrame.setLock(false);
        mainFrame.repaintChesses(msg.getMyChesses(), msg.getMyChessescnt());
    }
}

class DataModel extends AbstractListModel{
    static String[] s = new String[100];

    @Override
    public int getSize() {
        return s.length;
    }

    @Override
    public Object getElementAt(int index) {
        // 该index系统会自动从0开始计算，但+1操作要自己做
        return s[index];
    }

    public static void add(ArrayList<User> ou) throws IOException, ClassNotFoundException {
        int idx = 0;
        for(User u: ou){
            s[idx++] = u.getAccount();
        }
    }
}
