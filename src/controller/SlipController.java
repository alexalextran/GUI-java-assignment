package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import model.Student;



public class SlipController  extends Controller<Student>  {
  private Student student = getStudent();
  @FXML Text totalFeeTxt;
  @FXML Text netFeeTxt;
  @FXML Text creditsTxt;
  @FXML Text scholarshipTxt;
  @FXML Text deductionTxt;

    
   @FXML private void initialize() {
          stage.getIcons().add(new Image("view/edit.png"));
    totalFeeTxt.textProperty().bind(getStudent().totalFeeProperty().asString("$%.2f"));
   netFeeTxt.textProperty().bind(getStudent().netFeeProperty().asString("$%.2f"));
   creditsTxt.textProperty().bind(getStudent().payPerCreditProperty().asString("$%.2f"));
   scholarshipTxt.textProperty().bind(getStudent().scholarshipProperty().asString("$%.2f"));
   deductionTxt.textProperty().bind(getStudent().deductionProperty().asString("$%.2f"));
  
   }
  
  
    public final Student getStudent(){
    return model;
}
    
     @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
    
}
