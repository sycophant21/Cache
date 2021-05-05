package domain;

public class Student implements Value {
    private final String name;
    private final String phoneNumber;
    private final int age;
    private final StudentID studentID;

    public Student(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.studentID = new StudentID(phoneNumber);
    }

    @Override
    public ID getID() {
        return this.studentID;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
}
