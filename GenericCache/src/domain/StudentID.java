package domain;

import java.util.Objects;

public class StudentID implements ID {
    private final String studentID;

    public StudentID(String studentID) {
        this.studentID = studentID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentID)) return false;
        StudentID studentID1 = (StudentID) o;
        return Objects.equals(studentID, studentID1.studentID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID);
    }
}
