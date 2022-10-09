package entities;

public class Course {
    private int courseId;
    private String courseName;
    private String language;
    private double coursePrice;
    private Instructor instructor;

    public Course(int courseId, String courseName, String language, double coursePrice, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.language = language;
        this.coursePrice = coursePrice;
        this.instructor = instructor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
