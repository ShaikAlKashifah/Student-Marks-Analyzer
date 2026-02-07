import java.util.*;

public class Student {
    private String name;
    private String usn;
    private LinkedHashMap<String, Integer> subjectMarks;

    public Student(String name, String usn, LinkedHashMap<String, Integer> subjectMarks) {
        this.name = name;
        this.usn = usn;
        this.subjectMarks = subjectMarks;
    }

    public String getName() {
        return name;
    }

    public String getUsn() {
        return usn;
    }

    public LinkedHashMap<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public double getAverage() {
        int total = 0;
        for (int mark : subjectMarks.values()) {
            total += mark;
        }
        return total / (double) subjectMarks.size();
    }

    public int getHighestMark() {
        return Collections.max(subjectMarks.values());
    }

    public int getLowestMark() {
        return Collections.min(subjectMarks.values());
    }
}
