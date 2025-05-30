package isel.sisinf.jpa.ServicesData;

import isel.sisinf.model.Rider;

import java.time.LocalDateTime;
import java.util.Scanner;

public class DataRider {
    private static String inputData(String str, boolean show) {
        Scanner key = new Scanner(System.in);
        if (show) System.out.print("Enter corresponding values, separated by commas of:\n");
        System.out.print(str);
        System.out.print(">");
        return key.nextLine();
    }

    public static Rider createRiderFromInput() {
        String name = inputData("Nome: ", true);
        String email = inputData("Email: ", false);
        int taxnumber = Integer.parseInt(inputData("Número de contribuinte (tax number): ", false));
        double credit = Double.parseDouble(inputData("Crédito inicial: ", false));
        String typeofcard = inputData("Tipo de cartão (resident / tourist): ", false);

        Rider newRider = new Rider();
        newRider.setName(name);
        newRider.setEmail(email);
        newRider.setTaxnumber(taxnumber);
        newRider.setCredit(credit);
        newRider.setTypeofcard(typeofcard);
        newRider.setDtregister(LocalDateTime.now());

        return newRider;
    }
}
