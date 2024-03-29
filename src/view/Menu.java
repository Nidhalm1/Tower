package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import main1.Game;

public class Menu extends GameScene implements SceneMethods {
    private BufferedImage img;
	private Random random;
    
    public Menu(Game game){
        super(game);
        importImg();
        random = new Random();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img, 0, 0, null);

			for (int i = 0; i < 20; i++) {// si on fait moins que< 32 camarche
				g.setColor(getRandomColor());//changer la coleur dudessin
				g.fillRect(i*32, 0, 32, 32);
			}
			for (int y = 0; y < 20; y++) {
				g.setColor(getRandomColor());//changer la coleur dudessin
				g.fillRect(0, y*32, 32, 32);
			}

    }

    @Override
    public void callMe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callMe'");
    }
    public Color getRandomColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

	private void importImg() {

		InputStream is = getClass().getResourceAsStream("/res/mainBG.png");

		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    

}
