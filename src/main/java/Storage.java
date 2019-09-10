import java.io.*;
import java.text.ParseException;
/**
 * Handles reading and writing to hard disk.
 */
public class Storage{
    /**
     * Writes the Task ArrayList to a .txt file in a fixed relative path.
     * If a .txt file with the same name exists, deletes the old file and creates a new file to write to.
     *
     * @throws IOException thrown when the I/O operation has failed or is interrupted
     * @throws NullPointerException thrown when attempting to access a null File object
     */
    public static void writeListToFile() throws IOException, NullPointerException{
        File f = new File("data");
        f.mkdir(); // create directory if it doesn't exist
        File file = new File ("data/List.txt");
        file.delete(); // deletes old file
        FileWriter fw = new FileWriter("data/List.txt");
        try {
            for (Task v : Task.itemList) {
                String done = v.isDone ? "y" : "n";
                if (v instanceof ToDo) {
                    fw.write("T|" + done + "|" + ((ToDo) v).description + "\n");
                } else if (v instanceof Deadline) {
                    fw.write("D|" + done + "|" + ((Deadline) v).description + ">" + ((Deadline) v).dateBackup + "\n");
                } else if (v instanceof Event) {
                    fw.write("E|" + done + "|" + ((Event) v).description + ">" + ((Event) v).dateBackup + "\n");
                }
            }
            fw.close();
        } catch (IOException | NullPointerException e) {
            throw e;
        } finally {
            fw.close();
        }
    }

    /**
     * Reads line by line from a .txt file in a fixed relative path to load an ArrayList of Task objects.
     * If the .txt file does not exist, creates a new empty .txt file in that path.
     * When an exception is thrown, the method terminates.
     *
     * @throws ParseException thrown when there is an error in parsing the file when constructing Task objects
     * @throws DukeException thrown when the method does not recognize the data in the file
     */
    public static void readListFromFile() throws ParseException, DukeException {
        try {
            BufferedReader r = new BufferedReader(new FileReader("data/List.txt"));
            String line = r.readLine();
            while (line != null) {
                Task.addFromFile(line);
                line = r.readLine();
            }
        } catch (IOException e) {
            File f = new File("data/List.txt");
        }
    }
}
