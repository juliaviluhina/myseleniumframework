package core.conditions;

import core.conditions.collection.*;

public class CustomCollectionConditions {
    public static CustomCollectionCondition texts(final String... texts) {
        return new Texts(texts);
    }

    public static CustomCollectionCondition exactTexts(final String... texts) {
        return new ExactTexts(texts);
    }

    public static CustomCollectionCondition listNthElementHasText(
            final int index, final String text) {
        return new ListNthElementHasText(index, text);
    }

    public static CustomCollectionCondition size(final int expectedSize) {
        return new Size(expectedSize);
    }

    public static CustomCollectionCondition minimumSize(final int minimumSize) {
        return new MinimumSize(minimumSize);
    }

    public static CustomCollectionCondition empty() {
        return new Size(0);
    }

}
