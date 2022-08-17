import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Manual {
    /*TODO в разработке
     */
    public static void openManual (){
        Desktop desktop = Desktop.getDesktop();
        try {
            File file = new File("C:/Users/a.p.isaev/Desktop/Skillbox/Finder/Manual/package-summary.html");
            desktop.open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
