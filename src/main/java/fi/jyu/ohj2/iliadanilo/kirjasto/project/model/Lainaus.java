package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
public class Lainaus {
    @JsonIgnore
    private Kirja kirja;
    public Lainaus() {}
    private String lainaajanimi;
    private LocalDate lainattuPvm;
    private LocalDate palautusPvm;
    private LocalDate palautettuPvm;

    public Lainaus(String lainaajanimi, LocalDate lainattuPvm, LocalDate palautettuPvm, LocalDate palautusPvm, Kirja kirja) {
        this.lainaajanimi = lainaajanimi;
        this.lainattuPvm = lainattuPvm;
        this.palautettuPvm = palautettuPvm;
        this.palautusPvm = palautusPvm;
        this.kirja = kirja;
    }
    public String getLainaajanimi(){
        return lainaajanimi;
    }
    public LocalDate getLainattuPvm(){
        return lainattuPvm;
    }
    public LocalDate getPalautusPvm(){
        return palautusPvm;
    }
    public LocalDate getPalautettuPvm(){
        return palautettuPvm;
    }
    public Kirja getKirja() {
        return kirja;
    }


    public void setPalautettuPvm(LocalDate palautettuPvm) {
        this.palautettuPvm = palautettuPvm;
    }
    public void setKirja(Kirja kirja) {
        this.kirja = kirja;
    }
}


