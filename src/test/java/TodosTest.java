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
        Assertions.assertEquals(expectation, simpleTask.title);
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
        Assertions.assertEquals(expectation1, meeting.getTopic());
        Assertions.assertEquals(expectation2, meeting.getProject());
        Assertions.assertEquals(expectation3, meeting.getStart());
    }


    @Test
    void searchTest() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(6, "Позвонить девушке");
        SimpleTask simpleTask3 = new SimpleTask(7, "Позвонить другу");


        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(epic);
        todos.add(meeting);

        Task[] expectation1 = {
                simpleTask1, simpleTask2, simpleTask3
        };

        Task expectation2[] = {meeting};

        Task expectation3[] = new Task[0];
        Assertions.assertArrayEquals(expectation1, todos.search("Позвонить"));
        Assertions.assertArrayEquals(expectation2, todos.search("Приложение НетоБанка"));
        Assertions.assertArrayEquals(expectation3, todos.search("Зубная паста"));
    }
}
