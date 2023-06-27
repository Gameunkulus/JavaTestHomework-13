import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void matchesTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertFalse(epic.matches("Зубная паста"));
        Assertions.assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        Assertions.assertTrue(meeting.matches("Приложение НетоБанка"));
        Assertions.assertFalse(meeting.matches("Выкатка 1й версии приложения"));
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));
        Assertions.assertFalse(simpleTask.matches("Позвонить адвокату"));
        Assertions.assertFalse(todos.matches("Сходить в магазин"));
        Assertions.assertFalse(todos.matches("Сходить в спортзал"));

    }

    @Test
    void getEpicTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String[] expectation = {"Молоко", "Яйца", "Хлеб"};
        Assertions.assertArrayEquals(expectation, epic.getSubtasks());
    }

    @Test
    void getSimpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String expectation = "Позвонить родителям";
        Assertions.assertEquals(expectation,simpleTask.title);
    }

    @Test
    void getMeetingTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        meeting.getStart();

        String expectation1 = "Выкатка 3й версии приложения";
        String expectation2 = "Приложение НетоБанка";
        String expectation3 = "Во вторник после обеда";
        Assertions.assertEquals(expectation1,meeting.getTopic());
        Assertions.assertEquals(expectation2,meeting.getProject());
        Assertions.assertEquals(expectation3,meeting.getStart());
    }
}
