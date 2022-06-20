package operation;

import java.awt.*;
import java.util.Scanner;

public class OpenResult {
  private static final Scanner SCANNER = new Scanner(System.in);
  protected static void open(FindFileAndFolder findFileAndFolder) {
    Desktop desktop = Desktop.getDesktop();
    boolean trigger = true;
    while (trigger) {
      System.out.println("Введите номер списка для открытия или введите \"q\" для выхода:");
      String code = SCANNER.nextLine().trim();
      switch (code) {
        case("new"):
          Input.input();
        case ("q"):
          trigger = false;
          break;
        default:
          if (code.matches("\\d+") && findFileAndFolder.getListResultFinder().size() > Integer.parseInt(code)) {
            try {
              desktop.open(findFileAndFolder.getListResultFinder().get(Integer.parseInt(code)));
            }
            catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            System.out.println("Введённое значение не является числом или больше размера результата поиска.");
          }
          break;
      }
    }
  }
}
