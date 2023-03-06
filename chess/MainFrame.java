package chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

public class MainFrame extends JFrame{
    private DrawModel drawModel;

    public MainFrame(ObjectOutputStream oos, String account1, String account2) throws Exception {

        // 创建窗口对象
        JFrame jFrame = new JFrame();
        // 设置窗口大小
        jFrame.setSize(900,1000);
        // 设置布局管理员
        jFrame.setLayout(new BorderLayout());
        // 添加按钮面板
        JPanel btnPanel = new JPanel(new GridLayout(6, 1));
        // 将游戏面板添加到窗口中
        jFrame.add(btnPanel, BorderLayout.EAST);
        DrawModel drawModel = new DrawModel(oos,account1,account2);
        jFrame.add(drawModel);
        this.drawModel = drawModel;
        jFrame.setTitle(account1);


        // 创建按钮
        JLabel hintLable =  new JLabel("红方走");
        drawModel.setjLabel(hintLable);
        JButton btn01 = new JButton("悔棋");
        JButton btn02 = new JButton("保存棋谱");
        JButton btn03 = new JButton("导入棋谱");
        JButton btn04 = new JButton("求和");
        JButton btn05 = new JButton("认输");
        btnPanel.add(hintLable);
        btnPanel.add(btn01);
        btnPanel.add(btn02);
        btnPanel.add(btn03);
        btnPanel.add(btn04);
        btnPanel.add(btn05);
        btn01.setActionCommand("huiqi"); //点击按钮后可从鼠标事件收到一个字符串用于判断
        btn02.setActionCommand("baocun");
        btn03.setActionCommand("daoru");
        btn04.setActionCommand("qiuhe");
        btn05.setActionCommand("renshu");
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                switch(cmd){
                    case "huiqi":
                        drawModel.buttonWork(1, account1, account2, oos);
                        break;
                    case "baocun":
                        break;
                    case "daoru":
                        break;
                    case "qiuhe":
                        break;
                    case "renshu":
                        break;
                }
            }
        };
        btn01.addActionListener(actionListener);
        btn02.addActionListener(actionListener);
        btn03.addActionListener(actionListener);
        btn04.addActionListener(actionListener);
        btn05.addActionListener(actionListener);
        // 显示窗口
        jFrame.setVisible(true);
        // 点击关闭窗口时结束虚拟机运行
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean getLock(){
        return drawModel.getIslocket();
    }
    public void setLock(boolean flag){
        drawModel.setIslocked(flag);
    }

    public void repaintChesses(Chesses[] newChesses, int cnt){
        drawModel.setMyChesses(newChesses);
        drawModel.setChessescnt(cnt);
        drawModel.repaint();
    }

    public void setPlayer(boolean flag){
        drawModel.setCurplayer(flag);
    }
}
