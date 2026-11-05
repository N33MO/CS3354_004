package Module4.EventsHandling.exercise1;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterApplication extends JFrame {

    private JButton incButton;
    private JButton decButton;
    private JLabel labelCount;
    private int count = 0;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;
    
    public CounterApplication() {
        // Constructor code for the CounterApplication
        super("Counter Application");
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createComponents() {
        incButton = new JButton("Increment");
        decButton = new JButton("Decrement");
        labelCount = new JLabel("0");
        // set the font size of the buttons and label
        incButton.setFont(incButton.getFont().deriveFont(24.0f));
        decButton.setFont(decButton.getFont().deriveFont(24.0f));
        labelCount.setFont(labelCount.getFont().deriveFont(24.0f));

        incButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the counter and update the label
                count++;
                labelCount.setText(Integer.toString(count));
            }
        });

        decButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                labelCount.setText(Integer.toString(count));
            }
        });

        JPanel panel = new JPanel();
        panel.add(incButton);
        panel.add(decButton);
        panel.add(labelCount);
        add(panel);
    }
}
