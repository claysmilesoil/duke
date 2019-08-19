public class Task {
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
        this.isDone = false;
    }

    public String statusIcon() {
        return (isDone ? "[\u2713] " : "[\u2718] " ); // check mark or x
    }

    public void markAsDone() {
        isDone = true;
    }
}
