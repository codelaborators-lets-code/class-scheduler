package scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//maintains our collection of courses on the schedule
public class Schedule {

	List<Course> courseList = new ArrayList<>();

	public void addACourse(Course courseToAdd) {
		courseList.add(courseToAdd);
	}

	public int getNumCourses() {
		return courseList.size();
	}

	public Course findCourse(String courseId) {
		Course foundCourse = null;

		for (Course course : courseList) {
			if (course.getId().equals(courseId)) {
				foundCourse = course;
			}
		}
		return foundCourse;
	}

	public void dropACourse(Course courseToRemove) {
		courseList.remove(courseToRemove);
	}

	public int totalCredits() {
		int totalCredits = 0;
		for (Course course : courseList) {
			totalCredits += course.getCourseCredits(); // accumulator or running total
		}
		return totalCredits;
	}

	public String displayCourseDetails() {
		String details = "";
		for (Course course : courseList) {
			details += "Course id: " + course.getId() + " Course name: " + course.getCourseName() + " Details: "
					+ course.getDescription() + " Credits: " + course.getCourseCredits() + "\n";
		}
		return details;

	}

	public List<Course> sortCourses() {
		Collections.sort(courseList);
		return courseList;
	}

}
