package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Report;
import model.TMS;



public class TMSController extends Controller<TMS> {
  @FXML private TableView<Report> reportsTv;
  @FXML private TableColumn<Report, String> tuitionClm;
  @FXML private TableColumn<Report, String> scholarshipClm;
  @FXML private TableColumn<Report, String> deductionClm;
  @FXML private TableColumn<Report, String> netfeeClm;
  @FXML private Text totalTuitonFeeTxt;
    @FXML private Text totalNetFeeTxt;
      @FXML private Text basTxt;
        @FXML private Text totalScholarshipTxt;
          @FXML private Text totalDeductionTxt;
  
  @FXML private void initialize(){
      stage.getIcons().add(new Image("view/uts.jpeg"));
      tuitionClm.setCellValueFactory(cellData -> cellData.getValue().totalFeeProperty().asString("$%.2f"));
        scholarshipClm.setCellValueFactory(cellData -> cellData.getValue().scholarshipProperty().asString("$%.2f"));
          deductionClm.setCellValueFactory(cellData -> cellData.getValue().deductionProperty().asString("$%.2f"));
            netfeeClm.setCellValueFactory(cellData -> cellData.getValue().netFeeProperty().asString("$%.2f"));
            
   totalTuitonFeeTxt.textProperty().bind(getTms().totalTuitionFeeProperty().asString("$%.2f"));
   totalNetFeeTxt.textProperty().bind(getTms().totalNetFeeProperty().asString("$%.2f"));
   basTxt.textProperty().bind(getTms().basProperty().asString("$%.2f"));
   totalScholarshipTxt.textProperty().bind(getTms().totalScholarshipProperty().asString("$%.2f"));
   totalDeductionTxt.textProperty().bind(getTms().totalDeductionProperty().asString("$%.2f"));
     
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
