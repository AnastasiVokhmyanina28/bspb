package utils;

import java.util.List;
import java.util.Random;

public class RandomSelection {

    public static <T extends List<R>, R> R randomize(T collection) {
        return collection.get(new Random().nextInt(collection.size() + 1));
    }
}
