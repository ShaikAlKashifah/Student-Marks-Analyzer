import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class LoginPage {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private HashMap<String, String> userDatabase = new HashMap<>();

    public LoginPage() {
        frame = new JFrame("Login - Student Marks Analyzer");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(240, 248, 255)); // Light blue

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Welcome! Please Log In or Sign Up");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(33, 33, 99));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Sign In");
        JButton signupButton = new JButton("Sign Up");

        loginButton.setBackground(new Color(144, 238, 144));
        signupButton.setBackground(new Color(255, 182, 193));

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        frame.add(titleLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        frame.add(userLabel, gbc); gbc.gridx = 1;
        frame.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy++;
        frame.add(passLabel, gbc); gbc.gridx = 1;
        frame.add(passwordField, gbc);

        gbc.gridy++; gbc.gridx = 0;
        frame.add(loginButton, gbc); gbc.gridx = 1;
        frame.add(signupButton, gbc);

        loginButton.addActionListener(e -> signIn());
        signupButton.addActionListener(e -> signUp());

        // Add a default user for testing
        userDatabase.put("admin", "Admin@123");

        frame.setVisible(true);
    }

    private void signIn() {
        String user = usernameField.getText().trim();
        String pass = new String(passwordField.getPassword());

        if (userDatabase.containsKey(user) && userDatabase.get(user).equals(pass)) {
            JOptionPane.showMessageDialog(frame, "Login Successful!");
            frame.dispose();
            new StudentAnalyzerUI(); // open main app
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void signUp() {
        JTextField newUser = new JTextField();
        JPasswordField newPass = new JPasswordField();

        Object[] inputs = {
            "Enter New Username:", newUser,
            "Enter New Password:", newPass,
            "\nPassword must be at least 6 characters,\ncontain a capital letter and a special character."
        };

        int option = JOptionPane.showConfirmDialog(frame, inputs, "Create New Account", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = newUser.getText().trim();
            String password = new String(newPass.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!isValidPassword(password)) {
                JOptionPane.showMessageDialog(frame, "Password doesn't meet the criteria!", "Invalid Password", JOptionPane.WARNING_MESSAGE);
            } else if (userDatabase.containsKey(username)) {
                JOptionPane.showMessageDialog(frame, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                userDatabase.put(username, password);
                JOptionPane.showMessageDialog(frame, "Account created successfully! You can now log in.");
            }
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
