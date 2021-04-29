package pl.kurs.java.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private String surname;
    private String pesel;
    private LocalDate birthDate;
    private String currentPosition;
    private String currentCompany;
    private double currentSalary;
    private LocalDate hireDate;
    private int yearsOfExperience;
    private double amount;
    private String specialization;
    private String studyDirection;
    private int semester;
    private double average;
}
