package com.example.lab7.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Assignment {
    @NotNull(message = "id must be not null")
    private int assignment_id;
    @NotEmpty(message = "title can not be empty")
    @Size(max = 10,message = "title size must be 10 character or les")
    private String title;
    @NotEmpty(message = "description can not be empty")
    @Size(max = 100,message = "description size must be 100 character or les")
    private String description;
    @NotNull(message = "due_date Cannot be null. ")
    @FutureOrPresent(message = "should be a date in the Future Or Present ")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date due_date;


}
