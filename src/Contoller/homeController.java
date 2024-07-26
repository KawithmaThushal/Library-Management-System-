package Contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class homeController {


     @FXML
    private AnchorPane root;

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

    
}
