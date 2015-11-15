
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathBox extends enemyFigure
{

   private Image img;

   private static final int boxLength = 75;

   public deathBox(Panel p)
   {
      super(50, 50, boxLength, boxLength, 1, p);
      int startingX = super.getRandom(0, p.getWidth() - boxLength);
      int startingY = super.getRandom(0, p.getHeight() - boxLength);
      move(startingX, startingY);
      xVelocity = super.getRandom(-10, 10);
      yVelocity = super.getRandom(-10, 10);
      try
      {
         File file = new File("apple logo.png");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.out.println("Crashing: " + e);
      }
   }

   @Override
   public void draw()
   {
      if (img != null)
      {
         Graphics g = panel.getGraphics();
         g.drawImage(img, x, y, width, height, null);
      }
   }

}
