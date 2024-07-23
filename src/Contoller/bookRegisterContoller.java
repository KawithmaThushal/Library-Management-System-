package Contoller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

public class bookRegisterContoller {

        @FXML
    private AnchorPane root;

    @FXML
    void brnAddMemberOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
            this.root.getChildren().add(nood);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {

        this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
            this.root.getChildren().add(nood);

    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {

        this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRegister.fxml"));
            this.root.getChildren().add(nood);
    }

    
}
