package core.conditions.collection;

import java.util.Arrays;

public class ExactTexts extends Texts {

    public ExactTexts(String... texts) {
        super(texts);
    }

    public String toString() {
        return String.format("Texts equal: %s\n", Arrays.toString(texts));
    }

    protected boolean checkElement(int index) {
        return currentTexts.get(index).equals(texts[index]);
    }

}
