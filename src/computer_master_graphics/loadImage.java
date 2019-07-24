package computer_master_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class loadImage {

	public static BufferedImage image;
	public static BufferedImage entities;
	public static BufferedImage player,enemy;
	
	public static void init(){
		image=imageLoader("/white.png");
		entities=imageLoader("/airplane.png");
		crop();
	}
	
	public static BufferedImage imageLoader(String path){
		try {
			return ImageIO.read(loadImage.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static void crop(){
		enemy= entities.getSubimage(0, 0, 85, 95);
		player= entities.getSubimage(85, 0, 85, 95);
	}
	
	
	
}
