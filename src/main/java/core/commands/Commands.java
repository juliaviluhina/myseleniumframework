package core.commands;

import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;

public class Commands {

    public static Command clear() {
        return new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        };
    }

    public static Command click() {
        return new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        };
    }

    public static Command doubleClick() {
        return new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        };
    }

    public static Command hover() {
        return new  Command<WebElement>()  {
            public WebElement execute(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        };
    }

    public static Command sendKeys(CharSequence... charSequences) {
        return new SendKeys(charSequences);
    }

    public static Command setValue(String text) {
        return new SetValue(text);
    }

    public static <X> Command<X> getScreenshotAs(OutputType<X> outputType) {
        return new GetScreenshotAs(outputType);
    }

    public static Command submit() {
        return new Command<WebElement>()  {
            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        };
    }

    public static Command<String> getTagName() {
        return new Command<String>()  {
            public String execute(WebElement element) {
                return element.getTagName();
            }
        };
    }

    public static Command<String> getAttribute(String s) {
        return new GetAttribute(s);
    }

    public static Command<Boolean> isSelected() {
        return new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        };
    }

    public static Command<Boolean> isEnabled() {
        return new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        };
    }

    public static Command<Boolean> isDisplayed() {
        return new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        };
    }

    public static Command<String> getText() {
        return new Command<String>()  {
            public String execute(WebElement element) {
                return element.getText();
            }
        };
    }

    public static Command<List<WebElement>> findElements(By locator) {
        return new FindElements(locator);
    }

    public static Command<WebElement> findElement(By locator) {
        return new FindElement(locator);
    }

    public static Command<Point> getLocation() {
        return new Command<Point>() {
            public Point execute(WebElement element) {
                return element.getLocation();
            }
        };
    }

    public static Command<Dimension> getSize() {
        return new Command<Dimension>() {
            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        };
    }

    public static Command<Rectangle> getRect() {
        return new Command<Rectangle>() {
            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        };
    }

    public static Command<String> getCssValue(String s) {
        return new GetCssValue(s);
    }
}
