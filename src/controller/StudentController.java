package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.InputException;
import model.Student;





public class StudentController extends Controller<Student> {
@FXML Button addBtn;
@FXML Button updateBtn;
@FXML TextField nameTF;
@FXML TextField emailTF;
@FXML TextField phoneTF;
@FXML TextField addressTF;
@FXML TextField studentidTF;
@FXML TextField typeTF;
@FXML TextField creditsTF;
@FXML TextField ScholarshipTF;
@FXML TextField deductionTF;
Validator validator;

public StudentController(){
    validator = new Validator();
}


    @FXML private void initialize() {
        stage.getIcons().add(new Image("view/edit.png"));
       
        emailTF.setText(getStudent().getEmail());
       phoneTF.setText(getStudent().getPhone());
       addressTF.setText(getStudent().getAddress());
       studentidTF.setText(getStudent().getID());
        typeTF.setText(getStudent().getType());
         creditsTF.setText(String.valueOf(getStudent().getCredits()));
          ScholarshipTF.setText(String.valueOf(getStudent().getScholarship()));
          
       if(!(getStudent().getName().equals("a"))){ //updating student
           updateBtn.setDisable(false);
       nameTF.setText(getStudent().getName());
      deductionTF.setText(String.valueOf(getStudent().getDeduction()));
        }else{
           stage.getIcons().add(new Image("view/edit.png"));
            nameTF.setText("");
             deductionTF.setText("Code");
              addBtn.setDisable(false);
       }
    }
    @FXML public void handleAddStudent(ActionEvent event) throws Exception{
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        String adress = addressTF.getText();
        String studentid = studentidTF.getText();
        String type = typeTF.getText();
        int credits = Integer.parseInt(creditsTF.getText());
        double scholarship = Double.parseDouble(ScholarshipTF.getText());
        String deduction = deductionTF.getText();
        
      //  if(!validator.isValid(name, email, phone, adress, type, studentid, credits, scholarship)){
           //   validator.generateErrors(name, email, phone, adress, type, studentid, credits, scholarship);
         //    ViewLoader.showStage(validator, "/view/error.fxml", "Input Exceptions " , new Stage());
         //    validator.clear();
       // }else{
           
             Student student = new Student(name, email, phone, adress, studentid, type, credits, scholarship, deduction);  
        getStudent().getFaculty().addStudent(student);
         stage.close();
        //}
          
      
     
     
              
    }
    
     @FXML public void handleUpdateStudent(ActionEvent event) throws Exception{
        String name = nameTF.getText();
        String email = emailTF.getText();
        String phone = phoneTF.getText();
        String adress = addressTF.getText();
        String studentid = studentidTF.getText();
        String type = typeTF.getText();
        int credits = Integer.parseInt(creditsTF.getText());
        double scholarship = Double.parseDouble(ScholarshipTF.getText());
         String deduction = deductionTF.getText();  
          
          if(deduction.equals(getStudent().getDeduction()) && !deduction.equals("0.0")){
            deduction = "2022AUT";
       } 
       stage.close();
      getStudent().updateDetails(name, email, phone, adress, studentid, type, credits, scholarship, deduction);   
      
           
    }
    
    
    
      public final Student getStudent(){
        return model;
        }
    
      
       @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
    

}
