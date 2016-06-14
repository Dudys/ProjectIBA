package cz.duda.projectiba.model;

import lombok.Data;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Class represents entity Student.
 *
 * @author Jan Duda
 */
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Pattern(regexp = "^([^0-9]*)")
    @Size(min = 1, max = 60)
    private String firstname;

    @NotNull
    @Pattern(regexp = "^([^0-9]*)")
    @Size(min = 1, max = 60)
    private String lastname;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthdate;

    private boolean sex;

}
