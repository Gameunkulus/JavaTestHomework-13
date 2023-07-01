public class Epic extends Task {
    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public String getSubtask(int i) {
        return subtasks[i];
    }

    @Override
    public boolean matches(String query) {
        for (int i = 0; i < subtasks.length; i++) {
            if (getSubtask(i).contains(query)) {
                return true;
            }
        }
        return super.matches(query);
    }


}
