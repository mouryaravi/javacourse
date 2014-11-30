import java.io.IOException;
import java.nio.file.*;

/**
 * Created by ravi on 10/09/14.
 */
public class FileWriter {
  private String filePath;

  public FileWriter(String filePath) {
    this.filePath = filePath;
  }

  public void addLine(String line) {
    if (line != null && !line.endsWith("\n")) {
      line += "\n";
    }
    Path path = FileSystems.getDefault().getPath(filePath);
    try {
      if (Files.notExists(path)) {
        Files.createFile(path);
      }
      Files.write(path, line.getBytes(), new OpenOption[] {StandardOpenOption.APPEND});
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void deleteFile() {
    try {
      Files.deleteIfExists(FileSystems.getDefault().getPath(filePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
