package myframework;


import core.wrappers.LazyElement;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testconfig.BaseTest;

import static core.ConciseAPI.$;
import static core.conditions.CollectionConditions.exactTexts;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.exactText;
import static core.conditions.ElementConditions.text;
import static core.conditions.ElementConditions.visible;
import static pages.todomvc.ToDoMVC.Task.Status.ACTIVE;
import static pages.todomvc.ToDoMVC.assertTasks;
import static pages.todomvc.ToDoMVC.givenAtAll;
import static pages.todomvc.ToDoMVC.*;


public class MyFrameWorkTest extends BaseTest {

    @Test
    public void testChainableCalls() {
        givenAtAll(ACTIVE, "аb", "ааb", "ac", "bc");

//        System.out.println(Arrays.toString(tasks.filter(visible()).getTexts()));
//        System.out.println(Arrays.toString(tasks.filter(visible()).filter(text("а")).getTexts()));
//        System.out.println(Arrays.toString(tasks.filter(visible()).filter(text("а")).filter(text("b")).getTexts()));

        tasks.filter(visible()).filter(text("а")).filter(text("b")).shouldHave(size(2));
    }

    @Test
    public void testGetInCollection() {
        givenAtAll(ACTIVE, "аb", "ааb", "ac", "bc");

        tasks.get(0).shouldHave(exactText("аb"));

        tasks.get(4).shouldHave(exactText("аb"));
    }


    @Test
    public void testIterator() {
        givenAtAll(ACTIVE, "аb", "ааb", "ac", "bc");

        for (LazyElement element:tasks) {
            System.out.println(element.getText());
        }
    }

    @Test
    public void testTypeCasting() {
        givenAtAll(ACTIVE, "аb", "ааb", "ac", "bc");

        ((WebElement) $("#new-todo")).sendKeys("kuku"+ Keys.ENTER);

        assertTasks("аb", "ааb", "ac", "bc", "kuku");

    }

    @Test
    public void test1() {
        givenAtAll(ACTIVE, "аb");

        tasks.shouldHave(exactTexts("аb"));

        //assertTasks("ab");
        LazyElement task = tasks.find(exactText("ab"));
        LazyElement tasklabel = task.find("label");
        task.doubleClick();
        task.click();
        tasklabel.doubleClick();

    }

}
