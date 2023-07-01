public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    @Override
    public boolean matches(String query) {
        if (getTitle().contains(query)) {
            return true;
        }
        return super.matches(query);
    }

    public String getTitle() {
        return title;
    }
}
