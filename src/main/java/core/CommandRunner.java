package core;

import core.commands.Command;
import core.conditions.ElementCondition;
import core.wrappers.LazyElement;
import org.openqa.selenium.WebDriverException;

public class CommandRunner {

    public static <T> T run(LazyElement lazyElement, Command<T> command, ElementCondition waitCondition) {
        try {
            return command.execute(lazyElement.getWrappedEntity());
        } catch (WebDriverException e) {
        }
        return command.execute(WaitFor.until(lazyElement, waitCondition));
    }

}
