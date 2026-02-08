package ua.university.repository.faculty;

import ua.university.domain.Faculty;
import java.util.List;
import java.util.Optional;

public interface FacultyRepository {
    List<Faculty> findAll();
    void save(Faculty faculty);
    void delete(Faculty faculty);
    Optional<Faculty> findByCode(String code);
}
