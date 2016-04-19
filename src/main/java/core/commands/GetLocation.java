package core.commands;

import core.wrappers.LazyElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class GetLocation implements Command<Point> {

    public Point execute(WebElement element) {
        return element.getLocation();
    }
}
