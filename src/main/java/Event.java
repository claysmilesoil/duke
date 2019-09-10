import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents an Event object as a Task.
 */
public class Event extends Task {
    /**
     * The date of the event.
     */
    protected Date date;

    /**
     * The date of the event in String type, used for writing to file.
     */
    protected String dateBackup;

    /**
     * Instantiates an Event object, with a description and date.
     *
     * @param description the description of the event
     * @param date the date of the event in the format "dd/MM/yyyy HHmm"
     * @throws ParseException thrown when the format of date from user input is not recognized
     */
    public Event(String description, String date) throws ParseException {
        super(description);
        this.dateBackup = date;
        this.date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(date);
    }

    /**
     * Overwrites the Task method toString to print an Event object with "[E]" followed by Task object followed by date.
     * @return String of type of task, statusIcon, description and date
     */
    @Override
    public String toString() {
        return ("[E]" + super.toString() + " (at: " + date + ")");
    }

    /**
     * Adds an event to the task list.
     * Prints a message when the date or description is missing or invalid.
     *
     * @param input the user input string containing "event" followed by a description of the event followed by "/at" and the date
     */
    public static void addEvent(String input) {
        int dateIdx = input.indexOf("/at");
        try {
            if (dateIdx == - 1) {
                System.out.println("Specify a date or time using the keyword /at.");
            } else if (input.substring(5,dateIdx).isBlank()) {
                System.out.println("Uh, the description of an event cannot be empty.");
            }
            else {
                try {
                    Task.itemList.add(new Event(input.substring(6, dateIdx).trim(), input.substring(dateIdx + 4).trim()));
                    addTask();
                } catch (ParseException e) {
                    System.out.println("Date and time format is invalid. (valid: dd/MM/yyyy HHmm)");
                }
            }
        } catch(StringIndexOutOfBoundsException e){
            System.out.println("Specify a date or time after the keyword /at.");
        }
    }
}
