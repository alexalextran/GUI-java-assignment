package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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


    @FXML private void initialize() {
       
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
          
      
        Student student = new Student(name, email, phone, adress, studentid, type, credits, scholarship, deduction);  
        getStudent().getFaculty().addStudent(student);
        stage.close();
              
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
       
      getStudent().updateDetails(name, email, phone, adress, studentid, type, credits, scholarship, deduction);   
      stage.close();
           
    }
    
    
    
      public final Student getStudent(){
        return model;
        }
    
      
       @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
    

}
