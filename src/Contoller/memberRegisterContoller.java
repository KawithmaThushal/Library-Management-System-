package Contoller;

import java.io.IOException;

import Dto.memberDto;
import Service.subFacutory;
import Service.Custom.membercustom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class memberRegisterContoller {

    
    @FXML
    private AnchorPane root;  
    @FXML
    private TableView<?> TblMemberRegister;
    @FXML
    private TextField TextAdress;

    @FXML
    private TextField TextContact;

    @FXML
    private TextField TextDob;

    @FXML
    private TextField TextEmail;

    @FXML
    private TextField TextID;

    @FXML
    private TextField TextName;

    @FXML
    private TextField TextNic;

    @FXML
    private TableColumn<?, ?> tblAdress;

    @FXML
    private TableColumn<?, ?> tblDob;

    @FXML
    private TableColumn<?, ?> tblNic;

    @FXML
    private TableColumn<?, ?> tblcontactno;

    @FXML
    private TableColumn<?, ?> tblmembername;

    private membercustom  Mecustom = (membercustom) subFacutory.getInstance().getservice(subFacutory.serviceType.MEMBER);


  
    @FXML
    void DeleteOnAction(ActionEvent event) {
System.out.println(TextID.getText());
//System.out.println(str);
    }

    @FXML
    void UpdateOnActtion(ActionEvent event) {
        try {
            memberDto mdto= new memberDto(
                TextID.getText(),
                TextName.getText(),
                TextAdress.getText(),
                TextNic.getText(),
                TextDob.getText(),
                Integer.parseInt(TextContact.getText()),
                TextEmail.getText()
                  );
                String resp= Mecustom.Update(mdto);

                 if(resp != null){
             new Alert(Alert.AlertType.CONFIRMATION).show();
        }else{
            new Alert(Alert.AlertType.ERROR).show();

        }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
        }
    }

    

    @FXML
    void saveOnAction(ActionEvent event) {
            try {
                memberDto mdto= new memberDto(
                    TextID.getText(),
                    TextName.getText(),
                    TextAdress.getText(),
                    TextNic.getText(),
                    TextDob.getText(),
                    Integer.parseInt(TextContact.getText()),
                    TextEmail.getText()
                      );
                    String resp= Mecustom.save(mdto);

                     if(resp != null){
                 new Alert(Alert.AlertType.CONFIRMATION).show();
            }else{
                new Alert(Alert.AlertType.ERROR).show();

            }

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
            }
    }

    @FXML
    void viewMemberOnclick(MouseEvent event) {
        System.out.println(TextID.getText());
    }


    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
            this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRegister.fxml"));
            this.root.getChildren().add(nood);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void btnMemberRegiOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);

    }
    
}
