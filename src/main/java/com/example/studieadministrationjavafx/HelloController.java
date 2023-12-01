package com.example.studieadministrationjavafx;

import Studieadministration.DbSql;
import Studieadministration.Studerende;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label studerendeOprettet;

    @FXML
    private Label studerendeSlettet;

    @FXML
    private TextField stdnr;
    @FXML
    private TextField fnavn;

    @FXML private TextField enavn;

    @FXML private TextField Adresse;

    @FXML private TextField postnr;
    @FXML
    private TextField telefon;
    @FXML
    private TextField klasse;

    @FXML
    protected void onOpretStuderendeClick() {
        welcomeText.setText("Studerende er oprettet");
    }

    @FXML
    protected void onOpretStuderendeClickIStudieAdmin() {
        Studerende s = new Studerende();
        DbSql db = new DbSql();
        String stdnrText = stdnr.getText();
        String fnavnText = fnavn.getText();
        String enavnText = enavn.getText();
        String adresseText = Adresse.getText();
        String postnrText = postnr.getText();
        String telefonText = telefon.getText();
        String klasseText = klasse.getText();
        char klasse = klasseText.charAt(0);
        int snr = Integer.parseInt(stdnrText);
        s.setStdnr(snr);
        s.setFnavn(fnavnText);
        s.setEnavn(enavnText);
        s.setAdresse(adresseText);
        s.setPostnr(postnrText);
        s.setMobil(telefonText);
        s.setKlasse(klasse);
        db.opretStuderende(s);
        studerendeOprettet.setText("Studerende er oprettet");
    }
    @FXML
    protected void onSletStuderendeClick() {
        DbSql db = new DbSql();
        String stdnrText = stdnr.getText();
        int snr = Integer.parseInt(stdnrText);
        db.sletStuderende(snr);
        studerendeSlettet.setText("Studerende er slettet");
    }

    @FXML
    protected void soegOplysningerOmEnStuderende() {
        Studerende s;
        DbSql db = new DbSql();
        String stdnrText = stdnr.getText();
        int snr = Integer.parseInt(stdnrText);
        s = db.soegOplysOmStuderende(snr);
        fnavn.setText(s.getFnavn());
        enavn.setText(s.getEnavn());
        Adresse.setText(s.getAdresse());
        postnr.setText(s.getPostnr());
        telefon.setText(s.getMobil());
        String k = String.valueOf(s.getKlasse());
        klasse.setText(k);
    }
}