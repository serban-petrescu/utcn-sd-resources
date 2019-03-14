package ro.utcn.spet.example.a1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.exception.StudentNotFoundException;
import ro.utcn.spet.example.a1.service.StudentManagementService;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ConsoleController implements CommandLineRunner {
	private final Scanner scanner = new Scanner(System.in);
	private final StudentManagementService studentManagementService;

	@Override
	public void run(String... args) {
		print("Welcome to the attendance tracking system.");
		boolean done = false;
		while (!done) {
			print("Enter a command: ");
			String command = scanner.next().trim();
			try {
				done = handleCommand(command);
			} catch (StudentNotFoundException studentNotFoundException) {
				print("The student with the given ID was not found!");
			}
		}
	}

	private boolean handleCommand(String command) {
		switch (command) {
			case "list":
				handleList();
				return false;
			case "add":
				handleAdd();
				return false;
			case "update":
				handleUpdateEmail();
				return false;
			case "remove":
				handleRemove();
				return false;
			case "exit":
				return true;
			default:
				print("Unknown command. Try again.");
				return false;
		}
	}

	private void handleList() {
		studentManagementService.listStudents().forEach(s -> print(s.toString()));
	}

	private void handleAdd() {
		print("First name:");
		String firstName = scanner.next().trim();
		print("Last name:");
		String lastName = scanner.next().trim();
		Student student = studentManagementService.addStudent(firstName, lastName);
		print("Created student: " + student + ".");
	}

	private void handleUpdateEmail() {
		print("Student ID:");
		int id = scanner.nextInt();
		print("Email address:");
		String emailAddress = scanner.next().trim();
		studentManagementService.updateEmailAddress(id, emailAddress);
	}

	private void handleRemove() {
		print("Student ID:");
		int id = scanner.nextInt();
		studentManagementService.removeStudent(id);
	}

	private void print(String value) {
		System.out.println(value);
	}
}
