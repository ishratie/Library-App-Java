package fi.jyu.ohj2.iliadanilo.kirjasto.project.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fi.jyu.ohj2.iliadanilo.kirjasto.project.model.Kirja;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TallennusService {
    private static Path file = Path.of("kirjasto.json");
    private ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    public void tallenna(List<Kirja> kirjat){
        try {
            mapper.writeValue(file.toFile(), kirjat);
            System.out.println("Tallennettu");
        } catch (Exception w) {
            System.out.print("save error" + w.getMessage());
        }
    }
    public List<Kirja> loading() {
        try {
            //mapper to convert the names of books into the ArrayList
            Kirja[] kirjat = mapper.readValue(file.toFile(), Kirja[].class);
            return new ArrayList<>(Arrays.asList(kirjat));
        } catch (Exception w) {
            System.out.print("Loading error" + w.getMessage());
            return new ArrayList<>();
        }
    }

}
