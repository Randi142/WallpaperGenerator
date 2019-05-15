import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class WallpaperGenarator {

	public static void main(String[] args) throws IOException {
		
		boolean type = true; //distinguish 1 input or 9 inputs
		
		String [] input = new String[9]; // 9 inputs
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("1 image input enter true, 9 images input enter false");
		
		type = s.nextBoolean();
		
		
		
		if (type == true) {
			
			System.out.println("Please input the image path");
			
			input[0] = s.next();
			
			for (int x=0 ; x<9 ; x++)
				input [x] = input[0];
		}
		
		else
		{
			System.out.println("Please input the image path");
			
			for (int y=0 ; y<9 ;y++)
			{
				input[y] = s.next();
			}
			
		}
		
		BufferedImage joined = new BufferedImage(750,1334, BufferedImage.TYPE_INT_RGB); //default 750*1334 resolution for iPhone6
		
	    BufferedImage image1 = ImageIO.read(new File(input[0])); 
	    BufferedImage image2 = ImageIO.read(new File(input[1]));
	    BufferedImage image3 = ImageIO.read(new File(input[2]));
	    BufferedImage image4 = ImageIO.read(new File(input[3]));
	    BufferedImage image5 = ImageIO.read(new File(input[4]));
	    BufferedImage image6 = ImageIO.read(new File(input[5]));
	    BufferedImage image7 = ImageIO.read(new File(input[6]));
	    BufferedImage image8 = ImageIO.read(new File(input[7]));
	    BufferedImage image9 = ImageIO.read(new File(input[8]));

	    Graphics2D graph = joined.createGraphics(); 
	    graph.drawImage(image1, 0, 0,null); 
	    graph.drawImage(image2, image1.getWidth(), 0,null);
	    graph.drawImage(image3, (image1.getWidth()*2), 0,null);
	    graph.drawImage(image4, 0, image1.getHeight(),null);
	    graph.drawImage(image5, image1.getWidth(), image1.getHeight(),null);
	    graph.drawImage(image6, (image1.getWidth()*2), image1.getHeight(),null);
	    graph.drawImage(image7, 0, (image1.getHeight()*2),null);
	    graph.drawImage(image8, image1.getWidth(), (image1.getHeight()*2),null);
	    graph.drawImage(image9, (image1.getWidth()*2), (image1.getHeight()*2),null);

	    File joinedFile = new File("C:\\Users\\Rdi\\Desktop\\Java-workspace\\WallpaperGenerator\\output.png"); 
	    ImageIO.write(joined, "png", joinedFile); 

	}

}
