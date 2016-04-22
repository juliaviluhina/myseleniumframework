package core.commands;

import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;

public class Commands {

    public static Command clear() {
        return new Command<WebElement>() {
            public void setParameters(Object... parameters) {
            }

            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        };
    }

    public static Command click() {
        return new Command<WebElement>() {
            public void setParameters(Object... parameters) {
            }

            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        };
    }

    public static Command doubleClick() {
        return new Command<WebElement>() {
            public void setParameters(Object... parameters) {
            }

            public WebElement execute(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        };
    }

    public static Command hover() {
        return new Command<WebElement>() {
            public void setParameters(Object... parameters) {
            }

            public WebElement execute(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        };
    }

    public static Command sendKeys() {
        return new Command<WebElement>() {

            private String keys;

            public void setParameters(Object... parameters) {
                keys =  "" + parameters[0];
            }

            public WebElement execute(WebElement element) {
                element.sendKeys(keys);
                return element;
            }
        };
    }

    public static Command setValue() {
        return new Command<WebElement>() {

            private String text;

            public void setParameters(Object... parameters) {
                text = (String) parameters[0];
            }

            public WebElement execute(WebElement element) {
                element.clear();
                element.sendKeys(text);
                return element;
            }
        };
    }

    public static <X> Command<X> getScreenshotAs() {
        return new Command<X>() {
            OutputType<X> outputType;

            public void setParameters(Object... parameters) {
                outputType = (OutputType<X>) parameters[0];
            }

            public X execute(WebElement element) {
                return element.getScreenshotAs(outputType);
            }
        };
    }

    public static Command submit() {
        return new Command<WebElement>() {
            public void setParameters(Object... parameters) {
            }

            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        };
    }

    public static Command<String> getTagName() {
        return new Command<String>() {
            public void setParameters(Object... parameters) {
            }

            public String execute(WebElement element) {
                return element.getTagName();
            }
        };
    }

    public static Command<String> getAttribute() {
        return new Command<String>() {
            String s;

            public void setParameters(Object... parameters) {
                s = (String) parameters[0];
            }

            public String execute(WebElement element) {
                return element.getAttribute(s);
            }
        };
    }

    public static Command<Boolean> isSelected() {
        return new Command<Boolean>() {
            public void setParameters(Object... parameters) {
            }

            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        };
    }

    public static Command<Boolean> isEnabled() {
        return new Command<Boolean>() {
            public void setParameters(Object... parameters) {
            }

            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        };
    }

    public static Command<Boolean> isDisplayed() {
        return new Command<Boolean>() {
            public void setParameters(Object... parameters) {
            }

            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        };
    }

    public static Command<String> getText() {
        return new Command<String>() {
            public void setParameters(Object... parameters) {
            }

            public String execute(WebElement element) {
                return element.getText();
            }
        };
    }

    public static Command<List<WebElement>> findElements() {
        return new Command<List<WebElement>>() {

            By locator;

            public void setParameters(Object... parameters) {
                locator = (By) parameters[0];
            }

            public List<WebElement> execute(WebElement element) {
                return element.findElements(locator);
            }

        };
    }

    public static Command<WebElement> findElement() {
        return new Command<WebElement>() {

            By locator;

            public void setParameters(Object... parameters) {
                locator = (By) parameters[0];
            }

            public WebElement execute(WebElement element) {
                return element.findElement(locator);
            }

        };
    }

    public static Command<Point> getLocation() {
        return new Command<Point>() {
            public void setParameters(Object... parameters) {
            }

            public Point execute(WebElement element) {
                return element.getLocation();
            }
        };
    }

    public static Command<Dimension> getSize() {
        return new Command<Dimension>() {
            public void setParameters(Object... parameters) {
            }

            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        };
    }

    public static Command<Rectangle> getRect() {
        return new Command<Rectangle>() {
            public void setParameters(Object... parameters) {
            }

            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        };
    }

    public static Command<String> getCssValue() {
        return new Command<String>() {
            private String s;

            public void setParameters(Object... parameters) {
                s = (String) parameters[0];
            }

            public String execute(WebElement element) {
                return element.getCssValue(s);
            }
        };
    }
}
