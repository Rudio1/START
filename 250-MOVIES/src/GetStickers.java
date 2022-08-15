import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

//i will be one  of the greatest


public class GetStickers {
    
    public void create() throws Exception {

        BufferedImage image = ImageIO.read(new File("entrada/movie.jpg"));
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 200;
        
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(image, null, 0, 0);

        ImageIO.write(newImage, "png", new File("saida/figurinha.png"));
    }

    public static void main(String[] args) throws Exception {
       var teste = new GetStickers();
       teste.create();
        
    }
}


