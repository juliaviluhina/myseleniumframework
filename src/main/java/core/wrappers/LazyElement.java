package core.wrappers;

import core.conditions.CustomElementCondition;
import org.openqa.selenium.*;

import java.util.List;

import static core.ConciseAPI.actions;
import static core.ConciseAPI.byCSS;
import static core.WaitFor.waitFor;
import static core.conditions.CustomElementConditions.present;
import static core.conditions.CustomElementConditions.visible;


public abstract class LazyElement implements LazyEntity, WebElement {

    public abstract WebElement getWrappedEntity();

    public LazyCollectionElementByInnerLocator find(By innerLocator) {
        return new LazyCollectionElementByInnerLocator(this, innerLocator);
    }

    public LazyCollectionElementByInnerLocator find(String cssSelector) {
        return find(byCSS(cssSelector));
    }

    public LazyElement setValue(String text) {
        waitFor(this, visible());

        getWrappedEntity().clear();
        getWrappedEntity().sendKeys(text);
        return this;
    }

    public LazyElement sendKeys(String text) {
        waitFor(this, visible());

        getWrappedEntity().sendKeys(text);
        return this;
    }

    public void clear() {
        waitFor(this, visible());

        getWrappedEntity().clear();
    }

    public void click() {
        waitFor(this, visible());

        getWrappedEntity().click();
    }

    public LazyElement pressEnter() {
        waitFor(this, visible());

        getWrappedEntity().sendKeys(Keys.ENTER);
        return this;
    }

    public LazyElement pressEscape() {
        waitFor(this, visible());

        getWrappedEntity().sendKeys(Keys.ESCAPE);
        return this;
    }

    public LazyElement hover() {
        waitFor(this, visible());

        actions().moveToElement(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement doubleClick() {
        waitFor(this, visible());

        actions().doubleClick(getWrappedEntity()).perform();
        return this;
    }

    public LazyElement should(CustomElementCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyElement shouldBe(CustomElementCondition... conditions) {
        return should(conditions);
    }

    public LazyElement shouldHave(CustomElementCondition conditions) {
        return should(conditions);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        waitFor(this, visible());

        return getWrappedEntity().getScreenshotAs(outputType);
    }

    public void submit() {
        waitFor(this, visible());

        getWrappedEntity().submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        waitFor(this, visible());

        getWrappedEntity().sendKeys();
    }

    public String getTagName() {
        waitFor(this, present());

        return getWrappedEntity().getTagName();
    }

    public String getAttribute(String s) {
        waitFor(this, present());

        return getWrappedEntity().getAttribute(s);
    }

    public boolean isSelected() {
        waitFor(this, visible());

        return getWrappedEntity().isSelected();
    }

    public boolean isEnabled() {
        waitFor(this, visible());

        return getWrappedEntity().isEnabled();
    }

    public String getText() {
        waitFor(this, visible());

        return getWrappedEntity().getText();
    }

    public List<WebElement> findElements(By by) {
        waitFor(this, visible());

        return getWrappedEntity().findElements(by);
    }

    public WebElement findElement(By by) {
        waitFor(this, visible());

        return getWrappedEntity().findElement(by);
    }

    public boolean isDisplayed() {
        waitFor(this, present());

        return getWrappedEntity().isDisplayed();
    }

    public Point getLocation() {
        waitFor(this, visible());

        return getWrappedEntity().getLocation();
    }

    public Dimension getSize() {
        waitFor(this, visible());

        return getWrappedEntity().getSize();
    }

    public Rectangle getRect() {
        waitFor(this, visible());

        return getWrappedEntity().getRect();
    }

    public String getCssValue(String s) {
        waitFor(this, present());

        return getWrappedEntity().getCssValue(s);
    }

}
