package cz.duda.projectiba.model;

import lombok.Data;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Jan Duda on 6/11/2016.
 */
@Data
public class Student {

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
