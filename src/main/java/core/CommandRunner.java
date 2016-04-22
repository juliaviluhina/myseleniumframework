package core;

import core.commands.Command;
import core.conditions.ElementCondition;
import core.wrappers.LazyElement;
import org.openqa.selenium.WebDriverException;

public class CommandRunner<T> {

    public static Builder forElement(LazyElement lazyElement) {
        return new Builder(lazyElement);
    }

    public static class Builder {
        private ElementCondition waitCondition;
        private LazyElement lazyElement;
        private Object[] parameters;

        private Builder(LazyElement lazyElement) {
            this.lazyElement = lazyElement;
        }

        public Builder withWaitFor(ElementCondition waitCondition) {
            this.waitCondition = waitCondition;
            return this;
        }

        public Builder withParameters(Object... parameters) {
            this.parameters = parameters.clone();
            return this;
        }

        public <T> T run(Command<T> command) {
            return new CommandRunner<T>(this).runWithWaitCondition(command);
        }

    }

    private ElementCondition waitCondition;
    private LazyElement lazyElement;
    private Object[] parameters;

    private CommandRunner(Builder builder) {
        this.waitCondition = builder.waitCondition;
        this.lazyElement = builder.lazyElement;
        this.parameters = builder.parameters;
    }

    private T runWithWaitCondition(Command<T> command) {
        try {
            command.setParameters(parameters);
            return command.execute(lazyElement.getWrappedEntity());
        } catch (WebDriverException e) {
        }
        return command.execute(WaitFor.until(lazyElement, waitCondition));
    }

}
