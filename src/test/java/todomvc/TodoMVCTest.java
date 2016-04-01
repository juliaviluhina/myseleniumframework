package todomvc;

import org.junit.Test;
import testconfig.BaseTest;

import static core.conditions.CustomCollectionConditions.size;
import static core.conditions.CustomElementConditions.text;
import static core.conditions.CustomElementConditions.visible;
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
        givenAtAll(ACTIVE, "ab", "b");

        tasks.filter(visible()).filter(text("a")).filter(text("b")).shouldHave(size(2));
    }

}
