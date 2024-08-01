package Contoller;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class homeController {

    @FXML
    private Label dayOnManth;

    @FXML
    private Label lblDay;

    @FXML
    private Label lblMoneth;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblyear;

       
    @FXML
    private AnchorPane root;

    public void initialize(){
        UpdateTime();
    }    


    public void UpdateTime(){

        LocalDateTime currentDateTime = LocalDateTime.now();

        int year=currentDateTime.getYear();
        String month = currentDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String day = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        int Hour = currentDateTime.getHour();
        int Minitues =currentDateTime.getMinute();
        int daymonth=currentDateTime.getDayOfMonth();
        String time = String.format("%02d:%02d", Hour, Minitues);


        lblDay.setText(day+",");
        lblMoneth.setText(month);
        lblyear.setText(String.valueOf(" "+year));
        lblTime.setText(String.valueOf(time));
        dayOnManth.setText(String.valueOf("   "+daymonth+","));
        

    }



   

   

        
 

    @FXML
    void btnaddBookOnAction(ActionEvent event) throws Exception {
        
            this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRegister.fxml"));
            this.root.getChildren().add(nood);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void btnMemberRegisterOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void bookReleaseOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRelease.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void returnOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookReturn.fxml"));
        this.root.getChildren().add(nood);
    }

   
    
}
