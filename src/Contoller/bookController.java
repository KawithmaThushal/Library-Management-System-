package Contoller;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DM.BookTM;
import Dto.bookDto;
import Service.subFacutory;
import Service.Custom.bookCustom;
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
    private TableView<BookTM> tblbookRegister;

    @FXML
    private TableColumn<BookTM, String> tblAuthor;

    @FXML
    private TableColumn<BookTM, String> tblBookAddDate;

    @FXML
    private TableColumn<BookTM, String> tblBookID;
    
    @FXML
    private TableColumn<BookTM,String > tblCategories;

    @FXML
    private TableColumn<BookTM, Integer> tblavilable;

    @FXML // Move the Member Register Form
    void brnAddMemberOnAction(ActionEvent event) throws Exception {
            this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
            this.root.getChildren().add(nood);
    }

    @FXML // Move the Book Register Form
    void btnAddOnAction(ActionEvent event) throws Exception {
       
        this.root.getChildren().clear();
            Parent nood =  FXMLLoader.load(this.getClass().getResource("./view/bookRegister.fxml"));
            this.root.getChildren().add(nood);
    }

    @FXML // Move the Home  Form
    void btnHomeOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        this.root.getChildren().add(nood);
    }
    private bookCustom  bcustom = (bookCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.BOOK);
    @FXML // THE BOOK REGISTERE PROSESS
    void btnSaveOnAction(ActionEvent event) {
      

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

            if(resp != null){
                 new Alert(Alert.AlertType.CONFIRMATION).show();
            }else{
                new Alert(Alert.AlertType.ERROR).show();

            }
         

             Clear();
             getAllBook();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
                }


    }

    @FXML // THE book Delete Registere Process
    void btnDeleteOnAction(ActionEvent event) throws Exception {
        try {
            String id = TextID.getText();
            String rep = bcustom.Delete(id);
            if(rep != null){
                new Alert(Alert.AlertType.CONFIRMATION).show();
           }else{
               new Alert(Alert.AlertType.ERROR).show();

           }

           Clear();
            getAllBook();
            
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }
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
       @FXML // click the mouse in Table view
    void ViewOnMouseClicked(MouseEvent event) {

        try {
            BookTM selectbook = tblbookRegister.getSelectionModel().getSelectedItem();

            if(selectbook != null){
                TextID.setText(selectbook.getID());
                TextAuthor.setText(selectbook.getAuthor());
                TextCategorie.setText(selectbook.getCategories());
                TextTitale.setText(selectbook.getTitale());
                TextAddDate.setText(selectbook.getBookAddDate());
                TextQuantity.setText(String.valueOf(selectbook.getQTY()));
                TextPublishDate.setText(selectbook.getPublishDate());

            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }



    }
        // Get the All Book Details
    public void getAllBook() throws Exception{

        try {
          
            ArrayList<bookDto> bookList = bcustom.getAll();

            
            ObservableList<BookTM> bookTMList = FXCollections.observableArrayList();
            for (bookDto dto : bookList) {
                bookTMList.add(new BookTM(
                    dto.getID(),
                    dto.getAuthor(),
                    dto.getCategories(),
                    dto.getTitale(),
                    dto.getPublishDate(),
                    dto.getBookAddDate(),
                    dto.getQTY()
                   
                   
                ));
            }

          
            tblbookRegister.setItems(bookTMList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }




    }

    public void initialize() throws ClassNotFoundException, SQLException {
        try {
            tblBookID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tblAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
            tblCategories.setCellValueFactory(new PropertyValueFactory<>("Categories"));
            tblavilable.setCellValueFactory(new PropertyValueFactory<>("QTY"));
            tblBookAddDate.setCellValueFactory(new PropertyValueFactory<>("BookAddDate"));

            getAllBook();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error initializing data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    @FXML // update processes
    void btnUpdateOnAction(ActionEvent event) {
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

            String resp = bcustom.Update(cdto);
            if(resp != null){
                new Alert(Alert.AlertType.CONFIRMATION).show();
           }else{
               new Alert(Alert.AlertType.ERROR).show();

           }

             Clear();
             getAllBook();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
        }

    }
}
