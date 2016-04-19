package core.commands;

import org.openqa.selenium.WebElement;

public class GetTagName implements Command<String>  {

    public String execute(WebElement element) {
        return element.getTagName();
    }
}
