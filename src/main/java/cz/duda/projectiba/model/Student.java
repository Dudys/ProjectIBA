package cz.duda.projectiba.model;

import lombok.Data;
import org.joda.time.LocalDate;

/**
 * Created by Jan Duda on 6/11/2016.
 */
@Data
public class Student {

    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private boolean sex;

}
