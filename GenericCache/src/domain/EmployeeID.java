package domain;

import java.util.Objects;

public class EmployeeID implements ID {
    private final String employeeID;

    public EmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeID)) return false;
        EmployeeID that = (EmployeeID) o;
        return Objects.equals(employeeID, that.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID);
    }
}
