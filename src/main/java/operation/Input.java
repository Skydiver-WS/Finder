import java.util.Scanner;

public class Input {
  private static final Scanner SCANNER = new Scanner(System.in);
  public static void input(){

    String uri = CP1251ToUtf8.text(inputPath());
    if(uri.equals("exit")){
      System.exit(0);
    }
    while (true) {
      String findFile = CP1251ToUtf8.text(find());
      switch (findFile) {
        default:
          Result.result(uri, findFile);
          break;
        case ("q"):// новый поиск
          input();
          break;
        case ("exit"):
          System.exit(0);
          break;
      }
    }
  }
  private static String inputPath() {
    System.out.println("Введите путь предполагаемого расположения файла в формате (C:\\Users\\DNS\\Desktop)");
    return Input.SCANNER.nextLine().trim();
  }

  private static String find() {
    System.out.println("Введите что найти.");
    return Input.SCANNER.nextLine().trim();
  }
}
