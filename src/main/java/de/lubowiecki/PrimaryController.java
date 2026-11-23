package de.lubowiecki;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    private List<Kunde> kunden = new ArrayList<>();

    @FXML // Das Element aus der Oberfläche ist für Java verfügbar
    TextField vorname;

    @FXML
    TextField nachname;

    @FXML
    DatePicker geburtsDatum;

    @FXML
    TextArea ausgabe;

    @FXML
    private void speichern() throws IOException {
        Kunde kunde = new Kunde(vorname.getText(), nachname.getText(), geburtsDatum.getValue());
        kunden.add(kunde);

        updateOutput();
        clearForm();
    }

    private void updateOutput() {
        StringBuilder kundenSb = new StringBuilder();
        for(Kunde k : kunden) {
            kundenSb.append(k).append("\n");
        }
        ausgabe.setText(kundenSb.toString());
    }

    private void clearForm() {
        vorname.clear();
        nachname.clear();
        geburtsDatum.getEditor().clear();
    }
}
