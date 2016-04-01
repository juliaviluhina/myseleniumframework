package core.conditions.element;

public class ExactText extends Text {

    public ExactText(String text) {
        super(text);
    }

    public String toString() {
        return String.format("text equals: %s", text);
    }

    protected boolean check() {
        return currentText.equals(text);
    }
}
