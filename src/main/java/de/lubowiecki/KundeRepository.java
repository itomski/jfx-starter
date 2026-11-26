package de.lubowiecki;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KundeRepository {

    private final static String FILE = System.getProperty("user.home") + "/kunden.ser";

    private List<Kunde> kunden = new ArrayList<>();

    public KundeRepository() {
        readFromFile();
    }

    public List<Kunde> get() {
        return Collections.unmodifiableList(kunden);
    }

    public void add(Kunde kunde) throws IOException {
        this.kunden.add(kunde);
        saveToFile();
    }

    private void saveToFile() throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(kunden); // Liste von Tasks wird in eine Datei gespeichert
        }
    }

    private void readFromFile() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE))) {
            kunden = (List<Kunde>) in.readObject();
        }
        catch(Exception e) {
            kunden = new ArrayList<>();
        }
    }
}
