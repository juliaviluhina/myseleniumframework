package core.conditions;

import core.conditions.AbstractCondition;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract interface CollectionCondition extends Condition<List<WebElement>> {

}
