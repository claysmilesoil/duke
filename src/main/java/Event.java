import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Event extends Task {
    protected Date date;
    protected String dateBackup;
    public Event(String description, String date) {
        super(description);
        this.dateBackup = date;
        try {
            this.date = new SimpleDateFormat("dd/MM/yyyy kkmm").parse(date);
        } catch (ParseException e) {
            System.out.println("Date or time format is invalid.");
        }
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
