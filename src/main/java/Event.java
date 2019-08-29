import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Event extends Task {
    protected Date date;
    protected String dateBackup;
    public Event(String description, String date) throws ParseException {
        super(description);
        this.dateBackup = date;
        this.date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(date);
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
