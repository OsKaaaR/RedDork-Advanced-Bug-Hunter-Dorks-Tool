import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageUtil {
    public static ImageIcon resizeIcon(String path, int width, int height) {
        try {

            if (!path.startsWith("/")) {
                path = "/" + path;
            }

            URL imageUrl = ImageUtil.class.getResource(path);
            if (imageUrl == null) {
                System.err.println("❌ Image not found: " + path);
                return new ImageIcon();
            }

            ImageIcon icon = new ImageIcon(imageUrl);
            Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            e.printStackTrace();
            return new ImageIcon();
        }
    }
}
