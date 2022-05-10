package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;
import model.TMS;



public class FacultyController extends Controller<Faculty> {
    @FXML private TableView<Student> studentsTv;
    @FXML private TextField nameTF;
     @FXML private TextField emailTF;
 
    
    
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
     Student student = new Student("a", "", "", "", "", "", 0, 0.0, "Code");
     student.setFaculty(getFaculty());
     ViewLoader.showStage(student, "/view/student.fxml", "Adding new student", new Stage());
 }
  @FXML private void handleDeleteStudent(ActionEvent event) throws Exception{
     getFaculty().removeStudent(getSelectedStudent());
 }
  
  @FXML private void handleSlip(ActionEvent event) throws Exception{
     ViewLoader.showStage(getSelectedStudent(), "/view/slip.fxml", getSelectedStudent().getName() + " SLIP Report", new Stage());
 }
  
  @FXML private void handleReport(ActionEvent event) throws Exception{
     ViewLoader.showStage( new TMS(getFaculty()), "/view/tms.fxml", "TMS Report", new Stage());
 }
  
  
  @FXML private void handleFilter(ActionEvent event) throws Exception{
      
     getFaculty().filterList(nameTF.getText(), nameTF.getText());
 }
}
