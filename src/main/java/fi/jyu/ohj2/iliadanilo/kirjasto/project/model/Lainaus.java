package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
public class Lainaus {
    @JsonIgnore
    private Kirja kirja;
    public Lainaus() {}// creating empty constructor
    private String lainaajanimi;
    private LocalDate lainattuPvm;
    private LocalDate palautusPvm;
    private LocalDate palautettuPvm;
    // the strings are created

    public Lainaus(String lainaajanimi, LocalDate lainattuPvm, LocalDate palautettuPvm, LocalDate palautusPvm, Kirja kirja) {
        this.lainaajanimi = lainaajanimi;
        this.lainattuPvm = lainattuPvm;
        this.palautettuPvm = palautettuPvm;
        this.palautusPvm = palautusPvm;
        this.kirja = kirja;
        // putting the names n values inside the constructor
    }
    public String getLainaajanimi(){
        return lainaajanimi;
    } // gets name who borrows the book
    public LocalDate getLainattuPvm(){
        return lainattuPvm;
    }// gets date when is borrowed
    public LocalDate getPalautusPvm(){
        return palautusPvm;
    }// gets date when is returned
    public LocalDate getPalautettuPvm(){
        return palautettuPvm;
    }// gets date when is returned
    public Kirja getKirja() {
        return kirja;
    } // get the book


    public void setPalautettuPvm(LocalDate palautettuPvm) {
        this.palautettuPvm = palautettuPvm;
    } // set the date.
    public void setKirja(Kirja kirja) {
        this.kirja = kirja;
    } // set the book
}


