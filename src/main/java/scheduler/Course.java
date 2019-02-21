package scheduler;

public class Course implements Comparable<Course> {

	private String id;
	private String courseName;
	private String courseDescription;
	private int courseCredits;

	public String getId() {
		return id;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getDescription() {
		return courseDescription;
	}

	public int getCourseCredits() {
		return courseCredits;
	}

	public Course(String id, String courseName, String courseDescription, int courseCredits) {
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseCredits = courseCredits;
	}

	@Override
	public String toString() {
		return courseName;
	}

	@Override
	public int compareTo(Course course) {
		if (this.getCourseName().compareTo(course.getCourseName()) < 0) {
			return -1;
		} else if (this.getCourseName().compareTo(course.getCourseName()) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

}
