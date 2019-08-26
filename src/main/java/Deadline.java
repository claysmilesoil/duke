public class Deadline extends Task{
    protected String date;
    public Deadline(String description, String date) {
        super(description);
        this.date = date;
    }
    @Override
    public String toString() {
        return ("[D]" + super.toString() + " (by: " + date + ")");
    }

    public static void addDeadline(String input) {
        int dateIdx = input.indexOf("/by");
        try {
            if (dateIdx == -1) {
                System.out.println("Specify a date or time using the keyword /by.");
            } else if (input.substring(8,dateIdx).isBlank()) {
                    System.out.println("Uh, the description of a deadline cannot be empty.");
            } else {
                    Task.itemList[Task.numberOfTasks] = new Deadline(input.substring(9, dateIdx).trim(), input.substring(dateIdx + 4).trim());
                    addTask();
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Specify a date or time after the keyword /by.");
        }
    }
}
