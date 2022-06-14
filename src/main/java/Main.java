import java.awt.*;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String uri = inputPath(SCANNER);
        boolean trigger = true;
        while (trigger) {
            String findFile = find(SCANNER);
            switch (findFile) {
                default:
                    result(uri, findFile);
                    break;
                case ("q"):
                    uri = inputPath(SCANNER);
                    break;
                case ("exit"):
                    trigger = false;
                    break;
            }
        }
    }

    public static void result(String uri, String findFile) {
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
        if (findFileAndFolder.getListResultFinder().isEmpty()){
            System.out.println("Результат поиска пуст.");
        }else {
            open(findFileAndFolder);
        }
    }

    public static String inputPath(Scanner scanner) {
        System.out.println("Введите путь предполагаемого расположения файла в формате (C:\\Users\\a.p.isaev\\Desktop)");
        return scanner.nextLine().trim();
    }

    public static String find(Scanner scanner) {
        System.out.println("Введите что найти.");
        return scanner.nextLine().trim();
    }

    public static void open(FindFileAndFolder findFileAndFolder) {
        Desktop desktop = Desktop.getDesktop();
        boolean trigger = true;
        while (trigger) {
            System.out.println("Введите номер списка для открытия или введите \"q\" для выхода:");
            String code = SCANNER.nextLine().trim();
            switch (code) {
                case ("q"):
                    trigger = false;
                    break;
                default:
                    if (code.matches("\\d+") && findFileAndFolder.getListResultFinder().size() > Integer.parseInt(code)) {
                        try {
                            desktop.open(findFileAndFolder.getListResultFinder().get(Integer.parseInt(code)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Введённое значение не является числом или больше размера результата поиска.");
                    }
                    break;
            }
        }
    }

    public static void subFolder(FindFileAndFolder findFileAndFolder){
        findFileAndFolder.getListResultFinder();
        findFileAndFolder.getLIST_SUBFOLDER();
    }
}

