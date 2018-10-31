package util;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {
    private final Set<Integer> keys = new HashSet<>();

    public int create() {
        int id;
        do {
            id = 100+(int) (Math.random() * 100);

        } while (keys.contains(id));
        keys.add(id);
        return id;
    }

    public boolean contains(int id) {
        return keys.contains(id);
    }

    public void remove(int id) {
        keys.remove(id);
    }
}
