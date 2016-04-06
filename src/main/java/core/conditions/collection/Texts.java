package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Texts extends CollectionCondition {

    protected List<String> currentTexts;
    protected String[] texts;

    public Texts(String... texts) {
        this.texts = texts;
    }

    public String actual() {
        return Arrays.toString(currentTexts.toArray());
    }

    public String expected() {
        return Arrays.toString(texts);
    }

    protected List<WebElement> check() {
        currentTexts = new ArrayList<String>();
        for (int i = 0; i < wrappedEntity.size(); ++i) {
            currentTexts.add(i, wrappedEntity.get(i).getText());
        }
        if (currentTexts.size() != texts.length) {
            return null;
        } else {
            for (int i = 0; i < texts.length; ++i) {
                if (!checkElement(i)) {
                    return null;
                }
            }
            return wrappedEntity;
        }
    }

    protected boolean checkElement(int index) {
        return currentTexts.get(index).contains(texts[index]);
    }


}
