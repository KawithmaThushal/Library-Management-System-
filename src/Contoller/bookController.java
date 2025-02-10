package Contoller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DM.BookTM;
import Dto.CategoryDto;
import Dto.bookDto;
import Service.subFacutory;
import Service.Custom.CategoryService;
import Service.Custom.bookCustom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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

    // @FXML
    // private TextField TextCategorie;

    @FXML
    private TextField TextID;

    

    @FXML
    private TextField TextQuantity;

    @FXML
    private TextField TextTitale;


    @FXML
    private AnchorPane root;


       @FXML
    private DatePicker TextPublishDate;

    @FXML
    private DatePicker adddate;
  
    @FXML
    private ComboBox<String> categoriesId;
    
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
       
           try {
            this.root.getChildren().clear();
            Parent nood = FXMLLoader.load(getClass().getResource("/view/bookRegister.fxml"));
            this.root.getChildren().add(nood);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML file: " + e.getMessage());
        }
    }

    @FXML // Move the Home  Form
    void btnHomeOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/homeView.fxml"));
        this.root.getChildren().add(nood);
    }
    private bookCustom  bcustom = (bookCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.BOOK);
    private CategoryService  categoryService = (CategoryService) subFacutory.getInstance().getservice(subFacutory.serviceType.CATEGORY);

    @FXML // THE BOOK REGISTERE PROSESS
    void btnSaveOnAction(ActionEvent event) {
      

        try {
            String selectedCategoryName = categoriesId.getValue(); // Get selected category name
            if (selectedCategoryName == null) {
                new Alert(Alert.AlertType.WARNING, "Please select a category!").show();
                return;
            }


            List<CategoryDto> categories = categoryService.getAllCategories();
            int selectedCategoryId = categories.stream()
                    .filter(c -> c.getCategoryName().equals(selectedCategoryName))
                    .findFirst()
                    .map(CategoryDto::getCategoryId)
                    .orElse(-1);
    
            if (selectedCategoryId == -1) {
                new Alert(Alert.AlertType.ERROR, "Invalid category selection!").show();
                return;
            }

            bookDto cdto = new bookDto(
                TextID.getText(),
                TextAuthor.getText(),
                selectedCategoryId,
                TextTitale.getText(),
                TextPublishDate.getValue().toString(),
                adddate.getValue().toString(),
                Integer.parseInt(TextQuantity.getText())
            );

            String resp = bcustom.save(cdto);

            if(resp != null){
                new Alert(Alert.AlertType.CONFIRMATION, "Book saved successfully!").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Error saving book!").show();

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
        categoriesId.setValue("");
        TextTitale.setText("");
        TextPublishDate.setValue(null);
        adddate.setValue(null);
        TextQuantity.setText("");
    }
       @FXML // click the mouse in Table view
    void ViewOnMouseClicked(MouseEvent event) {

        try {
            BookTM selectbook = tblbookRegister.getSelectionModel().getSelectedItem();

            if(selectbook != null){
                TextID.setText(selectbook.getID());
                TextAuthor.setText(selectbook.getAuthor());
               // TextCategorie.setText(selectbook.getCategoryID());
                TextTitale.setText(selectbook.getTitale());
                adddate.setValue(java.time.LocalDate.parse(selectbook.getBookAddDate()));
                TextQuantity.setText(String.valueOf(selectbook.getQty()));
                TextPublishDate.setValue(java.time.LocalDate.parse(selectbook.getPublishDate()));


                categoriesId.setValue(selectbook.getCategoryName());
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
                    getCategoryNameById(dto.getCategoryID()),
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

    // // Helper: Get Category ID from Name
    // private int getCategoryIdByName(String name) {
    //     return categoryService.getAllCategories().stream()
    //             .filter(c -> c.getCategoryName().equals(name))
    //             .map(CategoryDto::getCategoryId)
    //             .findFirst()
    //             .orElse(-1);
    // }

    // Helper: Get Category Name from ID
    private String getCategoryNameById(int id) {
        return categoryService.getAllCategories().stream()
                .filter(c -> c.getCategoryId() == id)
                .map(CategoryDto::getCategoryName)
                .findFirst()
                .orElse("Unknown");
    }
    @FXML
    public void initialize() throws ClassNotFoundException, SQLException {
        try {
            tblBookID.setCellValueFactory(new PropertyValueFactory<>("ID"));
            tblAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
            tblCategories.setCellValueFactory(new PropertyValueFactory<>("CategoryName"));
            tblavilable.setCellValueFactory(new PropertyValueFactory<>("Qty"));
            tblBookAddDate.setCellValueFactory(new PropertyValueFactory<>("BookAddDate"));

            getAllBook();
            loadCategories();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error initializing data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unexpected error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

     private void loadCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
    
    ObservableList<String> categoryNames = FXCollections.observableArrayList();
    for (CategoryDto category : categories) {
        categoryNames.add(category.getCategoryName());
    }
    
        categoriesId.setItems(categoryNames);
    }

    @FXML // update processes
    void btnUpdateOnAction(ActionEvent event) {
        try {

            String selectedCategoryName = categoriesId.getValue();
            if (selectedCategoryName == null) {
                new Alert(Alert.AlertType.WARNING, "Please select a category!").show();
                return;
            } 

            List<CategoryDto> categories = categoryService.getAllCategories();
            int selectedCategoryId = categories.stream()
                    .filter(c -> c.getCategoryName().equals(selectedCategoryName))
                    .findFirst()
                    .map(CategoryDto::getCategoryId)
                    .orElse(-1);
    
            if (selectedCategoryId == -1) {
                new Alert(Alert.AlertType.ERROR, "Invalid category selection!").show();
                return;
            }



            bookDto cdto = new bookDto(
                TextID.getText(),
                TextAuthor.getText(),
                selectedCategoryId,
                TextTitale.getText(),
                TextPublishDate.getValue().toString(),
                adddate.getValue().toString(),
                Integer.parseInt(TextQuantity.getText())
            );

            String resp = bcustom.Update(cdto);
            if(resp != null){
                new Alert(Alert.AlertType.CONFIRMATION, "Book updated successfully!").show();
           }else{
               new Alert(Alert.AlertType.ERROR).show();

           }

             Clear();
             getAllBook();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
        }

    }

    
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
    void btnReportOnAction(ActionEvent event) throws Exception{
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/subReport/Report.fxml"));
        this.root.getChildren().add(nood);
    }
}
