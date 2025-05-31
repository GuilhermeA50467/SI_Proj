package isel.sisinf;

import isel.sisinf.model.Station;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class StationTest {
    @Test
    public void testSetAndGetAllFields() {
        Station station = new Station();

        int id = 10;
        BigDecimal latitude = new BigDecimal("41.1234");
        BigDecimal longitude = new BigDecimal("-8.4567");

        station.setId(id);
        station.setLatitude(latitude);
        station.setLongitude(longitude);

        assertEquals(id, station.getId());
        assertEquals(latitude, station.getLatitude());
        assertEquals(longitude, station.getLongitude());
    }
}
