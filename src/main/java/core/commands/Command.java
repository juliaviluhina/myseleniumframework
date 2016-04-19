package core.commands;

import core.wrappers.LazyElement;
import org.openqa.selenium.WebElement;

public interface Command<T> {
    T execute(WebElement element);
}
