
/**

 @author Nick Sosinski
 @author Jake Ira
 */
public class Prog5GUI extends java.awt.Frame
{

   private static Game gameManager;
   private static String gameMode;
   private final String MENU_MUSIC = "Hello.wav";

   /**
    This initializes the components, resizes the gamePanel for the current
    forms size, then creates the game manager which runs the game.
    */
   public Prog5GUI()
   {
      initComponents();
      componetResized(null);
      gameManager = new Game(this, gamePanel, timeField, deathCountField,
            gameMode);
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
      timeField = new java.awt.TextField();

      setMinimumSize(new java.awt.Dimension(1130, 700));
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
      add(gamePanel);
      gamePanel.setBounds(10, 60, 760, 230);

      deathCountField.setEditable(false);
      deathCountField.setName("deathCountField"); // NOI18N
      deathCountField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            deathCountFieldtransferFocus(evt);
         }
      });
      add(deathCountField);
      deathCountField.setBounds(10, 40, 120, 20);

      timeField.setBackground(new java.awt.Color(240, 240, 240));
      timeField.setEditable(false);
      timeField.setName("timeField"); // NOI18N
      timeField.addFocusListener(new java.awt.event.FocusAdapter()
      {
         public void focusGained(java.awt.event.FocusEvent evt)
         {
            timeFieldTransferFocus(evt);
         }
      });
      add(timeField);
      timeField.setBounds(140, 40, 150, 20);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   /**
    Exit the Application, causes a few errors, but those errors don't matter
    because the game has closed.

    @param evt A Java window event that we don't use.
    */
   private void exitForm(java.awt.event.WindowEvent evt)
	{//GEN-FIRST:event_exitForm
      Sound.stopGameMusic();
      Sound.playGameMusic(MENU_MUSIC);
      this.dispose();
    }//GEN-LAST:event_exitForm

   /**
    This method passes any KeyDown event onto gameManager.

    @param evt The KeyEvent data.
    */
   private void gamePanelKeyDown(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyDown
   {//GEN-HEADEREND:event_gamePanelKeyDown
      gameManager.keyDownHandler(evt);
   }//GEN-LAST:event_gamePanelKeyDown

   /**
    This method passes any KeyUp event onto gameManager.

    @param evt The KeyEvent data.
    */
   private void gamePanelKeyUp(java.awt.event.KeyEvent evt)//GEN-FIRST:event_gamePanelKeyUp
   {//GEN-HEADEREND:event_gamePanelKeyUp
      scanMan.keyUpReciver(evt);
   }//GEN-LAST:event_gamePanelKeyUp

   /**
    This method resizes the gamePanel to properly fit the window.

    @param evt The resized event data. (Not Used)
    */
   private void componetResized(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_componetResized
   {//GEN-HEADEREND:event_componetResized
      gamePanel.setSize(getWidth() - 20, getHeight() - 70);
   }//GEN-LAST:event_componetResized

   /**
    This method transfers focus back to the gamePanel when the user clicks on
    the deathCountField.

    @param evt The focus event data. (Not Used)
    */
   private void deathCountFieldtransferFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_deathCountFieldtransferFocus
   {//GEN-HEADEREND:event_deathCountFieldtransferFocus
      gamePanel.requestFocus();
   }//GEN-LAST:event_deathCountFieldtransferFocus

   /**
    This method transfers focus back to the gamePanel when the user clicks on
    the deathCountField.

    @param evt The focus event data. (Not Used)
    */
   private void timeFieldTransferFocus(java.awt.event.FocusEvent evt)//GEN-FIRST:event_timeFieldTransferFocus
   {//GEN-HEADEREND:event_timeFieldTransferFocus
      gamePanel.requestFocus();
   }//GEN-LAST:event_timeFieldTransferFocus

   /**
    This method is the main method of the program and it creates and runs the
    program.

    @param args the command line arguments.
    */
   public static void main(String args[])
   {

      if (args[0].equals("rounds"))
         gameMode = "rounds";
      else
         gameMode = "endless";

      java.awt.EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            new Prog5GUI().setVisible(true);
         }
      }
      );
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private java.awt.TextField deathCountField;
   private java.awt.Panel gamePanel;
   private java.awt.TextField timeField;
   // End of variables declaration//GEN-END:variables
}
