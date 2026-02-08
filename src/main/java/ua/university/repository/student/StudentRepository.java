package ua.university.repository.student;

import ua.university.domain.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    void delete(Student student);
    Optional<Student> findById(String id);
    List<Student> findAll();
}


