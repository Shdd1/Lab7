package com.example.lab7.Servic;

import com.example.lab7.Model.Assignment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AssignmentServic {
    ArrayList<Assignment>assignments=new ArrayList<>();
    public ArrayList<Assignment> getAss(){
        return assignments;
    }
    public void addAss(Assignment assignment){
        assignments.add(assignment);
    }

    public boolean updateAss(int id,Assignment assignment){
        for(int i=0;i<assignments.size();i++){
            if(assignments.get(i).getAssignment_id()==id){
                assignments.set(i,assignment);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAss(int id) {
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getAssignment_id() == id) {
                assignments.remove(i);
                return true;
            }
        }
        return false;
    }
    //Search Assignment by id
    public Assignment getAssById(int id){
        for (int i = 0; i < assignments.size(); i++) {
            if (assignments.get(i).getAssignment_id() == id) {
               return assignments.get(i);

            }
        }
        return null;

    }
    // get List of Assignment by Title
    public ArrayList<Assignment> getAssByTitle(String title ){
        ArrayList<Assignment>assignments1=new ArrayList<>();
        for (int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getTitle().equals(title)){
                assignments1.add(assignments.get(i));
            }
        }
        return assignments1;
    }

    //change title
   public Assignment changeTitle(int id,String title){
    for (int i = 0; i < assignments.size(); i++) {
        if (assignments.get(i).getAssignment_id()==id) {
            assignments.get(i).setTitle(title);
            return assignments.get(i);
        }
    }
    return null;

}

    //update description by id
    public  Assignment updateDes(int id){
        for (int i = 0; i < assignments.size(); i++) {
            if(assignments.get(i).getAssignment_id()==id){
                assignments.get(i).setDescription("Implement all class and create CRUD operations and four endpoints that have logic.");
                return assignments.get(i);
            }
        }
        return null;
    }
}
