package core.commands;

import org.openqa.selenium.WebElement;

public interface Command<TypeOfResult> {
    void setParameters(Object... parameters);
    TypeOfResult execute(WebElement element);
}
