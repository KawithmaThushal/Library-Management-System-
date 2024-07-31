package Contoller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DM.bookreturnTM;
import Dto.bookReturnDto;
import Service.subFacutory;
import Service.Custom.bookreturnCustom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class bookReturnCon {

       @FXML
    private AnchorPane root;
    @FXML
    private TableView<bookreturnTM> ReturnTableView;

    @FXML
    private TextField TxtBookID;

    @FXML
    private TextField TxtMemberID;

    @FXML
    private Label lblExpireDate;

    @FXML
    private TableColumn<bookreturnTM, String> tblB_ID;

    @FXML
    private TableColumn<bookreturnTM, String> tblExpireDate;

    @FXML
    private TableColumn<bookreturnTM, String> tblMID;

   


    private bookreturnCustom  returnbook = (bookreturnCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.RETURN);



     
    public void getAllReturnBook() throws Exception{

        try {
          
            ArrayList<bookReturnDto> bookList = returnbook.getAll();

            
            ObservableList<bookreturnTM> bookReturnTMList = FXCollections.observableArrayList();
            for (bookReturnDto dto : bookList) {
                bookReturnTMList.add(new bookreturnTM(
                dto.getBook_ID(),   
                dto.getM_ID(),
                dto.getExpire_Date()
                ));
            }

          
            ReturnTableView.setItems(bookReturnTMList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }




    }

     public void initialize() throws Exception {
        try {
            tblB_ID.setCellValueFactory(new PropertyValueFactory<>("book_ID"));
            tblMID.setCellValueFactory(new PropertyValueFactory<>("M_ID"));
            tblExpireDate.setCellValueFactory(new PropertyValueFactory<>("Expire_Date"));
           
            getAllReturnBook();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error initializing data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

// @FXML
//     void CheckOnAction(ActionEvent event) {

//     }

        @FXML
    void checkOnMouseClicked(MouseEvent event) {
  try {
    bookreturnTM Returntbook = ReturnTableView.getSelectionModel().getSelectedItem();

            if(Returntbook != null){
              TxtBookID.setText(Returntbook.getBook_ID());
              TxtMemberID.setText(Returntbook.getM_ID());
              lblExpireDate.setText(Returntbook.getExpire_Date());
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }
    }
    
}
