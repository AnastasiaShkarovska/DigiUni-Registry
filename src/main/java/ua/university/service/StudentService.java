package ua.university.service;

import ua.university.domain.Student;
import ua.university.repository.student.StudentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // ===== ПОШУК =====

    // Пошук за ПІБ
    public List<Student> findByFullName(String query) {
        return repository.findAll().stream()
                .filter(s -> s.getFullName()
                        .toLowerCase()
                        .contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Пошук за курсом
    public List<Student> findByCourse(int course) {
        return repository.findAll().stream()
                .filter(s -> s.getCourse() == course)
                .collect(Collectors.toList());
    }

    // Пошук за групою
    public List<Student> findByGroup(String group) {
        return repository.findAll().stream()
                .filter(s -> s.getGroup().equalsIgnoreCase(group))
                .collect(Collectors.toList());
    }

    // ===== ЗВІТИ =====

    // Всі студенти, впорядковані за курсом
    public List<Student> getStudentsSortedByCourse() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(Student::getCourse))
                .collect(Collectors.toList());
    }

    // Всі студенти, впорядковані за алфавітом
    public List<Student> getStudentsSortedByName() {
        return repository.findAll().stream()
                .sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName))
                .collect(Collectors.toList());
    }
}
