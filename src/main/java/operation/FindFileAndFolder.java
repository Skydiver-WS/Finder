import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFileAndFolder {
  private final String FIND_FILE;
  private final ArrayList<File> LIST_RESULT_FINDER = new ArrayList();

  protected FindFileAndFolder(String uri, String findFile) {
    FIND_FILE = findFile;
    findInFile(uri);
  }

  private void findInFile(String uri) {// непосредственно сердце поиска. Ищет по конечному имени, если в пути встречается совпадения по запросу, то игнорирует
    File file = new File(uri);
    File[] listFiles = file.listFiles();
    try {
      for (File list : Objects.requireNonNull(listFiles)) {
        if (getMatcher(list.getName())) {
          addResult(list);
        } else if (list.isDirectory()) {
          findInFile(list.getPath());
        }
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addResult(File result) { //добавление результатов в массив
    if (result.isFile()) {
      LIST_RESULT_FINDER.add(result);
    } else {
      findInFile(result.getPath());
      LIST_RESULT_FINDER.add(result);
    }
  }

  private boolean getMatcher(String directory) {
    Pattern pattern = Pattern.compile(FIND_FILE.toLowerCase());
    Matcher matcher = pattern.matcher(directory.toLowerCase());
    return matcher.find();
  }

  public ArrayList<File> getListResultFinder() {
    return LIST_RESULT_FINDER;
  }
}
