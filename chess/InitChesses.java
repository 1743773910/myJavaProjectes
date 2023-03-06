package chess;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class InitChesses {
    public Chesses[] getChesses() throws Exception {
        Chesses[] chesses = new Chesses[32];
        int i = 0;
        InitMap initMap = new InitMap();
        Map[] maps = initMap.getmaps();
        Map<String, ArrayList> mapx = maps[0];
        Map<String, ArrayList> mapy = maps[1];
        Map<String, String> mapName = maps[2];
        for(String key:mapx.keySet()){
            ArrayList arrx = mapx.get(key);
            ArrayList arry = mapy.get(key);
            Iterator itx = arrx.iterator();
            Iterator ity = arry.iterator();
            while(itx.hasNext()){
                Chesses chess = new Chesses((Integer) itx.next(), (Integer) ity.next(), key, mapName.get(key));
                chesses[i++] = chess;
            }
        }
        return chesses;
    }

    public Chesses thisPointHasChess(Point p, Chesses[] myChesses, int myChessescnt){
        for(int i = 0; i < myChessescnt; i++){
            if(myChesses[i].getX() == p.getX() && myChesses[i].getY() == p.getY()){
                return myChesses[i]; // 有
            }
        }
        return null;
    }
    public int abs(int a, int b){
        return a > b ? a - b : b - a;
    }

    public boolean juIsValid(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(p.getY() != select.getY() && p.getX() != select.getX()) return false;
        if(p.getX() == select.getX()){
            int start = select.getY(), end = (int)p.getY();
            start = start > end ? start - 1 : start + 1;
            if(start > end){
                for(int i = start; i >= end; i--){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        if(end == i) return true;
                        else return false;
                    }
                }
            }else{
                for(int i = start; i <= end; i++){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        if(end == i) return true;
                        else return false;
                    }
                }
            }
        }
        if(p.getY() == select.getY()) {
            int start = select.getX(), end = (int) p.getX();
            start = start > end ? start - 1 : start + 1;
            if (start > end) {
                for (int i = start; i >= end; i--) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        if (end == i) return true;
                        else return false;
                    }
                }
            } else {
                for (int i = start; i <= end; i++) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        if (end == i) return true;
                        else return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean maIsValid(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(!((abs((int)p.getX(), select.getX()) == 1 && abs((int)p.getY(), select.getY()) == 2) ||
                (abs((int)p.getY(), select.getY()) == 1 && abs((int)p.getX(), select.getX()) == 2))){
            return false;
        }
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();
        p1.x = p3.x = select.getX();
        p2.y = p4.y = select.getY();
        if((p1.y = select.getY()-1) >= 1 && thisPointHasChess(p1, myChesses, myChessescnt) != null
                && ((select.getX() - 1 == p.getX() && select.getY() - 2 == p.getY())
                || (select.getX() + 1 == p.getX() && select.getY() - 2 == p.getY()))) return false;
        if((p3.y = select.getY()+1) <= 10 && thisPointHasChess(p3, myChesses, myChessescnt) != null
                && ((select.getX() - 1 == p.getX() && select.getY() + 2 == p.getY())
                || (select.getX() + 1 == p.getX() && select.getY() + 2 == p.getY()))) return false;
        if((p2.x = select.getX()+1) <= 9 && thisPointHasChess(p2, myChesses, myChessescnt) != null
                && ((select.getX() + 2 == p.getX() && select.getY() + 1 == p.getY())
                || (select.getX() + 2 == p.getX() && select.getY() - 1 == p.getY()))) return false;
        if((p4.x = select.getX()-1) >= 1 && thisPointHasChess(p4, myChesses, myChessescnt) != null
                && ((select.getX() - 2 == p.getX() && select.getY() - 1 == p.getY())
                || (select.getX() - 2 == p.getX() && select.getY() + 1 == p.getY()))) return false;
        return true;
    }
    public boolean xiangIsValid(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(!(abs((int)p.getX(), select.getX()) == 2 && abs((int)p.getY(), select.getY()) == 2)) return false;
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();
        p1.x = select.getX() - 1;
        p1.y = select.getY() - 1;
        p2.x = select.getX() + 1;
        p2.y = select.getY() - 1;
        p3.x = select.getX() + 1;
        p3.y = select.getY() + 1;
        p4.x = select.getX() - 1;
        p4.y = select.getY() + 1;
        if(p1.x >= 1 && p1.y >= 1 && thisPointHasChess(p1, myChesses, myChessescnt) != null
                && select.getX() - 2 == p.getX() && select.getY() - 2 == p.getY()) return false;
        if(p2.x <= 9 && p1.y >= 1 && thisPointHasChess(p2, myChesses, myChessescnt) != null
                && select.getX() + 2 == p.getX() && select.getY() - 2 == p.getY()) return false;
        if(p3.x <= 9 && p1.y <= 10 && thisPointHasChess(p3, myChesses, myChessescnt) != null
                && select.getX() + 2 == p.getX() && select.getY() + 2 == p.getY()) return false;
        if(p4.x >= 1 && p1.y <= 10 && thisPointHasChess(p4, myChesses, myChessescnt) != null
                && select.getX() - 2 == p.getX() && select.getY() + 2 == p.getY()) return false;
        return true;
    }
    public boolean paoEatIsValid(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(p.getY() != select.getY() && p.getX() != select.getX()) return false;
        int cnt = 0;
        if(p.getX() == select.getX()){
            int start = select.getY(), end = (int)p.getY();
            start = start > end ? start - 1 : start + 1;
            if(start > end){
                for(int i = start; i >= end; i--){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        cnt++;
                    }
                }
            }else{
                for(int i = start; i <= end; i++){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        cnt++;
                    }
                }
            }
        }
        if(p.getY() == select.getY()) {
            int start = select.getX(), end = (int) p.getX();
            start = start > end ? start - 1 : start + 1;
            if (start > end) {
                for (int i = start; i >= end; i--) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        cnt++;
                    }
                }
            } else {
                for (int i = start; i <= end; i++) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        cnt++;
                    }
                }
            }
        }
        if(cnt == 2) return true;
        return false;
    }
    public boolean paoMoveIsValid(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(p.getY() != select.getY() && p.getX() != select.getX()) return false;
        if(p.getX() == select.getX()){
            int start = select.getY(), end = (int)p.getY();
            start = start > end ? start - 1 : start + 1;
            if(start > end){
                for(int i = start; i >= end; i--){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        return false;
                    }
                }
            }else{
                for(int i = start; i <= end; i++){
                    Point newPoint = new Point();
                    newPoint.x = (int)p.getX();
                    newPoint.y = i;
                    if(thisPointHasChess(newPoint, myChesses, myChessescnt) != null){
                        return false;
                    }
                }
            }
        }
        if(p.getY() == select.getY()) {
            int start = select.getX(), end = (int) p.getX();
            start = start > end ? start - 1 : start + 1;
            if (start > end) {
                for (int i = start; i >= end; i--) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = start; i <= end; i++) {
                    Point newPoint = new Point();
                    newPoint.x = i;
                    newPoint.y = (int) p.getY();
                    if (thisPointHasChess(newPoint, myChesses, myChessescnt) != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidMove(Chesses select, Point p, Chesses[] myChesses, int myChessescnt){
        if(select.getName().equals("jiang_b.GIF")){
            if(!(p.getX() >= 4 && p.getX() <= 6 && p.getY() <= 3 && p.getY() >=1)) return false;
            if(select.getX() != p.getX() && select.getY() != p.getY()) return false;
            if(select.getX() == p.getX() && abs((int)p.getY(), select.getY()) != 1) return false;
            if(select.getY() == p.getY() && abs((int)p.getX(), select.getX()) != 1) return false;
        } else if (select.getName().equals("shuai_r.GIF")) {
            if(!(p.getX() >= 4 && p.getX() <= 6 && p.getY() <= 10 && p.getY() >= 8)) return false;
            if(select.getX() != p.getX() && select.getY() != p.getY()) return false;
            if(select.getX() == p.getX() && abs((int)p.getY(), select.getY()) != 1) return false;
            if(select.getY() == p.getY() && abs((int)p.getX(), select.getX()) != 1) return false;
        } else if (select.getName().equals("zu_b.GIF")) {
            if(select.getY() <= 5){
                if(p.getX() == select.getX() && p.getY() - select.getY() == 1) return true;
                return false;
            }else{
                if(p.getY() < select.getY()) return false;
                if(select.getX() != p.getX() && select.getY() != p.getY()) return false;
                if(select.getX() == p.getX() && abs((int)p.getY(), select.getY()) != 1) return false;
                if(select.getY() == p.getY() && abs((int)p.getX(), select.getX()) != 1) return false;
            }
        } else if (select.getName().equals("bing_r.GIF")) {
                if(select.getY() >= 6){
                    if(p.getX() == select.getX() && select.getY() - p.getY() == 1) return true;
                    return false;
                }else{
                    if(p.getY() > select.getY()) return false;
                    if(select.getX() != p.getX() && select.getY() != p.getY()) return false;
                    if(select.getX() == p.getX() && abs((int)p.getY(), select.getY()) != 1) return false;
                    if(select.getY() == p.getY() && abs((int)p.getX(), select.getX()) != 1) return false;
                }
        } else if (select.getName().equals("ju_b.GIF")) {
            return juIsValid(select, p, myChesses, myChessescnt);
        }else if (select.getName().equals("ju_r.GIF")){
            return juIsValid(select, p, myChesses, myChessescnt);
        } else if (select.getName().equals("ma_b.GIF")) {
            return maIsValid(select, p, myChesses, myChessescnt);
        } else if (select.getName().equals("ma_r.GIF")) {
            return maIsValid(select, p, myChesses, myChessescnt);
        } else if (select.getName().equals("xiang_b.GIF")) {
            if(p.getY() >= 6) return false;
            return xiangIsValid(select, p, myChesses, myChessescnt);
        } else if (select.getName().equals("xiang_r.GIF")) {
            if(p.getY() <= 4) return false;
            return xiangIsValid(select, p, myChesses, myChessescnt);
        } else if (select.getName().equals("shi_b.GIF")) {
            if(!(p.getX() >= 4 && p.getX() <= 6 && p.getY() <= 3 && p.getY() >=1)) return false;
            if(!(abs((int)p.getX(), select.getX()) == 1 && abs((int)p.getY(), select.getY()) == 1)) return false;
        } else if (select.getName().equals("shi_r.GIF")) {
            if(!(p.getX() >= 4 && p.getX() <= 6 && p.getY() <= 10 && p.getY() >= 8)) return false;
            if(!(abs((int)p.getX(), select.getX()) == 1 && abs((int)p.getY(), select.getY()) == 1)) return false;
        } else {
            if(thisPointHasChess(p, myChesses, myChessescnt) != null){
                // 吃，看是否符合规则
                return paoEatIsValid(select, p, myChesses, myChessescnt);
            }else{
                // 移动
                return paoMoveIsValid(select, p, myChesses, myChessescnt);
            }
        }
        return true;
    }

}
