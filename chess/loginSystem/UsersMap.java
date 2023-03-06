package chess.loginSystem;

import java.util.HashMap;

public class UsersMap{
    public static HashMap<String, String> map = new HashMap<>();

    public static boolean add(String account,String pwd){
        try {
            map.put(account, pwd);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static boolean find(Message message){
        return map.get(message.getFrom()).equals(message.getPwd());
    }
    public static boolean remove(Message message){
        return map.remove(message.getFrom(), message.getPwd());
    }
}
