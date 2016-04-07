package core.wrappers.element;

import core.conditions.ElementCondition;
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

    public abstract WebElement getWrappedEntity();

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

    public LazyElement setValue(String text) {
        WaitFor.until(this, visible());

        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement sendKeys(String text) {
        WaitFor.until(this, visible());

        getWrappedEntity().sendKeys(text);
        return this;
    }

    public void clear() {
        WaitFor.until(this, visible());

        getWrappedEntity().clear();
    }

    public void click() {
        WaitFor.until(this, visible());

        getWrappedEntity().click();
    }

    public LazyElement pressEnter() {
        WaitFor.until(this, visible());

        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        WaitFor.until(this, visible());

        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        WaitFor.until(this, visible());

        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        WaitFor.until(this, visible());

        actions().doubleClick(getWrappedEntity()).perform();
        return this;
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
        return (condition.apply(this) != null);
    }

    public boolean has(ElementCondition condition) {
        return is(condition);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        WaitFor.until(this, visible());

        return getWrappedEntity().getScreenshotAs(outputType);
    }

    public void submit() {
        WaitFor.until(this, visible());

        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        WaitFor.until(this, visible());

        getWrappedEntity().sendKeys();
    }

    public String getTagName() {
        WaitFor.until(this, present());

        return getWrappedEntity().getTagName();
    }

    public String getAttribute(String s) {
        WaitFor.until(this, present());

        return getWrappedEntity().getAttribute(s);
    }

    public boolean isSelected() {
        WaitFor.until(this, visible());

        return getWrappedEntity().isSelected();
    }

    public boolean isEnabled() {
        WaitFor.until(this, visible());

        return getWrappedEntity().isEnabled();
    }

    public String getText() {
        WaitFor.until(this, visible());

        return getWrappedEntity().getText();
    }

    public List<WebElement> findElements(By by) {
        WaitFor.until(this, visible());

        return getWrappedEntity().findElements(by);
    }

    public WebElement findElement(By by) {
        WaitFor.until(this, visible());

        return getWrappedEntity().findElement(by);
    }

    public boolean isDisplayed() {
        WaitFor.until(this, present());

        return getWrappedEntity().isDisplayed();
    }

    public Point getLocation() {
        WaitFor.until(this, visible());

        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        WaitFor.until(this, visible());

        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        WaitFor.until(this, visible());

        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        WaitFor.until(this, present());

        return getWrappedEntity().getCssValue(s);
    }

}
