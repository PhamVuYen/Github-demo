
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayoutDemo extends JFrame{
    JRadioButton RradioButton;
    JRadioButton LradioButton;
    FlowLayout experimentLayout = new FlowLayout();
    final String Right = "Right to left";
    final String Left = "Left to right";
    JButton applyButton = new JButton("Apply component orientation.");

    public FlowLayoutDemo (String name){
        super (name);
    }
    public void addComponentToPane(final Container container){
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new FlowLayout());
        LradioButton = new JRadioButton(Left);
        LradioButton.setActionCommand(Left);
        LradioButton.setSelected(true);

        RradioButton = new JRadioButton(Right);
        RradioButton.setActionCommand(Right);

        compsToExperiment.add(new JButton("Button 1"));
        compsToExperiment.add(new JButton("Button 2"));
        compsToExperiment.add(new JButton("Button 3"));
        compsToExperiment.add(new JButton("Long_Named Button 4"));
        compsToExperiment.add(new JButton("Button 5"));
        compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        final ButtonGroup group = new ButtonGroup();
        group.add(LradioButton);
        group.add(RradioButton);
        controls.add(LradioButton);
        controls.add(RradioButton);
        controls.add(applyButton);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                if(command.equals("Left to right")){
                    compsToExperiment.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                }else{
                    compsToExperiment.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                }
                compsToExperiment.validate();
                compsToExperiment.repaint();
            }
        });
        container.add(compsToExperiment, BorderLayout.CENTER);
        container.add(controls, BorderLayout.SOUTH);
    }

    private static void createAndShowGUI(){
        FlowLayoutDemo frame = new FlowLayoutDemo("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentToPane(frame.getContentPane());
        frame.setVisible(true);
        frame.setSize(500, 550);
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plant.metal.MelLookAndFeel");
        }catch (UnsupportedLookAndFeelException ex ){
            ex.fillInStackTrace();
        }catch (IllegalAccessException ex){
            ex.fillInStackTrace();
        }catch (InstantiationException ex){
            ex.fillInStackTrace();
        }catch (ClassNotFoundException ex){
            ex.fillInStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
