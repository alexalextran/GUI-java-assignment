package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;



public class FacultyController extends Controller<Faculty> {
    @FXML private TableView<Student> studentsTv;
    
    
  public final Student getSelectedStudent(){
   return studentsTv.getSelectionModel().getSelectedItem();   
  }
    
   public final Faculty getFaculty(){
    return model;
}
   
 @FXML private void handleSelectStudent(ActionEvent event) throws Exception{
     Student student = getSelectedStudent();
      ViewLoader.showStage(getSelectedStudent(), "/view/student.fxml", "Accesing file: " + student.getName(), new Stage());
 }
 
 @FXML private void handleAddStudent(ActionEvent event) throws Exception{
     ViewLoader.showStage(null, "/view/student.fxml", "Adding new student", new Stage());
 }
}
