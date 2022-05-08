package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;
import model.Students;






public class TMSController extends Controller<Faculty> {
    @FXML private TableView<Student> studentsTv;
    
    
  public final Student getSelectedStudent(){
   return studentsTv.getSelectionModel().getSelectedItem();   
  }
    
   public final Faculty getFaculty(){
    return model;
}
   
 @FXML private void handleSelectStudent(ActionEvent event){
     Student student = getSelectedStudent();
 }
 
 @FXML private void handleAddStudent(ActionEvent event) throws Exception{
     ViewLoader.showStage(getFaculty(), "/view/student.fxml", "Adding new student", new Stage());
 }
}
