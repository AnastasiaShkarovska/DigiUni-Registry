package ua.university.repository.faculty;

import ua.university.domain.Faculty;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryFacultyRepository implements FacultyRepository {

    private final List<Faculty> faculties = new ArrayList<>();

    @Override
    public void save(Faculty faculty) {
        faculties.removeIf(f -> f.getCode().equals(faculty.getCode()));
        faculties.add(faculty);
    }

    @Override
    public void delete(Faculty faculty) {
        faculties.removeIf(f -> f.getCode().equals(faculty.getCode()));
    }

    @Override
    public Optional<Faculty> findByCode(String code) {
        for (Faculty f : faculties) {
            if (f.getCode().equals(code)) return Optional.of(f);
        }
        return Optional.empty();
    }

    @Override
    public List<Faculty> findAll() {
        return new ArrayList<>(faculties);
    }
}
