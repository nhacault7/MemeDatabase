package tools;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author n.hacault
 */
public class Images {
    
    public static void resizeToContainer(JLabel label) {
        int width = label.getWidth();
        int height = label.getHeight();
        ImageIcon originalIcon = (ImageIcon)label.getIcon();
        if (originalIcon == null) return;
        Image originalImage = originalIcon.getImage();
        Image newImage = originalImage.getScaledInstance(
                                width, height, Image.SCALE_SMOOTH);
        Icon icon = new ImageIcon(newImage);
        label.setIcon(icon);
    }
    
}
