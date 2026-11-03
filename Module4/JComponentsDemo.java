package Module4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class JComponentsDemo extends JFrame {

    public JComponentsDemo() {
        setTitle("JComponents Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);

        // ── Menu Bar ──────────────────────────────────────────────────────────
        JMenuBar menuBar = new JMenuBar();
        menuBar.setToolTipText("JMenuBar – the application's top-level menu bar");

        JMenu fileMenu = new JMenu("File");
        fileMenu.setToolTipText("JMenu – a top-level menu that holds menu items");
        JMenuItem newItem = new JMenuItem("New");
        newItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setToolTipText("JMenuItem – closes the application");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setToolTipText("JMenu – edit operations menu");
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setToolTipText("JMenu – help and information menu");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setToolTipText("JMenuItem – a clickable item inside a menu");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // ── Tabbed Pane (top-level container) ────────────────────────────────
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setToolTipText("JTabbedPane – organizes content into named tabs");

        // ── Tab 1: Basic Controls ─────────────────────────────────────────────
        JPanel basicPanel = new JPanel(new GridBagLayout());
        basicPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setToolTipText("JLabel – displays non-editable text or an image");
        gbc.gridx = 0; gbc.gridy = 0;
        basicPanel.add(nameLabel, gbc);

        // TextField
        JTextField textField = new JTextField("Type here…", 18);
        textField.setToolTipText("JTextField – a single-line text input field");
        gbc.gridx = 1; gbc.gridy = 0;
        basicPanel.add(textField, gbc);

        // Button
        JButton button = new JButton("Click Me");
        button.setToolTipText("JButton – a clickable button that triggers an action");
        button.addActionListener(e ->
            JOptionPane.showMessageDialog(this, "TextField says: " + textField.getText()));
        gbc.gridx = 2; gbc.gridy = 0;
        basicPanel.add(button, gbc);

        // ComboBox
        JLabel comboLabel = new JLabel("Combo:");
        comboLabel.setToolTipText("JLabel – label for the combo box below");
        gbc.gridx = 0; gbc.gridy = 1;
        basicPanel.add(comboLabel, gbc);
        String[] comboItems = {"Option A", "Option B", "Option C", "Option D"};
        JComboBox<String> comboBox = new JComboBox<>(comboItems);
        comboBox.setToolTipText("JComboBox – a drop-down list for selecting one option");
        gbc.gridx = 1; gbc.gridy = 1;
        basicPanel.add(comboBox, gbc);

        // Slider
        JLabel sliderLabel = new JLabel("Slider:");
        sliderLabel.setToolTipText("JLabel – label for the slider below");
        gbc.gridx = 0; gbc.gridy = 2;
        basicPanel.add(sliderLabel, gbc);
        JSlider slider = new JSlider(0, 100, 40);
        slider.setToolTipText("JSlider – a draggable knob for selecting a numeric value in a range");
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2;
        basicPanel.add(slider, gbc);
        gbc.gridwidth = 1;

        // Progress Bar (driven by slider)
        JLabel progressLabel = new JLabel("Progress:");
        progressLabel.setToolTipText("JLabel – label for the progress bar below");
        gbc.gridx = 0; gbc.gridy = 3;
        basicPanel.add(progressLabel, gbc);
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setToolTipText("JProgressBar – shows completion of a task as a filled bar");
        progressBar.setValue(slider.getValue());
        progressBar.setStringPainted(true);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2;
        basicPanel.add(progressBar, gbc);
        gbc.gridwidth = 1;
        slider.addChangeListener(e -> progressBar.setValue(slider.getValue()));

        // Text Area
        JLabel notesLabel = new JLabel("Notes:");
        notesLabel.setToolTipText("JLabel – label for the text area below");
        gbc.gridx = 0; gbc.gridy = 4;
        basicPanel.add(notesLabel, gbc);
        JTextArea textArea = new JTextArea(4, 20);
        textArea.setToolTipText("JTextArea – a multi-line text editing area");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane textAreaScroll = new JScrollPane(textArea);
        textAreaScroll.setToolTipText("JScrollPane – adds scroll bars to a component that may overflow");
        gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 2;
        basicPanel.add(textAreaScroll, gbc);
        gbc.gridwidth = 1;

        // List
        JLabel listLabel = new JLabel("List:");
        listLabel.setToolTipText("JLabel – label for the list below");
        gbc.gridx = 0; gbc.gridy = 5;
        basicPanel.add(listLabel, gbc);
        String[] listItems = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        JList<String> list = new JList<>(listItems);
        list.setToolTipText("JList – a scrollable list of selectable items");
        list.setVisibleRowCount(4);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroll = new JScrollPane(list);
        listScroll.setToolTipText("JScrollPane – adds scroll bars to the JList");
        gbc.gridx = 1; gbc.gridy = 5; gbc.gridwidth = 2;
        basicPanel.add(listScroll, gbc);
        gbc.gridwidth = 1;

        tabbedPane.addTab("Basic Controls", basicPanel);

        // ── Tab 2: Table & Tree (Split Pane) ─────────────────────────────────
        // Tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Animals");
        DefaultMutableTreeNode mammals = new DefaultMutableTreeNode("Mammals");
        mammals.add(new DefaultMutableTreeNode("Dog"));
        mammals.add(new DefaultMutableTreeNode("Cat"));
        mammals.add(new DefaultMutableTreeNode("Horse"));
        DefaultMutableTreeNode birds = new DefaultMutableTreeNode("Birds");
        birds.add(new DefaultMutableTreeNode("Eagle"));
        birds.add(new DefaultMutableTreeNode("Parrot"));
        root.add(mammals);
        root.add(birds);
        JTree tree = new JTree(root);
        tree.setToolTipText("JTree – displays hierarchical data as an expandable/collapsible tree");
        JScrollPane treeScroll = new JScrollPane(tree);
        treeScroll.setToolTipText("JScrollPane – adds scroll bars to the JTree");
        treeScroll.setBorder(BorderFactory.createTitledBorder("Tree"));

        // Table
        String[] columns = {"ID", "Name", "Score"};
        Object[][] data = {
            {1, "Alice", 95},
            {2, "Bob",   82},
            {3, "Carol", 78},
            {4, "Dave",  91},
            {5, "Eve",   88},
        };
        JTable table = new JTable(new DefaultTableModel(data, columns));
        table.setToolTipText("JTable – displays data in rows and columns, like a spreadsheet");
        table.setFillsViewportHeight(true);
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setToolTipText("JScrollPane – adds scroll bars to the JTable");
        tableScroll.setBorder(BorderFactory.createTitledBorder("Table"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, tableScroll);
        splitPane.setToolTipText("JSplitPane – divides two components with a draggable divider");
        splitPane.setDividerLocation(200);
        splitPane.setResizeWeight(0.3);

        tabbedPane.addTab("Table & Tree", splitPane);

        // ── Tab 3: Choosers ───────────────────────────────────────────────────
        JPanel chooserPanel = new JPanel(new GridLayout(1, 2, 8, 8));
        chooserPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // File Chooser (embedded preview panel + launch button)
        JPanel fileChooserPanel = new JPanel(new BorderLayout());
        fileChooserPanel.setBorder(BorderFactory.createTitledBorder("File Chooser"));
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setControlButtonsAreShown(false);
        JLabel fileLabel = new JLabel("No file selected.", SwingConstants.CENTER);
        fileLabel.setToolTipText("JLabel – shows the path of the file chosen below");
        JButton fileLaunchBtn = new JButton("Choose File…");
        fileLaunchBtn.setToolTipText("JButton – opens a JFileChooser dialog to pick a file");
        fileLaunchBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            fc.setToolTipText("JFileChooser – a dialog for browsing and selecting files or directories");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                fileLabel.setText(fc.getSelectedFile().getAbsolutePath());
        });
        fileChooserPanel.add(fileLabel, BorderLayout.CENTER);
        fileChooserPanel.add(fileLaunchBtn, BorderLayout.SOUTH);

        // Color Chooser
        JPanel colorChooserPanel = new JPanel(new BorderLayout());
        colorChooserPanel.setBorder(BorderFactory.createTitledBorder("Color Chooser"));
        JColorChooser colorChooser = new JColorChooser(Color.CYAN);
        colorChooser.setToolTipText("JColorChooser – a panel for visually selecting a color");
        JPanel colorPreview = new JPanel();
        colorPreview.setToolTipText("JPanel – a generic container; here used as a color preview swatch");
        colorPreview.setPreferredSize(new Dimension(80, 40));
        colorPreview.setBackground(Color.CYAN);
        colorPreview.setBorder(BorderFactory.createTitledBorder("Preview"));
        colorChooser.getSelectionModel().addChangeListener(
            e -> colorPreview.setBackground(colorChooser.getColor()));
        colorChooserPanel.add(colorChooser, BorderLayout.CENTER);
        colorChooserPanel.add(colorPreview, BorderLayout.SOUTH);

        chooserPanel.add(fileChooserPanel);
        chooserPanel.add(colorChooserPanel);

        tabbedPane.addTab("Choosers", chooserPanel);

        add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JComponentsDemo::new);
    }
}
