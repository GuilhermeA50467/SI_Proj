package serviceData;

import java.util.Scanner;

public class DataTravel {
    public static int[] readTripInput() {
        int dockid = Integer.parseInt(inputData("ID da doca de partida: ", false));
        int clientid = Integer.parseInt(inputData("ID do cliente: ", false));
        return new int[]{dockid, clientid};
    }

    private static String inputData(String prompt, boolean show) {
        Scanner scanner = new Scanner(System.in);
        if (show) System.out.println("Enter corresponding values, separated by commas of:");
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
