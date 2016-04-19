package core.commands;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;

public class GetRect implements Command<Rectangle> {
    @Override
    public Rectangle execute(WebElement element) {
        return element.getRect();
    }
}
