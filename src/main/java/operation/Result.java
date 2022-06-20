package operation;

public class Result {
  protected static void result(String uri, String findFile) {
    long start = System.currentTimeMillis();
    FindFileAndFolder findFileAndFolder = new FindFileAndFolder(uri, findFile);
    for (int i = 0; i < findFileAndFolder.getListResultFinder().size(); i++) {
      System.out.println(i + " - " + findFileAndFolder.getListResultFinder().get(i) + "\n"
        + "---------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    long end = System.currentTimeMillis();
    float result = end - start;
    System.out.println("По запросу найдено: " + findFileAndFolder.getListResultFinder().size() + " файлов\n" +
      "Время выполнения запроса составило: " + result + " мс");
    if (findFileAndFolder.getListResultFinder().isEmpty()) {
      System.out.println("Результат поиска пуст.");
    } else {
      OpenResult.open(findFileAndFolder);
    }
  }
}
