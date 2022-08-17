import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void input() {
        //String uri = CP1251ToUtf8.text(inputPath());
        String uri = inputPath(); //для отладки без библиотеки
        if (uri.equals(Text.getExit())) {
            System.exit(0);
        }
        while (true) {
            //String findFile = CP1251ToUtf8.text(find());
            String findFile = find(); //для отладки без библиотеки
            if (findFile.equals(Text.getNewFind())) {
                input();
            } else if (findFile.equals(Text.getExit())) {
                System.exit(0);
            } else {
                Result.result(uri, findFile);
            }
        }
    }

    private static String inputPath() {
        Text.inputClassExampleInputText();
        return Input.SCANNER.nextLine().trim();
    }

    private static String find() {
        Text.inputClassInstruction();
        Text.inputClassActionFind();
        return Input.SCANNER.nextLine().trim();
    }
}
