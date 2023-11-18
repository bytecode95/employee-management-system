module com.bytetalking.employe_management_systme {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bytetalking.employe_management_systme to javafx.fxml;
    exports com.bytetalking.employe_management_systme;
}