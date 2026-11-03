package Module4.ContainerExamples.topLevel;

import javax.swing.*;
import java.awt.*;

public class GlassPaneExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Glass Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a button and a label and add them to the main content pane
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));
        frame.add(button, BorderLayout.NORTH);

        JLabel label = new JLabel("This is the main content", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(label);

        // Set up the glass pane
        JPanel glass = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        glass.setOpaque(false);
        glass.setBackground(new Color(0, 0, 0, 100));
        JLabel glassLabel = new JLabel("Glass Pane Active", SwingConstants.CENTER);
        glassLabel.setFont(new Font("Arial", Font.BOLD, 20));
        glassLabel.setForeground(Color.RED);
        glass.add(glassLabel, BorderLayout.CENTER);

        // Intercept mouse events on the glass pane
        glass.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                e.consume();
            }
        });
        
        frame.setGlassPane(glass);
        glass.setVisible(true);
        frame.setVisible(true);

        new Timer(3000, e -> glass.setVisible(false)).start(); // Hide glass pane after 3 seconds
    }
}
