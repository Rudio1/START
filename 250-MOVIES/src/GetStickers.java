import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

//i will be one  of the greatest


public class GetStickers {
    
    public void create() throws Exception {
        File f = new File("250-MOVIES/entrada/test.jpg");
        String outputPath = "250-MOVIES/saida/figurinha.png";

        //Criando nova imagem em memória
        InputStream inputStream = new FileInputStream(f.getAbsolutePath());
        BufferedImage image = ImageIO.read(inputStream);
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = height + 200;
        
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = (Graphics2D) newImage.createGraphics();
        graphics.drawImage(image, 0, 0, null);

        //Escrevendo no arquivo e alterando a cor
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(fonte);
        graphics.setColor(Color.CYAN);
        graphics.drawString("Criando stickers", 30, newHeight - 100);

        //Escrevendo a imagem em um arquivo (saida)
        ImageIO.write(newImage, "png", new File(outputPath));

        System.out.println("Sucessfull");
    }

    public static void main(String[] args) throws Exception {
       var generate = new GetStickers();
       generate.create();
        
    }
}


