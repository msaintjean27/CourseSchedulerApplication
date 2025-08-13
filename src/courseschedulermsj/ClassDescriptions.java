package courseschedulermsj;

public class ClassDescriptions {

    private String courseCode;
    private String description;
    private int seats;

    public ClassDescriptions(String courseCode, String description, int seats) {
        this.courseCode = courseCode;
        this.description = description;
        this.seats = seats;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getDescription() {
        return description;
    }

    public int getSeats() {
        return seats;
    }

}
