import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by ravi on 10/09/14.
 */
public class FileReader {
  private String filePath;

  public FileReader(String filePath) {
    this.filePath = filePath;
  }

  public List<String> getLines() {
    Path path = FileSystems.getDefault().getPath(filePath);
    List<String> lines = null;
    try {
      lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return lines;
  }

}
