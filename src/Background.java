import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Background extends JPanel {


    Image image;

    public Background() {
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("GAMBLING MANIA.png"), "GAMBLING MANIA.png"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {

            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
