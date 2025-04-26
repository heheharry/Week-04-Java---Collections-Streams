package Day1.JavaGenerics;
import java.util.*;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by assignments.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    public void evaluate() {
        System.out.println(getCourseName() + " evaluated by research work.");
    }
}

class Course<T extends CourseType> {
    private T type;
    private String department;

    public Course(String department, T type) {
        this.department = department;
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void displayCourse() {
        System.out.println("Department: " + department);
        type.evaluate();
    }
}

class CourseUtility {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}
public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse("Calculus"));
        Course<AssignmentCourse> cs = new Course<>("Computer Science", new AssignmentCourse("Data Structures"));
        Course<ResearchCourse> bio = new Course<>("Biology", new ResearchCourse("Genetics Research"));

        List<CourseType> courseList = new ArrayList<>();
        courseList.add(math.getType());
        courseList.add(cs.getType());
        courseList.add(bio.getType());

        math.displayCourse();
        cs.displayCourse();
        bio.displayCourse();

        CourseUtility.displayAllCourses(courseList);
    }
}
