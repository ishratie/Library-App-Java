package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import org.junit.jupiter.api.Test;

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
}
