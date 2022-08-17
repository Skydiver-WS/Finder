import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class OpenResult {
    private boolean trigger = true;

    public void open(FindFileAndFolder findFileAndFolder) {
        Scanner SCANNER = new Scanner(System.in);
        while (trigger) {
            Text.openResultInstructions();
            String code = SCANNER.nextLine().trim();
            try {
                if (code.equals(Text.getLevelUp())) {
                    trigger = false;
                } else if (code.equals(Text.getNewFind())) {
                    Input.input();
                } else if (code.equals(Text.getExit())) {
                    System.exit(0);
                } else {
                    openResult(code, findFileAndFolder);
                }
            } catch (Exception ex) {
                Text.openResultClassCommandNotFound();
            }
        }
    }

    private void openResult(String code, FindFileAndFolder findFileAndFolder) {
        Desktop desktop = Desktop.getDesktop();
        String[] splitCode = code.split(Text.getOpenParentFolder());
        boolean cacheIndexOpen = findFileAndFolder.getListResultFinder().size() > Integer.parseInt(splitCode[0]);
        try {
            if (code.matches("\\d+" + Text.getOpenParentFolder()) && cacheIndexOpen) {
                String pathParentFolder = findFileAndFolder.getListResultFinder().get(Integer.parseInt(splitCode[0])).getParent();
                desktop.open(new File(pathParentFolder));
            } else if (splitCode[0].matches("\\d+") && cacheIndexOpen) {
                desktop.open(findFileAndFolder.getListResultFinder().get(Integer.parseInt(code)));
            } else {
               Text.openResultClassWarring();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
