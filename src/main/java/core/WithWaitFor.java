package core;

import core.conditions.ElementCondition;
import core.wrappers.LazyElement;
import org.openqa.selenium.WebDriverException;

public class WithWaitFor {

    private LazyElement lazyElement;
    private ElementCondition waitCondition;

    public WithWaitFor(LazyElement lazyElement, ElementCondition waitCondition) {
        this.lazyElement = lazyElement;
        this.waitCondition = waitCondition;
    }

    public  <T> T run(Command<T> command) {
        try {
            return command.execute(lazyElement.getWrappedEntity());
        } catch (WebDriverException e) {
        }
        return command.execute(WaitFor.until(lazyElement, waitCondition));
    }

}
