module com.bytetalking.employe_management_systme {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.bytetalking.employe_management_systme to javafx.fxml;
    exports com.bytetalking.employe_management_systme;
}