import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    String name;
    String rollNo;
    int marks;

    public Student(String name, String rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Marks: " + marks;
    }
}

public class StudentMarksAnalyzer extends JFrame {
    ArrayList<Student> students = new ArrayList<>();

    JTextField nameField, rollField, marksField, searchField;
    JTextArea outputArea;

    public StudentMarksAnalyzer() {
        setTitle("Student Marks Analyzer - Swing Version");
        setSize(600, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Input fields
        add(new JLabel("Name:"));
        nameField = new JTextField(10); add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField(10); add(rollField);

        add(new JLabel("Marks:"));
        marksField = new JTextField(5); add(marksField);

        JButton addBtn = new JButton("Add Student");
        add(addBtn);
        addBtn.addActionListener(e -> addStudent());

        JButton showBtn = new JButton("Show All");
        add(showBtn);
        showBtn.addActionListener(e -> showAll());

        JButton statsBtn = new JButton("Show Stats");
        add(statsBtn);
        statsBtn.addActionListener(e -> showStats());

        // Search
        add(new JLabel("Search Name/Roll:"));
        searchField = new JTextField(10); add(searchField);

        JButton searchBtn = new JButton("Search");
        add(searchBtn);
        searchBtn.addActionListener(e -> searchStudent());

        // Output area
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        setVisible(true);
    }

    void addStudent() {
        String name = nameField.getText().trim();
        String roll = rollField.getText().trim();
        int marks;

        try {
            marks = Integer.parseInt(marksField.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid integer for marks");
            return;
        }

        if (name.isEmpty() || roll.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Roll No can't be empty");
            return;
        }

        students.add(new Student(name, roll, marks));
        outputArea.setText("Student added.\n");
        nameField.setText("");
        rollField.setText("");
        marksField.setText("");
    }

    void showAll() {
        StringBuilder sb = new StringBuilder("All Students:\n");
        for (Student s : students) sb.append(s).append("\n");
        outputArea.setText(sb.toString());
    }

    void showStats() {
        if (students.isEmpty()) {
            outputArea.setText("No student records available.");
            return;
        }

        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (Student s : students) {
            sum += s.marks;
            if (s.marks > max) max = s.marks;
            if (s.marks < min) min = s.marks;
        }

        double avg = (double) sum / students.size();
        outputArea.setText("Statistics:\n");
        outputArea.append("Average Marks: " + avg + "\n");
        outputArea.append("Highest Marks: " + max + "\n");
        outputArea.append("Lowest Marks: " + min + "\n");
    }

    void searchStudent() {
        String query = searchField.getText().trim().toLowerCase();
        for (Student s : students) {
            if (s.name.toLowerCase().equals(query) || s.rollNo.toLowerCase().equals(query)) {
                outputArea.setText("Student Found:\n" + s);
                return;
            }
        }
        outputArea.setText("No matching student found.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentMarksAnalyzer());
    }
}