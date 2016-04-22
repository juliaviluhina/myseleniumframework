package core.wrappers.element;

import core.WithWaitFor;
import core.commands.Command;
import core.conditions.ElementCondition;
import core.exceptions.ElementNotFoundException;
import core.wrappers.LazyCollection;
import core.wrappers.LazyElement;
import core.wrappers.collection.LazyElementInnerCollection;
import org.openqa.selenium.*;

import java.util.List;

import core.WaitFor;

import static core.ConciseAPI.actions;
import static core.ConciseAPI.byCSS;
import static core.conditions.ElementConditions.present;
import static core.conditions.ElementConditions.visible;


public abstract class AbstractLazyElement implements LazyElement {

    public abstract WebElement fetchWrappedEntity();

    public WebElement getWrappedEntity() {
        WebElement wrappedEntity = fetchWrappedEntity();
        if (wrappedEntity == null) {
            throw new ElementNotFoundException(toString());
        }
        return wrappedEntity;
    }

    public LazyElement find(By innerLocator) {
        return new LazyElementInnerElement(this, innerLocator);
    }

    public LazyElement find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public LazyCollection findAll(By innerLocator) {
        return new LazyElementInnerCollection(this, innerLocator);
    }

    public LazyCollection findAll(String cssSelector) {
        return findAll(byCSS(cssSelector));
    }

    public LazyElement should(ElementCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public LazyElement shouldBe(ElementCondition... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(ElementCondition... conditions) {
        return should(conditions);
    }

    public boolean is(ElementCondition condition) {
        try {
            return condition.check(getWrappedEntity());
        } catch (WebDriverException e) {
            return false;
        }
    }

    public boolean has(ElementCondition condition) {
        return is(condition);
    }

    public LazyElement setValue(final String text) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.clear();
                element.sendKeys(text);
                return element;
            }
        });
        return this;
    }

    public LazyElement pressEnter() {
        sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        sendKeys(Keys.ESCAPE);
        return this;
    }

    public void sendKeys(final CharSequence... charSequences) {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.sendKeys(charSequences);
                return element;
            }
        });
    }

    public LazyElement hover() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                actions().moveToElement(element).perform();
                return element;
            }
        });
        return this;
    }

    public LazyElement doubleClick() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                actions().doubleClick(element).perform();
                return element;
            }
        });
        return this;
    }

    public void clear() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.clear();
                return element;
            }
        });
    }

    public void click() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.click();
                return element;
            }
        });
    }


    public <X> X getScreenshotAs(final OutputType<X> outputType) throws WebDriverException {
        return new WithWaitFor(this, visible()).run(new Command<X>() {
            public X execute(WebElement element) {
                return element.getScreenshotAs(outputType);
            }
        });
    }

    public void submit() {
        new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                element.submit();
                return element;
            }
        });
    }

    public String getTagName() {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getTagName();
            }
        });
    }

    public String getAttribute(final String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getAttribute(s);
            }
        });
    }

    public boolean isSelected() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isSelected();
            }
        });
    }

    public boolean isEnabled() {
        return new WithWaitFor(this, visible()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isEnabled();
            }
        });
    }

    public String getText() {
        return new WithWaitFor(this, visible()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getText();
            }
        });
    }

    public List<WebElement> findElements(final By locator) {
        return new WithWaitFor(this, visible()).run(new Command<List<WebElement>>() {
            public List<WebElement> execute(WebElement element) {
                return element.findElements(locator);
            }
        });
    }

    public WebElement findElement(final By locator) {
        return new WithWaitFor(this, visible()).run(new Command<WebElement>() {
            public WebElement execute(WebElement element) {
                return element.findElement(locator);
            }
        });
    }

    public boolean isDisplayed() {
        return new WithWaitFor(this, present()).run(new Command<Boolean>() {
            public Boolean execute(WebElement element) {
                return element.isDisplayed();
            }
        });
    }

    public Point getLocation() {
        return new WithWaitFor(this, visible()).run(new Command<Point>() {
            public Point execute(WebElement element) {
                return element.getLocation();
            }
        });
    }

    public Dimension getSize() {
        return new WithWaitFor(this, visible()).run(new Command<Dimension>() {
            public Dimension execute(WebElement element) {
                return element.getSize();
            }
        });
    }

    public Rectangle getRect() {
        return new WithWaitFor(this, visible()).run(new Command<Rectangle>() {
            public Rectangle execute(WebElement element) {
                return element.getRect();
            }
        });
    }

    public String getCssValue(final String s) {
        return new WithWaitFor(this, present()).run(new Command<String>() {
            public String execute(WebElement element) {
                return element.getCssValue(s);
            }
        });
    }

}
