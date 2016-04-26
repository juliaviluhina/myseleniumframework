package core.conditions.collection;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Texts extends AbstractCollectionCondition {

    public List<String> currentTexts;
    public String[] texts;

    public Texts(String... texts) {
        this.texts = texts;
    }

    public String actual() {
        return Arrays.toString(currentTexts.toArray());
    }

    public String expected() {
        return Arrays.toString(texts);
    }

    public boolean check(List<WebElement> elements) {
        currentTexts = new ArrayList<String>();
        for (int i = 0; i < elements.size(); ++i) {
            currentTexts.add(i, elements.get(i).getText());
        }
        if (currentTexts.size() != texts.length) {
            return false;
        }
        for (int i = 0; i < texts.length; ++i) {
            if (!checkElement(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkElement(int index) {
        return currentTexts.get(index).contains(texts[index]);
    }

}
