package fi.jyu.ohj2.iliadanilo.kirjasto.project.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TallennusService {
    private static Path file = Path.of("kirjasto.json"); // the path to this file to store books
    private ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule()) // let jackson write n edit localdate and other java time classes
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)// save data as normal, not in the computer way like 12312432424, but 01.01.1999
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // to let not crash the json if smth missing
    public void tallenna(List<Kirja> kirjat){ // saving feature as a list
        try {
            mapper.writeValue(file.toFile(), kirjat); // convert from list to json file
            System.out.println("Tallennettu");// prints saves
        } catch (Exception w) { // exception if this thing is not working
            System.out.print("save error" + w.getMessage());
        }
    }
    public List<Kirja> loading() { // reads json file
        try {
            //mapper to convert the names of books into the ArrayList
            Kirja[] kirjat = mapper.readValue(file.toFile(), Kirja[].class); // kirjat is list, reads there data
            return new ArrayList<>(Arrays.asList(kirjat)); // wraps in into the list again
        } catch (Exception w) { // exception if thing is not working
            System.out.print("Loading error" + w.getMessage());
            return new ArrayList<>(); // returning arraylist
        }
    }

}
