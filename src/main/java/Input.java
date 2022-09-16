import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<String> path = new ArrayList<>();
//TODO задвоенный результат поиска исправить
    public static void input() {
        String uri = CP1251ToUtf8.text(inputPath());
        //String uri = inputPath(); //для отладки без библиотеки
        path.clear();

        if (uri.isEmpty()) {
            input();
        } else if (uri.equals(Messages.getExit())) {
            Messages.exit();
            System.exit(3000);
        } else if (uri.equals(Messages.getMultiFind())) {
            path.clear();
            multiFind();
            inputFind();
        } else {
            path.add(uri);
            inputFind();
        }
    }

    private static void inputFind() {
        while (true) {
            String findFile = CP1251ToUtf8.text(find());
            //String findFile = find(); //для отладки без библиотеки
            if (findFile.isEmpty()) {
                Messages.inputClassTextNotFound();
            } else if (findFile.equals(Messages.getNewFind())) {
                FindFileAndFolder.getListResultFinder().clear();
                input();
            } else if (findFile.equals(Messages.getExit())) {
                Messages.exit();
                System.exit(1000);
            } else if (findFile.equals(Messages.getAllResultOpen())) {
                Result.result(path, "");
            } else {
                Result.result(path, findFile);
            }
        }
    }

    private static String inputPath() {
        Messages.inputClassExampleInputText();
        return Input.SCANNER.nextLine().trim();
    }

    private static String find() {
        Messages.inputClassInstruction();
        Messages.inputClassActionFind();
        return Input.SCANNER.nextLine().trim();
    }

    private static void multiFind() {
        String input = "";
        Messages.inputClassMultiFind();
        while (true) {
            input = Input.SCANNER.nextLine().trim();
            if (input.equals(Messages.getEndInputMultiFind())) {
                break;
            } else {
                path.add(input);
            }
        }
    }
}
