package CarManage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler {
    public static void writeToFile(List<ICar> vehicles, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(vehicles);
            System.out.println("Data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
