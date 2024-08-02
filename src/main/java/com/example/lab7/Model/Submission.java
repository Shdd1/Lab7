package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Submission {
    @NotNull(message = "id can not be null")
    private int submission_id;
    @NotNull(message = "id can not be null")
    private int assignment_id;
    @NotNull(message = "date can not be null")
    @PastOrPresent(message = "Submission date must be in the past or present")
    private Date submission_date;

    @NotNull(message = "file url can not be null")
    @Size(max = 255, message = "File URL must be at most 255 characters long")
    @Pattern(regexp = "^(https?|ftp|file)://.*$", message = "File URL must be a valid URL")
    private String file_url;

    @DecimalMin(value = "0.0", inclusive = true, message = "Grade must be at least 0.0")
    @DecimalMax(value = "100.0", inclusive = true, message = "Grade must be at most 100.0")
    private double grade;

}
