import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Represents a Deadline object as a Task.
 */
public class Deadline extends Task{
    /**
     * The date of the deadline.
     */
    protected Date date;

    /**
     * The date of the deadline in String type, used for writing to file.
     */
    protected String dateBackup;

    /**
     * Instantiates a Deadline object with a description and a date.
     * @param description the description of the deadline task
     * @param date the date of the deadline in the format "dd/MM/yyyy HHmm"
     * @throws ParseException thrown when the format of date from user input is not recognized
     */
    public Deadline(String description, String date) throws ParseException {
        super(description);
        this.dateBackup = date;
        this.date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(date);
    }

    /**
     * Overwrites the Task method toString to print a Deadline object with "[D]" followed by Task object followed by date.
     * @return String of type of task, statusIcon, description and date
     */
    @Override
    public String toString() {
        return ("[D]" + super.toString() + " (by: " + date + ")");
    }

    /**
     * Adds a deadline to the task list.
     * Prints a message when the date or description is missing or invalid.
     *
     * @param input the user input string containing "deadline" followed by a description of the deadline followed by "/by" and the date
     */
    public static void addDeadline(String input) {
        int dateIdx = input.indexOf("/by");
        try {
            if (dateIdx == -1) {
                System.out.println("Specify a date or time using the keyword /by.");
            } else if (input.substring(8,dateIdx).isBlank()) {
                    System.out.println("Uh, the description of a deadline cannot be empty.");
            } else {
                try {
                    Task.itemList.add(new Deadline(input.substring(9, dateIdx).trim(), input.substring(dateIdx + 4).trim()));
                    addTask();
                } catch (ParseException e) {
                    System.out.println("Date and time format is invalid. (valid: dd/MM/yyyy HHmm)");
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Specify a date or time after the keyword /by.");
        }
    }
}
