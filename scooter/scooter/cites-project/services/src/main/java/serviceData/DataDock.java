package serviceData;

import java.util.Scanner;

public class DataDock {
    private static String inputData(String str, boolean show) {
        Scanner key = new Scanner(System.in);
        if (show) System.out.print("Enter corresponding values, separated by commas of:\n");
        System.out.print(str);
        return key.nextLine();
    }

    public static int[] readDockScooterInput() {
        int dockId = Integer.parseInt(inputData("Dock ID:", false));
        int scooterId = Integer.parseInt(inputData("Scooter ID:", false));
        return new int[] { dockId, scooterId };
    }
}
