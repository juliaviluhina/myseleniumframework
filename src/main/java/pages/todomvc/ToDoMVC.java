package pages.todomvc;

import core.wrappers.LazyCollection;
import core.wrappers.LazyElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static core.ConciseAPI.*;
import static core.conditions.CustomCollectionConditions.empty;
import static core.conditions.CustomCollectionConditions.exactTexts;
import static core.conditions.CustomElementConditions.*;
import static pages.todomvc.ToDoMVC.Task.Status;

public class ToDoMVC {
    public static LazyCollection tasks = $$("#todo-list li");

    public static LazyElement newTask = $("#new-todo");

    public static void add(String... taskTexts) {
        for (String text : taskTexts) {
            newTask.setValue(text).pressEnter();
        }
    }

    public static void assertItemsLeft(int number) {
        $("#todo-count>strong").shouldHave(exactText(Integer.toString(number)));
    }

    public static void сlearCompleted() {
        $("#clear-completed").click();
    }

    public static void toggle(String taskText) {
        tasks.find(exactText(taskText)).find(".toggle").click();
    }

    public static void toggleAll() {
        $("#toggle-all").click();
    }

    public static LazyElement startEditing(String oldText, String newText) {
        tasks.find(exactText(oldText)).find("label").doubleClick();
        return tasks.find(cssClass("editing")).find(".edit").setValue(newText);
    }

    public static void filterAll() {
        $(By.linkText("All")).click();
    }

    public static void filterActive() {
        $(By.linkText("Active")).click();
    }

    public static void filterCompleted() {
        $(By.linkText("Completed")).click();
    }

    public static void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().find(".destroy").click();
    }

    public static void assertTasks(String... taskTexts) {
        tasks.filter(visible()).shouldHave(exactTexts(taskTexts));
    }

    public static void assertNoTasks() {
        tasks.filter(visible()).shouldBe(empty());
    }


    /***********************************************************************
     * Task for Given
     */

    public static class Task {

        public enum Status {
            ACTIVE("false"), COMPLETED("true");

            private String mark;

            Status(String mark) {
                this.mark = mark;
            }

            public String getMark() {
                return mark;
            }
        }

        public String name;
        public Status status;

        Task(String name, Status status) {
            this.name = name;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public Status getStatus() {
            return status;
        }

        public static Task aTask(String name, Status status) {
            return new Task(name, status);
        }

    }

    /**************************************************************************************
     * GIVENs
     */

    public enum Filters {
        ALL("/"), ACTIVE("/active"), COMPLETED("/completed");

        private String Url2;

        Filters(String Url2) {
            this.Url2 = Url2;
        }

        public String getUrl() {
            return "https://todomvc4tasj.herokuapp.com/#" + Url2;
        }
    }

    public static void updateLocalStorage(Task... tasks) {
        executeJavaScript(script(tasks));
    }

    public static String script(Task... tasks) {
        String jsModel = "localStorage.setItem('todos-troopjs', '[%s]')";
        String taskModel = "{'completed':%s, 'title':'%s'}".replace("'", "\\\"");
        List<String> taskCatalog = new ArrayList<String>();
        for (Task task : tasks) {
            String taskObject = String.format(taskModel, task.getStatus().getMark(), task.getName());
            taskCatalog.add(taskObject);
        }
        String givenTasks = String.join(", ", taskCatalog);
        return String.format(jsModel, givenTasks);
    }

    private static void assertLocalStorageLoaded(Filters filter, Task... tasks) {
        List<String> visibleTasksList = new ArrayList<String>();
        for (Task task : tasks) {
            if (filter == Filters.ALL || filter.toString().equals(task.status.toString()))
                visibleTasksList.add(task.getName());
        }
        String[] visibleTasksTexts = visibleTasksList.toArray(new String[0]);

        assertTasks(visibleTasksTexts);
    }

    public static void given(Filters filter, Task... tasks) {
        if (!url().equals(filter.getUrl())) {
            open(filter.getUrl());
        }
        updateLocalStorage(tasks);
        executeJavaScript("location.reload()");
        assertLocalStorageLoaded(filter, tasks); // without this assert code is unstable (in Selenide project was the same)
    }

    public static void givenAtAll(Task... tasks) {
        given(Filters.ALL, tasks);
    }

    public static void givenAtActive(Task... tasks) {
        given(Filters.ACTIVE, tasks);
    }

    public static void givenAtCompleted(Task... tasks) {
        given(Filters.COMPLETED, tasks);
    }

    private static Task[] aTasks(Status status, String... names) {
        Task[] tasks = new Task[names.length];

        for (int k = 0; k < names.length; ++k) {
            tasks[k] = new Task(names[k], status);
        }
        return tasks;
    }

    public static void givenAtAll(Status status, String... tasks) {
        given(Filters.ALL, aTasks(status, tasks));
    }

    public static void givenAtActive(Status status, String... tasks) {
        given(Filters.ACTIVE, aTasks(status, tasks));
    }

    public static void givenAtCompleted(Task.Status status, String... tasks) {
        given(Filters.COMPLETED, aTasks(status, tasks));
    }

}