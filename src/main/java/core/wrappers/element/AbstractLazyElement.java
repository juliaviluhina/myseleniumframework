package core.wrappers.element;

import core.CommandRunner;
import core.commands.Commands;
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
import static core.conditions.ElementConditions.enabled;
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
            condition.apply(this);
        } catch (WebDriverException e) {
            return false;
        }
        return true;

    }

    public boolean has(ElementCondition condition) {
        return is(condition);
    }

    public LazyElement setValue(String text) {
//        WebElement element = WaitFor.until(this, visible());
//
//        element.clear();
//        element.sendKeys(text);
        CommandRunner.run(this, Commands.setValue(text), visible());
        return this;
    }

    public LazyElement pressEnter() {
        //WaitFor.until(this, visible()).sendKeys(Keys.ENTER);
        CommandRunner.run(this, Commands.sendKeys(Keys.ENTER), visible());
        return this;
    }

    public LazyElement pressEscape() {
        //WaitFor.until(this, visible()).sendKeys(Keys.ESCAPE);
        CommandRunner.run(this, Commands.sendKeys(Keys.ESCAPE), visible());
        return this;
    }

    public LazyElement hover() {
        //actions().moveToElement(WaitFor.until(this, visible())).perform();
        CommandRunner.run(this, Commands.hover(), visible());
        return this;
    }

    public LazyElement doubleClick() {
        //actions().doubleClick(WaitFor.until(this, visible())).perform();
        CommandRunner.run(this, Commands.doubleClick(), visible());
        return this;
    }

    public void clear() {
        //WaitFor.until(this, visible()).clear();
        CommandRunner.run(this, Commands.clear(), visible());
    }

    public void click() {
        //WaitFor.until(this, visible()).click();
        CommandRunner.run(this, Commands.click(), visible());
    }


    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        //return WaitFor.until(this, visible()).getScreenshotAs(outputType);
        return CommandRunner.run(this, Commands.getScreenshotAs(outputType), visible());
    }

    public void submit() {
        //WaitFor.until(this, visible()).submit();
        CommandRunner.run(this, Commands.submit(), visible());
    }

    public void sendKeys(CharSequence... charSequences) {
        //WaitFor.until(this, visible()).sendKeys(charSequences);
        CommandRunner.run(this, Commands.sendKeys(charSequences), visible());
    }

    public String getTagName() {
        //return WaitFor.until(this, present()).getTagName();
        return CommandRunner.run(this, Commands.getTagName(), present());
    }

    public String getAttribute(String s) {
        //return WaitFor.until(this, present()).getAttribute(s);
        return CommandRunner.run(this, Commands.getAttribute(s), present());
    }

    public boolean isSelected() {
        //return WaitFor.until(this, visible()).isSelected();
        return CommandRunner.run(this, Commands.isSelected(), visible());
    }

    public boolean isEnabled() {
        //return WaitFor.until(this, visible()).isEnabled();
        return CommandRunner.run(this, Commands.isEnabled(), visible());
    }

    public String getText() {
        //return WaitFor.until(this, visible()).getText();
        return CommandRunner.run(this, Commands.getText(), visible());
    }

    public List<WebElement> findElements(By locator) {
        //return WaitFor.until(this, visible()).findElements(by);
        return CommandRunner.run(this, Commands.findElements(locator), visible());
    }

    public WebElement findElement(By locator) {
        //return WaitFor.until(this, visible()).findElement(by);
        return CommandRunner.run(this, Commands.findElement(locator), visible());
    }

    public boolean isDisplayed() {
        //return WaitFor.until(this, present()).isDisplayed();
        return CommandRunner.run(this, Commands.isDisplayed(), visible());
    }

    public Point getLocation() {
        //return WaitFor.until(this, visible()).getLocation();
        return CommandRunner.run(this, Commands.getLocation(), visible());
    }

    public Dimension getSize() {
        //return WaitFor.until(this, visible()).getSize();
        return CommandRunner.run(this, Commands.getSize(), visible());
    }

    public Rectangle getRect() {
        //return WaitFor.until(this, visible()).getRect();
        return CommandRunner.run(this, Commands.getRect(), visible());
    }

    public String getCssValue(String s) {
        //return WaitFor.until(this, present()).getCssValue(s);
        return CommandRunner.run(this, Commands.getCssValue(s), visible());
    }

}
