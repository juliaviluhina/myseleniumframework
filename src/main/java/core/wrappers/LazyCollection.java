package core.wrappers;

import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>,Iterable<LazyElement> {

    LazyElement find(ElementCondition condition);

    LazyCollection filter(ElementCondition condition);

    LazyElement get(int index);

    LazyCollection should(CollectionCondition... conditions);

    LazyCollection shouldBe(CollectionCondition... conditions);

    LazyCollection shouldHave(CollectionCondition... conditions);

    int size();

    boolean isEmpty();

    String[] getTexts();

}
