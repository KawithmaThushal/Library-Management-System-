package Contoller;

import javax.swing.JOptionPane;

import Dto.bookDto;
import Service.subFacutory;
import Service.Custom.bookCustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class bookController {


        @FXML
    private TextField TextAddDate;

    @FXML
    private TextField TextAuthor;

    @FXML
    private TextField TextCategorie;

    @FXML
    private TextField TextID;

    @FXML
    private TextField TextPublishDate;

    @FXML
    private TextField TextQuantity;

    @FXML
    private TextField TextTitale;

    @FXML
    private AnchorPane root;

    @FXML
    void brnAddMemberOnAction(ActionEvent event) throws Exception {
this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("./view/memberRegister.fxml"));
            this.root.getChildren().add(nood);
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws Exception {
       
        this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("./view/bookRegister.fxml"));
            this.root.getChildren().add(nood);
    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("./view/homeView.fxml"));
        this.root.getChildren().add(nood);
    }
    private bookCustom  bcustom = (bookCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.BOOK);
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        System.out.println(TextID.getText());
        System.out.println(TextAuthor.getText());

        try {
            bookDto cdto = new bookDto(
                TextID.getText(),
                TextAuthor.getText(),
                TextCategorie.getText(),
                TextTitale.getText(),
                TextPublishDate.getText(),
                TextAddDate.getText(),
                Integer.parseInt(TextQuantity.getText())
            );

            String resp = bcustom.save(cdto);
             JOptionPane.showMessageDialog(null, this, resp, 0);

             Clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, this, e.getMessage(), 0);
        }


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }
    public void Clear(){
        TextID.setText("");
        TextAuthor.setText("");
        TextCategorie.setText("");
        TextTitale.setText("");
        TextPublishDate.setText("");
        TextAddDate.setText("");
        TextQuantity.setText("");
    }
    
}
