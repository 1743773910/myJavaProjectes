package chess;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitMap {
    public void add(Map<String, ArrayList> mymap, int t, String name){
        if(mymap.get(name) == null){
            ArrayList arr = new ArrayList();
            arr.add(t);
            mymap.put(name, arr);
        }else{
            mymap.get(name).add(t);
        }
    }


    public Map[] getmaps() throws Exception{
        String filePath1 = "C:\\Users\\Qiu\\IdeaProjects\\myjavaproject\\chess_sourses\\sources_f";
        File file1 = new File(filePath1);
        int x = 20,y = 25,width = 80,high = 80;
        int offsetx = 85, offsety = 97;
        File[] files = file1.listFiles();

        InitMap initMap = new InitMap();

        //名称-次数表
        Map<String, Integer> map = new HashMap<>();
        for(File file : files){
            if(file.getName().equals("zu_b.GIF") || file.getName().equals("bing_r.GIF")){
                map.put(file.getName(), 5);
            } else if (file.getName().equals("jiang_b.GIF") || file.getName().equals("shuai_r.GIF")) {
                map.put(file.getName(), 1);
            } else{
                map.put(file.getName(), 2);
            }
        }
        // 名称-x轴、y轴坐标表
        Map<String, ArrayList> mapx = new HashMap<>();
        Map<String, ArrayList> mapy = new HashMap<>();
        Map<String, String> mapName = new HashMap<>();
        for(File file : files){
            for(int i = 0; i < map.get(file.getName()); i++) {
                String absolutePath = file.getAbsolutePath();
                String name = file.getName();
                if(name.equals("zu_b.GIF")) {
                    initMap.add(mapx, i*2+1, name);
                    initMap.add(mapy, 4, name);
                } else if (name.equals("ju_b.GIF")) {
                    initMap.add(mapx, i*8+1, name);
                    initMap.add(mapy, 1, name);
                } else if (name.equals("ma_b.GIF")) {
                    initMap.add(mapx, (i == 0 ? 1 : 7)+1, name);
                    initMap.add(mapy, 1, name);
                } else if (name.equals("xiang_b.GIF")) {
                    initMap.add(mapx, (i == 0 ? 2 : 6)+1, name);
                    initMap.add(mapy, 1, name);
                } else if (name.equals("shi_b.GIF")) {
                    initMap.add(mapx, (i == 0 ? 3 : 5)+1, name);
                    initMap.add(mapy, 1, name);
                } else if (name.equals("jiang_b.GIF")) {
                    initMap.add(mapx, 4+1, name);
                    initMap.add(mapy, 1, name);
                } else if (name.equals("bing_r.GIF")) {
                    initMap.add(mapx, i*2+1, name);
                    initMap.add(mapy, 7, name);
                } else if (name.equals("pao_b.GIF")) {
                    initMap.add(mapx, (i == 0 ? 1 : 7)+1, name);
                    initMap.add(mapy, 3, name);
                } else if (name.equals("pao_r.GIF")) {
                    initMap.add(mapx, (i == 0 ? 1 : 7)+1, name);
                    initMap.add(mapy, 8, name);
                } else if (name.equals("ju_r.GIF")) {
                    initMap.add(mapx, i*8+1, name);
                    initMap.add(mapy, 10, name);
                } else if (name.equals("ma_r.GIF")) {
                    initMap.add(mapx, (i == 0 ? 1 : 7)+1, name);
                    initMap.add(mapy, 10, name);
                } else if (name.equals("xiang_r.GIF")) {
                    initMap.add(mapx, (i == 0 ? 2 : 6)+1, name);
                    initMap.add(mapy, 10, name);
                } else if (name.equals("shi_r.GIF")) {
                    initMap.add(mapx, (i == 0 ? 3 : 5)+1, name);
                    initMap.add(mapy, 10, name);
                }else{
                    initMap.add(mapx, 4+1, name);
                    initMap.add(mapy, 10, name);
                }
                mapName.put(name, absolutePath);
            }
        }
        Map[] maps = new Map[3];
        maps[0] = mapx;
        maps[1] = mapy;
        maps[2] = mapName;
        return maps;
    }

}
