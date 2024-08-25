package Contoller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import DM.BookTM;
import DM.MemberTm;
import Dto.bookDto;
import Dto.memberDto;
import Service.subFacutory;
import Service.Custom.bookCustom;
import Service.Custom.homeCustomService;
import Service.Custom.membercustom;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class homeController {

    @FXML
    private Label LblMemberCount;

    @FXML
    private Label LblOverdueBook;

    @FXML
    private Label Lblbarrowedbook;

    @FXML
    private Label dayOnManth;

    @FXML
    private Label lblDay;

    @FXML
    private Label lblMoneth;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblyear;

       
    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<MemberTm, String> tblMemberID;

    @FXML
    private TableColumn<MemberTm, String> tblMemberNIC;

    @FXML
    private TableView<MemberTm> tblMemberView;

    @FXML
    private TableColumn<MemberTm, String> tblRegDate;

    @FXML
    private TableColumn<MemberTm, Integer> tblTeleNo;


    
    @FXML
    private TableColumn<BookTM, String> tblBookAuthor;

    @FXML
    private TableColumn<BookTM, String> tblBookId;

    @FXML
    private TableColumn<BookTM, Integer> tblBookQTY;

    @FXML
    private TableColumn<BookTM, String> tblBookTitale;

    @FXML
    private TableView<BookTM> tblBoolView;





    public void initialize() throws Exception{

                tblMemberID.setCellValueFactory(new PropertyValueFactory<>("M_ID"));
                tblMemberNIC.setCellValueFactory(new PropertyValueFactory<>("Nic"));
                tblTeleNo.setCellValueFactory(new PropertyValueFactory<>("Contac_No"));
                tblRegDate.setCellValueFactory(new PropertyValueFactory<>("MembershipDate"));



                tblBookId.setCellValueFactory(new PropertyValueFactory<>("ID"));
                tblBookAuthor.setCellValueFactory(new PropertyValueFactory<>("Author"));
                tblBookTitale.setCellValueFactory(new PropertyValueFactory<>("Titale"));
                tblBookQTY.setCellValueFactory(new PropertyValueFactory<>("QTY"));
               

               

        CountBook();
        UpdateTime();
        borrowbook();
        OverdueBook();

        getAllMember();
        getAllBook();
    }    

        private homeCustomService  homeService =  (homeCustomService) subFacutory.getInstance().getservice(subFacutory.serviceType.HOME);
         private membercustom  Mecustom = (membercustom) subFacutory.getInstance().getservice(subFacutory.serviceType.MEMBER);
             private bookCustom  bcustom = (bookCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.BOOK);



    public void UpdateTime(){

        LocalDateTime currentDateTime = LocalDateTime.now();

        int year=currentDateTime.getYear();
        String month = currentDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String day = currentDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        
        int Hour = currentDateTime.getHour();
        int Minitues =currentDateTime.getMinute();
        int daymonth=currentDateTime.getDayOfMonth();
        String time = String.format("%02d:%02d", Hour, Minitues);


        lblDay.setText(day+",");
        lblMoneth.setText(month);
        lblyear.setText(String.valueOf(" "+year));
        lblTime.setText(String.valueOf(time));
        dayOnManth.setText(String.valueOf("   "+daymonth+","));
        

    }


    public void CountBook(){
        try {
                int totalbook =homeService.getTotalBooks();
                LblMemberCount.setText(""+totalbook);
                

        } catch (Exception e) {
            LblMemberCount.setText("000");
            
        }

    }


    public void OverdueBook(){
        try {
                int overbook =homeService.getOverdueBook();
                LblOverdueBook.setText(""+overbook);
                
        } catch (Exception e) {
            LblMemberCount.setText("000");
           
        }
    }

    public void borrowbook(){
        try {
                int barrowlbook =homeService.getbarrowedbook();
                Lblbarrowedbook.setText(""+barrowlbook);
        } catch (Exception e) {
            LblMemberCount.setText("000");
            
        }

    }



    @FXML
    void btnAddBook(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRegister.fxml"));
        this.root.getChildren().add(nood);

    }

    @FXML
    void btnAddMember(ActionEvent event) throws IOException {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);

    }
   

   

        
 

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

    @FXML
    void bookReleaseOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookRelease.fxml"));
        this.root.getChildren().add(nood);
    }

    @FXML
    void returnOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/bookReturn.fxml"));
        this.root.getChildren().add(nood);
    }

      public void getAllMember() throws Exception{
        try {
            ArrayList<memberDto> memberList = Mecustom.getAll(); 
            ObservableList<MemberTm> MemberTMList = FXCollections.observableArrayList();
            for (memberDto dto : memberList) {
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
          
            tblMemberView.setItems(MemberTMList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();
        }
    }


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

          
            tblBoolView.setItems(bookTMList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,(e.getMessage())).show();

        }
    }
    
}
