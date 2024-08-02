package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Assignment;
import com.example.lab7.Servic.AssignmentServic;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/assignment")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentServic assignmentServic;
    @GetMapping("/get")
    public ResponseEntity getAssign(){
      return ResponseEntity.status(200).body(assignmentServic.getAss());

    }
    @PostMapping("/add")
    public ResponseEntity addAssign(@Valid@RequestBody Assignment assignment, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        assignmentServic.addAss(assignment);
        return ResponseEntity.status(200).body("it is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAsssign(@PathVariable int id,@Valid@RequestBody Assignment assignment,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean is_Updated=assignmentServic.updateAss(id,assignment);
        if(is_Updated){
            return ResponseEntity.status(200).body("is updated");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAssign(@PathVariable int id){
        boolean isDeleted=assignmentServic.deleteAss(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("is deleted");
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));

    }
    //Search Assignment by id
    @GetMapping("/assbyid/{id}")
    public ResponseEntity SearchAssById(@PathVariable int id){
        Assignment assignment=assignmentServic.getAssById(id);
        if(assignment==null){
            return ResponseEntity.status(400).body("not found");

        }
        return ResponseEntity.status(200).body(assignmentServic.getAssById(id));
    }

    // get List of Assignment by title
    @GetMapping("/get/{title}")
    public ResponseEntity getAssByDate(@PathVariable String title){
    return ResponseEntity.status(200).body(assignmentServic.getAssByTitle(title));

    }
    //change title
    @GetMapping("/change/{id}/{title}")
    public ResponseEntity changeDate(@PathVariable int id ,@PathVariable String title){
        Assignment assignment=assignmentServic.changeTitle(id,title);
        if(assignment==null){
            return ResponseEntity.status(400).body("Not found");
        }
        return ResponseEntity.status(200).body(assignmentServic.changeTitle(id,title));
    }
    //update description by id
    @GetMapping("/descr/{id}")
    public ResponseEntity updateById(@PathVariable int id){
        Assignment assignment2=assignmentServic.updateDes(id);
        if(assignment2==null){
            return ResponseEntity.status(400).body("not found");

        }
        return ResponseEntity.status(200).body(assignmentServic.updateDes(id));
     }
}
