package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Session;


public class LoginController extends Controller<Session>  {
@FXML Label error;
@FXML TextField emailTF;
@FXML TextField passwordTF;

public final Session getSession(){
    return model;
}

    @FXML private void handleLogin(ActionEvent event) throws Exception{
        String email = emailTF.getText();
        String password = passwordTF.getText();
        if(getSession().getFaculty(email, password) != null){
         ViewLoader.showStage(getSession().getFaculty(email, password), "/view/tms.fxml", "Session Admin: " + getSession().getFaculty(email, password).getName(), new Stage());
        } else{
            error.setText("Incorrect login details");
        }
        emailTF.setText("");
        passwordTF.setText("");
    }
    
}
