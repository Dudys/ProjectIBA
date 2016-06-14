package cz.duda.projectiba.dto;

import lombok.Data;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Creating DTO for entity Student.
 *
 * @author Jan Duda
 */
@Data
@XmlRootElement
public class StudentCreateDTO {

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
