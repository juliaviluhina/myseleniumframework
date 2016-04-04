package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Texts extends CustomCollectionCondition {

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

    public List<WebElement> apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        if (currentTexts.size() != texts.length) {
            return null;
        } else {
            for (int i = 0; i < texts.length; ++i) {
                if (!checkElement(i)) {
                    return null;
                }
            }
            return elements;
        }
    }

    protected boolean checkElement(int index) {
        return currentTexts.get(index).contains(texts[index]);
    }
}
