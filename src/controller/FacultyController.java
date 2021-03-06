package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Faculty;
import model.Student;
import model.TMS;



public class FacultyController extends Controller<Faculty> {
    @FXML private TableView<Student> studentsTv;
    @FXML private TextField nameTF;
     @FXML private TextField emailTF;
     @FXML private Button selectBtn;
       @FXML private Button deleteBtn;
         @FXML private Button slipBtn;
     
   @FXML private void initialize(){
        
       stage.getIcons().add(new Image("view/faculty.png"));
   
      studentsTv.getSelectionModel().selectedItemProperty().addListener(
      (observable, oldStudent, newStudent) -> {
       selectBtn.setDisable(newStudent == null);
         deleteBtn.setDisable(newStudent == null);
         slipBtn.setDisable(newStudent == null);
         });
      nameTF.textProperty().addListener( (observable, oldStudent, newStudent) -> {model.filterList(nameTF.getText(), "0");});
      emailTF.textProperty().addListener( (observable, oldStudent, newStudent) -> {model.filterList("0", emailTF.getText());});
   }
 
    
    
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
  
  
  
  
   @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
}
