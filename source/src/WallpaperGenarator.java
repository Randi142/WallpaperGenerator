import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class WallpaperGenarator {

	public static void main(String[] args) throws IOException {
		
		boolean type = true; //distinguish 1 input or 9 inputs
		
		double height , width ;
		
		String [] input = new String[10]; // 9 inputs
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("1 image input enter true, 9 images input enter false");
		
		type = s.nextBoolean();
		
		System.out.println("width? (resolution)");
		
		width = s.nextInt();
		
		System.out.println("height? (resolution)");
		
		height = s.nextInt();
		
		if (type == true) {		//1 input to 3*3 image
			
			System.out.println("Please input the image path");
			
			input[1] = s.next();
			
			for (int x=1 ; x<10 ; x++)
				input [x] = input[1];
		}
		
		else					//9 inputs to 3*3 image
		{
			System.out.println("Please input the image path");
			
			for (int y=1 ; y<10 ;y++)
			{
				input[y] = s.next();
			}
			
		}
		
		BufferedImage joined = new BufferedImage((int)width,(int)height, BufferedImage.TYPE_INT_RGB); 	// output image & size
		
		BufferedImage image[] = new BufferedImage[10];
		
		for (int x = 1; x<10 ; x++) 			
			image[x] = ImageIO.read(new File(input[x])); 

		BufferedImage resizedImage [] = new BufferedImage[10];
		
		width = (width / 3);				
		
		height = (height / 3);
		
		if ((width - (int)width) != 1)		//avoid black edge while the resolution / 3 has a remainder
			width++;
		if ((height - (int)height) != 1)
			height++;
		
		for (int x = 1; x<10 ; x++)
			resizedImage[x] = resize(image[x],(int)height,(int)width);		//resize
		
	    Graphics2D graph = joined.createGraphics();
	    
	    int widthCount = 0;
	    int heightCount = 0;
	    int z = 1 ;
	    
	    for (int y = 1 ; y<4 ; y++)			//assign the position of 9 images
	    {
	    	for (int x = 1 ; x<4 ; x++) {
	    		
	    		switch (y) {
	    		
	    		case 1 : heightCount = 0;
	    			break;
	    		case 2 : heightCount = resizedImage[1].getHeight();
	    			break;
	    		case 3 : heightCount = (resizedImage[1].getHeight()*2);
	    			break;
	    		}
	    		
	    		switch (x) {
	    		
	    		case 1 : widthCount = 0;
	    			break;
	    		case 2 : widthCount = resizedImage[1].getWidth();
	    			break;
	    		case 3 : widthCount = (resizedImage[1].getWidth()*2);
	    			break;
	    		}

		    	graph.drawImage(resizedImage[z], widthCount , heightCount , null);
		    	z++;
	    	}
	    }

	    File joinedFile = new File("output.png");
	    
	    ImageIO.write(joined, "png", joinedFile); 

	}
		
	private static BufferedImage resize(BufferedImage img, int height, int width) {		//resize function
		
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = resized.createGraphics();
        
        g2d.drawImage(tmp, 0, 0, null);
        
        g2d.dispose();
        
        return resized;
    }

}
