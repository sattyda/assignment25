package Assignment.depaterment.dapartment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    Long id;

    String name;

    String address;

    String faculty;
}
