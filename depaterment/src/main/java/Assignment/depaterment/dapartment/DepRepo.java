package Assignment.depaterment.dapartment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepRepo extends JpaRepository<Department , Long>{


    List<Department> findByName(String name);
}
