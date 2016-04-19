package core.commands;

import org.openqa.selenium.WebElement;


public class GetAttribute implements Command<String> {
    String s;

    public GetAttribute(String s) {
        this.s = s;
    }

    public String execute(WebElement element) {
        return element.getAttribute(s);
    }
}
