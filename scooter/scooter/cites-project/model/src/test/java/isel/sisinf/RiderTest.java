package isel.sisinf;


import isel.sisinf.model.Rider;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class RiderTest {

    @Test
    public void testSetAndGetAllFieldsCorrectly() {
        Rider rider = new Rider();

        int id = 1;
        String email = "rider@example.com";
        int taxnumber = 123456789;
        String name = "Teste";
        LocalDateTime dtregister = LocalDateTime.now();
        int cardid = 42;
        BigDecimal credit = new BigDecimal("25.75");
        String typeofcard = "resident";

        rider.setId(id);
        rider.setEmail(email);
        rider.setTaxnumber(taxnumber);
        rider.setName(name);
        rider.setDtregister(dtregister);
        rider.setCardid(cardid);
        rider.setCredit(credit);
        rider.setTypeofcard(typeofcard);

        assertEquals(id, rider.getId());
        assertEquals(email, rider.getEmail());
        assertEquals(taxnumber, rider.getTaxnumber());
        assertEquals(name, rider.getName());
        assertEquals(dtregister, rider.getDtregister());
        assertEquals(cardid, rider.getCardid());
        assertEquals(credit, rider.getCredit());
        assertEquals(typeofcard, rider.getTypeofcard());
    }

    @Test
    public void testInvalidEmailThrowsException() {
        Rider rider = new Rider();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rider.setEmail("invalid-email.com");
        });
        assertTrue(exception.getMessage().contains("inválido"));
    }

    @Test
    public void testInvalidTaxnumberThrowsException() {
        Rider rider = new Rider();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            rider.setTaxnumber(1234); // menos que 9 dígitos
        });
        assertTrue(ex.getMessage().contains("NIF"));
    }

    @Test
    public void testInvalidTypeofcardThrowsException() {
        Rider rider = new Rider();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            rider.setTypeofcard("invalidType");
        });
        assertTrue(ex.getMessage().contains("inválida"));
    }


}
