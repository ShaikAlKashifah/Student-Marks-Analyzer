import java.util.*;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student s) {
        studentList.add(s);
    }

    public boolean deleteStudentByUsn(String usn) {
        return studentList.removeIf(s -> s.getUsn().equalsIgnoreCase(usn));
    }

    public Student getStudentByUsn(String usn) {
        for (Student s : studentList) {
            if (s.getUsn().equalsIgnoreCase(usn)) {
                return s;
            }
        }
        return null;
    }

    public String getStudentReport() {
        if (studentList.isEmpty()) return "No students found.";

        StringBuilder sb = new StringBuilder();
        for (Student s : studentList) {
            sb.append("Name: ").append(s.getName()).append("\n")
              .append("USN: ").append(s.getUsn()).append("\n")
              .append("Marks:\n");

            for (Map.Entry<String, Integer> entry : s.getSubjectMarks().entrySet()) {
                sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }

            sb.append("Average: ").append(String.format("%.2f", s.getAverage())).append("\n")
              .append("Highest: ").append(s.getHighestMark()).append("\n")
              .append("Lowest: ").append(s.getLowestMark()).append("\n")
              .append("------------------------------------------------\n");
        }
        return sb.toString();
    }
}
