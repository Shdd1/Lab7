package com.example.lab7.Controller;

import com.example.lab7.ApiResponse.ApiResponse;
import com.example.lab7.Model.Submission;
import com.example.lab7.Servic.SubmissionServic;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/sub")
@RequiredArgsConstructor
public class SubmissionController {
    private final SubmissionServic submissionServic;

    @GetMapping("/get")
    public ResponseEntity getSubmission() {
        return ResponseEntity.status(200).body(submissionServic.getSub());
    }
    @PostMapping("/add")
    public ResponseEntity addSubmission(@Valid @RequestBody Submission submission, Errors errors) {
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        submissionServic.addSub(submission);
        return ResponseEntity.status(200).body(new ApiResponse("is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSubmission(@PathVariable int id,@Valid@RequestBody Submission submission,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate=submissionServic.updateSub(id,submission);
        if(isUpdate){
            return ResponseEntity.status(200).body("is updated");

        }
        return ResponseEntity.status(400).body("Not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSubmission(@PathVariable int id){
        boolean isDeleted = submissionServic.deleteSub(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("is delete");
        }
        return ResponseEntity.status(400).body("not found");
    }
    //assign grade
    @PutMapping("/assign/{id}/{grade}")
    public ResponseEntity assign_grade(@PathVariable int id,@PathVariable double grade){
        boolean isUpdate=submissionServic.asignDegree(id,grade);
        if(isUpdate){
            return ResponseEntity.status(200).body("is updated");
        }
        return ResponseEntity.status(400).body("not found");
    }
    //get list of the same grade
    @GetMapping("/grade/{grade}")
    public ResponseEntity getTheSamGrade(@PathVariable double grade){
       return ResponseEntity.status(200).body(submissionServic.getTheSameGrade(grade));
    }
   //get grade between min and max
   @GetMapping("/grade/{min}/{max}")
   public ResponseEntity getGrade(@PathVariable double min,@PathVariable double max){
       return ResponseEntity.status(200).body(submissionServic.getGrade(min,max));
   }
  //get submissions by assignment id
    @GetMapping("/get/{id}")
    public ResponseEntity getById(@PathVariable int id){
      Submission submission=submissionServic.GetSubmissionsByAssignmentId(id);
      if (submission==null){
          return ResponseEntity.status(400).body("not found");
      }
      return ResponseEntity.status(200).body(submissionServic.GetSubmissionsByAssignmentId(id));
    }

}
