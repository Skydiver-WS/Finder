public class Messages {

    private static final String exit = "exit";
    private static final String levelUp = "q";
    private static final String newFind = "new";
    private static final String openParentFolder = "f";
    private static final String allResultOpen = "all";
    private static final String multiFind = "multi";
    private static final String endInputMultiFind = "end";



    public static void mainClassStartText() {
        String startText = "Поисковик запущен.\n";
        System.out.println(startText);
    }

    public static void inputClassInstruction(){
        String text = "Список команд:\n\t " +
                newFind + " - новый поиск;\n\t " +
                exit + " - выход из программы.\n ";
        System.out.println(text);
    }
    public static void inputClassExampleInputText() {
        String exampleInputText = "Введите путь предполагаемого расположения файла в формате (C:\\Users\\DNS\\Desktop) и нажмите Enter:";
        String commandText = "Список команд:\n\t" +
                multiFind + " - поиск из нескольких источников;\n\t" +
                exit + " - выход из программы.\n ";
        System.out.println(commandText + "\n" + exampleInputText);
    }

    public static void inputClassActionFind() {
        String actionFind = "Введите что найти или q для перехода на уровень выше и нажмите Enter.";
        System.out.println(actionFind);
    }
    public static void inputClassMultiFind(){
        System.out.println("Введите адрес, после каждого ввода нажмите Enter, после ввода всех адресов введите команду " + endInputMultiFind + ".");
    }
    public static void inputClassTextNotFound(){
        System.out.println("Не введено что найти, попробуйте снова.");
    }

    public static void resultClassLeadTime() {
        System.out.println("По запросу найдено: " + FindFileAndFolder.getListResultFinder().size() + " файлов\n" +
                "Время выполнения запроса составило: " + Result.getResult() + " мс");
    }

    public static void resultClassOutput(Integer i) {
        System.out.println(i + " - " + FindFileAndFolder.getListResultFinder().get(i) + "\n"
                + "---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void resultClassListEmpty() {
        System.out.println("Результат поиска пуст.");
    }

    public static void openResultInstructions() {
        System.out.println("Список команд:\n" +
                "\tНомер от 0 до " + (Result.getFindFileAndFolder().getListResultFinder().size() - 1) + " - для открытия файла. Например 25;\n" +
                "\tНомер от 0 до " + (Result.getFindFileAndFolder().getListResultFinder().size() - 1)+ openParentFolder + " - для открытия папки. Например 25" + openParentFolder + ";\n" +
                "\t" + newFind + " - новый поиск;\n" +
                "\t" + levelUp + " - переход на уровень выше;\n" +
                "\t" + exit + " - новый поиск.");
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
    public static String getAllResultOpen() {
        return allResultOpen;
    }
    public static String getMultiFind() {
        return multiFind;
    }
    public static String getEndInputMultiFind() {
        return endInputMultiFind;
    }
    public static void exit(){
        System.out.println("Завершение работы.");
    }
}
