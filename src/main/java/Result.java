public class Result {
    private static FindFileAndFolder findFileAndFolder;


    private static Long result;

    public static FindFileAndFolder getFindFileAndFolder() {
        return findFileAndFolder;
    }

    public static Long getResult() {
        return result;
    }

    public static void result(String uri, String findFile) {
        printResult(uri, findFile);
        Text.resultClassLeadTime();
        if (findFileAndFolder.getListResultFinder().isEmpty()) {
            Text.resultClassListEmpty();
        } else {
            OpenResult openResult = new OpenResult();
            openResult.open(findFileAndFolder);
        }
    }

    public static void printResult(String uri, String findFile) {
        long start = System.currentTimeMillis();
        findFileAndFolder = new FindFileAndFolder(uri, findFile);
        for (int i = 0; i < findFileAndFolder.getListResultFinder().size(); i++) {
            Text.resultClassOutput(i);
        }
        long end = System.currentTimeMillis();
        result = end - start;
    }
}
