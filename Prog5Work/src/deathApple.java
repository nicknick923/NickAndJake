
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class deathApple extends enemyFigure
{

   private static final int deathAppleBaseDimension = 75;
   private static final int deathAppleMaxVelocity = 5;
   private Image img;

   /**
    This constructor creates a deathApple with the size and max velocity
    specified by the constants that lives on the panel which is passed as a
    parameter.

    @param p The panel for which the game is played on.
    @param player The players PFigure.
    */
   public deathApple(Panel p, PFigure player)
   {
      super(deathAppleBaseDimension, deathAppleBaseDimension,
            deathAppleMaxVelocity, p, player);
      try
      {
         File file = new File("apple logo.png");
         img = ImageIO.read(file);
      }
      catch (Exception e)
      {
         System.err.println("Error: " + e);
      }
   }

   /**
    This method will draw the deathApple at location x,y with the respective
    width and height values stored in this class, if the image was opened.
    */
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
