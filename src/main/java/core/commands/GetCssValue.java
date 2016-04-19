package core.commands;

import org.openqa.selenium.WebElement;

public class GetCssValue implements Command<String> {
    private String s;

    public GetCssValue(String s) {
        this.s = s;
    }

    @Override
    public String execute(WebElement element) {
        return element.getCssValue(s);
    }
}
