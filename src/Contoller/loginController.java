package Contoller;



import java.net.URL;

import Dto.loginDto;
import Service.subFacutory;
import Service.Custom.loginServiceCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController {

     @FXML
    private PasswordField TextPassword;

    @FXML
    private TextField TextUserName;

    
    @FXML
    private Label labelText;

    @FXML
    private AnchorPane root;


    private loginServiceCustom  loginservice = (loginServiceCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.LOGIN);

    @FXML
    void loginOnAction(ActionEvent event) {

     try {
        String username =TextUserName.getText();
        String password =TextPassword.getText();

        loginDto logindto= loginservice.getUser(username, password);

        if(logindto != null){
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + username + "!");
        

        // this.root.getChildren().clear();
        // Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        // this.root.getChildren().add(nood);
        Stage currentStage = (Stage) root.getScene().getWindow();
        currentStage.close();

        URL resource = this.getClass().getResource("/view/homeView.fxml");
        Parent root = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(root)); 
        stage.show();
        stage.setTitle("Home View");

        }else{
            labelText.setText("Invalid username or password.");
            //showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }

    

     } catch (Exception e) {
        e.printStackTrace();
        showAlert(Alert.AlertType.ERROR, "Login Failed", "An error occurred. Please try again.");}
     }


     private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
        
    

    
}
