import java.util.ArrayList;

public class Result {
    private static FindFileAndFolder findFileAndFolder;
    private static Long result;
    public static FindFileAndFolder getFindFileAndFolder() {
        return findFileAndFolder;
    }

    public static Long getResult() {
        return result;
    }

    public static void result(ArrayList<String> uri, String findFile) {
        printResult(uri, findFile);
        Messages.resultClassLeadTime();
        if (FindFileAndFolder.getListResultFinder().isEmpty()) {
            Messages.resultClassListEmpty();
        } else {
            OpenResult openResult = new OpenResult();
            openResult.open(findFileAndFolder);
        }
    }

    public static void printResult(ArrayList<String> uri, String findFile) {
        long start = System.currentTimeMillis();
        for (String oneUri:uri) {
            findFileAndFolder = new FindFileAndFolder(oneUri, findFile);
        }
        for (int i = 0; i < FindFileAndFolder.getListResultFinder().size(); i++) {
            Messages.resultClassOutput(i);
        }
        long end = System.currentTimeMillis();
        result = end - start;
    }
}
