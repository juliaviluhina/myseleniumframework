package core.commands;

import org.openqa.selenium.*;

import java.util.List;

public class Commands {

    public static Command clear() {
        return new Clear();
    }

    public static Command click() {
        return new Click();
    }

    public static Command doubleClick() {
        return new DoubleClick();
    }

    public static Command hover() {
        return new Hover();
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
        return new Submit();
    }

    public static Command<String> getTagName() {
        return new GetTagName();
    }

    public static Command<String> getAttribute(String s) {
        return new GetAttribute(s);
    }

    public static Command<Boolean> isSelected() {
        return new IsSelected();
    }

    public static Command<Boolean> isEnabled() {
        return new IsEnabled();
    }

    public static Command<Boolean> isDisplayed() {
        return new IsDisplayed();
    }

    public static Command<String> getText() {
        return new GetText();
    }

    public static Command<List<WebElement>> findElements(By locator) {
        return new FindElements(locator);
    }

    public static Command<WebElement> findElement(By locator) {
        return new FindElement(locator);
    }

    public static Command<Point> getLocation() {
        return new GetLocation();
    }

    public static Command<Dimension> getSize() {
        return new GetSize();
    }

    public static Command<Rectangle> getRect() {
        return new GetRect();
    }

    public static Command<String> getCssValue(String s) {
        return new GetCssValue(s);
    }
}
