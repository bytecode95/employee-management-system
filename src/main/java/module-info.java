module com.bytetalking.employe_management_systme {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.bytetalking.employe_management_systme.controllers;
    opens com.bytetalking.employe_management_systme.controllers to javafx.fxml;
}