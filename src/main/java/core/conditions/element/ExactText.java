package core.conditions.element;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    protected boolean check() {
        return currentText.equals(text);
    }
}
