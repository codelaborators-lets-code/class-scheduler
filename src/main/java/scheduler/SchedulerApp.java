package scheduler;

import java.util.Scanner;

public class SchedulerApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Schedule mySchedule = new Schedule();

		System.out.println("Welcome to our course scheduler.");
		System.out.println("What would you like to do?\n");

		String userChoice;

		do {
			System.out.println("Press 1 to add a course");
			System.out.println("Press 2 to drop a course");
			System.out.println("Press 3 to see your total enrollment credits");
			System.out.println("Press 4 to display course details");
			System.out.println("Press 5 to see a sorted display of your courses");
			System.out.println("Press -1 to exit\n");
			userChoice = input.nextLine();

			if (userChoice.equals("1")) {
				System.out.println("Let's add a course.");
				System.out.println("Enter the course id:");
				String id = input.nextLine();
				System.out.println("Enter the course name:");
				String name = input.nextLine();
				System.out.println("Enter the course description");
				String description = input.nextLine();
				System.out.println("Enter the number of credits:");
				int numCredits = input.nextInt();
				input.nextLine();

				Course toAdd = new Course(id, name, description, numCredits);
				mySchedule.addACourse(toAdd);

			} else if (userChoice.equals("2")) {
				System.out.println("Enter the id of the course you want to drop");
				String id = input.nextLine();
				Course toDrop = mySchedule.findCourse(id);
				mySchedule.dropACourse(toDrop);

			} else if (userChoice.equals("3")) {
				System.out.println("Your total enrollment credits so far are: " + mySchedule.totalCredits());

			} else if (userChoice.equals("4")) {
				System.out.println(mySchedule.displayCourseDetails());

			} else if (userChoice.equals("5")) {
				System.out.println("Here is a sorted list of your enrolled courses.");
				System.out.println(mySchedule.sortCourses());

			} else {
				System.out.println("Sorry request not recognized.");
			}

		} while (!userChoice.equals("-1"));
		System.out.println("Have a nice day!");
		System.exit(0);
		input.close();
	}

}
