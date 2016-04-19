package core.commands;

import core.wrappers.LazyElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

public class GetScreenshotAs<X> implements Command<X> {
    OutputType<X> outputType;

    public GetScreenshotAs(OutputType<X> outputType) {
        this.outputType = outputType;
    }

    public X execute(WebElement element) {
        return element.getScreenshotAs(outputType);
    }
}