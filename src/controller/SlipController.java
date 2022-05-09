package controller;

import au.edu.uts.ap.javafx.Controller;
import model.Faculty;
import model.Student;



public class SlipController  extends Controller<Student>  {
  private Student student = getStudent();
  
  
    public final Student getStudent(){
    return model;
}
    
}
