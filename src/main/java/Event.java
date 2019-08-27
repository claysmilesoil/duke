public class Event extends Task {
    protected String date;
    public Event(String description, String date) {
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return ("[E]" + super.toString() + " (at: " + date + ")");
    }

    public static void addEvent(String input) {
        int dateIdx = input.indexOf("/at");
        try {
            if (dateIdx == - 1) {
                System.out.println("Specify a date or time using the keyword /at.");
            } else if (input.substring(5,dateIdx).isBlank()) {
                System.out.println("Uh, the description of an event cannot be empty.");
            }
            else {
                Task.itemList[Task.numberOfTasks] = new Event(input.substring(6, dateIdx).trim(), input.substring(dateIdx + 4).trim());
                addTask();
            }
        } catch(StringIndexOutOfBoundsException e){
            System.out.println("Specify a date or time after the keyword /at.");
        }
    }
}
