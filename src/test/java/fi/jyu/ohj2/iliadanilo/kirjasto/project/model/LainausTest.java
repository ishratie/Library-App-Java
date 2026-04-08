package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LainausTest {

    private Kirja luodaKirja() {
        return new Kirja("Testaus", "Kirjoittaja", "0000");
    }



    @Test
    void testEmptyConstructor() {
        Lainaus l = new Lainaus();
        assertNull(l.getLainaajanimi());
        assertNull(l.getLainattuPvm());
        assertNull(l.getPalautusPvm());
        assertNull(l.getPalautettuPvm());
        assertNull(l.getKirja());
    }

    @Test
    void testFullConstructor() {
        Kirja kirja = luodaKirja();
        LocalDate borrowed = LocalDate.of(2024, 1, 1);
        LocalDate due = LocalDate.of(2024, 1, 15);
        Lainaus l = new Lainaus("createa", borrowed, null, due, kirja);

        assertEquals("createa", l.getLainaajanimi());
        assertEquals(borrowed, l.getLainattuPvm());
        assertEquals(due, l.getPalautusPvm());
        assertNull(l.getPalautettuPvm());
        assertEquals(kirja, l.getKirja());
    }


    @Test
    void testSetPalautettuPvm() {
        Kirja kirja = luodaKirja();
        Lainaus l = new Lainaus("Perttu", LocalDate.now(), null, LocalDate.now().plusDays(7), kirja);
        assertNull(l.getPalautettuPvm());
        LocalDate today = LocalDate.now();
        l.setPalautettuPvm(today);
        assertEquals(today, l.getPalautettuPvm());
    }

    @Test
    void testisPalautettuPvm() {
        Kirja kirja = luodaKirja();
        Lainaus l = new Lainaus("Mmimimimi", LocalDate.now().minusDays(5),
                null, LocalDate.now().plusDays(2), kirja);
        l.setPalautettuPvm(LocalDate.now());
        assertNotNull(l.getPalautettuPvm());
    }
}