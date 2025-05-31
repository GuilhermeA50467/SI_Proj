package isel.sisinf;
import isel.sisinf.model.Client;
import isel.sisinf.model.Scooter;
import isel.sisinf.model.Station;
import isel.sisinf.model.Travel;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class TravelTest {
    @Test
    public void testConstructorAndGetters() {
        LocalDateTime start = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime end = LocalDateTime.of(2023, 1, 1, 12, 0);
        Client client = new Client();  // assumindo construtor padrão
        Scooter scooter = new Scooter();
        scooter.setId(100);
        Station startStation = new Station();
        Station endStation = new Station();

        Travel travel = new Travel(start, null, null, end, client, scooter, startStation, endStation);

        assertEquals(start, travel.getDinitial());
        assertEquals(null, travel.getComment());
        assertEquals(null, travel.getEvaluation());
        assertEquals(end, travel.getDfinal());
        assertEquals(client, travel.getClient());
        assertEquals(scooter, travel.getScooter());
        assertEquals(startStation, travel.getStinitial());
        assertEquals(endStation, travel.getStfinal());
    }

}
