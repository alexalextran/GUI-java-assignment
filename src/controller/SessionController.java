package controller;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Session;



public class SessionController extends Controller<Session> {
   
    
   @FXML private void handleLogin(ActionEvent event) throws Exception{
        ViewLoader.showStage(new Session(), "/view/login.fxml", "Login", new Stage());
                
    }
   
  
}
