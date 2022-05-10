package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Report;
import model.TMS;



public class TMSController extends Controller<TMS> {
  @FXML private TableView<Report> reportsTv;
  @FXML private TableColumn<Report, String> name;
  
  @FXML private void initialize(){
      name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
  }
    
 public final TMS getTms(){
    return model;
}
 
 public final ObservableList<Report> getReports(){
     return getTms().reports();
 }
  

   
   
    @FXML private void handleClose(ActionEvent event) throws Exception{
    stage.close();
 }
   

}
