import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentRegistrationLogin extends JFrame implements ActionListener {
    // GUI Components
    private JTextField nameField, emailField, passwordField;
    private JButton registerButton, loginButton;
    private JTextField loginEmailField, loginPasswordField;
    
    // Database connection
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root"; // Update with your database username
    private static final String PASSWORD = "password"; // Update with your database password

    // Constructor
    public StudentRegistrationLogin() {
        setTitle("Student Registration and Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        // Registration Panel
        JPanel registrationPanel = new JPanel(new GridLayout(4, 2));
        registrationPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        registrationPanel.add(nameField);
        
        registrationPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        registrationPanel.add(emailField);
        
        registrationPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        registrationPanel.add(passwordField);
        
        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registrationPanel.add(registerButton);
        
        add(registrationPanel, "Registration");

        // Login Panel
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Email:"));
        loginEmailField = new JTextField();
        loginPanel.add(loginEmailField);
        
        loginPanel.add(new JLabel("Password:"));
        loginPasswordField = new JPasswordField();
        loginPanel.add(loginPasswordField);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);
        
        add(loginPanel, "Login");
        
        // Switch to Login Panel by default
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.show(getContentPane(), "Login");
    }

    // Action handling for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            registerStudent();
        } else if (e.getSource() == loginButton) {
            loginStudent();
        }
    }

    // Register student in the database
    private void registerStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO students (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Registration Failed: " + ex.getMessage());
        }
    }

    // Login student from the database
    private void loginStudent() {
        String email = loginEmailField.getText();
        String password = loginPasswordField.getText();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM students WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + resultSet.getString("name"));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid email or password!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Login Failed: " + ex.getMessage());
        }
    }

    // Clear input fields
    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        loginEmailField.setText("");
        loginPasswordField.setText("");
    }

    // Main method to run the program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentRegistrationLogin app = new StudentRegistrationLogin();
            app.setVisible(true);
        });
    }
}
