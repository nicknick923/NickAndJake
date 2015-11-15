
import java.awt.event.ActionEvent;

import java.awt.*;

/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class Prog5GUI extends java.awt.Frame implements java.awt.event.ActionListener
{

   private int deaths = 0;
   private final listOfPFigures figureList;
   private final javax.swing.Timer moveTimer = new javax.swing.Timer(100, this);
   private static final Point userInputData = new Point(0, 0);
   private static int level = 5;

   /**
    Creates new form Prog5GUI
    */
   public Prog5GUI()
   {
      initComponents();
      figureList = new listOfPFigures(gamePanel);
      moveTimer.start();
      userWonLevel();
   }

   /**
    This method is called from within the constructor to initialize the form.
    WARNING: Do NOT modify this code. The content of this method is always
    regenerated by the Form Editor.
    */
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      gamePanel = new java.awt.Panel();
      deathCountField = new java.awt.TextField();

      setMinimumSize(new java.awt.Dimension(1130, 700));
      setPreferredSize(new java.awt.Dimension(1130, 700));
      addComponentListener(new java.awt.event.ComponentAdapter()
      {
         public void componentResized(java.awt.event.ComponentEvent evt)
         {
            componetResized(evt);
         }
      });
      addWindowListener(new java.awt.event.WindowAdapter()
      {
         public void windowClosing(java.awt.event.WindowEvent evt)
         {
            exitForm(evt);
         }
      });
      setLayout(null);

      gamePanel.setBackground(new java.awt.Color(200, 200, 200));
      gamePanel.addKeyListener(new java.awt.event.KeyAdapter()
      {
         public void keyPressed(java.awt.event.KeyEvent evt)
         {
            gamePanelKeyDown(evt);
         }
         public void keyReleased(java.awt.event.KeyEvent evt)
         {
            gamePanelKeyUp(evt);
         }
      });
      gamePanel.setLayout(null);

      deathCountField.setEditable(false);
      deathCountField.setName("deathCountField"); // NOI18N
      deathCountField.setText("0 Deaths");
      deathCountField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            transferFocus(evt);
         }
      });
      gamePanel.add(deathCountField);
      deathCountField.setBounds(10, 10, 70, 20);

      add(gamePanel);
      gamePanel.setBounds(10, 40, 760, 230);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application
    */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
       System.exit(0);
    }//GEN-LAST:event_exitForm

   private void gamePanelKeyDown(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyDown
   {//GEN-HEADEREND:event_gamePanelKeyDown
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
         userInputData.y = 1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
         userInputData.y = -1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
         userInputData.x = -1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
         userInputData.x = 1;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE || evt.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE)
         if (moveTimer.isRunning())
            moveTimer.stop();
         else
            moveTimer.start();

   }//GEN-LAST:event_gamePanelKeyDown

   private void gamePanelKeyUp(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyUp
   {//GEN-HEADEREND:event_gamePanelKeyUp
      if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
         userInputData.y = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
         userInputData.y = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
         userInputData.x = 0;
      else if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
         userInputData.x = 0;
   }//GEN-LAST:event_gamePanelKeyUp

   private void componetResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_componetResized
   {//GEN-HEADEREND:event_componetResized
      gamePanel.setSize(this.getSize().width - 20, this.getSize().height - 50);
   }//GEN-LAST:event_componetResized

   private void transferFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_transferFocus
   {//GEN-HEADEREND:event_transferFocus
      gamePanel.requestFocus();
   }//GEN-LAST:event_transferFocus

   public static Point getUserInputData()
   {
      return userInputData;
   }

   private void userWonLevel()
   {
      level++;
      componetResized(null);
      setLevel();
   }

   private void setLevel()
   {
      figureList.resetList();
      figureList.hideAll();
      figureList.addFigure(new goalFigure(gamePanel));
      figureList.addFigure(new scanMan(gamePanel));
      for (int i = 0; i < level; i++)
      {
         figureList.addFigure(new deathDroid(gamePanel));
         figureList.addFigure(new deathBox(gamePanel));
      }
   }

   /**
    @param args the command line arguments
    */
   public static void main(String args[])
   {
      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog5GUI().setVisible(true);
         }
      });
   }

   @Override
   public void actionPerformed(ActionEvent ae)
   {
      figureList.drawAll();
      userCollideCheck();
   }

   private void userCollideCheck()
   {
      PFigure hitObject = figureList.userHitObject();
      if (hitObject != null)
         if (hitObject instanceof goalFigure)
            userWonLevel();
         else if (hitObject instanceof enemyFigure)
            try
            {
               deaths++;
               java.io.File soundFile = new java.io.File("C:\\Windows\\Media\\Windows Critical Stop.wav");
               javax.sound.sampled.AudioInputStream audioIn = javax.sound.sampled.AudioSystem.getAudioInputStream(soundFile);
               javax.sound.sampled.Clip clip = javax.sound.sampled.AudioSystem.getClip();
               clip.open(audioIn);
               clip.start();
               setLevel();
               if (deaths == 1)
                  deathCountField.setText("1 Death");
               else
                  deathCountField.setText(deaths + " Deaths");
            }
            catch (Exception e)
            {

            }
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.TextField deathCountField;
   private java.awt.Panel gamePanel;
   // End of variables declaration//GEN-END:variables
}
