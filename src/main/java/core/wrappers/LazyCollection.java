package core.wrappers;

import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import core.wrappers.collection.LazyFilteredCollection;
import core.wrappers.element.LazyCollectionFoundByConditionElement;
import core.wrappers.element.LazyCollectionNthElement;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface LazyCollection extends LazyEntity<List<WebElement>>,Iterable<LazyElement> {

    LazyCollectionFoundByConditionElement find(ElementCondition condition);

    LazyFilteredCollection filter(ElementCondition condition);

    LazyCollectionNthElement get(int index);

    LazyCollection should(CollectionCondition... conditions);

    LazyCollection shouldBe(CollectionCondition... conditions);

    LazyCollection shouldHave(CollectionCondition... conditions);

    int size();

    boolean isEmpty();

}
