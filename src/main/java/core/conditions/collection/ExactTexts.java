package core.conditions.collection;


public class ExactTexts extends Texts {

    public ExactTexts(String... texts) {
        super(texts);
    }

    public boolean checkElement(int index) {
        return currentTexts.get(index).equals(texts[index]);
    }

}
