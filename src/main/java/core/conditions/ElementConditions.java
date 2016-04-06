package core.conditions;

import core.conditions.element.*;

public class ElementConditions {
    public static ElementCondition text(final String text) {
        return new Text(text);
    }

    public static ElementCondition exactText(final String text) {
        return new ExactText(text);
    }

    public static ElementCondition cssClass(String cssClass) {
        return new CssClass(cssClass);
    }

    public static ElementCondition visible() {
        return new Visible();
    }

    public static ElementCondition present() {
        return new Present();
    }
}
