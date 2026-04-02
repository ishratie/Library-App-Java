package fi.jyu.ohj2.iliadanilo.kirjasto.project.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
// tests to test different cases

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
    //create a new book with a name, an author and as num
    //check that the book’s name is stored correctly
    //check that the book’s author is stored correctly
    //check that the book’s ISBN is stored correctly

    @Test
    void testLisaaLainaus() {
        Kirja kirja = new Kirja("Nimi", "Tekijä", "1333");
        Lainaus lainaus = new Lainaus("Matti", LocalDate.now(), null, LocalDate.now().plusDays(7), kirja);
        kirja.lisaaLainaus(lainaus);
        assertEquals(1, kirja.getLainauksetNmr());
    }
    //create a new book with no loans
    //create a new loan for that book
    //add the loan to the book
    //check that the book now reports having exactly one loan

    @Test
    void testTilanne() {
        Kirja kirja = new Kirja("Nimi", "Tekijä", "1333");
        assertEquals("Saatavilla", kirja.getTilanne());
        Lainaus lainaus = new Lainaus("Matti", LocalDate.now(), null, LocalDate.now().plusDays(7), kirja);
        kirja.lisaaLainaus(lainaus);
        assertEquals("Lainassa", kirja.getTilanne());
    }
    //create a new book
    //check that the book is initially marked as available
    //create a new loan for the book
    //add the loan to the book
    //check that the book’s status changes to loaned out
}

