package core.commands;

import org.openqa.selenium.WebElement;

public class SendKeys implements Command<WebElement>  {

    private CharSequence[] charSequences;

    public SendKeys(CharSequence... charSequences) {
        this.charSequences = charSequences.clone();
    }

    public WebElement execute(WebElement element) {
        element.sendKeys(charSequences);
        return element;
    }
}
