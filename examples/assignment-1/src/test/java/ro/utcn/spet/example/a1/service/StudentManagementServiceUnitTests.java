package ro.utcn.spet.example.a1.service;

import org.junit.Assert;
import org.junit.Test;
import ro.utcn.spet.example.a1.entity.Student;
import ro.utcn.spet.example.a1.exception.StudentNotFoundException;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;
import ro.utcn.spet.example.a1.repository.memory.InMemoryRepositoryFactory;

public class StudentManagementServiceUnitTests {

	private static RepositoryFactory createMockedFactory() {
		RepositoryFactory factory = new InMemoryRepositoryFactory();
		factory.createStudentRepository().save(new Student(1, "A.FN", "A.LN", "A.EA"));
		factory.createStudentRepository().save(new Student(2, "B.FN", "B.LN", "B.EA"));
		return factory;
	}

	@Test
	public void testRemoveWorksWithExistingId() {
		// arrange - create a mocked factory and a service backed up by this factory
		RepositoryFactory factory = createMockedFactory();
		StudentManagementService service = new StudentManagementService(factory);

		// act - remove a student with a well-known ID
		service.removeStudent(1);

		// assert - expect that the student was removed from the repository and the other student is still there
		Assert.assertEquals(1, factory.createStudentRepository().findAll().size());
		Assert.assertTrue(factory.createStudentRepository().findById(2).isPresent());
	}

	@Test(expected = StudentNotFoundException.class)
	public void testRemoveThrowsWithNotExistingId() {
		// arrange - create a mocked factory and a service backed up by this factory
		RepositoryFactory factory = createMockedFactory();
		StudentManagementService service = new StudentManagementService(factory);

		// act - remove a student with a non-existent ID
		service.removeStudent(999);

		// no assert, we expect an exception (see the @Test annotation)
	}

}
