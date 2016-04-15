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
        return (condition.apply(this) != null);
    }

    public boolean has(ElementCondition condition) {
        return is(condition);
    }

    public LazyElement setValue(String text) {
        WebElement element = WaitFor.until(this, visible());

        element.clear();
        element.sendKeys(text);
        return this;
    }

    public LazyElement pressEnter() {
        WaitFor.until(this, visible()).sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        WaitFor.until(this, visible()).sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        actions().moveToElement(WaitFor.until(this, visible())).perform();
        return this;
    }

    public LazyElement doubleClick() {
        actions().doubleClick(WaitFor.until(this, visible())).perform();
        return this;
    }

    public void clear() {
        WaitFor.until(this, visible()).clear();
    }

    public void click() {
        WaitFor.until(this, visible()).click();
    }


    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
       return WaitFor.until(this, visible()).getScreenshotAs(outputType);
    }

    public void submit() {
        WaitFor.until(this, visible()).submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        getWrappedEntity().sendKeys(charSequences);
    }

    public String getTagName() {
        return WaitFor.until(this, present()).getTagName();
    }

    public String getAttribute(String s) {
        return WaitFor.until(this, present()).getAttribute(s);
    }

    public boolean isSelected() {
        return WaitFor.until(this, visible()).isSelected();
    }

    public boolean isEnabled() {
        return WaitFor.until(this, visible()).isEnabled();
    }

    public String getText() {
        return WaitFor.until(this, visible()).getText();
    }

    public List<WebElement> findElements(By by) {
        return WaitFor.until(this, visible()).findElements(by);
    }

    public WebElement findElement(By by) {
        return WaitFor.until(this, visible()).findElement(by);
    }

    public boolean isDisplayed() {
        return WaitFor.until(this, present()).isDisplayed();
    }

    public Point getLocation() {
        return  WaitFor.until(this, visible()).getLocation();
    }

    public Dimension getSize() {
        return WaitFor.until(this, visible()).getSize();
    }

    public Rectangle getRect() {
        return WaitFor.until(this, visible()).getRect();
    }

    public String getCssValue(String s) {
        return WaitFor.until(this, present()).getCssValue(s);
    }


}
