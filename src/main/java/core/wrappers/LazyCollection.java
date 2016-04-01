package core.wrappers;

import core.conditions.CustomCollectionCondition;
import core.conditions.CustomElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static core.ConciseAPI.getDriver;
import static core.ConditionWaiter.waitFor;
import static core.conditions.CustomCollectionConditions.minimumSize;

public class LazyCollection implements LazyEntity, List<WebElement> {

    protected By locator;

    public LazyCollection(By locator) {
        this.locator = locator;
    }

    protected LazyCollection() {
    }

    public String toString() {
        return locator.toString();
    }

    public List<WebElement> getWrappedEntity() {
        return getDriver().findElements(locator);
    }

    public LazyCollectionElementByCondition find(CustomElementCondition condition) {
        return new LazyCollectionElementByCondition(this, condition);
    }

    public LazyFilteredCollection filter(CustomElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyCollectionElementByIndex get(int index) {
        waitFor(this, minimumSize(index + 1));
        return new LazyCollectionElementByIndex(this, index);
    }

    public LazyCollection should(CustomCollectionCondition... conditions) {
        waitFor(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CustomCollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CustomCollectionCondition... conditions) {
        return should(conditions);
    }


    public int size() {
        return getWrappedEntity().size();
    }

    public boolean isEmpty() {
        return getWrappedEntity().isEmpty();
    }

    public boolean contains(Object o) {
        return getWrappedEntity().contains(o);
    }

    public Iterator<WebElement> iterator() {
        return getWrappedEntity().iterator();
    }

    public Object[] toArray() {
        return getWrappedEntity().toArray();
    }

    public <T> T[] toArray(T[] a) {
        return getWrappedEntity().toArray(a);
    }

    public boolean add(WebElement element) {
        return getWrappedEntity().add(element);
    }

    public boolean remove(Object o) {
        return getWrappedEntity().remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return getWrappedEntity().containsAll(c);
    }

    public boolean addAll(Collection<? extends WebElement> c) {
        return getWrappedEntity().addAll(c);
    }

    public boolean addAll(int index, Collection<? extends WebElement> c) {
        return getWrappedEntity().addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return getWrappedEntity().removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return getWrappedEntity().retainAll(c);
    }

    public void clear() {
        getWrappedEntity().clear();
    }

    public WebElement set(int index, WebElement element) {
        return getWrappedEntity().set(index, element);
    }

    public void add(int index, WebElement element) {
        getWrappedEntity().add(index, element);
    }

    public WebElement remove(int index) {
        return getWrappedEntity().remove(index);
    }

    public int indexOf(Object o) {
        return getWrappedEntity().indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return getWrappedEntity().lastIndexOf(o);
    }

    public ListIterator<WebElement> listIterator() {
        return getWrappedEntity().listIterator();
    }

    public ListIterator<WebElement> listIterator(int index) {
        return getWrappedEntity().listIterator(index);
    }

    public List<WebElement> subList(int fromIndex, int toIndex) {
        return getWrappedEntity().subList(fromIndex, toIndex);
    }

}


