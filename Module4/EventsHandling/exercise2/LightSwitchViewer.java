package Module4.EventsHandling.exercise2;

import javax.swing.JFrame;

public class LightSwitchViewer {
    public static void main(String[] args) {
        JFrame frame = new LightSwitchSimulator();
        frame.setTitle("Light Switch Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
