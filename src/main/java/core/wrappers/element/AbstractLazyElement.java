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

    public LazyElement setValue(String text) {
        CommandRunner.forElement(this).withWaitFor(visible()).withParameters(text).run(Commands.setValue());
        return this;
    }

    public LazyElement pressEnter() {
        CommandRunner.forElement(this).withWaitFor(visible()).withParameters(Keys.ENTER).run(Commands.sendKeys());
        return this;
    }

    public LazyElement pressEscape() {
        CommandRunner.forElement(this).withWaitFor(visible()).withParameters(Keys.ESCAPE).run(Commands.sendKeys());
        return this;
    }

    public LazyElement hover() {
        CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.hover());
        return this;
    }

    public LazyElement doubleClick() {
        CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.doubleClick());
        return this;
    }

    public void clear() {
        CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.clear());
    }

    public void click() {
        CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.click());
    }


    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return (X) CommandRunner.forElement(this).withWaitFor(visible()).withParameters(outputType).run(Commands.getScreenshotAs());
    }

    public void submit() {
        CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.submit());
    }

    public void sendKeys(CharSequence... charSequences) {
        CommandRunner.forElement(this).withWaitFor(visible()).withParameters(charSequences).run(Commands.sendKeys());
    }

    public String getTagName() {
        return CommandRunner.forElement(this).withWaitFor(present()).run(Commands.getTagName());
    }

    public String getAttribute(String s) {
        return CommandRunner.forElement(this).withWaitFor(present()).withParameters(s).run(Commands.getAttribute());
    }

    public boolean isSelected() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.isSelected());
    }

    public boolean isEnabled() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.isEnabled());
    }

    public String getText() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.getText());
    }

    public List<WebElement> findElements(By locator) {
        return CommandRunner.forElement(this).withWaitFor(visible()).withParameters(locator).run(Commands.findElements());
    }

    public WebElement findElement(By locator) {
        return CommandRunner.forElement(this).withWaitFor(visible()).withParameters(locator).run(Commands.findElement());
    }

    public boolean isDisplayed() {
        return CommandRunner.forElement(this).withWaitFor(present()).run(Commands.isDisplayed());
    }

    public Point getLocation() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.getLocation());
    }

    public Dimension getSize() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.getSize());
    }

    public Rectangle getRect() {
        return CommandRunner.forElement(this).withWaitFor(visible()).run(Commands.getRect());
    }

    public String getCssValue(String s) {
        return CommandRunner.forElement(this).withWaitFor(present()).withParameters(s).run(Commands.getCssValue());
    }

}
