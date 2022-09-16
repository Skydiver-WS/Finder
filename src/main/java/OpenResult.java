import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class OpenResult {
    private boolean trigger = true;

    public void open(FindFileAndFolder findFileAndFolder) {
        Scanner SCANNER = new Scanner(System.in);
        while (trigger) {
            Messages.openResultInstructions();
            String code = SCANNER.nextLine().trim();
            try {
                if (code.equals(Messages.getLevelUp())) {
                    FindFileAndFolder.getListResultFinder().clear();
                    trigger = false;
                } else if (code.equals(Messages.getNewFind())) {
                    FindFileAndFolder.getListResultFinder().clear();
                    Input.input();
                } else if (code.equals(Messages.getExit())) {
                    System.exit(0);
                } else {
                    openResult(code, findFileAndFolder);
                }
            } catch (Exception ex) {
                Messages.openResultClassCommandNotFound();
            }
        }
    }

    private void openResult(String code, FindFileAndFolder findFileAndFolder) {
        Desktop desktop = Desktop.getDesktop();
        String[] splitCode = code.split(Messages.getOpenParentFolder());
        boolean cacheIndexOpen = FindFileAndFolder.getListResultFinder().size() > Integer.parseInt(splitCode[0]);
        try {
            if (code.matches("\\d+" + Messages.getOpenParentFolder()) && cacheIndexOpen) {
                String pathParentFolder = FindFileAndFolder.getListResultFinder().get(Integer.parseInt(splitCode[0])).getParent();
                desktop.open(new File(pathParentFolder));
            } else if (splitCode[0].matches("\\d+") && cacheIndexOpen) {
                desktop.open(FindFileAndFolder.getListResultFinder().get(Integer.parseInt(code)));
            } else {
               Messages.openResultClassWarring();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
