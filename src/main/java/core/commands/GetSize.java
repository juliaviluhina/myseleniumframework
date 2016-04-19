package core.commands;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class GetSize implements Command<Dimension> {
    @Override
    public Dimension execute(WebElement element) {
        return element.getSize();
    }
}
