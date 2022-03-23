import javax.swing.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        AtomicLong minNumber = new AtomicLong();
        AtomicLong maxNumber = new AtomicLong();
        AtomicLong desiredNumber = new AtomicLong();
        Random random = new Random();
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jFrame.add(jPanel);
        JLabel jLabel = new JLabel("Program view");
        JLabel jLabel1 = new JLabel("Enter range");
        JLabel jLabel2 = new JLabel("Hidden number");
        JLabel jLabel3 = new JLabel("Min");
        JLabel jLabel4 = new JLabel("Max");
        JLabel jLabel5 = new JLabel("Guessed number");
        JLabel jLabel6 = new JLabel();
        jLabel6.setBounds(425, 75, 175, 25);
        jLabel5.setBounds(450, 0, 100, 25);
        jLabel3.setBounds(125, 25, 75, 25);
        jLabel4.setBounds(125, 50, 75, 25);
        jLabel2.setBounds(300, 0, 150, 25);
        jLabel1.setBounds(164, 0, 150, 25);
        JTextField jTextField = new JTextField();
        jTextField.setBounds(150, 25, 100, 25);
        JTextField jTextField1 = new JTextField();
        jTextField1.setBounds(294, 25, 100, 25);
        JTextField jTextField2 = new JTextField();
        jTextField2.setBounds(150, 50, 100, 25);
        JTextField jTextField3 = new JTextField();
        jTextField3.setBounds(450, 25, 100, 25);
        jPanel.add(jTextField);
        jTextField.getText();
        jPanel.revalidate();
        JButton jButton = new JButton("Metal");
        jLabel.setBounds(0, 0, 100, 25);
        jButton.setBounds(0, 25, 100, 25);
        JButton jButton1 = new JButton("Nimbus");
        JButton jButton2 = new JButton("Motif");
        JButton jButton3 = new JButton("Windows");
        JButton jButton4 = new JButton("Input");
        JButton jButton5 = new JButton("Input");
        JButton jButton6 = new JButton("Input");
        jButton6.setBounds(450, 50, 100, 25);
        jButton5.setBounds(294, 50, 100, 25);
        jButton4.setBounds(150, 75, 100, 25);
        jButton.setBounds(0, 25, 100, 25);
        jButton1.setBounds(0, 50, 100, 25);
        jButton2.setBounds(0, 75, 100, 25);
        jButton3.setBounds(0, 100, 100, 25);
        jPanel.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(jButton4);
        jPanel.add(jLabel2);
        jPanel.add(jTextField1);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jTextField2);
        jPanel.add(jButton5);
        jPanel.add(jLabel5);
        jPanel.add(jTextField3);
        jPanel.add(jButton6);
        jPanel.add(jLabel6);
        jFrame.setTitle("More or less");
        jButton.addActionListener(actionEvent -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
        jButton1.addActionListener(actionEvent -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
        jButton2.addActionListener(actionEvent -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
        jButton3.addActionListener(actionEvent -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
        jButton4.addActionListener(actionEvent -> {
            minNumber.set(Long.parseLong(jTextField.getText()));
            maxNumber.set(Long.parseLong(jTextField2.getText()));
        });
        jButton5.addActionListener(actionEvent -> {
            desiredNumber.set(Long.parseLong(jTextField1.getText()));
            if (desiredNumber.get() > maxNumber.get() || desiredNumber.get() < minNumber.get()) {
                JOptionPane.showConfirmDialog(null, "You're rogue!");
            }
        });
        jButton6.addActionListener(actionEvent -> {
            int randomNumber = (int) (maxNumber.get() - random.nextInt((int) minNumber.get()));
            jLabel6.setText(randomNumber == desiredNumber.get() ? "You guessed the number!"
                    : "You not guessed the number!");
            jTextField3.setText(String.valueOf(randomNumber));
        });

    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(0, 0, 575, 225);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
