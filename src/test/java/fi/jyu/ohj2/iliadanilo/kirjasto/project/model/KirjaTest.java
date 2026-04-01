package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class KirjaTest{
    @Test
    void test() {
        Kirja kirja = new Kirja(
                "Nimi",
                "Tekijä",
                "1333"
                );
        assertEquals("Nimi", kirja.getNimi());
        assertEquals("Tekijä", kirja.getTekija());
        assertEquals("1333", kirja.getIsbn());
    }

    @Test
    void testLisaaLainaus() {
        Kirja kirja = new Kirja("Nimi", "Tekijä", "1333");
        Lainaus lainaus = new Lainaus("Matti", LocalDate.now(), null, LocalDate.now().plusDays(7), kirja);
        kirja.lisaaLainaus(lainaus);
        assertEquals(1, kirja.getLainauksetNmr());
    }

    @Test
    void testTilanne() {
        Kirja kirja = new Kirja("Nimi", "Tekijä", "1333");
        assertEquals("Saatavilla", kirja.getTilanne());
        Lainaus lainaus = new Lainaus("Matti", LocalDate.now(), null, LocalDate.now().plusDays(7), kirja);
        kirja.lisaaLainaus(lainaus);
        assertEquals("Lainassa", kirja.getTilanne());
    }
}

