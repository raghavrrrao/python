import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class game extends JFrame implements ActionListener {
    private JLabel instructionLabel;
    private JTextField guessInput;
    private JButton guessButton;
    private JTextArea resultTextArea;
    private int secretNumber;
    private int attempts;
    private boolean gameEnded;

    public game() {
        setTitle("Number Guessing Game");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();

        secretNumber = new Random().nextInt(100) + 1;
        attempts = 0;
        gameEnded = false;
    }

    private void initComponents() {
        instructionLabel = new JLabel("I'm thinking of a number between 1 and 100. Take a guess:");
        guessInput = new JTextField(10);
        guessButton = new JButton("Guess");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        guessButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(instructionLabel);
        panel.add(guessInput);
        panel.add(guessButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
    }

    private void endGame() {
        gameEnded = true;
        guessButton.setEnabled(false);
        guessInput.setEditable(false);

        // Add fade-in animation to the resultTextArea
        new Thread(() -> {
            for (float alpha = 0; alpha <= 1; alpha += 0.05f) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resultTextArea.setBackground(new Color(1f, 1f, 1f, alpha));
                resultTextArea.repaint();
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameEnded) return;

        int guess = 0;
        try {
            guess = Integer.parseInt(guessInput.getText());
        } catch (NumberFormatException ex) {
            resultTextArea.append("Invalid input. Please enter a valid number.\n");
            guessInput.setText("");
            return;
        }

        attempts++;

        if (guess < secretNumber) {
            resultTextArea.append("Too low! Try again.\n");
        } else if (guess > secretNumber) {
            resultTextArea.append("Too high! Try again.\n");
        } else {
            resultTextArea.append("Congratulations! You guessed the number " + secretNumber + " in " + attempts + " attempts.\n");
            endGame();
            return;
        }

        guessInput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            new game().setVisible(true);
        });
    }
}

//this is a comment for feature_branch
