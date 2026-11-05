package Module4.EventsHandling.exercise2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LightSwitchSimulator extends JFrame {
    
    private JButton button;
    private JLabel label;
    private boolean isLightOn = false;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;

    public LightSwitchSimulator() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents() {
        button = new JButton("Light Switch");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isLightOn) {
                    label.setText("The light is off");
                    isLightOn = false;
                } else {
                    label.setText("The light is on");
                    isLightOn = true;
                }
            }
        });

        label = new JLabel("The light is off");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        add(panel);
    }
}
