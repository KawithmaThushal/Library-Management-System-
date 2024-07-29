package Contoller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DM.MemberTm;
import Dto.memberDto;
import Service.subFacutory;
import Service.Custom.membercustom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class memberRegisterContoller {

    
    @FXML
    private AnchorPane root;  
    @FXML
    private TableView<MemberTm> TblMemberRegister;
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
    private TableColumn<MemberTm, String> tblAdress;

    @FXML
    private TableColumn<MemberTm, String> tblShipDate;

    @FXML
    private TableColumn<MemberTm, String> tblNic;

    @FXML
    private TableColumn<MemberTm, Integer> tblcontactno;

    @FXML
    private TableColumn<MemberTm, String> tblmemberID;

    @FXML
    private TableColumn<MemberTm, String> tblmemberName;

    private membercustom  Mecustom = (membercustom) subFacutory.getInstance().getservice(subFacutory.serviceType.MEMBER);


  
    @FXML
    void DeleteOnAction(ActionEvent event) {
try {
    String id = TextID.getText();
    String rep = Mecustom.Delete(id);
    if(rep != null){
        new Alert(Alert.AlertType.CONFIRMATION).show();
   }else{
       new Alert(Alert.AlertType.ERROR).show();

   }

   clear();
   getAllMember();
    
} catch (Exception e) {
    new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

}
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
        }
        else{
            new Alert(Alert.AlertType.ERROR).show();

        }
        clear();
        getAllMember();
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
            clear();
            getAllMember();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
            }
    }

    @FXML
    void viewMemberOnclick(MouseEvent event) {
try {
    MemberTm selecMember = TblMemberRegister.getSelectionModel().getSelectedItem();

            if(selecMember != null){
                TextID.setText(selecMember.getM_ID());
                TextName.setText(selecMember.getName());
                TextAdress.setText(selecMember.getAdress());
                TextDob.setText(selecMember.getDOB());
                TextNic.setText(selecMember.getNic());
                TextContact.setText(String.valueOf(selecMember.getContac_No()));
                TextEmail.setText(selecMember.getEmail());

                

            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }    }


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
    

      public void initialize() throws ClassNotFoundException, SQLException {
        try {
            tblmemberID.setCellValueFactory(new PropertyValueFactory<>("M_ID"));
            tblNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
            tblcontactno.setCellValueFactory(new PropertyValueFactory<>("CONTAC_NUM"));
            tblShipDate.setCellValueFactory(new PropertyValueFactory<>("MembershipDate"));
            tblmemberName.setCellValueFactory(new PropertyValueFactory<>("NAME"));

            getAllMember();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


      public void getAllMember() throws Exception{

        try {
          
            ArrayList<memberDto> bookList = Mecustom.getAll();

            
            ObservableList<MemberTm> MemberTMList = FXCollections.observableArrayList();
            for (memberDto dto : bookList) {
                MemberTMList.add(new MemberTm(
                   dto.getM_ID(),
                   dto.getName(),
                   dto.getAdress(),
                   dto.getNic(),
                   dto.getDOB(),
                   dto.getContac_No(),
                   dto.getEmail(),
                   dto.getMembershipDate()
                   
                   
                ));
            }

          
            TblMemberRegister.setItems(MemberTMList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }




    }

    public void clear(){
        TextID.setText("");
        TextName.setText("");
        TextAdress.setText("");
        TextContact.setText("");
        TextDob.setText("");
        TextEmail.setText("");
        TextNic.setText("");

    }

}
