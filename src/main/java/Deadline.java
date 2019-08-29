import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Deadline extends Task{
    protected Date date;
    protected String dateBackup;
    public Deadline(String description, String date) throws ParseException {
        super(description);
        this.dateBackup = date;
        this.date = new SimpleDateFormat("dd/MM/yyyy HHmm").parse(date);
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
