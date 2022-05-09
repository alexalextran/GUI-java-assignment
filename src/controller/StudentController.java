package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Student;





public class StudentController extends Controller<Student> {
@FXML private Button addBtn;
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
       nameTF.setText(getStudent().getName());
       emailTF.setText(getStudent().getEmail());
       phoneTF.setText(getStudent().getPhone());
       addressTF.setText(getStudent().getAddress());
       studentidTF.setText(getStudent().getID());
        typeTF.setText(getStudent().getType());
         creditsTF.setText(String. valueOf(getStudent().getCredits()));
          ScholarshipTF.setText(String.valueOf(getStudent().getScholarship()));
           deductionTF.setText(String. valueOf(getStudent().getDeduction()));
    }
    @FXML private void handleAddStudent(ActionEvent event) throws Exception{
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
        //getFaculty().addStudent(student);
    }
    
    
    
      public final Student getStudent(){
        return model;
        }
    
    

}
