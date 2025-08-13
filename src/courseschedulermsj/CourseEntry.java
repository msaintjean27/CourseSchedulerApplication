/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseschedulermsj;

/**
 *
 * @author meganpurr
 */
public class CourseEntry {

    private String course;
    private String Description;

    public CourseEntry(String course, String description) {
        this.course = course;
        this.Description = description;
    }

    public String getCourse() {
        return course;
    }

    public String getDescription() {
        return Description;
    }
}
