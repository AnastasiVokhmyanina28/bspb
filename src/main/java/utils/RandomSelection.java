package utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

public class RandomSelection {

    public static SelenideElement randomize(ElementsCollection collection){
        return collection.get(new Random().nextInt(collection.size() + 1));
    }
}
