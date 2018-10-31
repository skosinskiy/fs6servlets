package util;

import java.util.HashMap;
import java.util.Map;

public class LoginServer<T> {
    private final Map<Integer, T> users = new HashMap<>();

    public void login(int id, T name) {
        users.put(id, name);
    }

    public void logout(int id) {
        users.remove(id);
    }

    public boolean isLogged(int id) {
        return users.containsKey(id);
    }

    public T getName(String id) {
        return getName(Integer.parseInt(id));
    }

    public T getName(int id) {
        return users.get(id);
    }
}
