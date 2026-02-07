import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StudentAnalyzerUI {
    private JFrame frame;
    private JTextField nameField, usnField;
    private JTextField ccField, mlField, ajavaField, electiveField, devopsField;
    private JTextArea outputArea;
    private StudentManager manager = new StudentManager();

    public StudentAnalyzerUI() {
        frame = new JFrame("🎓 Student Marks Analyzer");
        frame.setSize(700, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(245, 255, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        nameField = new JTextField(15);
        usnField = new JTextField(15);
        ccField = new JTextField(5);        // Cloud Computing
        mlField = new JTextField(5);        // Machine Learning
        ajavaField = new JTextField(5);     // Advanced Java
        electiveField = new JTextField(5);  // Open Elective
        devopsField = new JTextField(5);    // DevOps

        outputArea = new JTextArea(15, 45);
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(255, 250, 240));
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JLabel titleLabel = new JLabel("STUDENT MARK ENTRY");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(33, 33, 99));

        JLabel markLabel = new JLabel("Enter Marks (out of 100)");
        markLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        markLabel.setForeground(new Color(60, 90, 100));

        JButton addButton = new JButton("Add Student");
        JButton showButton = new JButton("Show Report");
        JButton deleteButton = new JButton("Delete by USN");
        JButton searchButton = new JButton("Search by USN");

        addButton.setBackground(new Color(102, 205, 170));
        showButton.setBackground(new Color(176, 196, 222));
        deleteButton.setBackground(new Color(255, 160, 122));
        searchButton.setBackground(new Color(255, 222, 173));

        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2;
        frame.add(titleLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        frame.add(new JLabel("Name:"), gbc); gbc.gridx = 2;
        frame.add(nameField, gbc);

        gbc.gridx = 1; gbc.gridy++;
        frame.add(new JLabel("USN:"), gbc); gbc.gridx = 2;
        frame.add(usnField, gbc);

        gbc.gridx = 1; gbc.gridy++;
        gbc.gridwidth = 2;
        frame.add(markLabel, gbc);

        gbc.gridwidth = 1; gbc.gridy++;
        gbc.gridx = 1; frame.add(new JLabel("Cloud Computing:"), gbc); gbc.gridx = 2; frame.add(ccField, gbc);
        gbc.gridy++; gbc.gridx = 1; frame.add(new JLabel("Machine Learning:"), gbc); gbc.gridx = 2; frame.add(mlField, gbc);
        gbc.gridy++; gbc.gridx = 1; frame.add(new JLabel("Advanced Java:"), gbc); gbc.gridx = 2; frame.add(ajavaField, gbc);
        gbc.gridy++; gbc.gridx = 1; frame.add(new JLabel("Open Elective:"), gbc); gbc.gridx = 2; frame.add(electiveField, gbc);
        gbc.gridy++; gbc.gridx = 1; frame.add(new JLabel("DevOps:"), gbc); gbc.gridx = 2; frame.add(devopsField, gbc);

        gbc.gridy++; gbc.gridx = 1;
        frame.add(addButton, gbc); gbc.gridx = 2;
        frame.add(showButton, gbc);

        gbc.gridy++; gbc.gridx = 1;
        frame.add(deleteButton, gbc); gbc.gridx = 2;
        frame.add(searchButton, gbc);

        gbc.gridy++; gbc.gridx = 0; gbc.gridwidth = 3;
        frame.add(new JScrollPane(outputArea), gbc);

        addButton.addActionListener(e -> addStudent());
        showButton.addActionListener(e -> showReport());
        deleteButton.addActionListener(e -> deleteStudent());
        searchButton.addActionListener(e -> searchStudent());

        frame.setVisible(true);
    }

    private void addStudent() {
        try {
            String name = nameField.getText().trim();
            String usn = usnField.getText().trim();
            if (name.isEmpty() || usn.isEmpty()) {
                outputArea.setText("⚠️ Name and USN cannot be empty.");
                return;
            }

            LinkedHashMap<String, Integer> marks = new LinkedHashMap<>();
            marks.put("Cloud Computing", Integer.parseInt(ccField.getText().trim()));
            marks.put("Machine Learning", Integer.parseInt(mlField.getText().trim()));
            marks.put("Advanced Java", Integer.parseInt(ajavaField.getText().trim()));
            marks.put("Open Elective", Integer.parseInt(electiveField.getText().trim()));
            marks.put("DevOps", Integer.parseInt(devopsField.getText().trim()));

            Student s = new Student(name, usn, marks);
            manager.addStudent(s);
            outputArea.setText("✅ Student added successfully!");
            clearFields();
        } catch (NumberFormatException ex) {
            outputArea.setText("⚠️ Please enter valid integer marks.");
        }
    }

    private void showReport() {
        outputArea.setText(manager.getStudentReport());
    }

    private void deleteStudent() {
        String usn = JOptionPane.showInputDialog(frame, "Enter USN to delete:");
        if (usn != null && !usn.trim().isEmpty()) {
            boolean removed = manager.deleteStudentByUsn(usn.trim());
            outputArea.setText(removed ? "🗑️ Student deleted successfully." : "❌ USN not found.");
        }
    }

    private void searchStudent() {
        String usn = JOptionPane.showInputDialog(frame, "Enter USN to search:");
        if (usn != null && !usn.trim().isEmpty()) {
            Student s = manager.getStudentByUsn(usn.trim());
            if (s != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("🎓 Student Found!\n")
                  .append("Name: ").append(s.getName()).append("\n")
                  .append("USN: ").append(s.getUsn()).append("\n")
                  .append("Marks:\n");
                for (Map.Entry<String, Integer> entry : s.getSubjectMarks().entrySet()) {
                    sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                }
                sb.append("Average: ").append(String.format("%.2f", s.getAverage())).append("\n")
                  .append("Highest: ").append(s.getHighestMark()).append("\n")
                  .append("Lowest: ").append(s.getLowestMark()).append("\n");

                outputArea.setText(sb.toString());
            } else {
                outputArea.setText("❌ No student found with USN: " + usn);
            }
        }
    }

    private void clearFields() {
        nameField.setText(""); usnField.setText("");
        ccField.setText(""); mlField.setText(""); ajavaField.setText("");
        electiveField.setText(""); devopsField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentAnalyzerUI::new);
    }
}
