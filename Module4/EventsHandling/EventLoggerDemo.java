package Module4.EventsHandling;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;


/**
 * EventLoggerDemo - Demonstrates multiple event types in Swing.
 *
 * A label shows the CURRENT event in red and the PREVIOUS event in black.
 * A detail panel shows the latest event object's important fields.
 * The target region contains several Swing components so students can
 * compare mouse, keyboard, action, item, and change events.
 */
public class EventLoggerDemo {

    // Tracks the previous and current event descriptions
    private static String previousEvent = "(none)";
    private static String currentEvent  = "(none)";

    // Two labels so we can style them independently
    private static JLabel previousLabel;
    private static JLabel currentLabel;
    private static JTextArea detailArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Logger Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(980, 560);
        frame.setMinimumSize(new Dimension(860, 480));
        frame.setLocationRelativeTo(null);

        JPanel eventPanel = buildTargetPanel();

        // ── Labels for event display ─────────────────────────────────────────
        previousLabel = new JLabel("Previous: (none)");
        previousLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        previousLabel.setForeground(Color.BLACK);

        currentLabel = new JLabel("Current:  (none)");
        currentLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        currentLabel.setForeground(Color.RED);

        // ── Info label at the bottom ─────────────────────────────────────────
        JLabel infoLabel = new JLabel(
                "Try the text field, checkbox, combo box, slider, and button inside the blue region.");
        infoLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
        infoLabel.setForeground(Color.DARK_GRAY);

        // ── Current / previous summary panel ─────────────────────────────────
        JPanel displayPanel = new JPanel(new GridLayout(3, 1, 4, 4));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        displayPanel.add(currentLabel);
        displayPanel.add(previousLabel);
        displayPanel.add(infoLabel);

        // ── Detail panel for the generated event object ──────────────────────
        detailArea = new JTextArea();
        detailArea.setEditable(false);
        detailArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        detailArea.setText("Interact with the components on the left to inspect the latest event object.");

        JScrollPane detailScrollPane = new JScrollPane(detailArea);
        detailScrollPane.setBorder(BorderFactory.createTitledBorder("Detailed Event Object"));

        JPanel leftPanel = new JPanel(new BorderLayout(0, 8));
        leftPanel.add(eventPanel, BorderLayout.CENTER);
        leftPanel.add(displayPanel, BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, detailScrollPane);
        splitPane.setResizeWeight(0.62);
        splitPane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        frame.setLayout(new BorderLayout());
        frame.add(splitPane, BorderLayout.CENTER);

        registerSharedInputListeners(eventPanel);

        frame.setVisible(true);
        splitPane.setDividerLocation(610);
        eventPanel.requestFocusInWindow();
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private static JPanel buildTargetPanel() {
        JPanel eventPanel = new JPanel(new GridBagLayout());
        eventPanel.setName("Target Region");
        eventPanel.setFocusable(true);
        eventPanel.setBackground(new Color(230, 240, 255));
        eventPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Interaction Playground"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(6, 6, 6, 6);

        JLabel instructions = new JLabel(
                "Click the controls below, type in the field, and drag the slider to see different event objects.");
        instructions.setName("Instructions Label");
        eventPanel.add(instructions, gbc);

        JPanel topRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        topRow.setName("Top Control Row");
        topRow.setOpaque(false);

        JButton actionButton = new JButton("Action Button");
        actionButton.setName("Action Button");

        JCheckBox checkBox = new JCheckBox("Enable option");
        checkBox.setName("Example Check Box");
        checkBox.setOpaque(false);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{
                "Choice 1", "Choice 2", "Choice 3", "Choice 4"
        });
        comboBox.setName("Example Combo Box");

        topRow.add(actionButton);
        topRow.add(checkBox);
        topRow.add(comboBox);

        gbc.gridy++;
        eventPanel.add(topRow, gbc);

        JPanel textRow = new JPanel(new BorderLayout(8, 0));
        textRow.setName("Text Field Row");
        textRow.setOpaque(false);

        JLabel textLabel = new JLabel("Text field:");
        textLabel.setName("Text Field Label");

        JTextField textField = new JTextField("Type here and press Enter", 22);
        textField.setName("Example Text Field");

        textRow.add(textLabel, BorderLayout.WEST);
        textRow.add(textField, BorderLayout.CENTER);

        gbc.gridy++;
        eventPanel.add(textRow, gbc);

        JPanel sliderRow = new JPanel(new BorderLayout(8, 0));
        sliderRow.setName("Slider Row");
        sliderRow.setOpaque(false);

        JLabel sliderLabel = new JLabel("Slider:");
        sliderLabel.setName("Slider Label");

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 40);
        slider.setName("Example Slider");
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel sliderValueLabel = new JLabel("40");
        sliderValueLabel.setName("Slider Value Label");
        sliderValueLabel.setPreferredSize(new Dimension(40, 20));

        sliderRow.add(sliderLabel, BorderLayout.WEST);
        sliderRow.add(slider, BorderLayout.CENTER);
        sliderRow.add(sliderValueLabel, BorderLayout.EAST);

        gbc.gridy++;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        eventPanel.add(sliderRow, gbc);

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logEvent("Action PERFORMED on " + componentName(actionButton), e);
            }
        });

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                logEvent("Item STATE CHANGED on " + componentName(checkBox)
                        + " -> " + itemStateName(e.getStateChange()), e);
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selection = comboBox.getSelectedItem();
                logEvent("Action PERFORMED on " + componentName(comboBox)
                        + " -> selected \"" + selection + "\"", e);
            }
        });

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                logEvent("Item STATE CHANGED on " + componentName(comboBox)
                        + " -> " + itemStateName(e.getStateChange()) + " \"" + e.getItem() + "\"", e);
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logEvent("Action PERFORMED on " + componentName(textField)
                        + " -> submitted \"" + textField.getText() + "\"", e);
            }
        });

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderValueLabel.setText(String.valueOf(slider.getValue()));
                logEvent("State CHANGED on " + componentName(slider)
                        + " -> value=" + slider.getValue()
                        + (slider.getValueIsAdjusting() ? " (adjusting)" : ""), e);
            }
        });

        return eventPanel;
    }

    private static void registerSharedInputListeners(final JPanel eventPanel) {
        MouseAdapter sharedMouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusForEventSource(e);
                String btn = buttonName(e.getButton());
                logEvent("Mouse PRESSED  [" + btn + "] on " + componentName(e.getComponent())
                        + " at (" + e.getX() + ", " + e.getY() + ")", e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                String btn = buttonName(e.getButton());
                logEvent("Mouse RELEASED [" + btn + "] on " + componentName(e.getComponent())
                        + " at (" + e.getX() + ", " + e.getY() + ")", e);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String btn = buttonName(e.getButton());
                logEvent("Mouse CLICKED  [" + btn + "] on " + componentName(e.getComponent())
                        + " x" + e.getClickCount() + " at (" + e.getX() + ", " + e.getY() + ")", e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getComponent() == eventPanel) {
                    eventPanel.setBackground(new Color(200, 230, 255));
                }
                logEvent("Mouse ENTERED  " + componentName(e.getComponent()), e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getComponent() == eventPanel) {
                    eventPanel.setBackground(new Color(230, 240, 255));
                }
                logEvent("Mouse EXITED   " + componentName(e.getComponent()), e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                logEvent("Mouse MOVED    on " + componentName(e.getComponent())
                        + " at (" + e.getX() + ", " + e.getY() + ")", e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                logEvent("Mouse DRAGGED  on " + componentName(e.getComponent())
                        + " at (" + e.getX() + ", " + e.getY() + ")", e);
            }
        };

        KeyAdapter sharedKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                logEvent("Key PRESSED    [" + keyDescription(e) + "] on " + componentName((Component) e.getSource()), e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                logEvent("Key RELEASED   [" + keyDescription(e) + "] on " + componentName((Component) e.getSource()), e);
            }

            @Override
            public void keyTyped(KeyEvent e) {
                logEvent("Key TYPED      '" + displayKeyChar(e.getKeyChar()) + "' on "
                        + componentName((Component) e.getSource()), e);
            }
        };

        installListenersRecursively(eventPanel, sharedMouseListener, sharedKeyListener);
    }

    private static void installListenersRecursively(Component component,
                                                    MouseAdapter mouseListener,
                                                    KeyAdapter keyListener) {
        component.addMouseListener(mouseListener);
        component.addMouseMotionListener(mouseListener);
        component.addKeyListener(keyListener);

        if (component instanceof JPanel) {
            component.setFocusable(true);
        }

        if (component instanceof Container) {
            Component[] children = ((Container) component).getComponents();
            for (int i = 0; i < children.length; i++) {
                installListenersRecursively(children[i], mouseListener, keyListener);
            }
        }
    }

    private static void requestFocusForEventSource(MouseEvent e) {
        Component source = e.getComponent();
        if (source != null && source.isFocusable()) {
            source.requestFocusInWindow();
        }
    }

    /** Shifts current → previous, sets new current, then refreshes labels. */
    private static void logEvent(String description, EventObject event) {
        previousEvent = currentEvent;
        currentEvent  = description;

        previousLabel.setText("Previous: " + previousEvent);
        currentLabel .setText("Current:  " + currentEvent);
        detailArea.setText(buildEventDetails(description, event));
        detailArea.setCaretPosition(0);
    }

    /** Returns a human-readable mouse button name. */
    private static String buttonName(int button) {
        switch (button) {
            case MouseEvent.NOBUTTON: return "NONE";
            case MouseEvent.BUTTON1: return "LEFT";
            case MouseEvent.BUTTON2: return "MIDDLE";
            case MouseEvent.BUTTON3: return "RIGHT";
            default:                 return "BUTTON" + button;
        }
    }

    /**
     * Returns a readable description for a key event:
     * uses the key text (e.g. "A", "Space", "Enter", "Up") and notes
     * any active modifiers (Shift, Ctrl, Alt).
     */
    private static String keyDescription(KeyEvent e) {
        String key  = KeyEvent.getKeyText(e.getKeyCode());
        String mods = KeyEvent.getModifiersExText(e.getModifiersEx());
        return mods.isEmpty() ? key : mods + "+" + key;
    }

    private static String buildEventDetails(String description, EventObject event) {
        StringBuilder details = new StringBuilder();
        details.append("Summary:\n");
        details.append(description).append("\n\n");

        if (event == null) {
            details.append("No event object has been captured yet.\n");
            details.append("Use the controls in the target region to populate this panel.");
            return details.toString();
        }

        details.append("Raw event object:\n");
        details.append(event).append("\n\n");

        details.append("Event class: ").append(event.getClass().getName()).append("\n");
        details.append("Source: ").append(describeSource(event.getSource())).append("\n");

        if (event instanceof AWTEvent) {
            AWTEvent awtEvent = (AWTEvent) event;
            details.append("Event id: ").append(awtEvent.getID()).append("\n");
        }

        if (event instanceof InputEvent) {
            InputEvent inputEvent = (InputEvent) event;
            String modifiers = InputEvent.getModifiersExText(inputEvent.getModifiersEx());
            details.append("When: ").append(inputEvent.getWhen()).append("\n");
            details.append("Modifiers: ").append(modifiers.isEmpty() ? "(none)" : modifiers).append("\n");
            details.append("Consumed: ").append(inputEvent.isConsumed()).append("\n");
        }

        if (event instanceof MouseEvent) {
            MouseEvent mouseEvent = (MouseEvent) event;
            details.append("Mouse position: (").append(mouseEvent.getX()).append(", ")
                    .append(mouseEvent.getY()).append(")\n");
            details.append("Screen position: (").append(mouseEvent.getXOnScreen()).append(", ")
                    .append(mouseEvent.getYOnScreen()).append(")\n");
            details.append("Button: ").append(buttonName(mouseEvent.getButton())).append("\n");
            details.append("Click count: ").append(mouseEvent.getClickCount()).append("\n");
        }

        if (event instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) event;
            details.append("Key code: ").append(keyEvent.getKeyCode()).append("\n");
            if (keyEvent.getKeyCode() == KeyEvent.VK_UNDEFINED) {
                details.append("Key text: (undefined for KEY_TYPED)\n");
            } else {
                details.append("Key text: ").append(KeyEvent.getKeyText(keyEvent.getKeyCode())).append("\n");
            }
            details.append("Key char: ").append(displayKeyChar(keyEvent.getKeyChar())).append("\n");
        }

        if (event instanceof ActionEvent) {
            ActionEvent actionEvent = (ActionEvent) event;
            details.append("Action command: ").append(actionEvent.getActionCommand()).append("\n");
            details.append("When: ").append(actionEvent.getWhen()).append("\n");
        }

        if (event instanceof ItemEvent) {
            ItemEvent itemEvent = (ItemEvent) event;
            details.append("Item: ").append(itemEvent.getItem()).append("\n");
            details.append("State change: ").append(itemStateName(itemEvent.getStateChange())).append("\n");
        }

        if (event instanceof ChangeEvent) {
            ChangeEvent changeEvent = (ChangeEvent) event;
            if (changeEvent.getSource() instanceof JSlider) {
                JSlider slider = (JSlider) changeEvent.getSource();
                details.append("Slider value: ").append(slider.getValue()).append("\n");
                details.append("Value adjusting: ").append(slider.getValueIsAdjusting()).append("\n");
            }
        }

        return details.toString();
    }

    private static String describeSource(Object source) {
        if (source instanceof Component) {
            Component component = (Component) source;
            String name = component.getName();
            String className = component.getClass().getSimpleName();
            if (name == null || name.trim().isEmpty()) {
                return className;
            }
            return className + " [" + name + "]";
        }

        if (source == null) {
            return "(null)";
        }

        return source.getClass().getName() + " [" + source + "]";
    }

    private static String componentName(Component component) {
        if (component == null) {
            return "(unknown component)";
        }

        String name = component.getName();
        if (name == null || name.trim().isEmpty()) {
            return component.getClass().getSimpleName();
        }
        return name;
    }

    private static String itemStateName(int stateChange) {
        if (stateChange == ItemEvent.SELECTED) {
            return "SELECTED";
        }
        if (stateChange == ItemEvent.DESELECTED) {
            return "DESELECTED";
        }
        return "STATE=" + stateChange;
    }

    private static String displayKeyChar(char keyChar) {
        switch (keyChar) {
            case KeyEvent.CHAR_UNDEFINED: return "(undefined)";
            case '\n': return "\\n";
            case '\t': return "\\t";
            case '\b': return "\\b";
            case ' ': return "(space)";
            default: return String.valueOf(keyChar);
        }
    }
}
