module mns.java.PenduJAVA {
    requires javafx.controls;
    requires javafx.fxml;

    opens mns.java.PenduJAVA to javafx.fxml;
    exports mns.java.PenduJAVA;
}
