package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Faculty;
import model.Student;
import model.Students;






public class TMSController extends Controller<Faculty> {
    @FXML private TableView<Student> studentsTv;
    
   public final Faculty getFaculty(){
    return model;
}
   
  
   
}
