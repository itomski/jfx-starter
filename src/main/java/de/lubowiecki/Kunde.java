package de.lubowiecki;

import java.time.LocalDate;

public class Kunde {

    private String vorname;
    private String nachname;
    private LocalDate geburtsDatum;

    public Kunde(String vorname, String nachname, LocalDate geburtsDatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(vorname)
                .append(" ")
                .append(nachname)
                .append(", ")
                .append(geburtsDatum)
                .toString();
    }
}
