package controller;

import au.edu.uts.ap.javafx.Controller;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.text.Text;




public class ErrorController extends Controller<Validator> {
   @FXML Text text1;
   @FXML Text text2;
   @FXML Text text3;
   @FXML Text text4;
   @FXML Text text5;
   @FXML Text text6;
   @FXML Text text7;
   @FXML Text text8;
   
   LinkedList<Text> errorMsgs = new LinkedList<>();
   
  
   
     public final Validator getValidator(){
    return model;
}

   
    @FXML private void initialize() {
          stage.getIcons().add(new Image("view/error.png"));
           this.errorMsgs.add(text1);
        this.errorMsgs.add(text2);
         this.errorMsgs.add(text3);
          this.errorMsgs.add(text4);
            this.errorMsgs.add(text5);
              this.errorMsgs.add(text6);
                this.errorMsgs.add(text7);
                  this.errorMsgs.add(text8);
                  
        int i = 0;
       for(String error : getValidator().errors()){
       errorMsgs.get(i).setText(error);
       i++;
       }
    }
    
      @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
         }
    

}
