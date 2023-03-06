package chess.loginSystem;

import java.util.HashSet;

public class OnlineUsers {
    public static HashSet<User> onlineUsers = new HashSet<User>();

    public static void add(User user){
        onlineUsers.add(user);
    }
}
