import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFileAndFolder {
    private String uri;
    private final String FIND_FILE;
    private final ArrayList<File> LIST_RESULT_FINDER = new ArrayList();
    private ArrayList<File> bufferList;


    private final HashMap<String, ArrayList<File>> LIST_SUBFOLDER = new HashMap<>();

    public FindFileAndFolder(String uri, String findFile) {
        this.uri = uri;
        FIND_FILE = findFile;
        findInFile();
    }
    private void findInFile() {
        File file = new File(uri);
        File[] listFiles = file.listFiles();
        try {
            for (File list : Objects.requireNonNull(listFiles)) {
                if (getMatcher(list.getPath()) && list.isFile()) {
                    LIST_RESULT_FINDER.add(list);
                } else if (list.isDirectory()) {
                    findInDirectory(list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findInDirectory(File directory) {
        if (getMatcher(directory.getPath())) {
            LIST_RESULT_FINDER.add(directory);
            bufferList = new ArrayList<>();
            LIST_SUBFOLDER.put(directory.getPath(), subFolder(directory));
            return;
        }
        uri = directory.getPath();
        findInFile();
    }

    private ArrayList<File> subFolder(File dir) {
        File file = new File(dir.getPath());
        try {
            for (File list : Objects.requireNonNull(file.listFiles())) {
                if (getMatcher(list.getName()) && list.isFile()) {
                    bufferList.add(list);
                } else if (list.isDirectory()) {
                    subFolder(list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferList;
    }

    private boolean getMatcher(String directory) {
        Pattern pattern = Pattern.compile(FIND_FILE.toLowerCase());
        Matcher matcher = pattern.matcher(directory.toLowerCase());
        return matcher.find();
    }

    public ArrayList<File> getListResultFinder() {
        return LIST_RESULT_FINDER;
    }

    public HashMap<String, ArrayList<File>> getLIST_SUBFOLDER() {
        return LIST_SUBFOLDER;
    }
}
