import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFileAndFolder {
    private final String FIND_FILE;



    private static final ArrayList<File> LIST_RESULT_FINDER = new ArrayList();

    public FindFileAndFolder(String uri, String findFile) {
        FIND_FILE = findFile;
        findInFile(uri);
    }

    private void findInFile(String uri) {
        try {
            List<Path> listPath = Files.walk(Path.of(uri)).toList();
            for (Path path : listPath) {
                if (getMatcher(path.getFileName().toString())) {
                    addResult(path.toFile());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void addResult(File result) {
        LIST_RESULT_FINDER.add(result);
    }

    private boolean getMatcher(String directory) {
        Pattern pattern = Pattern.compile(FIND_FILE.toLowerCase());
        Matcher matcher = pattern.matcher(directory.toLowerCase());
        return matcher.find();
    }

    public static ArrayList<File> getListResultFinder() {
        return LIST_RESULT_FINDER;
    }
}
