package chess;

import chess.loginSystem.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;

// 游戏面板
public class DrawModel extends JPanel{
    // 画棋盘
    private Chesses[] myChesses;
    private Chesses[] lastMyChesses = new Chesses[32];

    public void setChessescnt(int chessescnt) {
        this.chessescnt = chessescnt;
    }

    public void setMyChesses(Chesses[] myChesses) {
        this.myChesses = myChesses;
    }

    private int chessescnt = 32;
    private int lastChessescnt = 32;

    public boolean isCurplayer() {
        return curplayer;
    }

    private Chesses selectChess = null;
    private boolean curplayer = false;

    public void setCurplayer(boolean curplayer) {
        this.curplayer = curplayer;
    }

    private JLabel jLabel;
    private boolean islocked = false;
    public void setIslocked(boolean islocked){
        this.islocked = islocked;
    }
    public boolean getIslocket(){
        return islocked;
    }
    public void setjLabel(JLabel jLabel){
        this.jLabel = jLabel;
    }

    @Override
    public void paint(Graphics g){
        int x, y, width, high;
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();// 获取Toolkit的实例
        Image background = defaultToolkit.getImage("C:\\Users\\Qiu\\IdeaProjects\\myjavaproject\\chess_sourses\\blackground.GIF");
        g.drawImage(background, 0, 0, 800, 1000, this);
//       通过图片路径得到图片对象
        for(int i = 0; i < chessescnt; i++){
            Image image = defaultToolkit.getImage(myChesses[i].getAbsoluteName());
            x = (int) myChesses[i].getP().getX() - 40;
            y = (int) myChesses[i].getP().getY() - 40;
            width = high = 80;
            g.drawImage(image, x, y, width, high, this);
        }
        if(selectChess != null){
            drawRect(g, selectChess);
        }
    }
    public void drawRect(Graphics g, Chesses c){
        g.drawRect((int)c.getP().getX()-40,(int)c.getP().getY()-40,80,80);
    }
    void swap(Chesses[] myChesses, int i, int j){
        Chesses tmp = myChesses[i];
        myChesses[i] = myChesses[j];
        myChesses[j] = tmp;
    }
    public DrawModel(ObjectOutputStream oos,String account1, String account2) throws Exception {
        InitChesses initChesses = new InitChesses();
        myChesses = initChesses.getChesses();
        copyChesses();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(islocked) return;
                Point p = getpoint(e);
                Chesses c = isvalid(e, myChesses);
                if(selectChess == null){
                    selectChess = c;
                    if(c != null && c.getPlayer() != curplayer){
                        selectChess = null;
                    }
                }else{
                    if(c != null){
                        if(c.getPlayer() == selectChess.getPlayer()){
                            // 重新选择
                            selectChess = c;
                            if(c.getPlayer() != curplayer){
                                selectChess = null;
                            }
                        }else{
                            // 吃
                            if(initChesses.isValidMove(selectChess, p, myChesses, chessescnt)){
                                copyChesses();
                                int idx = getpos(c);
                                swap(myChesses, idx, --chessescnt);
                                selectChess.setP(p);
                                selectChess.setX(p.x);
                                selectChess.setY(p.y);
                                if(c.getName().equals("jiang_b.GIF")){
                                    System.out.println("red win");
                                }
                                if(c.getName().equals("shuai_r.GIF")){
                                    System.out.println("black win");
                                }
                                over(jLabel);

                                Message msg = new Message();
                                msg.setType(Message.Type.Moveover);
                                msg.setMyChesses(myChesses);
                                msg.setMyChessescnt(chessescnt);
                                msg.setFrom(account1);
                                msg.setTo(account2);
                                try {
                                    oos.writeObject(msg); // 客户端发往服务端
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }else{
                                System.out.println("不能这样移动");
                            }
                        }
                    }else{
                        // 移动
                        if(initChesses.isValidMove(selectChess, p, myChesses, chessescnt)){
                            copyChesses();
                            selectChess.setP(p);
                            selectChess.setX(p.x);
                            selectChess.setY(p.y);
                            over(jLabel);

                            Message msg = new Message();
                            msg.setType(Message.Type.Moveover);
                            msg.setMyChesses(myChesses);
                            msg.setMyChessescnt(chessescnt);
                            msg.setFrom(account1);
                            msg.setTo(account2);
                            try {
                                oos.writeObject(msg); // 客户端发往服务端
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }else{
                            System.out.println("不能这样移动");
                        }

                    }
                }
                repaint();
            }
        });
    }
    // 判断点击是否有效
    public Chesses isvalid(MouseEvent e, Chesses[] chesses){
        for(int i = 0; i < chessescnt; i++){
            if((chesses[i].getP().getX() - e.getX())
                    * (chesses[i].getP().getX() - e.getX())
                    + (chesses[i].getP().getY() - e.getY())
                    * (chesses[i].getP().getY() - e.getY())
                    <= 40*40
            ){
                return chesses[i];
            }
        }
        return null;
    }
    //  输出点击坐标
    public Point getpoint(MouseEvent e){
        Point p = new Point();
        p.x = (e.getX() - 20) / 85 + 1;
        p.y = (e.getY() - 25) / 97 + 1;
        return p;
    }
    public int getpos(Chesses c){
        for(int i = 0; i < chessescnt; i++){
            if(c == myChesses[i]){
                return i;
            }
        }
        return 0;
    }
    public void over(JLabel hintLabel){
        selectChess = null;
        if(hintLabel.getText().equals("红方走")){
            hintLabel.setText("黑方走");
        }else{
            hintLabel.setText("红方走");
        }
    }
    public void copyChesses(){
        lastChessescnt = 0;
        for(int i = 0; i < chessescnt; i++){
            Chesses tmpchesses = new Chesses(myChesses[i].getX(), myChesses[i].getY(), myChesses[i].getName(), myChesses[i].getAbsoluteName());
            lastMyChesses[lastChessescnt++] = tmpchesses;
        }
    }
    public void buttonWork(int choise, String account1, String account2, ObjectOutputStream oos){
        if(choise == 1){
            chessescnt = 0;
            for(int i = 0; i < lastChessescnt; i++){
                Chesses tmpchesses = new Chesses(lastMyChesses[i].getX(), lastMyChesses[i].getY(), lastMyChesses[i].getName(), lastMyChesses[i].getAbsoluteName());
                myChesses[chessescnt++] = tmpchesses;
            }
            over(jLabel);
            Message msg = new Message();
            msg.setType(Message.Type.Regard);
            msg.setMyChesses(myChesses);
            msg.setMyChessescnt(chessescnt);
            msg.setFrom(account1);
            msg.setTo(account2);
            try {
                oos.writeObject(msg); // 客户端发往服务端
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
