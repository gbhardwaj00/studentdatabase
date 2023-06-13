package studentdatabase.studentdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import studentdatabase.studentdatabase.models.Student;
import studentdatabase.studentdatabase.models.StudentRepository;

@SpringBootApplication
public class StudentdatabaseApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentdatabaseApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Student student1 = new Student("Frodo Baggins", 134, 124, "Brown", 3.5);
		// studentRepo.save(student1);

		// Student student2 = new Student("Harry Potter", 150, 153, "Green", 2.8);
		// studentRepo.save(student2);
	}
}
