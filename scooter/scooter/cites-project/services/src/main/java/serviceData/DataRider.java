package serviceData;

import isel.sisinf.model.Rider;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DataRider {
    private static String inputData(String str, boolean show) {
        Scanner key = new Scanner(System.in);
        if (show) System.out.print("Enter corresponding values, separated by commas of:\n");
        System.out.print(str);
        return key.nextLine();
    }

    public static Rider createRiderFromInput() {
        Rider newRider = new Rider();
        String name = inputData("Nome: ", false);
        String email = inputData("Email: ", false);
        newRider.setEmail(email);
        int taxnumber = Integer.parseInt(inputData("Número de contribuinte (tax number): ", false));
        newRider.setTaxnumber(taxnumber);
        double credit = Double.parseDouble(inputData("Crédito inicial: ", false));
        newRider.setCredit(BigDecimal.valueOf(credit));
        String typeofcard = inputData("Tipo de cartão (resident / tourist): ", false);
        newRider.setTypeofcard(typeofcard);
        newRider.setName(name);
        newRider.setDtregister(LocalDateTime.now());
        return newRider;
    }
}
