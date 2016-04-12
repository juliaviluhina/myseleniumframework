package todomvc;

import core.wrappers.LazyElement;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testconfig.BaseTest;

import static core.ConciseAPI.*;
import static core.conditions.CollectionConditions.size;
import static core.conditions.ElementConditions.text;
import static core.conditions.ElementConditions.visible;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static pages.todomvc.ToDoMVC.Task.Status;
import static pages.todomvc.ToDoMVC.Task.Status.ACTIVE;
import static pages.todomvc.ToDoMVC.Task.Status.COMPLETED;
import static pages.todomvc.ToDoMVC.Task.aTask;
import static pages.todomvc.ToDoMVC.*;


public class TodoMVCTest extends BaseTest {

    @Test
    public void testTasksCommonFlow() {
        givenAtAll();

        add("a");
        assertTasks("a");
        assertItemsLeft(1);
        toggleAll();

        filterActive();
        assertNoTasks();

        filterCompleted();
        assertTasks("a");

        //activate task
        toggle("a");
        assertNoTasks();
        assertItemsLeft(1);

        filterAll();
        assertTasks("a");

        filterCompleted();
        assertNoTasks();

        filterActive();
        assertTasks("a");

        filterAll();
        delete("a");
        assertNoTasks();
    }

    @Test
    public void testCancelEditAtActive() {
        givenAtActive(Status.ACTIVE, "a", "b");

        startEditing("b", "b edited").pressEscape();
        assertTasks("a", "b");
        assertItemsLeft(2);
    }

    @Test
    public void testActivateAllAtCompleted() {
        givenAtCompleted(aTask("a", COMPLETED), aTask("b", COMPLETED));

        toggleAll();
        assertNoTasks();
        assertItemsLeft(2);
    }

    @Test
    public void testConfirmEditByClickOutsideAtAll() {
        givenAtAll(ACTIVE, "a", "b");

        startEditing("b", "b edited");
        newTask.click();

        assertTasks("a", "b edited");
        assertItemsLeft(2);
    }

    @Test
    public void test1() {
        givenAtAll(ACTIVE, "аb", "ааb", "ac", "bc");
        //assertTasks("аb", "ааb", "ac", "bc");

//        System.out.println(Arrays.toString(tasks.filter(visible()).getTexts()));
//        System.out.println(Arrays.toString(tasks.filter(visible()).filter(text("а")).getTexts()));
//        System.out.println(Arrays.toString(tasks.filter(visible()).filter(text("а")).filter(text("b")).getTexts()));

        tasks.filter(visible()).filter(text("а")).filter(text("b")).shouldHave(size(2));

        for (LazyElement element:tasks) {
            System.out.println(element.getText());
        }
        ((WebElement) $("#new-todo")).sendKeys("kuku"+ Keys.ENTER);
        assertTasks("аb", "ааb", "ac", "bc", "kuku");

    }



}
