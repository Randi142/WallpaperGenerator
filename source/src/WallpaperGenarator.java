import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class WallpaperGenarator {

	public static void main(String[] args) throws IOException {
		
		boolean type = true; //distinguish 1 input or 9 inputs
		
		String [] input = new String[10]; // 9 inputs
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("1 image input enter true, 9 images input enter false");
		
		type = s.nextBoolean();
		
		
		if (type == true) {
			
			System.out.println("Please input the image path");
			
			input[1] = s.next();
			
			for (int x=1 ; x<10 ; x++)
				input [x] = input[1];
		}
		
		else
		{
			System.out.println("Please input the image path");
			
			for (int y=1 ; y<10 ;y++)
			{
				input[y] = s.next();
			}
			
		}
		
		BufferedImage joined = new BufferedImage(1920,1080, BufferedImage.TYPE_INT_RGB); //default 750*1334 resolution for iPhone6
		
		BufferedImage image[] = new BufferedImage[10];
		
		for (int x = 1; x<10 ; x++) 
	    image[x] = ImageIO.read(new File(input[x])); 


	    Graphics2D graph = joined.createGraphics();
	    
	    int width = 0;
	    int height = 0;
	    int z = 1 ;
	    
	    for (int y = 1 ; y<4 ; y++)
	    {
	    	for (int x = 1 ; x<4 ; x++) {
	    		
	    		switch (y) {
	    		
	    		case 1 : height = 0;
	    			break;
	    		case 2 : height = image[1].getHeight();
	    			break;
	    		case 3 : height = (image[1].getHeight()*2);
	    			break;
	    		}
	    		
	    		switch (x) {
	    		
	    		case 1 : width = 0;
	    			break;
	    		case 2 : width = image[1].getWidth();
	    			break;
	    		case 3 : width = (image[1].getWidth()*2);
	    			break;
	    		}

		    	graph.drawImage(image[z], width , height , null);
		    	z++;
	    	}
	    }
	

	    File joinedFile = new File("output.png"); 
	    ImageIO.write(joined, "png", joinedFile); 

	}

}
