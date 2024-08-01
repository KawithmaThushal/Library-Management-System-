package Contoller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Dto.bookDto;
import Dto.bookReleaseDto;
import Dto.memberDto;
import Service.subFacutory;
import Service.Custom.bookCustom;
import Service.Custom.membercustom;
import Service.Custom.releasebook;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class bookRelease {

     @FXML
    private Label LabelbookDetails;

    @FXML
    private TableView<?> ReleaseTableView;

    @FXML
    private TextField TxtBookId;

    @FXML
    private TextField TxtMemberId;

    @FXML
    private Label lblMemberDetails;

    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> tblAvilable;

    @FXML
    private TableColumn<?, ?> tblB_ID;

    @FXML
    private TableColumn<?, ?> tblExpireDate;

    @FXML
    private TableColumn<?, ?> tblMID;

    @FXML
    private TableColumn<?, ?> tblReleaseDate;

    @FXML
    void bookReleaseOnAction(ActionEvent event) throws IOException {
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
    void memberRegisterOnAction(ActionEvent event) throws Exception {
        this.root.getChildren().clear();
        Parent nood =  FXMLLoader.load(this.getClass().getResource("/view/memberRegister.fxml"));
        this.root.getChildren().add(nood);

    }

     private membercustom  Mecustom = (membercustom) subFacutory.getInstance().getservice(subFacutory.serviceType.MEMBER);
    @FXML
    void checkOnAction(ActionEvent event) throws Exception {
     try {
        String mtext = TxtMemberId.getText();
        memberDto dto = Mecustom.getAllDto(mtext);
        if(dto != null){
            lblMemberDetails.setText(dto.getNic()+" "+dto.getName() + " "+dto.getMembershipDate());
        }
        else{
            lblMemberDetails.setText("Member id not found");
        }
        
        
    } catch (Exception e) {
         e.printStackTrace();
            e.initCause(e);
        JOptionPane.showMessageDialog(null, this, "Error at Search member ID", 0);
    }


    }
    private bookCustom  bcustom = (bookCustom) subFacutory.getInstance().getservice(subFacutory.serviceType.BOOK);

    @FXML
    void checkbookOnAction(ActionEvent event) {

        try {
            String btext = TxtBookId.getText();
            bookDto dto = bcustom.getAllDto(btext);
            if(dto != null){
                LabelbookDetails.setText(dto.getTitale()+ " "+dto.getAuthor() + " "+dto.getQTY());
            }
            else{
                LabelbookDetails.setText("Book id not found");
            }
            
            
        } catch (Exception e) {
             e.printStackTrace();
                e.initCause(e);
            JOptionPane.showMessageDialog(null, this, "Error at Search Custom ID", 0);
        }

    }

    private releasebook  releasebook = (releasebook) subFacutory.getInstance().getservice(subFacutory.serviceType.RELEASE);

    private ArrayList<bookDto> bookDtos = new ArrayList<>();
    @FXML
    void releaseOnAction(ActionEvent event) throws Exception {

try {
    LocalDate currentDate = LocalDate.now();
    LocalDate dateAfterTwoWeeks = currentDate.plusDays(14);
 

      bookReleaseDto bDto= new bookReleaseDto();
      bDto.setBook_ID(TxtBookId.getText());
      bDto.setM_ID(TxtMemberId.getText());
      bDto.setRelease_Date(currentDate.toString());
      bDto.setExpire_Date(dateAfterTwoWeeks.toString());
      bDto.setDtos(bookDtos);

      String reps = releasebook.release(bDto);
      JOptionPane.showMessageDialog(null, this, reps, 0);

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, this, e.getMessage(), 0);

       

    }
    }
}
