import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class IconGenerator {
    public static void main(String[] args) {
        int size = 64;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        
        // Set background to transparent
        g2d.setColor(new Color(0, 0, 0, 0));
        g2d.fillRect(0, 0, size, size);
        
        // Draw task/checkmark icon
        g2d.setColor(Color.BLUE);
        
        // Draw task rectangle
        g2d.fillRect(10, 10, 44, 44);
        
        // Draw checkmark
        g2d.setColor(Color.GREEN);
        g2d.drawLine(18, 36, 28, 46);
        g2d.drawLine(28, 46, 40, 24);
        
        g2d.dispose();
        
        try {
            File output = new File("icon.png");
            ImageIO.write(image, "png", output);
            System.out.println("Icon generated successfully!");
        } catch (Exception e) {
            System.err.println("Error saving icon: " + e.getMessage());
        }
    }
}
