package isel.sisinf.jpa.ServicesData;

import java.util.Scanner;

public class DataDock {

    private static String inputData(String prompt, boolean show) {
        Scanner key = new Scanner(System.in);
        if (show) System.out.print("Enter corresponding values:\n");
        System.out.print(prompt);
        return key.nextLine();
    }

    public static int[] readDockScooterInput() {
        int dockId = Integer.parseInt(inputData("Dock ID", false));
        int scooterId = Integer.parseInt(inputData("Scooter ID", false));
        return new int[] { dockId, scooterId };
    }
}
