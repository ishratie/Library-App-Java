package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;
import javax.security.auth.callback.LanguageCallback;
import java.time.LocalDate;
public class Lainaus {
    public Lainaus() {}
    private String lainaajanimi;
    private LocalDate lainattuPvm;
    private LocalDate palautusPvm;
    private LocalDate palautettuPvm;
    private Kirja kirja;
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
    public LocalDate lainattuPvm(){
        return lainattuPvm;
    }
    public LocalDate palautusPvm(){
        return palautusPvm;
    }
    public LocalDate palautettuPvm(){
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


