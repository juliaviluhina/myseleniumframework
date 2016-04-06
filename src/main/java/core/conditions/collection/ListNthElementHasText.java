package core.conditions.collection;

import core.conditions.CollectionCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNthElementHasText extends CollectionCondition {

    private String currentText;
    protected final String text;
    protected final int index;

    public ListNthElementHasText(int index, String text) {
        this.index = index;
        this.text = text;
    }

    public String actual() {
        return currentText;
    }

    public String expected() {
        return text;
    }

    protected WebElement check() {
        WebElement element = wrappedEntity.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }


}
