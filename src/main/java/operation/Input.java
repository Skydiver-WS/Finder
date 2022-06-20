package operation;

import java.util.Scanner;

public class Input {
  private static final Scanner SCANNER = new Scanner(System.in);
  public static void input(){
    String uri = inputPath();
    if(uri.equals("exit")){
      System.exit(0);
    }
    while (true) {
      String findFile = find();
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
