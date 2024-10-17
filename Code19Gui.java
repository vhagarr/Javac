import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // GUI Components
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, equalsButton, clearButton;
    private double num1, num2, result;
    private char operator;

    // Constructor
    public Calculator() {
        // Set up the frame
        setTitle("Standard Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display field
        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        add(displayField, BorderLayout.NORTH);

        // Create buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Create operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        clearButton = new JButton("C");

        // Add action listeners for operator buttons
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        equalsButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        buttonPanel.add(clearButton);
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(divButton);
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(mulButton);
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(subButton);
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(equalsButton);
        buttonPanel.add(addButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Event handling for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numberButtons.length; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = getDisplayValue();
            operator = '+';
            displayField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = getDisplayValue();
            operator = '-';
            displayField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = getDisplayValue();
            operator = '*';
            displayField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = getDisplayValue();
            operator = '/';
            displayField.setText("");
        } else if (e.getSource() == equalsButton) {
            num2 = getDisplayValue();
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        displayField.setText("Error");
                        return;
                    }
                    break;
            }
            displayField.setText(String.valueOf(result));
        } else if (e.getSource() == clearButton) {
            displayField.setText("");
        }
    }

    // Helper method to get the current value from the display field
    private double getDisplayValue() {
        String text = displayField.getText();
        return text.isEmpty() ? 0 : Double.parseDouble(text);
    }

    // Main method to run the calculator
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
