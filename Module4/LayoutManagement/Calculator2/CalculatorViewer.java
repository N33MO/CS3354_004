package Module4.LayoutManagement.Calculator2;

import javax.swing.JFrame;

public class CalculatorViewer
{  
   public static void main(String[] args)
   {  
      JFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Calculator");
      frame.setVisible(true);
   }
}