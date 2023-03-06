package chess;

import java.awt.*;
import java.io.Serializable;

public class Chesses extends InitMap implements Serializable {
    private final int SIZE = 80;
    private final int MARGINX = 20; // 距棋盘边缘
    private final int MARGINY = 25;
    private final int OFFSETX = 85;
    private final int OFFSETY = 97;
    private int x; // 棋子绘制时的坐标位置
    private int y;
    private Point p; // 棋子网格坐标
    private String name;
    private boolean player; // 0红1黑
    private String absoluteName;
    public Chesses(int x, int y, String name, String absoluteName){
        this.x = x;
        this.y = y;
        this.name = name;
        this.absoluteName = absoluteName;
        Point point = new Point();
        point.x = MARGINX + (x-1) * OFFSETX+40;
        point.y = MARGINY + (y-1) * OFFSETY+40;
        this.p = point;
        for(int i = 0; i < name.length(); i++){
            if(name.charAt(i) == '_'){
                if(name.charAt(i+1) == 'r') this.player = false;
                else{
                    this.player = true;
                }
            }
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Point getP(){
        return p;
    }
    public String getName(){
        return name;
    }
    public boolean getPlayer(){
        return player;
    }
    public String getAbsoluteName(){
        return absoluteName;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setP(Point p){
        Point point = new Point();
        point.x = MARGINX + ((int)p.getX()-1) * OFFSETX+40;
        point.y = MARGINY + ((int)p.getY()-1) * OFFSETY+40;
        this.p = point;
    }
}
