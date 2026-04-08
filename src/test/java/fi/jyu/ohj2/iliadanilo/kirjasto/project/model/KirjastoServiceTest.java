
package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Lainaus;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.service.KirjastoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class KirjastoServiceTest {

    private KirjastoService service;

    @BeforeEach
    void setUp() {
        service = new KirjastoService();
        // clear any books loaded from disk so tests are deterministic
        service.getKirjat().clear();
    }



    @Test
    void testLisaaKirjaIncreasesSize() {
        assertEquals(0, service.getKirjat().size());
        service.lisaaKirja(new Kirja("A", "B", "1"));
        assertEquals(1, service.getKirjat().size());
    }
    //test for checks the creating volume of books count

    @Test
    void testLisaaMultipleKirjat() {
        service.lisaaKirja(new Kirja("A", "B", "1"));
        service.lisaaKirja(new Kirja("C", "D", "2"));
        service.lisaaKirja(new Kirja("E", "F", "3"));
        assertEquals(3, service.getKirjat().size());
    }
    // test check the different kind of book can be created and stored

    @Test
    void testLisaaKirjaPreservesData() {
        Kirja kirja = new Kirja("label", "tekija", "isbn1337");
        service.lisaaKirja(kirja);
        Kirja stored = service.getKirjat().get(0);
        assertEquals("label", stored.getNimi());
        assertEquals("tekija", stored.getTekija());
        assertEquals("isbn1337", stored.getIsbn());
    }
    // test check the different kind of book can be created and stored and gets name,author and number


    @Test
    void testPoistaKirja() {
        Kirja kirja = new Kirja("A", "B", "1");
        service.lisaaKirja(kirja);
        assertEquals(1, service.getKirjat().size());
        service.poistaKirja(kirja);
        assertEquals(0, service.getKirjat().size());
    }
    //poistuminen kirjan testi
}