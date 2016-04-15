package core.exceptions;

import org.openqa.selenium.WebDriverException;

public class ElementNotFoundInListException extends WebDriverException {
    public ElementNotFoundInListException(String text) {
        super(text);
    }
}