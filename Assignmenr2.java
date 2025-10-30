package radiobuttonapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame {

    private JLabel lblImage;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup group;

    public RadioButtonDemo() {
        // Frame title
        setTitle("RadioButtonDemo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Left panel for radio buttons ---
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");

        group = new ButtonGroup();
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);

        panel.add(birdButton);
        panel.add(catButton);
        panel.add(dogButton);
        panel.add(rabbitButton);
        panel.add(pigButton);

        add(panel, BorderLayout.WEST);

        // --- Label to display image ---
        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(JLabel.CENTER);
        add(lblImage, BorderLayout.CENTER);

        // --- Add Action Listeners for each button ---
        birdButton.addActionListener(e -> showImage("bird"));
        catButton.addActionListener(e -> showImage("cat"));
        dogButton.addActionListener(e -> showImage("dog"));
        rabbitButton.addActionListener(e -> showImage("rabbit"));
        pigButton.addActionListener(e -> showImage("pig"))
