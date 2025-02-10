package Contoller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DM.bookreturnTM;
import Dto.billDto;
import Dto.bookReturnDto;
import Service.subFacutory;
import Service.Custom.bookreturnCustom;
import Service.Custom.releasebook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private TextField TxtDates;


    @FXML
    private TextField TxtBill;

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
            clear();
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

    @FXML
    void homeOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void memberOnAction(ActionEvent event) throws IOException {
     this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);
    }

  @FXML
    void addBookOnAction(ActionEvent event) throws IOException {
        
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRegister.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void bookAllotedOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRelease.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void bookReturnOnAction(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookReturn.fxml"));
        this.root.getChildren().add(nood);
    }
    
    @FXML
    void btnReportOnAction(ActionEvent event) throws Exception{
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/subReport/Report.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void checkOnAction(ActionEvent event) {
        try {
            String M_id = TxtMemberID.getText();
            String B_id = TxtBookID.getText();
            double Total;
            double daypay=2.50;
            bookReturnDto dto= returnbook.getBookreturnEntity(M_id,B_id);

            if(dto != null){
                 lblExpireDate.setText(dto.getExpire_Date());
                 LocalDate today = LocalDate.now();
                 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                 String expireDateString = dto.getExpire_Date();
                 System.out.println(expireDateString);
               
                    LocalDate expireDate = LocalDate.parse(expireDateString, formatter);

                    if(expireDate.isBefore(today)){
                        long daysPassed = ChronoUnit.DAYS.between(expireDate, today);
                        TxtDates.setText(String.valueOf(daysPassed));// set the expiredates
                        Total=daysPassed*daypay;
                  TxtBill.setText(String.valueOf(Total)); //set bill

                    }else{
                        TxtDates.setText("No overdue");
                        System.out.println("The expiration date is today or in the future.");
                        TxtBill.setText("");
                    }
                  // System.out.println(Total);
                //    System.out.println(daysPassed);
             

            }
            else{
                lblExpireDate.setText("Expire Date Not Found");            }
               
               
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
            e.printStackTrace();
        }

    }

    public void clear(){
        TxtBill.setText("");
        TxtBookID.setText("");
        TxtDates.setText("");
        TxtMemberID.setText("");
        lblExpireDate.setText("");

    }
        private releasebook  releasebook = (releasebook) subFacutory.getInstance().getservice(subFacutory.serviceType.RELEASE);

    @FXML
    void payonAction(ActionEvent event) {

        try {
                billDto bdto= new billDto(
                        TxtBookID.getText(),
                        TxtMemberID.getText(),
                      Integer.parseInt(TxtDates.getText()),
                      Double.parseDouble(TxtBill.getText())
                        
                        
                    
                      );
              //  billDto sampleBill1 = new billDto("M001", "B001", 5, 1500.50);
                    String resp= returnbook.save(bdto);

                    if("sucess".equalsIgnoreCase(resp)){
                            try{
                                String Mid= TxtMemberID.getText();
                                String Bid=TxtBookID.getText();
                                String rep = releasebook.Delete(Mid, Bid);

                                if ("sucess".equalsIgnoreCase(rep)) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Payment successful, borrow record deleted!").show();
                                } else {
                                    new Alert(Alert.AlertType.ERROR, "Payment saved, but failed to delete borrow record.").show();
                                }

                            }
                        catch (Exception e) {
                            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
                        
                        }
                    }
           clear();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
            }


    }

}
