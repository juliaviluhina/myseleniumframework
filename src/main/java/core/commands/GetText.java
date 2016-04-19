package core.commands;


import org.openqa.selenium.WebElement;

public class GetText implements Command<String>  {

    public String execute(WebElement element) {
        return element.getText();
    }

}