import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-hh:mm:ss-a");

    public Screenshot(JFrame maze) throws IOException, AWTException {

        Calendar now = Calendar.getInstance();
        Rectangle rec = maze.getBounds();

        BufferedImage image = new Robot().createScreenCapture(rec);
        ImageIO.write(image, "png", new File("src/main/resources/screenshots/Maze"+ formatter.format(now.getTime()) + ".png"));
    }
}
