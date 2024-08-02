package com.example.lab7.Servic;

import com.example.lab7.Model.Assignment;
import com.example.lab7.Model.Submission;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubmissionServic {
    ArrayList<Submission>submissions =new ArrayList<>();
    public ArrayList<Submission> getSub(){
        return submissions;
    }
    public void addSub(Submission submission){
        submissions.add(submission);
    }
    public boolean updateSub(int id,Submission submission){
        for(int i=0;i<submissions.size();i++){
            if(submissions.get(i).getSubmission_id()==id){
                submissions.set(i,submission);
                return true;
            }
        }
        return false;
    }

    public boolean deleteSub(int id) {
        for (int i = 0; i < submissions.size(); i++) {
            if (submissions.get(i).getSubmission_id() == id) {
                submissions.remove(i);
                return true;
            }
        }
        return false;
    }
    //assign grade
    public boolean asignDegree(int id,double grade){
        for (int i = 0; i < submissions.size(); i++){
            if(submissions.get(i).getSubmission_id() == id){
                 submissions.get(i).setGrade(grade);
                 return true;
            }
        }
        return false;
    }
    //get list the same grade
    public ArrayList<Submission> getTheSameGrade(double grade){
        ArrayList<Submission>submissions1=new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++){
            if(submissions.get(i).getGrade()==grade){
                submissions1.add(submissions.get(i));
            }
        }
        return submissions1;
    }
    //get grade between min and max
    public ArrayList<Submission> getGrade(double min,double max){
        ArrayList<Submission>submissions1=new ArrayList<>();
        for (int i = 0; i < submissions.size(); i++){
            if(submissions.get(i).getGrade()>=min && submissions.get(i).getGrade()<=max){
                submissions1.add(submissions.get(i));
            }
        }
        return submissions1;
    }

    //get submissions by assignment id
    public Submission GetSubmissionsByAssignmentId(int id){
        for (int i = 0; i < submissions.size(); i++){
            if(submissions.get(i).getAssignment_id()==id){
                return submissions.get(i);
            }
        }
        return null;
    }



}
