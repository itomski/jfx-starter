package de.lubowiecki;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    private final KundeRepository repo = new KundeRepository();

    @FXML // Das Element aus der Oberfläche ist für Java verfügbar
    TextField vorname;

    @FXML
    TextField nachname;

    @FXML
    DatePicker geburtsDatum;

//    @FXML
//    TextArea ausgabe;

    @FXML
    ListView<Kunde> ausgabe;

    @FXML
    private void speichern() throws IOException {
        Kunde kunde = new Kunde(vorname.getText(), nachname.getText(), geburtsDatum.getValue());
        repo.add(kunde);
        updateOutput();
        clearForm();
    }

    private void updateOutput() {
//        StringBuilder kundenSb = new StringBuilder();
//        for(Kunde k : repo.get()) {
//            kundenSb.append(k).append("\n");
//        }
//        ausgabe.setText(kundenSb.toString());

        // ObservableList - Eine Liste, in der eine Auswahl erfasst wird
        var daten = FXCollections.observableList(repo.get());
        ausgabe.setItems(daten);
    }

    private void clearForm() {
        vorname.clear();
        nachname.clear();
        geburtsDatum.getEditor().clear();
    }

    // Wird beim Start automatisch aufgerufen
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateOutput(); // Aktuallisiert die Anzeige
    }
}
