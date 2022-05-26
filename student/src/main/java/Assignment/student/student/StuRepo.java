package Assignment.student.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StuRepo extends JpaRepository<Student, Long>{


    List<Student> findByName(String name);
}
