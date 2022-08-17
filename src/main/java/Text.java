public class Text {

    private static final String exit = "exit";
    private static final String levelUp = "q";
    private static final String newFind = "new";
    private static final String openParentFolder = "f";



    public static void mainClassStartText() {
        String startText = "Поисковик запущен.\n\t" +
                "Список команд:\n\t" +
                exit + " - выход из программы.\n ";

        System.out.println(startText);
    }

    public static void inputClassInstruction(){
        String text = "Список команд:\n\t " +
                newFind + " - новый поиск;\n\t " +
                exit + " - выход из программы.\n ";
        System.out.println(text);
    }
    public static void inputClassExampleInputText() {
        String exampleInputText = "Введите путь предполагаемого расположения файла в формате (C:\\Users\\DNS\\Desktop) и нажмите Enter.";
        System.out.println(exampleInputText);
    }

    public static void inputClassActionFind() {
        String actionFind = "Введите что найти или q для перехода на уровень выше и нажмите Enter.";
        System.out.println(actionFind);
    }

    public static void resultClassLeadTime() {
        System.out.println("По запросу найдено: " + Result.getFindFileAndFolder().getListResultFinder().size() + " файлов\n" +
                "Время выполнения запроса составило: " + Result.getResult() + " мс");
    }

    public static void resultClassOutput(Integer i) {
        System.out.println(i + " - " + Result.getFindFileAndFolder().getListResultFinder().get(i) + "\n"
                + "---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void resultClassListEmpty() {
        System.out.println("Результат поиска пуст.");
    }

    public static void openResultInstructions() {
        System.out.println("""
                Введите номер списка (пример: 25) для открытия,\040
                              для открытия папки номер и\040""" + openParentFolder + " (например: 24" + openParentFolder + ")\n\t\t\t" +
                "для нового поиска " + newFind + "\n\t\t\t" +
                "или введите " + levelUp + " для выхода и нажмите Enter:"
        );
    }

    public static void openResultClassWarring() {
        System.out.println("Введённое значение не является числом или больше размера результата поиска.");
    }

    public static void openResultClassCommandNotFound() {
        System.out.println("Команда не найдена.");
    }

    public static String getExit() {
        return exit;
    }

    public static String getLevelUp() {
        return levelUp;
    }

    public static String getNewFind() {
        return newFind;
    }

    public static String getOpenParentFolder() {
        return openParentFolder;
    }
}
