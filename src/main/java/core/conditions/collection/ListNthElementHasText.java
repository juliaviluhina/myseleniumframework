package core.conditions.collection;

import core.conditions.CustomCollectionCondition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNthElementHasText extends CustomCollectionCondition {

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

    public WebElement apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        List<WebElement> elements = (List<WebElement>) lazyEntity.getWrappedEntity();
        WebElement element = elements.get(index);
        currentText = element.getText();
        return (currentText.contains(text)) ? element : null;
    }


}
