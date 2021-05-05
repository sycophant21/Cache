import cache.CacheAuthenticator;
import cache.CacheFactory;
import cache.CacheImpl;
import cache.CacheLayer;
import domain.Employee;
import domain.EmployeeID;
import domain.Student;
import domain.StudentID;

import java.util.Random;


public class Main {
    public static void main(String[] args) {

        CacheAuthenticator cacheAuthenticator = new CacheAuthenticator();
        CacheLayer cacheLayer = cacheAuthenticator.authenticate("userId","password");




        CacheFactory cacheFactory = CacheFactory.getInstance();
        CacheImpl employee = cacheFactory.createCache("employee");
        employee.addToCache(new Employee("abc","a","1234",20));
        System.out.println(employee.get(new EmployeeID("1234")));
        employee.createIndex("age");
        System.out.println(employee.search("age",20));
        CacheImpl student = cacheFactory.createCache("student");
        student.addToCache(new Student("abc","12345",15));
        System.out.println(student.get(new StudentID("12345")));
        student.createIndex("age");
        System.out.println(student.search("age",15));
        student.deleteFromCache(new domain.StudentID("12345"));
        student.deleteFromCache("Age",15);
    }

    public static class ValueSelector {
        public static char charSelector() {
            int x = new Random().nextInt(26) + 1;
            char c = (char) (x + 96);
            return c;
        }
    }
}
