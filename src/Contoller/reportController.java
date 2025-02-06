package Contoller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class reportController {
        @FXML
    private AnchorPane root;


    
    @FXML
    void bookAllocatedonAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRelease.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void bookReturnOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookReturn.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void brnAddMemberOnAction(ActionEvent event) throws Exception {
  this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
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
    void onCurrentInventory(MouseEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/subReport/currentInvenory.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void onBookAdded(MouseEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/subReport/bookAdded.fxml"));
        this.root.getChildren().add(nood);
    }

}


