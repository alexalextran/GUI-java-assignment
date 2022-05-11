package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Student;



public class SlipController  extends Controller<Student>  {
  private Student student = getStudent();
  
  
    public final Student getStudent(){
    return model;
}
    
     @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
    
}
