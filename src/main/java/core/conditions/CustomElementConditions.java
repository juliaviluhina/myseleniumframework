package core.conditions;

import core.conditions.element.CssClass;
import core.conditions.element.ElementVisible;
import core.conditions.element.ExactText;
import core.conditions.element.Text;

public class CustomElementConditions {
    public static CustomElementCondition text(final String text) {
        return new Text(text);
    }

    public static CustomElementCondition exactText(final String text) {
        return new ExactText(text);
    }

    public static CustomElementCondition cssClass(String cssClass) {
        return new CssClass(cssClass);
    }

    public static CustomElementCondition visible() {
        return new ElementVisible();
    }
}
