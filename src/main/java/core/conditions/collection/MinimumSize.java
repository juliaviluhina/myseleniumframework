package core.conditions.collection;

public class MinimumSize extends Size {

    public MinimumSize(int expectedSize) {
        super(expectedSize);
    }

    protected boolean checkList() {
        return listSize >= expectedSize;
    }

}
