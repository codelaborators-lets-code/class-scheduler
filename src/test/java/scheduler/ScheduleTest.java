package scheduler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ScheduleTest {

	Schedule underTest = new Schedule();
	Course courseToAdd = new Course("m200", "Adv Calculus", "Course Description", 3);
	Course anotherToAdd = new Course("e100", "Intro to Writing", "Course Description", 3);

	@Test
	public void shouldBeAbleToAddACourseToTheSchedule() {
		underTest.addACourse(courseToAdd);
		int checkSize = underTest.getNumCourses();
		assertThat(checkSize, is(1));
	}

	@Test
	public void shouldBeAbleToAdd2CoursesToTheSchedule() {
		underTest.addACourse(courseToAdd);
		underTest.addACourse(anotherToAdd);
		int checkSize = underTest.getNumCourses();
		assertThat(checkSize, is(2));
	}

	@Test
	public void shouldBeAbleToDropACourseFromTheSchedule() {
		underTest.addACourse(courseToAdd);
		underTest.addACourse(anotherToAdd);
		Course courseToRemove = underTest.findCourse("m200");
		underTest.dropACourse(courseToRemove);
		int checkSize = underTest.getNumCourses();
		assertThat(checkSize, is(1));

	}

	@Test
	public void shouldTotal3CreditsForOne3CreditCourse() {
		underTest.addACourse(courseToAdd);
		int checkCredits = underTest.totalCredits();
		assertThat(checkCredits, is(3));
	}

	@Test
	public void shouldTotal6CreditsForTwo3CreditCourses() {
		underTest.addACourse(courseToAdd);
		underTest.addACourse(anotherToAdd);
		int checkCredits = underTest.totalCredits();
		assertThat(checkCredits, is(6));
	}

	@Test
	public void shouldRenderCourseDetails() {
		underTest.addACourse(courseToAdd);
		String courseDetails = underTest.displayCourseDetails();
		assertThat(courseDetails,
				is("Course id: m200 Course name: Adv Calculus" + " Details: Course Description Credits: 3"));
	}

	@Test
	public void shouldBeAbleToSortCourses() {
		underTest.addACourse(anotherToAdd); // Intro to Writing
		underTest.addACourse(courseToAdd); // Adv Calc
		List<Course> sortedCourses = underTest.sortCourses();
		assertThat(sortedCourses, contains(courseToAdd, anotherToAdd));
	}

}
